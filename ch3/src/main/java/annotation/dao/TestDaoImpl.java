package annotation.dao;

import org.springframework.stereotype.Repository;

@Repository
/*等价于
    @Repository("testDaoImpl")
    但在service层使用@Repository("testDaoImpl"), testDaoImpl不能省略
*/
public class TestDaoImpl implements TestDao {
    @Override
    public void save() {
        System.out.println("TestDao save!");
    }
}
