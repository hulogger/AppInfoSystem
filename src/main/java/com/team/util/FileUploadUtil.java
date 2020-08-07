package com.team.util;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUploadUtil {
    public static  String uploadFile(String savePath, CommonsMultipartFile logoFile){
        try {
        //生成唯一文件名
        String originalFilename = logoFile.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = System.currentTimeMillis() + substring;
        //上传文件
        File saveFile=new File(savePath+"/"+fileName);
            logoFile.transferTo(saveFile);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
