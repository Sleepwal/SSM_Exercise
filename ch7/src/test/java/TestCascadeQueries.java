import com.controller.More2MoreController;
import com.controller.One2MoreController;
import com.controller.One2OneController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCascadeQueries {
    @Test
    public void one2OneTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        One2OneController o2o = ac.getBean(One2OneController.class);
        //一对一
        o2o.test();
    }

    @Test
    public void one2MoreTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        One2MoreController one2MoreController = ac.getBean(One2MoreController.class);
        //一对多
        one2MoreController.test();
    }

    @Test
    public void more2moreTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        More2MoreController more2MoreController = ac.getBean(More2MoreController.class);
        //多对多
        more2MoreController.test();
    }
}
