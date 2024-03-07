package com.example.testsalehere.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testsalehere.R
import com.example.testsalehere.databinding.FragmentHomeMainBinding
import com.example.testsalehere.ui.home.dashboard.HomeDashboardFragment


class HomeMainFragment : Fragment() {

    private lateinit var binding: FragmentHomeMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val fragmentManager = childFragmentManager.beginTransaction()
        fragmentManager.replace(R.id.home_main_layout, HomeDashboardFragment()).addToBackStack(null)
        fragmentManager.commit()
    }

}