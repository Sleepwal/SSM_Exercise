import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import pojo.TUser;

import javax.xml.transform.Source;
import java.util.List;

//指定当前测试类在Spring的测试环境中执行, 此时就可以通过注入的方式直接获取IOC容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testSpringJDBC() {
        String sql = "insert into ssm.t_user values (null, ?, ?, ?, ?, ?)";

        Object[] param1 = {"张三", "123", "25", "男", "123@qq.com"};
        Object[] param2 = {"李四", "123", "24", "男", "123@qq.com"};
        Object[] param3 = {"王五", "123", "28", "女", "123@qq.com"};

        //添加
        /*jdbcTemplate.update(sql, param1);
        jdbcTemplate.update(sql, param2);
        jdbcTemplate.update(sql, param3);*/

        //查询
        String selectSql = "select * from ssm.t_user";
        List<TUser> users = jdbcTemplate.query(selectSql, new BeanPropertyRowMapper<>(TUser.class));
        users.forEach(System.out::println);
    }

    @Autowired
    private TransactionTemplate transactionTemplate;

    //TransactionTemplate编程式事务管理
    @Test
    public void TransactionTemplateTest() {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                String sql = "insert into ssm.t_user values(null, ?, ?, ?, ?, ?)";
                try{
                    jdbcTemplate.update(sql, "root", "123", "23", "女", "123@qq.com");
                }catch (Exception e){
                    transactionStatus.setRollbackOnly();
                    e.printStackTrace();
                    return "事务回滚";
                }

                return "执行成功";
            }
        });
    }

    @Test
    public void testInsert(){
        String sql = "insert into ssm.t_user values(null, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, "root", "123", "23", "女", "123@qq.com");
    }

    @Test
    public void testSelect(){
        String sql = "select * from ssm.t_user";
        List<TUser> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TUser.class));
        users.forEach(System.out::println);
    }

}
