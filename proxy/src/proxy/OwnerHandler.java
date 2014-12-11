package proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OwnerHandler extends ConfigItemHandler {
    
    public OwnerHandler(ConfigItem ci) {
        super(ci);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return method.invoke(ci, args);
    }

}
