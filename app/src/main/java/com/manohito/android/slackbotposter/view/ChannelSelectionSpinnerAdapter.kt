package com.manohito.android.slackbotposter.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.manohito.android.slackbotposter.model.Channel
import org.androidannotations.annotations.EBean
import org.androidannotations.annotations.RootContext

@EBean
open class ChannelSelectionSpinnerAdapter : BaseAdapter() {

    @RootContext
    lateinit var context: Context

    private var channels: List<Channel> = emptyList()

    override fun getView(position: Int, current: View?, parent: ViewGroup?): View {
        return ChannelSelectionView_.build(context).apply { bind(channels[position]) }
    }

    override fun getItem(position: Int): Any = channels[position]

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = channels.size

    fun setChannels(channels: List<Channel>) {
        this.channels = channels
    }
}