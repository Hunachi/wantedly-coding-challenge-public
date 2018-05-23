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
    
    private var nowListCount = 0
    
    private val keyWord: MutableLiveData<SearchData> = MutableLiveData()
    
    private var factory: DataSourceFactory? = null
    
    val datas: LiveData<PagedList<DataViewModel>> = Transformations.switchMap(
        keyWord, { it ->
            factory?.let {
                LivePagedListBuilder(it, PagedList.Config.Builder()
                        .setInitialLoadSizeHint(PER_PAGE)
                        .setPageSize(PER_PAGE)
                        .build()).build()
            }
        }
    )
    
    val netWorkState: LiveData<NetWorkState> = Transformations.switchMap(
        keyWord, { it ->
            factory = DataSourceFactory(repository, it.listener, it.keyWord)
            factory?.dataSource?.netWorkState
        }
    )
    
    val dataState: LiveData<Boolean> = Transformations.map(
        netWorkState, { it ->
            when {
                it == null                 -> false
                it == NetWorkState.LOADING -> true
                nowListCount == 0          -> false
                else                       -> true
            }
        }
    )
    
    fun setListCount(count: Int) {
        nowListCount = count
    }
    
    fun search(keyWord: String, listener: DataItemListener) {
        nowListCount = -1
        this.keyWord.value = SearchData(listener, keyWord)
    }
    
    companion object {
        private const val PER_PAGE = 10
    }
}