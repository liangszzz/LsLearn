package design.cmd.cmds;

import design.cmd.Command;
import design.cmd.Receiver;

public class HelpCmd implements Command {

    private Receiver receiver;

    @Override
    public void execute() {
        receiver.doSomething();
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}
