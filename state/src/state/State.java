package state;

public abstract class State {
    
    protected Machine machine;
    
    public State(Machine machine) {
        this.machine = machine;
    }
    
    public String pay(double money) {
        machine.incMoney(money);
        return machine.rollback();
    }
    public String cancel() {
        return "nothing";
    }
    public String confirm() {
        return "nothing";
    }
    public String get() {
        return "nothing";
    }
}
