package com.password.security.application.domain.rules;

import com.password.security.application.domain.enumeration.Criteria;
import com.password.security.application.domain.mappers.PasswordRulesMapper;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class HasAtLeastOneDigitTest {

    static Stream<Arguments> passwordsAndExpectedOutputDataProvider() {
        return Stream.of(
                arguments("aasha5", true),
                arguments("123456789", true),
                arguments("aszs", false),
                arguments("!@#%zxc12354", true),
                arguments("123", true),
                arguments("1asdxaPsd!%!", true),
                arguments("!@9", true),
                arguments("5", true),
                arguments("", false),
                arguments("              ", false),
                arguments("_____5_____", true),
                arguments("*/AZXVZXasdasd7", true)
        );
    }

    @ParameterizedTest
    @MethodSource("passwordsAndExpectedOutputDataProvider")
    void checkIfPasswordsHasAtLeastOneDigitTest(String password, boolean expectedOutput) {
        boolean result = PasswordRulesMapper.isValid(password, Criteria.AT_LEAST_ONE_DIGIT);

        Assert.assertEquals(result, expectedOutput);
    }
}