package command;

public class FanMediumCommand extends FanCommand {

    public FanMediumCommand(Fan fan) {
        super(fan);
    }

    @Override
    public void setSpeed() {
        fan.setMedium();
    }

}
