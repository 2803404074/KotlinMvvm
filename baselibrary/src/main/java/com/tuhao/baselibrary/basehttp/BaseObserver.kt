package com.tuhao.baselibrary.basehttp


import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * 统一返回数据处理
 */
abstract class BaseObserver<T>: Observer<BaseResponse<T>> {

    abstract fun onFailure(e: Throwable?,message:String?)
    abstract fun onSuccess(result:T?)

    override fun onNext(t: BaseResponse<T>) {
        if (t.code == 0){
            onSuccess(t.data)
        }else{
            onFailure(null,t.message)
        }

    }

    override fun onError(e: Throwable) {
        onFailure(e,e.message)
    }

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

}