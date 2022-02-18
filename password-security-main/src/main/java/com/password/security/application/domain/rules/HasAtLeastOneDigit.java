package com.password.security.application.domain.rules;

import com.password.security.application.domain.interfaces.PasswordRulesInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HasAtLeastOneDigit implements PasswordRulesInterface {
    @Override
    public boolean verify(String password) {
        final String atLeastOneDigitRegex = "^(?=.*[0-9]).*$";

        log.info("Checking if the password has at least one digit");

        return password.matches(atLeastOneDigitRegex);
    }
}
