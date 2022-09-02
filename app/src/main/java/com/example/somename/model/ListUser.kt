package com.example.somename.model

data class ListUser(
    private var login: String,
    private var avatar_url: String
) {

    fun getLogin(): String {
        return login
    }

    fun setLogin(login: String) {
        this.login = login
    }

    fun getAvatar_url(): String {
        return avatar_url
    }

    fun setAvatar_url(avatar_url: String) {
        this.avatar_url = avatar_url
    }
}