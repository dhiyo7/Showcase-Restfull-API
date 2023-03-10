package com.plugin.showcaserestfullapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
class ShowcaseRestfullApiApplication
fun main(args: Array<String>) {
	runApplication<ShowcaseRestfullApiApplication>(*args)
}
