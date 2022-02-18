package com.password.security.application.service;

import com.password.security.application.domain.entity.PasswordStatus;
import com.password.security.application.domain.enumeration.Criteria;
import com.password.security.application.domain.mappers.PasswordRulesMapper;
import com.password.security.application.resources.entity.PasswordDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PasswordValidatorService {

    public PasswordStatus isValidPasswordWithAllCriteria(PasswordDTO passwordDTO) {
        String password = passwordDTO.getPassword();

        boolean isValidStatus = PasswordRulesMapper.isValid(password,
                Criteria.AT_LEAST_ONE_LOWERCASE_LETTER,
                Criteria.AT_LEAST_ONE_UPPERCASE_LETTER,
                Criteria.AT_LEAST_NINE_CHARACTERS,
                Criteria.AT_LEAST_ONE_SPECIAL_CHARACTER,
                Criteria.HAVE_NON_REPEATING_CHARACTERS,
                Criteria.HAVE_NON_SPACES);

        return PasswordStatus.builder()
                .isValid(isValidStatus)
                .build();
    }
}
