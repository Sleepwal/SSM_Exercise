package com.mybatis;

import com.pojo.TUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    TUser selectUserById(Integer id);
    List<TUser> selectAllUser();
    int addUser(TUser user);
    int updateUser(TUser user);
    int deleteUser(Integer uid);
}
