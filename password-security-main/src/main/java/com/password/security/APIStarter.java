package com.password.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class APIStarter {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(APIStarter.class);
        Environment env = app.run(args).getEnvironment();

        String port = env.getProperty("server.port");

        log.info("\n================================================\n" +
                        "\n\tAcesse: http://localhost:{}\n" +
                        "\tSwagger: http://localhost:{}/docs\n" +
                        "\n================================================\n",
                port, port
        );

    }

}
