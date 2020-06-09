package com.join.TinyProgram.controller.user;

import com.join.TinyProgram.entity.diary.Diary;
import com.join.TinyProgram.entity.user.User;
import com.join.TinyProgram.service.userService.UserService;
import com.join.TinyProgram.utils.img.ImgUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


import java.util.List;
import java.util.Map;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 21:40 2020/5/9
 */
@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/listAll")
    public List<User> listAll()throws Exception{
        return userService.listAll();
    }
    /**
     *登录~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/login")
    public int login(String code)throws Exception{
        String openid=getWxUserOpenid(code);
        User user=new User();
        user.setOpenid(openid);
        return userService.login(user);

    }
    @ResponseBody
    @RequestMapping("/addUser")
    public int addUser(User user)throws Exception{
        return  userService.addUser(user);
    }

    public String getWxUserOpenid(String code) {
        //拼接url
        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        String APPID="wxf2c6d2b1f0c648a5";
        String APPSecret="18d5f389168737b8940ab442092cb6a7";
        url.append("appid=");//appid设置
        url.append(APPID);
        url.append("&secret=");//secret设置
        url.append(APPSecret);
        url.append("&js_code=");//code设置
        url.append(code);
        url.append("&grant_type=authorization_code");
        String openid=null;
        try {
            HttpClient client = HttpClientBuilder.create().build();//构建一个Client
            HttpGet get = new HttpGet(url.toString());    //构建一个GET请求
            HttpResponse response = client.execute(get);//提交GET请求
            HttpEntity result = response.getEntity();//拿到返回的HttpResponse的"实体"
            String content = EntityUtils.toString(result);
            System.out.println(content);//打印返回的信息
            content.split("");
            String s[]=content.split(",");
            String s1[]=s[1].split(":");
            if(s1[0].equals("\"" +"openid"+"\"")){
                openid =s1[1].replace("\"", "");
                openid=openid.replace("}","");
                System.out.println("解析过openid"+openid);
            }
//            for(String x:s){
//                System.out.println(x+"\n");
//                openid=x;
//            }
            //JSONObject r=JSONObject.
            //把信息封装到map
            //map = parseJSON2Map(res);//这个小工具的代码在下面
        } catch (Exception e) {
            e.printStackTrace();
        }
        return openid;
    }
//    @ResponseBody
//    @RequestMapping("/refreshDiary")
//    public int refreshDiary(int id)throws Exception{
//        return userService.refresh(id);
//    }


}
