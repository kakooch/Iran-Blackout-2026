package com.google.android.gms.internal.vision;

import ir.nasim.AbstractC19162ps8;
import ir.nasim.InterfaceC18561or8;
import ir.nasim.Yq8;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class Z implements q1 {
    private final zzii a;

    private Z(zzii zziiVar) {
        zzii zziiVar2 = (zzii) AbstractC2184m0.f(zziiVar, "output");
        this.a = zziiVar2;
        zziiVar2.a = this;
    }

    public static Z h(zzii zziiVar) {
        Z z = zziiVar.a;
        return z != null ? z : new Z(zziiVar);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void A(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.f0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.k(i, 2);
        int iV0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iV0 += zzii.v0(((Integer) list.get(i3)).intValue());
        }
        this.a.K(iV0);
        while (i2 < list.size()) {
            this.a.a0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void B(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.U(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.k(i, 2);
        int iN0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iN0 += zzii.n0(((Long) list.get(i3)).longValue());
        }
        this.a.K(iN0);
        while (i2 < list.size()) {
            this.a.V(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void C(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.l(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.k(i, 2);
        int iE0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iE0 += zzii.e0(((Long) list.get(i3)).longValue());
        }
        this.a.K(iE0);
        while (i2 < list.size()) {
            this.a.r(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void D(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.j(i, ((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        this.a.k(i, 2);
        int iY = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iY += zzii.y(((Float) list.get(i3)).floatValue());
        }
        this.a.K(iY);
        while (i2 < list.size()) {
            this.a.g(((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void E(int i, boolean z) {
        this.a.q(i, z);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void F(int i, int i2) {
        this.a.L(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void G(int i, long j) {
        this.a.U(i, j);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void H(int i, long j) {
        this.a.M(i, j);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void I(int i, K k) {
        this.a.m(i, k);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void J(int i, AbstractC2209z0 abstractC2209z0, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.a.k(i, 2);
            this.a.K(AbstractC2203w0.a(abstractC2209z0, entry.getKey(), entry.getValue()));
            AbstractC2203w0.b(this.a, abstractC2209z0, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void K(int i, List list, P0 p0) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            M(i, list.get(i2), p0);
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void L(int i, Object obj, P0 p0) {
        this.a.o(i, (InterfaceC18561or8) obj, p0);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void M(int i, Object obj, P0 p0) {
        zzii zziiVar = this.a;
        zziiVar.k(i, 3);
        p0.e((InterfaceC18561or8) obj, zziiVar.a);
        zziiVar.k(i, 4);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void N(int i, List list, P0 p0) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            L(i, list.get(i2), p0);
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void a(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.l(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.k(i, 2);
        int iZ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZ += zzii.Z(((Long) list.get(i3)).longValue());
        }
        this.a.K(iZ);
        while (i2 < list.size()) {
            this.a.r(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void b(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.M(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.k(i, 2);
        int iJ0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iJ0 += zzii.j0(((Long) list.get(i3)).longValue());
        }
        this.a.K(iJ0);
        while (i2 < list.size()) {
            this.a.O(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void c(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.U(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.k(i, 2);
        int iR0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iR0 += zzii.r0(((Long) list.get(i3)).longValue());
        }
        this.a.K(iR0);
        while (i2 < list.size()) {
            this.a.V(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void d(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.T(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.k(i, 2);
        int iK0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iK0 += zzii.k0(((Integer) list.get(i3)).intValue());
        }
        this.a.K(iK0);
        while (i2 < list.size()) {
            this.a.K(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void e(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.i(i, ((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        this.a.k(i, 2);
        int iX = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iX += zzii.x(((Double) list.get(i3)).doubleValue());
        }
        this.a.K(iX);
        while (i2 < list.size()) {
            this.a.f(((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void f(int i, long j) {
        this.a.U(i, j);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void g(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.L(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.k(i, 2);
        int iG0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iG0 += zzii.g0(((Integer) list.get(i3)).intValue());
        }
        this.a.K(iG0);
        while (i2 < list.size()) {
            this.a.h(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void i(int i, int i2) {
        this.a.L(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void j(int i, long j) {
        this.a.l(i, j);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void k(int i, Object obj) {
        if (obj instanceof K) {
            this.a.N(i, (K) obj);
        } else {
            this.a.n(i, (InterfaceC18561or8) obj);
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void l(int i) {
        this.a.k(i, 4);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void m(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.f0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.k(i, 2);
        int iS0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iS0 += zzii.s0(((Integer) list.get(i3)).intValue());
        }
        this.a.K(iS0);
        while (i2 < list.size()) {
            this.a.a0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void n(int i, int i2) {
        this.a.f0(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void o(int i, long j) {
        this.a.l(i, j);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void p(int i, double d) {
        this.a.i(i, d);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void q(int i, float f) {
        this.a.j(i, f);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void r(int i, int i2) {
        this.a.b0(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void s(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.b0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.k(i, 2);
        int iO0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iO0 += zzii.o0(((Integer) list.get(i3)).intValue());
        }
        this.a.K(iO0);
        while (i2 < list.size()) {
            this.a.S(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void t(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.m(i, (K) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void u(int i, int i2) {
        this.a.f0(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void v(int i, int i2) {
        this.a.T(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void w(int i, List list) {
        int i2 = 0;
        if (!(list instanceof Yq8)) {
            while (i2 < list.size()) {
                this.a.p(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        Yq8 yq8 = (Yq8) list;
        while (i2 < list.size()) {
            Object objL = yq8.l(i2);
            if (objL instanceof String) {
                this.a.p(i, (String) objL);
            } else {
                this.a.m(i, (K) objL);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void x(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.q(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.a.k(i, 2);
        int iH = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iH += zzii.H(((Boolean) list.get(i3)).booleanValue());
        }
        this.a.K(iH);
        while (i2 < list.size()) {
            this.a.w(((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void y(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.L(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.k(i, 2);
        int iX0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iX0 += zzii.x0(((Integer) list.get(i3)).intValue());
        }
        this.a.K(iX0);
        while (i2 < list.size()) {
            this.a.h(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void z(int i, String str) {
        this.a.p(i, str);
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final int zza() {
        return AbstractC19162ps8.a;
    }

    @Override // com.google.android.gms.internal.vision.q1
    public final void zza(int i) {
        this.a.k(i, 3);
    }
}
