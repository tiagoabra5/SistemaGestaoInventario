package com.tiago.Sistema.service;

import com.tiago.Sistema.dto.SaleEventDTO;
import com.tiago.Sistema.dto.SaleRequestDTO;
import com.tiago.Sistema.messaging.SaleEventProducer;
import com.tiago.Sistema.entity.Product;
import com.tiago.Sistema.entity.Sale;
import com.tiago.Sistema.repository.ProductRepository;
import com.tiago.Sistema.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final SaleEventProducer saleEventProducer;

    public SaleService(SaleRepository saleRepository,
                       ProductRepository productRepository,
                       SaleEventProducer saleEventProducer) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.saleEventProducer = saleEventProducer;
    }

    public Sale createSale(SaleRequestDTO request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Sale sale = new Sale();
        sale.setProduct(product);
        sale.setQuantity(request.getQuantity());
        sale.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(request.getQuantity())));

        Sale savedSale = saleRepository.save(sale);

        SaleEventDTO event = new SaleEventDTO(
                savedSale.getId(),
                product.getId(),
                product.getName(),
                savedSale.getQuantity(),
                savedSale.getTotalPrice(),
                LocalDateTime.now()
        );

        saleEventProducer.publishSaleEvent(event);

        return savedSale;
    }
}