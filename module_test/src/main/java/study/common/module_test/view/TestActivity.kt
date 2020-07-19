package study.common.module_test.view

import com.alibaba.android.arouter.facade.annotation.Route
import study.common.common.base.constant.TEST_ACTIVITY
import study.common.common.view.BaseActivity
import study.common.module_test.R
import study.common.module_test.databinding.ActivityTestBinding
import study.common.module_test.viewmodel.TestViewModel

@Route(path = TEST_ACTIVITY)
class TestActivity : BaseActivity<ActivityTestBinding,TestViewModel>() {
    override fun getLayoutId(): Int =R.layout.activity_test

    override fun bindingViewModel()=TestViewModel::class.java

    override fun init() {
        mBinding.viewModel=mViewModel
        mViewModel.refreshCurrData()
    }

}