package dynamic.jdk;

import aspect.MyAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy implements InvocationHandler {
    //目标对象
    private TestDao target;

    //创建代理的方法
    public Object createProxy(TestDao testDao) {
        this.target = testDao;
        /*
        1. 类加载器
        2. 被代理对象实现的所有接口
        3. 使用代理类增强
        */
        ClassLoader classLoader = JDKDynamicProxy.class.getClassLoader();
        Class[] classes = testDao.getClass().getInterfaces();

        return Proxy.newProxyInstance(classLoader, classes, this);
    }

    /*
    * 代理的逻辑方法
    * proxy: 被代理对象
    * method: 将要被执行的方法
    * args: 执行方法时需要的参数
    * */
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        //创建一个切面
        MyAspect myAspect = new MyAspect();
        //前增强
        myAspect.check();
        myAspect.except();

        //相当于调用target中的方法
        Object obj = method.invoke(target, args);

        //后增强
        myAspect.log();
        myAspect.monitor();

        return obj;
    }
}
