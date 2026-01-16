package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;

/* loaded from: classes3.dex */
public final class Vb {
    public int a = 5;
    public final C2503e b;

    public Vb(C2516ec c2516ec, Oa oa) {
        this.b = new C2503e(new C2921vb(c2516ec, oa));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C2503e c2503e = this.b;
        c2503e.a.add(new InterfaceC2453c() { // from class: ir.nasim.MQ7
            @Override // io.appmetrica.analytics.impl.InterfaceC2453c
            public final void onAppNotResponding() {
                io.appmetrica.analytics.impl.Vb.b(anrListener);
            }
        });
    }
}
