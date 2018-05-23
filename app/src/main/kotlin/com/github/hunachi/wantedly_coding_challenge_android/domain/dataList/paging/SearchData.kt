package com.github.hunachi.wantedly_coding_challenge_android.domain.dataList.paging

import com.github.hunachi.wantedly_coding_challenge_android.domain.DataItemListener

data class SearchData(
        val listener: DataItemListener,
        val keyWord: String
)