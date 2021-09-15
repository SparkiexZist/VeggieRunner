package th.ac.ku.kinkao.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ComponentConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    // เป็นดีไซน์แพทเทิลแบบหนึ่ง
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}