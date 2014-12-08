package state;

import java.lang.reflect.Field;

public class Machine {
    private double money = 0.0;
    private double price;
    
    private State state;
    private State preState = new PreState(this);
    private State toConfirmState = new ToConfirmState(this);
    private State okState = new OkState(this);
    
    public Machine(double price) {
        this.price = price;
        state = preState;
    }
    
    boolean enough() {
        return money >= price;
    }
    
    String refund() {
        String ret = "refund " + money;
        money = 0.0;
        return ret;
    }
    
    String rollback() {
        String ret = refund();
        state = preState;
        return ret;
    }
    
    void setState(String stateName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        stateName += "State";
        Field field = this.getClass().getDeclaredField(stateName);
        this.state = (State) field.get(this);
    }
    
    void incMoney(double inc) {
        this.money += inc;
    }

    double getMoney() {
        return money;
    }
    
    double getLeft() {
        return price - money;
    }
    
    public String pay(double money) {
        return state.pay(money);
    }
    
    public String get() {
        return state.get();
    }
    
    public String confirm() {
        return state.confirm();
    }
    
    public String cancel() {
        return state.cancel();
    }
    
}
