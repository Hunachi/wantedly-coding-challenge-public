package com.github.hunachi.wantedly_api.domain.data.leader

data class Leader(
    val nameJp: String,
    val nameEn: String
) {
    fun name(isJapanese: Boolean): String = if (isJapanese) nameJp else nameEn
}