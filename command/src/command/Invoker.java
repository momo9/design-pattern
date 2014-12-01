package command;

public class Invoker {
    protected Command[] cmd;
    protected Command preCmd;
    
    public Invoker() {
        cmd = new Command[5];
        for (int i = 0; i < cmd.length; ++i) {
            cmd[i] = new NoCommand();
        }
        preCmd = new NoCommand();
    }
    
    public void setCommand(int index, Command cmd) {
        this.cmd[index] = cmd;
    }
    public void press(int index) {
        cmd[index].excute();
        preCmd = cmd[index];
    }
    public void undo() {
        preCmd.undo();
    }
}
