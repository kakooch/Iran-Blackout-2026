package io.appmetrica.analytics.impl;

import android.content.Context;

/* renamed from: io.appmetrica.analytics.impl.xi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2976xi implements InterfaceC2818r4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC2818r4
    public abstract /* synthetic */ InterfaceC2795q4 a(Context context, C2628j5 c2628j5, C2508e4 c2508e4, A4 a4);

    public final InterfaceC2795q4 a(W4 w4, C2628j5 c2628j5) {
        Qf qf;
        synchronized (c2628j5) {
            qf = (Qf) c2628j5.a.get(w4.toString());
        }
        return new C2952wi(qf);
    }
}
