package code;

import org.junit.Test;

/**
 * 将一个字符由小写字母转换为大写字母
 */
public class lowercaseToUppercase {

    @Test
    public void test0() {
        System.out.println(lowercaseToUppercase('a'));
    }

    public char lowercaseToUppercase(char character) {
        // write your code here
        return Character.toUpperCase(character);
    }
}
