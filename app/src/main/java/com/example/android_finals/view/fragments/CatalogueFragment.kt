package com.example.android_finals.activities.com.example.android_finals.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.android_finals.view.adapter.ItemCardAdapter
import com.example.android_finals.databinding.FragmentCatalogBinding
import com.example.android_finals.viewModel.ItemListUI
import com.example.android_finals.viewModel.ItemViewModel
import com.example.android_finals.viewModel.ItemViewModelFactory


class CatalogueFragment : Fragment() {

    companion object {
        fun newInstance() = CatalogueFragment()
    }

    private var _binding: FragmentCatalogBinding? = null
    private val binding: FragmentCatalogBinding get() = _binding!!

    private var adapter: ItemCardAdapter? = null
    private val viewModel: ItemViewModel by lazy {
        ItemViewModelFactory().create(ItemViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ItemCardAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.fetchItems()

        binding.womensClothing.setOnClickListener {
            adapter?.filterItems("women's clothing")
        }
        binding.mensClothing.setOnClickListener {
            adapter?.filterItems("men's clothing")
        }
        binding.jewelery.setOnClickListener {
            adapter?.filterItems("jewelery")
        }

        configureObserver()
    }


    private fun configureObserver(){
        viewModel.itemsListUI.observe(viewLifecycleOwner){ state->
            when(state){
                is ItemListUI.Success -> adapter?.updateList(state.items)
                is ItemListUI.Error -> Toast.makeText(requireContext(), "Error ! ${state.message}", Toast.LENGTH_LONG).show()
                is ItemListUI.Loading -> binding.progressBar.isVisible = state.isLoading
                is ItemListUI.Empty -> Toast.makeText(requireContext(), "No data", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
