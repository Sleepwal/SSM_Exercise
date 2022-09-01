import assemble.ComplexUser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAssemble {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //构造函数装配
        ComplexUser u1 = (ComplexUser)ac.getBean("user1");
        System.out.println(u1);

        //setter装配
        ComplexUser u2 = (ComplexUser)ac.getBean("user2");
        System.out.println(u2);
    }
}
