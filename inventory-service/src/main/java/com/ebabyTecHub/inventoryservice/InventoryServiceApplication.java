package com.ebabyTecHub.inventoryservice;

import com.ebabyTecHub.inventoryservice.entity.Inventory;
import com.ebabyTecHub.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("samsung fold");
			inventory1.setQuantity(2);

			Inventory inventory2 = new Inventory();
			inventory1.setSkuCode("iphone_13");
			inventory1.setQuantity(0);

			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
		};
	}

}
