package com.github.hunachi.wantedly_coding_challenge_android.ui.main

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.github.hunachi.wantedly_coding_challenge_android.R
import com.github.hunachi.wantedly_coding_challenge_android.databinding.ActivityMainBinding
import com.github.hunachi.wantedly_coding_challenge_android.domain.DataItemListener
import com.github.hunachi.wantedly_coding_challenge_android.domain.SearchListener
import com.github.hunachi.wantedly_coding_challenge_android.domain.dataList.paging.NetWorkState
import com.github.hunachi.wantedly_coding_challenge_android.ui.dataList.DataRecyclerViewAdapter
import com.github.hunachi.wantedly_coding_challenge_android.ui.detail.DetailActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
    
    private val dataRecyclerViewAdapter = DataRecyclerViewAdapter()
    
    @Inject
    lateinit var mainViewModel: MainViewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding.also {
            it.mainView = this
            it.setLifecycleOwner(this)
        }
        
        with(binding.list) {
            layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
            adapter = dataRecyclerViewAdapter
        }
        
        mainViewModel.also {
            binding.mainViewModel = it
            
            mainViewModel.datas.observe(this, Observer {list ->
                if (list == null) return@Observer
                dataRecyclerViewAdapter.submitList(list)
            })
        }
    }
    
    private val dataItemListener: DataItemListener = {
        DetailActivity.start(this, it)
    }
    
    val onTextChange: SearchListener = { str: String ->
        mainViewModel.search(str, dataItemListener)
    }
}
