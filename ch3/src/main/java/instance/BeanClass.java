package instance;

public class BeanClass {
    public String message;

    public BeanClass() {
        message = "无参构造方法实例化Bean";
    }

    public BeanClass(String message) {
        this.message = message;
    }
}
