package observer;

import java.util.Observable;

public class Data extends Observable {
    private int data;

    public void setData(int data) {
        this.data = data;
        setChanged();
        notifyObservers(this.data);
    }
    
}
