package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;

/* loaded from: classes3.dex */
public final class Ri implements Ka {
    public final /* synthetic */ PluginErrorDetails a;
    public final /* synthetic */ String b;

    public Ri(PluginErrorDetails pluginErrorDetails, String str) {
        this.a = pluginErrorDetails;
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.getPluginExtension().reportError(this.a, this.b);
    }
}
