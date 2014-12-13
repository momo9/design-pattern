package remote;

public class MonitorLocB extends MonitorBase {

    public MonitorLocB() {
        super("loc-b");
    }

    public static void main(String[] args) {
        register(new MonitorLocB(), 11011);
    }
    
}
