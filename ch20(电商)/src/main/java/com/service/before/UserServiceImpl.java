package com.service.before;

import com.mapper.UserMapper;
import com.pojo.Buser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @package: com.service.before
 * @className: UserServiceImpl
 * @author: SleepWalker
 * @description: 用户服务层
 * @date: 10:04
 * @version: 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @param buser:
     * @param model:
     * @param session:
     * @param code:
     * @return String
     * @author SleepWalker
     * @description 判断验证码, 插入新用户
     * @date  10:09
     */
    @Override
    public String register(Buser buser, Model model, HttpSession session, String code) {
        if(!code.equalsIgnoreCase(session.getAttribute("code").toString())){
            model.addAttribute("codeError", "验证码错误!");
            return "before/register";
        }

        if(userMapper.register(buser) > 0) {
            return "before/login";
        } else {
            model.addAttribute("msg", "注册失败");
            return "before/register";
        }
    }

    /**
     * @param buser:
     * @param model:
     * @param session:
     * @param code:
     * @return String
     * @author SleepWalker
     * @description 查询是否有用户,到首页
     * @date  12:50
     */
    @Override
    public String login(Buser buser, Model model, HttpSession session, String code) {
        if(!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
            model.addAttribute("codeError", "验证码错误!");
            return "before/login";
        }

        Buser ruser = null;
        List<Buser> list = userMapper.login(buser);
        if(list.size() > 0) {
            ruser = list.get(0);
        }
        if(ruser != null) {
            session.setAttribute("bruser", ruser);
            return "forward:/before";
        } else {
            model.addAttribute("msg", "用户名或密码错误!");
            return "before/login";
        }
    }
}
