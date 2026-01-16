package io.appmetrica.analytics.impl;

import android.content.Context;

/* loaded from: classes3.dex */
public class Ug implements InterfaceC2818r4, InterfaceC2509e5 {
    @Override // io.appmetrica.analytics.impl.InterfaceC2509e5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C2484d5 a(Context context, W4 w4, C3010z4 c3010z4, Bl bl) {
        return new Vg(context, w4, c3010z4, C2586ha.C.f(), bl.e(), new Uf(bl));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2818r4
    public final InterfaceC2795q4 a(Context context, C2628j5 c2628j5, C2508e4 c2508e4, A4 a4) {
        Qf qf;
        W4 w4 = new W4(c2508e4.b, c2508e4.a);
        Rf rf = new Rf(this);
        synchronized (c2628j5) {
            qf = (Qf) c2628j5.a(w4, a4, rf, c2628j5.a);
        }
        return new Pf(context, qf);
    }
}
