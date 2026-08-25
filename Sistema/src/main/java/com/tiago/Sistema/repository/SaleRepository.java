package com.tiago.Sistema.repository;

import com.tiago.Sistema.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}