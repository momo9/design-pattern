package command;


public class FanOffCommand extends FanCommand {
    
    public FanOffCommand(Fan fan) {
        super(fan);
    }

    @Override
    public void setSpeed() {
        fan.setOff();
    }

}
