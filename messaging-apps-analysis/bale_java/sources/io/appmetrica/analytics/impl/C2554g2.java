package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.impl.C2554g2;

/* renamed from: io.appmetrica.analytics.impl.g2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2554g2 {
    public static final boolean a(Throwable th) {
        return true;
    }

    public final InterfaceC3016za a(Context context, AppMetricaConfig appMetricaConfig, Na na) {
        return new Tg(new Rb(na, appMetricaConfig), new InterfaceC2606i6() { // from class: ir.nasim.Dd8
            @Override // io.appmetrica.analytics.impl.InterfaceC2606i6
            public final boolean a(Throwable th) {
                return C2554g2.a(th);
            }
        }, appMetricaConfig.crashTransformer, new G9(context));
    }
}
