package io.lampada.template;

import org.springframework.stereotype.Component;

/*

 This should be a bean (no logic, just fields and getter/setters).
 MUST have a parameter-less constructor
 
*/

@Component
public class Template {

    private Integer Id;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

}