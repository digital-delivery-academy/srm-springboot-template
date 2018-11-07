package io.lampada.template;

import org.springframework.stereotype.Service;

/*

The Service connects between the Controller and the Repository.
This should NOT return with any ResponseEntity's.

*/

@Service
public class TemplateService {
    TemplateRepository templateRepository;

    public TemplateService() {
        templateRepository = new TemplateRepository();
    }
}
