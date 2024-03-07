package com.example.testsalehere.ui.home.dashboard.adapter.viewholder

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testsalehere.databinding.OfferItemWrapperViewBinding
import com.example.testsalehere.model.OfferModel
import com.example.testsalehere.ui.home.dashboard.adapter.OfferAdapter

class OfferWrapperViewHolder(
    private val binding: OfferItemWrapperViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(adapter: OfferAdapter, data: ArrayList<OfferModel>) {
        val context = binding.root.context
        binding.rcvOffer.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rcvOffer.adapter = adapter
        adapter.submitList(data.toList())
    }
}