package com.tuhao.baselibrary.util

import android.view.View
import android.widget.ImageView
import com.chad.library.adapter.base.BaseViewHolder
import com.facebook.drawee.view.SimpleDraweeView

class MyViewHolder(v:View) : BaseViewHolder(v) {
    fun setImageByUrl(viewId: Int, path: String?): BaseViewHolder {
        val view = getView<ImageView>(viewId)
        GlideImageLoader().displayImage(null,path,view)
        return this
    }

    fun setDraViewByUrl(viewId: Int, path: String?): BaseViewHolder {
        val view = getView<SimpleDraweeView>(viewId)
        view.setImageURI(path)
        return this
    }
}