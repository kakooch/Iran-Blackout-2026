package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class zn implements aad, act {
    public static final zy a = zl.a;
    private final zx b;
    private adc<zu> f;
    private ug g;
    private ada h;
    private Handler i;
    private aac j;
    private zr k;
    private Uri l;
    private zt m;
    private boolean n;
    private final yg p;
    private final acj q;
    private final double e = 3.5d;
    private final List<zz> d = new ArrayList();
    private final HashMap<Uri, zm> c = new HashMap<>();
    private long o = -9223372036854775807L;

    public zn(yg ygVar, acj acjVar, zx zxVar) {
        this.p = ygVar;
        this.b = zxVar;
        this.q = acjVar;
    }

    private static zs A(zt ztVar, zt ztVar2) {
        int i = (int) (ztVar2.f - ztVar.f);
        List<zs> list = ztVar.m;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    static /* synthetic */ boolean p(zn znVar, Uri uri, long j) {
        int size = znVar.d.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            z |= !znVar.d.get(i).s(uri, j);
        }
        return z;
    }

    static /* synthetic */ zt q(zn znVar, zt ztVar, zt ztVar2) {
        long jB;
        int i;
        zs zsVarA;
        int size;
        int size2;
        if (ztVar != null) {
            long j = ztVar2.f;
            long j2 = ztVar.f;
            if (j <= j2 && (j < j2 || ((size = ztVar2.m.size()) <= (size2 = ztVar.m.size()) && (size != size2 || !ztVar2.j || ztVar.j)))) {
                return (!ztVar2.j || ztVar.j) ? ztVar : new zt(ztVar.a, ztVar.p, ztVar.q, ztVar.b, ztVar.c, ztVar.d, ztVar.e, ztVar.f, ztVar.g, ztVar.h, ztVar.i, ztVar.r, true, ztVar.k, ztVar.l, ztVar.m, ztVar.o, null, null, null);
            }
        }
        if (ztVar2.k) {
            jB = ztVar2.c;
        } else {
            zt ztVar3 = znVar.m;
            jB = ztVar3 != null ? ztVar3.c : 0L;
            if (ztVar != null) {
                int size3 = ztVar.m.size();
                zs zsVarA2 = A(ztVar, ztVar2);
                if (zsVarA2 != null) {
                    jB = ztVar.c + zsVarA2.e;
                } else if (size3 == ztVar2.f - ztVar.f) {
                    jB = ztVar.b();
                }
            }
        }
        long j3 = jB;
        if (ztVar2.d) {
            i = ztVar2.e;
        } else {
            zt ztVar4 = znVar.m;
            i = ztVar4 != null ? ztVar4.e : 0;
            if (ztVar != null && (zsVarA = A(ztVar, ztVar2)) != null) {
                i = (ztVar.e + zsVarA.d) - ztVar2.m.get(0).d;
            }
        }
        return new zt(ztVar2.a, ztVar2.p, ztVar2.q, ztVar2.b, j3, true, i, ztVar2.f, ztVar2.g, ztVar2.h, ztVar2.i, ztVar2.r, ztVar2.j, ztVar2.k, ztVar2.l, ztVar2.m, ztVar2.o, null, null, null);
    }

    static /* synthetic */ void r(zn znVar, Uri uri, zt ztVar) {
        if (uri.equals(znVar.l)) {
            if (znVar.m == null) {
                znVar.n = !ztVar.j;
                znVar.o = ztVar.c;
            }
            znVar.m = ztVar;
            znVar.j.y(ztVar);
        }
        int size = znVar.d.size();
        for (int i = 0; i < size; i++) {
            znVar.d.get(i).r();
        }
    }

    static /* synthetic */ double s(zn znVar) {
        return 3.5d;
    }

    static /* synthetic */ boolean u(zn znVar) {
        List<zq> list = znVar.k.c;
        int size = list.size();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            zm zmVar = znVar.c.get(list.get(i).a);
            if (jElapsedRealtime > zmVar.i) {
                znVar.l = zmVar.b;
                zmVar.d();
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aad
    public final void a(Uri uri, ug ugVar, aac aacVar) {
        this.i = aeu.k();
        this.g = ugVar;
        this.j = aacVar;
        add addVar = new add(this.p.a(), uri, 4, this.b.a());
        ary.q(this.h == null);
        ada adaVar = new ada("DefaultHlsPlaylistTracker:MasterPlaylist");
        this.h = adaVar;
        adaVar.e(addVar, this, this.q.a(addVar.c));
        ugVar.d(new to(addVar.b), addVar.c);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aad
    public final void b() {
        this.l = null;
        this.m = null;
        this.k = null;
        this.o = -9223372036854775807L;
        this.h.h();
        this.h = null;
        Iterator<zm> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.i.removeCallbacksAndMessages(null);
        this.i = null;
        this.c.clear();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aad
    public final void c(zz zzVar) {
        this.d.add(zzVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aad
    public final void d(zz zzVar) {
        this.d.remove(zzVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aad
    public final zr e() {
        return this.k;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aad
    public final zt f(Uri uri, boolean z) {
        zt ztVarA = this.c.get(uri).a();
        if (ztVarA != null && z && !uri.equals(this.l)) {
            List<zq> list = this.k.c;
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                if (uri.equals(list.get(i).a)) {
                    zt ztVar = this.m;
                    if (ztVar == null || !ztVar.j) {
                        this.l = uri;
                        this.c.get(uri).d();
                    }
                } else {
                    i++;
                }
            }
        }
        return ztVarA;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aad
    public final long g() {
        return this.o;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aad
    public final boolean h(Uri uri) {
        return this.c.get(uri).b();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aad
    public final void i() throws IOException {
        ada adaVar = this.h;
        if (adaVar != null) {
            adaVar.a();
        }
        Uri uri = this.l;
        if (uri != null) {
            j(uri);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aad
    public final void j(Uri uri) throws IOException {
        this.c.get(uri).e();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aad
    public final void k(Uri uri) {
        this.c.get(uri).d();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aad
    public final boolean l() {
        return this.n;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ acu v(acw acwVar, long j, long j2, IOException iOException, int i) {
        add addVar = (add) acwVar;
        long j3 = addVar.a;
        addVar.e();
        addVar.f();
        addVar.d();
        to toVar = new to();
        new tt(addVar.c);
        long jC = acj.c(new acr(iOException, i));
        boolean z = jC == -9223372036854775807L;
        this.g.m(toVar, addVar.c, iOException, z);
        return z ? ada.b : ada.b(false, jC);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ void w(acw acwVar, long j, long j2, boolean z) {
        add addVar = (add) acwVar;
        long j3 = addVar.a;
        addVar.e();
        addVar.f();
        addVar.d();
        this.g.j(new to(), 4);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ void x(acw acwVar, long j, long j2) {
        add addVar = (add) acwVar;
        zu zuVar = (zu) addVar.a();
        boolean z = zuVar instanceof zt;
        zr zrVarB = z ? zr.b(zuVar.p) : (zr) zuVar;
        this.k = zrVarB;
        this.f = this.b.b(zrVarB);
        this.l = zrVarB.c.get(0).a;
        List<Uri> list = zrVarB.b;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Uri uri = list.get(i);
            this.c.put(uri, new zm(this, uri));
        }
        zm zmVar = this.c.get(this.l);
        addVar.e();
        addVar.f();
        addVar.d();
        to toVar = new to();
        if (z) {
            zmVar.j((zt) zuVar, toVar);
        } else {
            zmVar.d();
        }
        this.g.g(toVar, 4);
    }
}
