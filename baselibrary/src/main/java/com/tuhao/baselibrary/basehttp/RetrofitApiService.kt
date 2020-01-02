package com.tuhao.baselibrary.basehttp

import com.tuhao.baselibrary.model.DemoMo
import io.reactivex.Observable
import retrofit2.http.*
import java.util.*


interface RetrofitApiService {
    @POST("api/login")
    @FormUrlEncoded
    fun getUserList(@Field("name")name:String
                    ,@Field("nickName")nickName:String
                    ,@Field("icon")icon:String
                    ,@Field("loginType")loginType:String): Observable<BaseResponse<DemoMo>>
}