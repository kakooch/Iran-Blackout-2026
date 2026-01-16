package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;

/* loaded from: classes3.dex */
public final class Lm implements pn {
    public final A8 a;

    public Lm() {
        this(new A8());
    }

    @Override // io.appmetrica.analytics.impl.pn
    public final byte[] a(G8 g8, Cg cg) {
        byte[] bArrDecompressBase64GzipAsBytes = new byte[0];
        try {
            bArrDecompressBase64GzipAsBytes = Base64Utils.decompressBase64GzipAsBytes(g8.b);
        } catch (Throwable unused) {
        }
        byte[] bArrA = ((InterfaceC3014z8) this.a.a.a(g8.o)).a(bArrDecompressBase64GzipAsBytes);
        return bArrA == null ? new byte[0] : bArrA;
    }

    public Lm(A8 a8) {
        this.a = a8;
    }

    public final A8 a() {
        return this.a;
    }
}
