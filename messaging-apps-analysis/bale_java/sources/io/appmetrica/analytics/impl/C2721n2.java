package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;

/* renamed from: io.appmetrica.analytics.impl.n2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2721n2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2740nl fromModel(C2697m2 c2697m2) {
        C2692ll c2692ll;
        C2740nl c2740nl = new C2740nl();
        c2740nl.a = new C2716ml[c2697m2.a.size()];
        for (int i = 0; i < c2697m2.a.size(); i++) {
            C2716ml c2716ml = new C2716ml();
            Pair pair = (Pair) c2697m2.a.get(i);
            c2716ml.a = (String) pair.first;
            if (pair.second != null) {
                c2716ml.b = new C2692ll();
                C2673l2 c2673l2 = (C2673l2) pair.second;
                if (c2673l2 == null) {
                    c2692ll = null;
                } else {
                    C2692ll c2692ll2 = new C2692ll();
                    c2692ll2.a = c2673l2.a;
                    c2692ll = c2692ll2;
                }
                c2716ml.b = c2692ll;
            }
            c2740nl.a[i] = c2716ml;
        }
        return c2740nl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2697m2 toModel(C2740nl c2740nl) {
        ArrayList arrayList = new ArrayList();
        for (C2716ml c2716ml : c2740nl.a) {
            String str = c2716ml.a;
            C2692ll c2692ll = c2716ml.b;
            arrayList.add(new Pair(str, c2692ll == null ? null : new C2673l2(c2692ll.a)));
        }
        return new C2697m2(arrayList);
    }
}
