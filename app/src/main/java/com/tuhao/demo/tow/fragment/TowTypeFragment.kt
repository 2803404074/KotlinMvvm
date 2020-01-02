package com.tuhao.demo.tow.fragment

import android.os.Bundle
import android.os.Handler
import android.view.View.GONE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuhao.baselibrary.baseview.BaseFragment
import com.tuhao.demo.R
import com.tuhao.demo.databinding.FragmentTypeTowBinding
import com.tuhao.demo.tow.vm.TowTypeViewModel

class TowTypeFragment:BaseFragment<TowTypeViewModel, FragmentTypeTowBinding>() {

    private var mFragmentIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFragmentIndex = arguments!!.getInt("index")
    }

    override fun initLayout(): Int {
        return R.layout.fragment_type_tow
    }

    override fun startWork() {
        mBinding.recyDemo.layoutManager = LinearLayoutManager(context)

        Handler().postDelayed({
            mViewModel.initMoreAdapter(this@TowTypeFragment.requireContext())

            mBinding.recyDemo.adapter = mViewModel.adapterMore
        }, 0)
        mViewModel.isLoad.observe(this, Observer {
            if (it){
                mBinding.skv.visibility = GONE
            }
        })
        mViewModel.loadData()
    }
    companion object {
        fun create(index: Int): TowTypeFragment {
            val pagerFragment = TowTypeFragment()
            val bundle = Bundle()
            bundle.putInt("index", index)
            pagerFragment.arguments = bundle
            return pagerFragment
        }
    }
}