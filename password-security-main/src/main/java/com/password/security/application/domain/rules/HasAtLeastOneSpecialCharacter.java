package com.password.security.application.domain.rules;

import com.password.security.application.domain.interfaces.PasswordRulesInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class HasAtLeastOneSpecialCharacter implements PasswordRulesInterface {

    private final String VALID_SPECIAL_CHARACTERS_REGEX = "!|@|#|$|%|^|&|*|(|)|\\-|+";

    @Override
    public boolean verify(String password) {
        log.info("Checking if the password has at least one special character");

        final String hasAtLeastOneSpecialCharacterRegex = "^(?=.*[" + VALID_SPECIAL_CHARACTERS_REGEX + "]).*$";

        if (haveAInvalidSpecialCharacter(password)) {
            log.info("The password have an invalid special character.");
            return false;
        }

        return password.matches(hasAtLeastOneSpecialCharacterRegex);
    }

    private boolean haveAInvalidSpecialCharacter(String password) {
        final String specialCharactersBlacklistRegex = "(?=[\\p{P}\\p{S}])(?![" + VALID_SPECIAL_CHARACTERS_REGEX +
                "])[\\w\\p{P}\\p{S}]";

        Pattern pattern = Pattern.compile(specialCharactersBlacklistRegex);

        Matcher matcher = pattern.matcher(password);

        return matcher.find();
    }
}
