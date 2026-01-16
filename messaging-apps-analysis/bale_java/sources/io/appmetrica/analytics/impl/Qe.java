package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Qe implements Converter {
    public final Jd a;
    public final Ke b;
    public final C3 c;
    public final Ue d;
    public final C2705ma e;
    public final C2705ma f;

    public Qe() {
        this(new Jd(), new Ke(), new C3(), new Ue(), new C2705ma(100), new C2705ma(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Rh fromModel(Te te) {
        Rh rhFromModel;
        Rh rhFromModel2;
        Rh rhA;
        Rh rhA2;
        C2608i8 c2608i8 = new C2608i8();
        Im imA = this.e.a(te.a);
        c2608i8.a = StringUtils.getUTF8Bytes((String) imA.a);
        Im imA2 = this.f.a(te.b);
        c2608i8.b = StringUtils.getUTF8Bytes((String) imA2.a);
        List<String> list = te.c;
        Rh rhFromModel3 = null;
        if (list != null) {
            rhFromModel = this.c.fromModel(list);
            c2608i8.c = (C2412a8) rhFromModel.a;
        } else {
            rhFromModel = null;
        }
        Map<String, String> map = te.d;
        if (map != null) {
            rhFromModel2 = this.a.fromModel(map);
            c2608i8.d = (C2560g8) rhFromModel2.a;
        } else {
            rhFromModel2 = null;
        }
        Me me2 = te.e;
        if (me2 != null) {
            rhA = this.b.fromModel(me2);
            c2608i8.e = (C2584h8) rhA.a;
        } else {
            rhA = null;
        }
        Me me3 = te.f;
        if (me3 != null) {
            rhA2 = this.b.fromModel(me3);
            c2608i8.f = (C2584h8) rhA2.a;
        } else {
            rhA2 = null;
        }
        List<String> list2 = te.g;
        if (list2 != null) {
            rhFromModel3 = this.d.fromModel(list2);
            c2608i8.g = (C2631j8[]) rhFromModel3.a;
        }
        return new Rh(c2608i8, new C2817r3(C2817r3.b(imA, imA2, rhFromModel, rhFromModel2, rhA, rhA2, rhFromModel3)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Qe(Jd jd, Ke ke, C3 c3, Ue ue, C2705ma c2705ma, C2705ma c2705ma2) {
        this.a = jd;
        this.b = ke;
        this.c = c3;
        this.d = ue;
        this.e = c2705ma;
        this.f = c2705ma2;
    }

    public final Te a(Rh rh) {
        throw new UnsupportedOperationException();
    }
}
