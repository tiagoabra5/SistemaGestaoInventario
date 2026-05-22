package com.tiago.Sistema.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String descricao;
    private BigDecimal price;
    private Integer quantity;
    private LocalDateTime createdAt;

}
