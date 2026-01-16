package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class Bm implements ProtobufConverter {
    public final Ak a;

    public Bm() {
        this(new Ak());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2460c6 fromModel(Cm cm) {
        C2460c6 c2460c6 = new C2460c6();
        c2460c6.a = (String) WrapUtils.getOrDefault(cm.a, "");
        c2460c6.b = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(cm.b, ""));
        List<Ck> list = cm.c;
        if (list != null) {
            c2460c6.c = this.a.fromModel(list);
        }
        Cm cm2 = cm.d;
        if (cm2 != null) {
            c2460c6.d = fromModel(cm2);
        }
        List list2 = cm.e;
        int i = 0;
        if (list2 == null) {
            c2460c6.e = new C2460c6[0];
        } else {
            c2460c6.e = new C2460c6[list2.size()];
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                c2460c6.e[i] = fromModel((Cm) it.next());
                i++;
            }
        }
        return c2460c6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Bm(Ak ak) {
        this.a = ak;
    }

    public final Cm a(C2460c6 c2460c6) {
        throw new UnsupportedOperationException();
    }
}
