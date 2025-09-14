package com.example.nit3213app.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213app.adapter.EntityAdapter
import com.example.nit3213app.viewmodel.DashboardViewModel
import com.example.nit3213app.R
import kotlinx.coroutines.flow.collect

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModel: DashboardViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Collect dashboard data
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.dashboardData.collect { dashboardResponse ->
                dashboardResponse?.entities?.let { entities ->
                    if (entities.isNotEmpty()) {
                        recyclerView.adapter = EntityAdapter(entities) { artwork ->
                            // On item click
                            Toast.makeText(requireContext(), "No entities available", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }


        // Trigger API call with your keypass
        viewModel.loadDashboard("art") // Replace "art" with actual keypass from login
    }
}
