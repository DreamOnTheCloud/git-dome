package Exception异常处理.Exception异常处理;

import java.util.InputMismatchException;
import java.util.Scanner;

/*throws手动抛出异常，用在方法头，后面跟的是你要抛出的异常名，Java里异常只有两种程序级别的异常和jvm虚拟机里的异常
* 所有的程序级别的异常都是throws抛出来的，设置一个异常在方法里不去处理，谁调用此个方法谁去处理*/
public class DivTest {
    public int div(int a , int b) throws Exception {//谁调用DivTest方法谁去处理我用throw抛出的异常
        if (b == 0){
            throw new ArithmeticException("除数不能为零");//手动抛出异常——错误信息
        }
        int result = a / b;
        return result;
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        DivTest t = new DivTest();//用类名实例化对象,通过对象访问类里面的方法,对象是t
        try {
            t.div(a , b); //因为DivTest类里面的div方法手动throws抛出了异常,所以要用try否则编译过不去
        } catch (Exception e) {
            e.printStackTrace();//追溯异常，顺藤摸瓜
            System.out.println(e.getMessage());//message获取里面的信息为你自己写在throw new后面的
        }
    }
}

/*
* 自定义异常MyException自己写的异常继承异常总父类Exception,创建构造方法引用父类的message值
* 这样的话自己想要抛出异常的话就可以直接调用自己写的MyException
* */
class MyException extends Exception{   //继承父类
    public MyException(String message){   //创建一个字符串参数的构造方法
        super(message);
    }
}

class CmdCalculator{
    public void calculator()throws MyException, InputMismatchException {//带异常的方法calculator
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("这是除法运算，请您输入一个整数:");
            int num1 = s.nextInt();


            System.out.println("请输入除数:");
            int num2 = s.nextInt();
            if (num2 == 0){
                throw new MyException("除数不可为零");
            }
            int result = this.div(10,5);
            System.out.println("运算结果为" + result);
        }catch (InputMismatchException e){
            throw new InputMismatchException("类型不匹配");
        }

    }

    public int div(int a , int b){
        return a / b;
    }

    public static void main(String[] args) {
        CmdCalculator c1 = new CmdCalculator();
        try {
            c1.calculator();
        } catch (MyException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
}














