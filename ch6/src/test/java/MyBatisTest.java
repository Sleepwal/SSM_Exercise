import com.mybatis.pojo.TUser;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.commons.logging.Log;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void test() {
        try {
            //读取配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //根据配置文件构建SqlSessionFactory
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
            //通过SqlSessionFactory创建SqlSession
            SqlSession sqlSession = ssf.openSession();

            //执行映射文件中定义的SQL
            //查询一个用户
            TUser tUser = sqlSession.selectOne("com.mybatis.mapper.UserMapper.selectUserById", 1);
            System.out.println(tUser);

            //添加一个用户
            TUser addUser = new TUser();
            addUser.setUsername("SleepWalker");
            addUser.setGender("男");
            sqlSession.insert("com.mybatis.mapper.UserMapper.addUser", addUser);

            //修改一个用户
            TUser updateUser = new TUser();
            updateUser.setUid(1);
            updateUser.setUsername("SleepWalker22222222");
            updateUser.setGender("男");
            sqlSession.update("com.mybatis.mapper.UserMapper.updateUser", updateUser);

            //删除一个用户
            sqlSession.delete("com.mybatis.mapper.UserMapper.deleteUser", 3);

            //查询所有用户
            List<TUser> list = sqlSession.selectList("com.mybatis.mapper.UserMapper.selectAllUser");
            for(TUser user : list){
                System.out.println(user);
            }

            //提交事务
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
