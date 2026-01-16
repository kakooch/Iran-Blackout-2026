package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.executors.SynchronizedBlockingExecutor;
import io.appmetrica.analytics.networktasks.internal.AllHostsExponentialBackoffPolicy;
import io.appmetrica.analytics.networktasks.internal.DefaultResponseValidityChecker;
import io.appmetrica.analytics.networktasks.internal.FinalConfigProvider;
import io.appmetrica.analytics.networktasks.internal.FullUrlFormer;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import io.appmetrica.analytics.networktasks.internal.RequestDataHolder;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import ir.nasim.AbstractC10360bX0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Bl {
    public final Cl a;
    public volatile NetworkTask b;

    public Bl(Cl cl) {
        this.a = cl;
    }

    public final Context b() {
        return this.a.a;
    }

    public final synchronized NetworkTask c() {
        NetworkTask networkTask;
        try {
            if (g()) {
                if (this.b == null) {
                    C2425al c2425alD = d();
                    C2732nd c2732nd = C2732nd.a;
                    Wk wk = new Wk(new C2995yd(), C2586ha.C.m());
                    FinalConfigProvider finalConfigProvider = new FinalConfigProvider(c2425alD);
                    this.b = new NetworkTask(new SynchronizedBlockingExecutor(), new C2823r9(this.a.a), new AllHostsExponentialBackoffPolicy(C2732nd.a.a(EnumC2684ld.STARTUP)), new C3027zl(this, new Qk(), new FullUrlFormer(wk, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), AbstractC10360bX0.m(), C2732nd.c);
                }
                networkTask = this.b;
            } else {
                networkTask = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return networkTask;
    }

    public final C2425al d() {
        return (C2425al) this.a.l.a();
    }

    public final C2549fl e() {
        C2549fl c2549fl;
        Hk hk = this.a.l;
        synchronized (hk) {
            c2549fl = hk.c.a;
        }
        return c2549fl;
    }

    public final void f() {
        C2549fl c2549fl;
        Hk hk = this.a.l;
        synchronized (hk) {
            c2549fl = hk.c.a;
        }
        C2500dl c2500dlA = c2549fl.a();
        ln lnVar = this.a.n;
        String str = c2549fl.d;
        lnVar.getClass();
        if (!ln.a(str)) {
            c2500dlA.a.a = this.a.m.a().id;
        }
        String str2 = c2549fl.a;
        if (str2 == null || str2.length() == 0) {
            c2500dlA.b = this.a.h.a();
            c2500dlA.c = "";
        }
        List<String> list = this.a.c.e;
        if (list == null || !(!list.isEmpty())) {
            list = null;
        }
        C2620il c2620il = c2500dlA.a;
        c2620il.g = list;
        C2549fl c2549fl2 = new C2549fl(c2500dlA.b, c2500dlA.c, new C2644jl(c2620il));
        b(c2549fl2);
        a(c2549fl2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005c A[PHI: r1
      0x005c: PHI (r1v4 boolean) = (r1v3 boolean), (r1v7 boolean), (r1v7 boolean) binds: [B:12:0x0025, B:21:0x0057, B:22:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean g() {
        /*
            r8 = this;
            monitor-enter(r8)
            io.appmetrica.analytics.impl.fl r0 = r8.e()     // Catch: java.lang.Throwable -> L22
            java.util.Set r1 = io.appmetrica.analytics.impl.AbstractC2450bl.a     // Catch: java.lang.Throwable -> L22
            boolean r1 = r0.w     // Catch: java.lang.Throwable -> L22
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L24
            long r4 = r0.o     // Catch: java.lang.Throwable -> L22
            io.appmetrica.analytics.impl.Dl r1 = r0.A     // Catch: java.lang.Throwable -> L22
            int r1 = r1.a     // Catch: java.lang.Throwable -> L22
            long r6 = (long) r1     // Catch: java.lang.Throwable -> L22
            long r4 = r4 + r6
            io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider r1 = io.appmetrica.analytics.impl.AbstractC2450bl.b     // Catch: java.lang.Throwable -> L22
            long r6 = r1.currentTimeSeconds()     // Catch: java.lang.Throwable -> L22
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 <= 0) goto L20
            goto L24
        L20:
            r1 = r2
            goto L25
        L22:
            r0 = move-exception
            goto L5f
        L24:
            r1 = r3
        L25:
            if (r1 != 0) goto L5c
            java.lang.String r1 = r0.d     // Catch: java.lang.Throwable -> L22
            boolean r1 = io.appmetrica.analytics.impl.AbstractC2450bl.a(r1)     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L40
            java.lang.String r1 = r0.a     // Catch: java.lang.Throwable -> L22
            boolean r1 = io.appmetrica.analytics.impl.AbstractC2450bl.a(r1)     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L40
            java.lang.String r1 = r0.b     // Catch: java.lang.Throwable -> L22
            boolean r1 = io.appmetrica.analytics.impl.AbstractC2450bl.a(r1)     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L40
            r2 = r3
        L40:
            r1 = r2 ^ 1
            io.appmetrica.analytics.impl.Cl r2 = r8.a     // Catch: java.lang.Throwable -> L22
            io.appmetrica.analytics.impl.T3 r2 = r2.k     // Catch: java.lang.Throwable -> L22
            io.appmetrica.analytics.impl.al r4 = r8.d()     // Catch: java.lang.Throwable -> L22
            java.util.Map r4 = r4.h     // Catch: java.lang.Throwable -> L22
            io.appmetrica.analytics.impl.Cl r5 = r8.a     // Catch: java.lang.Throwable -> L22
            io.appmetrica.analytics.impl.Q3 r5 = r5.j     // Catch: java.lang.Throwable -> L22
            r2.getClass()     // Catch: java.lang.Throwable -> L22
            boolean r0 = io.appmetrica.analytics.impl.T3.a(r4, r0, r5)     // Catch: java.lang.Throwable -> L22
            if (r1 != 0) goto L5c
            if (r0 != 0) goto L5c
            goto L5d
        L5c:
            r3 = r1
        L5d:
            monitor-exit(r8)
            return r3
        L5f:
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.Bl.g():boolean");
    }

    public final synchronized void h() {
        this.b = null;
    }

    public final W4 a() {
        return this.a.f;
    }

    public final synchronized void b(C2549fl c2549fl) {
        this.a.l.a(c2549fl);
        C2525el c2525el = this.a.g;
        c2525el.b.a(c2549fl.a);
        c2525el.b.b(c2549fl.b);
        c2525el.a.save(c2549fl.c);
        this.a.e.a(c2549fl);
    }

    public final synchronized boolean a(List<String> list, Map<String, String> map) {
        return !AbstractC2450bl.a(e(), list, map, new Al(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.appmetrica.analytics.impl.C2549fl a(io.appmetrica.analytics.impl.C2475cl r10, io.appmetrica.analytics.impl.C2425al r11, long r12) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.Bl.a(io.appmetrica.analytics.impl.cl, io.appmetrica.analytics.impl.al, long):io.appmetrica.analytics.impl.fl");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037 A[Catch: all -> 0x0032, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:14:0x0037, B:16:0x003e), top: B:23:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(io.appmetrica.analytics.impl.C2475cl r4, io.appmetrica.analytics.impl.C2425al r5, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = io.appmetrica.analytics.impl.hn.a(r6)     // Catch: java.lang.Throwable -> L32
            if (r0 != 0) goto L34
            java.lang.String r0 = "Date"
            java.lang.Object r6 = io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils.getFromMapIgnoreCase(r6, r0)     // Catch: java.lang.Throwable -> L32
            java.util.List r6 = (java.util.List) r6     // Catch: java.lang.Throwable -> L32
            boolean r0 = io.appmetrica.analytics.impl.hn.a(r6)     // Catch: java.lang.Throwable -> L32
            if (r0 != 0) goto L34
            r0 = 0
            java.lang.Object r6 = r6.get(r0)     // Catch: java.lang.Throwable -> L34
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L34
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> L34
            java.lang.String r1 = "E, d MMM yyyy HH:mm:ss z"
            java.util.Locale r2 = java.util.Locale.US     // Catch: java.lang.Throwable -> L34
            r0.<init>(r1, r2)     // Catch: java.lang.Throwable -> L34
            java.util.Date r6 = r0.parse(r6)     // Catch: java.lang.Throwable -> L34
            long r0 = r6.getTime()     // Catch: java.lang.Throwable -> L34
            java.lang.Long r6 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L34
            goto L35
        L32:
            r4 = move-exception
            goto L56
        L34:
            r6 = 0
        L35:
            if (r6 == 0) goto L3c
            long r0 = r6.longValue()     // Catch: java.lang.Throwable -> L32
            goto L3e
        L3c:
            r0 = 0
        L3e:
            java.lang.Long r6 = r4.l     // Catch: java.lang.Throwable -> L32
            io.appmetrica.analytics.impl.jj r2 = io.appmetrica.analytics.impl.AbstractC2618ij.a     // Catch: java.lang.Throwable -> L32
            r2.a(r0, r6)     // Catch: java.lang.Throwable -> L32
            io.appmetrica.analytics.impl.fl r4 = r3.a(r4, r5, r0)     // Catch: java.lang.Throwable -> L32
            r3.h()     // Catch: java.lang.Throwable -> L32
            r3.b(r4)     // Catch: java.lang.Throwable -> L32
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L32
            monitor-exit(r3)
            r3.a(r4)
            return
        L56:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.Bl.a(io.appmetrica.analytics.impl.cl, io.appmetrica.analytics.impl.al, java.util.Map):void");
    }

    public final void a(C2549fl c2549fl) {
        ArrayList arrayList;
        Cl cl = this.a;
        Ek ek = cl.d;
        String str = cl.b;
        synchronized (ek.a.b) {
            try {
                Gk gk = ek.a;
                gk.c = c2549fl;
                Collection collection = (Collection) gk.a.a.get(str);
                if (collection == null) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = new ArrayList(collection);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Pk) it.next()).a(c2549fl);
        }
    }

    public final void a(Ik ik) {
        synchronized (this) {
            this.b = null;
        }
        Cl cl = this.a;
        cl.d.a(cl.f.a, ik, e());
    }

    public final synchronized void a(Yk yk) {
        try {
            this.a.l.a(yk);
            C2425al c2425alD = d();
            if (c2425alD.k) {
                List list = c2425alD.j;
                if (list != null && !list.isEmpty()) {
                    if (!hn.a(list, c2425alD.e)) {
                        C2500dl c2500dlA = e().a();
                        C2620il c2620il = c2500dlA.a;
                        c2620il.g = list;
                        C2549fl c2549fl = new C2549fl(c2500dlA.b, c2500dlA.c, new C2644jl(c2620il));
                        b(c2549fl);
                        a(c2549fl);
                    }
                } else {
                    if (c2425alD.e != null && (!r5.isEmpty())) {
                        C2500dl c2500dlA2 = e().a();
                        C2620il c2620il2 = c2500dlA2.a;
                        c2620il2.g = null;
                        C2549fl c2549fl2 = new C2549fl(c2500dlA2.b, c2500dlA2.c, new C2644jl(c2620il2));
                        b(c2549fl2);
                        a(c2549fl2);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
