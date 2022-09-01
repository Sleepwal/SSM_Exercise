package annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
/*等价于
*   @Component("annotationUser")
*   @Component(value = "annotationUser")
* */
public class AnnotationUser {
    @Value("张三")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
