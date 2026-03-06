package com.factory.productionoptimizer.service;

import com.factory.productionoptimizer.entity.RawMaterial;
import com.factory.productionoptimizer.repository.RawMaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialService {

    private final RawMaterialRepository repository;

    public RawMaterialService(RawMaterialRepository repository) {
        this.repository = repository;
    }

    public List<RawMaterial> findAll() {
        return repository.findAll();
    }

    public RawMaterial findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Raw material not found"));
    }

    public RawMaterial save(RawMaterial rawMaterial) {
        return repository.save(rawMaterial);
    }

    public RawMaterial update(Long id, RawMaterial rawMaterial) {

        RawMaterial existing = findById(id);

        existing.setName(rawMaterial.getName());
        existing.setQuantity(rawMaterial.getQuantity());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}