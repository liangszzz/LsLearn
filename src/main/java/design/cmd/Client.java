package design.cmd;

import design.cmd.cmds.HelpCmd;

public class Client {

    public static void main(String[] args) {

        Invoker invoker = new Invoker();

        HelpCmd helpCmd = new HelpCmd();
        helpCmd.setReceiver(new Receiver());

        invoker.setCommand(helpCmd);

        invoker.execute();

    }
}
