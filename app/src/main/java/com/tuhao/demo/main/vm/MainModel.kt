package com.tuhao.demo.main.vm

import android.app.Application
import android.content.Context
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tuhao.baselibrary.basehttp.BaseObserver
import com.tuhao.baselibrary.basehttp.RequestUtil
import com.tuhao.baselibrary.baseview.BaseViewModel
import com.tuhao.baselibrary.model.DemoMo
import com.tuhao.demo.R
import com.tuhao.demo.four.fragment.FourFragment
import com.tuhao.demo.main.ui.NavHelper
import com.tuhao.demo.one.fragment.OneFragment
import com.tuhao.demo.three.fragment.ThreeFragment
import com.tuhao.demo.tow.fragment.TowFragment

class MainModel(application: Application) :BaseViewModel(application){

    lateinit var mNavHelper:NavHelper<String>

    var context:Context=application

    var user = MutableLiveData<DemoMo>()

    fun getUser(){
        RequestUtil.login(context,"hahaha","haha","haha","hahah",object :BaseObserver<DemoMo>(){
            override fun onSuccess(result: DemoMo?) {
                var us:DemoMo= DemoMo()
                us.passWords = "123"
                us.userName = "牛逼"
                user.value = us
            }
            override fun onFailure(e: Throwable?, message: String?) {
                Toast.makeText(context,message,LENGTH_LONG)
            }
        })
    }

    fun getNavFragment(fraLayoutId:Int,manager: FragmentManager){
        mNavHelper = NavHelper<String>(context, fraLayoutId, manager,null)
        mNavHelper.add(R.id.navigation_home, NavHelper.Tab(OneFragment::class.java, "aaa"))
        mNavHelper.add(R.id.navigation_dashboard, NavHelper.Tab(TowFragment::class.java, "aaa"))
        mNavHelper.add(R.id.navigation_notifications, NavHelper.Tab(ThreeFragment::class.java, "aaa"))
        mNavHelper.add(R.id.navigation, NavHelper.Tab(FourFragment::class.java, "aaa"))
    }
}