package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.fl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2549fl {
    public final Dl A;
    public final Map B;
    public final C2919v9 C;
    public final String a;
    public final String b;
    public final C2644jl c;
    public final String d;
    public final List e;
    public final List f;
    public final List g;
    public final Map h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final C2938w4 n;
    public final long o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final Md s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final BillingConfig x;
    public final C2889u3 y;
    public final C2697m2 z;

    public C2549fl(String str, String str2, C2644jl c2644jl) {
        this.a = str;
        this.b = str2;
        this.c = c2644jl;
        this.d = c2644jl.a;
        this.e = c2644jl.b;
        this.f = c2644jl.f;
        this.g = c2644jl.g;
        this.h = c2644jl.i;
        this.i = c2644jl.c;
        this.j = c2644jl.d;
        this.k = c2644jl.j;
        this.l = c2644jl.k;
        this.m = c2644jl.l;
        this.n = c2644jl.m;
        this.o = c2644jl.n;
        this.p = c2644jl.o;
        this.q = c2644jl.p;
        this.r = c2644jl.q;
        this.s = c2644jl.s;
        this.t = c2644jl.t;
        this.u = c2644jl.u;
        this.v = c2644jl.v;
        this.w = c2644jl.w;
        this.x = c2644jl.x;
        this.y = c2644jl.y;
        this.z = c2644jl.z;
        this.A = c2644jl.A;
        this.B = c2644jl.B;
        this.C = c2644jl.C;
    }

    public final C2500dl a() {
        C2644jl c2644jl = this.c;
        C2620il c2620il = new C2620il(c2644jl.m);
        c2620il.a = c2644jl.a;
        c2620il.f = c2644jl.f;
        c2620il.g = c2644jl.g;
        c2620il.j = c2644jl.j;
        c2620il.b = c2644jl.b;
        c2620il.c = c2644jl.c;
        c2620il.d = c2644jl.d;
        c2620il.e = c2644jl.e;
        c2620il.h = c2644jl.h;
        c2620il.i = c2644jl.i;
        c2620il.k = c2644jl.k;
        c2620il.l = c2644jl.l;
        c2620il.q = c2644jl.p;
        c2620il.o = c2644jl.n;
        c2620il.p = c2644jl.o;
        c2620il.r = c2644jl.q;
        c2620il.n = c2644jl.s;
        c2620il.t = c2644jl.u;
        c2620il.u = c2644jl.v;
        c2620il.s = c2644jl.r;
        c2620il.v = c2644jl.w;
        c2620il.w = c2644jl.t;
        c2620il.y = c2644jl.y;
        c2620il.x = c2644jl.x;
        c2620il.z = c2644jl.z;
        c2620il.A = c2644jl.A;
        c2620il.B = c2644jl.B;
        c2620il.C = c2644jl.C;
        C2500dl c2500dl = new C2500dl(c2620il);
        c2500dl.b = this.a;
        c2500dl.c = this.b;
        return c2500dl;
    }

    public final String b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final long d() {
        return this.v;
    }

    public final long e() {
        return this.u;
    }

    public final String f() {
        return this.d;
    }

    public final String toString() {
        return "StartupState(deviceId=" + this.a + ", deviceIdHash=" + this.b + ", startupStateModel=" + this.c + ')';
    }
}
