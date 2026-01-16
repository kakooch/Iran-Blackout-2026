package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class du {
    private static final tw s = new tw(new Object());
    public final es a;
    public final tw b;
    public final long c;
    public final int d;
    public final bn e;
    public final boolean f;
    public final vj g;
    public final abg h;
    public final List<qz> i;
    public final tw j;
    public final boolean k;
    public final int l;
    public final dv m;
    public final boolean n;
    public final boolean o;
    public volatile long p;
    public volatile long q;
    public volatile long r;

    public du(es esVar, tw twVar, long j, int i, bn bnVar, boolean z, vj vjVar, abg abgVar, List<qz> list, tw twVar2, boolean z2, int i2, dv dvVar, long j2, long j3, long j4, boolean z3, boolean z4) {
        this.a = esVar;
        this.b = twVar;
        this.c = j;
        this.d = i;
        this.e = bnVar;
        this.f = z;
        this.g = vjVar;
        this.h = abgVar;
        this.i = list;
        this.j = twVar2;
        this.k = z2;
        this.l = i2;
        this.m = dvVar;
        this.p = j2;
        this.q = j3;
        this.r = j4;
        this.n = z3;
        this.o = z4;
    }

    public static du a(abg abgVar) {
        es esVar = es.a;
        tw twVar = s;
        return new du(esVar, twVar, -9223372036854775807L, 1, null, false, vj.a, abgVar, arn.i(), twVar, false, 0, dv.a, 0L, 0L, 0L, false, false);
    }

    public static tw b() {
        return s;
    }

    public final du c(tw twVar, long j, long j2, long j3, vj vjVar, abg abgVar, List<qz> list) {
        return new du(this.a, twVar, j2, this.d, this.e, this.f, vjVar, abgVar, list, this.j, this.k, this.l, this.m, this.p, j3, j, this.n, this.o);
    }

    public final du d(es esVar) {
        return new du(esVar, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.p, this.q, this.r, this.n, this.o);
    }

    public final du e(int i) {
        return new du(this.a, this.b, this.c, i, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.p, this.q, this.r, this.n, this.o);
    }

    public final du f(bn bnVar) {
        return new du(this.a, this.b, this.c, this.d, bnVar, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.p, this.q, this.r, this.n, this.o);
    }

    public final du g(tw twVar) {
        return new du(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, twVar, this.k, this.l, this.m, this.p, this.q, this.r, this.n, this.o);
    }

    public final du h(boolean z, int i) {
        return new du(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, z, i, this.m, this.p, this.q, this.r, this.n, this.o);
    }

    public final du i(boolean z) {
        return new du(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.p, this.q, this.r, z, this.o);
    }
}
