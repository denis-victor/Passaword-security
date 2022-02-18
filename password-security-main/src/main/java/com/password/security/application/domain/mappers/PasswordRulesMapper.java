package com.password.security.application.domain.mappers;

import com.password.security.application.domain.enumeration.Criteria;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class PasswordRulesMapper {

    public boolean isValid(String password, Criteria... criterias) {

        for (Criteria criteria : criterias) {
            boolean isAnInvalidPassword = !criteria.getPasswordRulesInterface().verify(password);

            if (isAnInvalidPassword) {
                log.info("The password is invalid!");
                return false;
            }
        }

        log.info("The password is valid!");

        return true;
    }

}
