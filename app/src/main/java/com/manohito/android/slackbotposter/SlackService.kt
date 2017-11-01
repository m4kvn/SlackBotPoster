package com.manohito.android.slackbotposter

import com.manohito.android.slackbotposter.model.response.ResponseGetChannelsList
import com.manohito.android.slackbotposter.model.response.ResponsePostMessage
import com.manohito.android.slackbotposter.model.response.ResponseUsersList
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable


interface SlackService {

    @GET("chat.postMessage")
    fun postMessage(@Query("token") token: String,
                    @Query("channel") channel: String,
                    @Query("text") text: String,
                    @Query("icon_url") iconUrl: String,
                    @Query("username") username: String) : Observable<ResponsePostMessage>

    @GET("users.list")
    fun getUsersList(@Query("token") token: String) : Observable<ResponseUsersList>

    @GET("channels.list")
    fun getChannelsList(@Query("token") token: String) : Observable<ResponseGetChannelsList>
}