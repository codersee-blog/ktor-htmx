package com.codersee

import UserRepository
import com.codersee.routing.configureRouting
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val userRepository = UserRepository()

    configureRouting(userRepository)
}
