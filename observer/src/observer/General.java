package observer;

import java.util.Observable;
import java.util.Observer;

public class General implements Observer {

    private Observable subject;
    
    public General(Observable subject) {
        this.subject = subject;
    }
    
    public void register() {
        this.subject.addObserver(this);
    }
    
    public void unRegister() {
        this.subject.deleteObserver(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }

}
