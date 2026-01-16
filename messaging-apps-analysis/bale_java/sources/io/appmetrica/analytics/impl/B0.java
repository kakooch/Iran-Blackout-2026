package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import ir.nasim.AbstractC13042fc3;
import java.util.Collection;

/* loaded from: classes3.dex */
public final class B0 {
    public final IHandlerExecutor a = C2747o4.g().d().a();
    public final C2743o0 b;
    public final C2518ee c;
    public final C2590he d;

    public B0() {
        C2743o0 c2743o0 = new C2743o0();
        this.b = c2743o0;
        this.c = new C2518ee(c2743o0);
        this.d = new C2590he();
    }

    public final void a(final PluginErrorDetails pluginErrorDetails) {
        C2518ee c2518ee = this.c;
        c2518ee.a.a(null);
        c2518ee.b.a(pluginErrorDetails);
        C2590he c2590he = this.d;
        AbstractC13042fc3.f(pluginErrorDetails);
        c2590he.getClass();
        this.a.execute(new Runnable() { // from class: ir.nasim.JV
            @Override // java.lang.Runnable
            public final void run() {
                io.appmetrica.analytics.impl.B0.a(this.a, pluginErrorDetails);
            }
        });
    }

    public final void a(final PluginErrorDetails pluginErrorDetails, final String str) {
        C2518ee c2518ee = this.c;
        c2518ee.a.a(null);
        c2518ee.b.a(pluginErrorDetails);
        if (c2518ee.d.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).a) {
            C2590he c2590he = this.d;
            AbstractC13042fc3.f(pluginErrorDetails);
            c2590he.getClass();
            this.a.execute(new Runnable() { // from class: ir.nasim.IV
                @Override // java.lang.Runnable
                public final void run() {
                    io.appmetrica.analytics.impl.B0.a(this.a, pluginErrorDetails, str);
                }
            });
        }
    }

    public final void a(final String str, final String str2, final PluginErrorDetails pluginErrorDetails) {
        C2518ee c2518ee = this.c;
        c2518ee.a.a(null);
        c2518ee.c.a(str);
        C2590he c2590he = this.d;
        AbstractC13042fc3.f(str);
        c2590he.getClass();
        this.a.execute(new Runnable() { // from class: ir.nasim.HV
            @Override // java.lang.Runnable
            public final void run() {
                io.appmetrica.analytics.impl.B0.a(this.a, str, str2, pluginErrorDetails);
            }
        });
    }

    public static final void a(B0 b0, PluginErrorDetails pluginErrorDetails, String str) {
        b0.b.getClass();
        C2719n0 c2719n0 = C2719n0.e;
        AbstractC13042fc3.f(c2719n0);
        Wb wbI = c2719n0.j().i();
        AbstractC13042fc3.f(wbI);
        wbI.a.getPluginExtension().reportError(pluginErrorDetails, str);
    }

    public static final void a(B0 b0, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        b0.b.getClass();
        C2719n0 c2719n0 = C2719n0.e;
        AbstractC13042fc3.f(c2719n0);
        Wb wbI = c2719n0.j().i();
        AbstractC13042fc3.f(wbI);
        wbI.a.getPluginExtension().reportError(str, str2, pluginErrorDetails);
    }

    public static final void a(B0 b0, PluginErrorDetails pluginErrorDetails) {
        b0.b.getClass();
        C2719n0 c2719n0 = C2719n0.e;
        AbstractC13042fc3.f(c2719n0);
        Wb wbI = c2719n0.j().i();
        AbstractC13042fc3.f(wbI);
        wbI.a.getPluginExtension().reportUnhandledException(pluginErrorDetails);
    }
}
