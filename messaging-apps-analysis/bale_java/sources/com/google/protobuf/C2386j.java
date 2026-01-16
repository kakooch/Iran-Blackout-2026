package com.google.protobuf;

import com.google.protobuf.I;
import com.google.protobuf.r0;
import com.google.protobuf.s0;
import ir.nasim.InterfaceC3919Cx3;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.protobuf.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2386j implements s0 {
    private final CodedOutputStream a;

    /* renamed from: com.google.protobuf.j$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r0.b.values().length];
            a = iArr;
            try {
                iArr[r0.b.j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r0.b.i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[r0.b.g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[r0.b.q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[r0.b.s.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[r0.b.o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[r0.b.h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[r0.b.e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[r0.b.r.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[r0.b.t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[r0.b.f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[r0.b.k.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private C2386j(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) B.b(codedOutputStream, "output");
        this.a = codedOutputStream2;
        codedOutputStream2.a = this;
    }

    public static C2386j P(CodedOutputStream codedOutputStream) {
        C2386j c2386j = codedOutputStream.a;
        return c2386j != null ? c2386j : new C2386j(codedOutputStream);
    }

    private void Q(int i, boolean z, Object obj, I.a aVar) {
        this.a.T0(i, 2);
        this.a.V0(I.b(aVar, Boolean.valueOf(z), obj));
        I.e(this.a, aVar, Boolean.valueOf(z), obj);
    }

    private void R(int i, I.a aVar, Map map) {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = ((Integer) it.next()).intValue();
            i2++;
        }
        Arrays.sort(iArr);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            Object obj = map.get(Integer.valueOf(i4));
            this.a.T0(i, 2);
            this.a.V0(I.b(aVar, Integer.valueOf(i4), obj));
            I.e(this.a, aVar, Integer.valueOf(i4), obj);
        }
    }

    private void S(int i, I.a aVar, Map map) {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            jArr[i2] = ((Long) it.next()).longValue();
            i2++;
        }
        Arrays.sort(jArr);
        for (int i3 = 0; i3 < size; i3++) {
            long j = jArr[i3];
            Object obj = map.get(Long.valueOf(j));
            this.a.T0(i, 2);
            this.a.V0(I.b(aVar, Long.valueOf(j), obj));
            I.e(this.a, aVar, Long.valueOf(j), obj);
        }
    }

    private void T(int i, I.a aVar, Map map) {
        switch (a.a[aVar.a.ordinal()]) {
            case 1:
                Object obj = map.get(Boolean.FALSE);
                if (obj != null) {
                    Q(i, false, obj, aVar);
                }
                Object obj2 = map.get(Boolean.TRUE);
                if (obj2 != null) {
                    Q(i, true, obj2, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                R(i, aVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                S(i, aVar, map);
                return;
            case 12:
                U(i, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.a);
        }
    }

    private void U(int i, I.a aVar, Map map) {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            strArr[i2] = (String) it.next();
            i2++;
        }
        Arrays.sort(strArr);
        for (int i3 = 0; i3 < size; i3++) {
            String str = strArr[i3];
            Object obj = map.get(str);
            this.a.T0(i, 2);
            this.a.V0(I.b(aVar, str, obj));
            I.e(this.a, aVar, str, obj);
        }
    }

    private void V(int i, Object obj) {
        if (obj instanceof String) {
            this.a.R0(i, (String) obj);
        } else {
            this.a.l0(i, (AbstractC2383g) obj);
        }
    }

    @Override // com.google.protobuf.s0
    public void A(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.h0(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.a.T0(i, 2);
        int iF = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iF += CodedOutputStream.f(((Boolean) list.get(i3)).booleanValue());
        }
        this.a.V0(iF);
        while (i2 < list.size()) {
            this.a.i0(((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.s0
    public void B(int i, float f) {
        this.a.v0(i, f);
    }

    @Override // com.google.protobuf.s0
    public void C(int i) {
        this.a.T0(i, 4);
    }

    @Override // com.google.protobuf.s0
    public void D(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.N0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.T0(i, 2);
        int iN = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iN += CodedOutputStream.N(((Integer) list.get(i3)).intValue());
        }
        this.a.V0(iN);
        while (i2 < list.size()) {
            this.a.O0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.s0
    public void E(int i, int i2) {
        this.a.p0(i, i2);
    }

    @Override // com.google.protobuf.s0
    public void F(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.D0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.T0(i, 2);
        int iZ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZ += CodedOutputStream.z(((Long) list.get(i3)).longValue());
        }
        this.a.V0(iZ);
        while (i2 < list.size()) {
            this.a.E0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.s0
    public void G(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.n0(i, ((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        this.a.T0(i, 2);
        int iK = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iK += CodedOutputStream.k(((Double) list.get(i3)).doubleValue());
        }
        this.a.V0(iK);
        while (i2 < list.size()) {
            this.a.o0(((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.s0
    public void H(int i, int i2) {
        this.a.N0(i, i2);
    }

    @Override // com.google.protobuf.s0
    public void I(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.l0(i, (AbstractC2383g) list.get(i2));
        }
    }

    @Override // com.google.protobuf.s0
    public void J(int i, List list, e0 e0Var) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            N(i, list.get(i2), e0Var);
        }
    }

    @Override // com.google.protobuf.s0
    public void K(int i, Object obj, e0 e0Var) {
        this.a.y0(i, (P) obj, e0Var);
    }

    @Override // com.google.protobuf.s0
    public void L(int i, AbstractC2383g abstractC2383g) {
        this.a.l0(i, abstractC2383g);
    }

    @Override // com.google.protobuf.s0
    public void M(int i, List list, e0 e0Var) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            K(i, list.get(i2), e0Var);
        }
    }

    @Override // com.google.protobuf.s0
    public void N(int i, Object obj, e0 e0Var) {
        this.a.F0(i, (P) obj, e0Var);
    }

    @Override // com.google.protobuf.s0
    public void O(int i, I.a aVar, Map map) {
        if (this.a.b0()) {
            T(i, aVar, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.a.T0(i, 2);
            this.a.V0(I.b(aVar, entry.getKey(), entry.getValue()));
            I.e(this.a, aVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.protobuf.s0
    public void a(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.v0(i, ((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        this.a.T0(i, 2);
        int iS = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iS += CodedOutputStream.s(((Float) list.get(i3)).floatValue());
        }
        this.a.V0(iS);
        while (i2 < list.size()) {
            this.a.w0(((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.s0
    public final void b(int i, Object obj) {
        if (obj instanceof AbstractC2383g) {
            this.a.I0(i, (AbstractC2383g) obj);
        } else {
            this.a.H0(i, (P) obj);
        }
    }

    @Override // com.google.protobuf.s0
    public void c(int i, int i2) {
        this.a.r0(i, i2);
    }

    @Override // com.google.protobuf.s0
    public void d(int i, List list) {
        int i2 = 0;
        if (!(list instanceof InterfaceC3919Cx3)) {
            while (i2 < list.size()) {
                this.a.R0(i, (String) list.get(i2));
                i2++;
            }
        } else {
            InterfaceC3919Cx3 interfaceC3919Cx3 = (InterfaceC3919Cx3) list;
            while (i2 < list.size()) {
                V(i, interfaceC3919Cx3.q(i2));
                i2++;
            }
        }
    }

    @Override // com.google.protobuf.s0
    public void e(int i, String str) {
        this.a.R0(i, str);
    }

    @Override // com.google.protobuf.s0
    public void f(int i, long j) {
        this.a.W0(i, j);
    }

    @Override // com.google.protobuf.s0
    public void g(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.B0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.T0(i, 2);
        int iX = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iX += CodedOutputStream.x(((Integer) list.get(i3)).intValue());
        }
        this.a.V0(iX);
        while (i2 < list.size()) {
            this.a.C0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.s0
    public void h(int i, int i2) {
        this.a.B0(i, i2);
    }

    @Override // com.google.protobuf.s0
    public void i(int i, long j) {
        this.a.L0(i, j);
    }

    @Override // com.google.protobuf.s0
    public void j(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.r0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.T0(i, 2);
        int iO = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iO += CodedOutputStream.o(((Integer) list.get(i3)).intValue());
        }
        this.a.V0(iO);
        while (i2 < list.size()) {
            this.a.s0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.s0
    public void k(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.U0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.T0(i, 2);
        int iU = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iU += CodedOutputStream.U(((Integer) list.get(i3)).intValue());
        }
        this.a.V0(iU);
        while (i2 < list.size()) {
            this.a.V0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.s0
    public void l(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.P0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.T0(i, 2);
        int iP = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iP += CodedOutputStream.P(((Long) list.get(i3)).longValue());
        }
        this.a.V0(iP);
        while (i2 < list.size()) {
            this.a.Q0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.s0
    public void m(int i, long j) {
        this.a.P0(i, j);
    }

    @Override // com.google.protobuf.s0
    public void n(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.p0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.T0(i, 2);
        int iM = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM += CodedOutputStream.m(((Integer) list.get(i3)).intValue());
        }
        this.a.V0(iM);
        while (i2 < list.size()) {
            this.a.q0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.s0
    public void o(int i, int i2) {
        this.a.U0(i, i2);
    }

    @Override // com.google.protobuf.s0
    public void p(int i, double d) {
        this.a.n0(i, d);
    }

    @Override // com.google.protobuf.s0
    public void q(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.L0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.T0(i, 2);
        int iL = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iL += CodedOutputStream.L(((Long) list.get(i3)).longValue());
        }
        this.a.V0(iL);
        while (i2 < list.size()) {
            this.a.M0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.s0
    public void r(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.W0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.T0(i, 2);
        int iW = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iW += CodedOutputStream.W(((Long) list.get(i3)).longValue());
        }
        this.a.V0(iW);
        while (i2 < list.size()) {
            this.a.X0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.s0
    public void s(int i, long j) {
        this.a.t0(i, j);
    }

    @Override // com.google.protobuf.s0
    public s0.a t() {
        return s0.a.ASCENDING;
    }

    @Override // com.google.protobuf.s0
    public void u(int i, long j) {
        this.a.D0(i, j);
    }

    @Override // com.google.protobuf.s0
    public void v(int i, boolean z) {
        this.a.h0(i, z);
    }

    @Override // com.google.protobuf.s0
    public void w(int i, int i2) {
        this.a.J0(i, i2);
    }

    @Override // com.google.protobuf.s0
    public void x(int i) {
        this.a.T0(i, 3);
    }

    @Override // com.google.protobuf.s0
    public void y(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.t0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.T0(i, 2);
        int iQ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iQ += CodedOutputStream.q(((Long) list.get(i3)).longValue());
        }
        this.a.V0(iQ);
        while (i2 < list.size()) {
            this.a.u0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.s0
    public void z(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.J0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.T0(i, 2);
        int iJ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iJ += CodedOutputStream.J(((Integer) list.get(i3)).intValue());
        }
        this.a.V0(iJ);
        while (i2 < list.size()) {
            this.a.K0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }
}
