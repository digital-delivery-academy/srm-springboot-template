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
public class TemplateRepositoryTests {

    @Autowired
    private TemplateRepository templateRepository;

    @Test
    public void constructorShouldCreateEmptyHashmap() {
        Assert.assertEquals("templateRepository was not empty/constructed", 0,
            templateRepository.getAll().size());
    }

    @Test
    public void saveTemplateShouldIncreaseSizeOfRepositoryByOne() {
        Template testTemplate = new Template();
        templateRepository.saveTemplate(testTemplate);

        Assert.assertEquals("Size of repository was not 1", 1,
            templateRepository.getAll().size());
    }

    @Test
    public void saveTemplateShouldReturnNullIfANullTemplateIsSaved() {
        Assert.assertNull("Did not return null", templateRepository
            .saveTemplate(null));
    }

    @Test
    public void getAllShouldReturnMultipleTemplates() {
        Template testTemplate1 = new Template();
        Template testTemplate2 = new Template();

        templateRepository.saveTemplate(testTemplate1);
        templateRepository.saveTemplate(testTemplate2);

        List<Template> actual = templateRepository.getAll();

        if (!actual.contains(testTemplate1) || !actual.contains(testTemplate2)) {
            Assert.fail("Templates have not been found");
        }
    }

    @Test
    public void getAllShouldReturnEmptyListIfRepositoryIsEmpty() {
        Assert.assertEquals("Size of repository was not 0", 0, templateRepository
            .getAll().size());
    }

    @Test
    public void getByIdShouldReturnTemplateOnValidId() {
        Template testTemplate1 = new Template();
        Template testTemplate2 = new Template();

        templateRepository.saveTemplate(testTemplate1);
        templateRepository.saveTemplate(testTemplate2);

        Assert.assertEquals("Saved template with ID 2 was not returned", testTemplate2,
            templateRepository.getById(2));
    }

    @Test
    public void getByIdShouldReturnNullForInvalidId() {
        Assert.assertNull("getById didn't return null for an ID that didn't exist",
            templateRepository.getById(118118));
    }

}
