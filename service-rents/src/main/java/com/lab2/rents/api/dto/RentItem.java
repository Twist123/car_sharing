package com.lab2.rents.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class RentItem {
    private Long userId;
    private String info;
    private Integer status;
}
