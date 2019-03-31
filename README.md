# mapper

Light weight mapper for models to DTO without using any constructor or the setters, easily map to new modesl with annotations 

### Example

```
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
```
Mapping use the following helper

```
TestDTO dto = new in.saifali.mapper.Impl.Processor().map(TestDTO.class, model);
```

Please follow the test case for more information

#### Dependency
[Gson Library](https://mvnrepository.com/artifact/com.google.code.gson/gson)
Which one to convert The Model which is passed.

#### License
See the [LICENSE](https://github.com/saifali40/mapper/blob/master/LICENSE) file for license rights and limitations (Apache).
