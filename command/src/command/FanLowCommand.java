package command;

public class FanLowCommand extends FanCommand {

    public FanLowCommand(Fan fan) {
        super(fan);
    }

    @Override
    public void setSpeed() {
        fan.setLow();
    }

}
