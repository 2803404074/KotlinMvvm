package com.tuhao.baselibrary.baseview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.tuhao.baselibrary.util.StatusBarUtil
import java.lang.reflect.ParameterizedType


abstract class BaseActivity<VM : BaseViewModel,DB : ViewDataBinding> : AppCompatActivity() {


    //处理逻辑业务
    protected abstract fun startWork()

    //获取当前activity布局文件,并初始化我们的binding
    protected abstract fun getContenViewId():Int


    //具体的viewModel
    //lateinit关键字，表示先不初始化，但是会初始化的意思
    protected lateinit var mViewModel:VM

    //activity的binding对象
    protected lateinit var mBinding:DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.setRootViewFitsSystemWindows(this, false)
        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this)
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            StatusBarUtil.setStatusBarColor(this, 0x55000000)
        }

        //初始化binding
        mBinding = DataBindingUtil.setContentView(this,getContenViewId())

        //给binding加上感知生命周期，AppCompatActivity就是lifeOwner
        mBinding.lifecycleOwner = this

        //创建viewModel
        createViewModel()

        //业务处理
        startWork()

    }

    private fun createViewModel(){
        val modelClass: Class<VM>// java中：Class modelClass;
        val type = javaClass.genericSuperclass//java中 Type type = getClass().getGenericSuperclass();

        if (type is ParameterizedType) {//is 为java 的 intanceof
            modelClass = (type).actualTypeArguments[0] as Class<VM>
        } else {
            //如果没有指定泛型参数，则默认使用BaseViewModel
            modelClass = BaseViewModel::class.java as Class<VM>
        }
        mViewModel  = ViewModelProviders.of(this).get(modelClass)
    }
}