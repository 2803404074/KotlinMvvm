package com.tuhao.baselibrary.app

import android.app.Application
import androidx.multidex.MultiDex
import com.facebook.drawee.backends.pipeline.Fresco

class MyApplication : Application() {
    companion object{
        lateinit var instance:MyApplication
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        MultiDex.install(this);
        Fresco.initialize(this)
    }
}