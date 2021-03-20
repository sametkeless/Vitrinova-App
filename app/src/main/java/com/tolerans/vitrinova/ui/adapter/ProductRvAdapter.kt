package com.tolerans.vitrinova.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tolerans.vitrinova.R
import com.tolerans.vitrinova.data.model.Product
import com.tolerans.vitrinova.databinding.ItemProductsRvBinding

class ProductRvAdapter(val listProduct: List<Product>):  ListAdapter<Product,ProductRvAdapter.ProductViewHolder>(ProductDiffCallback())  {

    class ProductViewHolder(val databinding: ItemProductsRvBinding) : RecyclerView.ViewHolder(databinding.root) {

        fun setDataHolder(product: Product){

            databinding.apply {
                this.product = product
                executePendingBindings()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
            ProductViewHolder(
                    DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                            R.layout.item_products_rv,
                            parent,false))


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.setDataHolder(listProduct.get(position))
    }

    override fun getItemCount(): Int =
            listProduct.size


}

private class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}