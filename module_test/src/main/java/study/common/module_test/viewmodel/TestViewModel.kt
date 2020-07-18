package study.common.module_test.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import study.common.module_test.model.TimeModel

class TestViewModel :ViewModel(){
    private  var mTimeModel:TimeModel = TimeModel
    private val mCurrTimeData=MediatorLiveData<String>()

    init {
        mCurrTimeData.addSource(mTimeModel.getTime(), Observer {
            //可以对数据进行处理
        })
    }

    fun getTimeDateObserve()=mCurrTimeData

    fun refreshCurrData() {
        mTimeModel.refreshCurrTime()
    }

}