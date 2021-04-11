package com.example.myfirst.Component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginUserAutorAware implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor(){
        return Optional.of("AdminServer");
    }

}
