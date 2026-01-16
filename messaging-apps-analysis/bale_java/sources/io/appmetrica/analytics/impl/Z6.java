package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class Z6 implements ProtobufConverter {
    public final Dd a;
    public final C2583h7 b;

    /* JADX WARN: Multi-variable type inference failed */
    public Z6() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2654k7 fromModel(C2436b7 c2436b7) {
        C2654k7 c2654k7 = new C2654k7();
        Integer num = c2436b7.a;
        if (num != null) {
            c2654k7.a = num.intValue();
        }
        String str = c2436b7.b;
        if (str != null) {
            c2654k7.b = str;
        }
        String str2 = c2436b7.c;
        if (str2 != null) {
            c2654k7.c = str2;
        }
        Long l = c2436b7.d;
        if (l != null) {
            c2654k7.d = l.longValue();
        }
        C2559g7 c2559g7 = c2436b7.e;
        if (c2559g7 != null) {
            c2654k7.e = this.b.fromModel(c2559g7);
        }
        String str3 = c2436b7.f;
        if (str3 != null) {
            c2654k7.f = str3;
        }
        String str4 = c2436b7.g;
        if (str4 != null) {
            c2654k7.g = str4;
        }
        Long l2 = c2436b7.h;
        if (l2 != null) {
            c2654k7.h = l2.longValue();
        }
        Integer num2 = c2436b7.i;
        if (num2 != null) {
            c2654k7.i = num2.intValue();
        }
        Integer num3 = c2436b7.j;
        if (num3 != null) {
            c2654k7.j = num3.intValue();
        }
        String str5 = c2436b7.k;
        if (str5 != null) {
            c2654k7.k = str5;
        }
        B8 b8 = c2436b7.l;
        if (b8 != null) {
            c2654k7.l = b8.a;
        }
        String str6 = c2436b7.m;
        if (str6 != null) {
            c2654k7.m = str6;
        }
        X9 x9 = c2436b7.n;
        if (x9 != null) {
            c2654k7.n = x9.a;
        }
        EnumC2585h9 enumC2585h9 = c2436b7.o;
        if (enumC2585h9 != null) {
            c2654k7.o = enumC2585h9.a;
        }
        Boolean bool = c2436b7.p;
        if (bool != null) {
            c2654k7.p = this.a.fromModel(bool).intValue();
        }
        Integer num4 = c2436b7.q;
        if (num4 != null) {
            c2654k7.q = num4.intValue();
        }
        byte[] bArr = c2436b7.r;
        if (bArr != null) {
            c2654k7.r = bArr;
        }
        return c2654k7;
    }

    public Z6(Dd dd, C2583h7 c2583h7) {
        this.a = dd;
        this.b = c2583h7;
    }

    public /* synthetic */ Z6(Dd dd, C2583h7 c2583h7, int i, ED1 ed1) {
        this((i & 1) != 0 ? new Dd() : dd, (i & 2) != 0 ? new C2583h7(null, 1, null) : c2583h7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2436b7 toModel(C2654k7 c2654k7) {
        EnumC2585h9 enumC2585h9;
        C2654k7 c2654k72 = new C2654k7();
        int i = c2654k7.a;
        Integer numValueOf = i != c2654k72.a ? Integer.valueOf(i) : null;
        String str = c2654k7.b;
        String str2 = AbstractC13042fc3.d(str, c2654k72.b) ^ true ? str : null;
        String str3 = c2654k7.c;
        String str4 = AbstractC13042fc3.d(str3, c2654k72.c) ^ true ? str3 : null;
        long j = c2654k7.d;
        Long lValueOf = j != c2654k72.d ? Long.valueOf(j) : null;
        C2559g7 model = this.b.toModel(c2654k7.e);
        String str5 = c2654k7.f;
        String str6 = AbstractC13042fc3.d(str5, c2654k72.f) ^ true ? str5 : null;
        String str7 = c2654k7.g;
        String str8 = AbstractC13042fc3.d(str7, c2654k72.g) ^ true ? str7 : null;
        long j2 = c2654k7.h;
        Long lValueOf2 = Long.valueOf(j2);
        if (j2 == c2654k72.h) {
            lValueOf2 = null;
        }
        int i2 = c2654k7.i;
        Integer numValueOf2 = i2 != c2654k72.i ? Integer.valueOf(i2) : null;
        int i3 = c2654k7.j;
        Integer numValueOf3 = i3 != c2654k72.j ? Integer.valueOf(i3) : null;
        String str9 = c2654k7.k;
        String str10 = AbstractC13042fc3.d(str9, c2654k72.k) ^ true ? str9 : null;
        int i4 = c2654k7.l;
        Integer numValueOf4 = Integer.valueOf(i4);
        if (i4 == c2654k72.l) {
            numValueOf4 = null;
        }
        B8 b8A = numValueOf4 != null ? B8.a(Integer.valueOf(numValueOf4.intValue())) : null;
        String str11 = c2654k7.m;
        String str12 = AbstractC13042fc3.d(str11, c2654k72.m) ^ true ? str11 : null;
        int i5 = c2654k7.n;
        Integer numValueOf5 = Integer.valueOf(i5);
        if (i5 == c2654k72.n) {
            numValueOf5 = null;
        }
        X9 x9A = numValueOf5 != null ? X9.a(Integer.valueOf(numValueOf5.intValue())) : null;
        int i6 = c2654k7.o;
        Integer numValueOf6 = Integer.valueOf(i6);
        if (i6 == c2654k72.o) {
            numValueOf6 = null;
        }
        if (numValueOf6 != null) {
            int iIntValue = numValueOf6.intValue();
            EnumC2585h9[] enumC2585h9ArrValues = EnumC2585h9.values();
            int length = enumC2585h9ArrValues.length;
            int i7 = 0;
            while (true) {
                if (i7 < length) {
                    EnumC2585h9 enumC2585h92 = enumC2585h9ArrValues[i7];
                    EnumC2585h9[] enumC2585h9Arr = enumC2585h9ArrValues;
                    if (enumC2585h92.a == iIntValue) {
                        enumC2585h9 = enumC2585h92;
                        break;
                    }
                    i7++;
                    enumC2585h9ArrValues = enumC2585h9Arr;
                } else {
                    enumC2585h9 = EnumC2585h9.NATIVE;
                    break;
                }
            }
        } else {
            enumC2585h9 = null;
        }
        Boolean boolA = this.a.a(c2654k7.p);
        int i8 = c2654k7.q;
        Integer numValueOf7 = i8 != c2654k72.q ? Integer.valueOf(i8) : null;
        byte[] bArr = c2654k7.r;
        return new C2436b7(numValueOf, str2, str4, lValueOf, model, str6, str8, lValueOf2, numValueOf2, numValueOf3, str10, b8A, str12, x9A, enumC2585h9, boolA, numValueOf7, Arrays.equals(bArr, c2654k72.r) ^ true ? bArr : null);
    }
}
