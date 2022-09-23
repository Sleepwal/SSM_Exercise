package com.controller;

import com.mybatis.PersonMapper;
import com.pojo.Person;
import com.pojo.SelectPersonById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class One2OneController {
    @Autowired
    private PersonMapper personDao;

    public void test() {
        Person person1 = personDao.selectPersonById1(1);
        System.out.println("====1.嵌套查询");
        System.out.println(person1);
        System.out.println("====================");

        System.out.println("====2.嵌套结果");
        Person person2 = personDao.selectPersonById2(1);
        System.out.println(person2);
        System.out.println("====================");

        System.out.println("====3.连接查询");
        SelectPersonById person3 = personDao.selectPersonById3(1);
        System.out.println(person3);
        System.out.println("====================");

    }
}
