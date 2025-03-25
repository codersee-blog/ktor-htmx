package com.codersee.repository

class UserRepository {

    private val users = mutableListOf(
        User(firstName = "Jane", lastName = "Doe", enabled = true),
        User(firstName = "John", lastName = "Smith", enabled = true),
        User(firstName = "Alice", lastName = "Johnson", enabled = false),
        User(firstName = "Bob", lastName = "Williams", enabled = true),
    )

    fun create(firstName: String, lastName: String, enabled: Boolean): User =
        User(firstName = firstName, lastName = lastName, enabled = enabled)
            .also(users::add)

    fun findAll(): List<User> = users

    fun delete(id: String): Boolean = users.removeIf { it.id == id }
}