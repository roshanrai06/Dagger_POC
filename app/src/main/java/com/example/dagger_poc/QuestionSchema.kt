package com.example.dagger_poc

import com.google.gson.annotations.SerializedName

class QuestionSchema {
    @SerializedName("title")
     val mTitle: String? = null

    @SerializedName("question_id")
    private val mId: String? = null

    @SerializedName("body")
    private val mBody: String? = null

    @SerializedName("owner")
    private val mOwner: UserSchema? = null

}
