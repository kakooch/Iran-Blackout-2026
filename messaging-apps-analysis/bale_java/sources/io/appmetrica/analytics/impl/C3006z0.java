package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.AppMetricaPlugins;
import io.appmetrica.analytics.plugins.PluginErrorDetails;

/* renamed from: io.appmetrica.analytics.impl.z0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3006z0 implements AppMetricaPlugins {
    public final B0 a;

    public C3006z0(B0 b0) {
        this.a = b0;
    }

    @Override // io.appmetrica.analytics.plugins.AppMetricaPlugins
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        this.a.a(pluginErrorDetails, str);
    }

    @Override // io.appmetrica.analytics.plugins.AppMetricaPlugins
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.a.a(pluginErrorDetails);
    }

    public C3006z0() {
        this(new B0());
    }

    @Override // io.appmetrica.analytics.plugins.AppMetricaPlugins
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.a.a(str, str2, pluginErrorDetails);
    }
}
