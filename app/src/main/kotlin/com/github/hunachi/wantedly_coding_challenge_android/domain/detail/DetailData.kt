package com.github.hunachi.wantedly_coding_challenge_android.domain.detail

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.io.Serializable

data class DetailData(
    val title: String,
    val companyAvatar: String,
    val companyName: String,
    val urlImage: String,
    val description: String
) : Serializable {
    companion object {
        
        @JvmStatic
        @BindingAdapter("loadStringImage")
        fun ImageView.loadStringImage(url: String) {
            url.let {
                Glide.with(this).load(it)
                    .apply(RequestOptions.errorOf(null))
                    .into(this)
            }
        }
        
        @JvmStatic
        @BindingAdapter("loadStringCircleImage")
        fun ImageView.loadStringCircleImage(url: String) {
            url.let {
                Glide.with(this).load(it)
                    .apply(RequestOptions.circleCropTransform())
                    .into(this)
            }
        }
        
    }
}