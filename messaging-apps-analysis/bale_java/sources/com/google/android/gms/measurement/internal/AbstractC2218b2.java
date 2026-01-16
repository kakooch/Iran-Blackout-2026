package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.b2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2218b2 extends AbstractC2213a2 {
    private boolean b;

    AbstractC2218b2(H1 h1) {
        super(h1);
        this.a.i();
    }

    protected void i() {
    }

    protected abstract boolean j();

    protected final void k() {
        if (!n()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void l() {
        if (this.b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (j()) {
            return;
        }
        this.a.g();
        this.b = true;
    }

    public final void m() {
        if (this.b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        i();
        this.a.g();
        this.b = true;
    }

    final boolean n() {
        return this.b;
    }
}
