package com.tuhao.baselibrary.basehttp

import android.content.Context
import com.tuhao.baselibrary.model.DemoMo

class RequestUtil {
    companion object{
        fun login(context: Context,arg01:String,arg02:String,arg03:String,arg04:String,observer: BaseObserver<DemoMo>){
            RetrofitManager.get().createService(RetrofitApiService::class.java)
                .getUserList(arg01,arg02,arg03,arg04)
                .compose(RxHelper.observableIO2Main(context))
                .subscribe(observer)
        }
    }

}