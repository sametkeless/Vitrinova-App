package com.tolerans.vitrinova.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.tolerans.vitrinova.R
import com.tolerans.vitrinova.data.model.DiscoverItem
import com.tolerans.vitrinova.ui.adapter.NewProductsRvAdapter
import com.tolerans.vitrinova.ui.adapter.ProductRvAdapter


class ProductDetailFragment : Fragment() {
    private val args:ProductDetailFragmentArgs by navArgs()
    private lateinit var discoverItem: DiscoverItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        discoverItem = args.item
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val rv = view.findViewById<RecyclerView>(R.id.rv_product_list)

        rv.adapter = ProductRvAdapter(discoverItem.products)
    }

}