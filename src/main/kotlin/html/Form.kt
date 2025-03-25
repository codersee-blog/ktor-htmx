package com.codersee.html

import kotlinx.html.*

fun FlowContent.insertUserForm() {
    div {
        classes = setOf("mx-auto w-full")

        form {
            attributes["hx-post"] = "/users"
            attributes["hx-target"] = "#users-table"
            attributes["hx-swap"] = "beforeend"

            div {
                classes = setOf("-mx-3 flex flex-wrap")

                div {
                    classes = setOf("w-full px-3 sm:w-1/4")

                    label {
                        classes = setOf("mb-3 block text-base font-medium text-[#07074D]")

                        htmlFor = "first-name"
                        +"First Name"
                    }
                    input {
                        classes =
                            setOf("w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md")

                        type = InputType.text
                        name = "first-name"
                        id = "first-name"
                        placeholder = "First Name"
                    }
                }
                div {
                    classes = setOf("w-full px-3 sm:w-1/4")

                    label {
                        classes = setOf("mb-3 block text-base font-medium text-[#07074D]")

                        htmlFor = "last-name"
                        +"Last Name"
                    }
                    input {
                        classes =
                            setOf("w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md")

                        type = InputType.text
                        name = "last-name"
                        id = "last-name"
                        placeholder = "Last Name"
                    }
                }
                div {
                    classes = setOf("w-full px-3 sm:w-1/4")

                    label {
                        classes = setOf("mb-3 block text-base font-medium text-[#07074D]")

                        +"Account enabled"
                    }
                    div {
                        classes = setOf("flex items-center space-x-6 pt-3")

                        div {
                            classes = setOf("flex items-center")

                            input {
                                classes = setOf("h-5 w-5")

                                type = InputType.radio
                                name = "enabled-radio"
                                id = "radio-button-1"
                                value = "true"
                            }
                            label {
                                classes = setOf("pl-3 text-base font-medium text-[#07074D]")

                                htmlFor = "radio-button-1"
                                +"Yes"
                            }
                        }
                        div {
                            classes = setOf("flex items-center")

                            input {
                                classes = setOf("h-5 w-5")

                                type = InputType.radio
                                name = "enabled-radio"
                                id = "radio-button-2"
                                value = "false"
                                checked = true
                            }
                            label {
                                classes = setOf("pl-3 text-base font-medium text-[#07074D]")

                                htmlFor = "radio-button-2"
                                +"No"
                            }
                        }
                    }
                }
                div {
                    classes = setOf("w-full px-3 sm:w-1/4 pt-8")

                    button {
                        classes =
                            setOf("cursor-pointer rounded-md bg-slate-800 py-3 px-8 text-center text-base font-semibold text-white outline-none")

                        +"Add user"
                    }
                }
            }
        }
    }
}