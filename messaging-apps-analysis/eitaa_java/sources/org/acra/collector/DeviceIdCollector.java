package org.acra.collector;

import android.annotation.SuppressLint;
import android.content.Context;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;
import org.acra.prefs.SharedPreferencesFactory;
import org.acra.util.PackageManagerWrapper;
import org.acra.util.SystemServices;

/* loaded from: classes.dex */
public final class DeviceIdCollector extends BaseReportFieldCollector {
    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    public DeviceIdCollector() {
        super(ReportField.DEVICE_ID, new ReportField[0]);
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    boolean shouldCollect(Context context, CoreConfiguration coreConfiguration, ReportField reportField, ReportBuilder reportBuilder) {
        return super.shouldCollect(context, coreConfiguration, reportField, reportBuilder) && new SharedPreferencesFactory(context, coreConfiguration).create().getBoolean(ACRA.PREF_ENABLE_DEVICE_ID, true) && new PackageManagerWrapper(context).hasPermission("android.permission.READ_PHONE_STATE");
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    @SuppressLint({"HardwareIds"})
    void collect(ReportField reportField, Context context, CoreConfiguration coreConfiguration, ReportBuilder reportBuilder, CrashReportData crashReportData) throws Exception {
        crashReportData.put(ReportField.DEVICE_ID, SystemServices.getTelephonyManager(context).getDeviceId());
    }
}
