package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;

/* renamed from: io.appmetrica.analytics.impl.h7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2583h7 implements Converter {
    public final Dd a;

    /* JADX WARN: Multi-variable type inference failed */
    public C2583h7() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2678l7 fromModel(C2559g7 c2559g7) {
        C2678l7 c2678l7 = new C2678l7();
        Boolean bool = c2559g7.a;
        if (bool != null) {
            c2678l7.a = this.a.fromModel(bool).intValue();
        }
        Double d = c2559g7.c;
        if (d != null) {
            c2678l7.c = d.doubleValue();
        }
        Double d2 = c2559g7.b;
        if (d2 != null) {
            c2678l7.b = d2.doubleValue();
        }
        Long l = c2559g7.h;
        if (l != null) {
            c2678l7.h = l.longValue();
        }
        Integer num = c2559g7.f;
        if (num != null) {
            c2678l7.f = num.intValue();
        }
        Integer num2 = c2559g7.e;
        if (num2 != null) {
            c2678l7.e = num2.intValue();
        }
        Integer num3 = c2559g7.g;
        if (num3 != null) {
            c2678l7.g = num3.intValue();
        }
        Integer num4 = c2559g7.d;
        if (num4 != null) {
            c2678l7.d = num4.intValue();
        }
        String str = c2559g7.i;
        if (str != null) {
            c2678l7.i = str;
        }
        String str2 = c2559g7.j;
        if (str2 != null) {
            c2678l7.j = str2;
        }
        return c2678l7;
    }

    public C2583h7(Dd dd) {
        this.a = dd;
    }

    public /* synthetic */ C2583h7(Dd dd, int i, ED1 ed1) {
        this((i & 1) != 0 ? new Dd() : dd);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2559g7 toModel(C2678l7 c2678l7) {
        if (c2678l7 == null) {
            return new C2559g7(null, null, null, null, null, null, null, null, null, null);
        }
        C2678l7 c2678l72 = new C2678l7();
        Boolean boolA = this.a.a(c2678l7.a);
        double d = c2678l7.c;
        Double dValueOf = ((d > c2678l72.c ? 1 : (d == c2678l72.c ? 0 : -1)) == 0) ^ true ? Double.valueOf(d) : null;
        double d2 = c2678l7.b;
        Double dValueOf2 = (d2 == c2678l72.b) ^ true ? Double.valueOf(d2) : null;
        long j = c2678l7.h;
        Long lValueOf = j != c2678l72.h ? Long.valueOf(j) : null;
        int i = c2678l7.f;
        Integer numValueOf = i != c2678l72.f ? Integer.valueOf(i) : null;
        int i2 = c2678l7.e;
        Integer numValueOf2 = i2 != c2678l72.e ? Integer.valueOf(i2) : null;
        int i3 = c2678l7.g;
        Integer numValueOf3 = i3 != c2678l72.g ? Integer.valueOf(i3) : null;
        int i4 = c2678l7.d;
        Integer numValueOf4 = Integer.valueOf(i4);
        if (i4 == c2678l72.d) {
            numValueOf4 = null;
        }
        String str = c2678l7.i;
        String str2 = AbstractC13042fc3.d(str, c2678l72.i) ^ true ? str : null;
        String str3 = c2678l7.j;
        return new C2559g7(boolA, dValueOf2, dValueOf, numValueOf4, numValueOf2, numValueOf, numValueOf3, lValueOf, str2, AbstractC13042fc3.d(str3, c2678l72.j) ^ true ? str3 : null);
    }
}
