package com.manohito.android.slackbotposter

import android.annotation.SuppressLint
import android.app.Application
import org.androidannotations.annotations.EApplication
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@SuppressLint("Registered")
@EApplication
open class SlackApplication : Application() {

    val slackService: SlackService by lazy {
        Retrofit.Builder()
                .baseUrl("https://slack.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(SlackService::class.java)
    }
}