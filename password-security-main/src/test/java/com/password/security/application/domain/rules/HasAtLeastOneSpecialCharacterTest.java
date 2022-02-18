package com.password.security.application.domain.rules;

import com.password.security.application.domain.enumeration.Criteria;
import com.password.security.application.domain.mappers.PasswordRulesMapper;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class HasAtLeastOneSpecialCharacterTest {

    static Stream<Arguments> passwordsAndExpectedOutputDataProvider() {

        return Stream.of(
                arguments("zxc12345678", false),
                arguments("123456789", false),
                arguments("AAzzz", false),
                arguments("!@#%zxc12354", true),
                arguments("123", false),
                arguments("!☺", false),
                arguments("?=?", false),
                arguments("!@", true),
                arguments("", false),
                arguments(" ", false),
                arguments("              ", false),
                arguments("!@%!@%!@%!*&(z", true),
                arguments("Password!=", false),
                arguments("passW?ord!", false),
                arguments("pass=?", false),
                arguments("zz@", true),
                arguments("nnpxpk$ab", true),
                arguments("pasgo%j25", true),
                arguments("&jaoi77sjd", true),
                arguments("zkj*mm1z", true),
                arguments("tyoi(zp12a", true),
                arguments("1makasbc)", true)
        );
    }

    @ParameterizedTest
    @MethodSource("passwordsAndExpectedOutputDataProvider")
    void checkIfPasswordsHasAtLeastOneSpecialCharacterTest(String password, boolean expectedOutput) {
        boolean result = PasswordRulesMapper.isValid(password, Criteria.AT_LEAST_ONE_SPECIAL_CHARACTER);

        Assert.assertEquals(result, expectedOutput);
    }

}