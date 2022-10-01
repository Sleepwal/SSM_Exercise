package com.controller;

import com.pojo.Auser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @package: com.controller
 * @className: TestController
 * @author: SleepWalker
 * @description: TODO
 * @date: 23:05
 * @version: 1.0
 */
@Controller
public class TestController {
    /**
     * @param auser
     * @return String
     * @author SleepWalker
     * @description 运行项目后跳转到相应界面
     * @date  23:06
     */
    @RequestMapping("/")
    /*public String admin(@ModelAttribute Auser auser) {
        return "admin/login";
    }*/
    public String admin() {
        return "forward:/before";
    }
}
