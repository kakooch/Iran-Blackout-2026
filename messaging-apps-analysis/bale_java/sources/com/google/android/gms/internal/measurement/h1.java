package com.google.android.gms.internal.measurement;

import ir.nasim.AbstractC18350oW3;
import ir.nasim.Qr8;

/* loaded from: classes3.dex */
final class h1 implements o1 {
    private final Qr8 a;
    private final s1 b;
    private final boolean c;
    private final I0 d;

    private h1(s1 s1Var, I0 i0, Qr8 qr8) {
        this.b = s1Var;
        this.c = i0.c(qr8);
        this.d = i0;
        this.a = qr8;
    }

    static h1 b(s1 s1Var, I0 i0, Qr8 qr8) {
        return new h1(s1Var, i0, qr8);
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final boolean a(Object obj) {
        this.d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final Object g() {
        Qr8 qr8 = this.a;
        return qr8 instanceof P0 ? ((P0) qr8).i() : qr8.c().S();
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final int h(Object obj) {
        s1 s1Var = this.b;
        int iB = s1Var.b(s1Var.d(obj));
        if (!this.c) {
            return iB;
        }
        this.d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final int i(Object obj) {
        int iHashCode = this.b.d(obj).hashCode();
        if (!this.c) {
            return iHashCode;
        }
        this.d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final void j(Object obj) {
        this.b.g(obj);
        this.d.b(obj);
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final void k(Object obj, Object obj2) {
        q1.f(this.b, obj, obj2);
        if (this.c) {
            q1.e(this.d, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final void l(Object obj, F1 f1) {
        this.d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final boolean m(Object obj, Object obj2) {
        if (!this.b.d(obj).equals(this.b.d(obj2))) {
            return false;
        }
        if (!this.c) {
            return true;
        }
        this.d.a(obj);
        this.d.a(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final void n(Object obj, byte[] bArr, int i, int i2, C2142r0 c2142r0) {
        P0 p0 = (P0) obj;
        if (p0.zzc == t1.c()) {
            p0.zzc = t1.f();
        }
        AbstractC18350oW3.a(obj);
        throw null;
    }
}
