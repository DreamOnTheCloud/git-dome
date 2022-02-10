package PersonPackage;
//创建抽象类Person
abstract class Person {
    private String name;
    private String sex;
    private int age;
    //无参构造方法，用于set设置和get获取成员变量时使用
    public Person(){

    }
    //三参构造方法，用于实例化对象时赋值
    public Person(String name , String sex , int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    //一系列set和get方法用于设置和获取成员变量
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public String getSex(){
        return sex;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    //定义抽象方法用于子类重写时实现
    public abstract void work();
}

//定义学生类继承Person方法
class Student extends Person{
    //定义属于子类特有的成员变量school
    private String school;

    //子类无参构造方法
    public Student (){

    }

    //子类全参数构造方法
    public Student (String name , String sex , int age , String school){
        super(name , sex , age);
        this.school = school;
    }

    //子成员变量的设置获取方法
    public void setSchool(String school){
        this.school = school;
    }

    public String getSchool(){
        return school;
    }

    //重写父类的抽象方法
    public void work(){
        System.out.println("姓名:" + getName() + "\n性别:" + getSex()
                + "\n年龄:" + getAge() + "\n学校" + getSchool());
    }
}

//学生类的实现类(实例化一个学生)
class test{
    public static void main(String[] args) {
        Person s = new Student("张宇" , "男" , 20 , "石家庄信息工程职业学院");
        s.work();
    }
}























