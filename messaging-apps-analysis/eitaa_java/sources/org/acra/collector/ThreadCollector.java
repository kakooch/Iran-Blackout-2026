package org.acra.collector;

import android.content.Context;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.collector.Collector;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ThreadCollector extends BaseReportFieldCollector {
    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    public ThreadCollector() {
        super(ReportField.THREAD_DETAILS, new ReportField[0]);
    }

    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector
    public Collector.Order getOrder() {
        return Collector.Order.LATE;
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    void collect(ReportField reportField, Context context, CoreConfiguration coreConfiguration, ReportBuilder reportBuilder, CrashReportData crashReportData) throws Exception {
        Thread uncaughtExceptionThread = reportBuilder.getUncaughtExceptionThread();
        if (uncaughtExceptionThread != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", uncaughtExceptionThread.getId());
            jSONObject.put("name", uncaughtExceptionThread.getName());
            jSONObject.put("priority", uncaughtExceptionThread.getPriority());
            if (uncaughtExceptionThread.getThreadGroup() != null) {
                jSONObject.put("groupName", uncaughtExceptionThread.getThreadGroup().getName());
            }
            crashReportData.put(ReportField.THREAD_DETAILS, jSONObject);
            return;
        }
        crashReportData.put(ReportField.THREAD_DETAILS, (String) null);
    }
}
