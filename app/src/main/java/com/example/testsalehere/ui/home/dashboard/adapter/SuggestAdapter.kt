package com.example.testsalehere.ui.home.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.testsalehere.R
import com.example.testsalehere.model.SuggestModel
import com.example.testsalehere.ui.home.dashboard.adapter.viewholder.SuggestViewHolder

class SuggestAdapter: ListAdapter<SuggestModel, SuggestViewHolder>(Comparator) {

    object Comparator : DiffUtil.ItemCallback<SuggestModel>() {
        override fun areItemsTheSame(
            oldItem: SuggestModel,
            newItem: SuggestModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: SuggestModel,
            newItem: SuggestModel
        ): Boolean {
            return oldItem.id == newItem.id && oldItem.url == newItem.url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestViewHolder {
        return SuggestViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.suggest_item_view,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SuggestViewHolder, position: Int) {
        holder.bind(getItem(position), currentList.size == position + 1)
    }

}