package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import ir.nasim.AbstractC9766aX0;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: io.appmetrica.analytics.impl.d5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2484d5 implements Ja, InterfaceC2992ya, InterfaceC2752o9, Bg {
    public final Context a;
    public final W4 b;
    public final C2661ke c;
    public final C2733ne d;
    public final Kh e;
    public final I6 f;
    public final Ih g;
    public final S8 h;
    public final C2429b0 i;
    public final C2454c0 j;
    public final Sj k;
    public final C2544fg l;
    public final F8 m;
    public final PublicLogger n;
    public final C2537f9 o;
    public final Y4 p;
    public final C2680l9 q;
    public final A5 r;
    public final D3 s;
    public final TimePassedChecker t;
    public final He u;
    public final tn v;
    public final Kj w;

    public C2484d5(Context context, C2549fl c2549fl, W4 w4, C3010z4 c3010z4, InterfaceC3022zg interfaceC3022zg, AbstractC2434b5 abstractC2434b5) {
        this(context, w4, new C2454c0(), new TimePassedChecker(), new C2605i5(context, w4, c3010z4, abstractC2434b5, c2549fl, interfaceC3022zg, C2586ha.h().u().d(), PackageManagerUtils.getAppVersionCodeInt(context), C2586ha.h().i()));
    }

    public final boolean A() {
        Cg cg = (Cg) this.l.a();
        return cg.o && this.t.didTimePassSeconds(this.o.l, cg.u, "should force send permissions");
    }

    public final boolean B() {
        C2549fl c2549fl;
        He he = this.u;
        he.h.a(he.a);
        boolean z = ((Ee) he.c()).d;
        C2544fg c2544fg = this.l;
        synchronized (c2544fg) {
            c2549fl = c2544fg.c.a;
        }
        return !(z && c2549fl.q);
    }

    public void C() {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Pk
    public final void a(Ik ik, C2549fl c2549fl) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2992ya
    public final W4 b() {
        return this.b;
    }

    public CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MANUAL;
    }

    public final void d() {
        C2429b0 c2429b0 = this.i;
        synchronized (c2429b0) {
            c2429b0.a = new C2755oc();
        }
        this.j.a(this.i.a(), this.c);
    }

    public final synchronized void e() {
        this.e.b();
    }

    public final D3 f() {
        return this.s;
    }

    public final C2661ke g() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2992ya
    public final Context getContext() {
        return this.a;
    }

    public final I6 h() {
        return this.f;
    }

    public final F8 i() {
        return this.m;
    }

    public final S8 j() {
        return this.h;
    }

    public final C2537f9 k() {
        return this.o;
    }

    public final C2680l9 l() {
        return this.q;
    }

    public final Cg m() {
        return (Cg) this.l.a();
    }

    public final String n() {
        return this.c.i();
    }

    public final PublicLogger o() {
        return this.n;
    }

    public final L8 p() {
        return this.r;
    }

    public final C2733ne q() {
        return this.d;
    }

    public final Kj r() {
        return this.w;
    }

    public final Sj s() {
        return this.k;
    }

    public final C2549fl t() {
        C2549fl c2549fl;
        C2544fg c2544fg = this.l;
        synchronized (c2544fg) {
            c2549fl = c2544fg.c.a;
        }
        return c2549fl;
    }

    public final tn u() {
        return this.v;
    }

    public final void v() {
        C2537f9 c2537f9 = this.o;
        int i = c2537f9.k;
        c2537f9.m = i;
        c2537f9.a.a(i).b();
    }

    public final void w() {
        int iOptInt;
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        tn tnVar = this.v;
        synchronized (tnVar) {
            iOptInt = tnVar.a.a().optInt("last_migration_api_level", 0);
        }
        if (iOptInt < libraryApiLevel) {
            this.p.getClass();
            Iterator it = AbstractC9766aX0.e(new C2409a5(this)).iterator();
            while (it.hasNext()) {
                ((Z4) it.next()).a(iOptInt);
            }
            this.v.b(libraryApiLevel);
        }
    }

    public final boolean x() {
        Cg cg = (Cg) this.l.a();
        return cg.o && cg.isIdentifiersValid() && this.t.didTimePassSeconds(this.o.l, cg.t, "need to check permissions");
    }

    public final boolean y() {
        C2537f9 c2537f9 = this.o;
        return c2537f9.m < c2537f9.k && ((Cg) this.l.a()).p && ((Cg) this.l.a()).isIdentifiersValid();
    }

    public final void z() {
        C2544fg c2544fg = this.l;
        synchronized (c2544fg) {
            c2544fg.a = null;
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(Q5 q5) {
        String string;
        if (AbstractC2776p9.d.contains(Ta.a(q5.d))) {
            StringBuilder sb = new StringBuilder("Event received on service: ");
            sb.append(q5.getName());
            if (AbstractC2776p9.f.contains(Ta.a(q5.d)) && !TextUtils.isEmpty(q5.getValue())) {
                sb.append(" with value ");
                sb.append(q5.getValue());
            }
            string = sb.toString();
        } else {
            string = null;
        }
        if (string != null) {
            this.n.info(string, new Object[0]);
        }
        String str = this.b.b;
        if (TextUtils.isEmpty(str) || "-1".equals(str)) {
            return;
        }
        this.g.a(q5, new Hh());
    }

    public final void b(Q5 q5) {
        this.i.a(q5.f);
        C2404a0 c2404a0A = this.i.a();
        C2454c0 c2454c0 = this.j;
        C2661ke c2661ke = this.c;
        synchronized (c2454c0) {
            if (c2404a0A.b > c2661ke.d().b) {
                c2661ke.a(c2404a0A).b();
                this.n.info("Save new app environment for %s. Value: %s", this.b, c2404a0A.a);
            }
        }
    }

    public C2484d5(Context context, W4 w4, C2454c0 c2454c0, TimePassedChecker timePassedChecker, C2605i5 c2605i5) {
        this.a = context.getApplicationContext();
        this.b = w4;
        this.j = c2454c0;
        this.t = timePassedChecker;
        tn tnVarF = c2605i5.f();
        this.v = tnVarF;
        this.u = C2586ha.h().q();
        C2544fg c2544fgA = c2605i5.a(this);
        this.l = c2544fgA;
        PublicLogger publicLoggerA = c2605i5.d().a();
        this.n = publicLoggerA;
        C2661ke c2661keA = c2605i5.e().a();
        this.c = c2661keA;
        this.d = C2586ha.h().w();
        C2429b0 c2429b0A = c2454c0.a(w4, publicLoggerA, c2661keA);
        this.i = c2429b0A;
        this.m = c2605i5.a();
        I6 i6B = c2605i5.b(this);
        this.f = i6B;
        Kh khD = c2605i5.d(this);
        this.e = khD;
        this.p = C2605i5.b();
        C2731nc c2731ncA = C2605i5.a(i6B, c2544fgA);
        A5 a5A = C2605i5.a(i6B);
        this.r = a5A;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c2731ncA);
        arrayList.add(a5A);
        this.q = C2605i5.a(arrayList, this);
        w();
        Sj sjA = C2605i5.a(this, tnVarF, new C2459c5(this));
        this.k = sjA;
        publicLoggerA.info("Read app environment for component %s. Value: %s", w4.toString(), c2429b0A.a().a);
        Kj kjC = c2605i5.c();
        this.w = kjC;
        this.o = c2605i5.a(c2661keA, tnVarF, sjA, i6B, c2429b0A, kjC, khD);
        S8 s8C = C2605i5.c(this);
        this.h = s8C;
        this.g = C2605i5.a(this, s8C);
        this.s = c2605i5.a(c2661keA);
        i6B.d();
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.InterfaceC2992ya
    public synchronized void a(C3010z4 c3010z4) {
        try {
            this.l.a(c3010z4);
            if (Boolean.TRUE.equals(c3010z4.h)) {
                this.n.setEnabled(true);
            } else {
                if (Boolean.FALSE.equals(c3010z4.h)) {
                    this.n.setEnabled(false);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Pk
    public synchronized void a(C2549fl c2549fl) {
        this.l.a(c2549fl);
        this.q.b();
    }

    public final void a(String str) {
        this.c.j(str).b();
    }
}
