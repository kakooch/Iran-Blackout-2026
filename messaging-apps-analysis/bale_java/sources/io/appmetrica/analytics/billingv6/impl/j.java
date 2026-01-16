package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.QueryPurchasesParams;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* loaded from: classes3.dex */
public final class j extends SafeRunnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ r b;

    public j(k kVar, r rVar) {
        this.a = kVar;
        this.b = rVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        if (this.a.b.isReady()) {
            this.a.b.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType(this.a.a).build(), this.b);
        } else {
            this.a.c.getWorkerExecutor().execute(new i(this.a, this.b));
        }
    }
}
