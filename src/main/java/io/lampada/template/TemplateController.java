package io.lampada.template;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

Contains routes for endpoints.

*/

@RestController
public class TemplateController {

    @Autowired
    TemplateService templateService;

    public static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

    public TemplateController() {
    }

    @GetMapping(value = "/")
    public ResponseEntity getAll() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("GET Template Top");
    }

    @PostMapping(value = "/")
    public ResponseEntity create(@RequestBody Template postBody) {
        logger.info("Example Object created with ID: X");
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("POST Template Top");
    }

    @GetMapping(value = "/{parameter}")
    public ResponseEntity getWithParameter(@PathVariable Object parameter) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("GET Template Parameter");
    }

}
