package html

import com.codersee.repository.User
import kotlinx.html.*
import java.time.format.DateTimeFormatter

fun FlowContent.insertUserTable(users: List<User>) {
    div {
        classes = setOf("px-0 overflow-scroll")

        table {
            classes = setOf("w-full mt-4 text-left table-auto min-w-max")

            thead {
                tr {
                    th {
                        classes = setOf("p-4 border-y border-blue-gray-100 bg-blue-gray-50/50")
                        +"User"
                    }
                    th {
                        classes = setOf("p-4 border-y border-blue-gray-100 bg-blue-gray-50/50")
                        +"Status"
                    }
                    th {
                        classes = setOf("p-4 border-y border-blue-gray-100 bg-blue-gray-50/50")
                        +"Created At"
                    }
                    th {
                        classes = setOf("p-4 border-y border-blue-gray-100 bg-blue-gray-50/50")
                    }
                }
            }

            tbody {
                id = "users-table"

                users.forEach { user ->
                    tr {
                        insertUserRowCells(user)
                    }
                }
            }
        }
    }
}

fun TR.insertUserRowCells(user: User) {
    td {
        classes = setOf("p-4 border-b border-blue-gray-50")

        div {
            classes = setOf("flex items-center gap-3")

            img {
                classes = setOf("relative inline-block h-9 w-9 !rounded-full object-cover object-center")

                src = "/img/placeholder.png"
            }

            p {
                classes = setOf("block font-sans text-sm antialiased font-normal leading-normal text-blue-gray-900")

                +"${user.firstName} ${user.lastName}"
            }
        }
    }
    td {
        classes = setOf("p-4 border-b border-blue-gray-50")

        div {
            classes = setOf("w-max")

            div {
                val enabledLabel = if (user.enabled) "Enabled" else "Disabled"
                val labelColor = if (user.enabled) "green" else "red"

                classes =
                    setOf("relative grid items-center px-2 py-1 font-sans text-xs font-bold text-black-900 uppercase rounded-md select-none whitespace-nowrap bg-$labelColor-500/20")


                span { +enabledLabel }
            }
        }
    }
    td {
        classes = setOf("p-4 border-b border-blue-gray-50")

        p {
            classes = setOf("block font-sans text-sm antialiased font-normal leading-normal text-blue-gray-900")

            +user.createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        }
    }
    td {
        classes = setOf("p-4 border-b border-blue-gray-50")

        button {
            classes =
                setOf("cursor-pointer relative h-10 max-h-[40px] w-10 max-w-[40px] select-none rounded-lg text-center align-middle font-sans text-xs font-medium uppercase text-gray-900 transition-all hover:bg-gray-900/10 active:bg-gray-900/20 disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none")
            attributes["hx-delete"] = "/users/${user.id}"
            attributes["hx-swap"] = "outerHTML"
            attributes["hx-target"] = "closest tr"

            unsafe {
                +"""
                    <span class="absolute transform -translate-x-1/2 -translate-y-1/2 top-1/2 left-1/2">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                             stroke-width="2" stroke="currentColor" class="w-6 h-6">
                            <path stroke-linecap="round" stroke-linejoin="round"
                                  d="M6 18L18 6M6 6l12 12"/>
                        </svg>
                    </span>
                """.trimIndent()
            }

        }
    }
}
