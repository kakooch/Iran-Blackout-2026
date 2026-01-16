package org.acra.collector;

import android.content.Context;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class CustomDataCollector extends BaseReportFieldCollector {
    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    public CustomDataCollector() {
        super(ReportField.CUSTOM_DATA, new ReportField[0]);
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    void collect(ReportField reportField, Context context, CoreConfiguration coreConfiguration, ReportBuilder reportBuilder, CrashReportData crashReportData) {
        crashReportData.put(ReportField.CUSTOM_DATA, new JSONObject(reportBuilder.getCustomData()));
    }
}
