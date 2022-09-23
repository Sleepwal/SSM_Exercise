package com.controller;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;


@Controller
public class FileDownController {
    private static final Log logger = LogFactory.getLog(FileDownController.class);

    //显示要下载的文件
    @RequestMapping("showDownFiles")
    public String show(HttpServletRequest request, Model model) {
        String realpath = request.getServletContext().getRealPath("uploadfiles");

        File dir = new File(realpath);
        File files[] = dir.listFiles();

        //获取该目录下的所有文件名
        ArrayList<String> fileName = new ArrayList<>();

        for (File file : files) {
            fileName.add(file.getName());
        }
        model.addAttribute("files", fileName);

        return "showDownFiles";
    }

    //执行下载
    @RequestMapping("down")
    public String down(@RequestParam String filename, HttpServletRequest request,
                       HttpServletResponse response) {
        String aFilePath = null;
        FileInputStream in = null;
        ServletOutputStream out = null;

        try{
            aFilePath = request.getServletContext().getRealPath("uploadfiles");
            //设置下载文件使用的报头
            response.setHeader("Content-Type", "application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment;filename="
            + toUTF8String(filename));

            //读入文件
            in = new FileInputStream(aFilePath + "\\" + filename);

            //得到响应对象的输出流, 用于向客户端输出二进制数据
            out = response.getOutputStream();
            out.flush();
            int aRead = 0;
            byte[] b = new byte[1024];
            while((aRead = in.read(b)) != -1 & in != null) {
                out.write(b, 0, aRead);
            }

            out.flush();
            in.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("下载成功");
        return null;
    }

    //下载保存时中文文件名的字符编码转换方法
    public String toUTF8String(String str) {
        StringBuffer sb = new StringBuffer();
        int len = str.length();

        for (int i = 0; i < len; i++) {
            //取出字符中的每个字符
            char c = str.charAt(i);
            //Unicode码值为0~255时, 不做处理
            if(c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte b[];
                try {
                    b = Character.toString(c).getBytes(StandardCharsets.UTF_8);
                } catch (Exception e) {
                    e.printStackTrace();
                    b = null;
                }

                //转换为%HH的字符串形式
                assert b != null;
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if(k < 0){
                        k &= 255;
                    }
                    sb.append("%").append(Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }


}
