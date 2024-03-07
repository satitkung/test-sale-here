package com.example.testsalehere.ui.home.dashboard.adapter.viewholder

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testsalehere.databinding.SuggestItemWrapperViewBinding
import com.example.testsalehere.model.SuggestModel
import com.example.testsalehere.ui.home.dashboard.adapter.SuggestAdapter

class SuggestWrapperViewHolder(
    private val binding: SuggestItemWrapperViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(adapter: SuggestAdapter, data: ArrayList<SuggestModel>) {
        val context = binding.root.context
        binding.rcvSuggest.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rcvSuggest.adapter = adapter
        adapter.submitList(data.toList())
    }
}