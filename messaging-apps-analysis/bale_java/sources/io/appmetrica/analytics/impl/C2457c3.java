package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* renamed from: io.appmetrica.analytics.impl.c3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2457c3 extends SafeRunnable {
    public final /* synthetic */ ProductInfo a;
    public final /* synthetic */ C2482d3 b;

    public C2457c3(C2482d3 c2482d3, ProductInfo productInfo) {
        this.b = c2482d3;
        this.a = productInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        ((C2484d5) this.b.a).a(Q5.a(new Se(this.a)));
    }
}
