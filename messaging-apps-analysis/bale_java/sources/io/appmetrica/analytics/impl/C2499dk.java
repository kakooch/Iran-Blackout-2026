package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.dk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2499dk implements W7 {
    public final Qe a;
    public final C2877tf b;

    public C2499dk() {
        this(new Qe(), new C2877tf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final List<Rh> fromModel(C2474ck c2474ck) {
        Rh rhFromModel;
        C2775p8 c2775p8 = new C2775p8();
        c2775p8.a = 3;
        c2775p8.d = new C2727n8();
        Rh rhFromModel2 = this.a.fromModel(c2474ck.a);
        c2775p8.d.a = (C2608i8) rhFromModel2.a;
        Mf mf = c2474ck.b;
        if (mf != null) {
            rhFromModel = this.b.fromModel(mf);
            c2775p8.d.b = (C2655k8) rhFromModel.a;
        } else {
            rhFromModel = null;
        }
        return Collections.singletonList(new Rh(c2775p8, new C2817r3(C2817r3.b(rhFromModel2, rhFromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C2499dk(Qe qe, C2877tf c2877tf) {
        this.a = qe;
        this.b = c2877tf;
    }

    public final C2474ck a(List<Rh> list) {
        throw new UnsupportedOperationException();
    }
}
