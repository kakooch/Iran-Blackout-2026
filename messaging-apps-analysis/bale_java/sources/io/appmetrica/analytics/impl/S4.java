package io.appmetrica.analytics.impl;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class S4 implements U6 {
    public final String a;
    public final String b;

    public S4(W4 w4) {
        this.a = String.format("component_%s.db", Arrays.copyOf(new Object[]{w4.d() ? "main" : w4.b()}, 1));
        this.b = "db_metrica_" + w4;
    }

    @Override // io.appmetrica.analytics.impl.U6
    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.U6
    public final String b() {
        return this.a;
    }
}
