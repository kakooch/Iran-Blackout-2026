package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;

/* renamed from: io.appmetrica.analytics.impl.fj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2547fj extends AbstractC2998yg {
    public C2547fj(B6 b6) {
        super(b6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2998yg, io.appmetrica.analytics.impl.InterfaceC3022zg
    public final boolean a(Boolean bool) {
        return !this.a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
