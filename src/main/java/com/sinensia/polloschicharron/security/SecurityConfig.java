package com.sinensia.polloschicharron.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JwtAuthEntryPoint unauthorizedHandler;
     private final JwtUtils jwtUtils;
        private final UserDetailsServiceImpl userDetailsServiceImpl;

    public SecurityConfig(UserDetailsService userDetailsService,
                          JwtAuthEntryPoint unauthorizedHandler,
                          JwtUtils jwtUtils,
                          UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsService = userDetailsService;
        this.unauthorizedHandler = unauthorizedHandler;
        this.jwtUtils = jwtUtils;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Bean
    JwtAuthTokenFilter authenticationTokenFilterBean() {
        return new JwtAuthTokenFilter(jwtUtils, userDetailsServiceImpl);
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Deshabilitar CSRF
         http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll()  // <-- permite todas las rutas sin autenticación
        );

        // Manejo de excepciones y autenticación
        http.exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler));

        // Configuración de encabezados de seguridad
        http.headers(headers -> {
            // Configuración de CSP
            headers.contentSecurityPolicy(csp -> csp.policyDirectives("default-src 'self'; script-src 'self'; object-src 'none';"));

            // Configuración de HSTS
            headers.httpStrictTransportSecurity(hsts -> hsts.includeSubDomains(true).maxAgeInSeconds(31536000)); // 1 año

            // Configuración de frameOptions
            headers.frameOptions(frame -> frame.deny()); // Bloquear la opción de embeber en frames
        });

        // Gestión de sesiones
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Autorización de peticiones
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, "/auth/signin/**").permitAll()
                .requestMatchers("/WEB-INF/**").permitAll()
                .requestMatchers("/img/**", "/css/**", "/js/**").permitAll()
                .requestMatchers("/favicon.ico").permitAll()
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .requestMatchers("/app/**").permitAll()
                .requestMatchers("/admin/auditoria/**").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
        );

        // Proveedor de autenticación
        http.authenticationProvider(authenticationProvider());

        // Filtro de autenticación JWT
        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    private DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
