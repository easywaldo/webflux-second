package com.webflux.web.fluxsample.domain.entity

import jakarta.persistence.Entity
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import java.util.*

@Entity
@Table("users")
data class User(
    @Id @Column("id") val id: UUID,
    @Column("firstname")
    val firstname: String,
    @Column("lastname")
    val lastname: String,
    @Column("email")
    val email: String,
    @Column("age")
    val age: Int,
)