package io.lampada.template;

import java.util.List;
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

    public TemplateService() {

    }

    public Template saveTemplate(int id, Template templateToAdd) {
        templateRepository.saveTemplate(id, templateToAdd);
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
