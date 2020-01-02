package com.tuhao.demo.four.fragment

import com.tuhao.baselibrary.baseview.BaseFragment
import com.tuhao.demo.R
import com.tuhao.demo.databinding.FourFragmentBinding
import com.tuhao.demo.databinding.OneFragmentBinding
import com.tuhao.demo.four.vm.FourViewModel
import com.tuhao.demo.one.vm.OneViewModel


class FourFragment : BaseFragment<FourViewModel, FourFragmentBinding>() {

    override fun initLayout(): Int {
        return R.layout.four_fragment
    }

    override fun startWork() {

    }
    companion object {
        fun newInstance() = FourFragment()
    }
}
