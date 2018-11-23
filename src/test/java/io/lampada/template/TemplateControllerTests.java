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
    public void getShouldReturnNotImplemented() throws Exception {
        ResponseEntity<String> response = this.restTemplate
            .getForEntity("http://localhost:" + port + "/", String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.NOT_IMPLEMENTED);
    }

    @Test
    public void postShouldReturnNotImplemented() throws Exception {
        HttpEntity<Template> request = new HttpEntity<>(new Template());
        ResponseEntity<String> response = this.restTemplate
            .postForEntity("http://localhost:" + port + "/", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.NOT_IMPLEMENTED);
        
        /*
        Sample code where POST creates from a bean and returns a URI:

        HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
        URI location = restTemplate.postForLocation(fooResourceUrl, request);
        assertThat(location, notNullValue());
        */
    }
}
