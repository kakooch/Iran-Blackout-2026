package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Pj {
    public final Wj a;
    public Integer b;

    public Pj(Wj wj) {
        this.a = wj;
    }

    public final Qj a() {
        return new Qj(this);
    }

    public final Pj b() {
        this.b = 3600;
        return this;
    }
}
