package io.lampada.template;

import org.springframework.stereotype.Component;

/*

 This should be a bean (no logic, just fields and getter/setters).
 MUST have a parameter-less constructor
 
*/

@Component
public class Template {

    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

}