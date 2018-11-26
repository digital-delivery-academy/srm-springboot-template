package io.lampada.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Map<Integer, Template> hashMapTemplate = new HashMap<>();
        TemplateRepository exampleRepository = templateRepository;

        int actual = exampleRepository.getAll().size();
        int expected = hashMapTemplate.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void saveTemplateShouldIncreaseSizeOfRepositoryByOne() {
        Template testTemplate = new Template();
        templateRepository.saveTemplate(0, testTemplate);

        int expected = 1;
        int actual = templateRepository.getAll().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllShouldReturnMultipleTemplates() {
        Template testTemplate1 = new Template();
        Template testTemplate2 = new Template();

        templateRepository.saveTemplate(0, testTemplate1);
        templateRepository.saveTemplate(1, testTemplate2);

        List<Template> actual = templateRepository.getAll();

        if (!(actual.contains(testTemplate1) && actual.contains(testTemplate2))) {
            Assert.fail("Templates have not been found");
        }
    }

    @Test
    public void getSizeOfRepositoryShouldBeSizeZero() {
        int expected = 0;
        int actual = templateRepository.getSizeOfRepository();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getByIdShouldReturnTemplateOnValidId() {
        Template testTemplate1 = new Template();
        Template testTemplate2 = new Template();

        templateRepository.saveTemplate(0, testTemplate1);
        templateRepository.saveTemplate(1, testTemplate2);

        Template expected = testTemplate2;
        Template actual = templateRepository.getById(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getByIdShouldReturnNullForInvalidId() {
        Template expected = null;
        Template actual = templateRepository.getById(118118);
        Assert.assertEquals(expected, actual);
    }

}
