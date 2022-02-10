import java.text.SimpleDateFormat;
import java.util.*;

//21.11.10
class Student implements Comparable<Student>{
    private String id;
    private String name;
    private int age;

    public Student(String id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    public int getAge() {
        return this.age;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString(){
        return "id:"+this.id+" name:"+this.name+" age:"+this.age;
    }

    @Override
    public int compareTo(Student otherStudent){
        //重写compareTo方法 根据年龄升序排序
        return this.age-otherStudent.getAge();
    }

}
class Informetion{
    public static void main(String args[]) {
        //1.用list存储学生id，name和age信息，并在控制台输出。
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("1001", "张三", 24));
        studentArrayList.add(new Student("1002", "张四", 21));
        studentArrayList.add(new Student("1003", "张五", 22));
        System.out.println("ArrayList:");
        Iterator<Student> iterator = studentArrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("LinkedList:");
        LinkedList<Student> studentLinkedList = new LinkedList<>(studentArrayList);
        //有参构造方法：将studentArrayList的全部元素当做studentLinkList的初值
        for (Student student : studentLinkedList) {
            System.out.println(student);
        }

        //2.用map存储学生信息，id为key，学生对象为value，建立映射关系。并在控制台输出学生信息。
        HashMap<String,Student> studentHashMap = new HashMap<>();
        System.out.println("HashMap:");
        Iterator<Student> iterator2 = studentArrayList.iterator();
        while(iterator2.hasNext()){
            Student temp = iterator2.next();
            studentHashMap.put(temp.getId(),temp);
        }
        for(String i:studentHashMap.keySet()){
            System.out.println("key: "+ i +" value: "+studentHashMap.get(i));
        }

        //3.使用collections的sort方法对list排序。
        System.out.println("sort to ArrayList:");
        Collections.sort(studentArrayList);
        //自定义对象需要指明其排序方法 通过重写compareTo()方法 指定的排序方法为根据年龄升序排序
        System.out.println(studentArrayList);

        System.out.println("sort to LinkedList:");
        studentLinkedList.add(new Student("1005","精神小伙",16));
        System.out.println(studentLinkedList);
        Collections.sort(studentLinkedList);
        System.out.println(studentLinkedList);

        //4.练习使用Date，SimpleDateFormat，Calendar。
        //Date类
        Date today = new Date();    //无参构造方法
        System.out.println(today);

        long ms = today.getTime();
        Date otherToday = new Date(ms); //一个参(long)构造方法
        System.out.println(otherToday);

        //equals()方法被Date类重写 判断两个Data类对象的.getTime()返回的long值是否一致
        /**
         Java使用以下三种方法来比较两个日期：
         使用 getTime() 方法获取两个日期（自1970年1月1日经历的毫秒数值），然后比较这两个值。

         使用方法 before()，after() 和 equals()。例如，一个月的12号比18号早，
         则 new Date(99, 2, 12).before(new Date (99, 2, 18)) 返回true。
         使用 compareTo() 方法，它是由 Comparable 接口定义的，Date 类实现了这个接口。
         */
        System.out.println(today.equals(new Date(today.getTime())));
        System.out.println(today.before(new Date(today.getTime()+1)));
        System.out.println(today.after(new Date(today.getTime()-1)));

        //Calendar类
        /**
         获取Date对象的特定部分 Calendar是一个抽象类
         Calender的月份是从0开始的 日期和年份都是从1开始的
         */
        Calendar calendar = Calendar.getInstance(); //创建一个代表系统当前日期的calendar对象

        Calendar cal = Calendar.getInstance();
        cal.set(2001, 2,3,4,5);
        /**
         .set(int year,int month,int date) 设置年、月、日
         .set(int year,int month,int date,hourOfDay int,int minute) 设置年、月、日、小时、分钟
         .set(int year,int month,int date,hourOfDay int,int minute,int second) 设置年、月、日、小时、分钟、秒
         */
        System.out.println(cal.get(Calendar.YEAR)+" "+ cal.get(Calendar.MONTH)+" "+cal.get(Calendar.DATE));
        //.get()返回日历指定字段的值 返回了年份 月份 日期
        cal.setTime(new Date()); //将当前时间给cal日历重新赋值
        System.out.println(cal.get(Calendar.YEAR)+" "+ cal.get(Calendar.MONTH)+" "+cal.get(Calendar.DATE));

        cal.add(Calendar.YEAR,1); //为日历指定字段增加或减少值 若减少则参数2为-n
        //年份+1
        cal.add(Calendar.MONTH,-2);
        //月份-2
        System.out.println(cal.get(Calendar.YEAR)+" "+ cal.get(Calendar.MONTH)+" "+cal.get(Calendar.DATE));

        //simpleDateFormat类
        Date now = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(formatDate.format(now));

        //Random类
        Random myRandom = new Random();
        for (int i = 0; i <= 20; i++) {
            //double x = myRandom.nextDouble();
            //System.out.println(x);
            System.out.print((int) ( myRandom.nextDouble()*10 + 1) + " "); //与Math.random()类似返回 [0,1)范围浮点数
        }
        System.out.println();

        for(int i = 0;i<=20;i++) {
            System.out.print((int) (Math.random() * 10 + 1)+" ");//int(rnd()*(上-下+1)+下
        }
        System.out.println();

        for (int i = 0; i <= 20; i++) {
            System.out.print(myRandom.nextInt(10 + 1) + " ");
        }
        System.out.println();
        /**
         ①随机数是种子经过计算生成的。
         ②Random类中不含参的构造函数每次都是使用当前时间作为种子，随机性更强；而含参数的构造函数是以参数为种子产生的伪随机数，更有可预见性。
         ③具有相同种子值的Random对象生成的随机数相同；种子值不同，产生的随机数不再一致。
         Math.random()方法中内部调用的方法就是Random类中的nextDouble()方法。
         */

    }

    private static class var {
    }
}
