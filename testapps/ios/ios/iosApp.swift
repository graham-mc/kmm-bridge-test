//
//  iosApp.swift
//  ios
//
//  Created by Kevin Galligan on 9/10/23.
//

import SwiftUI
import allshared

@main
struct iosApp: App {
    
    init() {
        Task.detached {
            let isDead = await KillSwitch.isCurrentVersionDead()
            print(isDead!)
        }
    }
    
    var body: some Scene {
        WindowGroup {
        }
    }
}

class IosAnalytics: Analytics {
    func sendEvent(eventName: String, eventArgs: [String : Any]) {
        // In a real app, you would call to your analytics backend here
        print("\(eventName) - \(eventArgs)")
    }
}

struct KillSwitch {
    static func isCurrentVersionDead() async -> Bool? {
        let handle = StartSDKKt.startSDK(analytics: IosAnalytics(), xapisCredentials: TemplateXAPISCredentials(app: "app", release: "killswitch", channel: "stable", appKey: "1234"))
        handle.appAnalytics.appStarted()
        handle.templateAnalytics.templateSaidHello(id: 42)
        let isDead = try? await handle.templateRepository.isCurrentVersionDead()
        return isDead as? Bool

    }
}
