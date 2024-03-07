package com.example.testsalehere.ui.home.goal.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.testsalehere.R
import com.example.testsalehere.databinding.TagItemViewBinding
import com.example.testsalehere.enums.GoalTag
import com.example.testsalehere.model.TagModel

class TagViewHolder(
    private val binding: TagItemViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TagModel) {
        binding.apply {
            tag = item
            imvLogo.setImageResource(getLogoByTag(item.title))
        }
    }

    private fun getLogoByTag(tag: String) =
        when (GoalTag.getEnumFromString(tag)) {
            GoalTag.TRAVEL -> R.drawable.ic_travel
            GoalTag.EDUCATION -> R.drawable.ic_education
            GoalTag.SHOPPING -> R.drawable.ic_shopping
            GoalTag.SPORT -> R.drawable.ic_sport
            else -> R.drawable.ic_investment
        }
}