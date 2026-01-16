package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;

/* loaded from: classes3.dex */
public final class Vg extends C2484d5 {
    public final String x;
    public final B6 y;

    public Vg(Context context, W4 w4, C3010z4 c3010z4, B6 b6, C2549fl c2549fl, AbstractC2434b5 abstractC2434b5) {
        this(context, w4, new C2454c0(), new TimePassedChecker(), new C2605i5(context, w4, c3010z4, abstractC2434b5, c2549fl, new Qg(b6), C2586ha.h().u().d(), PackageManagerUtils.getAppVersionCodeInt(context), C2586ha.h().i()), b6);
    }

    @Override // io.appmetrica.analytics.impl.C2484d5, io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.InterfaceC2992ya
    public final synchronized void a(C3010z4 c3010z4) {
        super.a(c3010z4);
        this.y.a(this.x, c3010z4.i);
    }

    public Vg(Context context, W4 w4, C2454c0 c2454c0, TimePassedChecker timePassedChecker, C2605i5 c2605i5, B6 b6) {
        super(context, w4, c2454c0, timePassedChecker, c2605i5);
        this.x = w4.b();
        this.y = b6;
    }
}
