package com.mybatis;

import com.pojo.Idcard;
import org.springframework.stereotype.Repository;

@Repository
public interface IdCardMapper {
    Idcard selectCodeById(Integer i);
}
