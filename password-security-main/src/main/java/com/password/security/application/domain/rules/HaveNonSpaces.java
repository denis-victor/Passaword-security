package com.password.security.application.domain.rules;

import com.password.security.application.domain.interfaces.PasswordRulesInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HaveNonSpaces implements PasswordRulesInterface {
    @Override
    public boolean verify(String password) {
        final String haveNonSpacesRegex = "^(?!.*\\h).*$";

        log.info("Checking if the password doesn't have spaces");

        return password.matches(haveNonSpacesRegex);
    }
}
