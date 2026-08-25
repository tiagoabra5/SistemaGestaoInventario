package com.tiago.Sistema.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SaleEventDTO implements Serializable {

    private Long saleId;
    private Long productId;
    private String productName;
    private Integer quantity;
    private BigDecimal  totalPrice;
    private LocalDateTime timestamp;

    public SaleEventDTO() {}

    public SaleEventDTO(Long saleId, Long productId, String productName,
                        Integer quantity, BigDecimal totalPrice, LocalDateTime timestamp) {
        this.saleId = saleId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.timestamp = timestamp;
    }

    public Long getSaleId() { return saleId; }
    public void setSaleId(Long saleId) { this.saleId = saleId; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal  getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal  totalPrice) { this.totalPrice = totalPrice; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}