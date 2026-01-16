package io.appmetrica.analytics.impl;

import android.location.Location;
import io.appmetrica.analytics.AppMetricaConfig;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class A7 implements InterfaceC2803qc {
    public Location a;
    public Boolean b;
    public Boolean c;
    public final LinkedHashMap d = new LinkedHashMap();
    public final LinkedHashMap e = new LinkedHashMap();
    public boolean f;
    public String g;
    public boolean h;
    public Lh i;

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        this.b = boolValueOf;
        Lh lh = this.i;
        if (lh != null) {
            Boolean bool = this.c;
            if (hn.a(boolValueOf)) {
                lh.a.b.setLocationTracking(z);
            }
            if (hn.a(bool)) {
                lh.a.b.setDataSendingEnabled(bool.booleanValue());
            }
            Q5 q5A = Q5.a();
            Q4 q4 = lh.a;
            lh.a(Lh.a(q5A, q4), q4, 1, null);
        }
    }

    public final AppMetricaConfig b(AppMetricaConfig appMetricaConfig) {
        if (this.h) {
            return appMetricaConfig;
        }
        AppMetricaConfig.Builder builderNewConfigBuilder = AppMetricaConfig.newConfigBuilder(appMetricaConfig.apiKey);
        builderNewConfigBuilder.withDeviceType(appMetricaConfig.deviceType);
        builderNewConfigBuilder.withPreloadInfo(appMetricaConfig.preloadInfo);
        builderNewConfigBuilder.withLocation(appMetricaConfig.location);
        if (hn.a(appMetricaConfig.appVersion)) {
            builderNewConfigBuilder.withAppVersion(appMetricaConfig.appVersion);
        }
        if (hn.a(appMetricaConfig.dispatchPeriodSeconds)) {
            builderNewConfigBuilder.withDispatchPeriodSeconds(appMetricaConfig.dispatchPeriodSeconds.intValue());
        }
        if (hn.a(appMetricaConfig.appBuildNumber)) {
            builderNewConfigBuilder.withAppBuildNumber(appMetricaConfig.appBuildNumber.intValue());
        }
        if (hn.a(appMetricaConfig.maxReportsCount)) {
            builderNewConfigBuilder.withMaxReportsCount(appMetricaConfig.maxReportsCount.intValue());
        }
        if (hn.a(appMetricaConfig.logs) && appMetricaConfig.logs.booleanValue()) {
            builderNewConfigBuilder.withLogs();
        }
        if (hn.a(appMetricaConfig.sessionTimeout)) {
            builderNewConfigBuilder.withSessionTimeout(appMetricaConfig.sessionTimeout.intValue());
        }
        if (hn.a(appMetricaConfig.sessionsAutoTrackingEnabled)) {
            builderNewConfigBuilder.withSessionsAutoTrackingEnabled(appMetricaConfig.sessionsAutoTrackingEnabled.booleanValue());
        }
        if (hn.a(appMetricaConfig.crashReporting)) {
            builderNewConfigBuilder.withCrashReporting(appMetricaConfig.crashReporting.booleanValue());
        }
        if (hn.a(appMetricaConfig.nativeCrashReporting)) {
            builderNewConfigBuilder.withNativeCrashReporting(appMetricaConfig.nativeCrashReporting.booleanValue());
        }
        if (hn.a(appMetricaConfig.locationTracking)) {
            builderNewConfigBuilder.withLocationTracking(appMetricaConfig.locationTracking.booleanValue());
        }
        if (hn.a(appMetricaConfig.firstActivationAsUpdate)) {
            builderNewConfigBuilder.handleFirstActivationAsUpdate(appMetricaConfig.firstActivationAsUpdate.booleanValue());
        }
        if (hn.a(appMetricaConfig.dataSendingEnabled)) {
            builderNewConfigBuilder.withDataSendingEnabled(appMetricaConfig.dataSendingEnabled.booleanValue());
        }
        if (hn.a(appMetricaConfig.anrMonitoring)) {
            builderNewConfigBuilder.withAnrMonitoring(appMetricaConfig.anrMonitoring.booleanValue());
        }
        if (hn.a(appMetricaConfig.anrMonitoringTimeout)) {
            builderNewConfigBuilder.withAnrMonitoringTimeout(appMetricaConfig.anrMonitoringTimeout.intValue());
        }
        if (hn.a(appMetricaConfig.maxReportsInDatabaseCount)) {
            builderNewConfigBuilder.withMaxReportsInDatabaseCount(appMetricaConfig.maxReportsInDatabaseCount.intValue());
        }
        if (hn.a(appMetricaConfig.crashTransformer)) {
            builderNewConfigBuilder.withCrashTransformer(appMetricaConfig.crashTransformer);
        }
        if (hn.a(appMetricaConfig.userProfileID)) {
            builderNewConfigBuilder.withUserProfileID(appMetricaConfig.userProfileID);
        }
        if (hn.a(appMetricaConfig.revenueAutoTrackingEnabled)) {
            builderNewConfigBuilder.withRevenueAutoTrackingEnabled(appMetricaConfig.revenueAutoTrackingEnabled.booleanValue());
        }
        if (hn.a(appMetricaConfig.appOpenTrackingEnabled)) {
            builderNewConfigBuilder.withAppOpenTrackingEnabled(appMetricaConfig.appOpenTrackingEnabled.booleanValue());
        }
        if (hn.a((Object) appMetricaConfig.customHosts)) {
            builderNewConfigBuilder.withCustomHosts(appMetricaConfig.customHosts);
        }
        LinkedHashMap linkedHashMap = this.d;
        if (!hn.a((Map) linkedHashMap)) {
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                builderNewConfigBuilder.withAppEnvironmentValue((String) entry.getKey(), (String) entry.getValue());
            }
        }
        Map<String, String> map = appMetricaConfig.appEnvironment;
        if (!hn.a((Map) map)) {
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                builderNewConfigBuilder.withAppEnvironmentValue(entry2.getKey(), entry2.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = this.e;
        if (!hn.a((Map) linkedHashMap2)) {
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                builderNewConfigBuilder.withErrorEnvironmentValue((String) entry3.getKey(), (String) entry3.getValue());
            }
        }
        Map<String, String> map2 = appMetricaConfig.errorEnvironment;
        if (!hn.a((Map) map2)) {
            for (Map.Entry<String, String> entry4 : map2.entrySet()) {
                builderNewConfigBuilder.withErrorEnvironmentValue(entry4.getKey(), entry4.getValue());
            }
        }
        Map<String, Object> map3 = appMetricaConfig.additionalConfig;
        if (!hn.a((Map) map3)) {
            for (Map.Entry<String, Object> entry5 : map3.entrySet()) {
                builderNewConfigBuilder.withAdditionalConfig(entry5.getKey(), entry5.getValue());
            }
        }
        Boolean bool = this.b;
        if (appMetricaConfig.locationTracking == null && hn.a(bool)) {
            builderNewConfigBuilder.withLocationTracking(bool.booleanValue());
        }
        Location location = this.a;
        if (appMetricaConfig.location == null && hn.a(location)) {
            builderNewConfigBuilder.withLocation(location);
        }
        Boolean bool2 = this.c;
        if (appMetricaConfig.dataSendingEnabled == null && hn.a(bool2)) {
            builderNewConfigBuilder.withDataSendingEnabled(bool2.booleanValue());
        }
        if (!hn.a(appMetricaConfig.userProfileID) && hn.a(this.g)) {
            builderNewConfigBuilder.withUserProfileID(this.g);
        }
        this.h = true;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d.clear();
        this.e.clear();
        this.f = false;
        this.g = null;
        return builderNewConfigBuilder.build();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void clearAppEnvironment() {
        this.f = true;
        this.d.clear();
    }

    public final Location j() {
        return this.a;
    }

    public final Boolean k() {
        return this.c;
    }

    public final Boolean l() {
        return this.b;
    }

    public final boolean m() {
        return this.f;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void putAppEnvironmentValue(String str, String str2) {
        this.d.put(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void setDataSendingEnabled(boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        this.c = boolValueOf;
        Lh lh = this.i;
        if (lh != null) {
            Boolean bool = this.b;
            if (hn.a(bool)) {
                lh.a.b.setLocationTracking(bool.booleanValue());
            }
            if (hn.a(boolValueOf)) {
                lh.a.b.setDataSendingEnabled(z);
            }
            Q5 q5A = Q5.a();
            Q4 q4 = lh.a;
            lh.a(Lh.a(q5A, q4), q4, 1, null);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void setUserProfileID(String str) {
        this.g = str;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(Location location) {
        this.a = location;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(String str, String str2) {
        this.e.put(str, str2);
    }

    public final void a(Lh lh) {
        this.i = lh;
    }
}
