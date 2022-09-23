package com.controller;

import com.pojo.FileDomain;
import com.pojo.MultiFileDomain;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class FileUploadController {
    private static final Log logger = LogFactory.getLog(FileUploadController.class);

    //单文件上传
    @RequestMapping("/onefile")
    public String oneFileUpload(@ModelAttribute FileDomain fileDomain, HttpServletRequest request) {
        String realpath = request.getServletContext().getRealPath("uploadfiles");
        String fileName = fileDomain.getMyfile().getOriginalFilename();
        File targetFile = new File(realpath, fileName);
        if(!targetFile.exists()) {
            targetFile.mkdirs();
        }

        //上传
        try{
            fileDomain.getMyfile().transferTo(targetFile);
            logger.info("成功");
        } catch (Exception e){
            e.printStackTrace();
        }

        return "showOne";
    }

    //多文件上传
    @RequestMapping("multifile")
    public String multiFileUpload(@ModelAttribute MultiFileDomain multiFileDomain,
                                  HttpServletRequest request) {
        String realpath = request.getServletContext().getRealPath("uploadfiles");

        File targetDir = new File(realpath);
        if(!targetDir.exists()) {
            targetDir.mkdirs();
        }

        List<MultipartFile> files = multiFileDomain.getMyfile();
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            File targetFile = new File(realpath, fileName);

            //上传
            try {
                file.transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        logger.info("成功");
        return "showMulti";
    }
}
