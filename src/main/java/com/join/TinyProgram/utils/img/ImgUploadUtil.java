package com.join.TinyProgram.utils.img;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 17:38 2020/6/2
 */
public class ImgUploadUtil {

    public String imgUpload(MultipartFile file,String path){
        if (file.isEmpty()) {
            return null;
                   }
        //String fileName = filename;
        //file.getOriginalFilename();  // 文件名
        //String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        //String filePath = "/www/wwwroot/yanglq.xyz/images"+path; // 上传后的路径
        //fileName = fileName + suffixName; // 新文件名
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println(sdf.format(new Date()));
        String filename=getRandom()+getMD5String(sdf.format(new Date()))+suffixName;
        path=path+filename;
        File dest = new File(path);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }

    public static String getRandom() {
        int rs = (int) ((Math.random() * 9 + 1) * Math.pow(10, 6));
        return String.valueOf(rs);
    }

    public static String getMD5String(String str) {
        try {
            //利用Java自带的MessageDigest类实现的最简单的MD5加密方法
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
