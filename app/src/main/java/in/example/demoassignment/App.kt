package `in`.example.demoassignment

import `in`.example.demoassignment.di.appModule
import `in`.example.data.di.dataModule
import `in`.example.data.network.retrofit.createNetworkClient
import `in`.example.domain.di.domainModule
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidContext(this@App)
      modules(listOf(appModule, dataModule, domainModule))
    }

    instance = this
    setupNetwork()
  }

  private fun setupNetwork() {
    //createNetworkClient(this)
  }

  companion object {
    lateinit var instance: App
  }
}
