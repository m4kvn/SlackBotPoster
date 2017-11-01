package com.manohito.android.slackbotposter.model

import com.google.gson.annotations.SerializedName

data class Channel(val id: String,
                   val name: String,
                   val created: Long,
                   val creator: String,
                   val unlinked: Int,
                   val members: List<String>,
                   @SerializedName("is_private") val isPrivate: Boolean,
                   @SerializedName("is_member") val isMember: Boolean,
                   @SerializedName("name_normalized") val nameNormalized: String,
                   @SerializedName("is_archived") val isArchived: Boolean,
                   @SerializedName("is_general") val isGeneral: Boolean,
                   @SerializedName("is_channel") val isChannel: Boolean)