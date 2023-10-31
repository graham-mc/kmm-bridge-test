package co.touchlab.kampkit.android

import android.app.Application
import co.touchlab.kmmbridgekickstart.Analytics
import io.graham.template.startTemplateSDK
import io.graham.template.xapis.XAPISCredentials
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val analytics = object : Analytics {
            override fun sendEvent(eventName: String, eventArgs: Map<String, Any>) {
                println("eventName: ${eventName}, eventArgs: ${eventArgs.keys.joinToString(",") { key -> "[$key, ${eventArgs[key]}]" }}")
            }
        }
        val templateSDkHandle = startTemplateSDK(analytics, XAPISCredentials("app", "killswitch", "stable", "1234"), this)
        templateSDkHandle.appAnalytics.appStarted()
        GlobalScope.launch(Dispatchers.IO) {
            val isDead = templateSDkHandle.templateRepository.isCurrentVersionDead()
            if (isDead == true) {
                withContext(Dispatchers.Main) {
                    println(isDead)
                }
            }
        }
    }
}