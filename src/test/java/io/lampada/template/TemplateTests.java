package io.lampada.template;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TemplateTests {

    Template testTemplate;

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

}
