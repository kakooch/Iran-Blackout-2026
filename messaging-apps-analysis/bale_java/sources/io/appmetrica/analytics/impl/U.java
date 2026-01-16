package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class U implements ProtobufConverter {
    public final C2884tm a;

    public U(C2884tm c2884tm) {
        this.a = c2884tm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final S5 fromModel(T t) {
        S5 s5 = new S5();
        C2860sm c2860sm = t.a;
        if (c2860sm != null) {
            s5.a = this.a.fromModel(c2860sm);
        }
        s5.b = new C2435b6[t.b.size()];
        Iterator it = t.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            s5.b[i] = this.a.fromModel((C2860sm) it.next());
            i++;
        }
        String str = t.c;
        if (str != null) {
            s5.c = str;
        }
        return s5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final T a(S5 s5) {
        throw new UnsupportedOperationException();
    }
}
