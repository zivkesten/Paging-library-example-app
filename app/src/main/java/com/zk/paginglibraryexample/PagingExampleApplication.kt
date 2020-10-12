package com.zk.paginglibraryexample

import android.app.Application
import com.zk.paginglibraryexample.api.apiModule
import com.zk.paginglibraryexample.data.repositoryModule
import com.zk.testapp.di.ViewModelsModule
import com.zk.paginglibraryexample.networking.networkModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@FlowPreview
@ExperimentalCoroutinesApi
class PagingExampleApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PagingExampleApplication)
            modules(listOf(
                ViewModelsModule.modules,
                repositoryModule,
                apiModule,
                networkModule
            ))
        }
    }
}

