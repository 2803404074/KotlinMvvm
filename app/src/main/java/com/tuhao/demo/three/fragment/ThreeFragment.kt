package com.tuhao.demo.three.fragment

import com.tuhao.baselibrary.baseview.BaseFragment
import com.tuhao.demo.R
import com.tuhao.demo.databinding.OneFragmentBinding
import com.tuhao.demo.databinding.ThreeFragmentBinding
import com.tuhao.demo.one.vm.OneViewModel
import com.tuhao.demo.three.vm.ThreeViewModel


class ThreeFragment : BaseFragment<ThreeViewModel, ThreeFragmentBinding>() {

    override fun initLayout(): Int {
        return R.layout.three_fragment
    }

    override fun startWork() {

    }
    companion object {
        fun newInstance() = ThreeFragment()
    }
}
