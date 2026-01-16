package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingClient;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import io.appmetrica.analytics.billingv6.internal.BillingLibraryMonitor$updateBilling$1$runSafety$1;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
public final class g {
    public final BillingClient a;
    public final UtilsProvider b;
    public final LinkedHashSet c = new LinkedHashSet();

    public g(BillingClient billingClient, BillingLibraryMonitor$updateBilling$1$runSafety$1 billingLibraryMonitor$updateBilling$1$runSafety$1) {
        this.a = billingClient;
        this.b = billingLibraryMonitor$updateBilling$1$runSafety$1;
    }

    public final void a(Object obj) {
        this.c.remove(obj);
        if (this.c.size() == 0) {
            this.b.getUiExecutor().execute(new f(this));
        }
    }
}
