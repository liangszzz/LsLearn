package book1;


import java.util.Stack;

public class book4_3_2 {
    /**
     * 括号匹配检测
     */
    public boolean bracketMatch(String str) {

        Stack<Character> stack = new Stack<>();
        for (char c:str.toCharArray()){
            switch (c){
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop()!='{'){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop()!='['){
                        return false;
                    }
                    break;
            }
        }
        return true;
    }


    public void test0() {
        System.out.println(bracketMatch("{XX}{oo[vv]}ccc"));
    }
}
