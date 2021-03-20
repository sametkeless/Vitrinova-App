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
import com.tolerans.vitrinova.ui.adapter.CollectionRvAdapter
import com.tolerans.vitrinova.ui.adapter.NewProductsRvAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class NewShopListFragment : Fragment() {
    private val args:NewShopListFragmentArgs by navArgs()
    private lateinit var discoverItem: DiscoverItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        discoverItem = args.item
        return inflater.inflate(R.layout.fragment_new_shop_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv = view.findViewById<RecyclerView>(R.id.rv_new_shoplist)

        rv.adapter = NewProductsRvAdapter(discoverItem.shops)
    }

}