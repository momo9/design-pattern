package remote;

public class MonitorLocA extends MonitorBase {
    
    public MonitorLocA() {
        super("loc-a");
    }

    public static void main(String[] args) {
        register(new MonitorLocA(), 2000);
    }
    
}
