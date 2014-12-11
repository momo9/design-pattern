package proxy;

import java.lang.reflect.InvocationHandler;

public abstract class ConfigItemHandler implements InvocationHandler {

    protected ConfigItem ci;
    
    public ConfigItemHandler(ConfigItem ci) {
        this.ci = ci;
    }

}
