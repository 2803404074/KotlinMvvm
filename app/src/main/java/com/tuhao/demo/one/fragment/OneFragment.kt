package com.tuhao.demo.one.fragment

import android.view.View.GONE
import android.view.View.VISIBLE
import com.tuhao.baselibrary.baseview.BaseFragment
import com.tuhao.baselibrary.model.TypeMo
import com.tuhao.baselibrary.ui.indicator.DynamicFragmentPagerAdapter
import com.tuhao.baselibrary.ui.indicator.DynamicPagerIndicator
import com.tuhao.demo.databinding.OneFragmentBinding
import com.tuhao.demo.one.vm.OneViewModel
import java.util.*
import com.tuhao.baselibrary.ui.anim.ViewSizeChangeAnimo
import com.tuhao.baselibrary.util.ScreenUtils
import com.tuhao.demo.R


class OneFragment : BaseFragment<OneViewModel, OneFragmentBinding>() {

    var animation = ViewSizeChangeAnimo()

    override fun initLayout(): Int {
        return R.layout.one_fragment
    }

    override fun startWork() {
        animation.view = mBinding.include

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

        mBinding.mDpi.setOnOutPageChangeListener(object :
            DynamicPagerIndicator.OnOutPageChangeListener {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        mBinding.llTop.setBackgroundResource(R.drawable.shape_style_01)
                        mBinding.ivZhuan.visibility = VISIBLE
                        animation.targetWidth = ScreenUtils.dp2px(this@OneFragment.requireContext(),200F).toInt()
                        animation.duration = 500
                        mBinding.include.startAnimation(animation)
                    }
                    1 -> {
                        mBinding.llTop.setBackgroundResource(R.drawable.shape_style_02)
                        mBinding.ivZhuan.visibility = GONE
                        animation.targetWidth = ScreenUtils.dp2px(this@OneFragment.requireContext(),200F).toInt()+200
                        animation.duration = 500
                        mBinding.include.startAnimation(animation)
                    }
                    2 -> mBinding.llTop.setBackgroundResource(R.drawable.shape_style_03)
                    3 -> mBinding.llTop.setBackgroundResource(R.drawable.shape_style_04)
                    4 -> mBinding.llTop.setBackgroundResource(R.drawable.shape_style_05)
                    else -> mBinding.llTop.setBackgroundResource(R.drawable.shape_style_05)
                }
            }
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }
        })
    }
}
