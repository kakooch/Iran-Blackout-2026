package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import ir.nasim.AbstractC14398hq8;
import ir.nasim.AbstractC3795Cj5;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class T2 extends AbstractC2311u1 {
    private volatile M2 c;
    private volatile M2 d;
    protected M2 e;
    private final Map f;
    private Activity g;
    private volatile boolean h;
    private volatile M2 i;
    private M2 j;
    private boolean k;
    private final Object l;

    public T2(H1 h1) {
        super(h1);
        this.l = new Object();
        this.f = new ConcurrentHashMap();
    }

    private final M2 F(Activity activity) {
        AbstractC3795Cj5.j(activity);
        M2 m2 = (M2) this.f.get(activity);
        if (m2 == null) {
            M2 m22 = new M2(null, t(activity.getClass(), "Activity"), this.a.N().r0());
            this.f.put(activity, m22);
            m2 = m22;
        }
        return this.i != null ? this.i : m2;
    }

    private final void G(Activity activity, M2 m2, boolean z) {
        M2 m22;
        M2 m23 = this.c == null ? this.d : this.c;
        if (m2.b == null) {
            m22 = new M2(m2.a, activity != null ? t(activity.getClass(), "Activity") : null, m2.c, m2.e, m2.f);
        } else {
            m22 = m2;
        }
        this.d = this.c;
        this.c = m22;
        this.a.a().z(new O2(this, m22, m23, this.a.c().elapsedRealtime(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(M2 m2, M2 m22, long j, boolean z, Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        long j2;
        long j3;
        h();
        boolean z2 = false;
        boolean z3 = (m22 != null && m22.c == m2.c && AbstractC14398hq8.a(m22.b, m2.b) && AbstractC14398hq8.a(m22.a, m2.a)) ? false : true;
        if (z && this.e != null) {
            z2 = true;
        }
        if (z3) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            f4.y(m2, bundle2, true);
            if (m22 != null) {
                String str = m22.a;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = m22.b;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", m22.c);
            }
            if (z2) {
                H3 h3 = this.a.M().e;
                long j4 = j - h3.b;
                h3.b = j;
                if (j4 > 0) {
                    this.a.N().w(bundle2, j4);
                }
            }
            if (!this.a.z().D()) {
                bundle2.putLong("_mst", 1L);
            }
            String str3 = true != m2.e ? "auto" : "app";
            long jCurrentTimeMillis = this.a.c().currentTimeMillis();
            if (m2.e) {
                j2 = jCurrentTimeMillis;
                long j5 = m2.f;
                if (j5 != 0) {
                    j3 = j5;
                }
                this.a.I().v(str3, "_vs", j3, bundle2);
            } else {
                j2 = jCurrentTimeMillis;
            }
            j3 = j2;
            this.a.I().v(str3, "_vs", j3, bundle2);
        }
        if (z2) {
            p(this.e, true, j);
        }
        this.e = m2;
        if (m2.e) {
            this.j = m2;
        }
        this.a.L().u(m2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(M2 m2, boolean z, long j) {
        this.a.y().n(this.a.c().elapsedRealtime());
        if (!this.a.M().e.d(m2 != null && m2.d, z, j) || m2 == null) {
            return;
        }
        m2.d = false;
    }

    static /* bridge */ /* synthetic */ void w(T2 t2, Bundle bundle, M2 m2, M2 m22, long j) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        t2.o(m2, m22, j, true, t2.a.N().v0(null, "screen_view", bundle, null, false));
    }

    public final void A(Activity activity) {
        synchronized (this.l) {
            this.k = false;
            this.h = true;
        }
        long jElapsedRealtime = this.a.c().elapsedRealtime();
        if (!this.a.z().D()) {
            this.c = null;
            this.a.a().z(new Q2(this, jElapsedRealtime));
        } else {
            M2 m2F = F(activity);
            this.d = this.c;
            this.c = null;
            this.a.a().z(new R2(this, m2F, jElapsedRealtime));
        }
    }

    public final void B(Activity activity) {
        synchronized (this.l) {
            this.k = true;
            if (activity != this.g) {
                synchronized (this.l) {
                    this.g = activity;
                    this.h = false;
                }
                if (this.a.z().D()) {
                    this.i = null;
                    this.a.a().z(new S2(this));
                }
            }
        }
        if (!this.a.z().D()) {
            this.c = this.i;
            this.a.a().z(new P2(this));
        } else {
            G(activity, F(activity), false);
            C2330y0 c2330y0Y = this.a.y();
            c2330y0Y.a.a().z(new X(c2330y0Y, c2330y0Y.a.c().elapsedRealtime()));
        }
    }

    public final void C(Activity activity, Bundle bundle) {
        M2 m2;
        if (!this.a.z().D() || bundle == null || (m2 = (M2) this.f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", m2.c);
        bundle2.putString("name", m2.a);
        bundle2.putString("referrer_name", m2.b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (r5.length() <= 100) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
    
        if (r6.length() <= 100) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D(android.app.Activity r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.H1 r0 = r3.a
            com.google.android.gms.measurement.internal.g r0 = r0.z()
            boolean r0 = r0.D()
            if (r0 != 0) goto L1c
            com.google.android.gms.measurement.internal.H1 r4 = r3.a
            com.google.android.gms.measurement.internal.d1 r4 = r4.b()
            com.google.android.gms.measurement.internal.b1 r4 = r4.x()
            java.lang.String r5 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r4.a(r5)
            return
        L1c:
            com.google.android.gms.measurement.internal.M2 r0 = r3.c
            if (r0 != 0) goto L30
            com.google.android.gms.measurement.internal.H1 r4 = r3.a
            com.google.android.gms.measurement.internal.d1 r4 = r4.b()
            com.google.android.gms.measurement.internal.b1 r4 = r4.x()
            java.lang.String r5 = "setCurrentScreen cannot be called while no activity active"
            r4.a(r5)
            return
        L30:
            java.util.Map r1 = r3.f
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L48
            com.google.android.gms.measurement.internal.H1 r4 = r3.a
            com.google.android.gms.measurement.internal.d1 r4 = r4.b()
            com.google.android.gms.measurement.internal.b1 r4 = r4.x()
            java.lang.String r5 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r4.a(r5)
            return
        L48:
            if (r6 != 0) goto L54
            java.lang.Class r6 = r4.getClass()
            java.lang.String r1 = "Activity"
            java.lang.String r6 = r3.t(r6, r1)
        L54:
            java.lang.String r1 = r0.b
            boolean r1 = ir.nasim.AbstractC14398hq8.a(r1, r6)
            java.lang.String r0 = r0.a
            boolean r0 = ir.nasim.AbstractC14398hq8.a(r0, r5)
            if (r1 == 0) goto L75
            if (r0 != 0) goto L65
            goto L75
        L65:
            com.google.android.gms.measurement.internal.H1 r4 = r3.a
            com.google.android.gms.measurement.internal.d1 r4 = r4.b()
            com.google.android.gms.measurement.internal.b1 r4 = r4.x()
            java.lang.String r5 = "setCurrentScreen cannot be called with the same class and name"
            r4.a(r5)
            return
        L75:
            r0 = 100
            if (r5 == 0) goto La3
            int r1 = r5.length()
            if (r1 <= 0) goto L8b
            com.google.android.gms.measurement.internal.H1 r1 = r3.a
            r1.z()
            int r1 = r5.length()
            if (r1 > r0) goto L8b
            goto La3
        L8b:
            com.google.android.gms.measurement.internal.H1 r4 = r3.a
            com.google.android.gms.measurement.internal.d1 r4 = r4.b()
            com.google.android.gms.measurement.internal.b1 r4 = r4.x()
            int r5 = r5.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid screen name length in setCurrentScreen. Length"
            r4.b(r6, r5)
            return
        La3:
            if (r6 == 0) goto Lcf
            int r1 = r6.length()
            if (r1 <= 0) goto Lb7
            com.google.android.gms.measurement.internal.H1 r1 = r3.a
            r1.z()
            int r1 = r6.length()
            if (r1 > r0) goto Lb7
            goto Lcf
        Lb7:
            com.google.android.gms.measurement.internal.H1 r4 = r3.a
            com.google.android.gms.measurement.internal.d1 r4 = r4.b()
            com.google.android.gms.measurement.internal.b1 r4 = r4.x()
            int r5 = r6.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid class name length in setCurrentScreen. Length"
            r4.b(r6, r5)
            return
        Lcf:
            com.google.android.gms.measurement.internal.H1 r0 = r3.a
            com.google.android.gms.measurement.internal.d1 r0 = r0.b()
            com.google.android.gms.measurement.internal.b1 r0 = r0.v()
            if (r5 != 0) goto Lde
            java.lang.String r1 = "null"
            goto Ldf
        Lde:
            r1 = r5
        Ldf:
            java.lang.String r2 = "Setting current screen to name, class"
            r0.c(r2, r1, r6)
            com.google.android.gms.measurement.internal.M2 r0 = new com.google.android.gms.measurement.internal.M2
            com.google.android.gms.measurement.internal.H1 r1 = r3.a
            com.google.android.gms.measurement.internal.f4 r1 = r1.N()
            long r1 = r1.r0()
            r0.<init>(r5, r6, r1)
            java.util.Map r5 = r3.f
            r5.put(r4, r0)
            r5 = 1
            r3.G(r4, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.T2.D(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        if (r2 > 100) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
    
        if (r4 > 100) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(android.os.Bundle r13, long r14) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.T2.E(android.os.Bundle, long):void");
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2311u1
    protected final boolean n() {
        return false;
    }

    public final M2 r() {
        return this.c;
    }

    public final M2 s(boolean z) {
        i();
        h();
        if (!z) {
            return this.e;
        }
        M2 m2 = this.e;
        return m2 != null ? m2 : this.j;
    }

    final String t(Class cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] strArrSplit = canonicalName.split("\\.");
        int length = strArrSplit.length;
        String str2 = length > 0 ? strArrSplit[length - 1] : "";
        int length2 = str2.length();
        this.a.z();
        if (length2 <= 100) {
            return str2;
        }
        this.a.z();
        return str2.substring(0, 100);
    }

    public final void y(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.a.z().D() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f.put(activity, new M2(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void z(Activity activity) {
        synchronized (this.l) {
            try {
                if (activity == this.g) {
                    this.g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.a.z().D()) {
            this.f.remove(activity);
        }
    }
}
