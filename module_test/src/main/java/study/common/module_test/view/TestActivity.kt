package study.common.module_test.view

import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_test.*
import study.common.common.view.BaseActivity
import study.common.module_test.R
import study.common.module_test.viewmodel.TestViewModel

class TestActivity : BaseActivity<TestViewModel>() {
    override fun getLayoutId(): Int =R.layout.activity_test

    override fun bindingViewModel():Class<TestViewModel>{
        return TestViewModel::class.java
    }

    override fun init() {
        mViewModel.getTimeDateObserve().observe(this, Observer {
            currMsg.text=it
        })
        mViewModel.refreshCurrData()
        refreshMsg.setOnClickListener {
            mViewModel.refreshCurrData()
        }
    }

}