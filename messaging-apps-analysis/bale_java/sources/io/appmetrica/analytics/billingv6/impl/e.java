package io.appmetrica.analytics.billingv6.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoManager;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage;
import ir.nasim.AbstractC15401jX0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class e implements BillingInfoManager {
    public final BillingInfoStorage a;
    public boolean b;
    public final LinkedHashMap c;

    public e(BillingInfoStorage billingInfoStorage) {
        this.a = billingInfoStorage;
        this.b = billingInfoStorage.isFirstInappCheckOccurred();
        List<BillingInfo> billingInfo = billingInfoStorage.getBillingInfo();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : billingInfo) {
            linkedHashMap.put(((BillingInfo) obj).productId, obj);
        }
        this.c = linkedHashMap;
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoManager
    public final BillingInfo get(String str) {
        return (BillingInfo) this.c.get(str);
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoManager
    public final boolean isFirstInappCheckOccurred() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoManager
    public final void markFirstInappCheckOccurred() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.saveInfo(AbstractC15401jX0.m1(this.c.values()), this.b);
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoManager
    public final void update(Map<String, ? extends BillingInfo> map) {
        for (BillingInfo billingInfo : map.values()) {
            this.c.put(billingInfo.productId, billingInfo);
        }
        this.a.saveInfo(AbstractC15401jX0.m1(this.c.values()), this.b);
    }
}
