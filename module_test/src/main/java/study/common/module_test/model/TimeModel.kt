package study.common.module_test.model

import androidx.lifecycle.MutableLiveData

object TimeModel {
    private val mTime= MutableLiveData<String>()

    fun getTime():MutableLiveData<String>{return mTime}

    fun refreshCurrTime(){
        mTime.postValue(System.currentTimeMillis().toString())
    }
}