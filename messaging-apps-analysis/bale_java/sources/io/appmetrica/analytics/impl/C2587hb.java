package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.hb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2587hb implements on {
    @Override // io.appmetrica.analytics.impl.on
    public final mn a(String str) {
        return str == null ? new mn(this, false, "key is null") : str.startsWith("appmetrica") ? new mn(this, false, "key starts with appmetrica") : str.length() > 200 ? new mn(this, false, "key length more then 200 characters") : new mn(this, true, "");
    }
}
