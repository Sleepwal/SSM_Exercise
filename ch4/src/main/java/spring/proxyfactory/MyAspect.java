package spring.proxyfactory;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        check();
        except();

        Object obj = invocation.proceed();

        log();
        monitor();

        return obj;
    }

    public void check() {
        System.out.println("---模拟权限控制---代理类");
    }
    public void except() {
        System.out.println("---模拟异常处理---代理类");
    }
    public void log() {
        System.out.println("---模拟日志记录---代理类");
    }
    public void monitor() {
        System.out.println("---性能监测---代理类");
    }
}
