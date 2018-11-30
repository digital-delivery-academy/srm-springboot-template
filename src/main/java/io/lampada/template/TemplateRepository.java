package io.lampada.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/*

Repository handles storage and retrieval of data and no decision logic.
It can be embedded or remote, but it should act the same way no matter what.

*/

@Repository
public class TemplateRepository {

    private Map<Integer, Template> templates;

    public TemplateRepository() {
        templates = new HashMap<>();
    }

    public Template saveTemplate(Template templateToAdd) {
        if (templateToAdd!=null) {
            int id = templates.size() + 1;
            templateToAdd.setId(id);

            // Put returns the previous value associated with key, or null if there was no mapping
            // for key.
            templates.put(id, templateToAdd);
            return templateToAdd;
        } return null;
    }

    public Template getById(int id) {
        return templates.get(id);
    }

    public List<Template> getAll() {
        return new ArrayList<Template>(templates.values());
    }

    public int getSizeOfRepository() {
        return templates.size();
    }

}
