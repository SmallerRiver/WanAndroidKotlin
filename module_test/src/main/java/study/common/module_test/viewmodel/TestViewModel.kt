package study.common.module_test.viewmodel

import android.view.View
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import study.common.module_test.model.TimeModel

class TestViewModel :ViewModel(){
    private  var mTimeModel:TimeModel = TimeModel
    val mCurrTimeData=MediatorLiveData<String>()

    init {
        mCurrTimeData.addSource(mTimeModel.getTime(), Observer {
            //可以对数据进行处理
            mCurrTimeData.postValue("当前毫秒数:$it")
        })
    }

    fun getTimeDateObserve()=mCurrTimeData

   public fun refreshCurrData(view: View? =null) {
        mTimeModel.refreshCurrTime()
    }
}