package by.prohor.booklib.configuration;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Book Application API")
                        .description("This is a Book library. Task Intervale Company")
                        .termsOfService("terms")
                        .contact(new Contact().email("igorprohorchenko@gmail.com"))
                        .license(new License().name("GarryProhor"))
                        .version("1.0"));
    }
}
