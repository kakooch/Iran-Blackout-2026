package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.td, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2875td implements on {
    public final String a;

    public C2875td(String str) {
        this.a = str;
    }

    @Override // io.appmetrica.analytics.impl.on
    public final mn a(Object obj) {
        if (obj != null) {
            return new mn(this, true, "");
        }
        return new mn(this, false, this.a + " is null.");
    }

    public final String a() {
        return this.a;
    }
}
