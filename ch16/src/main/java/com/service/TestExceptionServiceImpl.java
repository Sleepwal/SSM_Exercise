package com.service;

import com.dao.TestExceptionDao;
import com.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class TestExceptionServiceImpl implements TestExceptionService {
    @Autowired
    private TestExceptionDao testExceptionDao;

    @Override
    public void serviceMy() throws Exception {
        throw new MyException("Service中自定义异常");
    }

    @Override
    public void serviceSQL() throws Exception {
        throw new SQLException("Service中数据库异常");
    }

    @Override
    public void serviceNo() throws Exception {
        throw new Exception("Service中未知异常");
    }

    @Override
    public void daoMy() throws Exception {
        testExceptionDao.daoMy();
    }

    @Override
    public void daoSQL() throws Exception {
        testExceptionDao.daoSQL();
    }

    @Override
    public void daoNo() throws Exception {
        testExceptionDao.daoNo();
    }
}
