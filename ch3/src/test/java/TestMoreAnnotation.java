import annotation.Controller.TestController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMoreAnnotation {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("annotationContext.xml");

        TestController testController = (TestController)ac.getBean("testController");
        testController.save();
    }
}
