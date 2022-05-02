package com.petcelsius.api.utils;

import com.petcelsius.api.constant.MessageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;


/**
 * 一定要加到容器中在使用，如果直接使用这个工具类，会报空指针异常
 */
@Component
public class EmailCodeUtils {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String formEmail;

    /**
     * 传递一个标志位
     * @param email
     * @param emailCode
     * @param isSimple
     * @return
     */
    public R sendEmailCode(String email, String emailCode, Boolean isSimple){
        if(isSimple){
            return sendSimpleEmailCode(email, emailCode);
        }
        return sendHtmlEmailCode(email, emailCode);
    }

    /**
     * 发送简单邮件(不带附件，不带格式)
     * @param email
     * @param emailCode
     * @return
     */
    public R sendSimpleEmailCode(String email, String emailCode){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(formEmail);
        message.setText("欢迎使用宠℃，您的验证码是：" + emailCode);
        message.setSubject("宠℃");
        message.setTo(email);
        // message.setCc("抄送人");
        // message.setBcc("密送人");
        try{
            javaMailSender.send(message);
            // 成功返回数据
            return R.ok(MessageConstant.SEND_EMAILCODE_SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            // 失败返回错误信息
            return R.error(MessageConstant.SEND_EMAILCODE_FAIL);
        }

    }



    public R sendHtmlEmailCode(String email, String emailCode){
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        //需要借助Helper类
        MimeMessageHelper helper=new MimeMessageHelper(mailMessage);
        String context="<b>尊敬的用户：</b><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您好，您的验证码是:"+ emailCode +
                "请您尽快通过登录系统。";
        try {
            helper.setFrom(formEmail);
            helper.setTo(email);
            // helper.setBcc("密送人");
            helper.setSubject("宠℃");
            helper.setSentDate(new Date()); //发送时间
            // 这个是html格式
            helper.setText(context,true);
            //第一个参数要发送的内容，第二个参数不是Html格式。

            javaMailSender.send(mailMessage);
            return R.ok(MessageConstant.SEND_EMAILCODE_SUCCESS);

        } catch (MessagingException e) {
            e.printStackTrace();
            return R.error(MessageConstant.SEND_EMAILCODE_FAIL);
        }
    }



}
