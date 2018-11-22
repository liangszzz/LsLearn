import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public void test0(){

        BigDecimal bigDecimal=new BigDecimal(1289.99d);
        BigDecimal val=BigDecimal.valueOf(1289.99d);

        System.out.println(bigDecimal.doubleValue());
    }
}
