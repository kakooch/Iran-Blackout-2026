package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Looper;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class eh {
    private final Context a;
    private adk b;
    private abf c;
    private ui d;
    private abq e;
    private gj f;
    private Looper g;
    private final gs h;
    private final int i;
    private boolean j;
    private final eg k;
    private final long l;
    private final long m;
    private final boolean n;
    private final aok o;
    private bk p;
    private final bj q;

    public eh(Context context, aok aokVar) {
        jw jwVar = new jw();
        aaw aawVar = new aaw(aaq.a(context), new aah());
        tj tjVar = new tj(new ach(context), jwVar);
        bk bkVar = new bk();
        acf acfVarE = acf.e(context);
        adk adkVar = adk.a;
        gj gjVar = new gj(adkVar);
        this.a = context;
        this.o = aokVar;
        this.c = aawVar;
        this.d = tjVar;
        this.p = bkVar;
        this.e = acfVarE;
        this.f = gjVar;
        this.g = aeu.o();
        this.h = gs.a;
        this.i = 1;
        this.j = true;
        this.k = eg.b;
        this.q = ek.a(0.97f, 1.03f, 500L, 5.0E-8f);
        this.b = adkVar;
        this.n = true;
        this.l = 500L;
        this.m = 2000L;
    }

    static /* synthetic */ int c(eh ehVar) {
        return 1;
    }

    static /* synthetic */ long d(eh ehVar) {
        return 2000L;
    }

    static /* synthetic */ long j(eh ehVar) {
        return 500L;
    }

    static /* synthetic */ boolean m(eh ehVar) {
        return true;
    }

    public final void q(gj gjVar) {
        ary.q(true);
        this.f = gjVar;
    }

    public final void r(abq abqVar) {
        ary.q(true);
        this.e = abqVar;
    }

    public final void s(adk adkVar) {
        ary.q(true);
        this.b = adkVar;
    }

    public final void t(bk bkVar) {
        ary.q(true);
        this.p = bkVar;
    }

    public final void u(Looper looper) {
        ary.q(true);
        this.g = looper;
    }

    public final void v(ui uiVar) {
        ary.q(true);
        this.d = uiVar;
    }

    public final void w(abf abfVar) {
        ary.q(true);
        this.c = abfVar;
    }

    public final void x() {
        ary.q(true);
        this.j = true;
    }
}
