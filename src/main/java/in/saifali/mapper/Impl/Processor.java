package in.saifali.mapper.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import in.saifali.mapper.annotations.FieldMapper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Processor {
    Gson gson = new Gson();
    Map<Object, Object> dtoMap = new HashMap<>();
    Map<Object, Object> objectMap = new HashMap<>();
    public <T> T map(Class<T> t, Object object) {
        try {
            T returnClass = t.newInstance();
            for (Field field : returnClass.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(FieldMapper.class)) {
                    dtoMap.put(field.getName(), field.getAnnotation(FieldMapper.class).field());
                }else{
                    dtoMap.put(field.getName(), field.getName());
                }
            }
            objectMap = gson.fromJson(gson.toJson(object), new TypeToken<HashMap<Object, Object>>() {
            }.getType());
            dtoMap.forEach((x, y) -> dtoMap.put(x, objectMap.get(y)));
            String json = gson.toJson(dtoMap);
            return gson.fromJson(json, t);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}
