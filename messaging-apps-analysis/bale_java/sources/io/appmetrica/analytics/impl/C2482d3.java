package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.Iterator;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.d3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2482d3 implements BillingInfoSender {
    public final Ja a;
    public final ICommonExecutor b;

    public C2482d3(Ja ja2) {
        this(ja2, C2586ha.h().u().e());
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender
    public final void sendInfo(List<ProductInfo> list) {
        Iterator<ProductInfo> it = list.iterator();
        while (it.hasNext()) {
            this.b.execute(new C2457c3(this, it.next()));
        }
    }

    public C2482d3(Ja ja2, ICommonExecutor iCommonExecutor) {
        this.a = ja2;
        this.b = iCommonExecutor;
    }
}
