import com.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestController {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = ac.getBean(UserController.class);
        //UserController userController = (UserController) ac.getBean("userController");

        userController.test();
    }
}
