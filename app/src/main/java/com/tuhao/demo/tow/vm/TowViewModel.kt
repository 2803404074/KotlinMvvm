package com.tuhao.demo.tow.vm

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.tuhao.baselibrary.baseview.BaseViewModel
import com.tuhao.demo.one.fragment.TypeFragment
import com.tuhao.demo.tow.fragment.TowTypeFragment
import java.util.ArrayList

class TowViewModel(application: Application) : BaseViewModel(application) {
    fun createFragments(index: Int): List<Fragment> {
        val fragments = ArrayList<Fragment>()
        for (i in 0 until index) {
            fragments.add(TowTypeFragment.create(i))
        }
        return fragments
    }
}
