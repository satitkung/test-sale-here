package com.example.testsalehere.ui.home.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testsalehere.R
import com.example.testsalehere.model.GoalModel
import com.example.testsalehere.ui.home.dashboard.adapter.viewholder.GoalWrapperViewHolder

class GoalWrapperAdapter(
    private val goalAdapter: GoalAdapter,
    private val onAddGoal: () -> Unit
) :
    RecyclerView.Adapter<GoalWrapperViewHolder>() {

    private val data: ArrayList<GoalModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalWrapperViewHolder {
        return GoalWrapperViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.goal_item_wrapper_view,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: GoalWrapperViewHolder, position: Int) {
        holder.bind(goalAdapter, data, onAddGoal)
    }

    override fun getItemCount(): Int {
        return if (data.isNotEmpty()) 1 else 0
    }

    fun addList(list: List<GoalModel>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

}