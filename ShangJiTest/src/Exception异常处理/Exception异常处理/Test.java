package Exception异常处理.Exception异常处理;

import java.io.*;

/*try里面写的是你认为可能会出错的代码，如果程序未报错的话正常执行try里面的程序
* 否则会去下面catch里面匹配相应的错误并给出提示，e是报错里的对象一个try可以配
* 多个catch，出现异常自动匹配*/
public class Test {
    public static void main(String[] args) {
        try{
            int n1 = 10;
            int n2 = 5;
            int result = n1 / n2;
            System.out.println(result);

            int a[] = {10 , 20};
            System.out.println(a[2]);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组下标越界");
            e.printStackTrace(); //追溯异常方法
        }catch (ArithmeticException e){
            System.out.println("除数不可为零");
            System.out.println(e);
        }finally {    //finally作用:无论上面的程序是否会发生异常，里面的代码都会执行常用来善后做反馈
            System.out.println("无论程序是否会报错，finally里的代码都会执行用来善后");
        }

        OutputStream out = null;
        try {
            out = new FileOutputStream("c:/java/hello.txt");//输出流往指定地点输出
            out.write(97);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{   //finally用于善后,因为out.close()方法也会自动抛出异常,所以在finally里嵌套try
            try {
                out.close(); //用完关闭输出流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
