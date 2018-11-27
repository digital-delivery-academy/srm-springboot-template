package io.lampada.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping(value = "/")
    public ResponseEntity getAll() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("GET Template Root");
    }

    @PostMapping(value = "/")
    public ResponseEntity create(@RequestBody Template postBody) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("POST Template Root");
    }

    @GetMapping(value = "/{parameter}")
    public ResponseEntity getWithParameter(@PathVariable Object parameter) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("GET Template Parameter");
    }

}
