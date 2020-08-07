package com.team.controller;

import com.github.pagehelper.PageInfo;
import com.team.domain.AppCondition;
import com.team.domain.AppInfo;
import com.team.domain.AppVersion;
import com.team.domain.DevUser;
import com.team.service.AppCRUDService;
import com.team.service.AppVersionService;
import com.team.service.SearchByHelperService;
import com.team.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
public class AppInfoController {
    String path="upload/logo";
    @Autowired
    private SearchByHelperService searchByHelperService;
    @Autowired
    private AppCRUDService appCRUDService;
    @Autowired
    private AppVersionService appVersionService;
    @RequestMapping("/searchByPageHelper")
    public String searchByPageHelper(Model model, AppCondition appCondition, HttpSession session){
        DevUser devUser = (DevUser) session.getAttribute("userInfo");
        appCondition.setDevid(devUser.getId());
        System.out.println(appCondition.toString());
        PageInfo<AppInfo> searchAppByP = searchByHelperService.searchAppByP(appCondition);
        model.addAttribute("searchAppByP",searchAppByP);
        model.addAttribute("appCondition",appCondition);
        return "developer/appinfolist";
    }

    @RequestMapping("/appinfoaddsave")
    public String appinfoaddsave(
            @RequestParam(value = "a_logoPicPath", required=false )CommonsMultipartFile logoFile,
            HttpServletRequest request,HttpSession session, AppInfo appInfo,Model model) throws Exception {
        if (!logoFile.isEmpty()){
            //获取保存位置

            String savePath = request.getSession().getServletContext().getRealPath(path);
            String fileName = FileUploadUtil.uploadFile(savePath,logoFile);
            System.out.println("图片保存成功"+fileName);
            appInfo.setLogopicpath(path+"/"+fileName);
        }
        DevUser devUser = (DevUser) session.getAttribute("userInfo");
        appInfo.setDevid(devUser.getId());
        Integer integer = appCRUDService.appinfoadd(appInfo);
        if (integer>0){
            model.addAttribute("info","成功");
        }else {
            model.addAttribute("info","失败");
        }
        return "developer/appinfoadd";
    }

    @RequestMapping("/getAppInfoById")
    public String getAppInfoById(String id,Model model){
        AppInfo appInfo = appCRUDService.getAppInfoById(Long.valueOf(id));
        model.addAttribute("appinfo",appInfo);
        return "developer/appinfomodify";
    }

    @RequestMapping("/updateAppInfo")
    public String updateAppInfo(
            @RequestParam(value = "a_logoPicPath", required=false )CommonsMultipartFile logoFile,
            HttpServletRequest request,HttpSession session,
            String oldFileName,AppInfo appInfo,Model model )throws Exception{
            if (!logoFile.isEmpty()){
                //将相对路径转化为绝对路径
                String savePath = request.getSession().getServletContext().getRealPath(path);
                String fileName = FileUploadUtil.uploadFile(savePath, logoFile);

                //删除旧图片
                System.out.println(oldFileName.toString());
                if (oldFileName!=null||!oldFileName.equals("")){
                    String delpath=request.getSession().getServletContext().getRealPath(oldFileName);
                    new File(delpath).delete();
                }
                //修改实体置新上传的文件名称，以便修改数据库
                appInfo.setLogopicpath(path+File.separator+fileName);
            }
            //添加信息到数据库
        Integer integer = appCRUDService.updateAppInfo(appInfo);
        return "redirect:searchByPageHelper";
    }

    @RequestMapping("/delApp")
    public String delApp(String id,String logoPicPath){
        appCRUDService.delApp(Long.valueOf(id));
        new File(logoPicPath).delete();
        return "redirect:searchByPageHelper";
    }

    @RequestMapping("/getAppInfo")
    public String getAppInfo(AppCondition appCondition,Model model){
        PageInfo<AppInfo> pageInfo = appCRUDService.getAppInfo(appCondition);
        System.out.println(appCondition.toString());
        System.out.println(pageInfo.getList().toString());
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("appCondition",appCondition);
        return "backend/applist";
    }

    @RequestMapping("/checkAppInfo")
    public String checkAppInfo(Model model,String id){
        AppInfo appinfo = appCRUDService.selectAppInfoToCheck(Long.valueOf(id));
        AppVersion bastVersion = appVersionService.getBastVersion(Long.valueOf(id));
        model.addAttribute("bastVersion",bastVersion);
        model.addAttribute("appinfo",appinfo);
        return "developer/appcheck";
    }

    @RequestMapping("/checked")
    public String checked(Long state,Long id){
        int i = appCRUDService.updateAppState(id,state);
        if (i>0){
            return "redirect:getAppInfo";
        }
        return "redirect:error.jsp";
    }

    @RequestMapping("/upDownApp")
    @ResponseBody   //返回json
    public String upDownApp(Long id,Long state){
        //调用业务实现
        int temp=this.appCRUDService.updateAppState(id,state);
        return "{\"result\":"+temp+"}";  //如果temp>0 成功  否则失败
    }
}
