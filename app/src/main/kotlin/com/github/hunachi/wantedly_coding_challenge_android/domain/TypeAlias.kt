package com.github.hunachi.wantedly_coding_challenge_android.domain

import com.github.hunachi.wantedly_api.domain.data.Data

typealias DataItemListener = (Data) -> Unit

typealias SearchListener = (String) -> Unit