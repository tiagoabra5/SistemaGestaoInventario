package com.tiago.Sistema.controller;

import com.tiago.Sistema.dto.SaleRequestDTO;
import com.tiago.Sistema.entity.Sale;
import com.tiago.Sistema.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody SaleRequestDTO request) {
        return ResponseEntity.ok(saleService.createSale(request));
    }
}