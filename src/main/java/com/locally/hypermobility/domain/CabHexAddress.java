package com.locally.hypermobility.domain;

import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class CabHexAddress {

    @Id
    private String cabId;
    private String h3Index;
    private BigDecimal latitude;
    private BigDecimal longitude;

}
