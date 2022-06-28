package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO
public class Code10 {

    @Test
    public void test() {
        Assertions.assertFalse(isMatch("aa", "p"));
    }

    @Test
    public void test1() {
        Assertions.assertTrue(isMatch("aa", "a*"));
    }

    @Test
    public void test2() {
        Assertions.assertTrue(isMatch("ab", ".*"));
    }

    @Test
    public void test3() {
        Assertions.assertFalse(isMatch("aa", "a"));
    }

    @Test
    public void test4() {
        Assertions.assertFalse(isMatch("ab", ".*c"));
    }

    @Test
    public void test5() {
        Assertions.assertFalse(isMatch("aab", "c*a*b"));
    }


    Map<Integer, List<Character>> map = new HashMap<>();

    public boolean isMatch(String s, String p) {
        charAt(p, s.length() + p.length());
        for (int j = 0; j < p.length(); j++) {

            char s1 = s.charAt(0);
            char p1 = p.charAt(j);

            if (s1 == p1 || p1 == '.') {
                boolean check = check(s, p, j);
                if (check) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(String s, String p, int index) {
        for (int i = 0; i < s.length(); i++) {
            List<Character> characters = charAt(p, index + i);
            if (!characters.contains(s.charAt(i)) && !characters.contains('.')) {
                return false;
            }
        }
        return true;
    }

    private List<Character> charAt(String p, int index) {

        if (p == null || p.isBlank() || p.length() == 0 || index < 0) {
            return new ArrayList<>();
        }

        List<Character> characters = map.get(index);
        if (characters != null) {
            return characters;
        }
        characters = new ArrayList<>();
        if (index == 0) {
            char c = p.charAt(0);
            switch (c) {
                case '.':
                default:
                    characters.add(c);
                case '*':
            }
        } else if (index < p.length()) {
            char c = p.charAt(index);
            switch (c) {
                case '.':
                default:
                    characters.add(c);
                case '*':
                    characters.addAll(charAt(p, index - 1));
            }

        } else if (index > p.length()) {
            char c = p.charAt(p.length() - 1);
            if (c == '*') {
                characters.addAll(charAt(p, p.length() - 1));
            }
        }
        map.put(index, characters);
        return characters;
    }


}
