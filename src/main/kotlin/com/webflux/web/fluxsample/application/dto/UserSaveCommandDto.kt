package com.webflux.web.fluxsample.application.dto

data class UserSaveCommandDto (
    val firstname: String, val lastname: String, val age: Int, val email: String)