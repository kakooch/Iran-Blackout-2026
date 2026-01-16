package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;

/* renamed from: io.appmetrica.analytics.impl.cc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2466cc extends C2484d5 implements Ga, Fa {
    public final C2603i3 A;
    public final Af x;
    public final Ef y;
    public final B6 z;

    public C2466cc(Context context, C2549fl c2549fl, W4 w4, C3010z4 c3010z4, Af af, B6 b6, AbstractC2434b5 abstractC2434b5) {
        this(context, w4, c2549fl, c3010z4, new C2454c0(), new TimePassedChecker(), new C2491dc(context, w4, c3010z4, abstractC2434b5, c2549fl, new Xb(b6), C2586ha.h().u().d(), PackageManagerUtils.getAppVersionCodeInt(context), C2586ha.h().u(), C2586ha.h().i()), af, b6);
    }

    @Override // io.appmetrica.analytics.impl.C2484d5
    public final void C() {
        this.x.a(this.y);
    }

    public final boolean D() {
        boolean zOptBoolean;
        tn tnVar = this.v;
        synchronized (tnVar) {
            zOptBoolean = tnVar.a.a().optBoolean("referrer_handled", false);
        }
        return zOptBoolean;
    }

    @Override // io.appmetrica.analytics.impl.C2484d5, io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.InterfaceC2992ya
    public final synchronized void a(C3010z4 c3010z4) {
        super.a(c3010z4);
        this.z.a(c3010z4.i);
    }

    @Override // io.appmetrica.analytics.impl.C2484d5, io.appmetrica.analytics.impl.InterfaceC2992ya
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MAIN;
    }

    @Override // io.appmetrica.analytics.impl.C2484d5, io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Pk
    public final void a(C2549fl c2549fl) {
        synchronized (this) {
            this.l.a(c2549fl);
            this.q.b();
        }
        this.A.a(c2549fl);
    }

    public C2466cc(Context context, W4 w4, C2549fl c2549fl, C3010z4 c3010z4, C2454c0 c2454c0, TimePassedChecker timePassedChecker, C2491dc c2491dc, Af af, B6 b6) {
        super(context, w4, c2454c0, timePassedChecker, c2491dc);
        this.x = af;
        S8 s8J = j();
        s8J.a(Ta.EVENT_TYPE_REGULAR, new Wf(s8J.b()));
        this.y = c2491dc.b(this);
        this.z = b6;
        C2603i3 c2603i3A = c2491dc.a(this);
        this.A = c2603i3A;
        c2603i3A.a(c2549fl, c3010z4.m);
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final void a() {
        tn tnVar = this.v;
        synchronized (tnVar) {
            un unVar = tnVar.a;
            unVar.a(unVar.a().put("referrer_handled", true));
        }
    }
}
