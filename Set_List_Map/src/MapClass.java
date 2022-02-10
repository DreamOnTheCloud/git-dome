import java.util.*;
class Student{
    private String name;
    private String id;
    private int age;
    public Student(String id,String name,int age){
        this.name=name;
        this.id=id;
        this.age= age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "id:"+this.id+"name:"+this.name+"age:"+this.age;
    }
}
class SavaStudent{
    public static void main(String args[]) {
        //1.用list存储学生id，name和age信息，并在控制台输出。
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("1001", "张三", 24));
        studentArrayList.add(new Student("1002", "张四", 21));
        studentArrayList.add(new Student("1003", "张五", 22));
        System.out.println("ArrayList:");
        Iterator<Student> iterator = studentArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        System.out.println("LinkedList:");
        LinkedList<Student> studentLinkedList = new LinkedList<>(studentArrayList);
        //有参构造方法：将studentArrayList的全部元素当做studentLinkList的初值
        for (Student student : studentLinkedList) {
            System.out.println(student);
        }

        //2.用map存储学生信息，id为key，学生对象为value，建立映射关系。并在控制台输出学生信息。
        HashMap<String, Student> studentHashMap = new HashMap<>();
        System.out.println("HashMap:");
        Iterator<Student> iterator2 = studentArrayList.iterator();
        while (iterator2.hasNext()) {
            Student temp = iterator2.next();
            studentHashMap.put(temp.getId(), temp);
        }
        System.out.println(studentHashMap); 
        for (String i : studentHashMap.keySet()) {
            System.out.println("key: " + i + " value: " + studentHashMap.get(i));
        }
    }
}


public class MapClass {
    public static void main(String args[]) {
        HashMap<String, Student> p1 = new HashMap<>();
        p1.put(new Student("1", "as", 12).getId(), new Student("1", "as", 12));
        for (String a : p1.keySet()) {
            System.out.println(a);
            System.out.println(p1.get(a));
        }
    }
}