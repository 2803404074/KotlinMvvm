package com.tuhao.baselibrary.baseview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.tuhao.baselibrary.basehttp.RetrofitManager

abstract class BaseViewModel(application: Application) : AndroidViewModel(application){

    override fun onCleared() {
        super.onCleared()
    }
}