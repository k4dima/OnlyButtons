package app.ui.elements

import android.app.Application
import com.example.onlybuttons.BuildConfig
import com.github.k4dima.testio.core.ui.elements.commonApplicationInit
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ButtonsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        commonApplicationInit(BuildConfig.DEBUG, this)
    }
}