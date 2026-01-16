package io.appmetrica.analytics.impl;

import android.content.Context;

/* loaded from: classes3.dex */
public final class Qb implements InterfaceC2818r4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC2818r4
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final F4 a(Context context, C2628j5 c2628j5, C2508e4 c2508e4, A4 a4) {
        I4 i4;
        G4 g4 = new G4(c2508e4.b);
        J4 j4 = new J4();
        synchronized (c2628j5) {
            i4 = (I4) c2628j5.a(g4, a4, j4, c2628j5.b);
        }
        return new F4(context, i4, a4);
    }
}
