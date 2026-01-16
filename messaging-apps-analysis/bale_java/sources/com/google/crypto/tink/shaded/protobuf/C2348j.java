package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.B;
import com.google.crypto.tink.shaded.protobuf.f0;
import com.google.crypto.tink.shaded.protobuf.g0;
import ir.nasim.InterfaceC3685Bx3;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.crypto.tink.shaded.protobuf.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2348j implements g0 {
    private final CodedOutputStream a;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.j$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[f0.b.values().length];
            a = iArr;
            try {
                iArr[f0.b.j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[f0.b.i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[f0.b.g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[f0.b.q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[f0.b.s.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[f0.b.o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[f0.b.h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[f0.b.e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[f0.b.r.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[f0.b.t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[f0.b.f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[f0.b.k.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private C2348j(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) AbstractC2360w.b(codedOutputStream, "output");
        this.a = codedOutputStream2;
        codedOutputStream2.a = this;
    }

    public static C2348j P(CodedOutputStream codedOutputStream) {
        C2348j c2348j = codedOutputStream.a;
        return c2348j != null ? c2348j : new C2348j(codedOutputStream);
    }

    private void Q(int i, B.a aVar, Map map) {
        int[] iArr = a.a;
        throw null;
    }

    private void R(int i, Object obj) {
        if (obj instanceof String) {
            this.a.C0(i, (String) obj);
        } else {
            this.a.a0(i, (AbstractC2345g) obj);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void A(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.Y(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.a.D0(i, 2);
        int iE = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iE += CodedOutputStream.e(((Boolean) list.get(i3)).booleanValue());
        }
        this.a.F0(iE);
        while (i2 < list.size()) {
            this.a.Z(((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void B(int i, float f) {
        this.a.j0(i, f);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void C(int i) {
        this.a.D0(i, 4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void D(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.y0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.D0(i, 2);
        int iG = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iG += CodedOutputStream.G(((Integer) list.get(i3)).intValue());
        }
        this.a.F0(iG);
        while (i2 < list.size()) {
            this.a.z0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void E(int i, int i2) {
        this.a.d0(i, i2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void F(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.p0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.D0(i, 2);
        int iW = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iW += CodedOutputStream.w(((Long) list.get(i3)).longValue());
        }
        this.a.F0(iW);
        while (i2 < list.size()) {
            this.a.q0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void G(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.b0(i, ((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        this.a.D0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.i(((Double) list.get(i4)).doubleValue());
        }
        this.a.F0(i3);
        while (i2 < list.size()) {
            this.a.c0(((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void H(int i, int i2) {
        this.a.y0(i, i2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void I(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.a0(i, (AbstractC2345g) list.get(i2));
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void J(int i, B.a aVar, Map map) {
        if (this.a.T()) {
            Q(i, aVar, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.a.D0(i, 2);
            this.a.F0(B.a(aVar, entry.getKey(), entry.getValue()));
            B.b(this.a, aVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void K(int i, Object obj, V v) {
        this.a.l0(i, (I) obj, v);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void L(int i, List list, V v) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            N(i, list.get(i2), v);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void M(int i, AbstractC2345g abstractC2345g) {
        this.a.a0(i, abstractC2345g);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void N(int i, Object obj, V v) {
        this.a.r0(i, (I) obj, v);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void O(int i, List list, V v) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            K(i, list.get(i2), v);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void a(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.j0(i, ((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        this.a.D0(i, 2);
        int iQ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iQ += CodedOutputStream.q(((Float) list.get(i3)).floatValue());
        }
        this.a.F0(iQ);
        while (i2 < list.size()) {
            this.a.k0(((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public final void b(int i, Object obj) {
        if (obj instanceof AbstractC2345g) {
            this.a.t0(i, (AbstractC2345g) obj);
        } else {
            this.a.s0(i, (I) obj);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void c(int i, int i2) {
        this.a.f0(i, i2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void d(int i, List list) {
        int i2 = 0;
        if (!(list instanceof InterfaceC3685Bx3)) {
            while (i2 < list.size()) {
                this.a.C0(i, (String) list.get(i2));
                i2++;
            }
        } else {
            InterfaceC3685Bx3 interfaceC3685Bx3 = (InterfaceC3685Bx3) list;
            while (i2 < list.size()) {
                R(i, interfaceC3685Bx3.q(i2));
                i2++;
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void e(int i, String str) {
        this.a.C0(i, str);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void f(int i, long j) {
        this.a.G0(i, j);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void g(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.n0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.D0(i, 2);
        int iU = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iU += CodedOutputStream.u(((Integer) list.get(i3)).intValue());
        }
        this.a.F0(iU);
        while (i2 < list.size()) {
            this.a.o0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void h(int i, int i2) {
        this.a.n0(i, i2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void i(int i, long j) {
        this.a.w0(i, j);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void j(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.f0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.D0(i, 2);
        int iM = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM += CodedOutputStream.m(((Integer) list.get(i3)).intValue());
        }
        this.a.F0(iM);
        while (i2 < list.size()) {
            this.a.g0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void k(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.E0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.D0(i, 2);
        int iN = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iN += CodedOutputStream.N(((Integer) list.get(i3)).intValue());
        }
        this.a.F0(iN);
        while (i2 < list.size()) {
            this.a.F0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void l(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.A0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.D0(i, 2);
        int I = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            I += CodedOutputStream.I(((Long) list.get(i3)).longValue());
        }
        this.a.F0(I);
        while (i2 < list.size()) {
            this.a.B0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void m(int i, long j) {
        this.a.A0(i, j);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void n(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.d0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.D0(i, 2);
        int iK = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iK += CodedOutputStream.k(((Integer) list.get(i3)).intValue());
        }
        this.a.F0(iK);
        while (i2 < list.size()) {
            this.a.e0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void o(int i, int i2) {
        this.a.E0(i, i2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void p(int i, double d) {
        this.a.b0(i, d);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void q(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.w0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.D0(i, 2);
        int iE = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iE += CodedOutputStream.E(((Long) list.get(i3)).longValue());
        }
        this.a.F0(iE);
        while (i2 < list.size()) {
            this.a.x0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void r(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.G0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.D0(i, 2);
        int iP = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iP += CodedOutputStream.P(((Long) list.get(i3)).longValue());
        }
        this.a.F0(iP);
        while (i2 < list.size()) {
            this.a.H0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void s(int i, long j) {
        this.a.h0(i, j);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public g0.a t() {
        return g0.a.ASCENDING;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void u(int i, long j) {
        this.a.p0(i, j);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void v(int i, boolean z) {
        this.a.Y(i, z);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void w(int i, int i2) {
        this.a.u0(i, i2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void x(int i) {
        this.a.D0(i, 3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void y(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.h0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.D0(i, 2);
        int iO = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iO += CodedOutputStream.o(((Long) list.get(i3)).longValue());
        }
        this.a.F0(iO);
        while (i2 < list.size()) {
            this.a.i0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g0
    public void z(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.u0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.D0(i, 2);
        int iC = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iC += CodedOutputStream.C(((Integer) list.get(i3)).intValue());
        }
        this.a.F0(iC);
        while (i2 < list.size()) {
            this.a.v0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }
}
