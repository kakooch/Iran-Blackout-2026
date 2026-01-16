package io.appmetrica.analytics.impl;

import android.content.Context;

/* loaded from: classes3.dex */
public final class Qf implements Pk, Aa {
    public final Context a;
    public final W4 b;
    public final X4 c;
    public final Bl d;
    public final Ja e;

    public Qf(Context context, W4 w4, A4 a4, InterfaceC2509e5 interfaceC2509e5, X4 x4, Gk gk) {
        this.a = context;
        this.b = w4;
        this.c = x4;
        Bl blA = gk.a(context, w4, a4.a);
        this.d = blA;
        this.e = interfaceC2509e5.a(context, w4, a4.b, blA);
        gk.a(w4, this);
    }

    public final W4 a() {
        return this.b;
    }

    public final Context b() {
        return this.a;
    }

    public final void a(InterfaceC2795q4 interfaceC2795q4) {
        this.c.a.add(interfaceC2795q4);
    }

    public final void b(InterfaceC2795q4 interfaceC2795q4) {
        this.c.a.remove(interfaceC2795q4);
    }

    @Override // io.appmetrica.analytics.impl.Pk
    public final void a(C2549fl c2549fl) {
        this.e.a(c2549fl);
    }

    @Override // io.appmetrica.analytics.impl.Pk
    public final void a(Ik ik, C2549fl c2549fl) {
        ((C2484d5) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.Aa
    public final void a(A4 a4) {
        this.d.a(a4.a);
        this.e.a(a4.b);
    }

    public Qf(Context context, W4 w4, A4 a4, InterfaceC2509e5 interfaceC2509e5) {
        this(context, w4, a4, interfaceC2509e5, new X4(), Gk.a());
    }

    public final void a(Q5 q5, A4 a4) {
        if (!AbstractC2776p9.c.contains(Ta.a(q5.d))) {
            this.e.a(a4.b);
        }
        ((C2484d5) this.e).a(q5);
    }
}
