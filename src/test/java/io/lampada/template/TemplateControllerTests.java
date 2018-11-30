package io.lampada.template;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TemplateControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void contextShouldLoad() {
        Assert.assertNotEquals(restTemplate, null);
    }

    @Test
    public void getRootShouldReturnOK() {
        ResponseEntity<String> response = this.restTemplate
            .getForEntity("http://localhost:" + port + "/", String.class);

        Assert.assertEquals("GET to / did not return OK", HttpStatus.OK, response
            .getStatusCode());
    }

    @Test
    public void getParameterShouldReturnNotImplemented() {
        ResponseEntity<String> response = this.restTemplate
            .getForEntity("http://localhost:" + port + "/1", String.class);

        Assert.assertEquals("GET to / with a parameter did not return NOT IMPLEMENTED",
            HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());
    }

    @Test
    public void postShouldReturnNotImplemented() {
        ResponseEntity<String> response = this.restTemplate
            .postForEntity("http://localhost:" + port + "/", new HttpEntity<>(new Template()),
                String.class);

        Assert.assertEquals("POST to / did not return NOT IMPLEMENTED", HttpStatus
            .NOT_IMPLEMENTED, response.getStatusCode());

        /*
        Sample code where POST creates from a bean and returns a URI:

        HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
        URI location = restTemplate.postForLocation(fooResourceUrl, request);
        Assert.assertNotNull(location);
        */
    }

    @Test
    public void sendingNullBodyToPostShouldNotThrowException() {
        Template nullTemplate = null;
        HttpEntity<Template> request = new HttpEntity<>(nullTemplate);
        ResponseEntity<String> response = this.restTemplate
            .postForEntity("http://localhost:" + port + "/", request, String.class);

        Assert.assertEquals(
            "Sending a null body should not throw an exception as that would destroy the "
                + "thread on the server", HttpStatus.UNSUPPORTED_MEDIA_TYPE,
            response.getStatusCode());
    }
    
}
