package com.example.testsalehere.ui.achievement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testsalehere.databinding.FragmentAchievementBinding
import com.example.testsalehere.extension.observeFor
import com.example.testsalehere.ui.achievement.adapter.AchievementAdapter
import com.example.testsalehere.ui.achievement.adapter.GridSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AchievementFragment : Fragment() {

    private lateinit var binding: FragmentAchievementBinding
    private val viewModel: AchievementViewModel by viewModels()
    private val adapter: AchievementAdapter by lazy { AchievementAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAchievementBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        initView()
        initObserver()
        viewModel.loadData()
    }

    private fun initView() {
        binding.rcvAchievement.layoutManager = GridLayoutManager(context, 3)
        binding.rcvAchievement.addItemDecoration(
            GridSpacingItemDecoration(
                spanCount = 3,
                spacing = 40
            )
        )
        binding.rcvAchievement.adapter = adapter

    }

    private fun initObserver() {
        observeFor(viewModel.achievementList) {
            adapter.submitList(it.toList())
        }
    }

}