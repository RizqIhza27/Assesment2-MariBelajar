package com.example.assesment2_maribelajar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.assesment2_maribelajar.network.HewanApi
import com.example.assesment2_maribelajar.databinding.FragmentListHewanBinding

class ListHewanFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private lateinit var binding: FragmentListHewanBinding
    private lateinit var myAdapter: MainAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentListHewanBinding.inflate(layoutInflater, container, false)
        myAdapter = MainAdapter()
        with(binding.wawa) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner, {
            myAdapter.updateData(it)
        })
        viewModel.getStatus().observe(viewLifecycleOwner, {
            updateProgress(it)
        })

    }
    private fun updateProgress(status: HewanApi.ApiStatus) {
        when (status) {
            HewanApi.ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            HewanApi.ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
            }
            HewanApi.ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }



}