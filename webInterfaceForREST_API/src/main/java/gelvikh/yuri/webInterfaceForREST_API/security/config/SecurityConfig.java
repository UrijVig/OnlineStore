package gelvikh.yuri.webInterfaceForREST_API.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private AuthHandler authHandler;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN") // ограничение доступа к ресурсам
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")// ограничение доступа к ресурсам
                        .anyRequest().permitAll()) // свободный доступ
                .formLogin(login -> login
                        .loginPage("/login") //замена дефолтной страницы аутентификации
                        .successHandler(authHandler)
                        .permitAll()) // свободный доступ
                .build();
    }

    /**
     * переопределение типа шифрования паролей
     * @return шифровщик паролей
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
