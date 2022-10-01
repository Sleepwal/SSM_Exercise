package com.service.admin;

import com.mapper.AdminOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

/**
 * @package: com.service.admin
 * @className: AdminOrderServiceImpl
 * @author: SleepWalker
 * @description: Service层
 * @date: 15:34
 * @version: 1.0
 */
@Service
@Transactional
public class AdminOrderServiceImpl implements AdminOrderService {
    @Autowired
    private AdminOrderMapper adminOrderMapper;
    /**
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 查询所有订单,到订单管理
     * @date  15:51
     */
    @Override
    public String orderInfo(Model model) {
        List<Map<String, Object>> list = adminOrderMapper.orderInfo();
        model.addAttribute("orderList", list);
        return "admin/orderManager";
    }

    /**
     * @param id:
     * @return String
     * @author SleepWalker
     * @description 删除订单,到订单管理
     * @date  15:55
     */
    @Override
    public String deleteOrderManager(Long id) {
        //先删除明细
        adminOrderMapper.deleteOrderDetail(id);
        //在删除订单基础
        adminOrderMapper.deleteOrderBase(id);
        return "forward:/adminOrder/orderInfo";
    }
}
