package com.example.somename.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SingleUser {

    @SerializedName("avatar_url")
    @Expose
    var avatarUrl = String()

    @SerializedName("type")
    @Expose
    var type = String()

    @SerializedName("name")
    @Expose
    var name = String()

    @SerializedName("location")
    @Expose
    var location = String()

    @SerializedName("public_repos")
    @Expose
    var publicRepos = Int

    @SerializedName("followers")
    @Expose
    var followers = Int


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

    fun get_PublicRepos(): Int.Companion {
        return publicRepos
    }

    fun set_PublicRepos(publicRepos: Int.Companion) {
        this.publicRepos = publicRepos
    }

    fun get_Followers(): Int.Companion {
        return followers
    }

    fun set_Followers(followers: Int.Companion) {
        this.followers = followers
    }
}
