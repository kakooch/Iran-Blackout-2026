package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* loaded from: classes3.dex */
public final class Z1 extends L2 {
    @Override // io.appmetrica.analytics.impl.L2
    /* renamed from: a */
    public final MessageNano defaultValue() {
        return new Y1();
    }

    public final Y1 b() {
        return new Y1();
    }

    @Override // io.appmetrica.analytics.impl.L2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new Y1();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Y1 toState(byte[] bArr) {
        return (Y1) MessageNano.mergeFrom(new Y1(), bArr);
    }
}
