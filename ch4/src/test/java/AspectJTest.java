import dynamic.jdk.TestDao;
import dynamic.jdk.TestDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJTest {
    @Test
    public void test() {
        //注解方式
        System.out.println("注解");
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        TestDao testDaoAdvice = ac.getBean(TestDao.class);
//        TestDao testDaoAdvice = (TestDao) ac.getBean("testDao");

        testDaoAdvice.save();

        //xml方式
        System.out.println("\n XML");
        ApplicationContext ac2 = new ClassPathXmlApplicationContext("applicationContext2.xml");

        TestDao testDaoAdvice2 = ac2.getBean(TestDao.class);
        testDaoAdvice2.delete();
      }

}
