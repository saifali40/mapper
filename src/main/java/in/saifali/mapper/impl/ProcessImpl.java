package in.saifali.mapper.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import in.saifali.mapper.annotations.FieldMapper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ProcessImpl  {


    Gson gson = new Gson();
    Map<Object, Object> dtoMap = new HashMap<>();
    Map<Object, Object> objectMap = new HashMap<>();

    /**
     * Using to do forward action where the Model to @Mapper Annotated field
     * @param object
     * @param returnClass
     * @return
     */
    protected String forwardAction(Object object, Class<? extends Object> returnClass) {
        return mapAction(object, returnClass, true);
    }

    /**
     *
     * Using for reverse Mapping where @Mapper Annotated to Model
     * @param object
     * @param returnClass
     * @return
     */
    protected String reverseAction(Object object, Class<? extends Object> returnClass) {
        return mapAction(object, returnClass, false);
    }

    private String mapAction(Object object, Class<? extends Object> returnClass, Boolean isForward) {

        for (Field field : returnClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(FieldMapper.class)) {
                if (isForward)
                    forwardMapper(field);
                else
                    reverseMapper(field);
            } else {
                dtoMap.put(field.getName(), field.getName());
            }
        }

        objectMap = gson.fromJson(gson.toJson(object), new TypeToken<HashMap<Object, Object>>() {
            private static final long serialVersionUID = 5621227363389228895L;
        }.getType());
        dtoMap.forEach((x, y) -> dtoMap.put(x, objectMap.get(y)));
        return gson.toJson(dtoMap);
    }

    private void forwardMapper(Field field) {
        dtoMap.put(field.getName(), field.getAnnotation(FieldMapper.class).field());
    }

    private void reverseMapper(Field field) {
        dtoMap.put(field.getAnnotation(FieldMapper.class).field(), field.getName());
    }

}
