import java.math.*;
public class MathClass {
    public static void main(String[] args) {
        double d = 45.225;
        BigDecimal d1 = new BigDecimal(d);
        d1.setScale(2,RoundingMode.HALF_UP).doubleValue();
        System.out.println(d1);

        double a = 23.5658;

    }
}
