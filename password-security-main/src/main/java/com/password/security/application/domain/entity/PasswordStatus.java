package com.password.security.application.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PasswordStatus {

    private boolean isValid;

}
