package io.ushi.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Springboot Application
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableDiscoveryClient
public class PlanApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlanApplication.class, args);
    }
}
