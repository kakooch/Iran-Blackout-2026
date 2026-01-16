package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.AbstractC2101z;
import ir.nasim.Hl8;
import ir.nasim.InterfaceC20302rm8;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.clearcut.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2094s implements v0 {
    private final zzbn a;

    private C2094s(zzbn zzbnVar) {
        zzbn zzbnVar2 = (zzbn) B.e(zzbnVar, "output");
        this.a = zzbnVar2;
        zzbnVar2.a = this;
    }

    public static C2094s l(zzbn zzbnVar) {
        C2094s c2094s = zzbnVar.a;
        return c2094s != null ? c2094s : new C2094s(zzbnVar);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void A(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.c0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.D(i, 2);
        int iA0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iA0 += zzbn.A0(((Integer) list.get(i3)).intValue());
        }
        this.a.s0(iA0);
        while (i2 < list.size()) {
            this.a.u0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void B(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.R(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.D(i, 2);
        int iJ0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iJ0 += zzbn.j0(((Long) list.get(i3)).longValue());
        }
        this.a.s0(iJ0);
        while (i2 < list.size()) {
            this.a.W(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void C(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.j(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.D(i, 2);
        int iB0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iB0 += zzbn.b0(((Long) list.get(i3)).longValue());
        }
        this.a.s0(iB0);
        while (i2 < list.size()) {
            this.a.I(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void D(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.i(i, ((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        this.a.D(i, 2);
        int iV = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iV += zzbn.v(((Float) list.get(i3)).floatValue());
        }
        this.a.s0(iV);
        while (i2 < list.size()) {
            this.a.g(((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void E(int i, List list, InterfaceC2082f0 interfaceC2082f0) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            J(i, list.get(i2), interfaceC2082f0);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void F(int i, List list, InterfaceC2082f0 interfaceC2082f0) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            I(i, list.get(i2), interfaceC2082f0);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void G(int i) {
        this.a.D(i, 4);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void H(int i, AbstractC2081f abstractC2081f) {
        this.a.k(i, abstractC2081f);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void I(int i, Object obj, InterfaceC2082f0 interfaceC2082f0) {
        this.a.m(i, (InterfaceC20302rm8) obj, interfaceC2082f0);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void J(int i, Object obj, InterfaceC2082f0 interfaceC2082f0) {
        zzbn zzbnVar = this.a;
        zzbnVar.D(i, 3);
        interfaceC2082f0.e((InterfaceC20302rm8) obj, zzbnVar.a);
        zzbnVar.D(i, 4);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final int K() {
        return AbstractC2101z.c.l;
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void L(int i, long j) {
        this.a.R(i, j);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void M(int i, long j) {
        this.a.j(i, j);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void N(int i, int i2) {
        this.a.Q(i, i2);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void O(int i) {
        this.a.D(i, 3);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void P(int i, M m, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.a.D(i, 2);
            this.a.s0(L.a(m, entry.getKey(), entry.getValue()));
            L.b(this.a, m, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void Q(int i, int i2) {
        this.a.c0(i, i2);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void a(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.j(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.D(i, 2);
        int iY = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iY += zzbn.Y(((Long) list.get(i3)).longValue());
        }
        this.a.s0(iY);
        while (i2 < list.size()) {
            this.a.I(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void b(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.E(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.D(i, 2);
        int iF0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iF0 += zzbn.f0(((Long) list.get(i3)).longValue());
        }
        this.a.s0(iF0);
        while (i2 < list.size()) {
            this.a.S(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void c(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.R(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.D(i, 2);
        int iM0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM0 += zzbn.m0(((Long) list.get(i3)).longValue());
        }
        this.a.s0(iM0);
        while (i2 < list.size()) {
            this.a.W(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void d(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.V(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.D(i, 2);
        int iX0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iX0 += zzbn.x0(((Integer) list.get(i3)).intValue());
        }
        this.a.s0(iX0);
        while (i2 < list.size()) {
            this.a.s0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void e(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.h(i, ((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        this.a.D(i, 2);
        int iU = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iU += zzbn.u(((Double) list.get(i3)).doubleValue());
        }
        this.a.s0(iU);
        while (i2 < list.size()) {
            this.a.f(((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void f(int i, long j) {
        this.a.E(i, j);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void g(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.Q(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.D(i, 2);
        int iW0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iW0 += zzbn.w0(((Integer) list.get(i3)).intValue());
        }
        this.a.s0(iW0);
        while (i2 < list.size()) {
            this.a.r0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void h(int i, boolean z) {
        this.a.H(i, z);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void i(int i, int i2) {
        this.a.Q(i, i2);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void j(int i, long j) {
        this.a.R(i, j);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void k(int i, Object obj) {
        if (obj instanceof AbstractC2081f) {
            this.a.F(i, (AbstractC2081f) obj);
        } else {
            this.a.G(i, (InterfaceC20302rm8) obj);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void m(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.c0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.D(i, 2);
        int iZ0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZ0 += zzbn.z0(((Integer) list.get(i3)).intValue());
        }
        this.a.s0(iZ0);
        while (i2 < list.size()) {
            this.a.u0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void o(int i, long j) {
        this.a.j(i, j);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void p(int i, double d) {
        this.a.h(i, d);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void q(int i, float f) {
        this.a.i(i, f);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void r(int i, int i2) {
        this.a.c0(i, i2);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void s(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.Z(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.D(i, 2);
        int iY0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iY0 += zzbn.y0(((Integer) list.get(i3)).intValue());
        }
        this.a.s0(iY0);
        while (i2 < list.size()) {
            this.a.t0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void t(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.k(i, (AbstractC2081f) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void u(int i, int i2) {
        this.a.V(i, i2);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void v(int i, int i2) {
        this.a.Z(i, i2);
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void w(int i, List list) {
        int i2 = 0;
        if (!(list instanceof Hl8)) {
            while (i2 < list.size()) {
                this.a.n(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        Hl8 hl8 = (Hl8) list;
        while (i2 < list.size()) {
            Object objQ = hl8.q(i2);
            if (objQ instanceof String) {
                this.a.n(i, (String) objQ);
            } else {
                this.a.k(i, (AbstractC2081f) objQ);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void x(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.H(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.a.D(i, 2);
        int iC = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iC += zzbn.C(((Boolean) list.get(i3)).booleanValue());
        }
        this.a.s0(iC);
        while (i2 < list.size()) {
            this.a.r(((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void y(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.Q(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.D(i, 2);
        int iB0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iB0 += zzbn.B0(((Integer) list.get(i3)).intValue());
        }
        this.a.s0(iB0);
        while (i2 < list.size()) {
            this.a.r0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.v0
    public final void z(int i, String str) {
        this.a.n(i, str);
    }
}
