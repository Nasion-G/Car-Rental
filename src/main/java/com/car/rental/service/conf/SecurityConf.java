package com.car.rental.service.conf;

import com.car.rental.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SecurityConf {


    @Configuration
    public class SecurityConfig implements CommandLineRunner, WebMvcConfigurer {
        private final UserDetailsServiceImpl userDetailsServiceImpl;
        private final RoleRepository roleRepository;

        @Value(value="${frontendUrl}")
        private     static String allowedUrl;

        public SecurityConfig(UserDetailsServiceImpl userDetailsService, RoleRepository roleRepository){
            this.userDetailsServiceImpl = userDetailsService;
            this.roleRepository=roleRepository;
        }

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins(allowedUrl)
                    .allowedHeaders("Authorization")
                    .allowedMethods("*");

        }

        @Override
        public void run(String... args) throws Exception {
            if(!roleRepository.existsById("ROLE_ADMIN")){
                Role role=new Role();
                role.setRoleId("ROLE_ADMIN");
                roleRepository.save(role);
            }
            if(!roleRepository.existsById("ROLE_USER")){
                Role role=new Role();
                role.setRoleId("ROLE_USER");
                roleRepository.save(role);
            }
        }
        @Bean
        public BCryptPasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }
        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception{
            return authenticationConfiguration.getAuthenticationManager();
        }
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
            AuthenticationManagerBuilder configuration = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
            configuration.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
            AuthenticationManager authenticationManager = configuration.build();
            httpSecurity.authenticationManager(authenticationManager)
                    .authorizeHttpRequests(request -> {
                        request.anyRequest().permitAll();
                    })
                    .cors(Customizer.withDefaults())
                    .csrf(AbstractHttpConfigurer::disable)
                    .httpBasic(Customizer.withDefaults());
            return httpSecurity.build();
        }
    }
}
