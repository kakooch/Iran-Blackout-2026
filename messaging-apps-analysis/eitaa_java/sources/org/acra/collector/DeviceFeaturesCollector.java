package org.acra.collector;

import android.content.Context;
import android.content.pm.FeatureInfo;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class DeviceFeaturesCollector extends BaseReportFieldCollector {
    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    public DeviceFeaturesCollector() {
        super(ReportField.DEVICE_FEATURES, new ReportField[0]);
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    void collect(ReportField reportField, Context context, CoreConfiguration coreConfiguration, ReportBuilder reportBuilder, CrashReportData crashReportData) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (FeatureInfo featureInfo : context.getPackageManager().getSystemAvailableFeatures()) {
            String str = featureInfo.name;
            if (str != null) {
                jSONObject.put(str, true);
            } else {
                jSONObject.put("glEsVersion", featureInfo.getGlEsVersion());
            }
        }
        crashReportData.put(ReportField.DEVICE_FEATURES, jSONObject);
    }
}
