package com.mybatis;

import com.pojo.TUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public TUser selectUserById(Integer id);
    List<TUser> selectUserByIf(TUser user);
    List<TUser> selectUserByChoose(TUser user);
    List<TUser> selectUserByWhere(TUser user);
    int updateUserBySet(TUser user);
    List<TUser> selectUserByForeach(@Param("listId") List<Integer> listId);
    List<TUser> selectUserByBind(TUser user);
}
