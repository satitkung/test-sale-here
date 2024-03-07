package com.example.testsalehere.ui.home.dashboard.adapter.viewholder

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testsalehere.R
import com.example.testsalehere.databinding.GoalItemWrapperViewBinding
import com.example.testsalehere.model.GoalModel
import com.example.testsalehere.ui.home.dashboard.adapter.GoalAdapter

class GoalWrapperViewHolder(
    private val binding: GoalItemWrapperViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(adapter: GoalAdapter, data: ArrayList<GoalModel>,onAddGoal: ()-> Unit) {
        val context = binding.root.context

        binding.apply {
            rcvGoal.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rcvGoal.adapter = adapter
            adapter.submitList(data.toList())

            txtTotalGoal.text = context.getString(R.string.home_goal_total).format(data.size)
            txtTotalAmount.text = context.getString(R.string.home_goal_amount).format(
                data.sumOf { it.currentAmount }
            )
            btnAdd.setOnClickListener {
                onAddGoal.invoke()
            }
        }

    }
}