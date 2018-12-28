package design.chain;

import design.chain.handles.FatherHandle;
import design.chain.handles.MotherHandle;

public class Client {

    public static void main(String[] args) {

        MotherHandle motherHandle = new MotherHandle();
        FatherHandle fatherHandle = new FatherHandle();

        motherHandle.setNext(fatherHandle);

        motherHandle.execute(2);

    }
}
