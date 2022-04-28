package com.petcelsius.api.controller;


import com.aliyun.oss.OSS;
import com.petcelsius.api.domain.User;
import com.petcelsius.api.service.UserService;
import com.petcelsius.api.utils.*;
import com.petcelsius.api.vo.Logvo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("userApi")
public class UserApiController {

    @Autowired
    private RedisTemplate<String , String> redisTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private OSS ossClient;

    @Value("${oss.base.url}")
    private String ossBaseUrl;

    @Value("${oss.bucketName}")
    private String bucketName;

    // 检测登录状态, 这个方法用不了，没服务器环境带不了cookie
//    @GetMapping("checkSession")
//    public R checkSession(HttpServletRequest request){
//        HttpSession session = request.getSession();
//        Object user = session.getAttribute("user");
//        System.out.println(user);
//        if(user == null){
//            return R.error().put("user", user);
//        }
//        return R.ok().put("user", user);
//    }


    /**
     * 获取验证码，根据手机号码来保存
     * @param mobile
     * @return
     */
    // 获取验证码
    @GetMapping("getSmsCode/{mobile}")
    public R generateSmsCode(@PathVariable("mobile") String mobile){
        String smsCode = GenerateSmsCode.generateSmsCode();
        System.out.println(mobile);
        // 发送验证码
        Result result = SMSUtils.sendShortMessage(mobile, smsCode);

        if (result.isFlag()){
            String smsCodeKey = "sms" + mobile;
            try{
                ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
                opsForValue.set(smsCodeKey, smsCode, 60*5, TimeUnit.SECONDS);
            }catch (Exception e){
                e.printStackTrace();
                return R.error("redis链接失败");
            }
            return R.ok("发送成功");
        }
        return R.error("发送失败");
    }


    /**
     * 不用session
     * @param logvo
     * @return
     */
    // 登录
    @PostMapping("loginUser")
    public R loginUser(@Valid @RequestBody Logvo logvo){


        String mobile = logvo.getMobile();
        String smsCode = logvo.getSmsCode().trim();

        String smsCodeKey = "sms" + mobile;
        try{
            String realSmsCode = redisTemplate.opsForValue().get(smsCodeKey);
            if (smsCode.equals(realSmsCode)){
                // 如果有用户就查出来返回
                User user = userService.findByMobile(mobile);
                if (user != null){
//                    session.setAttribute("user", user);
//                    session.setMaxInactiveInterval(60*60*5);
//                    String id = session.getId();
                    return R.ok().put("user", user);
                }
                // 如果没有用户就保存之后返回
                User newUser = new User();
                BeanUtils.copyProperties(logvo, newUser);
                newUser.setUsername(mobile);
                userService.save(newUser);
                User byId = userService.getById(newUser.getId());
//                session.setAttribute("user", byId);
//                session.setMaxInactiveInterval(60*60*5);
//                String id = session.getId();
                return R.ok().put("user", byId);
            }
        }catch (Exception e){

            e.printStackTrace();

        }
        return R.error();
    }


    /**
     * 用户头像上传到oss，并返回对应的头像url
     * @param topic
     * @return
     * @throws IOException
     */
    // 上传头像
    @PostMapping("topicUpload")
    public String topicUpload(@RequestBody MultipartFile topic) throws IOException {
        String originalFilename = topic.getOriginalFilename();
        InputStream inputStream = topic.getInputStream();
//        System.out.println(originalFilename);


        try{
            R topicResult = OssUploadUtils.uploadByFile("topic", originalFilename, inputStream, ossBaseUrl, ossClient, bucketName);
            return (String) topicResult.get("data");
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }

    }


    /**
     * 修改用户的信息，包括头像
     * @param alterUser
     * @return
     */
    // 修改用户信息
    @PostMapping("alterUserInfo")
    public R alterUserInfo(@RequestBody User alterUser){

//        System.out.println(alterUser);
        try {
            userService.updateByIdself(alterUser);

            User user = userService.getById(alterUser.getId());

            return R.ok().put("user", user);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

    }




}
