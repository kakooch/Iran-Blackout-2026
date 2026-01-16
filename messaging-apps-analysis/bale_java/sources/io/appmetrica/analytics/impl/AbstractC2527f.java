package io.appmetrica.analytics.impl;

import android.content.Context;

/* renamed from: io.appmetrica.analytics.impl.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2527f implements InterfaceC2795q4 {
    public final Context a;
    public final Qf b;

    public AbstractC2527f(Context context, Qf qf) {
        this.a = context.getApplicationContext();
        this.b = qf;
        qf.a(this);
        C2586ha.h().k().b(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2795q4
    public final void a(Q5 q5, A4 a4) {
        b(q5, a4);
    }

    public final Qf b() {
        return this.b;
    }

    public abstract void b(Q5 q5, A4 a4);

    public final Context c() {
        return this.a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2795q4
    public final void a() {
        this.b.b(this);
        C2586ha.C.j().a(this);
    }
}
