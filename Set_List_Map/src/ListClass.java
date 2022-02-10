import java.util.*;
class Person666{
//    三个成员变量私有的private
    private String name;
    private int age;
    private String id;
//    创建无参的构造方法
    public Person666(){
//    无参构造方法用于get方法设置过
    }
    public Person666(String name,int age,String id){
//    构造方法用于实例化对象时使用
        this.name=name;
        this.age=age;
        this.id=id;
    }

    //以下是上面三个私有变量的设置和获取方法
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
//     设置一个格式化输出方法用于存值
    public String toString(){
//     printf表示格式化输出
//     在本类里面使用this.name等表示引用本类的此变量
        System.out.printf("name: %s age: %d id:%s",this.name,this.age,this.id);
        return null;
    }
}

public class ListClass {
    public static void main(String args[]) {
        ArrayList<Person666> persons = new ArrayList<>();
        persons.add(new Person666("张三",1,"1001"));
        persons.add(new Person666("张四",2,"1002"));
        persons.add(new Person666("张五",3,"1003"));
        Iterator it = persons.iterator();
        while (it.hasNext()){
            it.next().toString();
            System.out.println();
        }
    }
}
