package by.prohor.booklib.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class ClientHttpRequestInterceptor implements org.springframework.http.client.ClientHttpRequestInterceptor {
    private static Logger LOGGER = LoggerFactory
            .getLogger(ClientHttpRequestInterceptor.class);
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequestDetails(request);
        ClientHttpResponse response = execution.execute(request, body);

        return response;
    }
    private void logRequestDetails(HttpRequest request) {
        LOGGER.info("Headers: {}", request.getHeaders());
        LOGGER.info("Request Method: {}", request.getMethod());
        LOGGER.info("Request URI: {}", request.getURI());
    }
}

