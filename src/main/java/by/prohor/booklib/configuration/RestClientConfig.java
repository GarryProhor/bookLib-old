package by.prohor.booklib.configuration;

import by.prohor.booklib.interceptor.CustomRestTemplateCustomizer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RestClientConfig {
    @Bean
    public CustomRestTemplateCustomizer restTemplate() {
        return new CustomRestTemplateCustomizer();
    }

    @Bean
    public RestTemplateBuilder restTemplateBuilder(){
        return new RestTemplateBuilder(restTemplate());
    }
}
