package com.tuhao.demo.one.vm

import android.app.Application
import android.content.Context
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuhao.baselibrary.baseview.BaseViewModel
import com.tuhao.baselibrary.model.DemoMo
import com.tuhao.baselibrary.model.MoreType
import com.tuhao.baselibrary.util.*
import com.tuhao.demo.R
import com.youth.banner.Banner
import com.youth.banner.listener.OnBannerListener
import java.util.*


class TypeViewModel(application: Application) : BaseViewModel(application){

    var imgRes:Int = 0

    var itemColor:Int = R.drawable.shape_white

    var isLoad = MutableLiveData<Boolean>()
    var mDaMore = mutableListOf<MoreType>()
    lateinit var adapterMore: MyMoreBaseAdapter<MoreType>

    fun initMoreAdapter(context: Context, view: View,img:Int) {
        this.imgRes = img
        if (img==0){//0不加顶部视图

        }else if (img == 1){//1顶部视图为轮播图
            mDaMore.add(MoreType(R.layout.item_banner, 0))
        }else{//其他是顶部视图为一张图片，图片的内容则是img
            mDaMore.add(MoreType(R.layout.item_image, 3))
        }
        mDaMore.add(MoreType(R.layout.layout_recy, 1))
        mDaMore.add(MoreType(R.layout.item_advertisement, 2))
        mDaMore.add(MoreType(R.layout.layout_recy, 1))
        adapterMore = object : MyMoreBaseAdapter<MoreType>(mDaMore) {
            override fun myConvert(helper: MyViewHolder, item: MoreType, type: Int) {
                when (type) {
                    0 -> {
                        var mBanner = helper.getView<Banner>(R.id.mBanner)
                        startBanner(mBanner,view)
                    }
                    1 -> {
                        var rec = helper.getView<RecyclerView>(R.id.recy_demo)
                        rec.layoutManager = GridLayoutManager(context, 2)

                        var mDa = mutableListOf<DemoMo>()
                        for (index in 1..10) {
                            var d = DemoMo()

                            if (index % 2 == 0) {
                                d.userName = "外国大神教你如何让手指更灵敏，准备好了吗!Let's go!"
                                d.passWords =
                                    "http://i2.hdslb.com/bfs/archive/7fc61167a237a4002b227b541f6190e0d01cadaf.jpg"
                            } else {
                                d.userName = "[周星驰] 星爷深情演唱，这谁顶得住？"
                                d.passWords =
                                    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577723943622&di=6f105ada527680284962fd07ca083ede&imgtype=0&src=http%3A%2F%2Fimage.uczzd.cn%2F9715278983705248721.jpg%3Fid%3D0"
                            }
                            mDa.add(d)
                        }

                        var mAdapter = object : MyBaseAdapter<DemoMo>(mDa, R.layout.item_one) {
                            override fun myConvert(helper: MyViewHolder, item: DemoMo) {
                                helper.setBackgroundRes(R.id.rlContent,itemColor)
                                helper.getView<TextView>(R.id.tvData).text = item.userName
                                helper.setDraViewByUrl(R.id.ivContent, item.passWords)
                                helper.getView<ImageView>(R.id.ivMore)
                                    .setOnClickListener {

                                    }
                            }
                        }
                        rec.adapter = mAdapter
                    }
                    2 -> {
                        //加载广告
                        var img = helper.getView<ImageView>(R.id.ivContent)
                        var a = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1578406498&di=5b13c25315ecfca33fea12015d393bf0&imgtype=jpg&er=1&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F17%2F08%2F98%2F84a58PICWZe_1024.jpg"
                        GlideImageLoader().displayImage(null,a,img)
                    }

                    3->{
                        helper.setBackgroundRes(R.id.mImage,imgRes)
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
    fun startBanner(banner: Banner,view:View) {
        var mListImg = ArrayList<String>()
        var mListTitle = ArrayList<String>()
        mListImg.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577804928723&di=b0c659e95e63a4dfbf0c5d5380785468&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fdesign%2F00%2F40%2F26%2F40%2Ff7e3b87ab6ac300a93d743903f3b8c95.jpg")

        mListImg.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577804928721&di=9eef7174b2d3c49d5910ee541992c2fe&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01b266571dd33b32f875a3996d817b.jpg%401280w_1l_2o_100sh.jpg")

        mListImg.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577804928721&di=6b2895ec5569625367e310d6abe5488d&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fdesign%2F00%2F66%2F91%2F14%2Fs_1024_5772158596e2d.jpg")

        mListTitle.add("冬天狂欢节")
        mListTitle.add("竞品竞拍")
        mListTitle.add("时尚达人")
        BannerUtil.startBanner(mListImg,mListTitle,banner,OnBannerListener {
                position ->
            SnackBarUtil.show(view,"广告服务")
        })

    }
}
