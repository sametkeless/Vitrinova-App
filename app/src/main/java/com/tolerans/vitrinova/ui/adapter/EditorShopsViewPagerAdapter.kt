package com.tolerans.vitrinova.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tolerans.vitrinova.R
import com.tolerans.vitrinova.data.model.Shop
import com.tolerans.vitrinova.databinding.ItemEditorShopsViewpagerBinding
import com.tolerans.vitrinova.util.setBlackFilter



class EditorShopsViewPagerAdapter(val listShop: List<Shop>):
    ListAdapter<Shop, EditorShopsViewPagerAdapter.ShopViewHolder>(ShopDiffCallback()) {

    class ShopViewHolder(val databinding: ItemEditorShopsViewpagerBinding) : RecyclerView.ViewHolder(databinding.root) {

        fun setDataHolder(shop: Shop){

            databinding.apply {
                sliderItem = shop
                img.setBlackFilter()
                executePendingBindings()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder =
        ShopViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_editor_shops_viewpager,
                parent,false))


    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.setDataHolder(listShop.get(position))
    }

    override fun getItemCount(): Int =
        listShop.size



}
