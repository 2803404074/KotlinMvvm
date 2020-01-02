package com.tuhao.baselibrary.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.tuhao.baselibrary.R
import com.tuhao.baselibrary.app.MyApplication
import com.youth.banner.loader.ImageLoader

class GlideImageLoader: ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        if (imageView != null) {
            Glide.with(MyApplication.instance)
                .load(path)
                .placeholder(R.drawable.no_banner)
                .error(R.drawable.no_banner)
                .centerCrop().into(imageView)
        }
    }
}