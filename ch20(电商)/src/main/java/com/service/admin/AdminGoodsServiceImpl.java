package com.service.admin;

import com.github.pagehelper.PageInfo;
import com.mapper.AdminGoodsMapper;
import com.pojo.Goods;
import com.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @package: com.service.admin
 * @className: AdminGoodsServiceImpl
 * @author: SleepWalker
 * @description: TODO
 * @date: 17:45
 * @version: 1.0
 */
@Service
public class AdminGoodsServiceImpl implements AdminGoodsService {
    @Autowired
    AdminGoodsMapper adminGoodsMapper;

    @Override
    public String addOrUpdateGoods(Goods goods, HttpServletRequest request, String updateAct) {
        //防止文件重名
        String newFileName = "";
        String fileName = goods.getLogoImage().getOriginalFilename();

        //选择了文件
        if(fileName.length() > 0) {
            String realpath = request.getServletContext().getRealPath("logos");
            //实现文件上传
            String fileType = fileName.substring(fileName.lastIndexOf('.'));
            //防止文件重名
            newFileName = MyUtil.getStringID() + fileType;
            goods.setGpicture(newFileName);
            File targetFile = new File(realpath, newFileName);
            if(!targetFile.exists()) {
                targetFile.mkdirs();
            }

            //上传
            try{
                goods.getLogoImage().transferTo(targetFile);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        //修改
        if("update".equals(updateAct)) { //updateAct不能与act重名, 因为使用了转发
            //修改到数据库
            if(adminGoodsMapper.updateGoodsById(goods) > 0) {
                return "forward:/adminGoods/selectGoods?act=updateSelect";
            } else {
                return "/adminGoods/updateAgoods";
            }
        } else {
            //保存到数据库
            if(adminGoodsMapper.addGoods(goods) > 0){
                //转发到查询的controller
                return "forward:/adminGoods/selectGoods?act=updateSelect";
            } else {
                return "card/addCard";
            }
        }
        
    }
}
