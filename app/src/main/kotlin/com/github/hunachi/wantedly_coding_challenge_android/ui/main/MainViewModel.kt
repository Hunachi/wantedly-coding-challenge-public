package com.github.hunachi.wantedly_coding_challenge_android.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.util.Log
import com.github.hunachi.wantedly_api.domain.DataRepository
import com.github.hunachi.wantedly_coding_challenge_android.data.DataSourceFactory
import com.github.hunachi.wantedly_coding_challenge_android.domain.DataItemListener
import com.github.hunachi.wantedly_coding_challenge_android.domain.dataList.paging.NetWorkState
import com.github.hunachi.wantedly_coding_challenge_android.domain.dataList.paging.SearchData
import com.github.hunachi.wantedly_coding_challenge_android.ui.dataList.DataViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
        private val repository: DataRepository
) : ViewModel() {
    
    private var loadingCount = 0
    private var nowListCount = 0
    
    private val keyWord: MutableLiveData<SearchData> = MutableLiveData()
    
    val datas: LiveData<PagedList<DataViewModel>> = Transformations.switchMap(
        keyWord, { it ->
            LivePagedListBuilder(DataSourceFactory(repository, it.listener, it.keyWord), PagedList.Config.Builder()
                    .setInitialLoadSizeHint(PER_PAGE)
                    .setPageSize(PER_PAGE)
                    .build()).build()
        }
    )
    
    val netWorkState: LiveData<NetWorkState> = Transformations.switchMap(
        keyWord, { it ->
            DataSourceFactory(repository, it.listener, it.keyWord).dataSource.netWorkState
        }
    )
    
    val dataState: MutableLiveData<Boolean> = MutableLiveData()
    
    fun setState(state: NetWorkState) {
        if (state == NetWorkState.LOADING) loadingCount++
        else {
            loadingCount--
            if (nowListCount == 0 && loadingCount == 0) dataState.value = false
        }
    }
    
    fun setListCount(count: Int) {
        nowListCount = count
    }
    
    fun search(keyWord: String, listener: DataItemListener) {
        nowListCount = 0
        dataState.value = true
        this.keyWord.value = SearchData(listener, keyWord)
    }
    
    companion object {
        private const val PER_PAGE = 10
    }
}