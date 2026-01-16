package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;

/* renamed from: io.appmetrica.analytics.impl.ae, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2418ae implements Runnable {
    public final /* synthetic */ PluginErrorDetails a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C2468ce c;

    public RunnableC2418ae(C2468ce c2468ce, PluginErrorDetails pluginErrorDetails, String str) {
        this.c = c2468ce;
        this.a = pluginErrorDetails;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((La) this.c.d.get()).getPluginExtension().reportError(this.a, this.b);
    }
}
