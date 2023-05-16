package com.webflux.web.fluxsample

import com.webflux.web.fluxsample.domain.entity.User
import com.webflux.web.fluxsample.domain.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*

@SpringBootApplication
class WebFluxSampleApplication

fun main(args: Array<String>) {
	runApplication<WebFluxSampleApplication>(*args)
}

@Component
class DatabasePreparement(val userRepository: UserRepository): CommandLineRunner {

	override fun run(vararg args: String?) {
		userRepository.save(User(
			firstname = "lee",
			lastname = "easywaldo",
			age = 20,
			email = "easywaldo@gmail.com",
			id = UUID.randomUUID(),
		))
	}
}
