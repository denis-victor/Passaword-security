package com.password.security.integration;

import com.password.security.APIStarter;
import com.password.security.application.resources.entity.PasswordDTO;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest(classes = APIStarter.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests {

    @LocalServerPort
    private int port;

    static Stream<Arguments> validPasswordsFollowingAllCriteriaAndExpectedOutputDataProvider() {
        return Stream.of(
                arguments("", false),
                arguments(" ", false),
                arguments("Aiushda 123!", false),
                arguments("AbTp9!fok", true),
                arguments("asoid!Pj@", true),
                arguments("ab", false),
                arguments("12125", false),
                arguments("!@#", false),
                arguments("AbTp9 fok", false),
                arguments("AbTp9!foo", false),
                arguments("AbTp9!foA", false),
                arguments("AAAbbbCc", false)
        );
    }

    @ParameterizedTest
    @MethodSource("validPasswordsFollowingAllCriteriaAndExpectedOutputDataProvider")
    void validPasswordFollowingAllCriteriaTest(String password, boolean expectedOutput) {
        PasswordDTO passwordDTO = new PasswordDTO();
        passwordDTO.setPassword(password);

        given()
                .port(port)
                .body(passwordDTO)
                .contentType("application/JSON")
                .when()
                .post("/v1/password/validate")
                .then()
                .statusCode(200)
                .body("valid", equalTo(expectedOutput));
    }

}
