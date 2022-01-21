package com.lab2.maintenance.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class MaintenanceItem {
    private Integer volume;
    private Integer weight;
    private String pointFrom;
    private String pointTo;
    private Integer status;
}
