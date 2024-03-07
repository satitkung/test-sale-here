package com.example.testsalehere.ui.achievement.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.testsalehere.databinding.AchievementItemViewBinding
import com.example.testsalehere.model.AchievementModel

class AchievementViewHolder(
    private val binding: AchievementItemViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AchievementModel) {
        binding.apply {
            achievement = item
        }
    }
}