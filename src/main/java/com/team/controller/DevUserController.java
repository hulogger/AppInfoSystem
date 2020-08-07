package com.team.controller;

import com.team.domain.DevUser;
import com.team.service.DevUserService;
import com.team.service.impl.DevUserServiceImpl;
import com.team.util.QRCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;

@Controller
public class DevUserController {
    @Autowired
    private DevUserService devUserService;
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        DevUser login = devUserService.login(username, password);
        if (login==null){
            return "redirect:jsp/devlogin.jsp";
        }else {
            session.setAttribute("userInfo",login);
            session.setMaxInactiveInterval(1200);
            return "developer/main";
        }
    }

    @RequestMapping("/devloginByQr")
    public String devloginByQr(HttpServletResponse response, HttpServletRequest request,HttpSession session) throws Exception {
        // 存放在二维码中的内容
        // 二维码中的内容可以是文字，可以是链接等
        String text = "http://localhost:8080/jsp/devlogin.jsp";
        // 嵌入二维码的图片路径
        //String imgPath = "D:\\picture\\pictures\\pictures\\ps处理\\张太阳3.png";
        // 生成的二维码的路径及名称
        String destPath = "D:\\img\\code" + System.currentTimeMillis() + ".jpg";
        //生成二维码
        QRCodeUtil.encode(text, null, destPath, true);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);
        session.setAttribute("imgpath",destPath);


        /*==========================================*/
        ServletOutputStream out = response.getOutputStream();
        String realPath = destPath;//获取要写图片相对于当前web应用的绝对路径
        InputStream in = new FileInputStream(realPath);
        int len = 0;
        byte[] buffer = new byte[1024];//每次读1k
        while((len=in.read(buffer))>0){
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
        return "devloginByQr";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        Enumeration attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            session.removeAttribute(attributeNames.nextElement().toString());
        }
        return "redirect:jsp/devlogin.jsp";
    }
}
