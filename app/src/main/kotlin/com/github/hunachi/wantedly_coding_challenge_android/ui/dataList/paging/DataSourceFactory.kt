package com.github.hunachi.wantedly_coding_challenge_android.ui.dataList.paging

import android.arch.paging.DataSource
import com.github.hunachi.wantedly_api.domain.DataRepository
import com.github.hunachi.wantedly_coding_challenge_android.domain.DataItemListener
import com.github.hunachi.wantedly_coding_challenge_android.ui.dataList.DataViewModel

class DataSourceFactory(
    repository: DataRepository,
    dataItemListener: DataItemListener,
    keyWord: String
) : DataSource.Factory<Int, DataViewModel>() {
    
    val dataSource = PageKeyedDataSource(repository, dataItemListener, keyWord)
    
    override fun create(): DataSource<Int, DataViewModel> = dataSource
}