package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;

/* loaded from: classes3.dex */
public final class A3 implements Converter {
    public final Qe a;
    public final C2869t7 b;
    public final Ke c;
    public final C2877tf d;

    public A3() {
        this(new Qe(), new C2869t7(), new Ke(), new C2877tf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Rh fromModel(B3 b3) {
        Rh rhA;
        Z7 z7 = new Z7();
        Rh rhA2 = this.a.fromModel(b3.a);
        z7.a = (C2608i8) rhA2.a;
        z7.c = this.b.fromModel(b3.b);
        Rh rhA3 = this.c.fromModel(b3.c);
        z7.d = (C2584h8) rhA3.a;
        Mf mf = b3.d;
        if (mf != null) {
            rhA = this.d.fromModel(mf);
            z7.b = (C2655k8) rhA.a;
        } else {
            rhA = null;
        }
        return new Rh(z7, new C2817r3(C2817r3.b(rhA2, rhA3, rhA)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public A3(Qe qe, C2869t7 c2869t7, Ke ke, C2877tf c2877tf) {
        this.a = qe;
        this.b = c2869t7;
        this.c = ke;
        this.d = c2877tf;
    }

    public final B3 a(Rh rh) {
        throw new UnsupportedOperationException();
    }
}
