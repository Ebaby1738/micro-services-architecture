package com.inventorymodule.inventorymodule.service;


import com.inventorymodule.inventorymodule.dto.InventoryResponse;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface InventoryService {
    //boolean isInStock(String skuCode);

    @Transactional(readOnly = true)
    List<InventoryResponse> isInStock(List<String> skuCode);
}
