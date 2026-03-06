package com.factory.productionoptimizer.controller;

import com.factory.productionoptimizer.service.ProductionOptimizerService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/optimize-production")
public class ProductionController {

    private final ProductionOptimizerService service;

    public ProductionController(ProductionOptimizerService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Integer> optimize() {
        return service.calculateProduction();
    }
}