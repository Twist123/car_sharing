package com.lab2.identities.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class IdentityItem {
    private String login;
    private String password;
    private Boolean moderator;
    private Integer status;
}
