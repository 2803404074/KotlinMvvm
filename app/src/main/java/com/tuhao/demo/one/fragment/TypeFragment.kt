package com.tuhao.demo.one.fragment

import android.os.Bundle
import android.view.View.GONE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuhao.baselibrary.baseview.BaseFragment
import com.tuhao.demo.R
import com.tuhao.demo.databinding.FragmentTypeBinding
import com.tuhao.demo.databinding.LayoutRecyBinding
import com.tuhao.demo.one.vm.TypeViewModel

class TypeFragment:BaseFragment<TypeViewModel,FragmentTypeBinding>() {

    private var mFragmentIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFragmentIndex = arguments!!.getInt("index")
    }

    override fun initLayout(): Int {
        return R.layout.fragment_type
    }

    override fun startWork() {
        mBinding.recyDemo.layoutManager = LinearLayoutManager(context)
        var img:Int = 0
        when (mFragmentIndex) {
            0 -> {
                img = 1
                mBinding.llContent.setBackgroundResource(R.drawable.shape_style_01)
            }
            1 -> {
                mBinding.llContent.setBackgroundResource(R.drawable.shape_style_02)
                img = R.drawable.test2
            }
            2 ->{
                mBinding.llContent.setBackgroundResource(R.drawable.shape_style_03)
                img = R.drawable.test3
            }
            3 -> {
                mBinding.llContent.setBackgroundResource(R.drawable.shape_style_04)
                img = 1
            }
            4 -> {
                mBinding.llContent.setBackgroundResource(R.drawable.shape_style_05)
                img = 1
            }
            else -> {
                mBinding.llContent.setBackgroundResource(R.drawable.shape_style_05)
                img = 1
            }
        }


        mViewModel.initMoreAdapter(this@TypeFragment.requireContext(),mBinding.llContent,img)

        mBinding.recyDemo.adapter = mViewModel.adapterMore

        mViewModel.isLoad.observe(this, Observer {
            if (it){
                mBinding.skv.visibility = GONE
            }
        })
        mViewModel.loadData()
    }
    companion object {
        fun create(index: Int): TypeFragment {
            val pagerFragment = TypeFragment()
            val bundle = Bundle()
            bundle.putInt("index", index)
            pagerFragment.arguments = bundle
            return pagerFragment
        }
    }
}