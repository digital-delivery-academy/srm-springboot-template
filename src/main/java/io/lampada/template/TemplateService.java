package io.lampada.template;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*

The Service connects between the Controller and the Repository.
This should NOT return with any ResponseEntity's.

*/

@Service
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    public static final Logger logger = LoggerFactory.getLogger(TemplateService.class);


    public Template saveTemplate(int id, Template templateToAdd) {
        templateRepository.saveTemplate(id, templateToAdd);
        logger.info("Template has been saved with the ID number " + id);

        return templateToAdd;
    }

    public Template getById(int id) {
        return templateRepository.getById(id);
    }

    public List<Template> getAll() {
        return templateRepository.getAll();
    }

    public int getSizeOfRepository() {
        return templateRepository.getSizeOfRepository();
    }

}
