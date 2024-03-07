package com.example.testsalehere.ui.home.dashboard.adapter.viewholder

import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.testsalehere.R
import com.example.testsalehere.databinding.GoalItemViewBinding
import com.example.testsalehere.enums.GoalTag
import com.example.testsalehere.extension.dpToPx
import com.example.testsalehere.model.GoalModel

class GoalViewHolder(
    private val binding: GoalItemViewBinding
) : RecyclerView.ViewHolder(binding.root) {
    val context = binding.root.context

    fun bind(item: GoalModel, isLastItem: Boolean) {

        val isGoodStatus = isGoodStatus(item.currentAmount, item.targetAmount)

        binding.apply {
            goal = item

            val marginEnd = if (isLastItem) 16 else 0
            val params = binding.goalLayout.layoutParams as ViewGroup.MarginLayoutParams
            params.marginEnd = context.dpToPx(marginEnd.toFloat())
            binding.goalLayout.layoutParams = params

            imvLogo.setImageResource(getLogoByTag(item.tag))
            if (isGoodStatus) {
                txtStatus.text = context.getString(R.string.home_goal_good_status)
                txtStatus.setTextColor(ContextCompat.getColor(context, R.color.green))
                goalLayout.setBackgroundResource(R.drawable.bg_goal_good_status)
            } else {
                txtStatus.text = context.getString(R.string.home_goal_unhappy_status)
                txtStatus.setTextColor(ContextCompat.getColor(context, R.color.orange))
                goalLayout.setBackgroundResource(R.drawable.bg_goal_bad_status)
            }

            gauge.progress = ((item.currentAmount.toFloat() / item.targetAmount).toDouble() * 100).toInt()
        }

    }

    private fun isGoodStatus(current:Int, target: Int) = target / current <= 2

    private fun getLogoByTag(tag: String) =
        when (GoalTag.getEnumFromString(tag)) {
            GoalTag.TRAVEL -> R.drawable.ic_travel
            GoalTag.EDUCATION -> R.drawable.ic_education
            GoalTag.SHOPPING -> R.drawable.ic_shopping
            GoalTag.SPORT -> R.drawable.ic_sport
            else -> R.drawable.ic_investment
        }
}