package aspect;
/*
* 切面类
*/
public class MyAspect {
    public void check() {
        System.out.println("---模拟权限控制---");
    }
    public void except() {
        System.out.println("---模拟异常处理---");
    }
    public void log() {
        System.out.println("---模拟日志记录---");
    }
    public void monitor() {
        System.out.println("---性能监测---");
    }
}
