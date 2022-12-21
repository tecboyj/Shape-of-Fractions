package Testing;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Testing {
    public static void main(String[] args) {
        BigDecimal x = new BigDecimal(1);
        BigDecimal y = new BigDecimal(14);
        BigDecimal value = x.divide(y, 64, RoundingMode.DOWN);
        System.out.println(value);
    }
}
