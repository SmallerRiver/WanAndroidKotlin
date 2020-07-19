package study.common.common.application

import androidx.multidex.MultiDexApplication
import com.alibaba.android.arouter.launcher.ARouter

class BaseApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        ARouter.init(this)
    }
}