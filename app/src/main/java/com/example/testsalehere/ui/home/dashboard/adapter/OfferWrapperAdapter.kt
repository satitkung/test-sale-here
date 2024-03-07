package com.example.testsalehere.ui.home.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testsalehere.R
import com.example.testsalehere.model.OfferModel
import com.example.testsalehere.ui.home.dashboard.adapter.viewholder.OfferWrapperViewHolder

class OfferWrapperAdapter(private val offerAdapter: OfferAdapter) :
    RecyclerView.Adapter<OfferWrapperViewHolder>() {

    private val data: ArrayList<OfferModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferWrapperViewHolder {
        return OfferWrapperViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.offer_item_wrapper_view,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OfferWrapperViewHolder, position: Int) {
        holder.bind(offerAdapter, data)
    }

    override fun getItemCount(): Int {
        return if (data.isNotEmpty()) 1 else 0
    }

    fun addList(list: List<OfferModel>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

}