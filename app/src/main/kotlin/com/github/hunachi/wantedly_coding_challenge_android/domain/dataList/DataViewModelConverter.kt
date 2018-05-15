package com.github.hunachi.wantedly_coding_challenge_android.domain.dataList

import com.github.hunachi.wantedly_api.domain.data.Data
import com.github.hunachi.wantedly_coding_challenge_android.domain.DataItemListener
import com.github.hunachi.wantedly_coding_challenge_android.ui.dataList.DataViewModel

internal fun Data.convertToViewModel(listner: DataItemListener): DataViewModel =
    DataViewModel(
        data = this,
        listener = listner
    )