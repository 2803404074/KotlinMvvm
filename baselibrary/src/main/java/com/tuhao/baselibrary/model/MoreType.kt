package com.tuhao.baselibrary.model

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * 多类型item
 */
open class MoreType : MultiItemEntity {
    var layoutId:Int = 0
    private var itemType: Int = 0

    constructor(layoutId:Int,itemType: Int){
        this.layoutId = layoutId
        this.itemType = itemType
    }

    override fun getItemType(): Int {
        return this.itemType
    }
}