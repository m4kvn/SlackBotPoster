package com.manohito.android.slackbotposter.model

import com.google.gson.annotations.SerializedName

data class Profile(@SerializedName("bot_id") val botId: String?,
                   @SerializedName("api_app_id") val apiAppId: String?,
                   @SerializedName("always_active") val alwaysActive: Boolean?,
                   @SerializedName("first_name") val firstName: String,
                   @SerializedName("last_name") val lastName: String?,
                   @SerializedName("avatar_hash") val avatarHash: String,
                   @SerializedName("image_24") val image24: String,
                   @SerializedName("image_32") val image32: String,
                   @SerializedName("image_48") val image48: String,
                   @SerializedName("image_72") val image72: String,
                   @SerializedName("image_192") val image192: String,
                   @SerializedName("image_512") val image512: String,
                   @SerializedName("image_1024") val image1024: String,
                   @SerializedName("image_original") val imageOriginal: String,
                   @SerializedName("real_name") val realName: String,
                   @SerializedName("display_name") val displayName: String,
                   @SerializedName("real_name_normalized") val realNameNormalized: String,
                   @SerializedName("display_name_normalized") val displayNameNormalized: String,
                   @SerializedName("status_emoji") val statusEmoji: String?,
                   @SerializedName("status_text") val statusText: String?,
                   val email: String?,
                   val team: String,
                   val title: String?,
                   val phone: String?)