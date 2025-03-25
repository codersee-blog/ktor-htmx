package com.codersee.routing

import com.codersee.html.renderIndex
import com.codersee.repository.UserRepository
import html.insertUserRowCells
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.stream.createHTML
import kotlinx.html.tr

fun Application.configureRouting(userRepository: UserRepository) {
    routing {
        staticResources("/img", "img")

        get("/") {
            call.respondHtml {
                renderIndex(userRepository)
            }
        }

        route("/users") {

            post {
                val formParams = call.receiveParameters()
                val firstName = formParams["first-name"]!!
                val lastName = formParams["last-name"]!!
                val enabled = formParams["enabled-radio"]!!.toBoolean()

                if (firstName.isBlank() || lastName.isBlank())
                    return@post call.respond(HttpStatusCode.BadRequest)

                val createdItem = userRepository.create(firstName, lastName, enabled)

                val todoItemHtml = createHTML().tr { insertUserRowCells(createdItem) }

                call.respondText(
                    todoItemHtml,
                    contentType = ContentType.Text.Html,
                )
            }

            delete("/{id}") {
                val id = call.parameters["id"]!!

                userRepository.delete(id)

                call.respond(HttpStatusCode.OK)
            }
        }
    }

}