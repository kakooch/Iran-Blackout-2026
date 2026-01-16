package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.B;
import androidx.datastore.preferences.protobuf.g0;
import androidx.datastore.preferences.protobuf.h0;
import ir.nasim.InterfaceC4387Ex3;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1940i implements h0 {
    private final CodedOutputStream a;

    /* renamed from: androidx.datastore.preferences.protobuf.i$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g0.b.values().length];
            a = iArr;
            try {
                iArr[g0.b.j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g0.b.i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[g0.b.g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[g0.b.q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[g0.b.s.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[g0.b.o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[g0.b.h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[g0.b.e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[g0.b.r.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[g0.b.t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[g0.b.f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[g0.b.k.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private C1940i(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) AbstractC1952v.b(codedOutputStream, "output");
        this.a = codedOutputStream2;
        codedOutputStream2.a = this;
    }

    public static C1940i P(CodedOutputStream codedOutputStream) {
        C1940i c1940i = codedOutputStream.a;
        return c1940i != null ? c1940i : new C1940i(codedOutputStream);
    }

    private void Q(int i, boolean z, Object obj, B.a aVar) {
        this.a.N0(i, 2);
        this.a.P0(B.b(aVar, Boolean.valueOf(z), obj));
        B.e(this.a, aVar, Boolean.valueOf(z), obj);
    }

    private void R(int i, B.a aVar, Map map) {
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
            this.a.N0(i, 2);
            this.a.P0(B.b(aVar, Integer.valueOf(i4), obj));
            B.e(this.a, aVar, Integer.valueOf(i4), obj);
        }
    }

    private void S(int i, B.a aVar, Map map) {
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
            this.a.N0(i, 2);
            this.a.P0(B.b(aVar, Long.valueOf(j), obj));
            B.e(this.a, aVar, Long.valueOf(j), obj);
        }
    }

    private void T(int i, B.a aVar, Map map) {
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

    private void U(int i, B.a aVar, Map map) {
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
            this.a.N0(i, 2);
            this.a.P0(B.b(aVar, str, obj));
            B.e(this.a, aVar, str, obj);
        }
    }

    private void V(int i, Object obj) {
        if (obj instanceof String) {
            this.a.L0(i, (String) obj);
        } else {
            this.a.f0(i, (AbstractC1937f) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void A(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.b0(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int iD = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iD += CodedOutputStream.d(((Boolean) list.get(i3)).booleanValue());
        }
        this.a.P0(iD);
        while (i2 < list.size()) {
            this.a.c0(((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void B(int i, float f) {
        this.a.p0(i, f);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void C(int i) {
        this.a.N0(i, 4);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void D(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.H0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int iK = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iK += CodedOutputStream.K(((Integer) list.get(i3)).intValue());
        }
        this.a.P0(iK);
        while (i2 < list.size()) {
            this.a.I0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void E(int i, int i2) {
        this.a.j0(i, i2);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void F(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.x0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int iX = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iX += CodedOutputStream.x(((Long) list.get(i3)).longValue());
        }
        this.a.P0(iX);
        while (i2 < list.size()) {
            this.a.y0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void G(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.h0(i, ((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.i(((Double) list.get(i4)).doubleValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.i0(((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void H(int i, int i2) {
        this.a.H0(i, i2);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void I(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.f0(i, (AbstractC1937f) list.get(i2));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void J(int i, List list, V v) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            N(i, list.get(i2), v);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void K(int i, AbstractC1937f abstractC1937f) {
        this.a.f0(i, abstractC1937f);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void L(int i, Object obj, V v) {
        this.a.z0(i, (I) obj, v);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void M(int i, B.a aVar, Map map) {
        if (this.a.Y()) {
            T(i, aVar, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.a.N0(i, 2);
            this.a.P0(B.b(aVar, entry.getKey(), entry.getValue()));
            B.e(this.a, aVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void N(int i, Object obj, V v) {
        this.a.s0(i, (I) obj, v);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void O(int i, List list, V v) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            L(i, list.get(i2), v);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void a(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.p0(i, ((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int iQ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iQ += CodedOutputStream.q(((Float) list.get(i3)).floatValue());
        }
        this.a.P0(iQ);
        while (i2 < list.size()) {
            this.a.q0(((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final void b(int i, Object obj) {
        if (obj instanceof AbstractC1937f) {
            this.a.C0(i, (AbstractC1937f) obj);
        } else {
            this.a.B0(i, (I) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void c(int i, int i2) {
        this.a.l0(i, i2);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void d(int i, List list) {
        int i2 = 0;
        if (!(list instanceof InterfaceC4387Ex3)) {
            while (i2 < list.size()) {
                this.a.L0(i, (String) list.get(i2));
                i2++;
            }
        } else {
            InterfaceC4387Ex3 interfaceC4387Ex3 = (InterfaceC4387Ex3) list;
            while (i2 < list.size()) {
                V(i, interfaceC4387Ex3.q(i2));
                i2++;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void e(int i, String str) {
        this.a.L0(i, str);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void f(int i, long j) {
        this.a.Q0(i, j);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void g(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.v0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int iV = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iV += CodedOutputStream.v(((Integer) list.get(i3)).intValue());
        }
        this.a.P0(iV);
        while (i2 < list.size()) {
            this.a.w0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void h(int i, int i2) {
        this.a.v0(i, i2);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void i(int i, long j) {
        this.a.F0(i, j);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void j(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.l0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int iM = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM += CodedOutputStream.m(((Integer) list.get(i3)).intValue());
        }
        this.a.P0(iM);
        while (i2 < list.size()) {
            this.a.m0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void k(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.O0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int iR = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iR += CodedOutputStream.R(((Integer) list.get(i3)).intValue());
        }
        this.a.P0(iR);
        while (i2 < list.size()) {
            this.a.P0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void l(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.J0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int iM = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM += CodedOutputStream.M(((Long) list.get(i3)).longValue());
        }
        this.a.P0(iM);
        while (i2 < list.size()) {
            this.a.K0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void m(int i, long j) {
        this.a.J0(i, j);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void n(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.j0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int iK = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iK += CodedOutputStream.k(((Integer) list.get(i3)).intValue());
        }
        this.a.P0(iK);
        while (i2 < list.size()) {
            this.a.k0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void o(int i, int i2) {
        this.a.O0(i, i2);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void p(int i, double d) {
        this.a.h0(i, d);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void q(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.F0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int I = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            I += CodedOutputStream.I(((Long) list.get(i3)).longValue());
        }
        this.a.P0(I);
        while (i2 < list.size()) {
            this.a.G0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void r(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.Q0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int iT = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iT += CodedOutputStream.T(((Long) list.get(i3)).longValue());
        }
        this.a.P0(iT);
        while (i2 < list.size()) {
            this.a.R0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void s(int i, long j) {
        this.a.n0(i, j);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public h0.a t() {
        return h0.a.ASCENDING;
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void u(int i, long j) {
        this.a.x0(i, j);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void v(int i, boolean z) {
        this.a.b0(i, z);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void w(int i, int i2) {
        this.a.D0(i, i2);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void x(int i) {
        this.a.N0(i, 3);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void y(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.n0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int iO = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iO += CodedOutputStream.o(((Long) list.get(i3)).longValue());
        }
        this.a.P0(iO);
        while (i2 < list.size()) {
            this.a.o0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void z(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.D0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int iG = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iG += CodedOutputStream.G(((Integer) list.get(i3)).intValue());
        }
        this.a.P0(iG);
        while (i2 < list.size()) {
            this.a.E0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }
}
