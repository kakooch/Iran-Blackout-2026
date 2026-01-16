package io.appmetrica.analytics.coreutils.impl;

import io.appmetrica.analytics.coreutils.internal.services.FirstExecutionConditionServiceImpl;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.SA2;

/* loaded from: classes3.dex */
public final class k extends AbstractC8614Ws3 implements SA2 {
    public final /* synthetic */ UtilityServiceProvider a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(UtilityServiceProvider utilityServiceProvider) {
        super(0);
        this.a = utilityServiceProvider;
    }

    @Override // ir.nasim.SA2
    public final Object invoke() {
        return new FirstExecutionConditionServiceImpl(this.a);
    }
}
