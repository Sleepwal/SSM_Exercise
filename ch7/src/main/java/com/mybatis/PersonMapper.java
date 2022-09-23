package com.mybatis;

import com.pojo.Person;
import com.pojo.SelectPersonById;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMapper {
    Person selectPersonById1(Integer id);
    Person selectPersonById2(Integer id);
    SelectPersonById selectPersonById3(Integer id);
}
