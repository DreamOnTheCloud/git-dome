public class Animals {
    private int id;
    private String name;
    private int age;

    //定义一个无参的构造方法用于子类创建无参构造方法 自行去set变量的值
    public Animals() {

    }

    /*定义三参构造方法,用来初始化时直接赋值使用
    例如 Animals a1 = new Animals( 5 , 老鼠(Mouse) , 3)*/
    public Animals(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    //下面是set设置和get获取变量值的方法
    //set用于使用无参构造方法时去设置变量值
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*以下是父类里的三个方法，分别是移动吃和自我介绍子类待会会重写这几个方法
     * 所谓重写: 即是方法名相同，参数相同只是在父类的基础上加上子类的特征*/
    public void move() {
        System.out.println(name + "可以移动");
    }

    public void eat() {
        System.out.println(name + "可以吃东西");
    }

    public void introduction() {
        System.out.println("大家好我是" + id + "号" + name + "我今年" + age + "岁了");
    }
}


//动物类子类之一    (老鼠)
class Mouse extends Animals {
    //无参构造方法 ， 用get方法赋值
    public Mouse() {

    }

    public Mouse(int id, String name, int age) {
        super(id, name, age);//调用父类的三参数构造方法初始化时赋值
    }

    //重写父类的三个方法 此时name id age 内容已变成老鼠的值
    public void move() {
        System.out.println("老鼠跑的很快很快");
    }

    public void eat() {
        System.out.println("老鼠喜欢吃大米饭");
    }
}


//动物类子类之一  (兔子)
class Rabbit extends Animals {
    ///无参构造方法 用于set自行设置
    public Rabbit() {

    }

    public Rabbit(int id, String name, int age) {
        super(id, name, age); //三参构造方法还没赋值用于初始化时赋值
    }

    //父类方法的重写
    public void move() {
        System.out.println("兔子是蹦蹦跳跳的");
    }

    public void eat() {
        System.out.println("兔子喜欢吃胡罗卜");
    }

}

class AnimalsTest{
    public static void main(String[] args) {
        //调用无参构造方法自行get变量值
        Animals a1 = new Animals();
        a1.setAge(5);
        a1.setId(1);
        a1.setName("动物");
        a1.introduction();
        //动物的两个方法(重写之前的)
        a1.eat();
        a1.move();


        //调用老鼠三参构造方法直接初始化变量值
        Mouse m1 = new Mouse(2, "Tom" , 6);
        m1.introduction();
        //老鼠的两个方法(重写之后的)
        m1.eat();
        m1.move();

        //调用兔子三参构造方法直接初始化变量值
        Rabbit r1 = new Rabbit(3, "白白" , 8);
        r1.introduction();
        //兔子的两个方法(重写之后的)
        r1.eat();
        r1.move();

    }
}

