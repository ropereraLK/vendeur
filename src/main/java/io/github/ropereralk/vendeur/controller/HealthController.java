package io.github.ropereralk.vendeur.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class HealthController {

    @Value("${app.app-name}")
    private String name;

    @Value("${app.version}")
    private String version;

    @GetMapping("/api/v1/health")
    public ResponseEntity<Map<String, String>> healthCheck() {

        Map<String, String> response = new HashMap<>();
        response.put("app-name", name);
        response.put("version", version);
        response.put("message", "Application is up and running");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/v1/admin/health")
    public ResponseEntity<Map<String, String>> adminHealthCheck() {

        Map<String, String> response = new HashMap<>();
        response.put("app-name", name);
        response.put("version", version);
        response.put("role", "admin");
        response.put("message", "Application is up and running");
        return ResponseEntity.ok(response);
    }
}
