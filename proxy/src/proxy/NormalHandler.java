package proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NormalHandler extends ConfigItemHandler {

    public NormalHandler(ConfigItem ci) {
        super(ci);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (method.getName().startsWith("set")) {
            throw new IllegalAccessException();
        } else {
            return method.invoke(ci, args);
        }
    }

}
