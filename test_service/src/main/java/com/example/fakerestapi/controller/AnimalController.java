package com.example.fakerestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class AnimalController {

    @GetMapping("/animals")
    public ResponseEntity<String> getAnimals(){

        long startTime = System.currentTimeMillis();
        long delay = 20 * 1000; // 400 seconds in milliseconds

        while (System.currentTimeMillis() - startTime < delay) {
            // Busy-wait loop until 400 seconds have passed
        }
        System.out.println("400-second delay completed.");

       // Math.random();
        return ResponseEntity.status(200).body("Rabbit "+Math.random());

    }
}
