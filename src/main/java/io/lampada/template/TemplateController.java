package io.lampada.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*

Contains routes for endpoints.

*/

@RestController
public class TemplateController {

    @Autowired
    TemplateService templateService;

    public TemplateController() {
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("GET Template");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Template postBody) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("POST Template");
    }

    @RequestMapping(value = "/{parameter}", method = RequestMethod.GET)
    public ResponseEntity getWithParameter(@PathVariable Object parameter) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("GET Template");
    }
}
