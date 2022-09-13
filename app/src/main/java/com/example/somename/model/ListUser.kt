package com.example.somename.model

data class ListUser(
    private var login: String,
    private var avatar_url: String
) {
    fun getLogin() = login
    fun getAvatar_url() = avatar_url
}