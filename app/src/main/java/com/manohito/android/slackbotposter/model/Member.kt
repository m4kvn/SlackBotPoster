package com.manohito.android.slackbotposter.model

import com.google.gson.annotations.SerializedName

data class Member(val id: String,
                  val name: String,
                  val deleted: Boolean,
                  val profile: Profile,
                  val updated: Long,
                  val color: String?,
                  val tz: String?,
                  @SerializedName("tz_label") val tzLabel: String?,
                  @SerializedName("tz_offset") val tzOffset: Int?,
                  @SerializedName("real_name") val realName: String?,
                  @SerializedName("team_id") val teamId: String,
                  @SerializedName("is_bot") val isBot: Boolean,
                  @SerializedName("is_app_user") val isAppUser: Boolean,
                  @SerializedName("is_admin") val isAdmin: Boolean?,
                  @SerializedName("is_owner") val isOwner: Boolean?,
                  @SerializedName("is_primary_owner") val isPrimaryOwner: Boolean?,
                  @SerializedName("is_restricted") val isRestricted: Boolean?,
                  @SerializedName("is_ultra_restricted") val isUltraRestricted: Boolean?,
                  @SerializedName("has_2fa") val has2fa: Boolean?)