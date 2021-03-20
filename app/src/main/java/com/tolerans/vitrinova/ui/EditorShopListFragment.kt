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
import com.tolerans.vitrinova.ui.adapter.EditorShopsRvAdapter


class EditorShopListFragment : Fragment() {
    private val args:EditorShopListFragmentArgs by navArgs()
    private lateinit var discoverItem: DiscoverItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        discoverItem = args.item
        return inflater.inflate(R.layout.fragment_editor_shop_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val rv = view.findViewById<RecyclerView>(R.id.rv_edit_shoplist)

        rv.adapter = EditorShopsRvAdapter(discoverItem.shops)

    }


}