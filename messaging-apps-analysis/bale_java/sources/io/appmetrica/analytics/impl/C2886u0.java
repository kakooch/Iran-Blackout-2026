package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.impl.C2886u0;

/* renamed from: io.appmetrica.analytics.impl.u0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2886u0 {
    public final C2743o0 a;
    public final C2849sb b;
    public final C2873tb c;
    public final C2945wb d;
    public final IHandlerExecutor e;

    public C2886u0() {
        C2743o0 c2743o0B = C2747o4.g().b();
        this.a = c2743o0B;
        this.b = new C2849sb(c2743o0B);
        this.c = new C2873tb(c2743o0B);
        this.d = new C2945wb();
        this.e = C2747o4.g().d().a();
    }

    public final void a(Context context) {
        this.b.a.a(context);
        final Context applicationContext = context.getApplicationContext();
        C2873tb c2873tb = this.c;
        c2873tb.b.a(applicationContext);
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Session autotracking enabled", new Object[0]);
        C2747o4.g().f.a();
        c2873tb.a.getClass();
        C2719n0 c2719n0A = C2719n0.a(applicationContext, true);
        c2719n0A.d.a(null, c2719n0A);
        this.e.execute(new Runnable() { // from class: ir.nasim.De8
            @Override // java.lang.Runnable
            public final void run() {
                C2886u0.a(this.a, applicationContext);
            }
        });
        this.a.getClass();
        synchronized (C2719n0.class) {
            C2719n0.f = true;
        }
    }

    public static final void a(C2886u0 c2886u0, Context context) {
        c2886u0.a.getClass();
        C2719n0.a(context, false).j().d();
    }
}
