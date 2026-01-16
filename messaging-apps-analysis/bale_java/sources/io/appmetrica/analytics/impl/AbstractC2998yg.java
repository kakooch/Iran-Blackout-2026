package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;

/* renamed from: io.appmetrica.analytics.impl.yg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2998yg implements InterfaceC3022zg {
    protected final DataSendingRestrictionController a;

    public AbstractC2998yg(DataSendingRestrictionController dataSendingRestrictionController) {
        this.a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC3022zg
    public boolean a(Boolean bool) {
        return ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
