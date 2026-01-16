package org.acra.collector;

import android.content.Context;
import org.acra.config.CoreConfiguration;

/* loaded from: classes.dex */
public interface ApplicationStartupCollector extends Collector {

    /* renamed from: org.acra.collector.ApplicationStartupCollector$-CC, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final /* synthetic */ class CC {
    }

    void collectApplicationStartUp(Context context, CoreConfiguration coreConfiguration);

    @Override // org.acra.collector.Collector, org.acra.plugins.Plugin
    /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration);
}
