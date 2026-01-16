package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class P8 {
    public static final Map h;
    public static final P8 i;
    public final Xc a;
    public final pn b;
    public final InterfaceC2846s8 c;
    public final InterfaceC2704m9 d;
    public final Lb e;
    public final InterfaceC2708md f;
    public final H9 g;

    static {
        HashMap map = new HashMap();
        map.put(X9.FIRST_OCCURRENCE, 1);
        map.put(X9.NON_FIRST_OCCURENCE, 0);
        map.put(X9.UNKNOWN, -1);
        h = Collections.unmodifiableMap(map);
        i = new P8(new C2546fi(), new Yl(), new C2899ud(), new C2522ei(), new C2489da(), new C2514ea(), new C2464ca());
    }

    public P8(O8 o8) {
        this(o8.a, o8.b, o8.c, o8.d, o8.e, o8.f, o8.g);
    }

    public final Z8 a(G8 g8, Cg cg) {
        Z8 z8 = new Z8();
        Y8 y8A = this.f.a(g8.l, g8.m);
        U8 u8A = this.e.a(g8.g);
        if (y8A != null) {
            z8.g = y8A;
        }
        if (u8A != null) {
            z8.f = u8A;
        }
        String strA = this.a.a(g8.a);
        if (strA != null) {
            z8.d = strA;
        }
        z8.e = this.b.a(g8, cg);
        String str = g8.j;
        if (str != null) {
            z8.h = str;
        }
        Integer numA = this.d.a(g8);
        if (numA != null) {
            z8.c = numA.intValue();
        }
        Long l = g8.c;
        if (l != null) {
            z8.a = l.longValue();
        }
        Long l2 = g8.d;
        if (l2 != null) {
            z8.n = l2.longValue();
        }
        Long l3 = g8.e;
        if (l3 != null) {
            z8.o = l3.longValue();
        }
        Long l4 = g8.f;
        if (l4 != null) {
            z8.b = l4.longValue();
        }
        Integer num = g8.k;
        if (num != null) {
            z8.i = num.intValue();
        }
        z8.j = this.c.a(g8.o);
        C2559g7 c2559g7 = g8.g;
        z8.k = c2559g7 != null ? new C2582h6().a(c2559g7.a) : -1;
        String str2 = g8.n;
        if (str2 != null) {
            z8.l = str2.getBytes();
        }
        X9 x9 = g8.p;
        Integer num2 = x9 != null ? (Integer) h.get(x9) : null;
        if (num2 != null) {
            z8.m = num2.intValue();
        }
        EnumC2585h9 enumC2585h9 = g8.q;
        if (enumC2585h9 != null) {
            z8.p = enumC2585h9.a;
        }
        Boolean bool = g8.r;
        if (bool != null) {
            z8.q = bool.booleanValue();
        }
        if (g8.s != null) {
            z8.r = r6.intValue();
        }
        z8.s = ((C2464ca) this.g).a(g8.t);
        return z8;
    }

    public P8(Xc xc, pn pnVar, InterfaceC2846s8 interfaceC2846s8, InterfaceC2704m9 interfaceC2704m9, Lb lb, InterfaceC2708md interfaceC2708md, H9 h9) {
        this.a = xc;
        this.b = pnVar;
        this.c = interfaceC2846s8;
        this.d = interfaceC2704m9;
        this.e = lb;
        this.f = interfaceC2708md;
        this.g = h9;
    }

    public static O8 a() {
        return new O8(i);
    }
}
