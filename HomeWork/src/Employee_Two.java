import java.lang.invoke.SerializedLambda;
//Employee_Two此类为抽象类加abstract了，不可被实例化
public abstract class Employee_Two {
    //下面的是抽象类里的三个成员变量 private私有的
    private String name;
    private String address;
    private int id;

    //无参构造方法
    public Employee_Two() {

    }
    //三参构造方法
    public Employee_Two(String name, String address, int id) {
        this.name = name;
        this.address = address;
        this.id = id;
    }

    //使用无参构造方法时调用set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //抽象类里的抽象方法
    public abstract void mailCheck();

}

//子类全年工资类
class Salary extends Employee_Two {
    private double yearSalary;

    public Salary(String name, String address, int id, double yearSalary) {
        super(name, address, id);
        this.yearSalary = yearSalary;
    }

    public double getYearSalary() {
        return yearSalary;
    }

    public void setYearSalary(double yearSalary) {
        this.yearSalary = yearSalary;
    }

    public void computePay() {
        System.out.println(yearSalary / 12);
    }

    //重写抽象方法
    public void mailCheck() {
        System.out.println("全年工资为" + yearSalary);
        System.out.println("单月工资为" + yearSalary / 12);
    }

}

class TestEmployee_Two {
    public static void main(String[] args) {
        Salary s1 = new Salary("张三", "邯郸市", 2, 120000);
        s1.mailCheck();

    }


}
