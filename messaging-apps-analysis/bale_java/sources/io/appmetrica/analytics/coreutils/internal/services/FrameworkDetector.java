package io.appmetrica.analytics.coreutils.internal.services;

import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.plugins.PluginErrorDetails;

/* loaded from: classes3.dex */
public class FrameworkDetector {
    private static final String a = new FrameworkDetector().detectFramework();

    public static String framework() {
        return a;
    }

    public String detectFramework() {
        return ReflectionUtils.detectClassExists("com.unity3d.player.UnityPlayer") ? PluginErrorDetails.Platform.UNITY : ReflectionUtils.detectClassExists("mono.MonoPackageManager") ? PluginErrorDetails.Platform.XAMARIN : ReflectionUtils.detectClassExists("org.apache.cordova.CordovaPlugin") ? PluginErrorDetails.Platform.CORDOVA : ReflectionUtils.detectClassExists("com.facebook.react.ReactRootView") ? "react" : ReflectionUtils.detectClassExists("io.flutter.embedding.engine.FlutterEngine") ? PluginErrorDetails.Platform.FLUTTER : PluginErrorDetails.Platform.NATIVE;
    }
}
