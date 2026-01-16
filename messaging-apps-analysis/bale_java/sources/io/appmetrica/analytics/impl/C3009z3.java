package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.z3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3009z3 implements W7 {
    public final A3 a;

    public C3009z3() {
        this(new A3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final List<Rh> fromModel(C2985y3 c2985y3) {
        C2775p8 c2775p8 = new C2775p8();
        c2775p8.e = new Y7();
        Rh rhFromModel = this.a.fromModel(c2985y3.b);
        c2775p8.e.a = (Z7) rhFromModel.a;
        c2775p8.a = c2985y3.a;
        return Collections.singletonList(new Rh(c2775p8, new C2817r3(C2817r3.b(rhFromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C3009z3(A3 a3) {
        this.a = a3;
    }

    public final C2985y3 a(List<Rh> list) {
        throw new UnsupportedOperationException();
    }
}
