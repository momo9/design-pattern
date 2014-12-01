package command;


public class MacroCommand implements Command {
    
    private Command[] cmds;
    
    public MacroCommand(Command[] cmds) {
        this.cmds = cmds;
    }

    @Override
    public void excute() {
        for (Command cmd : cmds) {
            cmd.excute();
        }
    }

    @Override
    public void undo() {
        for (Command cmd : cmds) {
            cmd.undo();
        }
    }

}
