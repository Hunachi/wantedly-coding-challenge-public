package com.github.hunachi.wantedly_coding_challenge_android.ui.dataList

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import com.github.hunachi.wantedly_api.domain.data.Data
import com.github.hunachi.wantedly_coding_challenge_android.BR
import com.github.hunachi.wantedly_coding_challenge_android.domain.DataItemListener
import com.github.hunachi.wantedly_coding_challenge_android.domain.dataList.ExpandableLayoutState
import net.cachapa.expandablelayout.ExpandableLayout

class DataViewModel(
    val data: Data,
    private val listener: DataItemListener
) : BaseObservable() {
    
    @Bindable
    var expanding: ExpandableLayoutState = ExpandableLayoutState.INIT
        set(value) {
            field = value
            notifyPropertyChanged(BR.expanding)
        }
    
    val description: String = data.description.let {
        if (it.length > 150) "${it.substring(0, 150)}..."
        else it
    }
    
    fun onClickGoDetailText() {
        listener(data)
    }
    
    fun onClickExpand() {
        expanding = if (expanding == ExpandableLayoutState.EXPANDING) ExpandableLayoutState.CLOSING
        else ExpandableLayoutState.EXPANDING
    }
    
    companion object {
        @JvmStatic
        @BindingAdapter("expandListener")
        fun ExpandableLayout.setExpand(state: ExpandableLayoutState) {
            if (state == ExpandableLayoutState.CLOSING) collapse(true)
            else if (state == ExpandableLayoutState.EXPANDING) expand(true)
        }
    }
}