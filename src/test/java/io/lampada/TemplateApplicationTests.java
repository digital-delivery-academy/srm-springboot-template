package io.lampada;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
// Drops @SpringBootTest and the empty test method contextLoads(), which run Spring Boot
// Test class added ONLY to cover main() invocation not covered by application tests
public class TemplateApplicationTests {

    @Test
    public void testMain() {
        try {
            TemplateApplication.main(new String[]{
                // Should start Spring Boot, but should not run as a web-application and should not
                // start an embedded web-server.
                "--spring.main.web-application-type=NONE",
                "--spring.main.banner-mode=OFF"
            });
        } catch (Exception e) {
            // Added as "JUnit tests should include assert() or fail()"
            // JUnit tests would fail if they throw an exception,
            // e.g. IllegalStateException, ConnectorStartFailedException, etc.
            Assert.fail("Failed with exception " + e.toString());
        }
        // This is the expected path.
    }

}