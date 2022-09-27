import com.controller.UserController;
        import org.junit.Test;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class TestController {
    @Autowired
    private UserController userController;

    @Test
    public void test() {
        userController.test();
    }
}*/
public class TestController {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = ac.getBean(UserController.class);
//        UserController userController = (UserController) ac.getBean("userController");
        //if
        System.out.println("if");
        userController.test();
        System.out.println("=========\n");

        //choose
        System.out.println("choose");
        userController.testChoose();
        System.out.println("=========\n");

        //trim
        System.out.println("trim");
        userController.testTrim();
        System.out.println("=========\n");

        //where
        System.out.println("where");
        userController.testWhere();
        System.out.println("=========\n");

        //set
        System.out.println("set");
        int cnt = userController.testSet();
        System.out.println(cnt + "条记录");
        System.out.println("=========\n");

        //foreach
        System.out.println("foreach");
        userController.testForeach();
        System.out.println("=========\n");

        //bind
        System.out.println("bind");
        userController.testBind();
        System.out.println("=========\n");
    }

}
