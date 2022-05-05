package com.petcelsius.api.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.common.comm.ResponseMessage;
import com.aliyun.oss.model.PutObjectResult;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 文件上传到oss工具类
 */

public class OssUploadUtils {
    /**
     *
     * @param type  上传到那个文件夹
     * @param originFileName  原文件的路径
     * @param inputStream  原文件的输入流
     * @param baseUrl  外网访问的域名，url
     * @param ossClient  Oss的对象
     * @param bucketName  Oss的Bucket名字
     * @return R
     */

    public static R uploadByFile(String type, String originFileName, InputStream inputStream, String baseUrl, OSS ossClient, String bucketName){
        // 根据种类定义文件夹
        String fileDir = type + "/" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "/";
        // 获取原文件的拓展名
        String exName = originFileName.substring(originFileName.lastIndexOf("."));
        // 生成uuid唯一文件主体名字
        String fileMainName = UUID.randomUUID().toString().replace("-", "");
        // 真实的上传文件的路径+文件名，不加域名
        String realFileName = fileDir + fileMainName + exName;

        // 上传文件
        try{
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, realFileName, inputStream);
            ResponseMessage response = putObjectResult.getResponse();
            if(response == null){
                // 上传成功
                String resultUrl = baseUrl + realFileName;
                return R.ok().put("data", resultUrl);
            }else {
                return R.ok("上传失败");
            }

        }catch (Exception e){
            e.printStackTrace();
            return R.error("上传失败");
        }finally {
//            ossClient.shutdown();
        }
    }
}