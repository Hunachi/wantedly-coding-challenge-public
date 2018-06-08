package com.github.hunachi.wantedly_coding_challenge_android.ui.dataList

import android.arch.paging.PagedList
import android.util.Log

/*memo*/
class DataBoundaryCallback : PagedList.BoundaryCallback<DataViewModel>() {
    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()
        Log.e("loading", "データがなかったよ！")
    }
    
    override fun onItemAtFrontLoaded(itemAtFront: DataViewModel) {
        super.onItemAtFrontLoaded(itemAtFront)
        //普通使わない？　もっと前のデータを読み込みたい時に使う？
    }
    
    override fun onItemAtEndLoaded(itemAtEnd: DataViewModel) {
        super.onItemAtEndLoaded(itemAtEnd)
        Log.d("loading", "データを全部表示し終わったよ！")
    }
}