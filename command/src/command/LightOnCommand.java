package command;

public class LightOnCommand implements Command {
    
    private Light light;
    
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void excute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }

}
