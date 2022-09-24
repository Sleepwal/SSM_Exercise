import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.service.TestDIService;

public class HelloTest {
    @Test
    public void test(){
        //初始化Spring容器ApplicationContext，加载配置文件
        ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取 TestDIService实例
        TestDIService ts = (TestDIService)appCon.getBean("testService");
        ts.sayHello();

        TestDIService ts1 = (TestDIService)appCon.getBean("testService1");
        ts1.sayHello();
    }
}
