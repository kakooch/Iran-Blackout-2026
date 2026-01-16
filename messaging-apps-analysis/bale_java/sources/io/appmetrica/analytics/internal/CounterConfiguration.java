package io.appmetrica.analytics.internal;

import android.content.ContentValues;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.LocationUtils;
import io.appmetrica.analytics.impl.hn;

/* loaded from: classes3.dex */
public class CounterConfiguration implements Parcelable {
    public static final Parcelable.Creator<CounterConfiguration> CREATOR = new b();
    private final ContentValues a;

    /* synthetic */ CounterConfiguration(ContentValues contentValues, int i) {
        this(contentValues);
    }

    private void a(String str) {
        if (hn.a(str)) {
            setApiKey(str);
        }
    }

    private void b(String str) {
        if ("20799a27-fa80-4b36-b2db-0f8141f24180".equals(str)) {
            setReporterType(CounterConfigurationReporterType.SELF_SDK);
        } else {
            setReporterType(CounterConfigurationReporterType.MANUAL);
        }
    }

    private void c(Integer num) {
        if (hn.a(num)) {
            this.a.put("MAX_REPORTS_IN_DB_COUNT", num);
        }
    }

    private void d(Integer num) {
        if (hn.a(num)) {
            setSessionTimeout(num.intValue());
        }
    }

    public static CounterConfiguration fromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            return (CounterConfiguration) bundle.getParcelable("COUNTER_CFG_OBJ");
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized void applyFromConfig(AppMetricaConfig appMetricaConfig) {
        try {
            a(appMetricaConfig.apiKey);
            d(appMetricaConfig.sessionTimeout);
            if (hn.a(appMetricaConfig.location)) {
                setManualLocation(appMetricaConfig.location);
            }
            if (hn.a(appMetricaConfig.locationTracking)) {
                setLocationTracking(appMetricaConfig.locationTracking.booleanValue());
            }
            if (hn.a(appMetricaConfig.deviceType)) {
                setDeviceType(appMetricaConfig.deviceType);
            }
            a(appMetricaConfig.dispatchPeriodSeconds);
            b(appMetricaConfig.maxReportsCount);
            b(appMetricaConfig.logs);
            if (!TextUtils.isEmpty(appMetricaConfig.appVersion)) {
                setCustomAppVersion(appMetricaConfig.appVersion);
            }
            if (hn.a(appMetricaConfig.appBuildNumber)) {
                setAppBuildNumber(appMetricaConfig.appBuildNumber.intValue());
            }
            if (hn.a(appMetricaConfig.firstActivationAsUpdate)) {
                setFirstActivationAsUpdate(appMetricaConfig.firstActivationAsUpdate.booleanValue());
            }
            a(appMetricaConfig.dataSendingEnabled);
            c(appMetricaConfig.maxReportsInDatabaseCount);
            Boolean bool = appMetricaConfig.nativeCrashReporting;
            if (hn.a(bool)) {
                this.a.put("CFG_NATIVE_CRASHES_ENABLED", bool);
            }
            if (hn.a(appMetricaConfig.revenueAutoTrackingEnabled)) {
                setRevenueAutoTrackingEnabled(appMetricaConfig.revenueAutoTrackingEnabled.booleanValue());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getApiKey() {
        return this.a.getAsString("CFG_API_KEY");
    }

    public String getAppBuildNumber() {
        return this.a.getAsString("CFG_APP_VERSION_CODE");
    }

    public String getAppVersion() {
        return this.a.getAsString("CFG_APP_VERSION");
    }

    public Boolean getDataSendingEnabled() {
        return this.a.getAsBoolean("CFG_DATA_SENDING_ENABLED");
    }

    public String getDeviceType() {
        return this.a.getAsString("CFG_DEVICE_SIZE_TYPE");
    }

    public Integer getDispatchPeriod() {
        return this.a.getAsInteger("CFG_DISPATCH_PERIOD");
    }

    public Location getManualLocation() {
        if (this.a.containsKey("CFG_MANUAL_LOCATION")) {
            return LocationUtils.bytesToLocation(this.a.getAsByteArray("CFG_MANUAL_LOCATION"));
        }
        return null;
    }

    public Integer getMaxReportsCount() {
        return this.a.getAsInteger("CFG_MAX_REPORTS_COUNT");
    }

    public Integer getMaxReportsInDbCount() {
        return this.a.getAsInteger("MAX_REPORTS_IN_DB_COUNT");
    }

    public Boolean getReportNativeCrashesEnabled() {
        return this.a.getAsBoolean("CFG_NATIVE_CRASHES_ENABLED");
    }

    public CounterConfigurationReporterType getReporterType() {
        return CounterConfigurationReporterType.fromStringValue(this.a.getAsString("CFG_REPORTER_TYPE"));
    }

    public Integer getSessionTimeout() {
        return this.a.getAsInteger("CFG_SESSION_TIMEOUT");
    }

    public String getUuid() {
        return this.a.getAsString("CFG_UUID");
    }

    public Boolean isFirstActivationAsUpdate() {
        return this.a.getAsBoolean("CFG_IS_FIRST_ACTIVATION_AS_UPDATE");
    }

    public Boolean isLocationTrackingEnabled() {
        return this.a.getAsBoolean("CFG_LOCATION_TRACKING");
    }

    public Boolean isLogEnabled() {
        return this.a.getAsBoolean("CFG_IS_LOG_ENABLED");
    }

    public synchronized Boolean isRevenueAutoTrackingEnabled() {
        return this.a.getAsBoolean("CFG_REVENUE_AUTO_TRACKING_ENABLED");
    }

    public synchronized void setApiKey(String str) {
        this.a.put("CFG_API_KEY", str);
    }

    public synchronized void setAppBuildNumber(int i) {
        this.a.put("CFG_APP_VERSION_CODE", String.valueOf(i));
    }

    public final synchronized void setCustomAppVersion(String str) {
        this.a.put("CFG_APP_VERSION", str);
    }

    public final synchronized void setDataSendingEnabled(boolean z) {
        this.a.put("CFG_DATA_SENDING_ENABLED", Boolean.valueOf(z));
    }

    public final synchronized void setDeviceType(String str) {
        ContentValues contentValues = this.a;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        contentValues.put("CFG_DEVICE_SIZE_TYPE", str);
    }

    public synchronized void setDispatchPeriod(int i) {
        this.a.put("CFG_DISPATCH_PERIOD", Integer.valueOf(i));
    }

    public final synchronized void setFirstActivationAsUpdate(boolean z) {
        this.a.put("CFG_IS_FIRST_ACTIVATION_AS_UPDATE", Boolean.valueOf(z));
    }

    public synchronized void setLocationTracking(boolean z) {
        this.a.put("CFG_LOCATION_TRACKING", Boolean.valueOf(z));
    }

    public synchronized void setLogEnabled(boolean z) {
        this.a.put("CFG_IS_LOG_ENABLED", Boolean.valueOf(z));
    }

    public final synchronized void setManualLocation(Location location) {
        this.a.put("CFG_MANUAL_LOCATION", LocationUtils.locationToBytes(location));
    }

    public synchronized void setMaxReportsCount(int i) {
        ContentValues contentValues = this.a;
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        contentValues.put("CFG_MAX_REPORTS_COUNT", Integer.valueOf(i));
    }

    public void setMaxReportsInDbCount(int i) {
        this.a.put("MAX_REPORTS_IN_DB_COUNT", Integer.valueOf(i));
    }

    public synchronized void setReporterType(CounterConfigurationReporterType counterConfigurationReporterType) {
        this.a.put("CFG_REPORTER_TYPE", counterConfigurationReporterType.getStringValue());
    }

    public synchronized void setRevenueAutoTrackingEnabled(boolean z) {
        this.a.put("CFG_REVENUE_AUTO_TRACKING_ENABLED", Boolean.valueOf(z));
    }

    public synchronized void setSessionTimeout(int i) {
        this.a.put("CFG_SESSION_TIMEOUT", Integer.valueOf(i));
    }

    public synchronized void setUuid(String str) {
        this.a.put("CFG_UUID", str);
    }

    public synchronized void toBundle(Bundle bundle) {
        bundle.putParcelable("COUNTER_CFG_OBJ", this);
    }

    public synchronized String toString() {
        return "CounterConfiguration{mParamsMapping=" + this.a + '}';
    }

    @Override // android.os.Parcelable
    public synchronized void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.internal.CounterConfiguration.data", this.a);
        parcel.writeBundle(bundle);
    }

    public CounterConfiguration(CounterConfiguration counterConfiguration) {
        synchronized (counterConfiguration) {
            this.a = new ContentValues(counterConfiguration.a);
        }
    }

    private void a(Integer num) {
        if (hn.a(num)) {
            setDispatchPeriod(num.intValue());
        }
    }

    private void b(Integer num) {
        if (hn.a(num)) {
            setMaxReportsCount(num.intValue());
        }
    }

    private void a(Boolean bool) {
        if (hn.a(bool)) {
            setDataSendingEnabled(bool.booleanValue());
        }
    }

    private void b(Boolean bool) {
        if (hn.a(bool)) {
            setLogEnabled(bool.booleanValue());
        }
    }

    public CounterConfiguration() {
        this.a = new ContentValues();
    }

    public CounterConfiguration(String str) {
        this();
        synchronized (this) {
            setApiKey(str);
        }
    }

    public CounterConfiguration(CounterConfigurationReporterType counterConfigurationReporterType) {
        this();
        synchronized (this) {
            setReporterType(counterConfigurationReporterType);
        }
    }

    public CounterConfiguration(AppMetricaConfig appMetricaConfig, CounterConfigurationReporterType counterConfigurationReporterType) {
        this();
        synchronized (this) {
            applyFromConfig(appMetricaConfig);
            setReporterType(counterConfigurationReporterType);
        }
    }

    public CounterConfiguration(ReporterConfig reporterConfig) {
        this();
        synchronized (this) {
            a(reporterConfig.apiKey);
            d(reporterConfig.sessionTimeout);
            a(reporterConfig.dispatchPeriodSeconds);
            b(reporterConfig.maxReportsCount);
            b(reporterConfig.logs);
            a(reporterConfig.dataSendingEnabled);
            c(reporterConfig.maxReportsInDatabaseCount);
            b(reporterConfig.apiKey);
        }
    }

    private CounterConfiguration(ContentValues contentValues) {
        this.a = contentValues;
    }
}
