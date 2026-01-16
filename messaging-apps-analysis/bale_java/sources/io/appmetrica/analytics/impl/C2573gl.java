package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.gl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2573gl implements ProtobufConverter {
    public final Nd a = new Nd();
    public final Z9 b = new Z9();
    public final Il c = new Il();
    public final C2769p2 d = new C2769p2();
    public final C2937w3 e = new C2937w3();
    public final C2721n2 f = new C2721n2();
    public final C2868t6 g = new C2868t6();
    public final El h = new El();
    public final Qc i = new Qc();
    public final C2943w9 j = new C2943w9();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2979xl fromModel(C2644jl c2644jl) {
        C2979xl c2979xl = new C2979xl();
        c2979xl.s = c2644jl.u;
        c2979xl.t = c2644jl.v;
        String str = c2644jl.a;
        if (str != null) {
            c2979xl.a = str;
        }
        List list = c2644jl.f;
        if (list != null) {
            c2979xl.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = c2644jl.g;
        if (list2 != null) {
            c2979xl.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = c2644jl.b;
        if (list3 != null) {
            c2979xl.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = c2644jl.h;
        if (list4 != null) {
            c2979xl.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = c2644jl.i;
        if (map != null) {
            c2979xl.h = this.g.fromModel(map);
        }
        Md md = c2644jl.s;
        if (md != null) {
            c2979xl.v = this.a.fromModel(md);
        }
        String str2 = c2644jl.j;
        if (str2 != null) {
            c2979xl.j = str2;
        }
        String str3 = c2644jl.c;
        if (str3 != null) {
            c2979xl.d = str3;
        }
        String str4 = c2644jl.d;
        if (str4 != null) {
            c2979xl.e = str4;
        }
        String str5 = c2644jl.e;
        if (str5 != null) {
            c2979xl.r = str5;
        }
        c2979xl.i = this.b.fromModel(c2644jl.m);
        String str6 = c2644jl.k;
        if (str6 != null) {
            c2979xl.k = str6;
        }
        String str7 = c2644jl.l;
        if (str7 != null) {
            c2979xl.l = str7;
        }
        c2979xl.m = c2644jl.p;
        c2979xl.b = c2644jl.n;
        c2979xl.q = c2644jl.o;
        RetryPolicyConfig retryPolicyConfig = c2644jl.t;
        c2979xl.w = retryPolicyConfig.maxIntervalSeconds;
        c2979xl.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = c2644jl.q;
        if (str8 != null) {
            c2979xl.n = str8;
        }
        Hl hl = c2644jl.r;
        if (hl != null) {
            this.c.getClass();
            C2955wl c2955wl = new C2955wl();
            c2955wl.a = hl.a;
            c2979xl.p = c2955wl;
        }
        c2979xl.u = c2644jl.w;
        BillingConfig billingConfig = c2644jl.x;
        if (billingConfig != null) {
            c2979xl.z = this.d.fromModel(billingConfig);
        }
        C2889u3 c2889u3 = c2644jl.y;
        if (c2889u3 != null) {
            this.e.getClass();
            C2788pl c2788pl = new C2788pl();
            c2788pl.a = c2889u3.a;
            c2979xl.y = c2788pl;
        }
        C2697m2 c2697m2 = c2644jl.z;
        if (c2697m2 != null) {
            c2979xl.A = this.f.fromModel(c2697m2);
        }
        c2979xl.B = this.h.fromModel(c2644jl.A);
        c2979xl.C = this.i.fromModel(c2644jl.B);
        c2979xl.D = this.j.fromModel(c2644jl.C);
        return c2979xl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2644jl toModel(C2979xl c2979xl) {
        C2620il c2620il = new C2620il(this.b.toModel(c2979xl.i));
        c2620il.a = c2979xl.a;
        c2620il.j = c2979xl.j;
        c2620il.c = c2979xl.d;
        c2620il.b = Arrays.asList(c2979xl.c);
        c2620il.g = Arrays.asList(c2979xl.g);
        c2620il.f = Arrays.asList(c2979xl.f);
        c2620il.d = c2979xl.e;
        c2620il.e = c2979xl.r;
        c2620il.h = Arrays.asList(c2979xl.o);
        c2620il.k = c2979xl.k;
        c2620il.l = c2979xl.l;
        c2620il.q = c2979xl.m;
        c2620il.o = c2979xl.b;
        c2620il.p = c2979xl.q;
        c2620il.t = c2979xl.s;
        c2620il.u = c2979xl.t;
        c2620il.r = c2979xl.n;
        c2620il.v = c2979xl.u;
        c2620il.w = new RetryPolicyConfig(c2979xl.w, c2979xl.x);
        c2620il.i = this.g.toModel(c2979xl.h);
        C2907ul c2907ul = c2979xl.v;
        if (c2907ul != null) {
            this.a.getClass();
            c2620il.n = new Md(c2907ul.a, c2907ul.b);
        }
        C2955wl c2955wl = c2979xl.p;
        if (c2955wl != null) {
            this.c.getClass();
            c2620il.s = new Hl(c2955wl.a);
        }
        C2764ol c2764ol = c2979xl.z;
        if (c2764ol != null) {
            this.d.getClass();
            c2620il.x = new BillingConfig(c2764ol.a, c2764ol.b);
        }
        C2788pl c2788pl = c2979xl.y;
        if (c2788pl != null) {
            this.e.getClass();
            c2620il.y = new C2889u3(c2788pl.a);
        }
        C2740nl c2740nl = c2979xl.A;
        if (c2740nl != null) {
            c2620il.z = this.f.toModel(c2740nl);
        }
        C2931vl c2931vl = c2979xl.B;
        if (c2931vl != null) {
            this.h.getClass();
            c2620il.A = new Dl(c2931vl.a);
        }
        c2620il.B = this.i.toModel(c2979xl.C);
        C2835rl c2835rl = c2979xl.D;
        if (c2835rl != null) {
            this.j.getClass();
            c2620il.C = new C2919v9(c2835rl.a);
        }
        return new C2644jl(c2620il);
    }
}
