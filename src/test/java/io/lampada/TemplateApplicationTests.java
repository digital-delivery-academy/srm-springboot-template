package io.lampada;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
// Without @SpringBootTest and the empty test method contextLoads()
public class TemplateApplicationTests {

    @Test
    public void testMain() {
        TemplateApplication.main(new String[]{
            // Should startup Spring Boot, but should not run as a web-application and should not start an embedded web-server.
            "--spring.main.web-application-type=NONE",
            "--spring.main.banner-mode=OFF"
        });
    }

}
