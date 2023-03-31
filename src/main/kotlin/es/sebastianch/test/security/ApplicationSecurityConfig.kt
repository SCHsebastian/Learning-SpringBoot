package es.sebastianch.test.security

import es.sebastianch.test.security.ApplicationUserRole.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

/**
 * Simple new Configuration class to configure Spring Security Web
 * */
@Configuration
@EnableWebSecurity
class ApplicationSecurityConfig{

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    /*
    * He're we're using requestMatchers to match the request with the role
    * */
    @Bean
    fun filterChain(http: HttpSecurity):SecurityFilterChain{
        http
            //.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/api/*").hasRole(USER.name)
            .requestMatchers("/api/admin/**").hasRole(ADMIN.name)
            .anyRequest().authenticated()
            .and()
            .httpBasic()

        return http.build()
    }

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
            return WebSecurityCustomizer { web ->
                    web.ignoring().requestMatchers("/","/css/**","/js/**","/images/**")

            }
    }


     /*
     * Password encoder is injected with @Autowired annotation and @Bean annotation
     * is compulsory to use it in the method if not this won't work
     * */
    @Bean
    fun userDetailsService():UserDetailsService = InMemoryUserDetailsManager(
        User.builder()
            .username("Sebastian")
            .password(passwordEncoder.encode("123"))
            .roles(ADMIN.name)
            .build(),

        User.builder()
            .username("user")
            .password(passwordEncoder.encode("123"))
            .roles(USER.name)
            .build()
    )

}