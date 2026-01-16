package io.appmetrica.analytics.impl;

import android.content.Context;

/* renamed from: io.appmetrica.analytics.impl.o4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2747o4 {
    public static volatile C2747o4 p;
    public final Sb a;
    public final A7 b;
    public final C2556g4 c;
    public final G1 d;
    public final C2766p e;
    public final Xj f;
    public final F5 g;
    public final C2670l h;
    public final C2645jm i;
    public Vc j;
    public volatile C2675l4 k;
    public final C3018zc l;
    public volatile C2637je m;
    public C2785pi n;
    public final C2743o0 o;

    public C2747o4(Sb sb, C2766p c2766p, C2556g4 c2556g4) {
        this(sb, c2766p, c2556g4, new C2670l(c2766p));
    }

    public static C2747o4 g() {
        if (p == null) {
            synchronized (C2747o4.class) {
                try {
                    if (p == null) {
                        p = new C2747o4(new Sb(), new C2766p(), new C2556g4());
                    }
                } finally {
                }
            }
        }
        return p;
    }

    public final C2766p a() {
        return this.e;
    }

    public final C2637je b(Context context) {
        C2637je c2637je = this.m;
        if (c2637je == null) {
            synchronized (this) {
                try {
                    c2637je = this.m;
                    if (c2637je == null) {
                        c2637je = new C2637je(W6.a(context).a());
                        this.m = c2637je;
                    }
                } finally {
                }
            }
        }
        return c2637je;
    }

    public final G1 c() {
        return this.d;
    }

    public final C2556g4 d() {
        return this.c;
    }

    public final F5 e() {
        return this.g;
    }

    public final A7 f() {
        return this.b;
    }

    public final Sb h() {
        return this.a;
    }

    public final C2675l4 i() {
        C2675l4 c2675l4 = this.k;
        if (c2675l4 == null) {
            synchronized (this) {
                try {
                    c2675l4 = this.k;
                    if (c2675l4 == null) {
                        c2675l4 = new C2675l4();
                        this.k = c2675l4;
                    }
                } finally {
                }
            }
        }
        return c2675l4;
    }

    public final Sb j() {
        return this.a;
    }

    public final Xj k() {
        return this.f;
    }

    public C2747o4(Sb sb, C2766p c2766p, C2556g4 c2556g4, C2670l c2670l) {
        this(sb, new A7(), c2556g4, c2670l, new G1(), c2766p, new Xj(c2766p, c2670l), new F5(c2766p), new C2645jm());
    }

    public final synchronized Vc a(Context context) {
        try {
            if (this.j == null) {
                this.j = new Vc(context, new in());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.j;
    }

    public C2747o4(Sb sb, A7 a7, C2556g4 c2556g4, C2670l c2670l, G1 g1, C2766p c2766p, Xj xj, F5 f5, C2645jm c2645jm) {
        this.l = new C3018zc();
        this.o = new C2743o0();
        this.a = sb;
        this.b = a7;
        this.c = c2556g4;
        this.h = c2670l;
        this.d = g1;
        this.e = c2766p;
        this.f = xj;
        this.g = f5;
        this.i = c2645jm;
    }

    public final C2743o0 b() {
        return this.o;
    }
}
