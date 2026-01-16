package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
final /* synthetic */ class cb implements adr {
    static final adr a = new cb();

    private cb() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adr
    public final void a(Object obj) {
        ((dw) obj).q(bn.e(new TimeoutException("Player release timed out."), 1));
    }
}
