package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.bk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2449bk implements W7 {
    public final C2713mi a;
    public final Qe b;

    public C2449bk() {
        this(new C2713mi(), new Qe());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final List<Rh> fromModel(C2424ak c2424ak) {
        C2775p8 c2775p8 = new C2775p8();
        c2775p8.a = 2;
        c2775p8.c = new C2703m8();
        Rh rhFromModel = this.a.fromModel(c2424ak.b);
        c2775p8.c.b = (C2679l8) rhFromModel.a;
        Rh rhFromModel2 = this.b.fromModel(c2424ak.a);
        c2775p8.c.a = (C2608i8) rhFromModel2.a;
        return Collections.singletonList(new Rh(c2775p8, new C2817r3(C2817r3.b(rhFromModel, rhFromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C2449bk(C2713mi c2713mi, Qe qe) {
        this.a = c2713mi;
        this.b = qe;
    }

    public final C2424ak a(List<Rh> list) {
        throw new UnsupportedOperationException();
    }
}
