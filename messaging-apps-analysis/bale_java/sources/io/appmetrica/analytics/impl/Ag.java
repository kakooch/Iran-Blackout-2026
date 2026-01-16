package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Ag extends N5 {
    public final C2484d5 b;
    public final InterfaceC3022zg c;
    public final T3 d;

    public Ag(C2484d5 c2484d5, InterfaceC3022zg interfaceC3022zg) {
        this(c2484d5, interfaceC3022zg, new T3());
    }

    @Override // io.appmetrica.analytics.impl.N5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Cg load(M5 m5) {
        Cg cg = (Cg) super.load(m5);
        cg.n = ((C2974xg) m5.componentArguments).a;
        cg.s = this.b.v.a();
        cg.x = this.b.s.a();
        C2974xg c2974xg = (C2974xg) m5.componentArguments;
        cg.d = c2974xg.c;
        cg.e = c2974xg.b;
        cg.f = c2974xg.d;
        cg.g = c2974xg.e;
        cg.j = c2974xg.f;
        cg.h = c2974xg.g;
        cg.i = c2974xg.h;
        Boolean boolValueOf = Boolean.valueOf(c2974xg.i);
        InterfaceC3022zg interfaceC3022zg = this.c;
        cg.k = boolValueOf;
        cg.l = interfaceC3022zg;
        C2974xg c2974xg2 = (C2974xg) m5.componentArguments;
        cg.w = c2974xg2.k;
        C2549fl c2549fl = m5.a;
        C2938w4 c2938w4 = c2549fl.n;
        cg.o = c2938w4.a;
        Md md = c2549fl.s;
        if (md != null) {
            cg.t = md.a;
            cg.u = md.b;
        }
        cg.p = c2938w4.b;
        cg.r = c2549fl.e;
        cg.q = c2549fl.k;
        T3 t3 = this.d;
        Map<String, String> map = c2974xg2.j;
        Q3 q3D = C2586ha.C.d();
        t3.getClass();
        cg.v = T3.a(map, c2549fl, q3D);
        return cg;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new Cg(this.b);
    }

    public Ag(C2484d5 c2484d5, InterfaceC3022zg interfaceC3022zg, T3 t3) {
        super(c2484d5.getContext(), c2484d5.b().c());
        this.b = c2484d5;
        this.c = interfaceC3022zg;
        this.d = t3;
    }

    public final Cg a() {
        return new Cg(this.b);
    }
}
