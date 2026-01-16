package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;

/* renamed from: io.appmetrica.analytics.impl.be, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2443be implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;
    public final /* synthetic */ C2468ce d;

    public RunnableC2443be(C2468ce c2468ce, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.d = c2468ce;
        this.a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((La) this.d.d.get()).getPluginExtension().reportError(this.a, this.b, this.c);
    }
}
