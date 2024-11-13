package io.github.ropereralk.vendeur.perf.reactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.lang.management.MonitorInfo;

@RestController
@RequestMapping("/perf")
public class RectorController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/animals")
    public Mono<String> getAnimalData(){

        return animalService.getAnimalData()
                .doOnSuccess(System.out::println);


    }
}
