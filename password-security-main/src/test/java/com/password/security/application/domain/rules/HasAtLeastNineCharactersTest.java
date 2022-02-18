package com.password.security.application.domain.rules;

import com.password.security.application.domain.enumeration.Criteria;
import com.password.security.application.domain.mappers.PasswordRulesMapper;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class HasAtLeastNineCharactersTest {

    static Stream<Arguments> passwordsAndExpectedOutputDataProvider() {
        return Stream.of(
                arguments("zxc12345678", true),
                arguments("123456789", true),
                arguments("aszs", false),
                arguments("!@#%zxc12354", true),
                arguments("123", false),
                arguments("zxc123a4", false),
                arguments("!@", false),
                arguments("", false),
                arguments(" ", false),
                arguments("              ", true)
        );
    }

    @ParameterizedTest
    @MethodSource("passwordsAndExpectedOutputDataProvider")
    void checkIfPasswordsHasAtLeastNineCharactersTest(String password, boolean expectedOutput) {
        boolean result = PasswordRulesMapper.isValid(password, Criteria.AT_LEAST_NINE_CHARACTERS);

        Assert.assertEquals(result, expectedOutput);
    }

}