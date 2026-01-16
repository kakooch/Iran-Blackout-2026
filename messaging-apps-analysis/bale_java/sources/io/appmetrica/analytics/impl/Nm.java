package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.List;

/* loaded from: classes3.dex */
public final class Nm implements ProtobufConverter {
    public final Bm a;
    public final U b;
    public final C2582h6 c;
    public final Ak d;
    public final Wd e;
    public final Xd f;

    public Nm() {
        this(new Bm(), new U(new C2884tm()), new C2582h6(), new Ak(), new Wd(), new Xd());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final W5 fromModel(Mm mm) {
        W5 w5 = new W5();
        Cm cm = mm.a;
        if (cm != null) {
            w5.a = this.a.fromModel(cm);
        }
        T t = mm.b;
        if (t != null) {
            w5.b = this.b.fromModel(t);
        }
        List<Ck> list = mm.c;
        if (list != null) {
            w5.e = this.d.fromModel(list);
        }
        String str = mm.g;
        if (str != null) {
            w5.c = str;
        }
        w5.d = this.c.a(mm.h);
        if (!TextUtils.isEmpty(mm.d)) {
            w5.h = this.e.fromModel(mm.d);
        }
        if (!TextUtils.isEmpty(mm.e)) {
            w5.i = mm.e.getBytes();
        }
        if (!hn.a(mm.f)) {
            w5.j = this.f.fromModel(mm.f);
        }
        return w5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Nm(Bm bm, U u, C2582h6 c2582h6, Ak ak, Wd wd, Xd xd) {
        this.b = u;
        this.a = bm;
        this.c = c2582h6;
        this.d = ak;
        this.e = wd;
        this.f = xd;
    }

    public final Mm a(W5 w5) {
        throw new UnsupportedOperationException();
    }
}
