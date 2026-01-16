package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;

/* loaded from: classes3.dex */
public final class Qi implements Ka {
    public final /* synthetic */ PluginErrorDetails a;

    public Qi(PluginErrorDetails pluginErrorDetails) {
        this.a = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.getPluginExtension().reportUnhandledException(this.a);
    }
}
