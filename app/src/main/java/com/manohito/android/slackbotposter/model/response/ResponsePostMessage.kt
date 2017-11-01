package com.manohito.android.slackbotposter.model.response

import com.manohito.android.slackbotposter.model.Message

data class ResponsePostMessage(val ok: Boolean,
                               val channel: String,
                               val ts: String,
                               val message: Message)