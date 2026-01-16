package com.google.protobuf;

import ir.nasim.KW4;

/* renamed from: com.google.protobuf.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2378b implements KW4 {
    private static final C2394s a = C2394s.b();

    private P b(P p) throws InvalidProtocolBufferException {
        if (p == null || p.isInitialized()) {
            return p;
        }
        throw c(p).a().m(p);
    }

    private UninitializedMessageException c(P p) {
        return p instanceof AbstractC2377a ? ((AbstractC2377a) p).newUninitializedMessageException() : new UninitializedMessageException(p);
    }

    @Override // ir.nasim.KW4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public P a(byte[] bArr) {
        return f(bArr, a);
    }

    public P e(byte[] bArr, int i, int i2, C2394s c2394s) {
        return b(g(bArr, i, i2, c2394s));
    }

    public P f(byte[] bArr, C2394s c2394s) {
        return e(bArr, 0, bArr.length, c2394s);
    }

    public abstract P g(byte[] bArr, int i, int i2, C2394s c2394s);
}
