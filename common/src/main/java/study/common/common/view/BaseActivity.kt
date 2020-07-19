package study.common.common.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<binding : ViewDataBinding, viewModel : ViewModel> :
    AppCompatActivity() {
    lateinit var mViewModel: viewModel
    lateinit var mBinding: binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(bindingViewModel())
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mBinding.lifecycleOwner=this
        init()
    }

    abstract fun bindingViewModel(): Class<viewModel>

    abstract fun init()

    abstract fun getLayoutId(): Int

}
