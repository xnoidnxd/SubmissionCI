package com.inoid.submission

import android.app.Application
import com.inoid.submission.core.di.CoreComponent
import com.inoid.submission.core.di.DaggerCoreComponent
import com.inoid.submission.ui.di.AppComponent
import com.inoid.submission.ui.di.DaggerAppComponent

open class MyApplication : Application() {

    val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }

}