package org.acra.scheduler;

import android.content.Context;
import org.acra.config.CoreConfiguration;
import org.acra.plugins.Plugin;

/* loaded from: classes.dex */
public interface SenderSchedulerFactory extends Plugin {

    /* renamed from: org.acra.scheduler.SenderSchedulerFactory$-CC, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final /* synthetic */ class CC {
    }

    SenderScheduler create(Context context, CoreConfiguration coreConfiguration);

    @Override // org.acra.plugins.Plugin
    /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration);
}
