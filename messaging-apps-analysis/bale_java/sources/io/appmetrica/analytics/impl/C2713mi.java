package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.mi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2713mi implements Converter {
    public final Jd a;
    public final C3 b;
    public final C2705ma c;
    public final C2705ma d;

    public C2713mi() {
        this(new Jd(), new C3(), new C2705ma(100), new C2705ma(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Rh fromModel(C2809qi c2809qi) {
        Rh rhFromModel;
        C2679l8 c2679l8 = new C2679l8();
        Im imA = this.c.a(c2809qi.a);
        c2679l8.a = StringUtils.getUTF8Bytes((String) imA.a);
        List<String> list = c2809qi.b;
        Rh rhA = null;
        if (list != null) {
            rhFromModel = this.b.fromModel(list);
            c2679l8.b = (C2412a8) rhFromModel.a;
        } else {
            rhFromModel = null;
        }
        Im imA2 = this.d.a(c2809qi.c);
        c2679l8.c = StringUtils.getUTF8Bytes((String) imA2.a);
        Map<String, String> map = c2809qi.d;
        if (map != null) {
            rhA = this.a.fromModel(map);
            c2679l8.d = (C2560g8) rhA.a;
        }
        return new Rh(c2679l8, new C2817r3(C2817r3.b(imA, rhFromModel, imA2, rhA)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C2713mi(Jd jd, C3 c3, C2705ma c2705ma, C2705ma c2705ma2) {
        this.a = jd;
        this.b = c3;
        this.c = c2705ma;
        this.d = c2705ma2;
    }

    public final C2809qi a(Rh rh) {
        throw new UnsupportedOperationException();
    }
}
