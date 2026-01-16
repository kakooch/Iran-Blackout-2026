package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ej extends bg {
    private iu A;
    private int B;
    private final gs C;
    private final float D;
    private boolean E;
    private final boolean F;
    private boolean G;
    private ix H;
    private final ary I;
    protected final ed[] b;
    private final cj c;
    private final ei d;
    private final CopyOnWriteArraySet<afk> e;
    private final CopyOnWriteArraySet<gu> f;
    private final CopyOnWriteArraySet g;
    private final CopyOnWriteArraySet<iy> h;
    private final CopyOnWriteArraySet<afu> i;
    private final CopyOnWriteArraySet<hi> j;
    private final gj k;
    private final bb l;
    private final bf m;
    private final eo n;
    private final et o;
    private final eu p;
    private final long q;
    private cy r;
    private cy s;
    private Surface t;
    private boolean u;
    private final int v;
    private SurfaceHolder w;
    private int x;
    private int y;
    private iu z;

    @Deprecated
    protected ej(Context context, aok aokVar, abf abfVar, ui uiVar, bk bkVar, abq abqVar, gj gjVar, adk adkVar, Looper looper) {
        eh ehVar = new eh(context, aokVar);
        ehVar.w(abfVar);
        ehVar.v(uiVar);
        ehVar.t(bkVar);
        ehVar.r(abqVar);
        ehVar.q(gjVar);
        ehVar.x();
        ehVar.s(adkVar);
        ehVar.u(looper);
        gj gjVar2 = ehVar.f;
        this.k = gjVar2;
        this.I = null;
        gs gsVar = ehVar.h;
        this.C = gsVar;
        int iC = eh.c(ehVar);
        this.v = iC;
        this.E = false;
        this.q = eh.d(ehVar);
        ei eiVar = new ei(this);
        this.d = eiVar;
        CopyOnWriteArraySet<afk> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        this.e = copyOnWriteArraySet;
        CopyOnWriteArraySet<gu> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
        this.f = copyOnWriteArraySet2;
        new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet3 = new CopyOnWriteArraySet();
        this.g = copyOnWriteArraySet3;
        this.h = new CopyOnWriteArraySet<>();
        CopyOnWriteArraySet<afu> copyOnWriteArraySet4 = new CopyOnWriteArraySet<>();
        this.i = copyOnWriteArraySet4;
        CopyOnWriteArraySet<hi> copyOnWriteArraySet5 = new CopyOnWriteArraySet<>();
        this.j = copyOnWriteArraySet5;
        Handler handler = new Handler(ehVar.g);
        ed[] edVarArrA = ehVar.o.a(handler, eiVar, eiVar);
        this.b = edVarArrA;
        this.D = 1.0f;
        this.B = 0;
        Collections.emptyList();
        this.F = true;
        cj cjVar = new cj(edVarArrA, ehVar.c, ehVar.p, ehVar.e, gjVar2, ehVar.j, ehVar.k, ehVar.q, eh.j(ehVar), false, ehVar.b, ehVar.g);
        this.c = cjVar;
        cjVar.e(eiVar);
        copyOnWriteArraySet4.add(gjVar2);
        copyOnWriteArraySet.add(gjVar2);
        copyOnWriteArraySet5.add(gjVar2);
        copyOnWriteArraySet2.add(gjVar2);
        ary.t(gjVar2);
        copyOnWriteArraySet3.add(gjVar2);
        bb bbVar = new bb(ehVar.a, handler, eiVar);
        this.l = bbVar;
        bbVar.a(false);
        bf bfVar = new bf(ehVar.a, handler, eiVar);
        this.m = bfVar;
        bfVar.b(null);
        eo eoVar = new eo(ehVar.a, handler, eiVar);
        this.n = eoVar;
        int i = gsVar.c;
        int i2 = aeu.a;
        eoVar.a(3);
        et etVar = new et(ehVar.a);
        this.o = etVar;
        etVar.a(false);
        eu euVar = new eu(ehVar.a);
        this.p = euVar;
        euVar.a(false);
        this.H = af(eoVar);
        if (!eh.m(ehVar)) {
            cjVar.b();
        }
        ae(1, 3, gsVar);
        ae(2, 4, Integer.valueOf(iC));
        ae(1, 101, Boolean.valueOf(this.E));
    }

    static /* synthetic */ void C(ej ejVar) {
        Iterator<gu> it = ejVar.f.iterator();
        while (it.hasNext()) {
            gu next = it.next();
            if (!ejVar.j.contains(next)) {
                next.z(ejVar.B);
            }
        }
        Iterator<hi> it2 = ejVar.j.iterator();
        while (it2.hasNext()) {
            it2.next().z(ejVar.B);
        }
    }

    static /* synthetic */ void E(ej ejVar) {
        Iterator<gu> it = ejVar.f.iterator();
        while (it.hasNext()) {
            gu next = it.next();
            if (!ejVar.j.contains(next)) {
                next.F(ejVar.E);
            }
        }
        Iterator<hi> it2 = ejVar.j.iterator();
        while (it2.hasNext()) {
            it2.next().F(ejVar.E);
        }
    }

    static /* synthetic */ boolean O(ej ejVar) {
        return false;
    }

    static /* synthetic */ void P(ej ejVar) {
        int iG = ejVar.g();
        if (iG != 1) {
            if (iG == 2 || iG == 3) {
                ejVar.ad();
                ejVar.o.b(ejVar.j() && !ejVar.c.c());
                ejVar.p.b(ejVar.j());
                return;
            }
            if (iG != 4) {
                throw new IllegalStateException();
            }
        }
        ejVar.o.b(false);
        ejVar.p.b(false);
    }

    static /* synthetic */ ary Y(ej ejVar) {
        return null;
    }

    private final void Z() {
        SurfaceHolder surfaceHolder = this.w;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.d);
            this.w = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa(Surface surface, boolean z) {
        ArrayList arrayList = new ArrayList();
        ed[] edVarArr = this.b;
        int length = edVarArr.length;
        for (int i = 0; i < 2; i++) {
            ed edVar = edVarArr[i];
            if (edVar.a() == 2) {
                ea eaVarK = this.c.k(edVar);
                eaVarK.o(1);
                eaVarK.n(surface);
                eaVarK.m();
                arrayList.add(eaVarK);
            }
        }
        Surface surface2 = this.t;
        if (surface2 != null && surface2 != surface) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ea) it.next()).k(this.q);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                this.c.B(bn.e(new TimeoutException("Detaching surface timed out."), 3));
            }
            if (this.u) {
                this.t.release();
            }
        }
        this.t = surface;
        this.u = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ab(int i, int i2) {
        if (i == this.x && i2 == this.y) {
            return;
        }
        this.x = i;
        this.y = i2;
        Iterator<afk> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().M(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ac(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            z2 = false;
        } else if (i != -1) {
            z2 = true;
        } else {
            z2 = false;
            i = -1;
        }
        this.c.h(z2, (!z2 || i == 1) ? 0 : 1, i2);
    }

    private final void ad() {
        if (Looper.myLooper() != this.c.d()) {
            if (this.F) {
                throw new IllegalStateException("Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread");
            }
            adu.a("SimpleExoPlayer", "Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread", this.G ? null : new IllegalStateException());
            this.G = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ae(int i, int i2, Object obj) {
        ed[] edVarArr = this.b;
        int length = edVarArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            ed edVar = edVarArr[i3];
            if (edVar.a() == i) {
                ea eaVarK = this.c.k(edVar);
                eaVarK.o(i2);
                eaVarK.n(obj);
                eaVarK.m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ix af(eo eoVar) {
        return new ix(eoVar.b(), eoVar.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ag(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final void A() {
        ad();
        this.m.c(j(), 1);
        this.c.A();
        Collections.emptyList();
    }

    public final void X() {
        ad();
        Z();
        aa(null, false);
        ab(0, 0);
    }

    public final void b(SurfaceHolder surfaceHolder) {
        ad();
        Z();
        if (surfaceHolder != null) {
            ad();
            ae(2, 8, null);
        }
        this.w = surfaceHolder;
        if (surfaceHolder == null) {
            aa(null, false);
            ab(0, 0);
            return;
        }
        surfaceHolder.addCallback(this.d);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            aa(null, false);
            ab(0, 0);
        } else {
            aa(surface, false);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            ab(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public final void c(gl glVar) {
        ary.t(glVar);
        this.k.G(glVar);
    }

    public final void d(gl glVar) {
        this.k.H(glVar);
    }

    public final void e(afk afkVar) {
        ary.t(afkVar);
        this.e.add(afkVar);
    }

    public final void f(afk afkVar) {
        this.e.remove(afkVar);
    }

    public final int g() {
        ad();
        return this.c.f();
    }

    @Deprecated
    public final void h(ty tyVar) {
        ad();
        List<ty> listSingletonList = Collections.singletonList(tyVar);
        ad();
        this.c.z(listSingletonList);
        ad();
        boolean zJ = j();
        int iC = this.m.c(zJ, 2);
        ac(zJ, iC, ag(zJ, iC));
        this.c.g();
    }

    public final void i(boolean z) {
        ad();
        int iC = this.m.c(z, g());
        ac(z, iC, ag(z, iC));
    }

    public final boolean j() {
        ad();
        return this.c.i();
    }

    public final void k() {
        ad();
        this.l.a(false);
        this.n.d();
        this.o.b(false);
        this.p.b(false);
        this.m.d();
        this.c.j();
        Z();
        Surface surface = this.t;
        if (surface != null) {
            if (this.u) {
                surface.release();
            }
            this.t = null;
        }
        Collections.emptyList();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final int l() {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final int m() {
        ad();
        return this.c.m();
    }

    public final long n() {
        ad();
        return this.c.n();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final long o() {
        ad();
        return this.c.o();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final long p() {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final boolean q() {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final int r() {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final int s() {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final long t() {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final es u() {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final void y(int i) {
        ad();
        this.k.K();
        this.c.y(i);
    }
}
