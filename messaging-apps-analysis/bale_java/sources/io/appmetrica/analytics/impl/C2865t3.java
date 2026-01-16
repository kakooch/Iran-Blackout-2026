package io.appmetrica.analytics.impl;

import android.util.Base64;

/* renamed from: io.appmetrica.analytics.impl.t3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2865t3 implements pn {
    public final A8 a;

    public C2865t3() {
        this(new A8());
    }

    @Override // io.appmetrica.analytics.impl.pn
    public final byte[] a(G8 g8, Cg cg) {
        byte[] bArrDecode = new byte[0];
        String str = g8.b;
        if (str != null) {
            try {
                bArrDecode = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        A8 a8 = this.a;
        return ((InterfaceC3014z8) a8.a.a(g8.o)).a(bArrDecode);
    }

    public C2865t3(A8 a8) {
        this.a = a8;
    }
}
