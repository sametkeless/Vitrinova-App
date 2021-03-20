package com.tolerans.vitrinova.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tolerans.vitrinova.R
import com.tolerans.vitrinova.data.model.Category
import com.tolerans.vitrinova.databinding.ItemCategoriesRvBinding


class CategoryRvAdapter(val listCategory: List<Category>) :
    ListAdapter<Category, CategoryRvAdapter.CategoryViewHolder>(CategoryDiffCallback()) {

    class CategoryViewHolder(val databinding: ItemCategoriesRvBinding) :
        RecyclerView.ViewHolder(databinding.root) {
        fun setDataHolder(category: Category) {
            databinding.apply {
                this.category = category
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_categories_rv,
                parent, false))

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.setDataHolder(listCategory.get(position))
    }

    override fun getItemCount(): Int = listCategory.size
}

private class CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {

    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}