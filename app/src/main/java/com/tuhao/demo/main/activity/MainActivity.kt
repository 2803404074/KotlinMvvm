package com.tuhao.demo.main.activity

import com.tuhao.baselibrary.baseview.BaseActivity
import com.tuhao.demo.R
import com.tuhao.demo.databinding.ActivityMainBinding
import com.tuhao.demo.main.vm.MainModel

class MainActivity : BaseActivity<MainModel, ActivityMainBinding>() {

    override fun startWork() {

        mViewModel.getNavFragment(R.id.mFrameLayout,supportFragmentManager)
        mViewModel.mNavHelper.performClickMenu(R.id.navigation_home)
        mBinding.navView.setOnNavigationItemSelectedListener {
            item -> mViewModel.mNavHelper.performClickMenu(item.itemId)
        }
    }

    override fun getContenViewId(): Int {
        return R.layout.activity_main
    }
}
