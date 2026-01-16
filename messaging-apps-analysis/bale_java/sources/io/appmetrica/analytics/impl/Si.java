package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;

/* loaded from: classes3.dex */
public final class Si implements Ka {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public Si(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.getPluginExtension().reportError(this.a, this.b, this.c);
    }
}
