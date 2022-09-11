import dynamic.jdk.JDKDynamicProxy;
import dynamic.jdk.TestDao;
import dynamic.jdk.TestDaoImpl;

public class JDKDynamicTest {
    public static void main(String[] args) {
        //创建代理对象
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy();
        //创建目标对象
        TestDao target = new TestDaoImpl();

        //从代理对象中获取增强后的对象, 该对象会进入代理的逻辑方法invoke中
        TestDao targetAdvice = (TestDao)jdkDynamicProxy.createProxy(target);

        //执行
        targetAdvice.save();
        System.out.println();
        targetAdvice.modify();
        System.out.println();
        targetAdvice.delete();

    }
}
