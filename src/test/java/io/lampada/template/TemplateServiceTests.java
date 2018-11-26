package io.lampada.template;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TemplateServiceTests {

    private TemplateService templateService;

    @Before
    public void setUp() {
        templateService = new TemplateService();
        setPrivateField("templateRepository", templateService, new TemplateRepository());
    }

    @After
    public void tearDown() {
        templateService = null;
    }

    public void setPrivateField(String name, Object obj, Object newValue) {
        try {
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(obj, newValue);
            field.setAccessible(false);
        } catch (NoSuchFieldException e) {
            Assert.fail("Test error: NoSuchField exception");
        } catch (IllegalAccessException e) {
            Assert.fail("Test error: Refused access to the field");
        }
    }

    @Test
    public void saveTemplateShouldIncreaseSizeOfRepositoryByOne() {
        Template testTemplate = new Template();
        templateService.saveTemplate(0, testTemplate);

        int expected = 1;
        int actual = templateService.getAll().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void saveTemplateWithSameIdShouldNotAdd() {
        Template testTemplate = new Template();
        templateService.saveTemplate(0, testTemplate);

        Template testNotAddedTemplate = new Template();
        templateService.saveTemplate(0, testNotAddedTemplate);

        int expected = 1;
        int actual = templateService.getAll().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSizeOfRepositoryShouldBeSizeZero() {
        int expected = 0;
        int actual = templateService.getSizeOfRepository();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllShouldReturnMultipleTemplates() {
        Template testTemplate1 = new Template();
        Template testTemplate2 = new Template();

        templateService.saveTemplate(0, testTemplate1);
        templateService.saveTemplate(1, testTemplate2);

        List<Template> actual = templateService.getAll();

        if (!actual.contains(testTemplate1) || !actual.contains(testTemplate2)) {
            Assert.fail("Templates have not been found");
        }
    }

    @Test
    public void getByIdShouldReturnTemplateOnValidId() {
        Template testTemplate1 = new Template();
        Template testTemplate2 = new Template();

        templateService.saveTemplate(0, testTemplate1);
        templateService.saveTemplate(1, testTemplate2);

        Template expected = testTemplate2;
        Template actual = templateService.getById(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getByIdShouldReturnNullForInvalidId() {
        Template expected = null;
        Template actual = templateService.getById(118118);
        Assert.assertEquals(expected, actual);
    }

}
