package io.lampada.template;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*

Contains routes for endpoints.

*/

@RestController
public class TemplateController {

    TemplateService templateService;

    public TemplateController() {
        templateService = new TemplateService();
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
