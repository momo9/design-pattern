package state;

public abstract class State {
    
    protected Machine machine;
    
    public State(Machine machine) {
        this.machine = machine;
    }
    
    public String pay(double money) {
        return "refund " + money;
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
