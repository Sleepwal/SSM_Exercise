interface Human{
    String getBelief();

    void eat(String food);
}

//被代理类
class SpuerMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

/*需要解决的两个主要问题：
    问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
    （通过Proxy.newProxyInstance()实现）

    问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。
    (通过InvocationHandler接口的实现类及其方法invoke())
*/

class ProxyFactory{

}

public class ProxyTest {
}













