package com.google.android.gms.internal.vision;

import ir.nasim.InterfaceC18561or8;
import ir.nasim.Oq8;
import ir.nasim.Yq8;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
abstract class Q0 {
    private static final Class a = F();
    private static final f1 b = g(false);
    private static final f1 c = g(true);
    private static final f1 d = new g1();

    static int A(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC2195s0) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iJ0 = 0;
        for (int i = 0; i < size; i++) {
            iJ0 += zzii.j0(((Long) list.get(i)).longValue());
        }
        return iJ0;
    }

    public static f1 B() {
        return d;
    }

    public static void C(int i, List list, q1 q1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.a(i, list, z);
    }

    static int D(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return E(list) + (size * zzii.c0(i));
    }

    static int E(List list) {
        int iX0;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2182l0) {
            C2182l0 c2182l0 = (C2182l0) list;
            iX0 = 0;
            while (i < size) {
                iX0 += zzii.x0(c2182l0.h(i));
                i++;
            }
        } else {
            iX0 = 0;
            while (i < size) {
                iX0 += zzii.x0(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iX0;
    }

    private static Class F() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void G(int i, List list, q1 q1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.C(i, list, z);
    }

    static int H(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return I(list) + (size * zzii.c0(i));
    }

    static int I(List list) {
        int iG0;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2182l0) {
            C2182l0 c2182l0 = (C2182l0) list;
            iG0 = 0;
            while (i < size) {
                iG0 += zzii.g0(c2182l0.h(i));
                i++;
            }
        } else {
            iG0 = 0;
            while (i < size) {
                iG0 += zzii.g0(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iG0;
    }

    private static Class J() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void K(int i, List list, q1 q1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.b(i, list, z);
    }

    static int L(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return M(list) + (size * zzii.c0(i));
    }

    static int M(List list) {
        int iK0;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2182l0) {
            C2182l0 c2182l0 = (C2182l0) list;
            iK0 = 0;
            while (i < size) {
                iK0 += zzii.k0(c2182l0.h(i));
                i++;
            }
        } else {
            iK0 = 0;
            while (i < size) {
                iK0 += zzii.k0(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iK0;
    }

    public static void N(int i, List list, q1 q1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.B(i, list, z);
    }

    static int O(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return P(list) + (size * zzii.c0(i));
    }

    static int P(List list) {
        int iO0;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2182l0) {
            C2182l0 c2182l0 = (C2182l0) list;
            iO0 = 0;
            while (i < size) {
                iO0 += zzii.o0(c2182l0.h(i));
                i++;
            }
        } else {
            iO0 = 0;
            while (i < size) {
                iO0 += zzii.o0(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iO0;
    }

    public static void Q(int i, List list, q1 q1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.c(i, list, z);
    }

    static int R(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.t0(i, 0);
    }

    static int S(List list) {
        return list.size() << 2;
    }

    public static void T(int i, List list, q1 q1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.g(i, list, z);
    }

    static int U(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.m0(i, 0L);
    }

    static int V(List list) {
        return list.size() << 3;
    }

    public static void W(int i, List list, q1 q1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.d(i, list, z);
    }

    static int X(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.D(i, true);
    }

    static int Y(List list) {
        return list.size();
    }

    public static void Z(int i, List list, q1 q1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.s(i, list, z);
    }

    static int a(int i, Object obj, P0 p0) {
        return zzii.B(i, (InterfaceC18561or8) obj, p0);
    }

    public static void a0(int i, List list, q1 q1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.m(i, list, z);
    }

    static int b(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iC0 = zzii.c0(i) * size;
        if (list instanceof Yq8) {
            Yq8 yq8 = (Yq8) list;
            while (i2 < size) {
                Object objL = yq8.l(i2);
                iC0 += objL instanceof K ? zzii.E((K) objL) : zzii.G((String) objL);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iC0 += obj instanceof K ? zzii.E((K) obj) : zzii.G((String) obj);
                i2++;
            }
        }
        return iC0;
    }

    public static void b0(int i, List list, q1 q1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.A(i, list, z);
    }

    static int c(int i, List list, P0 p0) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iC0 = zzii.c0(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            iC0 += zzii.c((InterfaceC18561or8) list.get(i2), p0);
        }
        return iC0;
    }

    public static void c0(int i, List list, q1 q1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.y(i, list, z);
    }

    static int d(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return e(list) + (list.size() * zzii.c0(i));
    }

    public static void d0(int i, List list, q1 q1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.x(i, list, z);
    }

    static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC2195s0) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iZ = 0;
        for (int i = 0; i < size; i++) {
            iZ += zzii.Z(((Long) list.get(i)).longValue());
        }
        return iZ;
    }

    public static f1 f() {
        return b;
    }

    private static f1 g(boolean z) {
        try {
            Class clsJ = J();
            if (clsJ == null) {
                return null;
            }
            return (f1) clsJ.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    static Object h(int i, int i2, Object obj, f1 f1Var) {
        if (obj == null) {
            obj = f1Var.a();
        }
        f1Var.b(obj, i, i2);
        return obj;
    }

    static Object i(int i, List list, Oq8 oq8, Object obj, f1 f1Var) {
        if (oq8 == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (oq8.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj = h(i, iIntValue, obj, f1Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!oq8.zza(iIntValue2)) {
                    obj = h(i, iIntValue2, obj, f1Var);
                    it.remove();
                }
            }
        }
        return obj;
    }

    public static void j(int i, List list, q1 q1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.w(i, list);
    }

    public static void k(int i, List list, q1 q1Var, P0 p0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.N(i, list, p0);
    }

    public static void l(int i, List list, q1 q1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.e(i, list, z);
    }

    static void m(AbstractC2166d0 abstractC2166d0, Object obj, Object obj2) {
        C2172g0 c2172g0B = abstractC2166d0.b(obj2);
        if (c2172g0B.a.isEmpty()) {
            return;
        }
        abstractC2166d0.e(obj).c(c2172g0B);
    }

    static void n(B0 b0, Object obj, Object obj2, long j) {
        i1.j(obj, j, b0.c(i1.F(obj, j), i1.F(obj2, j)));
    }

    static void o(f1 f1Var, Object obj, Object obj2) {
        f1Var.e(obj, f1Var.i(f1Var.f(obj), f1Var.f(obj2)));
    }

    public static void p(Class cls) {
        Class cls2;
        if (!AbstractC2178j0.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean q(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int r(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iC0 = size * zzii.c0(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iC0 += zzii.E((K) list.get(i2));
        }
        return iC0;
    }

    static int s(int i, List list, P0 p0) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iQ = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iQ += zzii.Q(i, (InterfaceC18561or8) list.get(i2), p0);
        }
        return iQ;
    }

    static int t(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return u(list) + (size * zzii.c0(i));
    }

    static int u(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC2195s0) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iE0 = 0;
        for (int i = 0; i < size; i++) {
            iE0 += zzii.e0(((Long) list.get(i)).longValue());
        }
        return iE0;
    }

    public static f1 v() {
        return c;
    }

    public static void w(int i, List list, q1 q1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.t(i, list);
    }

    public static void x(int i, List list, q1 q1Var, P0 p0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.K(i, list, p0);
    }

    public static void y(int i, List list, q1 q1Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q1Var.D(i, list, z);
    }

    static int z(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return A(list) + (size * zzii.c0(i));
    }
}
