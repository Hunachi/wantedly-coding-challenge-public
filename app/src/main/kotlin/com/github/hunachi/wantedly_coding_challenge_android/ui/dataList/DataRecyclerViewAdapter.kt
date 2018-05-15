package com.github.hunachi.wantedly_coding_challenge_android.ui.dataList

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.hunachi.wantedly_coding_challenge_android.R
import com.github.hunachi.wantedly_coding_challenge_android.databinding.ItemDataBinding

internal class DataRecyclerViewAdapter :
    PagedListAdapter<DataViewModel, DataRecyclerViewAdapter.ViewHolder>(DIFF_UTIL) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data, parent, false)
        return ViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.dataViewModel = getItem(position)
    }
    
    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemDataBinding = ItemDataBinding.bind(view)
    }
    
    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<DataViewModel>() {
            
            override fun areItemsTheSame(oldItem: DataViewModel, newItem: DataViewModel) =
                oldItem.data.id == newItem.data.id
            
            override fun areContentsTheSame(oldItem: DataViewModel, newItem: DataViewModel) =
                oldItem.data == newItem.data
        }
    }
}
