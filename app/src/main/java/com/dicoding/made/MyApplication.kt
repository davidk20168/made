package com.dicoding.made

import android.app.Application
import com.dicoding.made.core.di.databaseModule
import com.dicoding.made.core.di.networkModule
import com.dicoding.made.core.di.repositoryModule
import com.dicoding.made.di.useCaseModule
import com.dicoding.made.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}