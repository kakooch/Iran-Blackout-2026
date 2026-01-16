package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
abstract class O3 extends N3 {
    private boolean c;

    O3(Y3 y3) {
        super(y3);
        this.b.r();
    }

    protected final void i() {
        if (!k()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void j() {
        if (this.c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        l();
        this.b.m();
        this.c = true;
    }

    final boolean k() {
        return this.c;
    }

    protected abstract boolean l();
}
