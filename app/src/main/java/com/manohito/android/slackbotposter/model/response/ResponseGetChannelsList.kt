package com.manohito.android.slackbotposter.model.response

import com.manohito.android.slackbotposter.model.Channel

data class ResponseGetChannelsList(val ok: Boolean,
                                   val channels: List<Channel>)