package com.factory.productionoptimizer.repository;

import com.factory.productionoptimizer.entity.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {
}