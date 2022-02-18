package com.password.security.application.domain.rules;

import com.password.security.application.domain.interfaces.PasswordRulesInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Slf4j
@Component
public class HaveNonRepeatingCharacters implements PasswordRulesInterface {
    @Override
    public boolean verify(String password) {
        final String haveNonRepeatingCharactersRegex = "^(?!.*(.).*\\1).*$";

        log.info("Checking if the password doesn't repeat characters");

        Pattern haveNonRepeatingCharactersPattern = Pattern.compile(haveNonRepeatingCharactersRegex,
                Pattern.CASE_INSENSITIVE);

        return haveNonRepeatingCharactersPattern.matcher(password).find();
    }
}
