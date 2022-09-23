package com.mybatis;

import com.pojo.MyUser;
import com.pojo.SelectUserOrdersById;
import com.pojo.SelectUserParam;
import com.pojo.TUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    MyUser selectUserOrdersById1(Integer uid);
    MyUser selectUserOrdersById2(Integer uid);
    List<SelectUserOrdersById> selectUserOrdersById3(Integer uid);

    /*根据Id查询用户*/
    public TUser selectUserById(Integer id);
    public List<TUser> selectUser(Map<String, Object> param);
    /*查询姓?的?性用户*/
    public List<TUser> selectUser(SelectUserParam param);
    /*查询所有用户*/
//    public List<Map<String, Object>> selectAllUserMap();
    public List<TUser> selectAllUserMap();
    /*添加一个用户*/
    public int insertUser(TUser tUser);
}
