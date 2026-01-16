package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;

/* loaded from: classes3.dex */
public final class Qg extends AbstractC2998yg {
    public Qg(B6 b6) {
        super(b6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2998yg, io.appmetrica.analytics.impl.InterfaceC3022zg
    public final boolean a(Boolean bool) {
        return !this.a.isRestrictedForReporter() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
