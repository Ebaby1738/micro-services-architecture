package com.inventorymodule.inventorymodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryModuleApplication.class, args);
    }

}
