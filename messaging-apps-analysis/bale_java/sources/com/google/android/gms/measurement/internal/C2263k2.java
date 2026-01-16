package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import ir.nasim.AbstractC13194fo8;
import ir.nasim.AbstractC3795Cj5;
import java.util.ArrayList;
import java.util.List;
import org.xbill.DNS.TTL;

/* renamed from: com.google.android.gms.measurement.internal.k2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2263k2 {
    private long A;
    private String B;
    private boolean C;
    private long D;
    private long E;
    private final H1 a;
    private final String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private long g;
    private long h;
    private long i;
    private String j;
    private long k;
    private String l;
    private long m;
    private long n;
    private boolean o;
    private boolean p;
    private String q;
    private Boolean r;
    private long s;
    private List t;
    private String u;
    private long v;
    private long w;
    private long x;
    private long y;
    private long z;

    C2263k2(H1 h1, String str) {
        AbstractC3795Cj5.j(h1);
        AbstractC3795Cj5.f(str);
        this.a = h1;
        this.b = str;
        h1.a().h();
    }

    public final long A() {
        this.a.a().h();
        return 0L;
    }

    public final void B(long j) {
        AbstractC3795Cj5.a(j >= 0);
        this.a.a().h();
        this.C |= this.g != j;
        this.g = j;
    }

    public final void C(long j) {
        this.a.a().h();
        this.C |= this.h != j;
        this.h = j;
    }

    public final void D(boolean z) {
        this.a.a().h();
        this.C |= this.o != z;
        this.o = z;
    }

    public final void E(Boolean bool) {
        this.a.a().h();
        this.C |= !AbstractC13194fo8.a(this.r, bool);
        this.r = bool;
    }

    public final void F(String str) {
        this.a.a().h();
        this.C |= !AbstractC13194fo8.a(this.e, str);
        this.e = str;
    }

    public final void G(List list) {
        this.a.a().h();
        if (AbstractC13194fo8.a(this.t, list)) {
            return;
        }
        this.C = true;
        this.t = list != null ? new ArrayList(list) : null;
    }

    public final void H(String str) {
        this.a.a().h();
        this.C |= !AbstractC13194fo8.a(this.u, str);
        this.u = str;
    }

    public final boolean I() {
        this.a.a().h();
        return this.p;
    }

    public final boolean J() {
        this.a.a().h();
        return this.o;
    }

    public final boolean K() {
        this.a.a().h();
        return this.C;
    }

    public final long L() {
        this.a.a().h();
        return this.k;
    }

    public final long M() {
        this.a.a().h();
        return this.D;
    }

    public final long N() {
        this.a.a().h();
        return this.y;
    }

    public final long O() {
        this.a.a().h();
        return this.z;
    }

    public final long P() {
        this.a.a().h();
        return this.x;
    }

    public final long Q() {
        this.a.a().h();
        return this.w;
    }

    public final long R() {
        this.a.a().h();
        return this.A;
    }

    public final long S() {
        this.a.a().h();
        return this.v;
    }

    public final long T() {
        this.a.a().h();
        return this.n;
    }

    public final long U() {
        this.a.a().h();
        return this.s;
    }

    public final long V() {
        this.a.a().h();
        return this.E;
    }

    public final long W() {
        this.a.a().h();
        return this.m;
    }

    public final long X() {
        this.a.a().h();
        return this.i;
    }

    public final long Y() {
        this.a.a().h();
        return this.g;
    }

    public final long Z() {
        this.a.a().h();
        return this.h;
    }

    public final String a() {
        this.a.a().h();
        return this.e;
    }

    public final Boolean a0() {
        this.a.a().h();
        return this.r;
    }

    public final String b() {
        this.a.a().h();
        return this.u;
    }

    public final String b0() {
        this.a.a().h();
        return this.q;
    }

    public final List c() {
        this.a.a().h();
        return this.t;
    }

    public final String c0() {
        this.a.a().h();
        String str = this.B;
        y(null);
        return str;
    }

    public final void d() {
        this.a.a().h();
        this.C = false;
    }

    public final String d0() {
        this.a.a().h();
        return this.b;
    }

    public final void e() {
        this.a.a().h();
        long j = this.g + 1;
        if (j > TTL.MAX_VALUE) {
            this.a.b().w().b("Bundle index overflow. appId", C2227d1.z(this.b));
            j = 0;
        }
        this.C = true;
        this.g = j;
    }

    public final String e0() {
        this.a.a().h();
        return this.c;
    }

    public final void f(String str) {
        this.a.a().h();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.C |= true ^ AbstractC13194fo8.a(this.q, str);
        this.q = str;
    }

    public final String f0() {
        this.a.a().h();
        return this.l;
    }

    public final void g(boolean z) {
        this.a.a().h();
        this.C |= this.p != z;
        this.p = z;
    }

    public final String g0() {
        this.a.a().h();
        return this.j;
    }

    public final void h(String str) {
        this.a.a().h();
        this.C |= !AbstractC13194fo8.a(this.c, str);
        this.c = str;
    }

    public final String h0() {
        this.a.a().h();
        return this.f;
    }

    public final void i(String str) {
        this.a.a().h();
        this.C |= !AbstractC13194fo8.a(this.l, str);
        this.l = str;
    }

    public final String i0() {
        this.a.a().h();
        return this.d;
    }

    public final void j(String str) {
        this.a.a().h();
        this.C |= !AbstractC13194fo8.a(this.j, str);
        this.j = str;
    }

    public final String j0() {
        this.a.a().h();
        return this.B;
    }

    public final void k(long j) {
        this.a.a().h();
        this.C |= this.k != j;
        this.k = j;
    }

    public final void l(long j) {
        this.a.a().h();
        this.C |= this.D != j;
        this.D = j;
    }

    public final void m(long j) {
        this.a.a().h();
        this.C |= this.y != j;
        this.y = j;
    }

    public final void n(long j) {
        this.a.a().h();
        this.C |= this.z != j;
        this.z = j;
    }

    public final void o(long j) {
        this.a.a().h();
        this.C |= this.x != j;
        this.x = j;
    }

    public final void p(long j) {
        this.a.a().h();
        this.C |= this.w != j;
        this.w = j;
    }

    public final void q(long j) {
        this.a.a().h();
        this.C |= this.A != j;
        this.A = j;
    }

    public final void r(long j) {
        this.a.a().h();
        this.C |= this.v != j;
        this.v = j;
    }

    public final void s(long j) {
        this.a.a().h();
        this.C |= this.n != j;
        this.n = j;
    }

    public final void t(long j) {
        this.a.a().h();
        this.C |= this.s != j;
        this.s = j;
    }

    public final void u(long j) {
        this.a.a().h();
        this.C |= this.E != j;
        this.E = j;
    }

    public final void v(String str) {
        this.a.a().h();
        this.C |= !AbstractC13194fo8.a(this.f, str);
        this.f = str;
    }

    public final void w(String str) {
        this.a.a().h();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.C |= true ^ AbstractC13194fo8.a(this.d, str);
        this.d = str;
    }

    public final void x(long j) {
        this.a.a().h();
        this.C |= this.m != j;
        this.m = j;
    }

    public final void y(String str) {
        this.a.a().h();
        this.C |= !AbstractC13194fo8.a(this.B, str);
        this.B = str;
    }

    public final void z(long j) {
        this.a.a().h();
        this.C |= this.i != j;
        this.i = j;
    }
}
