package com.password.security.application.domain.rules;

import com.password.security.application.domain.interfaces.PasswordRulesInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HasAtLeastOneLowercaseLetter implements PasswordRulesInterface {
    @Override
    public boolean verify(String password) {
        final String atLeastOneLowerCaseLetterRegex = "^(?=.*[a-z]).*$";

        log.info("Checking if the password has at least one lowercase letter");

        return password.matches(atLeastOneLowerCaseLetterRegex);
    }
}
