package com.tolerans.vitrinova.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tolerans.vitrinova.R
import com.tolerans.vitrinova.data.model.Shop
import com.tolerans.vitrinova.databinding.ItemNewproductsRvBinding

class NewProductsRvAdapter(val listNewProduct: List<Shop>): ListAdapter<Shop, NewProductsRvAdapter.NewProductViewHolder>(ShopDiffCallback()){

    class NewProductViewHolder(val databinding: ItemNewproductsRvBinding) : RecyclerView.ViewHolder(databinding.root) {

        fun setDataHolder(shop: Shop){
            databinding.apply {
                this.shop = shop
                executePendingBindings()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewProductViewHolder =
            NewProductViewHolder(
                    DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                            R.layout.item_newproducts_rv,
                            parent,false))


    override fun onBindViewHolder(holder: NewProductViewHolder, position: Int) {
        holder.setDataHolder(listNewProduct.get(position))
    }

    override fun getItemCount(): Int =
            listNewProduct.size

}