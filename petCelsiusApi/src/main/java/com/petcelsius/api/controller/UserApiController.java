package com.petcelsius.api.controller;


import com.aliyun.oss.OSS;
import com.petcelsius.api.constant.Constant;
import com.petcelsius.api.constant.MessageConstant;
import com.petcelsius.api.domain.User;
import com.petcelsius.api.service.UserService;
import com.petcelsius.api.utils.*;
import com.petcelsius.api.vo.LoginByEmailVo;
import com.petcelsius.api.vo.LoginByMobilelVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping("userApi")
public class UserApiController {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private UserService userService;

    @Autowired
    private OSS ossClient;

    @Autowired
    private EmailCodeUtils emailCodeUtils;

    @Value("${oss.base.url}")
    private String ossBaseUrl;

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
//        System.out.println(mobile);
        // 发送验证码
        Result result = SMSUtils.sendShortMessage(mobile, smsCode);

        if (result.isFlag()){
            String smsCodeKey = Constant.SMSCODE_PREFIX + mobile;
            try{
                Jedis jedis = jedisPool.getResource();
                jedis.setex(smsCodeKey, Constant.VALIDATE_TIMEOUT, smsCode);
            }catch (Exception e){
                e.printStackTrace();
                return R.error(MessageConstant.REDIS_CONNECTION_FAIL);
            }
            return R.ok(MessageConstant.SEND_VALIDATECODE_SUCCESS);
        }
        return R.error(MessageConstant.SEND_VALIDATECODE_FAIL);
    }


    /**
     * 不用session
     * @param logvo
     * @return
     */
    // 登录
    @PostMapping("loginUser")
    public R loginUser(@Valid @RequestBody LoginByMobilelVo logvo){


        String mobile = logvo.getMobile();
        String smsCode = logvo.getSmsCode().trim();

        String smsCodeKey = Constant.SMSCODE_PREFIX + mobile;
        try{
            Jedis jedis = jedisPool.getResource();
            String realSmsCode = jedis.get(smsCodeKey);
            if (smsCode.equals(realSmsCode)){
                // System.out.println("获取成功" + realSmsCode);
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
                jedis.del(smsCodeKey);
                return R.ok().put("user", byId);
            }
            return R.error();
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

    /**
     * 下面两个是补充接口，如果不行就用邮箱
     */

    /**
     * 获取邮箱验证码
     * @param email
     * @return
     */
    @GetMapping("getEmailCode/{email}")
    public R getEmailCode(@PathVariable("email") String email){
        // System.out.println(email);
        String emailCOde = GenerateEmailCode.generateEmailCode();
        try{
            // 发送验证码
            R result = emailCodeUtils.sendEmailCode(email, emailCOde, false);
            // System.out.println(result.get("msg"));
            if (result.get("msg") == MessageConstant.SEND_EMAILCODE_SUCCESS){
                // 缓存验证码
                Jedis jedis = jedisPool.getResource();
                String emailCodeKey = Constant.EMAIL_PREFIX + email;
                jedis.setex(emailCodeKey, Constant.VALIDATE_TIMEOUT, emailCOde);
            }
            // 成功返回数据
            return result;
        }catch (Exception e){
            e.printStackTrace();
            // 失败返回错误信息
            return R.error(MessageConstant.SEND_EMAILCODE_FAIL);
        }
    }


    /**
     * 登录通过邮箱验证
     */
    @PostMapping("emailLogin")
    public R loginUserByEmail(@Valid @RequestBody LoginByEmailVo loginByEmailVo){
        String email = loginByEmailVo.getEmail();
        // 获取验证码并且去掉两边空白
        String emailCode = loginByEmailVo.getEmailCode().trim();
        String emailCodeKdy = Constant.EMAIL_PREFIX + email;
        try{

            Jedis jedis = jedisPool.getResource();
            String realEmailCode = jedis.get(emailCodeKdy);
            if (emailCode.equals(realEmailCode)){
                User user = userService.findByMobile(email);
                if (user != null){
//                    session.setAttribute("user", user);
//                    session.setMaxInactiveInterval(60*60*5);
//                    String id = session.getId();
                    return R.ok().put("user", user);
                }
                // 如果没有用户就保存之后返回
                User newUser = new User();
                newUser.setMobile(loginByEmailVo.getEmail());
                newUser.setUsername(loginByEmailVo.getEmail());
                userService.save(newUser);
                User byId = userService.getById(newUser.getId());
//                session.setAttribute("user", byId);
//                session.setMaxInactiveInterval(60*60*5);
//                String id = session.getId();
                // 验证完成删除验证码
                jedis.del(emailCodeKdy);
                return R.ok().put("user", byId);
            }
            // 成功返回数据
            return R.error();
        }catch (Exception e){
            e.printStackTrace();
            // 失败返回错误信息
            return R.error();
        }

    }







}
