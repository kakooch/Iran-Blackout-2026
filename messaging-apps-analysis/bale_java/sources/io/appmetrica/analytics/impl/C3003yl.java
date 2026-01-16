package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* renamed from: io.appmetrica.analytics.impl.yl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3003yl extends L2 {
    @Override // io.appmetrica.analytics.impl.L2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C2979xl defaultValue() {
        C2979xl c2979xl = new C2979xl();
        c2979xl.i = new C2859sl();
        return c2979xl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2979xl toState(byte[] bArr) {
        return (C2979xl) MessageNano.mergeFrom(new C2979xl(), bArr);
    }
}
