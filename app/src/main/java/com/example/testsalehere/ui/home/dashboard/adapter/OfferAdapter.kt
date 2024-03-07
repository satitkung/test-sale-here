package com.example.testsalehere.ui.home.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.testsalehere.R
import com.example.testsalehere.model.OfferModel
import com.example.testsalehere.ui.home.dashboard.adapter.viewholder.OfferViewHolder

class OfferAdapter: ListAdapter<OfferModel, OfferViewHolder>(Comparator) {

    object Comparator : DiffUtil.ItemCallback<OfferModel>() {
        override fun areItemsTheSame(
            oldItem: OfferModel,
            newItem: OfferModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: OfferModel,
            newItem: OfferModel
        ): Boolean {
            return oldItem.id == newItem.id && oldItem.url == newItem.url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        return OfferViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.offer_item_view,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.bind(getItem(position), currentList.size == position + 1)
    }

}