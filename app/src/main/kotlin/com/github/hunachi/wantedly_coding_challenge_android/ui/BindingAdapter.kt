package com.github.hunachi.wantedly_coding_challenge_android.ui

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.SearchView
import com.bumptech.glide.Glide
import com.github.hunachi.common.url.Url
import com.github.hunachi.wantedly_coding_challenge_android.R
import com.github.hunachi.wantedly_coding_challenge_android.domain.dataList.ExpandableLayoutState
import com.bumptech.glide.request.RequestOptions
import com.github.hunachi.wantedly_coding_challenge_android.domain.SearchListener


@BindingAdapter("loadImage")
fun ImageView.loadImage(url: Url) {
    url.value.let {
        Glide.with(this).load(it)
            .apply(RequestOptions.errorOf(null))
            .into(this)
    }
}

@BindingAdapter("loadCircleImage")
fun ImageView.loadCircleImage(url: Url) {
    url.value.let {
        Glide.with(this).load(it)
            .apply(RequestOptions.circleCropTransform())
            .into(this)
    }
}

@BindingAdapter("expandIcon")
fun ImageView.setExpand(state: ExpandableLayoutState) {
    Glide.with(this).load(
        if (state == ExpandableLayoutState.EXPANDING) R.drawable.ic_close else R.drawable.ic_expand
    ).into(this)
}

@BindingAdapter("searchListener")
fun SearchView.setTextListener(listener: SearchListener) =
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        
        override fun onQueryTextSubmit(query: String?) = false
        
        override fun onQueryTextChange(newText: String?): Boolean {
            newText?.let { if (it.isNotBlank()) listener(it) }
            return false
        }
    })
    
