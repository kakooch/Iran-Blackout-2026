package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.UA2;

/* renamed from: io.appmetrica.analytics.impl.l5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2676l5 extends AbstractC8614Ws3 implements UA2 {
    public static final C2676l5 a = new C2676l5();

    public C2676l5() {
        super(1);
    }

    @Override // ir.nasim.UA2
    public final Object invoke(Object obj) {
        return ((ModuleAdRevenueProcessor) obj).getDescription();
    }
}
