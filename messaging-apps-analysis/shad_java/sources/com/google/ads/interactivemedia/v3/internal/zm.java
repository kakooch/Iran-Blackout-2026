package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.SystemClock;
import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class zm implements Runnable, act {
    final /* synthetic */ zn a;
    private final Uri b;
    private final ada c = new ada("DefaultHlsPlaylistTracker:MediaPlaylist");
    private final add<zu> d;
    private zt e;
    private long f;
    private long g;
    private long h;
    private long i;
    private boolean j;
    private IOException k;

    public zm(zn znVar, Uri uri) {
        this.a = znVar;
        this.b = uri;
        this.d = new add<>(znVar.p.a(), uri, 4, znVar.f);
    }

    private final void i() {
        this.c.e(this.d, this, this.a.q.a(this.d.c));
        this.a.g.d(new to(this.d.b), this.d.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(zt ztVar, to toVar) {
        zt ztVar2 = this.e;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f = jElapsedRealtime;
        zt ztVarQ = zn.q(this.a, ztVar2, ztVar);
        this.e = ztVarQ;
        if (ztVarQ != ztVar2) {
            this.k = null;
            this.g = jElapsedRealtime;
            zn.r(this.a, this.b, ztVarQ);
        } else if (!ztVarQ.j) {
            long j = ztVar.f;
            int size = ztVar.m.size();
            zt ztVar3 = this.e;
            if (j + size < ztVar3.f) {
                this.k = new aaa();
                zn.p(this.a, this.b, -9223372036854775807L);
            } else {
                double d = jElapsedRealtime - this.g;
                double dA = bi.a(ztVar3.h);
                double dS = zn.s(this.a);
                Double.isNaN(dA);
                if (d > dA * dS) {
                    this.k = new aab();
                    new tt(4);
                    long jB = acj.b(new acr(this.k, 1));
                    zn.p(this.a, this.b, jB);
                    if (jB != -9223372036854775807L) {
                        k(jB);
                    }
                }
            }
        }
        zt ztVar4 = this.e;
        this.h = jElapsedRealtime + bi.a(ztVar4 != ztVar2 ? ztVar4.h : ztVar4.h / 2);
        if (!this.b.equals(this.a.l) || this.e.j) {
            return;
        }
        d();
    }

    private final boolean k(long j) {
        this.i = SystemClock.elapsedRealtime() + j;
        return this.b.equals(this.a.l) && !zn.u(this.a);
    }

    public final zt a() {
        return this.e;
    }

    public final boolean b() {
        int i;
        if (this.e == null) {
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jMax = Math.max(30000L, bi.a(this.e.n));
        zt ztVar = this.e;
        return ztVar.j || (i = ztVar.a) == 2 || i == 1 || this.f + jMax > jElapsedRealtime;
    }

    public final void c() {
        this.c.h();
    }

    public final void d() {
        this.i = 0L;
        if (this.j || this.c.f() || this.c.c()) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime >= this.h) {
            i();
        } else {
            this.j = true;
            this.a.i.postDelayed(this, this.h - jElapsedRealtime);
        }
    }

    public final void e() throws IOException {
        this.c.a();
        IOException iOException = this.k;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j = false;
        i();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ acu v(acw acwVar, long j, long j2, IOException iOException, int i) {
        acu acuVarB;
        add addVar = (add) acwVar;
        long j3 = addVar.a;
        addVar.e();
        addVar.f();
        addVar.d();
        to toVar = new to();
        new tt(addVar.c);
        acr acrVar = new acr(iOException, i);
        long jB = acj.b(acrVar);
        boolean zK = zn.p(this.a, this.b, jB) || jB == -9223372036854775807L;
        if (jB != -9223372036854775807L) {
            zK |= k(jB);
        }
        if (zK) {
            long jC = acj.c(acrVar);
            acuVarB = jC != -9223372036854775807L ? ada.b(false, jC) : ada.b;
        } else {
            acuVarB = ada.a;
        }
        this.a.g.m(toVar, addVar.c, iOException, !acuVarB.a());
        return acuVarB;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ void w(acw acwVar, long j, long j2, boolean z) {
        add addVar = (add) acwVar;
        long j3 = addVar.a;
        addVar.e();
        addVar.f();
        addVar.d();
        this.a.g.j(new to(), 4);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ void x(acw acwVar, long j, long j2) {
        add addVar = (add) acwVar;
        zu zuVar = (zu) addVar.a();
        addVar.e();
        addVar.f();
        addVar.d();
        to toVar = new to();
        if (zuVar instanceof zt) {
            j((zt) zuVar, toVar);
            this.a.g.g(toVar, 4);
        } else {
            this.k = new dt("Loaded playlist has unexpected type.");
            this.a.g.m(toVar, 4, this.k, true);
        }
    }
}
