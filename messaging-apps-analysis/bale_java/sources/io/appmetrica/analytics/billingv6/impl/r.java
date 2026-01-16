package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchasesResponseListener;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import ir.nasim.SA2;
import java.util.List;

/* loaded from: classes3.dex */
public final class r implements PurchasesResponseListener {
    public final UtilsProvider a;
    public final SA2 b;
    public final List c;
    public final List d;
    public final g e;

    public r(UtilsProvider utilsProvider, SA2 sa2, List list, List list2, g gVar) {
        this.a = utilsProvider;
        this.b = sa2;
        this.c = list;
        this.d = list2;
        this.e = gVar;
    }

    public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
        this.a.getWorkerExecutor().execute(new q(this, billingResult, list));
    }
}
