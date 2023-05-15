package com.webflux.web.fluxsample.application.controller

import com.webflux.web.fluxsample.application.dto.UserSaveCommandDto
import com.webflux.web.fluxsample.application.service.UserService
import com.webflux.web.fluxsample.domain.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/users")
class UserController(@Autowired val userService: UserService) {

    @GetMapping("/")
    fun getAllUsers(): Flux<User> {
        return userService.getAll()
    }

    @GetMapping("/count")
    fun countALlUsers(): Mono<Long> {
        return userService.countAll()
    }

    @PostMapping("/")
    fun saveUser(@RequestBody commandDto: UserSaveCommandDto): Mono<User> {
        return userService.save(commandDto)
    }
}