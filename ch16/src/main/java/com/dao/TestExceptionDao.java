package com.dao;

import com.exception.MyException;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class TestExceptionDao {
    public void daoSQL() throws Exception {
        throw new SQLException("Dao中数据库异常");
    }

    public void daoMy() throws Exception {
        throw new MyException("Dao中自定义异常");
    }

    public void daoNo() throws Exception {
        throw new Exception("Dao中未知异常");
    }
}
