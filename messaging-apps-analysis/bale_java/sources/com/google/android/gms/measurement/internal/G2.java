package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.AbstractC13016fZ6;
import ir.nasim.AbstractC23966xo8;
import ir.nasim.AbstractC24556yo8;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Bo8;
import ir.nasim.C17399mt8;
import ir.nasim.Cr8;
import ir.nasim.Do8;
import ir.nasim.KJ;
import ir.nasim.Qh8;
import ir.nasim.Rs8;
import ir.nasim.WW0;
import ir.nasim.Wt8;
import ir.nasim.Xh8;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class G2 extends AbstractC2311u1 {
    protected F2 c;
    private Bo8 d;
    private final Set e;
    private boolean f;
    private final AtomicReference g;
    private final Object h;
    private Xh8 i;
    private int j;
    private final AtomicLong k;
    private long l;
    private int m;
    final l4 n;
    protected boolean o;
    private final e4 p;

    protected G2(H1 h1) {
        super(h1);
        this.e = new CopyOnWriteArraySet();
        this.h = new Object();
        this.o = true;
        this.p = new C2317v2(this);
        this.g = new AtomicReference();
        this.i = new Xh8(null, null);
        this.j = 100;
        this.l = -1L;
        this.m = 100;
        this.k = new AtomicLong(0L);
        this.n = new l4(h1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(Boolean bool, boolean z) {
        h();
        i();
        this.a.b().q().b("Setting app measurement enabled (FE)", bool);
        this.a.F().s(bool);
        if (z) {
            C2292q1 c2292q1F = this.a.F();
            H1 h1 = c2292q1F.a;
            c2292q1F.h();
            SharedPreferences.Editor editorEdit = c2292q1F.o().edit();
            if (bool != null) {
                editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit.remove("measurement_enabled_from_api");
            }
            editorEdit.apply();
        }
        if (this.a.p() || !(bool == null || bool.booleanValue())) {
            P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        h();
        String strA = this.a.F().m.a();
        if (strA != null) {
            if ("unset".equals(strA)) {
                M("app", "_npa", null, this.a.c().currentTimeMillis());
            } else {
                M("app", "_npa", Long.valueOf(true != "true".equals(strA) ? 0L : 1L), this.a.c().currentTimeMillis());
            }
        }
        if (!this.a.o() || !this.o) {
            this.a.b().q().a("Updating Scion state (FE)");
            this.a.L().w();
            return;
        }
        this.a.b().q().a("Recording app launch after enabling measurement for the first time (FE)");
        f0();
        C17399mt8.b();
        if (this.a.z().B(null, S0.f0)) {
            this.a.M().d.a();
        }
        this.a.a().z(new RunnableC2258j2(this));
    }

    static /* bridge */ /* synthetic */ void b0(G2 g2, Xh8 xh8, Xh8 xh82) {
        Qh8[] qh8Arr = {Qh8.ANALYTICS_STORAGE, Qh8.AD_STORAGE};
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= 2) {
                break;
            }
            Qh8 qh8 = qh8Arr[i];
            if (!xh82.i(qh8) && xh8.i(qh8)) {
                z = true;
                break;
            }
            i++;
        }
        boolean zL = xh8.l(xh82, Qh8.ANALYTICS_STORAGE, Qh8.AD_STORAGE);
        if (z || zL) {
            g2.a.B().v();
        }
    }

    static /* synthetic */ void c0(G2 g2, Xh8 xh8, int i, long j, boolean z, boolean z2) {
        g2.h();
        g2.i();
        if (j <= g2.l && Xh8.j(g2.m, i)) {
            g2.a.b().u().b("Dropped out-of-date consent setting, proposed settings", xh8);
            return;
        }
        C2292q1 c2292q1F = g2.a.F();
        H1 h1 = c2292q1F.a;
        c2292q1F.h();
        if (!c2292q1F.w(i)) {
            g2.a.b().u().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
            return;
        }
        SharedPreferences.Editor editorEdit = c2292q1F.o().edit();
        editorEdit.putString("consent_settings", xh8.h());
        editorEdit.putInt("consent_source", i);
        editorEdit.apply();
        g2.l = j;
        g2.m = i;
        g2.a.L().t(z);
        if (z2) {
            g2.a.L().S(new AtomicReference());
        }
    }

    protected final void A(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelable);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        this.a.a().z(new RunnableC2273m2(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    final void B(String str, String str2, long j, Object obj) {
        this.a.a().z(new RunnableC2278n2(this, str, str2, obj, j));
    }

    final void C(String str) {
        this.g.set(str);
    }

    public final void D(Bundle bundle) {
        E(bundle, this.a.c().currentTimeMillis());
    }

    public final void E(Bundle bundle, long j) {
        AbstractC3795Cj5.j(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString(CommonUrlParts.APP_ID))) {
            this.a.b().w().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove(CommonUrlParts.APP_ID);
        AbstractC3795Cj5.j(bundle2);
        AbstractC23966xo8.a(bundle2, CommonUrlParts.APP_ID, String.class, null);
        AbstractC23966xo8.a(bundle2, "origin", String.class, null);
        AbstractC23966xo8.a(bundle2, "name", String.class, null);
        AbstractC23966xo8.a(bundle2, "value", Object.class, null);
        AbstractC23966xo8.a(bundle2, "trigger_event_name", String.class, null);
        AbstractC23966xo8.a(bundle2, "trigger_timeout", Long.class, 0L);
        AbstractC23966xo8.a(bundle2, "timed_out_event_name", String.class, null);
        AbstractC23966xo8.a(bundle2, "timed_out_event_params", Bundle.class, null);
        AbstractC23966xo8.a(bundle2, "triggered_event_name", String.class, null);
        AbstractC23966xo8.a(bundle2, "triggered_event_params", Bundle.class, null);
        AbstractC23966xo8.a(bundle2, "time_to_live", Long.class, 0L);
        AbstractC23966xo8.a(bundle2, "expired_event_name", String.class, null);
        AbstractC23966xo8.a(bundle2, "expired_event_params", Bundle.class, null);
        AbstractC3795Cj5.f(bundle2.getString("name"));
        AbstractC3795Cj5.f(bundle2.getString("origin"));
        AbstractC3795Cj5.j(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (this.a.N().n0(string) != 0) {
            this.a.b().r().b("Invalid conditional user property name", this.a.D().f(string));
            return;
        }
        if (this.a.N().j0(string, obj) != 0) {
            this.a.b().r().c("Invalid conditional user property value", this.a.D().f(string), obj);
            return;
        }
        Object objP = this.a.N().p(string, obj);
        if (objP == null) {
            this.a.b().r().c("Unable to normalize conditional user property value", this.a.D().f(string), obj);
            return;
        }
        AbstractC23966xo8.b(bundle2, objP);
        long j2 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name"))) {
            this.a.z();
            if (j2 > 15552000000L || j2 < 1) {
                this.a.b().r().c("Invalid conditional user property timeout", this.a.D().f(string), Long.valueOf(j2));
                return;
            }
        }
        long j3 = bundle2.getLong("time_to_live");
        this.a.z();
        if (j3 > 15552000000L || j3 < 1) {
            this.a.b().r().c("Invalid conditional user property time to live", this.a.D().f(string), Long.valueOf(j3));
        } else {
            this.a.a().z(new RunnableC2288p2(this, bundle2));
        }
    }

    public final void F(Bundle bundle, int i, long j) {
        i();
        String strG = Xh8.g(bundle);
        if (strG != null) {
            this.a.b().x().b("Ignoring invalid consent setting", strG);
            this.a.b().x().a("Valid consent values are 'granted', 'denied'");
        }
        G(Xh8.a(bundle), i, j);
    }

    public final void G(Xh8 xh8, int i, long j) {
        Xh8 xh82;
        boolean z;
        boolean zK;
        boolean z2;
        Xh8 xh8D = xh8;
        i();
        if (i != -10 && xh8.e() == null && xh8.f() == null) {
            this.a.b().x().a("Discarding empty consent settings");
            return;
        }
        synchronized (this.h) {
            try {
                xh82 = this.i;
                z = false;
                if (Xh8.j(i, this.j)) {
                    zK = xh8D.k(this.i);
                    Qh8 qh8 = Qh8.ANALYTICS_STORAGE;
                    if (xh8D.i(qh8) && !this.i.i(qh8)) {
                        z = true;
                    }
                    xh8D = xh8D.d(this.i);
                    this.i = xh8D;
                    this.j = i;
                    z2 = z;
                    z = true;
                } else {
                    zK = false;
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z) {
            this.a.b().u().b("Ignoring lower-priority consent settings, proposed settings", xh8D);
            return;
        }
        long andIncrement = this.k.getAndIncrement();
        if (zK) {
            this.g.set(null);
            this.a.a().A(new B2(this, xh8D, j, i, andIncrement, z2, xh82));
            return;
        }
        C2 c2 = new C2(this, xh8D, i, andIncrement, z2, xh82);
        if (i == 30 || i == -10) {
            this.a.a().A(c2);
        } else {
            this.a.a().z(c2);
        }
    }

    public final void H(Bo8 bo8) {
        Bo8 bo82;
        h();
        i();
        if (bo8 != null && bo8 != (bo82 = this.d)) {
            AbstractC3795Cj5.n(bo82 == null, "EventInterceptor already set.");
        }
        this.d = bo8;
    }

    public final void I(Boolean bool) {
        i();
        this.a.a().z(new A2(this, bool));
    }

    final void J(Xh8 xh8) {
        h();
        boolean z = (xh8.i(Qh8.ANALYTICS_STORAGE) && xh8.i(Qh8.AD_STORAGE)) || this.a.L().A();
        if (z != this.a.p()) {
            this.a.l(z);
            C2292q1 c2292q1F = this.a.F();
            H1 h1 = c2292q1F.a;
            c2292q1F.h();
            Boolean boolValueOf = c2292q1F.o().contains("measurement_enabled_from_api") ? Boolean.valueOf(c2292q1F.o().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || boolValueOf == null || boolValueOf.booleanValue()) {
                O(Boolean.valueOf(z), false);
            }
        }
    }

    public final void K(String str, String str2, Object obj, boolean z) {
        L("auto", "_ldl", obj, true, this.a.c().currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void L(java.lang.String r18, java.lang.String r19, java.lang.Object r20, boolean r21, long r22) {
        /*
            r17 = this;
            r6 = r17
            r2 = r19
            r0 = r20
            if (r18 != 0) goto Lb
            java.lang.String r1 = "app"
            goto Ld
        Lb:
            r1 = r18
        Ld:
            r3 = 0
            r4 = 24
            if (r21 == 0) goto L1e
            com.google.android.gms.measurement.internal.H1 r5 = r6.a
            com.google.android.gms.measurement.internal.f4 r5 = r5.N()
            int r5 = r5.n0(r2)
        L1c:
            r13 = r5
            goto L48
        L1e:
            com.google.android.gms.measurement.internal.H1 r5 = r6.a
            com.google.android.gms.measurement.internal.f4 r5 = r5.N()
            java.lang.String r7 = "user property"
            boolean r8 = r5.R(r7, r2)
            r9 = 6
            if (r8 != 0) goto L2f
        L2d:
            r13 = r9
            goto L48
        L2f:
            java.lang.String[] r8 = ir.nasim.Ao8.a
            r10 = 0
            boolean r8 = r5.N(r7, r8, r10, r2)
            if (r8 != 0) goto L3b
            r5 = 15
            goto L1c
        L3b:
            com.google.android.gms.measurement.internal.H1 r8 = r5.a
            r8.z()
            boolean r5 = r5.M(r7, r4, r2)
            if (r5 != 0) goto L47
            goto L2d
        L47:
            r13 = r3
        L48:
            r5 = 1
            if (r13 == 0) goto L71
            com.google.android.gms.measurement.internal.H1 r0 = r6.a
            com.google.android.gms.measurement.internal.f4 r0 = r0.N()
            com.google.android.gms.measurement.internal.H1 r1 = r6.a
            r1.z()
            java.lang.String r15 = r0.r(r2, r4, r5)
            if (r2 == 0) goto L60
            int r3 = r19.length()
        L60:
            r16 = r3
            com.google.android.gms.measurement.internal.H1 r0 = r6.a
            com.google.android.gms.measurement.internal.f4 r10 = r0.N()
            com.google.android.gms.measurement.internal.e4 r11 = r6.p
            r12 = 0
            java.lang.String r14 = "_ev"
            r10.B(r11, r12, r13, r14, r15, r16)
            return
        L71:
            if (r0 == 0) goto Lc7
            com.google.android.gms.measurement.internal.H1 r7 = r6.a
            com.google.android.gms.measurement.internal.f4 r7 = r7.N()
            int r11 = r7.j0(r2, r0)
            if (r11 == 0) goto Lb1
            com.google.android.gms.measurement.internal.H1 r1 = r6.a
            com.google.android.gms.measurement.internal.f4 r1 = r1.N()
            com.google.android.gms.measurement.internal.H1 r7 = r6.a
            r7.z()
            java.lang.String r13 = r1.r(r2, r4, r5)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L99
            boolean r1 = r0 instanceof java.lang.CharSequence
            if (r1 == 0) goto L97
            goto L99
        L97:
            r14 = r3
            goto La2
        L99:
            java.lang.String r0 = r20.toString()
            int r3 = r0.length()
            goto L97
        La2:
            com.google.android.gms.measurement.internal.H1 r0 = r6.a
            com.google.android.gms.measurement.internal.f4 r8 = r0.N()
            com.google.android.gms.measurement.internal.e4 r9 = r6.p
            r10 = 0
            java.lang.String r12 = "_ev"
            r8.B(r9, r10, r11, r12, r13, r14)
            return
        Lb1:
            com.google.android.gms.measurement.internal.H1 r3 = r6.a
            com.google.android.gms.measurement.internal.f4 r3 = r3.N()
            java.lang.Object r5 = r3.p(r2, r0)
            if (r5 == 0) goto Lc6
            r0 = r17
            r2 = r19
            r3 = r22
            r0.B(r1, r2, r3, r5)
        Lc6:
            return
        Lc7:
            r5 = 0
            r0 = r17
            r2 = r19
            r3 = r22
            r0.B(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.G2.L(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void M(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            ir.nasim.AbstractC3795Cj5.f(r9)
            ir.nasim.AbstractC3795Cj5.f(r10)
            r8.h()
            r8.i()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L61
            boolean r0 = r11 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L50
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L50
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            r0 = 1
            if (r0 == r10) goto L37
            r4 = 0
            goto L38
        L37:
            r4 = r2
        L38:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.H1 r0 = r8.a
            com.google.android.gms.measurement.internal.q1 r0 = r0.F()
            com.google.android.gms.measurement.internal.p1 r0 = r0.m
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L4a
            java.lang.String r11 = "true"
        L4a:
            r0.b(r11)
            r6 = r10
        L4e:
            r3 = r1
            goto L63
        L50:
            if (r11 != 0) goto L61
            com.google.android.gms.measurement.internal.H1 r10 = r8.a
            com.google.android.gms.measurement.internal.q1 r10 = r10.F()
            com.google.android.gms.measurement.internal.p1 r10 = r10.m
            java.lang.String r0 = "unset"
            r10.b(r0)
            r6 = r11
            goto L4e
        L61:
            r3 = r10
            r6 = r11
        L63:
            com.google.android.gms.measurement.internal.H1 r10 = r8.a
            boolean r10 = r10.o()
            if (r10 != 0) goto L7b
            com.google.android.gms.measurement.internal.H1 r9 = r8.a
            com.google.android.gms.measurement.internal.d1 r9 = r9.b()
            com.google.android.gms.measurement.internal.b1 r9 = r9.v()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.a(r10)
            return
        L7b:
            com.google.android.gms.measurement.internal.H1 r10 = r8.a
            boolean r10 = r10.r()
            if (r10 != 0) goto L84
            return
        L84:
            com.google.android.gms.measurement.internal.zzkw r10 = new com.google.android.gms.measurement.internal.zzkw
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.H1 r9 = r8.a
            com.google.android.gms.measurement.internal.t3 r9 = r9.L()
            r9.y(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.G2.M(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void N(Do8 do8) {
        i();
        AbstractC3795Cj5.j(do8);
        if (this.e.remove(do8)) {
            return;
        }
        this.a.b().w().a("OnEventListener had not been registered");
    }

    public final int Q(String str) {
        AbstractC3795Cj5.f(str);
        this.a.z();
        return 25;
    }

    public final Boolean R() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.a.a().r(atomicReference, 15000L, "boolean test flag value", new RunnableC2302s2(this, atomicReference));
    }

    public final Double S() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.a.a().r(atomicReference, 15000L, "double test flag value", new RunnableC2337z2(this, atomicReference));
    }

    public final Integer T() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.a.a().r(atomicReference, 15000L, "int test flag value", new RunnableC2332y2(this, atomicReference));
    }

    public final Long U() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.a.a().r(atomicReference, 15000L, "long test flag value", new RunnableC2327x2(this, atomicReference));
    }

    public final String V() {
        return (String) this.g.get();
    }

    public final String W() {
        M2 m2R = this.a.K().r();
        if (m2R != null) {
            return m2R.b;
        }
        return null;
    }

    public final String X() {
        M2 m2R = this.a.K().r();
        if (m2R != null) {
            return m2R.a;
        }
        return null;
    }

    public final String Y() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.a.a().r(atomicReference, 15000L, "String test flag value", new RunnableC2322w2(this, atomicReference));
    }

    public final ArrayList Z(String str, String str2) {
        if (this.a.a().C()) {
            this.a.b().r().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        this.a.d();
        if (C2220c.a()) {
            this.a.b().r().a("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.a.a().r(atomicReference, 5000L, "get conditional user properties", new RunnableC2297r2(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return f4.v(list);
        }
        this.a.b().r().b("Timed out waiting for get conditional user properties", null);
        return new ArrayList();
    }

    public final Map a0(String str, String str2, boolean z) {
        if (this.a.a().C()) {
            this.a.b().r().a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        this.a.d();
        if (C2220c.a()) {
            this.a.b().r().a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.a.a().r(atomicReference, 5000L, "get user properties", new RunnableC2307t2(this, atomicReference, null, str, str2, z));
        List<zzkw> list = (List) atomicReference.get();
        if (list == null) {
            this.a.b().r().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        KJ kj = new KJ(list.size());
        for (zzkw zzkwVar : list) {
            Object objP = zzkwVar.P();
            if (objP != null) {
                kj.put(zzkwVar.b, objP);
            }
        }
        return kj;
    }

    public final void f0() {
        h();
        i();
        if (this.a.r()) {
            if (this.a.z().B(null, S0.Z)) {
                C2240g c2240gZ = this.a.z();
                c2240gZ.a.d();
                Boolean boolT = c2240gZ.t("google_analytics_deferred_deep_link_enabled");
                if (boolT != null && boolT.booleanValue()) {
                    this.a.b().q().a("Deferred Deep Link feature enabled.");
                    this.a.a().z(new Runnable() { // from class: com.google.android.gms.measurement.internal.i2
                        @Override // java.lang.Runnable
                        public final void run() {
                            G2 g2 = this.a;
                            g2.h();
                            if (g2.a.F().s.b()) {
                                g2.a.b().q().a("Deferred Deep Link already retrieved. Not fetching again.");
                                return;
                            }
                            long jA = g2.a.F().t.a();
                            g2.a.F().t.b(1 + jA);
                            g2.a.z();
                            if (jA < 5) {
                                g2.a.j();
                            } else {
                                g2.a.b().w().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                g2.a.F().s.a(true);
                            }
                        }
                    });
                }
            }
            this.a.L().O();
            this.o = false;
            C2292q1 c2292q1F = this.a.F();
            c2292q1F.h();
            String string = c2292q1F.o().getString("previous_os_version", null);
            c2292q1F.a.A().k();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = c2292q1F.o().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.a.A().k();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            u("auto", "_ou", bundle);
        }
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2311u1
    protected final boolean n() {
        return false;
    }

    public final void o(String str, String str2, Bundle bundle) {
        long jCurrentTimeMillis = this.a.c().currentTimeMillis();
        AbstractC3795Cj5.f(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        this.a.a().z(new RunnableC2293q2(this, bundle2));
    }

    public final void p() {
        if (!(this.a.f().getApplicationContext() instanceof Application) || this.c == null) {
            return;
        }
        ((Application) this.a.f().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.c);
    }

    final /* synthetic */ void q(Bundle bundle) {
        if (bundle == null) {
            this.a.F().x.b(new Bundle());
            return;
        }
        Bundle bundleA = this.a.F().x.a();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.a.N().U(obj)) {
                    this.a.N().B(this.p, null, 27, null, null, 0);
                }
                this.a.b().x().c("Invalid default event parameter type. Name, value", str, obj);
            } else if (f4.W(str)) {
                this.a.b().x().b("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                bundleA.remove(str);
            } else {
                f4 f4VarN = this.a.N();
                this.a.z();
                if (f4VarN.P("param", str, 100, obj)) {
                    this.a.N().C(bundleA, str, obj);
                }
            }
        }
        this.a.N();
        int iM = this.a.z().m();
        if (bundleA.size() > iM) {
            int i = 0;
            for (String str2 : new TreeSet(bundleA.keySet())) {
                i++;
                if (i > iM) {
                    bundleA.remove(str2);
                }
            }
            this.a.N().B(this.p, null, 26, null, null, 0);
            this.a.b().x().a("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.a.F().x.b(bundleA);
        this.a.L().v(bundleA);
    }

    public final void r(String str, String str2, Bundle bundle) {
        s(str, str2, bundle, true, true, this.a.c().currentTimeMillis());
    }

    public final void s(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (str2 == "screen_view" || (str2 != null && str2.equals("screen_view"))) {
            this.a.K().E(bundle2, j);
            return;
        }
        boolean z3 = true;
        if (z2 && this.d != null && !f4.W(str2)) {
            z3 = false;
        }
        A(str3, str2, j, bundle2, z2, z3, z, null);
    }

    public final void t(String str, String str2, Bundle bundle, String str3) {
        H1.t();
        A("auto", str2, this.a.c().currentTimeMillis(), bundle, false, true, true, str3);
    }

    final void u(String str, String str2, Bundle bundle) {
        h();
        v(str, str2, this.a.c().currentTimeMillis(), bundle);
    }

    final void v(String str, String str2, long j, Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        h();
        w(str, str2, j, bundle, true, this.d == null || f4.W(str2), true, null);
    }

    protected final void w(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z4;
        String str4;
        ArrayList arrayList;
        long j2;
        Bundle[] bundleArr;
        AbstractC3795Cj5.f(str);
        AbstractC3795Cj5.j(bundle);
        h();
        i();
        if (!this.a.o()) {
            this.a.b().q().a("Event not sent since app measurement is disabled");
            return;
        }
        List listU = this.a.B().u();
        if (listU != null && !listU.contains(str2)) {
            this.a.b().q().c("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        if (!this.f) {
            this.f = true;
            try {
                try {
                    (!this.a.s() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.a.f().getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, this.a.f());
                } catch (Exception e) {
                    this.a.b().w().b("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                this.a.b().u().a("Tag Manager is not found and thus will not be used");
            }
        }
        if ("_cmp".equals(str2) && bundle.containsKey("gclid")) {
            this.a.d();
            M("auto", "_lgclid", bundle.getString("gclid"), this.a.c().currentTimeMillis());
        }
        this.a.d();
        if (z && f4.a0(str2)) {
            this.a.N().z(bundle, this.a.F().x.a());
        }
        if (!z3) {
            this.a.d();
            if (!"_iap".equals(str2)) {
                f4 f4VarN = this.a.N();
                int i = 2;
                if (f4VarN.R("event", str2)) {
                    if (f4VarN.N("event", AbstractC24556yo8.a, AbstractC24556yo8.b, str2)) {
                        f4VarN.a.z();
                        if (f4VarN.M("event", 40, str2)) {
                            i = 0;
                        }
                    } else {
                        i = 13;
                    }
                }
                if (i != 0) {
                    this.a.b().s().b("Invalid public event name. Event will not be logged (FE)", this.a.D().d(str2));
                    f4 f4VarN2 = this.a.N();
                    this.a.z();
                    this.a.N().B(this.p, null, i, "_ev", f4VarN2.r(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        this.a.d();
        M2 m2S = this.a.K().s(false);
        if (m2S != null && !bundle.containsKey("_sc")) {
            m2S.d = true;
        }
        f4.y(m2S, bundle, z && !z3);
        boolean zEquals = "am".equals(str);
        boolean zW = f4.W(str2);
        if (!z || this.d == null || zW) {
            z4 = zEquals;
        } else {
            if (!zEquals) {
                this.a.b().q().c("Passing event to registered event handler (FE)", this.a.D().d(str2), this.a.D().b(bundle));
                AbstractC3795Cj5.j(this.d);
                this.d.a(str, str2, bundle, j);
                return;
            }
            z4 = true;
        }
        if (this.a.r()) {
            int iK0 = this.a.N().k0(str2);
            if (iK0 != 0) {
                this.a.b().s().b("Invalid event name. Event will not be logged (FE)", this.a.D().d(str2));
                f4 f4VarN3 = this.a.N();
                this.a.z();
                this.a.N().B(this.p, str3, iK0, "_ev", f4VarN3.r(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            Bundle bundleV0 = this.a.N().v0(str3, str2, bundle, WW0.b("_o", "_sn", "_sc", "_si"), z3);
            AbstractC3795Cj5.j(bundleV0);
            this.a.d();
            if (this.a.K().s(false) != null && "_ae".equals(str2)) {
                H3 h3 = this.a.M().e;
                long jElapsedRealtime = h3.d.a.c().elapsedRealtime();
                long j3 = jElapsedRealtime - h3.b;
                h3.b = jElapsedRealtime;
                if (j3 > 0) {
                    this.a.N().w(bundleV0, j3);
                }
            }
            Rs8.b();
            if (this.a.z().B(null, S0.e0)) {
                if (!"auto".equals(str) && "_ssr".equals(str2)) {
                    f4 f4VarN4 = this.a.N();
                    String string = bundleV0.getString("_ffr");
                    if (AbstractC13016fZ6.a(string)) {
                        string = null;
                    } else if (string != null) {
                        string = string.trim();
                    }
                    if (Cr8.a(string, f4VarN4.a.F().u.a())) {
                        f4VarN4.a.b().q().a("Not logging duplicate session_start_with_rollout event");
                        return;
                    }
                    f4VarN4.a.F().u.b(string);
                } else if ("_ae".equals(str2)) {
                    String strA = this.a.N().a.F().u.a();
                    if (!TextUtils.isEmpty(strA)) {
                        bundleV0.putString("_ffr", strA);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(bundleV0);
            if (this.a.F().o.a() > 0 && this.a.F().v(j) && this.a.F().r.b()) {
                this.a.b().v().a("Current session is expired, remove the session number, ID, and engagement time");
                arrayList = arrayList2;
                j2 = 0;
                str4 = "_ae";
                M("auto", "_sid", null, this.a.c().currentTimeMillis());
                M("auto", "_sno", null, this.a.c().currentTimeMillis());
                M("auto", "_se", null, this.a.c().currentTimeMillis());
                this.a.F().p.b(0L);
            } else {
                str4 = "_ae";
                arrayList = arrayList2;
                j2 = 0;
            }
            if (bundleV0.getLong("extend_session", j2) == 1) {
                this.a.b().v().a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.a.M().d.b(j, true);
            }
            ArrayList arrayList3 = new ArrayList(bundleV0.keySet());
            Collections.sort(arrayList3);
            int size = arrayList3.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str5 = (String) arrayList3.get(i2);
                if (str5 != null) {
                    this.a.N();
                    Object obj = bundleV0.get(str5);
                    if (obj instanceof Bundle) {
                        bundleArr = new Bundle[]{(Bundle) obj};
                    } else if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList4 = (ArrayList) obj;
                        bundleArr = (Bundle[]) arrayList4.toArray(new Bundle[arrayList4.size()]);
                    } else {
                        bundleArr = null;
                    }
                    if (bundleArr != null) {
                        bundleV0.putParcelableArray(str5, bundleArr);
                    }
                }
            }
            int i3 = 0;
            while (i3 < arrayList.size()) {
                ArrayList arrayList5 = arrayList;
                Bundle bundleU0 = (Bundle) arrayList5.get(i3);
                String str6 = i3 != 0 ? "_ep" : str2;
                bundleU0.putString("_o", str);
                if (z2) {
                    bundleU0 = this.a.N().u0(bundleU0);
                }
                Bundle bundle2 = bundleU0;
                this.a.L().o(new zzaw(str6, new zzau(bundle2), str, j), str3);
                if (!z4) {
                    Iterator it = this.e.iterator();
                    while (it.hasNext()) {
                        ((Do8) it.next()).a(str, str2, new Bundle(bundle2), j);
                    }
                }
                i3++;
                arrayList = arrayList5;
            }
            this.a.d();
            if (this.a.K().s(false) == null || !str4.equals(str2)) {
                return;
            }
            this.a.M().e.d(true, true, this.a.c().elapsedRealtime());
        }
    }

    public final void x(Do8 do8) {
        i();
        AbstractC3795Cj5.j(do8);
        if (this.e.add(do8)) {
            return;
        }
        this.a.b().w().a("OnEventListener already registered");
    }

    public final void y(long j) {
        this.g.set(null);
        this.a.a().z(new RunnableC2283o2(this, j));
    }

    final void z(long j, boolean z) {
        h();
        i();
        this.a.b().q().a("Resetting analytics data (FE)");
        J3 j3M = this.a.M();
        j3M.h();
        j3M.e.a();
        Wt8.b();
        if (this.a.z().B(null, S0.o0)) {
            this.a.B().v();
        }
        boolean zO = this.a.o();
        C2292q1 c2292q1F = this.a.F();
        c2292q1F.e.b(j);
        if (!TextUtils.isEmpty(c2292q1F.a.F().u.a())) {
            c2292q1F.u.b(null);
        }
        C17399mt8.b();
        C2240g c2240gZ = c2292q1F.a.z();
        R0 r0 = S0.f0;
        if (c2240gZ.B(null, r0)) {
            c2292q1F.o.b(0L);
        }
        c2292q1F.p.b(0L);
        if (!c2292q1F.a.z().E()) {
            c2292q1F.t(!zO);
        }
        c2292q1F.v.b(null);
        c2292q1F.w.b(0L);
        c2292q1F.x.b(null);
        if (z) {
            this.a.L().q();
        }
        C17399mt8.b();
        if (this.a.z().B(null, r0)) {
            this.a.M().d.a();
        }
        this.o = !zO;
    }
}
