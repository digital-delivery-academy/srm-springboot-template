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

    private Map<Integer, Template> templateMap;

    public TemplateRepository() {
        templateMap = new HashMap<>();
    }

    public Template saveTemplate(int id, Template templateToAdd) {
        // Put returns the previous value associated with key, or null if there was no mapping for key.
        templateMap.put(id, templateToAdd);
        return templateToAdd;
    }

    public Template getById(int id) {
        return templateMap.get(id);
    }

    public List<Template> getAll() {
        return new ArrayList<Template>(templateMap.values());
    }

    public int getSizeOfRepository() {
        return templateMap.size();
    }
}