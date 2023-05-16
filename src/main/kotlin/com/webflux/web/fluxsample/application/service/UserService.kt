package com.webflux.web.fluxsample.application.service

import com.webflux.web.fluxsample.application.dto.UserSaveCommandDto
import com.webflux.web.fluxsample.domain.entity.User
import com.webflux.web.fluxsample.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class UserService(
    @Autowired val userRepository: UserRepository,
) {
    fun save(userSaveCommandDto: UserSaveCommandDto): Mono<User> {
        return userRepository.save(
            User(
                firstname = userSaveCommandDto.firstname,
                lastname = userSaveCommandDto.lastname,
                email = userSaveCommandDto.email,
                age = userSaveCommandDto.age,
                id = UUID.randomUUID(),
            ),
        )
    }

    fun getAll() : Flux<User> {
        return userRepository.findAll()
    }

    fun countAll(): Mono<Long> {
        return userRepository.countAll()
    }

    fun getUser(id: UUID): Mono<User> {
        return userRepository.findById(id)
    }
}