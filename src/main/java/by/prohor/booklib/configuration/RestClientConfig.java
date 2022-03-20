package by.prohor.booklib.configuration;

import by.prohor.booklib.interceptor.ClientHttpRequestInterceptor;
import by.prohor.booklib.interceptor.CustomRestTemplateCustomizer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import javax.annotation.Resource;

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

    /**
     * RestTemplate with default URI "https://ibapi.alfabank.by:8273"
     *
     * @param builder the builder
     * @return the rest template
     */
    @Bean("alfaBank")
    @Resource
    public RestTemplate restTemplateAlfaBank(RestTemplateBuilder builder) {
        return builder
                .uriTemplateHandler(new DefaultUriBuilderFactory("https://ibapi.alfabank.by:8273"))
                .additionalInterceptors(new ClientHttpRequestInterceptor())
                .build();
    }
}
