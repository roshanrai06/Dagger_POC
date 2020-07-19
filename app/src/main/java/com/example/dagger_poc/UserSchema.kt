package com.example.dagger_poc

import com.google.gson.annotations.SerializedName

class UserSchema {
    @SerializedName("display_name")
    private var mUserDisplayName: String? = null

    fun UserSchema(
        userDisplayName: String?,
        userAvatarUrl: String?
    ) {
        mUserDisplayName = userDisplayName
        mUserAvatarUrl = userAvatarUrl
    }

    @SerializedName("profile_image")
    private var mUserAvatarUrl: String? = null

    fun getUserAvatarUrl(): String? {
        return mUserAvatarUrl
    }

    fun getUserDisplayName(): String? {
        return mUserDisplayName
    }

}
