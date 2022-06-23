package util.test;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

public class RefTest {

    @Test
    void test() {
        User u = new User();
        u.a = 1;
        setU(u);
        System.out.println(u.a);
    }

    public void setU(User u) {
        u.a = 2;
    }

    @Getter
    @Setter
    static class User {

        private int a;
    }
}
