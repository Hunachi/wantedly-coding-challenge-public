package com.github.hunachi.wantedly_coding_challenge_android.ui.dataList.paging

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PageKeyedDataSource
import com.github.hunachi.wantedly_api.domain.DataRepository
import com.github.hunachi.wantedly_coding_challenge_android.domain.DataItemListener
import com.github.hunachi.wantedly_coding_challenge_android.domain.dataList.convertToViewModel
import com.github.hunachi.wantedly_coding_challenge_android.domain.dataList.paging.NetWorkState
import com.github.hunachi.wantedly_coding_challenge_android.ui.dataList.DataViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

class PageKeyedDataSource(
    private val repository: DataRepository,
    private val dataItemListener: DataItemListener,
    private val keyWord: String
) : PageKeyedDataSource<Int, DataViewModel>() {
    
    private val _netWorkState: MutableLiveData<NetWorkState> = MutableLiveData()
    val netWorkState: LiveData<NetWorkState> = _netWorkState
    
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, DataViewModel>
    ) {
        callApi(0, params.requestedLoadSize) { datas, next ->
            callback.onResult(datas, null, next)
        }
    }
    
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DataViewModel>) {}
    
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DataViewModel>) {
        callApi(params.key, params.requestedLoadSize) { datas, next ->
            callback.onResult(datas, next)
        }
    }
    
    private fun callApi(
        page: Int,
        perPage: Int,
        callback: (datas: List<DataViewModel>, next: Int?) -> Unit
    ) {
        
        _netWorkState.postValue(NetWorkState.LOADING)
        
        repository.data(keyWord, page.toLong()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val next = if (it.size < perPage || page > 5) null else page + 1
                _netWorkState.postValue(NetWorkState.SUCCESS)
                callback(it.map { it.convertToViewModel(dataItemListener) }, next)
            }, {
                _netWorkState.postValue(NetWorkState.FAILED)
            })
    }
}