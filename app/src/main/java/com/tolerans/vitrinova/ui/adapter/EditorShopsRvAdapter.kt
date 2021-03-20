package com.tolerans.vitrinova.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tolerans.vitrinova.R
import com.tolerans.vitrinova.data.model.Shop
import com.tolerans.vitrinova.databinding.ItemEditorshopsRvBinding


class EditorShopsRvAdapter(val listNewProduct: List<Shop>):ListAdapter<Shop,EditorShopsRvAdapter.EditorShopsViewHolder>(ShopDiffCallback()) {

    class EditorShopsViewHolder(val databinding: ItemEditorshopsRvBinding) : RecyclerView.ViewHolder(databinding.root) {

        fun setDataHolder(shop: Shop){
            databinding.apply {
                this.shop = shop
                executePendingBindings()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditorShopsViewHolder =
            EditorShopsViewHolder(
                    DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                            R.layout.item_editorshops_rv,
                            parent,false))


    override fun onBindViewHolder(holder: EditorShopsViewHolder, position: Int) {
        holder.setDataHolder(listNewProduct.get(position))
    }

    override fun getItemCount(): Int =
            listNewProduct.size

}
class ShopDiffCallback:DiffUtil.ItemCallback<Shop>(){
    override fun areItemsTheSame(oldItem: Shop, newItem: Shop): Boolean {
        return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Shop, newItem: Shop): Boolean {
        return oldItem == newItem
    }

}