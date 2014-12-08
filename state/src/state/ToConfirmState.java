package state;

public class ToConfirmState extends State {

    public ToConfirmState(Machine machine) {
        super(machine);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String cancel() {
        return machine.rollback();
    }

    @Override
    public String confirm() {
        // TODO Auto-generated method stub
        return null;
    }

}
