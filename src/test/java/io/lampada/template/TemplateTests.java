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
    public void getIdShouldReturnId() {
        testTemplate.setId(1);

        Assert.assertEquals("Id was not 1", 1, testTemplate.getId());
    }

    @Test
    public void setIdShouldSetId()
        throws NoSuchFieldException, IllegalAccessException {
        testTemplate.setId(1);
        Field field = testTemplate.getClass().getDeclaredField("Id");
        field.setAccessible(true);

        Assert.assertEquals("Id was not 1", 1, field.get(testTemplate));
    }

}
