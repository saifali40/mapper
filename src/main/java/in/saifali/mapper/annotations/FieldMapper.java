package in.saifali.mapper.annotations;


import java.lang.annotation.*;


/**
 * @author saif
 *
 * Annotate the {@link FieldMapper} to the fields which has different field name in main Model to your DTO
 *
 */


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldMapper {
    String field();
}
