package com.github.hunachi.wantedly_coding_challenge_android.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.github.hunachi.wantedly_api.domain.DataRepository
import com.github.hunachi.wantedly_coding_challenge_android.data.DataSourceFactory
import com.github.hunachi.wantedly_coding_challenge_android.domain.DataItemListener
import com.github.hunachi.wantedly_coding_challenge_android.domain.dataList.paging.NetWorkState
import com.github.hunachi.wantedly_coding_challenge_android.domain.dataList.paging.SearchData
import com.github.hunachi.wantedly_coding_challenge_android.ui.dataList.DataBoundaryCallback
import com.github.hunachi.wantedly_coding_challenge_android.ui.dataList.DataViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: DataRepository
) : ViewModel() {
    
    private val keyWord: MutableLiveData<SearchData> = MutableLiveData()
    
    private var factory: DataSourceFactory? = null
    
    val datas: LiveData<PagedList<DataViewModel>> = Transformations.switchMap(
        keyWord, { _ ->
            /*Repositoryとかを別で作るべき*/
            val config = PagedList.Config.Builder()
                //nullのitemをカウントするかどうか？（デフォルトはtrue）
                .setEnablePlaceholders(false)
                //最初に読み込むitemの数．
                .setInitialLoadSizeHint(PER_PAGE)
                // Listがどれくらいスクロールされたら次のpageの読み込むか決める(引数は表示されているitemとリスト末尾の距離)
                .setPrefetchDistance(PER_PAGE * 3)
                //1ページ(一回に読み込む)item数を指定．
                .setPageSize(PER_PAGE)
                .build()
            factory?.let {
                LivePagedListBuilder(it, config)
                    //BoundaryCallbackはここでset．
                    .setBoundaryCallback(DataBoundaryCallback())
                    .build()
            }
        }
    )
    
    fun search(keyWord: String, listener: DataItemListener) {
        factory = DataSourceFactory(repository, listener, keyWord)
        this.keyWord.value = SearchData(listener, keyWord)
    }
    
    companion object {
        private const val PER_PAGE = 10
    }
}