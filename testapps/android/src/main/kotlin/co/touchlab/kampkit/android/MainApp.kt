package co.touchlab.kampkit.android

import android.app.Application
import android.util.Log
import co.touchlab.kmmbridgekickstart.Analytics
import io.graham.template.startTemplateSDK

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val analytics = object : Analytics {
            override fun sendEvent(eventName: String, eventArgs: Map<String, Any>) {
                println("eventName: ${eventName}, eventArgs: ${eventArgs.keys.joinToString(",") { key -> "[$key, ${eventArgs[key]}]" }}")
            }
        }
        val templateSDkHandle = startTemplateSDK(analytics, this)
        templateSDkHandle.appAnalytics.appStarted()
        Log.i("templateCall", templateSDkHandle.templateRepository.helloTemplate())
    }
}