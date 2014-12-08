package state;

public class ToConfirmState extends State {

    public ToConfirmState(Machine machine) {
        super(machine);
    }

    @Override
    public String cancel() {
        return machine.rollback();
    }

    @Override
    public String confirm() {
        String ret = machine.changeFund();
        ret = ret + ", begin to make";
        try {
            machine.setState("ok");
        } catch (NoSuchFieldException | SecurityException
                | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return ret;
    }

}
