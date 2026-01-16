package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public final class Ke implements Converter {
    public final V a;
    public final Le b;

    public Ke() {
        this(new V(), new Le(30));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Rh fromModel(Me me2) {
        int bytesTruncated;
        C2584h8 c2584h8 = new C2584h8();
        Rh rhFromModel = this.a.fromModel(me2.a);
        c2584h8.a = (X7) rhFromModel.a;
        Im imA = this.b.a(me2.b);
        if (hn.a((Collection) imA.a)) {
            bytesTruncated = 0;
        } else {
            c2584h8.b = new X7[((List) imA.a).size()];
            bytesTruncated = 0;
            for (int i = 0; i < ((List) imA.a).size(); i++) {
                Rh rhFromModel2 = this.a.fromModel((W) ((List) imA.a).get(i));
                c2584h8.b[i] = (X7) rhFromModel2.a;
                bytesTruncated += rhFromModel2.b.getBytesTruncated();
            }
        }
        return new Rh(c2584h8, new C2817r3(C2817r3.b(rhFromModel, imA, new C2817r3(bytesTruncated))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Ke(V v, Le le) {
        this.a = v;
        this.b = le;
    }

    public final Me a(Rh rh) {
        throw new UnsupportedOperationException();
    }
}
