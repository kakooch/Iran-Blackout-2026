package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;

/* renamed from: io.appmetrica.analytics.impl.gj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2571gj extends C2484d5 {
    public C2571gj(Context context, C2549fl c2549fl, W4 w4, C3010z4 c3010z4, InterfaceC3022zg interfaceC3022zg, AbstractC2434b5 abstractC2434b5) {
        this(context, w4, new C2454c0(), new TimePassedChecker(), new C2605i5(context, w4, c3010z4, abstractC2434b5, c2549fl, interfaceC3022zg, C2586ha.h().u().d(), PackageManagerUtils.getAppVersionCodeInt(context), C2586ha.h().i()));
    }

    @Override // io.appmetrica.analytics.impl.C2484d5, io.appmetrica.analytics.impl.InterfaceC2992ya
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.SELF_SDK;
    }

    public C2571gj(Context context, W4 w4, C2454c0 c2454c0, TimePassedChecker timePassedChecker, C2605i5 c2605i5) {
        super(context, w4, c2454c0, timePassedChecker, c2605i5);
    }
}
