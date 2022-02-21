package by.prohor.booklib.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
@Configuration
@ConfigurationProperties(prefix = "openlibrary.settings")
public class OpenLibraryConfig {
    @NotBlank
    private String baseUrl;
}
