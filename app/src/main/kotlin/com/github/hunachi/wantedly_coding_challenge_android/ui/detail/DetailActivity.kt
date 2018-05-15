package com.github.hunachi.wantedly_coding_challenge_android.ui.detail

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.hunachi.wantedly_api.domain.data.Data
import com.github.hunachi.wantedly_coding_challenge_android.R
import com.github.hunachi.wantedly_coding_challenge_android.databinding.ActivityDetailBinding
import com.github.hunachi.wantedly_coding_challenge_android.domain.detail.DetailData
import com.github.hunachi.wantedly_coding_challenge_android.domain.detail.convertDitailData

class DetailActivity : AppCompatActivity() {
    
    private val binding: ActivityDetailBinding by lazy {
        DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding.data = intent.getSerializableExtra(EXTRA_DATA) as DetailData
    }
    
    companion object {
        
        private const val EXTRA_DATA = "data"
        
        fun start(context: Context, data: Data) {
            
            context.startActivity(Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_DATA, data.convertDitailData())
            })
        }
    }
}
