public class Person {
    /*父类大类 Person人类，三个私有的成员变量，下面又是两个构造方法
     一个是无参的，一个是包含三个参数  三个参数的传进来的值对应成员变量的值
     再下面是自定义设置成员变量的方法set 和返回所设置的值 get 方法
     若使用无参数构造方法，才需用set和get设置变量的值，否则直接初始化值即可
     最后设置初值统一用 get 方法输出对应值*/
    private String name;
    private int id;
    private int age;

    public Person() {

    }

    public Person(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {this.id = id;}

    public int getId() {
        return id;
    }
}

/*下面是学生类 继承了上面的人类 extends Person 再给出父类之外的两个字符串类型的成员变量
  calsses班级 和 garden年级 加以设置*/
class Students extends Person {
    private String classes;
    private String grade;

    //无参的构造方法1，用于set设置和get取值
    public Students() {

    }

    //三参的构造方法2 调用的是上面的三个参数的父类构造方法，直接初始化值
    public Students(int id, String name, int age) {
        super(name , id , age);
    }

    //五参的构造方法2 调用的是上面的三个参数的父类构造方法，加上两个自定义的的初始值
    public Students(int id, String name, int age, String classes, String grade) {
        super(name , id , age);
        this.grade = grade;
        this.classes = classes;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}

/*下面是教师类 同样继承了上面的人类 extends Person 再给出父类之外的一个字符串类型的成员变量
  office所属办公室 加以设置*/
class Teacher extends Person {
    private String office;

    //无参构造方法1 用于set设置和get取值
    public Teacher() {

    }

    //三参构造方法2 调用父类直接初始化值
    public Teacher(String name, int id, int age) {
        super("王刚", 555666, 36);
    }

    //四参构造方法3 三个调用父类直接初始化值office 自行设置
    public Teacher(String name, int id, int age, String office) {
        super(name , id , age);
        this.office = office;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

}

class PeronTest{
    public static void main(String[] args) {
        //父类人类的实例化对象1 ， 对应的是那三个参数的构造方法
        Person p1 = new Person("张宇" , 1 , 20);
        System.out.println(p1.getId() + "号" + p1.getName() + p1.getAge() + "岁");

        //子类学生类的实例化对象1 调用的是那个五个参数的构造方法并直接初始化值
        Students s1 = new Students(1 , "张三" , 10 , "三班" , "五年级");
        System.out.println(s1.getId() + "号" + s1.getName() + s1.getAge() + "岁" + "来自" + s1.getClasses() + s1.getGrade());

        //子类教师类的实例化对象1 调用的是那个四个参数的构造方法并直接初始化值
        Teacher t1 = new Teacher("王刚" , 000555 , 39 , "知海楼");
        System.out.println(t1.getId() + "号教师" + t1.getName() + "年龄:" + t1.getAge() + "来自" + t1.getOffice());

        //此对象调用了父类三个参数的构造方法，班级与年级都是用set方法自己设置的
        Students s2 = new Students(5 , "张三",10);
        s2.setClasses("8班");
        s2.setGrade("六年级");
        System.out.println(s2.getId() + "号" + s2.getName() + s2.getAge() + "岁" + "来自" + s2.getClasses() + s2.getGrade());

    }
}
