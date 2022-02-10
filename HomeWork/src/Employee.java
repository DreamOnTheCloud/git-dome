public class Employee {
    private int id;
    private String name;
    private double salary;

    //无参构造方法用于set自行设置变量值
    public Employee() {

    }
    //三参构造方法用于初始化变量值
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;}

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //涨工资方法百分之十
    public double raiseSalary(double bycerbent){
        double raise = salary * bycerbent / 100;
        salary += raise;
        return salary;
    }

}

class TestEmployee{
    public static void main(String[] args) {
        Employee e1 = new Employee(1  , "张三" , 10000);
        System.out.println(e1.getId() + "号程序员" + e1.getName() + "工资" + e1.getSalary());
        System.out.println("涨完后工资为" + e1.raiseSalary(20));
    }
}


