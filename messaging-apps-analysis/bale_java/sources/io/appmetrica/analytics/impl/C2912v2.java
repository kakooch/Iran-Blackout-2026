package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* renamed from: io.appmetrica.analytics.impl.v2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2912v2 extends L2 {
    @Override // io.appmetrica.analytics.impl.L2
    /* renamed from: a */
    public final MessageNano defaultValue() {
        return new C2888u2();
    }

    public final C2888u2 b() {
        return new C2888u2();
    }

    @Override // io.appmetrica.analytics.impl.L2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new C2888u2();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2888u2 toState(byte[] bArr) {
        return (C2888u2) MessageNano.mergeFrom(new C2888u2(), bArr);
    }
}
