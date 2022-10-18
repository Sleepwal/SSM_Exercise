package com.service.before;

import com.mapper.AdminTypeMapper;
import com.mapper.IndexMapper;
import com.pojo.Buser;
import com.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * @package: com.service.before
 * @className: IndexServiceImpl
 * @author: SleepWalker
 * @description: 首页Service
 * @date: 22:34
 * @version: 1.0
 */
@Service
@Transactional
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexMapper indexMapper;
    @Autowired
    private AdminTypeMapper adminTypeMapper;

    /**
     * @param model:
     * @param session:
     * @param id:
     * @return String
     * @author SleepWalker
     * @description 查询需要数据,到首页
     * @date  23:13
     */
    @Override
    public String before(Model model, HttpSession session, Integer id) {
        session.setAttribute("goodsType", adminTypeMapper.selectGoodsType());
        session.setAttribute("salelist", indexMapper.getSaleOrder());
        session.setAttribute("focuslist", indexMapper.getFocusOrder());
        session.setAttribute("noticelist", indexMapper.selectNotice());

        Goods goods = new Goods();
        if(id == null){
            goods.setGoodstypeId(0L);
        }

        model.addAttribute("lastedlist", indexMapper.getLastedGoods(goods));
        return "before/index";
    }

    /**
     * @param model:
     * @param mykey:
     * @return String
     * @author SleepWalker
     * @description 模糊搜索, 到搜索结果
     * @date  23:13
     */
    @Override
    public String search(Model model, String mykey) {
        model.addAttribute("searchlist",  indexMapper.search(mykey));
        return "before/searchResult";
    }

    /**
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 到注册页面
     * @date  10:01
     */
    @Override
    public String toRegister(Model model) {
        model.addAttribute("rbuser", new Buser());
        return "before/register";
    }

    @Override
    public String toLogin(Model model) {
        model.addAttribute("lbuser", new Buser());
        return "before/login";
    }

    @Override
    public String goodsDetail(Model model, Integer id) {
        Goods goods = indexMapper.selectGoodsById(id);
        model.addAttribute("goods", goods);
        return "before/goodsdetail";
    }
}
