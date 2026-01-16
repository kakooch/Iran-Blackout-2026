package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;

/* renamed from: io.appmetrica.analytics.impl.km, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2669km {
    public final InterfaceC2717mm a;
    public final InterfaceC2717mm b;

    public C2669km(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.a = new T2(new C2715mk(context));
            this.b = new T2(new C2874tc(context));
        } else {
            this.a = new T7();
            this.b = new T7();
        }
    }
}
