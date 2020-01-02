package com.tuhao.baselibrary.basehttp

enum class ResponseEm(var status:Int,val a:String) {
    SUCCESS(0,"成功"),
    ERRBY400(400,"400错误"),
    ERRBY500(500,"500错误")
}