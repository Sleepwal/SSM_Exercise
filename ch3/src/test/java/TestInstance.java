import instance.BeanClass;
import instance.BeanStaticFactory;
import life.BeanLife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInstance {
    @Test
    public void test(){ //实例化Bean
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //测试构造方法实例化Bean
        BeanClass b1 = (BeanClass)applicationContext.getBean("constructorInstance");
        System.out.println(b1);
        System.out.println(b1.message);

        //测试静态工厂实例化Bean
        BeanClass b2 = BeanStaticFactory.createInstance();
        System.out.println(b2);
        System.out.println(b2.message);
    }

    @Test
    public void test2() {   //作用域
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //singleton
        System.out.println("singleton");
        BeanClass b1 = (BeanClass)applicationContext.getBean("constructorInstance");
        System.out.println(b1);

        BeanClass b2 = (BeanClass)applicationContext.getBean("constructorInstance");
        System.out.println(b2);

        //prototype
        System.out.println("\nprototype");
        BeanClass b3 = (BeanClass)applicationContext.getBean("constructorInstance1");
        System.out.println(b3);

        BeanClass b4 = (BeanClass)applicationContext.getBean("constructorInstance1");
        System.out.println(b4);
    }

    @Test
    public void lifeTest() {    //生命周期
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("获得对象前");
        BeanLife beanLife = (BeanLife)ctx.getBean("beanLife");
        System.out.println("获得对象后" + beanLife);

        ctx.close();
    }
}
