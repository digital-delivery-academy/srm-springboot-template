package io.lampada.template;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private TemplateService templateService;

    private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

    @GetMapping(value = "/")
    public ResponseEntity<List<Template>> allEvents() {
        List<Template> colEvents = templateService.getAll();
        // As Http Status NO_CONTENT cannot also return content even zero-size.
        return ResponseEntity.ok(colEvents);
    }

    @PostMapping(value = "/")
    public ResponseEntity create(@RequestBody Template postBody) {
        // This is an example of what a log message would look like:
        //logger.info("Created new Object with ID:" + createdTemplate.getId());
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("POST Template Top");
    }

    @GetMapping(value = "/{parameter}")
    public ResponseEntity getWithParameter(@PathVariable Object parameter) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("GET Template Parameter");
    }
}
