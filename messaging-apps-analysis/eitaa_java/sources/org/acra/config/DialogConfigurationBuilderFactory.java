package org.acra.config;

import android.content.Context;
import org.acra.plugins.Plugin;

/* loaded from: classes.dex */
public class DialogConfigurationBuilderFactory implements ConfigurationBuilderFactory {
    @Override // org.acra.config.ConfigurationBuilderFactory, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    @Override // org.acra.config.ConfigurationBuilderFactory
    public ConfigurationBuilder create(Context context) {
        return new DialogConfigurationBuilderImpl(context);
    }
}
