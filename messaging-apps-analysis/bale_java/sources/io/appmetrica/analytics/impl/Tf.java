package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;

/* loaded from: classes3.dex */
public final class Tf implements ProtobufConverter {
    public final Bm a;
    public final U b;
    public final C2582h6 c;
    public final Ak d;
    public final Wd e;
    public final Xd f;

    public Tf() {
        this(new Bm(), new U(new C2884tm()), new C2582h6(), new Ak(), new Wd(), new Xd());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Y5 fromModel(Sf sf) {
        Y5 y5 = new Y5();
        y5.f = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(sf.a, y5.f));
        Mm mm = sf.b;
        if (mm != null) {
            Cm cm = mm.a;
            if (cm != null) {
                y5.a = this.a.fromModel(cm);
            }
            T t = mm.b;
            if (t != null) {
                y5.b = this.b.fromModel(t);
            }
            List<Ck> list = mm.c;
            if (list != null) {
                y5.e = this.d.fromModel(list);
            }
            y5.c = (String) WrapUtils.getOrDefault(mm.g, y5.c);
            y5.d = this.c.a(mm.h);
            if (!TextUtils.isEmpty(mm.d)) {
                y5.i = this.e.fromModel(mm.d);
            }
            if (!TextUtils.isEmpty(mm.e)) {
                y5.j = mm.e.getBytes();
            }
            if (!hn.a(mm.f)) {
                y5.k = this.f.fromModel(mm.f);
            }
        }
        return y5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Tf(Bm bm, U u, C2582h6 c2582h6, Ak ak, Wd wd, Xd xd) {
        this.a = bm;
        this.b = u;
        this.c = c2582h6;
        this.d = ak;
        this.e = wd;
        this.f = xd;
    }

    public final Sf a(Y5 y5) {
        throw new UnsupportedOperationException();
    }
}
