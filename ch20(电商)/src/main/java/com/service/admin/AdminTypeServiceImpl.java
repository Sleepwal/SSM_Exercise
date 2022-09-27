package com.service.admin;

import com.mapper.AdminTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * @package: com.service.admin
 * @className: AdminTypeServiceImpl
 * @author: SleepWalker
 * @description: TODO
 * @date: 23:52
 * @version: 1.0
 */

@Service
public class AdminTypeServiceImpl implements AdminTypeService {
    @Autowired
    AdminTypeMapper adminTypeMapper;

    /**
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 查询出所有类型并跳转到addType页面
     * @date  23:54
     */
    @Override
    public String toAddType(Model model) {
        model.addAttribute("allTypes", adminTypeMapper.selectGoodsType());
        return "admin/addType";
    }

    /**
     * @param typename:
     * @param model:
     * @param session:
     * @return String
     * @author SleepWalker
     * @description 添加商品
     * @date  23:55
     */
    @Override
    public String addType(String typename, Model model, HttpSession session) {
        adminTypeMapper.addType(typename);
        //添加完类型, 查询后添加变量goodsType再跳转
        session.setAttribute("goodsType", adminTypeMapper.selectGoodsType());
        return "forward:/adminType/toAddType";
    }

    /**
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 跳转
     * @date  12:19
     */
    @Override
    public String toDeleteType(Model model) {
        model.addAttribute("allTypes", adminTypeMapper.selectGoodsType());
        return "admin/deleteType";
    }

    /**
     * @param id:
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 判断类型是否关联, 删除无关联类型
     * @date  12:21
     */
    @Override
    public String deleteType(long id, Model model) {
        //类型有关联
        if(adminTypeMapper.selectGoodsByType(id).size() > 0) {
            model.addAttribute("msg", "类型有关联, 不允许删除!");
        }

        if(adminTypeMapper.deleteType(id) > 0) {
            model.addAttribute("msg", "类型删除成功!");
        }

        return "forward:/adminType/toDeleteType";
    }
}
