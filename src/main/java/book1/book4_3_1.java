package book1;


import java.util.ArrayList;
import java.util.List;

public class book4_3_1 {

    /**
     * 进制转换
     * @param number 10进制数值
     * @param hex N 进制 如2
     */
    public void convert(int number,int hex){

        List<Integer> list=new ArrayList<>();

        while (number>0){
            list.add(number%hex);
            number=number/hex;
        }

        for (int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i));
        }
    }


    public void test0(){
        convert(2007,8);
    }
}
