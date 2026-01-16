package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC4616Fw7;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.dd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2492dd implements ProtobufConverter {
    public static final C2467cd a = new C2467cd();
    public static final Map b = AbstractC20051rO3.n(AbstractC4616Fw7.a(NativeCrashSource.UNKNOWN, 0), AbstractC4616Fw7.a(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final W5 fromModel(C2565gd c2565gd) {
        W5 w5 = new W5();
        w5.f = 1;
        V5 v5 = new V5();
        v5.a = c2565gd.a;
        Z5 z5 = new Z5();
        Integer num = (Integer) b.get(c2565gd.b.a);
        if (num != null) {
            z5.a = num.intValue();
        }
        String str = c2565gd.b.b;
        if (str == null) {
            str = "";
        }
        z5.b = str;
        v5.b = z5;
        w5.g = v5;
        return w5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final C2565gd a(W5 w5) {
        throw new UnsupportedOperationException();
    }
}
