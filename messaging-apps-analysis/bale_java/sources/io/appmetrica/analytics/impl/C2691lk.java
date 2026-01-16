package io.appmetrica.analytics.impl;

import android.telephony.TelephonyManager;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;

/* renamed from: io.appmetrica.analytics.impl.lk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2691lk implements FunctionWithThrowable {
    public final /* synthetic */ C2715mk a;

    public C2691lk(C2715mk c2715mk) {
        this.a = c2715mk;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
    public final Object apply(Object obj) {
        TelephonyManager telephonyManager = (TelephonyManager) obj;
        C2715mk c2715mk = this.a;
        if (c2715mk.b.hasPermission(c2715mk.a, "android.permission.READ_PHONE_STATE")) {
            return Boolean.valueOf(telephonyManager.isNetworkRoaming());
        }
        return null;
    }
}
