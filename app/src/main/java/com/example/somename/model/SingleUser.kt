package com.example.somename.model


import com.google.gson.annotations.SerializedName

data class SingleUser(
    @SerializedName("avatar_url") private val avatarUrl: String,
    @SerializedName("type") private val type: String,
    @SerializedName("name") private val name: String,
    @SerializedName("location") private val location: String,
    @SerializedName("public_repos") private val publicRepos: Int,
    @SerializedName("followers") private val followers: Int,
    @SerializedName("bio") private val bio: String,
    @SerializedName("email") private val email: String,
    @SerializedName("following") private val following: Int
) {

    fun get_AvatarUrl() = avatarUrl
    fun get_Type() = type
    fun get_Name() = name
    fun get_Location() = location
    fun get_PublicRepos() = publicRepos
    fun get_Followers() = followers
    fun get_Bio() = bio
    fun get_Email() = email
    fun get_Following() = following
}
