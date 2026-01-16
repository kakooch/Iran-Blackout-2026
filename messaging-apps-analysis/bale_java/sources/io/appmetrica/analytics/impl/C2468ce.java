package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;

/* renamed from: io.appmetrica.analytics.impl.ce, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2468ce implements IPluginReporter {
    public final C2542fe a = new C2542fe();
    public final C2566ge b = new C2566ge();
    public final IHandlerExecutor c = C2747o4.g().d().a();
    public final Provider d;

    public C2468ce(Provider<La> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C2542fe c2542fe = this.a;
        c2542fe.a.a(pluginErrorDetails);
        if (c2542fe.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).a) {
            this.b.getClass();
            this.c.execute(new RunnableC2418ae(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.a.a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new Zd(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.a.b.a(str);
        this.b.getClass();
        this.c.execute(new RunnableC2443be(this, str, str2, pluginErrorDetails));
    }
}
