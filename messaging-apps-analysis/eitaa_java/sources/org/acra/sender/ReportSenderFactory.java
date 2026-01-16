package org.acra.sender;

import android.content.Context;
import org.acra.config.CoreConfiguration;
import org.acra.plugins.Plugin;

/* loaded from: classes.dex */
public interface ReportSenderFactory extends Plugin {

    /* renamed from: org.acra.sender.ReportSenderFactory$-CC, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final /* synthetic */ class CC {
    }

    ReportSender create(Context context, CoreConfiguration coreConfiguration);

    @Override // org.acra.plugins.Plugin
    /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration);
}
