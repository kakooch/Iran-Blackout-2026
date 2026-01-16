package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.fk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2548fk implements W7 {
    public final C2713mi a;

    public C2548fk() {
        this(new C2713mi());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final List<Rh> fromModel(C2524ek c2524ek) {
        C2775p8 c2775p8 = new C2775p8();
        c2775p8.a = 1;
        c2775p8.b = new C2751o8();
        Rh rhFromModel = this.a.fromModel(c2524ek.a);
        c2775p8.b.a = (C2679l8) rhFromModel.a;
        C2817r3 c2817r3 = new C2817r3(C2817r3.b(rhFromModel));
        rhFromModel.b.getBytesTruncated();
        return Collections.singletonList(new Rh(c2775p8, c2817r3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C2548fk(C2713mi c2713mi) {
        this.a = c2713mi;
    }

    public final C2524ek a(List<Rh> list) {
        throw new UnsupportedOperationException();
    }
}
