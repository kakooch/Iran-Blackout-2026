package io.appmetrica.analytics.impl;

import java.util.Collection;

/* renamed from: io.appmetrica.analytics.impl.qd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2804qd implements on {
    public final String a;

    public C2804qd(String str) {
        this.a = str;
    }

    @Override // io.appmetrica.analytics.impl.on
    public final mn a(Collection<Object> collection) {
        if (!hn.a((Collection) collection)) {
            return new mn(this, true, "");
        }
        return new mn(this, false, this.a + " is null or empty.");
    }
}
