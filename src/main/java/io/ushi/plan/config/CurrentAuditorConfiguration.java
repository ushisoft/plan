package io.ushi.plan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class CurrentAuditorConfiguration implements AuditorAware<Long> {

    @Override
    public Optional getCurrentAuditor() {
        return Optional.of(999L);
    }
}
