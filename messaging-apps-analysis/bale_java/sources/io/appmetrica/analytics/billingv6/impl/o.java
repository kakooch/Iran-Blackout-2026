package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.QueryProductDetailsParams;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import ir.nasim.AbstractC10976cX0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class o extends SafeRunnable {
    public final /* synthetic */ p a;
    public final /* synthetic */ List b;
    public final /* synthetic */ k c;

    public o(p pVar, List list, k kVar) {
        this.a = pVar;
        this.b = list;
        this.c = kVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        if (!this.a.b.isReady()) {
            this.a.c.getWorkerExecutor().execute(new n(this.a, this.c));
            return;
        }
        BillingClient billingClient = this.a.b;
        QueryProductDetailsParams.Builder builderNewBuilder = QueryProductDetailsParams.newBuilder();
        List list = this.b;
        p pVar = this.a;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(QueryProductDetailsParams.Product.newBuilder().setProductId((String) it.next()).setProductType(pVar.d).build());
        }
        billingClient.queryProductDetailsAsync(builderNewBuilder.setProductList(arrayList).build(), this.c);
    }
}
