package command;

public class FanHighCommand extends FanCommand {

    public FanHighCommand(Fan fan) {
        super(fan);
    }

    @Override
    public void setSpeed() {
        fan.setHigh();
    }

}
