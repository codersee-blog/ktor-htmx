package com.codersee.html

import com.codersee.repository.UserRepository
import kotlinx.html.*
import html.insertUserTable

fun HTML.renderIndex(userRepository: UserRepository) {
    head {
        script {
            src = "https://unpkg.com/htmx.org@2.0.4"
        }
        script {
            src = "https://unpkg.com/@tailwindcss/browser@4"
        }
    }
    body {
        div {
            classes = setOf("m-auto max-w-5xl w-full overflow-hidden")

            insertHeader()
            insertUserForm()
            insertUserTable(userRepository.findAll())
        }

        insertErrorHandlingScripts()
    }
}

private fun FlowContent.insertHeader() {
    h5 {
        classes =
            setOf("py-8 block font-sans text-xl antialiased font-semibold leading-snug tracking-normal text-blue-gray-900")

        +"Users list"
    }
}

private fun BODY.insertErrorHandlingScripts() {
    script {
        +"""
            document.body.addEventListener('htmx:responseError', function(evt) {
              alert('An error occurred! HTTP status:' + evt.detail.xhr.status);
            });
            
            document.body.addEventListener('htmx:sendError', function(evt) {
              alert('Server unavailable!');
            });
        """.trimIndent()
    }
}