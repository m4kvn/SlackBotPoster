package com.manohito.android.slackbotposter.view

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.widget.TextView
import com.manohito.android.slackbotposter.R
import com.manohito.android.slackbotposter.model.Channel
import org.androidannotations.annotations.EViewGroup
import org.androidannotations.annotations.ViewById

@EViewGroup(R.layout.view_channel_selection)
open class ChannelSelectionView(context: Context) : ConstraintLayout(context) {

    @ViewById(R.id.channel_name_text_view)
    lateinit var channelNameTextView: TextView

    fun bind(channel: Channel) {
        channelNameTextView.text = channel.name
    }
}