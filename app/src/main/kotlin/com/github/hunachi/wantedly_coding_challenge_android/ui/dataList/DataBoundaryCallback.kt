package com.github.hunachi.wantedly_coding_challenge_android.ui.dataList

import android.arch.paging.PagedList
import android.util.Log

/*memo*/
class DataBoundaryCallback : PagedList.BoundaryCallback<DataViewModel>() {
    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()
        Log.e("loading", "アイテムが0だったよ！")
    }
    
    override fun onItemAtFrontLoaded(itemAtFront: DataViewModel) {
        super.onItemAtFrontLoaded(itemAtFront)
        Log.d("loading", "最初の読み込み中！")
    }
    
    override fun onItemAtEndLoaded(itemAtEnd: DataViewModel) {
        super.onItemAtEndLoaded(itemAtEnd)
        Log.d("loading", "読み込み終わったよ！")
    }
}