package com.manohito.android.slackbotposter.model

import com.google.gson.annotations.SerializedName

data class Message(val text: String,
                   val username: String,
                   @SerializedName("bot_id") val botId: String,
                   val type: String,
                   val subtype: String,
                   val ts: String)