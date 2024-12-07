package com.example.android_finals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.android_finals.databinding.FragmentCatalogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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


        ApiSource.client.fetchAllItems().enqueue(object : Callback<List<Item>> {
            override fun onResponse(p0: Call<List<Item>>, p1: Response<List<Item>>) {

                if (p1.isSuccessful) {
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()

                    val items = p1.body()
                    if (!items.isNullOrEmpty()) {
                        adapter?.submitList(items)
                    } else {
                        Toast.makeText(context, "No items", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Response isn't successful", Toast.LENGTH_SHORT).show()
                }


            }

            override fun onFailure(p0: Call<List<Item>>, p1: Throwable) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }

        })
    }

}