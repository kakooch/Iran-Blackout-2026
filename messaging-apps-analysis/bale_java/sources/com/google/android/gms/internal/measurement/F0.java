package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC23996xr8;
import ir.nasim.Qr8;
import java.util.List;

/* loaded from: classes3.dex */
final class F0 implements F1 {
    private final E0 a;

    private F0(E0 e0) {
        R0.f(e0, "output");
        this.a = e0;
        e0.a = this;
    }

    public static F0 K(E0 e0) {
        F0 f0 = e0.a;
        return f0 != null ? f0 : new F0(e0);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void A(int i, int i2) {
        this.a.o(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void B(int i, List list) {
        int i2 = 0;
        if (!(list instanceof InterfaceC23996xr8)) {
            while (i2 < list.size()) {
                this.a.r(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        InterfaceC23996xr8 interfaceC23996xr8 = (InterfaceC23996xr8) list;
        while (i2 < list.size()) {
            Object objY = interfaceC23996xr8.y(i2);
            if (objY instanceof String) {
                this.a.r(i, (String) objY);
            } else {
                this.a.j(i, (A0) objY);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void C(int i, float f) {
        this.a.k(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void D(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                E0 e0 = this.a;
                int iIntValue = ((Integer) list.get(i2)).intValue();
                e0.t(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return;
        }
        this.a.s(i, 2);
        int iA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue2 = ((Integer) list.get(i3)).intValue();
            iA += E0.a((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        this.a.u(iA);
        while (i2 < list.size()) {
            E0 e02 = this.a;
            int iIntValue3 = ((Integer) list.get(i2)).intValue();
            e02.u((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void E(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.v(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.s(i, 2);
        int iB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iB += E0.b(((Long) list.get(i3)).longValue());
        }
        this.a.u(iB);
        while (i2 < list.size()) {
            this.a.w(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void F(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.k(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.s(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.a.u(i3);
        while (i2 < list.size()) {
            this.a.l(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void G(int i, long j) {
        this.a.v(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void H(int i, long j) {
        this.a.m(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void I(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                E0 e0 = this.a;
                long jLongValue = ((Long) list.get(i2)).longValue();
                e0.v(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        this.a.s(i, 2);
        int iB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iB += E0.b((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        this.a.u(iB);
        while (i2 < list.size()) {
            E0 e02 = this.a;
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            e02.w((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void J(int i, Object obj, o1 o1Var) throws zzjk {
        Qr8 qr8 = (Qr8) obj;
        D0 d0 = (D0) this.a;
        d0.u((i << 3) | 2);
        d0.u(((AbstractC2137o0) qr8).a(o1Var));
        o1Var.l(qr8, d0.a);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void a(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.i(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.a.s(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).booleanValue();
            i3++;
        }
        this.a.u(i3);
        while (i2 < list.size()) {
            this.a.h(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void b(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.m(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.s(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.a.u(i3);
        while (i2 < list.size()) {
            this.a.n(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void c(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.k(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.s(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.a.u(i3);
        while (i2 < list.size()) {
            this.a.l(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void d(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.o(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.s(i, 2);
        int iZ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZ += E0.z(((Integer) list.get(i3)).intValue());
        }
        this.a.u(iZ);
        while (i2 < list.size()) {
            this.a.p(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void e(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.m(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        this.a.s(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).doubleValue();
            i3 += 8;
        }
        this.a.u(i3);
        while (i2 < list.size()) {
            this.a.n(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void f(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.j(i, (A0) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void g(int i, int i2) {
        this.a.t(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void h(int i, boolean z) {
        this.a.i(i, z);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void i(int i, String str) {
        this.a.r(i, str);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void j(int i, long j) {
        this.a.v(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void k(int i, A0 a0) {
        this.a.j(i, a0);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void l(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.o(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.s(i, 2);
        int iZ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZ += E0.z(((Integer) list.get(i3)).intValue());
        }
        this.a.u(iZ);
        while (i2 < list.size()) {
            this.a.p(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void m(int i, int i2) {
        this.a.o(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void n(int i, double d) {
        this.a.m(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void o(int i, int i2) {
        this.a.k(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void p(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.v(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.s(i, 2);
        int iB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iB += E0.b(((Long) list.get(i3)).longValue());
        }
        this.a.u(iB);
        while (i2 < list.size()) {
            this.a.w(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void q(int i) {
        this.a.s(i, 3);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void r(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.k(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        this.a.s(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).floatValue();
            i3 += 4;
        }
        this.a.u(i3);
        while (i2 < list.size()) {
            this.a.l(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void s(int i, long j) {
        this.a.v(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void t(int i) {
        this.a.s(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void u(int i, int i2) {
        this.a.t(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void v(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.m(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.s(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.a.u(i3);
        while (i2 < list.size()) {
            this.a.n(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void w(int i, int i2) {
        this.a.k(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void x(int i, long j) {
        this.a.m(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void y(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.t(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.s(i, 2);
        int iA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iA += E0.a(((Integer) list.get(i3)).intValue());
        }
        this.a.u(iA);
        while (i2 < list.size()) {
            this.a.u(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.F1
    public final void z(int i, Object obj, o1 o1Var) {
        E0 e0 = this.a;
        e0.s(i, 3);
        o1Var.l((Qr8) obj, e0.a);
        e0.s(i, 4);
    }
}
