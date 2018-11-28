package io.lampada.template;

import java.lang.reflect.Field;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TemplateTests {

    private Template testTemplate;

    @Before
    public void setUp() {
        testTemplate = new Template();
    }

    @Test
    public void getExampleIdShouldReturnExampleId() {
        testTemplate.setExampleId(1);

        int expected = 1;
        int actual = testTemplate.getExampleId();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExampleIdShouldSetExampleId()
        throws NoSuchFieldException, IllegalAccessException {
        testTemplate.setExampleId(1);
        Field field = testTemplate.getClass().getDeclaredField("exampleId");
        field.setAccessible(true);

        int expected = 1;
        Object actual = field.get(testTemplate);

        Assert.assertEquals(expected, actual);
    }

}
