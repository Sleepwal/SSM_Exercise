package com.controller;

import com.pojo.GoodsModelB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class FormatterController {
    @RequestMapping("/formatter")
    public String myConverter(GoodsModelB gm, Model model) {
        model.addAttribute("goods2", gm);
        return "showGoods";
    }
}
