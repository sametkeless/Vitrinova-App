package com.tolerans.vitrinova.ui.adapter

import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import com.tolerans.vitrinova.R
import com.tolerans.vitrinova.data.model.DiscoverItem
import com.tolerans.vitrinova.databinding.*
import com.tolerans.vitrinova.ui.main.MainFragmentDirections
import com.tolerans.vitrinova.util.Constant
import com.tolerans.vitrinova.util.Constant.CATEGORIES
import com.tolerans.vitrinova.util.Constant.COLLECTIONS
import com.tolerans.vitrinova.util.Constant.EDITOR_SHOPS

import com.tolerans.vitrinova.util.Constant.FEATURED
import com.tolerans.vitrinova.util.Constant.NEW_PRODUCTS
import com.tolerans.vitrinova.util.Constant.PRODUCTS
import com.tolerans.vitrinova.util.DepthPageTransformer



class DiscoverParentRvAdapter constructor(val discoverItemList : List<DiscoverItem>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class FeaturedViewHolder(val binding: LayoutFeaturedBinding):RecyclerView.ViewHolder(binding.root){

        fun setData(baseElementItem:DiscoverItem){

            binding.apply {
               viewPagerMain.adapter = FeaturedLayoutViewPagerAdapter(baseElementItem.featured)
                viewPagerMain.setPageTransformer(DepthPageTransformer())
                item = baseElementItem
                executePendingBindings()



            }

        }

    }
    inner  class ProductsViewHolder(val binding: LayoutProductsBinding):RecyclerView.ViewHolder(binding.root){

        fun setData(baseElementItem: DiscoverItem){
            binding.apply {
               item = baseElementItem
               rvProduct.adapter = ProductRvAdapter(baseElementItem.products)
                executePendingBindings()
                binding.showAllProduct.setOnClickListener {v->
                    item?.let {
                        val directions = MainFragmentDirections.actionMainFragmentToProductDetailFragment(it)
                        v.findNavController().navigate(directions)
                    }
                }
            }
        }

    }
    inner class CategoriesViewHolder(val binding: LayoutCategoriesBinding):RecyclerView.ViewHolder(binding.root){

        fun setData(baseElementItem:DiscoverItem){
            binding.apply {
                item = baseElementItem
                rvCategory.adapter = CategoryRvAdapter(baseElementItem.categories)
                executePendingBindings()
            }
        }

    }
    inner  class CollectionsViewHolder(val binding: LayoutCollectionsBinding):RecyclerView.ViewHolder(binding.root){
        fun setData(baseElementItem:DiscoverItem){

            binding.apply {
                item = baseElementItem
                rvCollection.adapter = CollectionRvAdapter(baseElementItem.collections)
                executePendingBindings()

                binding.showAllCollection.setOnClickListener {v->
                    item?.let {
                        val directions = MainFragmentDirections.actionMainFragmentToCollectionsFragment(it)
                        v.findNavController().navigate(directions)
                    }
                }
            }
        }

    }
    inner class NewProductViewHolder(val binding: LayoutNewProductsBinding):RecyclerView.ViewHolder(binding.root){

        fun setData(baseElementItem:DiscoverItem){

            binding.apply {
                item = baseElementItem
                rvNewProducts.adapter = NewProductsRvAdapter(baseElementItem.shops)
                executePendingBindings()

                binding.showAllNewProduct.setOnClickListener {v->
                    item?.let {
                        val directions = MainFragmentDirections.actionMainFragmentToNewShopListFragment(it)
                        v.findNavController().navigate(directions)
                    }
                }
            }
        }

    }
    inner class EditorShopViewHolder(val binding: LayoutEditorShopsBinding):RecyclerView.ViewHolder(binding.root){

        fun setData(baseElementItem:DiscoverItem){
            binding.apply {
                item = baseElementItem
                val snapHelper = GravitySnapHelper(Gravity.CENTER)
                snapHelper.attachToRecyclerView(rvEditorShops)
                rvEditorShops.adapter = EditorShopsRvAdapter(baseElementItem.shops)
                viewPagerEditorShops.adapter= EditorShopsViewPagerAdapter(baseElementItem.shops)
                viewPagerEditorShops.isUserInputEnabled = false
                scrollViewPager()
                executePendingBindings()


                binding.showAllEditorShop.setOnClickListener {v->
                    item?.let {
                        val directions = MainFragmentDirections.actionMainFragmentToEditorShopListFragment(it)
                        v.findNavController().navigate(directions)
                    }
                }
            }

        }

        fun scrollViewPager(){
            binding.apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    rvEditorShops.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                            super.onScrolled(recyclerView, dx, dy)
                            var layoutManager: LinearLayoutManager =
                                recyclerView.layoutManager as LinearLayoutManager

                            var position =  layoutManager.findLastCompletelyVisibleItemPosition()
                            if(position != RecyclerView.NO_POSITION)
                                viewPagerEditorShops.setCurrentItem(
                                   position,
                                    true
                                )
                        }
                    })
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            FEATURED->{
                 return FeaturedViewHolder( DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.layout_featured,parent,false))
            }
            PRODUCTS->{
                return  ProductsViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.layout_products,parent,false))
            }
            CATEGORIES->{
                return CategoriesViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.layout_categories,parent,false))
            }
            COLLECTIONS->{
                return  CollectionsViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.layout_collections,parent,false))
            }
            EDITOR_SHOPS->{
                return  EditorShopViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.layout_editor_shops,parent,false))
            }
            NEW_PRODUCTS->{
                return  NewProductViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.layout_new_products,parent,false))

            }
            else->{
                return throw Exception("unvalid type")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            when(position){
                FEATURED->{
                   val innerHolder:FeaturedViewHolder = holder as FeaturedViewHolder
                    innerHolder.setData(discoverItemList.get(position))
                }

                PRODUCTS->{
                    val innerHolder:ProductsViewHolder = holder as ProductsViewHolder
                    innerHolder.setData(discoverItemList.get(position))
                }

                CATEGORIES->{
                    val innerHolder:CategoriesViewHolder = holder as CategoriesViewHolder
                    innerHolder.setData(discoverItemList.get(position))
                }

                COLLECTIONS->{
                    val innerHolder:CollectionsViewHolder = holder as CollectionsViewHolder
                    innerHolder.setData(discoverItemList.get(position))
                }
                EDITOR_SHOPS->{
                    val innerHolder:EditorShopViewHolder = holder as EditorShopViewHolder
                    innerHolder.setData(discoverItemList.get(position))
                }
                NEW_PRODUCTS->{
                    val innerHolder:NewProductViewHolder = holder as NewProductViewHolder
                    innerHolder.setData(discoverItemList.get(position))
                }
            }
    }

    override fun getItemCount(): Int =
            discoverItemList.size

    override fun getItemViewType(position: Int): Int {
        return position
    }
}

