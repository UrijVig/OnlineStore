package gelvikh.yuri.webInterfaceForREST_API.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().permitAll())
                        // ограничение доступа к ресурсам
                .formLogin(login -> login
                        .loginPage("/login") //замена дефолтной страницы аутентификации
                        .successHandler(authHandler)
                        .permitAll()) // свободный доступ
                .build();
    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/","/login").permitAll()
//                        .requestMatchers("/admin/**").hasAnyRole("ADMIN")
//                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//                        .anyRequest().authenticated())
//                // ограничение доступа к ресурсам
//                .formLogin(login -> login
//                        .loginPage("/login") //замена дефолтной страницы аутентификации
//                        .defaultSuccessUrl("/candle/homepage") //перенаправление пользователя после успешной аутентификации
//                        .permitAll()) // свободный доступ
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/candle/homepage"))
//                .csrf().disable()
//                .build();
//    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin = User.builder().username("admin").password(encoder.encode("admin")).roles("ADMIN").build();
        UserDetails user = User.builder().username("user").password(encoder.encode("user")).roles("USER").build();

        return new InMemoryUserDetailsManager(admin, user);
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
