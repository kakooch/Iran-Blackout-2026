package org.acra.interaction;

import android.content.Context;
import java.io.File;
import org.acra.config.CoreConfiguration;
import org.acra.plugins.Plugin;

/* loaded from: classes.dex */
public interface ReportInteraction extends Plugin {

    /* renamed from: org.acra.interaction.ReportInteraction$-CC, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final /* synthetic */ class CC {
    }

    @Override // org.acra.plugins.Plugin
    /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration);

    boolean performInteraction(Context context, CoreConfiguration coreConfiguration, File file);
}
