package in.saifali.mapper.impl;

import java.lang.reflect.InvocationTargetException;

public class Processor extends ProcessImpl{


    public <T> T map(Class<T> t, Object object)
            throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class<? extends Object> returnClass = t.getDeclaredConstructor().newInstance().getClass();
        return gson.fromJson(forwardAction(object, returnClass), t);
    }

    public <T> T reverse(Class<T> t, Object object) {
        Class<? extends Object> returnClass = object.getClass();
        return gson.fromJson(reverseAction(object, returnClass), t);
    }

}
