package com.github.hunachi.wantedly_coding_challenge_android.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.github.hunachi.wantedly_api.domain.DataRepository
import com.github.hunachi.wantedly_coding_challenge_android.domain.DataItemListener
import com.github.hunachi.wantedly_coding_challenge_android.domain.dataList.paging.NetWorkState
import com.github.hunachi.wantedly_coding_challenge_android.ui.dataList.DataViewModel
import com.github.hunachi.wantedly_coding_challenge_android.ui.dataList.paging.DataSourceFactory
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: DataRepository
) : ViewModel() {
    
    lateinit var netWorkState: LiveData<NetWorkState>
        private set
    
    lateinit var datas: LiveData<PagedList<DataViewModel>>
        private set
    
    private val _dataState: MutableLiveData<Boolean> = MutableLiveData()
    val dataState: LiveData<Boolean> = _dataState
    
    fun setUp(keyWord: String, itemListener: DataItemListener) {
        _dataState.value = true
        val config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(PER_PAGE)
            .setPageSize(PER_PAGE)
            .build()
        
        val factory = DataSourceFactory(repository, itemListener, keyWord)
        datas = LivePagedListBuilder(factory, config).build()
        netWorkState = factory.dataSource.netWorkState
    }
    
    fun setNoData() {
        _dataState.value = false
    }
    
    companion object {
        private const val PER_PAGE = 10
    }
}