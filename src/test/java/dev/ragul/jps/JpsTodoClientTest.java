package dev.ragul.jps;

import dev.ragul.jps.todo.JpsTodoClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.web.client.RestClient;

class JpsTodoClientTest {

    private final ApplicationContextRunner contextRunner =
            new ApplicationContextRunner()
                    .withUserConfiguration(JsonPlaceholderServiceConfiguration.class);

    @Test
    void shouldContainTodoRestClientBean() {
        contextRunner.run(context -> {
            Assertions.assertNotNull(context.getBean(RestClient.class));
            Assertions.assertNotNull(context.getBean(JpsTodoClient.class));
        });
    }
}
