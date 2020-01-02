package com.tuhao.baselibrary.util

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
abstract class MyBaseAdapter<T>(mData:MutableList<T>,layoutId:Int) : BaseQuickAdapter<T, MyViewHolder>(layoutId,mData) {
    abstract fun myConvert(helper: MyViewHolder, item: T)
    override fun convert(helper: MyViewHolder, item: T) {
        myConvert(helper,item)
    }
}
