package com.example.testsalehere.ui.home.goal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testsalehere.R
import com.example.testsalehere.model.TagModel
import com.example.testsalehere.ui.home.goal.adapter.viewholder.TagViewHolder

class TagAdapter :
    ListAdapter<TagModel, RecyclerView.ViewHolder>(Comparator) {

    object Comparator : DiffUtil.ItemCallback<TagModel>() {
        override fun areItemsTheSame(
            oldItem: TagModel,
            newItem: TagModel
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: TagModel,
            newItem: TagModel
        ): Boolean {
            return oldItem.title == newItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TagViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.tag_item_view,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TagViewHolder) {
            holder.bind(getItem(position))
        }
    }

}