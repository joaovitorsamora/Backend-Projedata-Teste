package com.factory.productionoptimizer.controller;

import com.factory.productionoptimizer.entity.RawMaterial;
import com.factory.productionoptimizer.service.RawMaterialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/raw-materials")
public class RawMaterialController {

    private final RawMaterialService service;

    public RawMaterialController(RawMaterialService service) {
        this.service = service;
    }

    @GetMapping
    public List<RawMaterial> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RawMaterial getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public RawMaterial create(@RequestBody RawMaterial rawMaterial) {
        return service.save(rawMaterial);
    }

    @PutMapping("/{id}")
    public RawMaterial update(@PathVariable Long id, @RequestBody RawMaterial rawMaterial) {
        return service.update(id, rawMaterial);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}