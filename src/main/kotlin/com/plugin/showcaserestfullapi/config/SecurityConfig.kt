package com.plugin.showcaserestfullapi.config

import com.plugin.showcaserestfullapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder



@Configuration
@EnableWebSecurity
class SecurityConfig  : WebSecurityConfigurerAdapter() {

    @Autowired
    private val userService : UserService? = null

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        val auth = DaoAuthenticationProvider()
        auth.setUserDetailsService(userService)
        auth.setPasswordEncoder(passwordEncoder())
        return auth
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProvider())
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            .authorizeRequests().antMatchers(
                "/api/register",
                "/api/showcase",
                "/api/showcases"
            ).permitAll()
        http.authorizeRequests().anyRequest().authenticated()

    }

}