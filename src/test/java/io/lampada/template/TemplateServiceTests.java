package io.lampada.template;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TemplateServiceTests {

    @Autowired
    private TemplateService templateService;

    @Test
    public void saveTemplateShouldIncreaseSizeOfRepositoryByOne() {
        Template testTemplate = new Template();
        templateService.saveTemplate(testTemplate);

        Assert.assertEquals("Size of repository was not 1", 1, templateService
            .getAll().size());
    }

    @Test
    public void saveTemplateShouldReturnNullIfANullTemplateIsSaved() {
        Assert.assertNull("Did not return null", templateService
            .saveTemplate(null));
    }

    @Test
    public void getSizeOfRepositoryShouldReturnZeroIfSizeIsZero() {
        Assert.assertEquals("Size of repository was not 0", 0, templateService
            .getSizeOfRepository());
    }

    @Test
    public void getSizeOfRepositoryShouldNotBeZeroIfNotEmpty() {
        Template testTemplate = new Template();

        templateService.saveTemplate(testTemplate);

        Assert.assertEquals("Size of repository was not 1", 1, templateService
            .getSizeOfRepository());
    }

    @Test
    public void getAllShouldReturnMultipleTemplates() {
        Template testTemplate1 = new Template();
        Template testTemplate2 = new Template();

        templateService.saveTemplate(testTemplate1);
        templateService.saveTemplate(testTemplate2);

        List<Template> actual = templateService.getAll();

        if (!actual.contains(testTemplate1) || !actual.contains(testTemplate2)) {
            Assert.fail("Templates have not been found");
        }
    }

    @Test
    public void getAllShouldReturnEmptyListIfRepositoryIsEmpty() {
        Assert.assertEquals("Size of repository was not 0", 0, templateService
            .getAll().size());
    }

    @Test
    public void getByIdShouldReturnTemplateOnValidId() {
        Template testTemplate1 = new Template();
        Template testTemplate2 = new Template();

        templateService.saveTemplate(testTemplate1);
        templateService.saveTemplate(testTemplate2);

        Assert.assertEquals("Saved template with ID 2 was not returned", testTemplate2,
            templateService.getById(2));
    }

    @Test
    public void getByIdShouldReturnNullForInvalidId() {
        Assert.assertEquals("Did not return null", null, templateService
            .getById(118118));
    }

}
