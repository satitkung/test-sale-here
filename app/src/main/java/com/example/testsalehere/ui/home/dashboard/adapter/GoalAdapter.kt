package com.example.testsalehere.ui.home.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.testsalehere.R
import com.example.testsalehere.model.GoalModel
import com.example.testsalehere.ui.home.dashboard.adapter.viewholder.GoalViewHolder

class GoalAdapter: ListAdapter<GoalModel, GoalViewHolder>(Comparator) {

    object Comparator : DiffUtil.ItemCallback<GoalModel>() {
        override fun areItemsTheSame(
            oldItem: GoalModel,
            newItem: GoalModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: GoalModel,
            newItem: GoalModel
        ): Boolean {
            return oldItem.id == newItem.id && oldItem.tag == newItem.tag
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        return GoalViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.goal_item_view,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        holder.bind(getItem(position), currentList.size == position + 1)
    }

}