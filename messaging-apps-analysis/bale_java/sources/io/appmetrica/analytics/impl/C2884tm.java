package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.tm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2884tm implements ProtobufConverter {
    public final Ak a;

    public C2884tm() {
        this(new Ak());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2435b6 fromModel(C2860sm c2860sm) {
        C2435b6 c2435b6 = new C2435b6();
        Integer num = c2860sm.e;
        c2435b6.e = num == null ? -1 : num.intValue();
        c2435b6.d = c2860sm.d;
        c2435b6.b = c2860sm.b;
        c2435b6.a = c2860sm.a;
        c2435b6.c = c2860sm.c;
        Ak ak = this.a;
        List list = c2860sm.f;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Ck((StackTraceElement) it.next()));
        }
        c2435b6.f = ak.fromModel(arrayList);
        return c2435b6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C2884tm(Ak ak) {
        this.a = ak;
    }

    public final C2860sm a(C2435b6 c2435b6) {
        throw new UnsupportedOperationException();
    }
}
