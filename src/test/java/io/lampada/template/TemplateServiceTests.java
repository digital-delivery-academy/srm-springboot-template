package io.lampada.template;

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TemplateServiceTests {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private TemplateRepository templateRepository;

    @After
    public void tearDown() {
        templateRepository.clearAll();
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
