package dev.ragul.jps;

import dev.ragul.jps.todo.JpsTodoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@AutoConfiguration
@EnableConfigurationProperties(JsonPlaceholderServiceProperties.class)
public class JsonPlaceholderServiceConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(JsonPlaceholderServiceConfiguration.class);
    private final JsonPlaceholderServiceProperties jpsProperties;

    public JsonPlaceholderServiceConfiguration(JsonPlaceholderServiceProperties jpsProperties) {
        this.jpsProperties = jpsProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public RestClient restClient() {
        logger.info("Creating RestClient for JsonPlaceholder with baseUrl={}",
                jpsProperties.baseUrl());

        return RestClient.builder()
                .baseUrl(jpsProperties.baseUrl())
                .build();
    }

    @Bean
    @ConditionalOnMissingBean
    public JpsTodoClient jpsTodoClient(RestClient restClient) {
        return new JpsTodoClient(restClient);
    }

}
