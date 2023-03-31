package es.sebastianch.test.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class PasswordTools {

    @Bean
    fun getPasswordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder(10)
    }


}