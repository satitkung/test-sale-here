package com.example.testsalehere.ui.home.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testsalehere.R
import com.example.testsalehere.databinding.FragmentHomeDashboardBinding
import com.example.testsalehere.extension.observeFor
import com.example.testsalehere.ui.home.dashboard.adapter.GoalAdapter
import com.example.testsalehere.ui.home.dashboard.adapter.GoalWrapperAdapter
import com.example.testsalehere.ui.home.dashboard.adapter.OfferAdapter
import com.example.testsalehere.ui.home.dashboard.adapter.OfferWrapperAdapter
import com.example.testsalehere.ui.home.dashboard.adapter.SuggestAdapter
import com.example.testsalehere.ui.home.dashboard.adapter.SuggestWrapperAdapter
import com.example.testsalehere.ui.home.goal.HomeAddGoalFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeDashboardFragment : Fragment() {

    companion object {
        const val ADD_GOAL_REQUEST_CODE = "add_goal_request_code"
    }

    private lateinit var binding: FragmentHomeDashboardBinding
    private val viewModel: HomeDashboardViewModel by viewModels()

    private val goalAdapter: GoalAdapter by lazy { GoalAdapter() }
    private val goalWrapperAdapter: GoalWrapperAdapter by lazy {
        GoalWrapperAdapter(goalAdapter) {
            navigateToAddGoalScreen()
        }
    }
    private val offerAdapter: OfferAdapter by lazy { OfferAdapter() }
    private val offerWrapperAdapter: OfferWrapperAdapter by lazy { OfferWrapperAdapter(offerAdapter) }
    private val suggestAdapter: SuggestAdapter by lazy { SuggestAdapter() }
    private val suggestWrapperAdapter: SuggestWrapperAdapter by lazy {
        SuggestWrapperAdapter(
            suggestAdapter
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserver()
        viewModel.loadData()
    }

    private fun initObserver() {
        observeFor(viewModel.goalList) {
            goalWrapperAdapter.addList(it)
        }

        observeFor(viewModel.offerList) {
            offerWrapperAdapter.addList(it)
        }

        observeFor(viewModel.suggestList) {
            suggestWrapperAdapter.addList(it)
        }

        observeFor(viewModel.isRefresh) {
            binding.pullLayout.isRefreshing = it
        }

        setFragmentResultListener(ADD_GOAL_REQUEST_CODE) { _, bundle ->
            viewModel.loadData()
        }
    }

    private fun navigateToAddGoalScreen() {
        parentFragmentManager.beginTransaction()
            .add(R.id.home_main_layout, HomeAddGoalFragment()).addToBackStack(null).commit()
    }

    private fun initView() {
        val dashboardAdapter =
            ConcatAdapter(goalWrapperAdapter, offerWrapperAdapter, suggestWrapperAdapter)
        binding.rcvDashboard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcvDashboard.adapter = dashboardAdapter

        binding.pullLayout.setOnRefreshListener {
            viewModel.loadData()
        }
    }

}