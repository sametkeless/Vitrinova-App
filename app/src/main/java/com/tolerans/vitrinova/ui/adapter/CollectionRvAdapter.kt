package com.tolerans.vitrinova.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tolerans.vitrinova.R
import com.tolerans.vitrinova.data.model.Collection;
import com.tolerans.vitrinova.databinding.ItemCollectionsRvBinding
import com.tolerans.vitrinova.util.setBlackFilter


class CollectionRvAdapter(val listCollection: List<Collection>): ListAdapter<Collection,CollectionRvAdapter.CollectionViewHolder>(CollectionDiffCallback()) {

    class CollectionViewHolder(val databinding: ItemCollectionsRvBinding) : RecyclerView.ViewHolder(databinding.root) {

        fun setDataHolder(collection: Collection){

            databinding.apply {
                this.collection = collection
               imgCollectionItem.setBlackFilter()
                executePendingBindings()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder =
            CollectionViewHolder(
                    DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                            R.layout.item_collections_rv,
                            parent,false))


    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.setDataHolder(listCollection.get(position))
    }

    override fun getItemCount(): Int =
            listCollection.size



}

private class CollectionDiffCallback : DiffUtil.ItemCallback<Collection>() {

    override fun areItemsTheSame(oldItem: Collection, newItem: Collection): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Collection, newItem: Collection): Boolean {
        return oldItem == newItem
    }
}