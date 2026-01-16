package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;

/* loaded from: classes3.dex */
public final class fn implements InterfaceC2668kl {
    public final UtilityServiceProvider a;

    public fn(UtilityServiceProvider utilityServiceProvider) {
        this.a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2668kl
    public final void a(C2549fl c2549fl) {
        this.a.updateConfiguration(new UtilityServiceConfiguration(c2549fl.v, c2549fl.u));
    }
}
