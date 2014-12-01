package command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class FanCommand implements Command {

    protected Fan fan;
    protected String preSpeed = null;
    
    public FanCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void undo() {
        String methodName = 
            "set" + 
            Character.toUpperCase(preSpeed.charAt(0)) +
            preSpeed.substring(1);
        try {
            Method method = Fan.class.getMethod(methodName);
            method.invoke(fan);
            System.out.println(fan);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excute() {
        preSpeed = fan.getSpeed();
        setSpeed();
        System.out.println(fan);
    }
    
    protected abstract void setSpeed();
}
