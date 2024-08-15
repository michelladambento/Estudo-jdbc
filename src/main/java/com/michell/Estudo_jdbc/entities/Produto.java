package com.michell.Estudo_jdbc.entities;


import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Produto {

    private Long id;

    private String description;

    private BigDecimal price;

    private Integer qtd;

}
