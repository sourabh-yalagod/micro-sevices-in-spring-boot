package microservices.restClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.io.IOException;

@Configuration
public class RequestClientConfig {
    private CustomInterceptor customInterceptor;

    @Bean
    public RestClient getRestClient(ClientHttpRequestInterceptor interceptor) {
        return RestClient.builder().requestInterceptor(interceptor).build();
    }
}
