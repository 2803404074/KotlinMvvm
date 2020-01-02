package com.tuhao.demo.tow.fragment

import com.tuhao.baselibrary.baseview.BaseFragment
import com.tuhao.baselibrary.model.TypeMo
import com.tuhao.baselibrary.ui.indicator.DynamicFragmentPagerAdapter
import com.tuhao.demo.R
import com.tuhao.demo.databinding.OneFragmentBinding
import com.tuhao.demo.databinding.TowFragmentBinding
import com.tuhao.demo.one.vm.OneViewModel
import com.tuhao.demo.tow.vm.TowViewModel
import java.util.ArrayList


class TowFragment : BaseFragment<TowViewModel, TowFragmentBinding>() {

    override fun initLayout(): Int {
        return R.layout.tow_fragment
    }

    override fun startWork() {
        val list = ArrayList<TypeMo>()
        list.add(TypeMo(0,"吉他"))
        list.add(TypeMo(0,"钢琴"))
        list.add(TypeMo(0,"架子鼓"))
        list.add(TypeMo(0,"贝斯"))
        list.add(TypeMo(0,"声乐"))
        list.add(TypeMo(0,"流行"))
        list.add(TypeMo(0,"舞蹈"))
        list.add(TypeMo(0,"口琴"))

        mBinding.mViewPager.adapter =
            DynamicFragmentPagerAdapter(childFragmentManager, mViewModel.createFragments(8),list)
        mBinding.mDpi.viewPager = mBinding.mViewPager
    }
    companion object {
        fun newInstance() = TowFragment()
    }
}
