package io.appmetrica.analytics;

import android.location.Location;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.impl.Am;
import io.appmetrica.analytics.impl.C2796q5;
import io.appmetrica.analytics.impl.X3;
import io.appmetrica.analytics.impl.Ya;
import io.appmetrica.analytics.impl.Z;
import io.appmetrica.analytics.impl.hn;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AppMetricaConfig {
    public final Map<String, Object> additionalConfig;
    public final Boolean anrMonitoring;
    public final Integer anrMonitoringTimeout;
    public final String apiKey;
    public final Integer appBuildNumber;
    public final Map<String, String> appEnvironment;
    public final Boolean appOpenTrackingEnabled;
    public final String appVersion;
    public final Boolean crashReporting;
    public final ICrashTransformer crashTransformer;
    public final List<String> customHosts;
    public final Boolean dataSendingEnabled;
    public final String deviceType;
    public final Integer dispatchPeriodSeconds;
    public final Map<String, String> errorEnvironment;
    public final Boolean firstActivationAsUpdate;
    public final Location location;
    public final Boolean locationTracking;
    public final Boolean logs;
    public final Integer maxReportsCount;
    public final Integer maxReportsInDatabaseCount;
    public final Boolean nativeCrashReporting;
    public final PreloadInfo preloadInfo;
    public final Boolean revenueAutoTrackingEnabled;
    public final Integer sessionTimeout;
    public final Boolean sessionsAutoTrackingEnabled;
    public final String userProfileID;

    public static class Builder {
        private static final Am C = new Am(new Z());
        private List A;
        private final HashMap B;
        private final C2796q5 a;
        private final String b;
        private String c;
        private Integer d;
        private Boolean e;
        private Boolean f;
        private Location g;
        private Boolean h;
        private Boolean i;
        private PreloadInfo j;
        private Boolean k;
        private Boolean l;
        private Integer m;
        private final LinkedHashMap n;
        private String o;
        private Boolean p;
        private Boolean q;
        private Boolean r;
        private String s;
        private Integer t;
        private Integer u;
        private Integer v;
        private final LinkedHashMap w;
        private ICrashTransformer x;
        private Boolean y;
        private Integer z;

        /* synthetic */ Builder(String str, int i) {
            this(str);
        }

        public AppMetricaConfig build() {
            return new AppMetricaConfig(this, 0);
        }

        public Builder handleFirstActivationAsUpdate(boolean z) {
            this.k = Boolean.valueOf(z);
            return this;
        }

        public Builder withAdditionalConfig(String str, Object obj) {
            this.B.put(str, obj);
            return this;
        }

        public Builder withAnrMonitoring(boolean z) {
            this.y = Boolean.valueOf(z);
            return this;
        }

        public Builder withAnrMonitoringTimeout(int i) {
            this.z = Integer.valueOf(i);
            return this;
        }

        public Builder withAppBuildNumber(int i) {
            if (i < 0) {
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid %1$s. %1$s should be positive.", "App Build Number"));
            }
            this.t = Integer.valueOf(i);
            return this;
        }

        public Builder withAppEnvironmentValue(String str, String str2) {
            this.w.put(str, str2);
            return this;
        }

        public Builder withAppOpenTrackingEnabled(boolean z) {
            this.r = Boolean.valueOf(z);
            return this;
        }

        public Builder withAppVersion(String str) {
            this.c = str;
            return this;
        }

        public Builder withCrashReporting(boolean z) {
            this.e = Boolean.valueOf(z);
            return this;
        }

        public Builder withCrashTransformer(ICrashTransformer iCrashTransformer) {
            this.x = iCrashTransformer;
            return this;
        }

        public Builder withCustomHosts(List<String> list) {
            this.A = CollectionUtils.unmodifiableListCopy(list);
            return this;
        }

        public Builder withDataSendingEnabled(boolean z) {
            this.l = Boolean.valueOf(z);
            return this;
        }

        public Builder withDeviceType(String str) {
            this.s = str;
            return this;
        }

        public Builder withDispatchPeriodSeconds(int i) {
            this.u = Integer.valueOf(i);
            return this;
        }

        public Builder withErrorEnvironmentValue(String str, String str2) {
            this.n.put(str, str2);
            return this;
        }

        public Builder withLocation(Location location) {
            this.g = location;
            return this;
        }

        public Builder withLocationTracking(boolean z) {
            this.h = Boolean.valueOf(z);
            return this;
        }

        public Builder withLogs() {
            this.i = Boolean.TRUE;
            return this;
        }

        public Builder withMaxReportsCount(int i) {
            this.v = Integer.valueOf(i);
            return this;
        }

        public Builder withMaxReportsInDatabaseCount(int i) {
            this.m = Integer.valueOf(this.a.a(i));
            return this;
        }

        public Builder withNativeCrashReporting(boolean z) {
            this.f = Boolean.valueOf(z);
            return this;
        }

        public Builder withPreloadInfo(PreloadInfo preloadInfo) {
            this.j = preloadInfo;
            return this;
        }

        public Builder withRevenueAutoTrackingEnabled(boolean z) {
            this.p = Boolean.valueOf(z);
            return this;
        }

        public Builder withSessionTimeout(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        public Builder withSessionsAutoTrackingEnabled(boolean z) {
            this.q = Boolean.valueOf(z);
            return this;
        }

        public Builder withUserProfileID(String str) {
            this.o = str;
            return this;
        }

        private Builder(String str) {
            this.n = new LinkedHashMap();
            this.w = new LinkedHashMap();
            this.B = new HashMap();
            C.a(str);
            this.a = new C2796q5(str);
            this.b = str;
        }
    }

    /* synthetic */ AppMetricaConfig(Builder builder, int i) {
        this(builder);
    }

    public static AppMetricaConfig fromJson(String str) {
        AppMetricaConfig appMetricaConfig;
        HashMap mapC;
        HashMap mapC2;
        HashMap mapC3;
        if (TextUtils.isEmpty(str)) {
            appMetricaConfig = null;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Builder builderNewConfigBuilder = newConfigBuilder(jSONObject.getString("apikey"));
                if (jSONObject.has("app_version")) {
                    builderNewConfigBuilder.withAppVersion(jSONObject.optString("app_version"));
                }
                if (jSONObject.has("session_timeout")) {
                    builderNewConfigBuilder.withSessionTimeout(jSONObject.getInt("session_timeout"));
                }
                builderNewConfigBuilder.withLocation(X3.a(jSONObject.optString("location")));
                builderNewConfigBuilder.withPreloadInfo(X3.b(jSONObject.optString("preload_info")));
                if (jSONObject.has("logs") && jSONObject.optBoolean("logs")) {
                    builderNewConfigBuilder.withLogs();
                }
                if (jSONObject.has("crash_enabled")) {
                    builderNewConfigBuilder.withCrashReporting(jSONObject.optBoolean("crash_enabled"));
                }
                if (jSONObject.has("crash_native_enabled")) {
                    builderNewConfigBuilder.withNativeCrashReporting(jSONObject.optBoolean("crash_native_enabled"));
                }
                if (jSONObject.has("location_enabled")) {
                    builderNewConfigBuilder.withLocationTracking(jSONObject.optBoolean("location_enabled"));
                }
                if (jSONObject.has("max_reports_in_db_count")) {
                    builderNewConfigBuilder.withMaxReportsInDatabaseCount(jSONObject.optInt("max_reports_in_db_count"));
                }
                if (jSONObject.has("error_environment") && (mapC3 = Ya.c(jSONObject.optString("error_environment"))) != null) {
                    for (Map.Entry entry : mapC3.entrySet()) {
                        builderNewConfigBuilder.withErrorEnvironmentValue((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (jSONObject.has("first_activation_as_update")) {
                    builderNewConfigBuilder.handleFirstActivationAsUpdate(jSONObject.optBoolean("first_activation_as_update"));
                }
                if (jSONObject.has("data_sending_enabled")) {
                    builderNewConfigBuilder.withDataSendingEnabled(jSONObject.optBoolean("data_sending_enabled"));
                }
                if (jSONObject.has("user_profile_id")) {
                    appMetricaConfig = null;
                    try {
                        builderNewConfigBuilder.withUserProfileID(jSONObject.optString("user_profile_id", null));
                    } catch (Throwable unused) {
                    }
                } else {
                    appMetricaConfig = null;
                }
                if (jSONObject.has("revenue_auto_tracking_enabled")) {
                    builderNewConfigBuilder.withRevenueAutoTrackingEnabled(jSONObject.optBoolean("revenue_auto_tracking_enabled"));
                }
                if (jSONObject.has("sessions_auto_tracking_enabled")) {
                    builderNewConfigBuilder.withSessionsAutoTrackingEnabled(jSONObject.optBoolean("sessions_auto_tracking_enabled"));
                }
                if (jSONObject.has("app_open_tracking_enabled")) {
                    builderNewConfigBuilder.withAppOpenTrackingEnabled(jSONObject.optBoolean("app_open_tracking_enabled"));
                }
                if (jSONObject.has(CommonUrlParts.DEVICE_TYPE)) {
                    builderNewConfigBuilder.withDeviceType(jSONObject.optString(CommonUrlParts.DEVICE_TYPE));
                }
                if (jSONObject.has(CommonUrlParts.APP_VERSION_CODE)) {
                    builderNewConfigBuilder.withAppBuildNumber(jSONObject.optInt(CommonUrlParts.APP_VERSION_CODE));
                }
                if (jSONObject.has("dispatch_period_seconds")) {
                    builderNewConfigBuilder.withDispatchPeriodSeconds(jSONObject.optInt("dispatch_period_seconds"));
                }
                if (jSONObject.has("max_reports_count")) {
                    builderNewConfigBuilder.withMaxReportsCount(jSONObject.optInt("max_reports_count"));
                }
                if (jSONObject.has("app_environment") && (mapC2 = Ya.c(jSONObject.optString("app_environment"))) != null) {
                    for (Map.Entry entry2 : mapC2.entrySet()) {
                        builderNewConfigBuilder.withAppEnvironmentValue((String) entry2.getKey(), (String) entry2.getValue());
                    }
                }
                if (jSONObject.has("anr_monitoring")) {
                    builderNewConfigBuilder.withAnrMonitoring(jSONObject.optBoolean("anr_monitoring"));
                }
                if (jSONObject.has("anr_monitoring_timeout")) {
                    builderNewConfigBuilder.withAnrMonitoringTimeout(jSONObject.optInt("anr_monitoring_timeout"));
                }
                if (jSONObject.has("customHosts")) {
                    builderNewConfigBuilder.withCustomHosts(Ya.a(jSONObject.optJSONArray("customHosts")));
                }
                if (jSONObject.has("additional_config") && (mapC = Ya.c(jSONObject.optString("additional_config"))) != null) {
                    for (Map.Entry entry3 : mapC.entrySet()) {
                        builderNewConfigBuilder.withAdditionalConfig((String) entry3.getKey(), entry3.getValue());
                    }
                }
                return builderNewConfigBuilder.build();
            } catch (Throwable unused2) {
            }
        }
        return appMetricaConfig;
    }

    public static Builder newConfigBuilder(String str) {
        return new Builder(str, 0);
    }

    public String toJson() {
        String string;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("apikey", this.apiKey);
            jSONObject.put("app_version", this.appVersion);
            jSONObject.put("session_timeout", this.sessionTimeout);
            jSONObject.put("location", X3.a(this.location));
            PreloadInfo preloadInfo = this.preloadInfo;
            JSONObject jSONObject2 = null;
            if (preloadInfo == null) {
                string = null;
            } else {
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("trackid", preloadInfo.getTrackingId());
                    Map<String, String> additionalParams = preloadInfo.getAdditionalParams();
                    jSONObject3.put("params", additionalParams == null ? null : new JSONObject(additionalParams));
                    string = jSONObject3.toString();
                } catch (Throwable unused) {
                }
            }
            jSONObject.put("preload_info", string);
            jSONObject.put("logs", this.logs);
            jSONObject.put("crash_enabled", this.crashReporting);
            jSONObject.put("crash_native_enabled", this.nativeCrashReporting);
            jSONObject.put("location_enabled", this.locationTracking);
            jSONObject.put("max_reports_in_db_count", this.maxReportsInDatabaseCount);
            Map<String, String> map = this.errorEnvironment;
            jSONObject.put("error_environment", map == null ? null : new JSONObject(map));
            jSONObject.put("first_activation_as_update", this.firstActivationAsUpdate);
            jSONObject.put("data_sending_enabled", this.dataSendingEnabled);
            jSONObject.put("user_profile_id", this.userProfileID);
            jSONObject.put("revenue_auto_tracking_enabled", this.revenueAutoTrackingEnabled);
            jSONObject.put("sessions_auto_tracking_enabled", this.sessionsAutoTrackingEnabled);
            jSONObject.put("app_open_tracking_enabled", this.appOpenTrackingEnabled);
            jSONObject.put(CommonUrlParts.DEVICE_TYPE, this.deviceType);
            jSONObject.put(CommonUrlParts.APP_VERSION_CODE, this.appBuildNumber);
            jSONObject.put("dispatch_period_seconds", this.dispatchPeriodSeconds);
            jSONObject.put("max_reports_count", this.maxReportsCount);
            Map<String, String> map2 = this.appEnvironment;
            jSONObject.put("app_environment", map2 == null ? null : new JSONObject(map2));
            jSONObject.put("anr_monitoring", this.anrMonitoring);
            jSONObject.put("anr_monitoring_timeout", this.anrMonitoringTimeout);
            List<String> list = this.customHosts;
            if (list != null) {
                jSONObject.put("customHosts", hn.a((Collection) list) ? null : new JSONArray((Collection) list));
            }
            Map<String, Object> map3 = this.additionalConfig;
            if (map3 != null) {
                jSONObject2 = new JSONObject(map3);
            }
            jSONObject.put("additional_config", jSONObject2);
            return jSONObject.toString();
        } catch (Throwable unused2) {
            return "";
        }
    }

    private AppMetricaConfig(Builder builder) {
        this.apiKey = builder.b;
        this.appVersion = builder.c;
        this.sessionTimeout = builder.d;
        this.crashReporting = builder.e;
        this.nativeCrashReporting = builder.f;
        this.location = builder.g;
        this.locationTracking = builder.h;
        this.logs = builder.i;
        this.preloadInfo = builder.j;
        this.firstActivationAsUpdate = builder.k;
        this.dataSendingEnabled = builder.l;
        this.maxReportsInDatabaseCount = builder.m;
        this.errorEnvironment = CollectionUtils.unmodifiableSameOrderMapCopy(builder.n);
        this.userProfileID = builder.o;
        this.revenueAutoTrackingEnabled = builder.p;
        this.sessionsAutoTrackingEnabled = builder.q;
        this.appOpenTrackingEnabled = builder.r;
        this.deviceType = builder.s;
        this.appBuildNumber = builder.t;
        this.dispatchPeriodSeconds = builder.u;
        this.maxReportsCount = builder.v;
        this.appEnvironment = CollectionUtils.unmodifiableSameOrderMapCopy(builder.w);
        this.crashTransformer = builder.x;
        this.anrMonitoring = builder.y;
        this.anrMonitoringTimeout = builder.z;
        this.customHosts = builder.A;
        this.additionalConfig = CollectionUtils.unmodifiableSameOrderMapCopy(builder.B);
    }

    protected AppMetricaConfig(AppMetricaConfig appMetricaConfig) {
        this.apiKey = appMetricaConfig.apiKey;
        this.appVersion = appMetricaConfig.appVersion;
        this.sessionTimeout = appMetricaConfig.sessionTimeout;
        this.crashReporting = appMetricaConfig.crashReporting;
        this.nativeCrashReporting = appMetricaConfig.nativeCrashReporting;
        this.location = appMetricaConfig.location;
        this.locationTracking = appMetricaConfig.locationTracking;
        this.logs = appMetricaConfig.logs;
        this.preloadInfo = appMetricaConfig.preloadInfo;
        this.firstActivationAsUpdate = appMetricaConfig.firstActivationAsUpdate;
        this.dataSendingEnabled = appMetricaConfig.dataSendingEnabled;
        this.maxReportsInDatabaseCount = appMetricaConfig.maxReportsInDatabaseCount;
        this.errorEnvironment = appMetricaConfig.errorEnvironment;
        this.userProfileID = appMetricaConfig.userProfileID;
        this.revenueAutoTrackingEnabled = appMetricaConfig.revenueAutoTrackingEnabled;
        this.sessionsAutoTrackingEnabled = appMetricaConfig.sessionsAutoTrackingEnabled;
        this.appOpenTrackingEnabled = appMetricaConfig.appOpenTrackingEnabled;
        this.deviceType = appMetricaConfig.deviceType;
        this.appBuildNumber = appMetricaConfig.appBuildNumber;
        this.dispatchPeriodSeconds = appMetricaConfig.dispatchPeriodSeconds;
        this.maxReportsCount = appMetricaConfig.maxReportsCount;
        this.appEnvironment = appMetricaConfig.appEnvironment;
        this.crashTransformer = appMetricaConfig.crashTransformer;
        this.anrMonitoring = appMetricaConfig.anrMonitoring;
        this.anrMonitoringTimeout = appMetricaConfig.anrMonitoringTimeout;
        this.customHosts = appMetricaConfig.customHosts;
        this.additionalConfig = appMetricaConfig.additionalConfig;
    }
}
