package org.acra.config;

import android.content.Context;
import org.acra.plugins.Plugin;

/* loaded from: classes.dex */
public interface ConfigurationBuilderFactory extends Plugin {

    /* renamed from: org.acra.config.ConfigurationBuilderFactory$-CC, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final /* synthetic */ class CC {
    }

    ConfigurationBuilder create(Context context);

    @Override // org.acra.plugins.Plugin
    /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration);
}
