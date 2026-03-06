package com.factory.productionoptimizer.controller;

import com.factory.productionoptimizer.entity.ProductMaterial;
import com.factory.productionoptimizer.service.ProductMaterialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/product-materials")
public class ProductMaterialController {

    private final ProductMaterialService service;

    public ProductMaterialController(ProductMaterialService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductMaterial> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ProductMaterial create(@RequestBody ProductMaterial productMaterial) {
        return service.save(productMaterial);
    }

    @GetMapping("/{id}")
    public ProductMaterial getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ProductMaterial update(
            @PathVariable Long id,
            @RequestBody ProductMaterial productMaterial) {
        return service.update(id, productMaterial);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}