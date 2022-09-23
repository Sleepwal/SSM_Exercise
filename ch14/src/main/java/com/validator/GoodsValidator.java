package com.validator;

import com.pojo.Goods;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class GoodsValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        //要验证的model, 返回值为false则不验证
        return Goods.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //target要验证的对象
        Goods goods = (Goods)target;
        //goods.gname.required是错误消息属性文件中的编码
        ValidationUtils.rejectIfEmpty(errors, "gname", "goods.gname.required");
        ValidationUtils.rejectIfEmpty(errors, "gdescription", "goods.gdescription.required");

        if(goods.getGprice() > 100 || goods.getGprice() < 0) {
            errors.rejectValue("gprice", "gprice.invalid");
        }
        Date goodsDate = goods.getGdate();

        //在系统时间之后
        if(goodsDate != null && goodsDate.after(new Date())) {
            errors.rejectValue("gdate", "gdate.invalid");
        }
    }
}
