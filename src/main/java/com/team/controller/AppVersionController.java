package com.team.controller;

import com.team.dao.AppVersionMapper;
import com.team.domain.AppVersion;
import com.team.service.AppVersionService;
import com.team.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AppVersionController {
    @Autowired
    private AppVersionService appVersionService;

    private String path="upload/apk";  //设置apk文件的相对位置

    //去添加app版本信息， 传appid
    @RequestMapping("/goAddVersion")
    public String goAddVersion(Long id, Model model){
        //设用业务查询所有app的版本信息
        List<AppVersion> appverssionList=appVersionService.getAppVersionInfo(id);
        //填充页面
        model.addAttribute("appverssionList",appverssionList);
        //将appid回显到页面中，便用添加版本时获取appid
        model.addAttribute("appid",id);
        return "developer/appversionadd";
    }


    //添加app版本信息
    //注意:给添加app版本的表单，需要添加获取appid的表单对象(隐藏域)
    @RequestMapping("/addAppVersion")
    public String addAppVersion(
            AppVersion appVersion,    //接收保存的数据
            HttpServletRequest request,
            @RequestParam(value = "a_downloadLink",required = false) CommonsMultipartFile apkFile, Model model){
        try {
            //1.上传app文件
            //判断是否有选择上传图片  如没有上传图片则返回true,反之false
            if(!apkFile.isEmpty()){
                //1.实现文件上传
                //一个文件域对应一个CommonsMultipartFile类的参数对象
                String savePath=request.getSession().getServletContext().getRealPath(path);
                //上传
                String fileName= FileUploadUtil.uploadFile(savePath,apkFile);
                //注意:设置数据库保存的apk文件路径
                appVersion.setDownloadlink(path+"/"+fileName);
                //设置apk文件的名称  保存原始文件名
                appVersion.setApkfilename(apkFile.getOriginalFilename());
            }
            //2.保存信息到数据库
            appVersionService.addAppVersion(appVersion);
        }catch (Exception e){
            e.printStackTrace();
        }
        //跳转到添加app版本的页面
        return "redirect:goAddVersion?id="+appVersion.getAppid();
    }




}
