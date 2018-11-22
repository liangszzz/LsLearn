package book1;

import org.junit.Test;

import java.util.Stack;

/**
 * 汉罗塔
 */
public class book5_3 {

    final int n=4;
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();
    Stack<Integer> stack3=new Stack<>();

    @Test
    public void test0(){
        init();
        System.out.println(stack1.toString());
        System.out.println(stack2.toString());
        System.out.println(stack3.toString());
        System.out.println("--------------------------");
        moveByBuff(n,stack1,stack2,stack3);
    }


    private void init(){
        for (int i=n;i>0;i--){
            stack1.push(i);
        }
    }


    public void moveByBuff(int number,Stack<Integer> from,Stack<Integer> buffer,Stack<Integer> to){
        //先判断from的数量,如果只有1
        if (number==1){
            to.push(from.pop());
        }
        else {
            moveByBuff(number-1,from,to,buffer);
            to.push(from.pop());
            moveByBuff(number-1,buffer,from,to);
        }
        System.out.println("--------------------------");
        System.out.println(stack1.toString());
        System.out.println(stack2.toString());
        System.out.println(stack3.toString());
    }
}
