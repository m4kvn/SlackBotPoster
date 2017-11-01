package com.manohito.android.slackbotposter.model.response

import com.google.gson.annotations.SerializedName
import com.manohito.android.slackbotposter.model.Member

data class ResponseUsersList(val ok: Boolean,
                             val members: List<Member>,
                             @SerializedName("cache_ts") val cacheTs: String)