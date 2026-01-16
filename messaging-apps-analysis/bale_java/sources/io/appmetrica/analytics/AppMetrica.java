package io.appmetrica.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.webkit.WebView;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.impl.A0;
import io.appmetrica.analytics.impl.AbstractC2624j1;
import io.appmetrica.analytics.impl.C2601i1;
import io.appmetrica.analytics.plugins.AppMetricaPlugins;
import io.appmetrica.analytics.profile.UserProfile;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class AppMetrica {
    public static void activate(Context context, AppMetricaConfig appMetricaConfig) {
        AbstractC2624j1.a.a(context, appMetricaConfig);
    }

    public static void activateReporter(Context context, ReporterConfig reporterConfig) {
        AbstractC2624j1.a.a(context, reporterConfig);
    }

    public static void clearAppEnvironment() {
        AbstractC2624j1.a.a();
    }

    public static void enableActivityAutoTracking(Application application) {
        AbstractC2624j1.a.a(application);
    }

    public static String getDeviceId(Context context) {
        return AbstractC2624j1.a.b();
    }

    public static int getLibraryApiLevel() {
        return 114;
    }

    public static String getLibraryVersion() {
        return "7.1.0";
    }

    public static AppMetricaPlugins getPluginExtension() {
        return A0.a;
    }

    public static IReporter getReporter(Context context, String str) {
        return AbstractC2624j1.a.a(context, str);
    }

    public static String getUuid(Context context) {
        return AbstractC2624j1.a.a(context).id;
    }

    public static void initWebViewReporting(WebView webView) {
        AbstractC2624j1.a.a(webView);
    }

    public static void pauseSession(Activity activity) {
        AbstractC2624j1.a.a(activity);
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        AbstractC2624j1.a.a(str, str2);
    }

    public static void putErrorEnvironmentValue(String str, String str2) {
        AbstractC2624j1.a.b(str, str2);
    }

    public static void registerAnrListener(AnrListener anrListener) {
        AbstractC2624j1.a.a(anrListener);
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        AbstractC2624j1.a.a(adRevenue);
    }

    public static void reportAppOpen(Activity activity) {
        AbstractC2624j1.a.b(activity);
    }

    public static void reportECommerce(ECommerceEvent eCommerceEvent) {
        AbstractC2624j1.a.a(eCommerceEvent);
    }

    public static void reportError(String str, String str2) {
        AbstractC2624j1.a.a(str, str2, (Throwable) null);
    }

    public static void reportEvent(String str) {
        AbstractC2624j1.a.b(str);
    }

    public static void reportExternalAdRevenue(Object... objArr) {
        AbstractC2624j1.a.b(objArr);
    }

    public static void reportExternalAttribution(ExternalAttribution externalAttribution) {
        AbstractC2624j1.a.a(externalAttribution);
    }

    public static void reportReferralUrl(String str) {
        AbstractC2624j1.a.d(str);
    }

    public static void reportRevenue(Revenue revenue) {
        AbstractC2624j1.a.a(revenue);
    }

    public static void reportUnhandledException(Throwable th) {
        AbstractC2624j1.a.a(th);
    }

    public static void reportUserProfile(UserProfile userProfile) {
        AbstractC2624j1.a.a(userProfile);
    }

    public static void requestDeferredDeeplink(DeferredDeeplinkListener deferredDeeplinkListener) {
        AbstractC2624j1.a.a(deferredDeeplinkListener);
    }

    public static void requestDeferredDeeplinkParameters(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        AbstractC2624j1.a.a(deferredDeeplinkParametersListener);
    }

    public static void requestStartupParams(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        C2601i1 c2601i1 = AbstractC2624j1.a;
        if (list.isEmpty()) {
            list = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH);
        }
        c2601i1.a(context, startupParamsCallback, list);
    }

    public static void resumeSession(Activity activity) {
        AbstractC2624j1.a.c(activity);
    }

    public static void sendEventsBuffer() {
        AbstractC2624j1.a.f();
    }

    public static void setDataSendingEnabled(boolean z) {
        AbstractC2624j1.a.a(z);
    }

    public static void setLocation(Location location) {
        AbstractC2624j1.a.a(location);
    }

    public static void setLocationTracking(boolean z) {
        AbstractC2624j1.a.b(z);
    }

    public static void setUserProfileID(String str) {
        AbstractC2624j1.a.e(str);
    }

    public static void reportAppOpen(Intent intent) {
        AbstractC2624j1.a.a(intent);
    }

    public static void reportError(String str, String str2, Throwable th) {
        AbstractC2624j1.a.a(str, str2, th);
    }

    public static void reportEvent(String str, String str2) {
        AbstractC2624j1.a.c(str, str2);
    }

    public static void reportAppOpen(String str) {
        AbstractC2624j1.a.a(str);
    }

    public static void reportError(String str, Throwable th) {
        AbstractC2624j1.a.a(str, th);
    }

    public static void reportEvent(String str, Map<String, Object> map) {
        AbstractC2624j1.a.a(str, map);
    }
}
