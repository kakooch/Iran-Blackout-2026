package io.appmetrica.analytics.impl;

import android.content.Context;

/* loaded from: classes3.dex */
public final class Rf implements I7 {
    public final InterfaceC2509e5 a;

    public Rf(InterfaceC2509e5 interfaceC2509e5) {
        this.a = interfaceC2509e5;
    }

    @Override // io.appmetrica.analytics.impl.I7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Qf a(Context context, W4 w4, A4 a4) {
        return new Qf(context, w4, a4, this.a, new X4(), Gk.a());
    }

    public final InterfaceC2509e5 a() {
        return this.a;
    }
}
