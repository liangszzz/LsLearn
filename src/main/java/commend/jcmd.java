package commend;

import com.beust.jcommander.JCommander;

/**
 * java command jar learn
 */
public class jcmd {

    public static void main(String[] args) {
        Args arg1 = new Args();
        JCommander.newBuilder().addObject(arg1).build().parse(args);
        System.out.println(arg1);
    }
}
