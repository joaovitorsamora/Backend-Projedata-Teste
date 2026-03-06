package com.factory.productionoptimizer.service;

import com.factory.productionoptimizer.entity.Product;
import com.factory.productionoptimizer.entity.ProductMaterial;
import com.factory.productionoptimizer.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductionOptimizerService {

    private final ProductRepository productRepository;

    public ProductionOptimizerService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Map<String, Integer> calculateProduction() {
        List<Product> products = productRepository.findAll().stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        Map<String, Integer> result = new LinkedHashMap<>();
        
        Map<Long, Double> inventorySnapshot = new HashMap<>();

        for (Product product : products) {
            int canProduce = 0;
            
            if (product.getMaterials() == null || product.getMaterials().isEmpty()) {
                result.put(product.getName(), 0);
                continue;
            }

            while (true) {
                boolean hasStockForOneMore = true;

                for (ProductMaterial pm : product.getMaterials()) {
                    Long materialId = pm.getMaterial().getId();
                    double required = pm.getQuantityRequired();
                    
                    inventorySnapshot.putIfAbsent(materialId, pm.getMaterial().getQuantity());

                    if (inventorySnapshot.get(materialId) < required) {
                        hasStockForOneMore = false;
                        break;
                    }
                }

                if (hasStockForOneMore) {
                    
                    for (ProductMaterial pm : product.getMaterials()) {
                        Long materialId = pm.getMaterial().getId();
                        inventorySnapshot.put(materialId, inventorySnapshot.get(materialId) - pm.getQuantityRequired());
                    }
                    canProduce++;
                } else {
                    break; 
                }
            }
            result.put(product.getName(), canProduce);
        }

        return result;
    }
}