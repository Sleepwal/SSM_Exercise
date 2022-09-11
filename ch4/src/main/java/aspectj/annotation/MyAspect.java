package aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
*   切面类
*/
// @Aspect表示这个类是一个切面类
@Aspect
// @Component注解保证这个切面类能够放入IOC容器
@Component
public class MyAspect {
    /*
    * 定义切入点
    */
//    @Pointcut("execution(public void dynamic.jdk.TestDaoImpl.save(..))")
    @Pointcut("execution(* dynamic.jdk.TestDaoImpl.*())")
    private void myPointCut(){}

    //前置通知, JoinPoint接口作为参数获得目标对象信息
    @Before("myPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("---前置通知: 模拟权限控制");
        System.out.println("---目标类对象" + joinPoint.getTarget()
        + ", 被增强的处理方法: " + joinPoint.getSignature().getName());
    }

    //后置返回通知
    @AfterReturning(value = "myPointCut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        System.out.println("---后置返回通知: 模拟删除临时文件");
        System.out.println("---被增强的处理方法: " + joinPoint.getSignature().getName());
        System.out.println("---结果: " + result);
    }

    //异常通知
    @AfterThrowing(value="myPointCut()", throwing="e")
    public void except(Throwable e){
        System.out.println("---异常通知: 程序执行异常" + e.getMessage());
    }

    //后置通知
    @After("myPointCut()")
    public void after(){
        System.out.println("---最终通知: 模拟释放资源");
    }

    //环绕通知
    @Around("myPointCut()")
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
