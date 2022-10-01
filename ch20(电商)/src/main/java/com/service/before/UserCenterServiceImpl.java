package com.service.before;

import com.mapper.UserCenterMapper;
import com.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * @package: com.service.before
 * @className: UserCenterServiceImpl
 * @author: SleepWalker
 * @description: TODO
 * @date: 23:29
 * @version: 1.0
 */
@Service
@Transactional
public class UserCenterServiceImpl implements UserCenterService {
    @Autowired
    private UserCenterMapper userCenterMapper;

    @Override
    public String userCenter(HttpSession session, Model model) {
        model.addAttribute("myOrder",
                userCenterMapper.myOrder(MyUtil.getUserId(session)));
        model.addAttribute("myFocus",
                userCenterMapper.myFocus(MyUtil.getUserId(session)));

        return "before/userCenter";
    }

    @Override
    public String orderDetail(Model model, Long ordersn) {
        model.addAttribute("myOrderDetail",
                userCenterMapper.orderDetail(ordersn));

        return "before/userOrderDetail";
    }
}
