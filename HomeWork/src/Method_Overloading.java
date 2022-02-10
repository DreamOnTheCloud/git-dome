public class Method_Overloading {
    public int test(int num1, int num2) {
        return num1 + num2;
    }

    public double test(double num1, double num2) {
        return num1 + num2;
    }

    public int test(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    public double test(double num1, double num2, double num3) {
        return num1 + num2 + num3;
    }
}

class Max {
    public int max(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }

    public double max(double num1, double num2) {
        return num1 > num2 ? num1 : num2;
    }
}

class test {
    public static void main(String[] args) {
        Method_Overloading m1 = new Method_Overloading();
        System.out.println(m1.test(10, 20));
        System.out.println(m1.test(20.6, 20.1));
        System.out.println(m1.test(10.6, 20.88, 12.3));
        System.out.println(m1.test(10, 20, 30));
        Max n1 = new Max();
        System.out.println(n1.max(50, 100));
        System.out.println(n1.max(50.99, 50.88));


    }
}
