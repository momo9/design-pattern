package command;

public class Fan {
    private String speed;
    public Fan() {
        setOff();
    }
    public void setOff() {
        speed = "off";
    }
    public void setLow() {
        speed = "low";
    }
    public void setMedium() {
        speed = "medium";
    }
    public void setHigh() {
        speed = "high";
    }
    public String getSpeed() {
        return speed;
    }
    
    @Override
    public String toString() {
        return String.format("Fan: speed is %s", speed);
    }
}
