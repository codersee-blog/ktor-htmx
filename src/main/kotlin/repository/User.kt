package com.codersee.repository

import java.time.LocalDateTime
import java.util.*

data class User(
    val id: String = UUID.randomUUID().toString(),
    val firstName: String,
    val lastName: String,
    val enabled: Boolean,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)