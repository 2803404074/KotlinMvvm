package com.tuhao.baselibrary.model

import androidx.lifecycle.LiveData
import java.io.Serializable

class DemoMo :Serializable, LiveData<DemoMo>(){
    var userName:String?=null
    var passWords:String?=null
    var passWords2:String?=null
}