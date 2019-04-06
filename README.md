# mapper
[![Build Status](https://travis-ci.org/saifali40/mapper.svg?branch=master)](https://travis-ci.org/saifali40/mapper)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=saifali40_mapper&metric=alert_status)](https://sonarcloud.io/dashboard?id=saifali40_mapper)

[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=saifali40_mapper)](https://sonarcloud.io/dashboard?id=saifali40_mapper)


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
