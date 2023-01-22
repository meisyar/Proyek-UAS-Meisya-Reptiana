package com.example.proyek_uas_meisya_reptiana

import android.app.Application
import com.example.proyek_uas_meisya_reptiana.core.di.networkModule
import com.example.proyek_uas_meisya_reptiana.core.di.repositoryModule
import com.example.proyek_uas_meisya_reptiana.di.useCaseModule
import com.example.proyek_uas_meisya_reptiana.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}