package io.appmetrica.analytics.billingv6.impl;

import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.SA2;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class m extends AbstractC8614Ws3 implements SA2 {
    public final /* synthetic */ Map a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ p c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(LinkedHashMap linkedHashMap, Map map, p pVar) {
        super(0);
        this.a = linkedHashMap;
        this.b = map;
        this.c = pVar;
    }

    @Override // ir.nasim.SA2
    public final Object invoke() {
        Map map = this.a;
        Map map2 = this.b;
        p pVar = this.c;
        t.a(map, map2, pVar.d, pVar.c.getBillingInfoManager());
        return C19938rB7.a;
    }
}
