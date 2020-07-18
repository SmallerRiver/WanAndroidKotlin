package study.common.common.view

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<viewModel : ViewModel> : AppCompatActivity() {
    lateinit var mViewModel: viewModel
    lateinit var mRootLayout: View

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        requestWindowFeature(Window.FEATURE_NO_TITLE) //隐藏标题栏

        mRootLayout = LayoutInflater.from(this).inflate(getLayoutId(), null)
        setContentView(mRootLayout)
        mViewModel = ViewModelProvider(this).get(bindingViewModel())
        init()
    }

    abstract fun bindingViewModel(): Class<viewModel>

    abstract fun init()

    abstract fun getLayoutId(): Int

}
