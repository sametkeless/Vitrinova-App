package com.tolerans.vitrinova.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tolerans.vitrinova.R
import com.tolerans.vitrinova.data.model.Featured
import com.tolerans.vitrinova.databinding.ItemFeaturedSliderImageBinding
import com.tolerans.vitrinova.util.setBlackFilter


public class FeaturedLayoutViewPagerAdapter(val listFeatured: List<Featured>):ListAdapter<Featured,FeaturedLayoutViewPagerAdapter.FeaturedViewHolder>(FeaturedDiffCallback()) {

     class FeaturedViewHolder(val databinding:ItemFeaturedSliderImageBinding) : RecyclerView.ViewHolder(databinding.root) {

         fun setDataHolder(featured:Featured){

             databinding.apply {
                 sliderItem = featured
                 img.setBlackFilter()
                 executePendingBindings()
             }

         }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedViewHolder =
            FeaturedViewHolder(
           DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.item_featured_slider_image,
            parent,false))


    override fun onBindViewHolder(holder: FeaturedViewHolder, position: Int) {
        holder.setDataHolder(listFeatured.get(position))
    }

    override fun getItemCount(): Int =
            listFeatured.size



}

private class FeaturedDiffCallback : DiffUtil.ItemCallback<Featured>() {

    override fun areItemsTheSame(oldItem: Featured, newItem: Featured): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Featured, newItem: Featured): Boolean {
        return oldItem == newItem
    }
}