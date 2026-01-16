package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;

/* loaded from: classes3.dex */
public final class Zd implements Runnable {
    public final /* synthetic */ PluginErrorDetails a;
    public final /* synthetic */ C2468ce b;

    public Zd(C2468ce c2468ce, PluginErrorDetails pluginErrorDetails) {
        this.b = c2468ce;
        this.a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((La) this.b.d.get()).getPluginExtension().reportUnhandledException(this.a);
    }
}
