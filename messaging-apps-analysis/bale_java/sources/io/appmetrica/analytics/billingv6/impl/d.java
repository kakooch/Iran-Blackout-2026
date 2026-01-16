package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import io.appmetrica.analytics.billingv6.internal.BillingLibraryMonitor$updateBilling$1$runSafety$1;

/* loaded from: classes3.dex */
public final class d implements BillingClientStateListener {
    public final BillingConfig a;
    public final BillingClient b;
    public final UtilsProvider c;
    public final g d;

    public d(BillingConfig billingConfig, BillingClient billingClient, BillingLibraryMonitor$updateBilling$1$runSafety$1 billingLibraryMonitor$updateBilling$1$runSafety$1, g gVar) {
        this.a = billingConfig;
        this.b = billingClient;
        this.c = billingLibraryMonitor$updateBilling$1$runSafety$1;
        this.d = gVar;
    }

    public final void onBillingServiceDisconnected() {
    }

    public final void onBillingSetupFinished(BillingResult billingResult) {
        this.c.getWorkerExecutor().execute(new a(this, billingResult));
    }
}
