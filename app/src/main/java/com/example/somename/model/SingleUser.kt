package com.example.somename.model


import com.google.gson.annotations.SerializedName

data class SingleUser(
    @SerializedName("avatar_url") private var avatarUrl: String,
    @SerializedName("type") private var type: String,
    @SerializedName("name") private var name: String,
    @SerializedName("location") private var location: String,
    @SerializedName("public_repos") private var publicRepos: Int,
    @SerializedName("followers") private var followers: Int,
    @SerializedName("bio") private var bio: String
) {


    fun get_AvatarUrl(): String {
        return avatarUrl
    }

    fun set_AvatarUrl(avatarUrl: String) {
        this.avatarUrl = avatarUrl
    }

    fun get_Type(): String {
        return type
    }

    fun set_Type(type: String) {
        this.type = type
    }


    fun get_Name(): String {
        return name
    }

    fun set_Name(name: String) {
        this.name = name
    }


    fun get_Location(): String {
        return location
    }

    fun set_Location(location: String) {
        this.location = location
    }

    fun get_PublicRepos(): Int {
        return publicRepos
    }

    fun set_PublicRepos(publicRepos: Int) {
        this.publicRepos = publicRepos
    }

    fun get_Followers(): Int {
        return followers
    }

    fun set_Followers(followers: Int) {
        this.followers = followers
    }



    fun get_Bio(): String {
        return bio
    }

    fun set_Bio(bio: String) {
        this.bio = bio
    }
}
