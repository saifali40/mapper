package in.saifali.mapper.impl;

import java.lang.reflect.InvocationTargetException;

public class Processor extends ProcessImpl{


    /**
     *
     * @param t {@link Class} Classname that going to return the object // Basically DTO
     * @param object ClassObject that going to be mapped to t
     * @return t
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    public <T> T map(Class<T> t, Object object)
            throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class<? extends Object> returnClass = t.getDeclaredConstructor().newInstance().getClass();
        return gson.fromJson(forwardAction(object, returnClass), t);
    }

    /**
     *
     * @param t {@link Class} Classname that going to return the object // Basically the model
     * @param object ClassObject that going to be mapped to t // DTO
     * @param <T>
     * @return
     */
    public <T> T reverse(Class<T> t, Object object) {
        Class<? extends Object> returnClass = object.getClass();
        return gson.fromJson(reverseAction(object, returnClass), t);
    }

}
