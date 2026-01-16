package org.acra.collector;

import android.content.Context;
import java.io.IOException;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.collector.Collector;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;
import org.acra.util.StreamReader;

/* loaded from: classes.dex */
public final class LogFileCollector extends BaseReportFieldCollector {
    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    public LogFileCollector() {
        super(ReportField.APPLICATION_LOG, new ReportField[0]);
    }

    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector
    public Collector.Order getOrder() {
        return Collector.Order.LATE;
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    void collect(ReportField reportField, Context context, CoreConfiguration coreConfiguration, ReportBuilder reportBuilder, CrashReportData crashReportData) throws IOException {
        crashReportData.put(ReportField.APPLICATION_LOG, new StreamReader(coreConfiguration.applicationLogFileDir().getFile(context, coreConfiguration.applicationLogFile())).setLimit(coreConfiguration.applicationLogFileLines()).read());
    }
}
