package io.appmetrica.analytics.impl;

import java.util.Map;

/* loaded from: classes3.dex */
public final class Bh implements on {
    public final Map a;

    public Bh(Map<String, ?> map) {
        this.a = map;
    }

    @Override // io.appmetrica.analytics.impl.on
    public final mn a(String str) {
        return this.a.containsKey(str) ? new mn(this, false, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", str)) : new mn(this, true, "");
    }
}
