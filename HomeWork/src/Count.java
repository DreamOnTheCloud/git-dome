public class Count {
    private String name;
    public static int count;


    //构造方法
    public Count(String name) {
        this.name = name;


    }

    public void setName(int count) {
        this.name = name;
    }

    public int getname() {
        return count;
    }

    public void Start() {
        count++;
        if (count <= 4) {
            System.out.println(name + "来了但是人不够");

        } else {
            System.out.println("够了");

        }
    }


}

class st {
    public static void main(String[] args) {
        Count c1 = new Count("张三");
        Count c2 = new Count("李四");
        Count c3 = new Count("王五");
        Count c4 = new Count("马六");
        Count c5 = new Count("张宇");
        c1.Start();
        c2.Start();
        c3.Start();
        c4.Start();
        c5.Start();
    }

}




