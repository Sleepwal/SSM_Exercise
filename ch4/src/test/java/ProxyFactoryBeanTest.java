import dynamic.jdk.TestDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyFactoryBeanTest {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("proxyApplicationContext.xml");
        TestDao testDaoAdvice = (TestDao)ac.getBean("proxyFactoryBean");

        testDaoAdvice.save();
        System.out.println("-----------------");
        testDaoAdvice.modify();
        System.out.println("-----------------");
        testDaoAdvice.delete();
    }
}
