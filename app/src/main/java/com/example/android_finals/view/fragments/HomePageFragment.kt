package com.example.android_finals.activities.com.example.android_finals.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_finals.view.adapter.ItemAdapter
import com.example.android_finals.model.entity.MainPageItem
import com.example.android_finals.R
import com.example.android_finals.databinding.FragmentMainPageBinding

class HomePageFragment : Fragment() {

    private var _binding: FragmentMainPageBinding? = null
    private val binding: FragmentMainPageBinding get() = _binding!!

    companion object {
        fun newInstance() = HomePageFragment()
    }

    // Sample data for the ListView
    private val items = listOf(
        MainPageItem(R.drawable.new_collection, "New Collection"),
        MainPageItem(R.drawable.best_sellers, "Best Sellers"),
        MainPageItem(R.drawable.new_arrivals, "New Arrivals"),
        MainPageItem(R.drawable.jewellery, "Jewellery"),
        MainPageItem(R.drawable.matching_sets, "Matching Sets")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ItemAdapter(requireContext(), items)
        binding.listView.adapter = adapter
    }

}
