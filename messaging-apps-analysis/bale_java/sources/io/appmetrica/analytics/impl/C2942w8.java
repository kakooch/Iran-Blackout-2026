package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* renamed from: io.appmetrica.analytics.impl.w8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2942w8 implements pn {
    public final A8 a;

    public C2942w8() {
        this(new A8());
    }

    @Override // io.appmetrica.analytics.impl.pn
    public final byte[] a(G8 g8, Cg cg) {
        String str = g8.b;
        return ((InterfaceC3014z8) this.a.a.a(g8.o)).a(str != null ? StringUtils.getUTF8Bytes(str) : new byte[0]);
    }

    public C2942w8(A8 a8) {
        this.a = a8;
    }
}
