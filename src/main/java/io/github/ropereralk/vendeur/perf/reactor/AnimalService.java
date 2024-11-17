package io.github.ropereralk.vendeur.perf.reactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;

@Service
public class AnimalService {
    @Autowired
    private WebClient webClient;

    public Mono<String> getAnimalData() {
        //Request 01 Received
        String correlationId = UUID.randomUUID().toString();
        System.out.println("Request received, CorrelationId: " + correlationId + " Timestamp: " + Instant.now());

        Mono<String> apiResponse = webClient.get()
                .uri("/animals")
                .retrieve()



                .bodyToMono(String.class)
                .doOnSuccess(i -> System.out.println("Request Completed, CorrelationId: " + correlationId + " Timestamp: " + Instant.now()))
                .doOnError(Throwable::printStackTrace);


        for (int i = 1; i <= 50000; i++) {
            try {
                Thread.sleep(500); // Simulate some other non-blocking work, e.g., logging, processing, etc.
                System.out.println("Other work in progress: Task " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // return apiResponse once it is recieved

        return apiResponse;

    }
}
