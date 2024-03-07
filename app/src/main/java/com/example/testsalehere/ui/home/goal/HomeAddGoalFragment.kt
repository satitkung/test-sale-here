package com.example.testsalehere.ui.home.goal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testsalehere.databinding.FragmentHomeAddGoalBinding
import com.example.testsalehere.extension.observeFor
import com.example.testsalehere.ui.achievement.adapter.GridSpacingItemDecoration
import com.example.testsalehere.ui.home.dashboard.HomeDashboardFragment.Companion.ADD_GOAL_REQUEST_CODE
import com.example.testsalehere.ui.home.goal.adapter.TagAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeAddGoalFragment : Fragment() {

    private lateinit var binding: FragmentHomeAddGoalBinding
    private val viewModel: HomeAddGoalViewModel by viewModels()
    private val adapter: TagAdapter by lazy { TagAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentFragmentManager.popBackStack()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeAddGoalBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserver()
        viewModel.loadData()
    }

    private fun initObserver() {
        observeFor(viewModel.tagList) {
            adapter.submitList(it.toList())
        }
    }

    private fun initView() {

        binding.topBar.edtGoal.requestFocus()
        binding.rcvTag.layoutManager = GridLayoutManager(context, 3)
        binding.rcvTag.addItemDecoration(
            GridSpacingItemDecoration(
                spanCount = 3,
                spacing = 50
            )
        )
        binding.rcvTag.adapter = adapter

        binding.btnAdd.setOnClickListener {
            setFragmentResult(ADD_GOAL_REQUEST_CODE, Bundle())
            parentFragmentManager.popBackStack()
        }
    }

}