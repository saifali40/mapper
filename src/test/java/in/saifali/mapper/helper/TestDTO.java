package in.saifali.mapper.helper;

import in.saifali.mapper.annotations.FieldMapper;

public class TestDTO {


    @FieldMapper(field="field1")
    public String testField1;

    @FieldMapper(field="field2")
    public String testField2;

    @FieldMapper(field="field3")
    public String testField3;

    @FieldMapper(field="field4")
    public Integer testField4;


    public Integer field5;

}
