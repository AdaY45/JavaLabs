package production.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "production.service",
        "production.security",
        "production.repository"
})
public class AppConfig {

}
