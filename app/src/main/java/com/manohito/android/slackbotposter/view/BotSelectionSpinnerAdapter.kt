package com.manohito.android.slackbotposter.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.manohito.android.slackbotposter.model.Member
import org.androidannotations.annotations.EBean
import org.androidannotations.annotations.RootContext

@EBean
open class BotSelectionSpinnerAdapter : BaseAdapter() {

    @RootContext
    lateinit var context: Context

    private var bots: List<Member> = emptyList()

    override fun getView(position: Int, current: View?, parent: ViewGroup?): View {
        return BotSelectionView_.build(context).apply { bind(bots[position]) }
    }

    override fun getItem(position: Int): Any = bots[position]

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = bots.size

    fun setBots(bots: List<Member>) {
        this.bots = bots
    }
}