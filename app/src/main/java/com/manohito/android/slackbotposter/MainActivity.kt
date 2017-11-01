package com.manohito.android.slackbotposter

import android.annotation.SuppressLint
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatSpinner
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.manohito.android.slackbotposter.model.Channel
import com.manohito.android.slackbotposter.model.Member
import com.manohito.android.slackbotposter.view.BotSelectionSpinnerAdapter
import com.manohito.android.slackbotposter.view.ChannelSelectionSpinnerAdapter
import org.androidannotations.annotations.*
import rx.schedulers.Schedulers

@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
open class MainActivity : AppCompatActivity() {

    private val token: String by lazy { BuildConfig.SLACK_BOT_API_TOKEN }

    @Bean
    lateinit var botSelectionSpinnerAdapter: BotSelectionSpinnerAdapter

    @Bean
    lateinit var channelSelectionSpinnerAdapter: ChannelSelectionSpinnerAdapter

    @App
    lateinit var slackApplication: SlackApplication

    @SystemService
    lateinit var inputMethodManager: InputMethodManager

    @ViewById(R.id.message_edit_text)
    lateinit var messageEditText: TextInputEditText

    @ViewById(R.id.message_response_text_view)
    lateinit var messageResponseTextView: TextView

    @ViewById(R.id.bot_selection_spinner)
    lateinit var botSelectionSpinner: AppCompatSpinner

    @ViewById(R.id.channel_selection_spinner)
    lateinit var channelSelectionSpinner: AppCompatSpinner

    @AfterViews
    fun init() {
        botSelectionSpinner.adapter = botSelectionSpinnerAdapter
        channelSelectionSpinner.adapter = channelSelectionSpinnerAdapter

        slackApplication.slackService.getChannelsList(token)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    channelSelectionSpinnerAdapter.setChannels(it.channels)
                    channelSelectionSpinnerAdapter.notifyDataSetChanged()
                }, {
                    updateTextView(it.toString())
                })

        slackApplication.slackService.getUsersList(token)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    botSelectionSpinnerAdapter.setBots(it.members.filter { it.isBot && !it.deleted })
                    botSelectionSpinnerAdapter.notifyDataSetChanged()
                }, {
                    updateTextView(it.toString())
                })
    }

    @UiThread
    open fun updateTextView(text: String) {
        messageResponseTextView.text = text
    }

    @UiThread
    open fun clearMessageEditText() {
        messageEditText.setText("")
    }

    @Click(R.id.message_post_button)
    fun onClickedMessagePostButton() {
        hideInputWindow()
        val text = messageEditText.text.toString()
        val member = botSelectionSpinner.selectedItem as Member
        val iconUrl = member.profile.image32
        val username = member.profile.realName
        val channel = channelSelectionSpinner.selectedItem as Channel
        val channelName = channel.name

        slackApplication.slackService
                .postMessage(token, "#$channelName", text, iconUrl, username)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    updateTextView(it.toString())
                }, {
                    updateTextView(it.toString())
                })

        clearMessageEditText()
    }

    private fun hideInputWindow() {
        inputMethodManager.hideSoftInputFromWindow(
                currentFocus.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
        )
    }

    private fun showInputWindow(view: View) {
        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }
}
