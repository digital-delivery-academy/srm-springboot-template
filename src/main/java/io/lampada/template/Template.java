package io.lampada.template;

import org.springframework.stereotype.Component;

/*

 This should be a bean (no logic, just fields and getter/setters).
 MUST have a parameter-less constructor
 
*/

@Component
public class Template {

    private int exampleId;

    Template() {
    }

    public Integer getExampleId() {
        return exampleId;
    }

    public void setExampleId(int exampleId) {
        this.exampleId = exampleId;
    }

}