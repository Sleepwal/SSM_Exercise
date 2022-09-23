package statement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import statement.dao.TestDao;

@Service
@Transactional
//受Spring的事务管理
//@Transactional只能针对public属性范围内的方法添加
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Override
    public void test() {
        String deleteSql = "delete from t_user where username = '张三'";
        String saveSql = "insert into t_user values(null,?,?,?,?,?)";
        Object[] param = {"张三", "123", "25", "男", "123@qq.com"};

        testDao.delete(deleteSql, null);
        testDao.save(saveSql, param);
        testDao.save(saveSql, param);
    }
}
