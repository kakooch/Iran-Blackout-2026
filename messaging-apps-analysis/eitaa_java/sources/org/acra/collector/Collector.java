package org.acra.collector;

import android.content.Context;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;

/* loaded from: classes.dex */
public interface Collector extends Plugin {

    public enum Order {
        FIRST,
        EARLY,
        NORMAL,
        LATE,
        LAST
    }

    void collect(Context context, CoreConfiguration coreConfiguration, ReportBuilder reportBuilder, CrashReportData crashReportData) throws CollectorException;

    @Override // org.acra.plugins.Plugin
    /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration);

    Order getOrder();

    /* renamed from: org.acra.collector.Collector$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
    }
}
