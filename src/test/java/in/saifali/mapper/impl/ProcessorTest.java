package in.saifali.mapper.impl;


import in.saifali.mapper.helper.TestDTO;
import in.saifali.mapper.helper.TestModel;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProcessorTest {
    static TestModel model = new TestModel();
    static TestDTO dto;
    @BeforeClass
    public static void setUp(){
        model.field1="1";
        model.field2="2";
        model.field3="3";
        model.field4 = 4;
    }

    @Test(timeout = 250L)
    public void testCustomAnnotation1() {
        dto= new Processor().map(TestDTO.class, model);
        assertEquals(dto.testField1, model.field1);
    }

    @Test(timeout = 250L)
    public void testCustomAnnotation2() {
        dto= new Processor().map(TestDTO.class, model);
        assertEquals(dto.testField4, model.field4);
    }

    @Test(timeout = 250L)
    public void testCustomAnnotation3() {
        dto= new Processor().map(TestDTO.class, model);
        assertEquals(dto.field5, model.field5);
    }



}
