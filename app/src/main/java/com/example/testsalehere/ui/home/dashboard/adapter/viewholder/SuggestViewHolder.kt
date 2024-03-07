package com.example.testsalehere.ui.home.dashboard.adapter.viewholder

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testsalehere.databinding.SuggestItemViewBinding
import com.example.testsalehere.extension.dpToPx
import com.example.testsalehere.model.SuggestModel

class SuggestViewHolder(
    private val binding: SuggestItemViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: SuggestModel, isLastItem: Boolean) {
        val context = binding.root.context

        val marginEnd = if (isLastItem) 16 else 0
        val params = binding.imvLogo.layoutParams as ViewGroup.MarginLayoutParams
        params.marginEnd = context.dpToPx(marginEnd.toFloat())
        binding.imvLogo.layoutParams = params

        Glide.with(binding.root.context)
            .load(item.url)
            .centerCrop()
            .into(binding.imvLogo)
    }
}