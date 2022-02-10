package Exception异常处理.Exception异常处理;
import java.util.*;//此语句是引入一个包，用于实例化对象
public class Collection接口 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();//实例化集合类对象
        list.add("a");//添加数据到集合List里面
        list.add("b");
        list.add("c");
        Iterator<String> it = list.iterator();//创建迭代器
        while (it.hasNext()){   //判断是否有下一个元素
            String str = (String) it.next(); //获取集合中的元素
            System.out.println(str);
        }
    }
}

class list集合类{
    public static void main(String[] args) {
        //父类向下引用指向子类实例化对象
        List<String> l1 = new ArrayList<>();//创建实现类ArrayList，访问速度快但是插入删除对象的速度慢
        List<String> l2 = new LinkedList<>();//创建实现类ArrayLinkedList，访问速度慢插入删除对象速度慢
        l1.add("张宇1");
        l1.add("张宇2");
        l1.add("张宇3");
        int i = (int)(Math.random()*l1.size());//获取0-2之间的索引位置随机获取一个元素的位置
        System.out.println("根据索引位置随机获取数组中的元素" + l1.get(i));
        l1.remove(2);
        System.out.println("将索引是2的元素下标元素删除掉");
        System.out.println("将索引为'2'的元素删除后，数组的变化");
        for (String j : l1){
            System.out.println(j);
        }
    }
}

class Hashset集合类{
    public static void main(String[] args) {
        /*可以看出HashSet是一种可以传任意类型的无序集合它的特点同时还有
        * 无重复，可传空值null,如需集合内的值同一类型，那么添加范式*/
        HashSet H1 = new HashSet();
        H1.add("张宇01");
        H1.add("张宇01");
        H1.add("张宇02");
        H1.add("张宇03");
        H1.add("张宇04");
        H1.add("张宇05");
        H1.add("张宇05");
        H1.add(666);
        H1.add(777);
        System.out.println(H1);
        System.out.println(H1.contains(777));//判断某值是否在某集合内
        H1.remove(777);//删除remove
        System.out.println(H1);
        System.out.println(H1.size());//集合长度size
        H1.clear();//清空集合全部元素
    }
}


class Friend{
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<String>();
        Set<String> s2 = new HashSet<String>();
        s1.add("张三");
        s1.add("李四");
        s2.add("张三");
        s2.add("王五");
        s1.addAll(s2);
        System.out.println(s1);//合并两个集合，相同元素自动抹除，只打印一个张三
    }
}

class TreeOne{
    public static void main(String[] args) {
        Set s1 = new TreeSet();//Set的子类与HashSet同级，可自动排序
        s1.add(1);
        s1.add(5);
        s1.add(6);
        s1.add(100);
        s1.add(88);
        System.out.println(s1);//排序后的集合
    }
}


