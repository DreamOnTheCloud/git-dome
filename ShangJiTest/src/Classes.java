public abstract class Classes { //抽象类 abstract 不需要实现的类
    public abstract void move ();
    /*抽象类里的方法叫做抽象方法，有抽象方法的类，必须声明为抽象类
    * 抽象方法-不需要在父类实现的方法在子类实现 , 抽象类不可以被实例化*/


    public void eat(){
        System.out.println("狗再吃");
    }

}

class dog extends Classes{
    public void move(){
        System.out.println("小狗在跑");
        /*实现了抽象方法的子类可以实例化
        但他的父类抽象类不可以被实例化*/
    }
}

class TestClasses {
    public static void main(String[] args) {
        dog d1 = new dog(); //狗类继承的是最上面的Classes抽象类
        d1.move();          //重写并实现Classes抽象类里的抽象方法move
    }
}




abstract class Animal{   //定义抽象类Animals，注意:此类为抽象类不可被实例化谁实现他的抽象方法谁可以被实例化
    public abstract void move();  //抽象方法


    public void eat(){
        System.out.println("动物在吃"); //一般方法父类直接实现 子类可以重写
    }


}

class cat extends Animal{
    public void move(){     //抽象方法重写左边为绿色的
        System.out.println("猫再跳");
        /*猫类是实现了父类动物类里的抽象方法(move),子类猫类不是抽象类所以可以被实例化*/
    }

    public void eat(){      //一般方法重写左边为蓝色的
        System.out.println("猫喜欢吃鱼");
    }
}

class testAnimal {
    public static void main(String[] args) {
        cat c1 = new cat();  //实例化子类因为子类不是抽象类，并且实现了父类的抽象方法move
        c1.move(); //重写实现父类的抽象方法
        c1.eat();  //重写父类的一般方法


    }
}


























