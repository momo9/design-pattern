package state;

public class PreState extends State {

    public PreState(Machine machine) {
        super(machine);
    }
    
    

    @Override
    public String pay(double money) {
        String ret = money + " paid, ";
        machine.incMoney(money);
        ret = ret + machine.getMoney() + " in total";
        if (machine.enough()) {
            ret = ret + ", enough";
            try {
                machine.setState("toConfirm");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    @Override
    public String cancel() {
        return machine.rollback();
    }

    @Override
    public String confirm() {
        double left = machine.getLeft();
        return "not enough money, need " + left + " more";
    }

}
