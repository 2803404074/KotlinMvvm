package com.tuhao.baselibrary.basehttp
import okhttp3.Interceptor
import okhttp3.Response

class HttpLogInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var requestBuilder = request.newBuilder().header("token","123").build()
        return chain.proceed(requestBuilder)
    }
}