package com.service.admin;

import com.github.pagehelper.PageInfo;
import com.mapper.AdminGoodsMapper;
import com.mapper.AdminTypeMapper;
import com.pojo.Goods;
import com.pojo.GoodsType;
import com.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @package: com.service.admin
 * @className: AdminGoodsServiceImpl
 * @author: SleepWalker
 * @description: TODO
 * @date: 17:45
 * @version: 1.0
 */
@Service
@Transactional
public class AdminGoodsServiceImpl implements AdminGoodsService {
    @Autowired
    AdminGoodsMapper adminGoodsMapper;
    @Autowired
    AdminTypeMapper adminTypeMapper;

    /**
     * @param goods:
     * @param request:
     * @param updateAct:
     * @return String
     * @author SleepWalker
     * @description 添加或更新
     * @date  22:39
     */
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

    /**
     * @param model:
     * @param pageCur:
     * @param act:
     * @return String
     * @author SleepWalker
     * @description 查询商品
     * @date  22:56
     */
    @Override
    public String selectGoods(Model model, Long pageCur, String act) {
        List<Goods> allGoods = adminGoodsMapper.selectGoods();
        int temp = allGoods.size();
        model.addAttribute("totalCount", temp);
        int totalPage = 0;
        int pageSize = 2; //每一个商品个数

        if(temp == 0) {
            totalPage = 0;  //总页数
        } else {
            //返回大于或等于指定表达式的最小整数
            totalPage = (int)Math.ceil((double) temp / pageSize);
        }

        if(pageCur == null) {
            pageCur = 1L;
        }
        if((pageCur - 1) * pageSize > temp) {
            pageCur = pageCur - 1;
        }

        //分页查询
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", (pageCur - 1) * pageSize); //起始位置
        map.put("perPageSize", pageSize); //每页10个
        allGoods = adminGoodsMapper.selectAllGoodsByPage(map);

        model.addAttribute("allGoods", allGoods);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageCur", pageCur);

        //删除查询
        if("deleteSelect".equals(act)) {
            return "admin/deleteSelectGoods";
        }
        //修改查询
        else if("updateSelect".equals(act)) {
            return "admin/updateSelectGoods";
        }
        else {
            return "admin/selectGoods";
        }
    }

    /**
     * @param model:
     * @param id:
     * @param act:
     * @return String
     * @author SleepWalker
     * @description 查询一个商品
     * @date  22:56
     */
    @Override
    public String selectAGoods(Model model, Long id, String act) {
        Goods agoods = adminGoodsMapper.selectGoodsById(id);
        model.addAttribute("goods", agoods);

        if("updateAgoods".equals(act)){
            model.addAttribute("goodsType", adminTypeMapper.selectGoodsType());
            return "admin/updateAgoods";
        }

        return "admin/goodsDetail";
    }

    /**
     * @param ids:
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 删除多个商品
     * @date  11:05
     */
    @Override
    public String deleteGoods(Long[] ids, Model model) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            if(adminGoodsMapper.selectCartGoods(ids[i]).size() > 0 ||
                    adminGoodsMapper.selectFocusGoods(ids[i]).size() > 0 ||
                    adminGoodsMapper.selectOrderdetailGoods(ids[i]).size() > 0) {
                model.addAttribute("msg", "商品有关联, 不允许删除!");
                return "forward:/adminGoods/selectGoods?act=deleteSelect";
            }
            list.add(ids[i]);
        }
        adminGoodsMapper.deleteGoods(list);
        model.addAttribute("msg", "成功删除商品!");

        return "forward:/adminGoods/selectGoods?act=deleteSelect";
    }

    /**
     * @param id:
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 删除一个商品
     * @date  11:11
     */
    @Override
    public String deleteAGoods(long id, Model model) {
        //商品有关联
        if(adminGoodsMapper.selectCartGoods(id).size() > 0 ||
                adminGoodsMapper.selectFocusGoods(id).size() > 0 ||
                adminGoodsMapper.selectOrderdetailGoods(id).size() > 0) {
            model.addAttribute("msg", "商品有关联, 不允许删除!");
            return "forward:/adminGoods/selectGoods?act=deleteSelect";
        }

        adminGoodsMapper.deleteAGoods(id);
        model.addAttribute("msg", "成功删除商品!");

        return "forward:/adminGoods/selectGoods?act=deleteSelect";
    }

}
