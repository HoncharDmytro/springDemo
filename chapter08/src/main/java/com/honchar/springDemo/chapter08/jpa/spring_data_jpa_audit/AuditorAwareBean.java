package com.honchar.springDemo.chapter08.jpa.spring_data_jpa_audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareBean implements AuditorAware<String> {
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Returning a Fixed String \"springDemo\"!");
    }
}
