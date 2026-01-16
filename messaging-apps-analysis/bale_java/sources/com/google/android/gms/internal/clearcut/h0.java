package com.google.android.gms.internal.clearcut;

import ir.nasim.Hl8;
import ir.nasim.InterfaceC20302rm8;
import ir.nasim.InterfaceC23346wl8;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
abstract class h0 {
    private static final Class a = C();
    private static final l0 b = w(false);
    private static final l0 c = w(true);
    private static final l0 d = new n0();

    public static l0 A() {
        return c;
    }

    public static l0 B() {
        return d;
    }

    private static Class C() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class D() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static int E(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof A) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iW0 = 0;
        for (int i = 0; i < size; i++) {
            iW0 += zzbn.w0(((Integer) list.get(i)).intValue());
        }
        return iW0;
    }

    public static void F(int i, List list, v0 v0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.b(i, list, z);
    }

    static int G(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof A) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iX0 = 0;
        for (int i = 0; i < size; i++) {
            iX0 += zzbn.x0(((Integer) list.get(i)).intValue());
        }
        return iX0;
    }

    public static void H(int i, List list, v0 v0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.B(i, list, z);
    }

    public static void I(Class cls) {
        Class cls2;
        if (!AbstractC2101z.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static int J(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof A) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iY0 = 0;
        for (int i = 0; i < size; i++) {
            iY0 += zzbn.y0(((Integer) list.get(i)).intValue());
        }
        return iY0;
    }

    public static void K(int i, List list, v0 v0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.c(i, list, z);
    }

    static int L(List list) {
        return list.size() << 2;
    }

    public static void M(int i, List list, v0 v0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.g(i, list, z);
    }

    static int N(List list) {
        return list.size() << 3;
    }

    public static void O(int i, List list, v0 v0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.d(i, list, z);
    }

    static int P(List list) {
        return list.size();
    }

    public static void Q(int i, List list, v0 v0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.s(i, list, z);
    }

    public static void R(int i, List list, v0 v0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.m(i, list, z);
    }

    public static void S(int i, List list, v0 v0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.A(i, list, z);
    }

    public static void T(int i, List list, v0 v0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.y(i, list, z);
    }

    public static void U(int i, List list, v0 v0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.x(i, list, z);
    }

    static int V(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * zzbn.v0(i));
    }

    static int W(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return j(list) + (size * zzbn.v0(i));
    }

    static int X(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return q(list) + (size * zzbn.v0(i));
    }

    static int Y(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return v(list) + (size * zzbn.v0(i));
    }

    static int Z(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return E(list) + (size * zzbn.v0(i));
    }

    static int a(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof H) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iY = 0;
        for (int i = 0; i < size; i++) {
            iY += zzbn.Y(((Long) list.get(i)).longValue());
        }
        return iY;
    }

    static int a0(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return G(list) + (size * zzbn.v0(i));
    }

    private static Object b(int i, int i2, Object obj, l0 l0Var) {
        if (obj == null) {
            obj = l0Var.f();
        }
        l0Var.a(obj, i, i2);
        return obj;
    }

    static int b0(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return J(list) + (size * zzbn.v0(i));
    }

    static Object c(int i, List list, InterfaceC23346wl8 interfaceC23346wl8, Object obj, l0 l0Var) {
        if (interfaceC23346wl8 == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (interfaceC23346wl8.l(iIntValue) != null) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj = b(i, iIntValue, obj, l0Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (interfaceC23346wl8.l(iIntValue2) == null) {
                    obj = b(i, iIntValue2, obj, l0Var);
                    it.remove();
                }
            }
        }
        return obj;
    }

    static int c0(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.n0(i, 0);
    }

    public static void d(int i, List list, v0 v0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.w(i, list);
    }

    static int d0(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.e0(i, 0L);
    }

    public static void e(int i, List list, v0 v0Var, InterfaceC2082f0 interfaceC2082f0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.F(i, list, interfaceC2082f0);
    }

    static int e0(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.N(i, true);
    }

    public static void f(int i, List list, v0 v0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.e(i, list, z);
    }

    static void g(AbstractC2095t abstractC2095t, Object obj, Object obj2) {
        AbstractC2099x abstractC2099xB = abstractC2095t.b(obj2);
        if (abstractC2099xB.b()) {
            return;
        }
        abstractC2095t.e(obj).f(abstractC2099xB);
    }

    static void h(O o, Object obj, Object obj2, long j) {
        o0.i(obj, j, o.d(o0.M(obj, j), o0.M(obj2, j)));
    }

    static void i(l0 l0Var, Object obj, Object obj2) {
        l0Var.g(obj, l0Var.i(l0Var.k(obj), l0Var.k(obj2)));
    }

    static int j(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof H) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iB0 = 0;
        for (int i = 0; i < size; i++) {
            iB0 += zzbn.b0(((Long) list.get(i)).longValue());
        }
        return iB0;
    }

    public static void k(int i, List list, v0 v0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.t(i, list);
    }

    public static void l(int i, List list, v0 v0Var, InterfaceC2082f0 interfaceC2082f0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.E(i, list, interfaceC2082f0);
    }

    public static void m(int i, List list, v0 v0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.D(i, list, z);
    }

    static int n(int i, Object obj, InterfaceC2082f0 interfaceC2082f0) {
        return zzbn.y(i, (InterfaceC20302rm8) obj, interfaceC2082f0);
    }

    static int o(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iV0 = zzbn.v0(i) * size;
        if (list instanceof Hl8) {
            Hl8 hl8 = (Hl8) list;
            while (i2 < size) {
                Object objQ = hl8.q(i2);
                iV0 += objQ instanceof AbstractC2081f ? zzbn.A((AbstractC2081f) objQ) : zzbn.k0((String) objQ);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iV0 += obj instanceof AbstractC2081f ? zzbn.A((AbstractC2081f) obj) : zzbn.k0((String) obj);
                i2++;
            }
        }
        return iV0;
    }

    static int p(int i, List list, InterfaceC2082f0 interfaceC2082f0) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iV0 = zzbn.v0(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            iV0 += zzbn.B((InterfaceC20302rm8) list.get(i2), interfaceC2082f0);
        }
        return iV0;
    }

    static int q(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof H) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iF0 = 0;
        for (int i = 0; i < size; i++) {
            iF0 += zzbn.f0(((Long) list.get(i)).longValue());
        }
        return iF0;
    }

    public static void r(int i, List list, v0 v0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.a(i, list, z);
    }

    public static boolean s(int i, int i2, int i3) {
        if (i2 < 40) {
            return true;
        }
        long j = i2 - i;
        long j2 = i3;
        return j + 10 <= ((2 * j2) + 3) + ((j2 + 3) * 3);
    }

    static int t(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iV0 = size * zzbn.v0(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iV0 += zzbn.A((AbstractC2081f) list.get(i2));
        }
        return iV0;
    }

    static int u(int i, List list, InterfaceC2082f0 interfaceC2082f0) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iM += zzbn.M(i, (InterfaceC20302rm8) list.get(i2), interfaceC2082f0);
        }
        return iM;
    }

    static int v(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof A) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iB0 = 0;
        for (int i = 0; i < size; i++) {
            iB0 += zzbn.B0(((Integer) list.get(i)).intValue());
        }
        return iB0;
    }

    private static l0 w(boolean z) {
        try {
            Class clsD = D();
            if (clsD == null) {
                return null;
            }
            return (l0) clsD.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void x(int i, List list, v0 v0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        v0Var.C(i, list, z);
    }

    static boolean y(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static l0 z() {
        return b;
    }
}
