package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Jd implements Converter {
    public final C2777pa a;

    public Jd() {
        this(new C2777pa(20480, 100, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Rh fromModel(Map<String, String> map) {
        Im imA = this.a.a(map);
        C2560g8 c2560g8 = new C2560g8();
        c2560g8.b = ((C2986y4) imA.b).b;
        Map map2 = (Map) imA.a;
        if (map2 != null) {
            c2560g8.a = new C2536f8[map2.size()];
            int i = 0;
            for (Map.Entry entry : map2.entrySet()) {
                c2560g8.a[i] = new C2536f8();
                c2560g8.a[i].a = StringUtils.getUTF8Bytes((String) entry.getKey());
                c2560g8.a[i].b = StringUtils.getUTF8Bytes((String) entry.getValue());
                i++;
            }
        }
        InterfaceC2841s3 interfaceC2841s3 = imA.b;
        int i2 = ((C2986y4) interfaceC2841s3).a;
        return new Rh(c2560g8, interfaceC2841s3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Jd(C2777pa c2777pa) {
        this.a = c2777pa;
    }

    public final Map<String, String> a(Rh rh) {
        throw new UnsupportedOperationException();
    }
}
