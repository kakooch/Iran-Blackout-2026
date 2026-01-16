package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.u1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2311u1 extends W0 {
    private boolean b;

    AbstractC2311u1(H1 h1) {
        super(h1);
        this.a.i();
    }

    protected final void i() {
        if (!m()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void j() {
        if (this.b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (n()) {
            return;
        }
        this.a.g();
        this.b = true;
    }

    public final void k() {
        if (this.b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        l();
        this.a.g();
        this.b = true;
    }

    protected void l() {
    }

    final boolean m() {
        return this.b;
    }

    protected abstract boolean n();
}
