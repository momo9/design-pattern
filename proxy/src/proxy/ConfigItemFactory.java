package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ConfigItemFactory {

    static public ConfigItem createOwnerProxy(String name, String content) {
        ConfigItem ci = new ConfigItemImpl(name, content);
        return createProxy(ci, new OwnerHandler(ci));
    }
    
    static private ConfigItem createProxy(ConfigItem ci, InvocationHandler handler) {
        return (ConfigItem) Proxy.newProxyInstance(
                ci.getClass().getClassLoader(),
                ci.getClass().getInterfaces(),
                handler);
    }
    
    static public ConfigItem createNormalProxy(String name, String content) {
        ConfigItem ci = new ConfigItemImpl(name, content);
        return createProxy(ci, new NormalHandler(ci));
    }
    
}
