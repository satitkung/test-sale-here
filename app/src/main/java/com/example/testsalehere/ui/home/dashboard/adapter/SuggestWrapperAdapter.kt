package com.example.testsalehere.ui.home.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testsalehere.R
import com.example.testsalehere.model.SuggestModel
import com.example.testsalehere.ui.home.dashboard.adapter.viewholder.SuggestWrapperViewHolder

class SuggestWrapperAdapter(private val suggestAdapter: SuggestAdapter) :
    RecyclerView.Adapter<SuggestWrapperViewHolder>() {

    private val data: ArrayList<SuggestModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestWrapperViewHolder {
        return SuggestWrapperViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.suggest_item_wrapper_view,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SuggestWrapperViewHolder, position: Int) {
        holder.bind(suggestAdapter, data)
    }

    override fun getItemCount(): Int {
        return if (data.isNotEmpty()) 1 else 0
    }

    fun addList(list: List<SuggestModel>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

}