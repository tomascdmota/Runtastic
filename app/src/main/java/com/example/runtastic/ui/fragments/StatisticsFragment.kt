package com.example.runtastic.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.runtastic.R
import com.example.runtastic.ui.viewmodels.MainViewModel
import com.example.runtastic.ui.viewmodels.StatisticsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticsFragment: Fragment(R.layout.fragment_statistics) {

    private val viewModel: StatisticsViewModel by viewModels()
}