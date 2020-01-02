package com.tuhao.baselibrary.basehttp

import java.io.Serializable

class BaseResponse<T>:Serializable {
    var data:T?=null
    var code:Int = 0
    var message:String?=null
}