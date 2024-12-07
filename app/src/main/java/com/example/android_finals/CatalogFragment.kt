package com.example.android_finals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_finals.databinding.FragmentCatalogBinding

class CatalogFragment : Fragment() {

    companion object {
        fun newInstance() = CatalogFragment()
    }

    private var _binding: FragmentCatalogBinding? = null
    private val binding: FragmentCatalogBinding get() = _binding!!

    private var adapter: ItemCardAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ItemCardAdapter()
        binding.recyclerView.adapter = adapter

        adapter!!.submitList(DataSource.items)
    }

}