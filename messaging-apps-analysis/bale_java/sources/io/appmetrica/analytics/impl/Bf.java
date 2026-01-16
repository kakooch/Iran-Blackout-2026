package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;

/* loaded from: classes3.dex */
public enum Bf {
    b(CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE),
    c("gpl"),
    d("hms-content-provider");

    public final String a;

    Bf(String str) {
        this.a = str;
    }
}
