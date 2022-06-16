package com.honchar.springDemo.chapter08.jpa.hibernate_envers;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareBean implements AuditorAware<String> {
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Fixed string \"springDemo\"!");
    }
}
