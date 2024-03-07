package com.example.testsalehere.ui.achievement.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testsalehere.R
import com.example.testsalehere.model.AchievementModel
import com.example.testsalehere.ui.achievement.adapter.viewholder.AchievementViewHolder

class AchievementAdapter :
    ListAdapter<AchievementModel, RecyclerView.ViewHolder>(Comparator) {

    object Comparator : DiffUtil.ItemCallback<AchievementModel>() {
        override fun areItemsTheSame(
            oldItem: AchievementModel,
            newItem: AchievementModel
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: AchievementModel,
            newItem: AchievementModel
        ): Boolean {
            return oldItem.title == newItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AchievementViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.achievement_item_view,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AchievementViewHolder) {
            holder.bind(getItem(position))
        }
    }

}