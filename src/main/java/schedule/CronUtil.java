package schedule;

import lombok.Data;

import java.util.Arrays;
import java.util.BitSet;
import java.util.TimeZone;

@Data
public class CronUtil {

    private boolean hasYear = false;

    private BitSet second = new BitSet(60);

    private String minute;

    private String hour;

    private String dayOfMonth;

    private String month;

    private String dayOfWeek;

    private String year;

    private final TimeZone timeZone;

    public CronUtil(String expression) {
        this.timeZone = TimeZone.getDefault();
        this.parseExpression(expression);
    }

    public CronUtil(String expression, TimeZone timeZone) {
        if (timeZone == null) {
            throw new RuntimeException();
        }
        this.timeZone = timeZone;
        this.parseExpression(expression);
    }

    private void parseExpression(String expression) {
        assert expression != null;
        String[] s = expression.split(" ");
        if (s.length != 6 && s.length != 7) {
            throw new RuntimeException();
        }
        checkAndSetSecond(s[0]);
        this.minute = s[1];
        this.hour = s[2];
        this.dayOfMonth = s[3];
        this.month = s[4];
        this.dayOfWeek = s[5];
        if (s.length == 7) {
            this.hasYear = true;
            this.year = s[6];
        }

    }

    private void checkAndSetSecond(String second) {
        assert second != null;
        if (second.contains(",")) {
            String[] split = second.split(",");
            System.out.println(Arrays.toString(split));
        } else if (second.contains("-")) {
            String[] split = second.split("-");
            System.out.println(Arrays.toString(split));
        } else if (second.contains("*")) {
            if (!"*".equals(second)) {
                throw new RuntimeException("checkException");
            }
        } else if (second.contains("/")) {
            String[] split = second.split("/");
            System.out.println(Arrays.toString(split));
        } else {
            int integer = Integer.parseInt(second);
            this.second.set(integer);
        }


    }

    private void setField(BitSet bitSet, String[] strs) {

        for (String str : strs) {
            int index = Integer.parseInt(str);
            if (index < 0 || index >= bitSet.size()) {
                throw new RuntimeException("checkException");
            }
            bitSet.set(index);
        }
    }


    public static void main(String[] args) {

        String expression = "500 * * * * ?";

        CronUtil cronUtil = new CronUtil(expression);
        System.out.println(cronUtil);

    }

}
