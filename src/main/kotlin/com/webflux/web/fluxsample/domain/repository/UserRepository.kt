package com.webflux.web.fluxsample.domain.repository

import com.webflux.web.fluxsample.domain.entity.User
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.r2dbc.core.delete
import org.springframework.data.r2dbc.core.insert
import org.springframework.data.relational.core.query.Criteria.where
import org.springframework.data.relational.core.query.Query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class UserRepository(private val entityTemplate: R2dbcEntityTemplate) {

    fun findAll(): Flux<User> {
        return entityTemplate.select(User::class.java).all()
    }

    fun countAll(): Mono<Long> {
        return entityTemplate.select(User::class.java).count()
    }

    fun findById(id: Long): Mono<User> {
        return entityTemplate.selectOne(Query.query(where ("firstname").`is`("easywaldo")), User::class.java)
    }

    fun save(user: User): Mono<User> {
        return entityTemplate.insert<User>().using(user).map { user }
    }

    fun deleteById(id: Long): Mono<Boolean> {
        return entityTemplate.delete<User>()
            .matching(
                Query.query(where("id").`is`(id)))
            .all().map {
                it -> it.countOneBits() > 0
        }
    }
}