package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import ir.nasim.Ak8;

/* loaded from: classes3.dex */
public final class J3 extends AbstractC2311u1 {
    private Handler c;
    protected final I3 d;
    protected final H3 e;
    protected final E3 f;

    J3(H1 h1) {
        super(h1);
        this.d = new I3(this);
        this.e = new H3(this);
        this.f = new E3(this);
    }

    static /* bridge */ /* synthetic */ void q(J3 j3, long j) {
        j3.h();
        j3.s();
        j3.a.b().v().b("Activity paused, time", Long.valueOf(j));
        j3.f.a(j);
        if (j3.a.z().D()) {
            j3.e.b(j);
        }
    }

    static /* bridge */ /* synthetic */ void r(J3 j3, long j) {
        j3.h();
        j3.s();
        j3.a.b().v().b("Activity resumed, time", Long.valueOf(j));
        if (j3.a.z().D() || j3.a.F().r.b()) {
            j3.e.c(j);
        }
        j3.f.b();
        I3 i3 = j3.d;
        i3.a.h();
        if (i3.a.a.o()) {
            i3.b(i3.a.a.c().currentTimeMillis(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        h();
        if (this.c == null) {
            this.c = new Ak8(Looper.getMainLooper());
        }
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2311u1
    protected final boolean n() {
        return false;
    }
}
