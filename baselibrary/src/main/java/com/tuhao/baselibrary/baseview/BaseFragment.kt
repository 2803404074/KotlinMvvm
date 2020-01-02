package com.tuhao.baselibrary.baseview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : Fragment() {

    protected lateinit var mViewModel: VM
    protected lateinit var mBinding: DB
    protected var isLoad: Boolean? = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!isLoad!!) {
            mBinding = DataBindingUtil.inflate(inflater, initLayout(), container, false)
            createViewModel()
            startWork()
            isLoad = true
        }
        return mBinding.root
    }

    abstract fun initLayout(): Int

    abstract fun startWork()

    @SuppressWarnings("unchecked")
    private fun createViewModel() {
        val modelClass: Class<VM>// java中：Class modelClass;
        val type = javaClass.genericSuperclass//java中 Type type = getClass().getGenericSuperclass();

        if (type is ParameterizedType) {//is 为java 的 intanceof
            modelClass = (type).actualTypeArguments[0] as Class<VM>
        } else {
            //如果没有指定泛型参数，则默认使用BaseViewModel
            modelClass = BaseViewModel::class.java as Class<VM>
        }
        mViewModel = ViewModelProviders.of(this).get(modelClass)
    }

}