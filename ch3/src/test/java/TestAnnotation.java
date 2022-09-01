import annotation.AnnotationUser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    @Test
    public void test(){
        ApplicationContext ac = new  ClassPathXmlApplicationContext("annotationContext.xml");

        //annotationUser首字母要小写
        AnnotationUser au = (AnnotationUser)ac.getBean("annotationUser");
        System.out.println(au.getUsername());
    }
}
