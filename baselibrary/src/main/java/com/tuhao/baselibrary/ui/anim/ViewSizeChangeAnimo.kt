package com.tuhao.baselibrary.ui.anim

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation

class ViewSizeChangeAnimo() : Animation() {
    var initialHeight: Int = 0
    //var targetHeight: Int = 0
    var initialWidth: Int = 0
    var targetWidth: Int = 0
    var view: View? = null

    constructor(view: View) : this() {
        this.view = view;
//        this.targetHeight = targetHeight;
        //this.targetWidth = targetWidth;
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
//        view?.layoutParams!!.height =
//            initialHeight + ((targetHeight - initialHeight) * interpolatedTime) as Int
        view?.layoutParams!!.width =
            initialWidth + ((targetWidth - initialWidth) * interpolatedTime).toInt()
        view?.requestLayout()
    }

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
//        this.initialHeight = height
        this.initialWidth = width
        super.initialize(width, height, parentWidth, parentHeight)
    }

    override fun willChangeBounds(): Boolean {
        return true
    }
}