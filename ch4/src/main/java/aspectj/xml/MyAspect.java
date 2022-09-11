package aspectj.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
*   切面类
*/
public class MyAspect {
    //前置通知, JoinPoint接口作为参数获得目标对象信息
    public void before(JoinPoint joinPoint){
        System.out.println("---前置通知: 模拟权限控制");
        System.out.println("---目标类对象" + joinPoint.getTarget()
        + ", 被增强的处理方法: " + joinPoint.getSignature().getName());
    }

    //后置返回通知
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("---后置返回通知: 模拟删除临时文件");
        System.out.println("---被增强的处理方法: " + joinPoint.getSignature().getName());
    }

    //异常通知
    public void except(Throwable e){
        System.out.println("---异常通知: 程序执行异常" + e.getMessage());
    }

    //后置通知
    public void after(){
        System.out.println("---最终通知: 模拟释放资源");
    }

    //环绕通知
    public Object around(ProceedingJoinPoint pjp){

        Object result = null;
        try {
            System.out.println("===环绕通知-->目标对象方法执行之前");

            //目标方法的执行，目标方法的返回值一定要返回给外界调用者
            result = pjp.proceed();

            System.out.println("===环绕通知-->目标对象方法返回值之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("===环绕通知-->目标对象方法出现异常时");
        } finally {
            System.out.println("===环绕通知-->目标对象方法执行完毕");
        }

        return result;
    }
}
