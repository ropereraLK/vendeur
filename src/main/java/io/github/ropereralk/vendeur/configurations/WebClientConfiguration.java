package io.github.ropereralk.vendeur.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

//    @Bean
//    public WebClient.Builder webClientBuilder() {
//        return WebClient.builder();
//    }


    @Bean
    public WebClient keycloakWebClientBuilder(){
        return WebClient.builder().build();
    }
}
