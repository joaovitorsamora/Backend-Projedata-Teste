package com.factory.productionoptimizer.service;

import com.factory.productionoptimizer.entity.ProductMaterial;
import com.factory.productionoptimizer.repository.ProductMaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMaterialService {

    private final ProductMaterialRepository repository;

    public ProductMaterialService(ProductMaterialRepository repository) {
        this.repository = repository;
    }

    public List<ProductMaterial> findAll() {
        return repository.findAll();
    }

    public ProductMaterial save(ProductMaterial productMaterial) {
        return repository.save(productMaterial);
    }

    public ProductMaterial findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductMaterial not found"));
    }

    public ProductMaterial update(Long id, ProductMaterial productMaterial) {

        ProductMaterial existing = findById(id);

        existing.setProduct(productMaterial.getProduct());
        existing.setMaterial(productMaterial.getMaterial());
        existing.setQuantityRequired(productMaterial.getQuantityRequired());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}