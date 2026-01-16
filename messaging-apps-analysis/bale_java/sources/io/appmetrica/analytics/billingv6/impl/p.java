package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchaseHistoryResponseListener;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import java.util.List;

/* loaded from: classes3.dex */
public final class p implements PurchaseHistoryResponseListener {
    public final BillingConfig a;
    public final BillingClient b;
    public final UtilsProvider c;
    public final String d;
    public final g e;

    public p(BillingConfig billingConfig, BillingClient billingClient, UtilsProvider utilsProvider, String str, g gVar) {
        this.a = billingConfig;
        this.b = billingClient;
        this.c = utilsProvider;
        this.d = str;
        this.e = gVar;
    }

    public final void onPurchaseHistoryResponse(BillingResult billingResult, List list) {
        this.c.getWorkerExecutor().execute(new l(this, billingResult, list));
    }
}
