package com.password.security.application.resources.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Objects;

@Data
public class PasswordDTO {

    private String password;

    @JsonIgnore
    public boolean isInvalidInput() {
        return Objects.isNull(this.password);
    }
}
