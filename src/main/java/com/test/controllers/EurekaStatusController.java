package com.test.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaStatusController {

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServerUrl;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/check-eureka-registration")
    public String checkEurekaRegistration() {
        String url = eurekaServerUrl + "/apps/" + applicationName.toUpperCase();
        RestTemplate restTemplate = new RestTemplate();
        try {
            String response = restTemplate.getForObject(url, String.class);
            if (response != null && response.contains(applicationName.toUpperCase())) {
                return "Service is registered with Eureka";
            } else {
                return "Service is NOT registered with Eureka";
            }
        } catch (Exception e) {
            return "Error checking Eureka registration: " + e.getMessage();
        }
    }

    @GetMapping("/sesuatu")
    String index() {
        return "Hello World";
    }

    @PostMapping("/sesuatu1")
    public ResponseEntity<String> postWithParams(
            @RequestParam String id,
            @RequestParam String nama,
            @RequestParam String alamat) {
        String response = "ID: " + id + ", Nama: " + nama + ", Alamat: " + alamat;
        return ResponseEntity.ok(response);
    }
}