package com.password.security.application.domain.rules;


import com.password.security.application.domain.enumeration.Criteria;
import com.password.security.application.domain.mappers.PasswordRulesMapper;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class HaveNonSpacesTest {

    static Stream<Arguments> passwordsAndExpectedOutputDataProvider() {
        return Stream.of(
                arguments(" ", false),
                arguments("", true),
                arguments("Aiushda 123!", false),
                arguments("asoid!Pajs%", true)
        );
    }

    @ParameterizedTest
    @MethodSource("passwordsAndExpectedOutputDataProvider")
    void checkIfPasswordsHaveNonSpacesTest(String password, boolean expectedOutput) {
        boolean result = PasswordRulesMapper.isValid(password, Criteria.HAVE_NON_SPACES);

        Assert.assertEquals(result, expectedOutput);
    }
}