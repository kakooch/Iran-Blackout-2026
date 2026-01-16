package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* renamed from: io.appmetrica.analytics.impl.db, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2490db implements Converter {
    public final C2898uc a;

    public C2490db() {
        this(new C2898uc(new Nm()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final byte[] fromModel(Mm mm) {
        return MessageNano.toByteArray((MessageNano) this.a.a.fromModel(mm));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C2490db(C2898uc c2898uc) {
        this.a = c2898uc;
    }

    public final Mm a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
