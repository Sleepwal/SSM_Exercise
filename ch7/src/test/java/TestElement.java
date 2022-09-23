import com.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestElement {
    @Test
    public void testSelectAllUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserController userController = ac.getBean(UserController.class);
        userController.test();
    }
}
