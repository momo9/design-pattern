package state;

public class OkState extends State {

    public OkState(Machine machine) {
        super(machine);
    }

    @Override
    public String get() {
        try {
            machine.setState("pre");
        } catch (NoSuchFieldException | SecurityException
                | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return "get the juice";
    }
    
}
