package com.tuhao.demo.tow.vm

import android.app.Application
import android.content.Context
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuhao.baselibrary.baseview.BaseViewModel
import com.tuhao.baselibrary.model.DemoMo
import com.tuhao.baselibrary.model.MoreType
import com.tuhao.baselibrary.util.*
import com.tuhao.demo.R
import com.youth.banner.Banner
import com.youth.banner.listener.OnBannerListener
import java.util.*


class TowTypeViewModel(application: Application) : BaseViewModel(application){

    var isLoad = MutableLiveData<Boolean>()
    var mDaMore = mutableListOf<MoreType>()
    lateinit var adapterMore: MyMoreBaseAdapter<MoreType>

    fun initMoreAdapter(context: Context) {
        mDaMore.add(MoreType(R.layout.layout_recy, 1))


        adapterMore = object : MyMoreBaseAdapter<MoreType>(mDaMore) {
            override fun myConvert(helper: MyViewHolder, item: MoreType, type: Int) {
                when (type) {
                    1 -> {
                        var rec = helper.getView<RecyclerView>(R.id.recy_demo)
                        rec.layoutManager = LinearLayoutManager(context)

                        var mDa = mutableListOf<DemoMo>()
                        for (index in 1..10) {
                            var d = DemoMo()
                            d.userName = "【亡灵序曲】钢琴对决，潇月代表和玲珑代表谁才是王者？"
                            d.passWords =
                                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1578545873&di=63d594eebf8b3d4563156ee7b638a234&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.hongtaihall.com%2Fadmin_ht%2Fumeditor%2Fphp%2Fupload%2F20150713%2F1436756020370.jpg"
                            d.passWords2 =
                                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577951367447&di=d1864ee1706a640b7589e480d640383f&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fphotoblog%2F1505%2F21%2Fc9%2F7099969_1432183062301_mthumb.jpg"
                            mDa.add(d)
                        }

                        var mAdapter = object : MyBaseAdapter<DemoMo>(mDa, R.layout.item_tow) {
                            override fun myConvert(helper: MyViewHolder, item: DemoMo) {
                                helper.getView<TextView>(R.id.tvData).text = item.userName
                                helper.setDraViewByUrl(R.id.ivContent01, item.passWords)
                                helper.setDraViewByUrl(R.id.ivContent02, item.passWords2)
                            }
                        }
                        rec.adapter = mAdapter
                    }
                }
            }
        }
    }
    fun loadData() {
        Handler().postDelayed({
            isLoad.value = true
            adapterMore.setNewData(mDaMore)
        }, 2000)
    }
}
