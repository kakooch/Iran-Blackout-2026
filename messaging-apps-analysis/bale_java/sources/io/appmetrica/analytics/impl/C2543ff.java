package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.ff, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2543ff implements on {
    @Override // io.appmetrica.analytics.impl.on
    public final mn a(Object obj) {
        Integer num = (Integer) obj;
        if (num == null || num.intValue() > 0) {
            return new mn(this, true, "");
        }
        return new mn(this, false, "Invalid quantity value " + num);
    }
}
