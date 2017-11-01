package com.manohito.android.slackbotposter.view

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.widget.ImageView
import android.widget.TextView
import com.manohito.android.slackbotposter.R
import com.manohito.android.slackbotposter.model.Member
import com.squareup.picasso.Picasso
import org.androidannotations.annotations.EViewGroup
import org.androidannotations.annotations.ViewById

@EViewGroup(R.layout.view_bot_selection)
open class BotSelectionView(context: Context) : ConstraintLayout(context) {

    @ViewById(R.id.bot_image_view)
    lateinit var botImageView: ImageView

    @ViewById(R.id.bot_name)
    lateinit var botNameTextView: TextView

    fun bind(member: Member) {
        Picasso.with(context).load(member.profile.image48).into(botImageView)
        botNameTextView.text = member.name
    }
}