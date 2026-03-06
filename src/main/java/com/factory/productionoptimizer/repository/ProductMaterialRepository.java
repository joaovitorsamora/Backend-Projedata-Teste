package com.factory.productionoptimizer.repository;

import com.factory.productionoptimizer.entity.ProductMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMaterialRepository extends JpaRepository<ProductMaterial, Long> {
}