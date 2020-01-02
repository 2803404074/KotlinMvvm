package com.tuhao.demo.one.vm

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chad.library.adapter.base.BaseQuickAdapter
import com.tuhao.baselibrary.baseview.BaseViewModel
import com.tuhao.baselibrary.model.DemoMo
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.chad.library.adapter.base.BaseViewHolder
import com.tuhao.baselibrary.util.MyBaseAdapter
import com.tuhao.baselibrary.util.MyViewHolder
import com.tuhao.demo.R
import com.tuhao.demo.one.fragment.TypeFragment
import java.util.ArrayList


class OneViewModel(application: Application) : BaseViewModel(application){

    fun createFragments(index: Int): List<Fragment> {
        val fragments = ArrayList<Fragment>()
        for (i in 0 until index) {
            fragments.add(TypeFragment.create(i))
        }
        return fragments
    }
}
