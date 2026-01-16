package io.appmetrica.analytics.impl;

import android.content.Context;

/* loaded from: classes3.dex */
public final class Yb implements InterfaceC2818r4, InterfaceC2509e5 {
    @Override // io.appmetrica.analytics.impl.InterfaceC2818r4
    public final InterfaceC2795q4 a(Context context, C2628j5 c2628j5, C2508e4 c2508e4, A4 a4) {
        Qf qf;
        C2416ac c2416ac = new C2416ac(c2508e4.b, c2508e4.a);
        Rf rf = new Rf(this);
        synchronized (c2628j5) {
            qf = (Qf) c2628j5.a(c2416ac, a4, rf, c2628j5.a);
        }
        return new Zb(context, qf);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2509e5
    public final Ja a(Context context, W4 w4, C3010z4 c3010z4, Bl bl) {
        return new C2466cc(context, bl.e(), w4, c3010z4, C2586ha.C.r(), C2586ha.C.f(), new Uf(bl));
    }
}
