package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC17970nr8;
import ir.nasim.InterfaceC23996xr8;
import ir.nasim.Qr8;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
abstract class q1 {
    private static final Class a;
    private static final s1 b;
    private static final s1 c;
    private static final s1 d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        b = C(false);
        c = C(true);
        d = new u1();
    }

    static int A(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (E0.a(i << 3) + 1);
    }

    static void B(C2107b1 c2107b1, Object obj, Object obj2, long j) {
        z1.x(obj, j, C2107b1.b(z1.k(obj, j), z1.k(obj2, j)));
    }

    private static s1 C(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (s1) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int D(List list) {
        return list.size();
    }

    static int E(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iC = size * E0.C(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iC += E0.x((A0) list.get(i2));
        }
        return iC;
    }

    static int F(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return G(list) + (size * E0.C(i));
    }

    static int G(List list) {
        int iZ;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Q0) {
            Q0 q0 = (Q0) list;
            iZ = 0;
            while (i < size) {
                iZ += E0.z(q0.h(i));
                i++;
            }
        } else {
            iZ = 0;
            while (i < size) {
                iZ += E0.z(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZ;
    }

    static int H(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (E0.a(i << 3) + 4);
    }

    static int I(List list) {
        return list.size() * 4;
    }

    static int J(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (E0.a(i << 3) + 8);
    }

    static int K(List list) {
        return list.size() * 8;
    }

    static int L(int i, List list, o1 o1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iY += E0.y(i, (Qr8) list.get(i2), o1Var);
        }
        return iY;
    }

    static int M(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return N(list) + (size * E0.C(i));
    }

    static int N(List list) {
        int iZ;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Q0) {
            Q0 q0 = (Q0) list;
            iZ = 0;
            while (i < size) {
                iZ += E0.z(q0.h(i));
                i++;
            }
        } else {
            iZ = 0;
            while (i < size) {
                iZ += E0.z(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZ;
    }

    static int O(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return P(list) + (list.size() * E0.C(i));
    }

    static int P(List list) {
        int iB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof W0) {
            W0 w0 = (W0) list;
            iB = 0;
            while (i < size) {
                iB += E0.b(w0.zza(i));
                i++;
            }
        } else {
            iB = 0;
            while (i < size) {
                iB += E0.b(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iB;
    }

    static int Q(int i, Object obj, o1 o1Var) {
        return E0.a(i << 3) + E0.A((Qr8) obj, o1Var);
    }

    static int R(int i, List list, o1 o1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iC = E0.C(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            iC += E0.A((Qr8) list.get(i2), o1Var);
        }
        return iC;
    }

    static int S(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return T(list) + (size * E0.C(i));
    }

    static int T(List list) {
        int iA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Q0) {
            Q0 q0 = (Q0) list;
            iA = 0;
            while (i < size) {
                int iH = q0.h(i);
                iA += E0.a((iH >> 31) ^ (iH + iH));
                i++;
            }
        } else {
            iA = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iA += E0.a((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iA;
    }

    static int U(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return V(list) + (size * E0.C(i));
    }

    static int V(List list) {
        int iB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof W0) {
            W0 w0 = (W0) list;
            iB = 0;
            while (i < size) {
                long jZza = w0.zza(i);
                iB += E0.b((jZza >> 63) ^ (jZza + jZza));
                i++;
            }
        } else {
            iB = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iB += E0.b((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iB;
    }

    static int W(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iC = E0.C(i) * size;
        if (list instanceof InterfaceC23996xr8) {
            InterfaceC23996xr8 interfaceC23996xr8 = (InterfaceC23996xr8) list;
            while (i2 < size) {
                Object objY = interfaceC23996xr8.y(i2);
                iC += objY instanceof A0 ? E0.x((A0) objY) : E0.B((String) objY);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iC += obj instanceof A0 ? E0.x((A0) obj) : E0.B((String) obj);
                i2++;
            }
        }
        return iC;
    }

    static int X(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return Y(list) + (size * E0.C(i));
    }

    static int Y(List list) {
        int iA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Q0) {
            Q0 q0 = (Q0) list;
            iA = 0;
            while (i < size) {
                iA += E0.a(q0.h(i));
                i++;
            }
        } else {
            iA = 0;
            while (i < size) {
                iA += E0.a(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iA;
    }

    static int Z(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return a0(list) + (size * E0.C(i));
    }

    public static s1 a() {
        return c;
    }

    static int a0(List list) {
        int iB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof W0) {
            W0 w0 = (W0) list;
            iB = 0;
            while (i < size) {
                iB += E0.b(w0.zza(i));
                i++;
            }
        } else {
            iB = 0;
            while (i < size) {
                iB += E0.b(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iB;
    }

    public static s1 b() {
        return d;
    }

    public static s1 b0() {
        return b;
    }

    static Object c(Object obj, int i, List list, InterfaceC17970nr8 interfaceC17970nr8, Object obj2, s1 s1Var) {
        Object objD = null;
        if (interfaceC17970nr8 == null) {
            return null;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (interfaceC17970nr8.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    objD = d(obj, i, iIntValue, objD, s1Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return objD;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!interfaceC17970nr8.zza(iIntValue2)) {
                    objD = d(obj, i, iIntValue2, objD, s1Var);
                    it.remove();
                }
            }
        }
        return objD;
    }

    static Object d(Object obj, int i, int i2, Object obj2, s1 s1Var) {
        if (obj2 == null) {
            obj2 = s1Var.c(obj);
        }
        s1Var.f(obj2, i, i2);
        return obj2;
    }

    static void e(I0 i0, Object obj, Object obj2) {
        i0.a(obj2);
        throw null;
    }

    static void f(s1 s1Var, Object obj, Object obj2) {
        s1Var.h(obj, s1Var.e(s1Var.d(obj), s1Var.d(obj2)));
    }

    public static void g(Class cls) {
        Class cls2;
        if (!P0.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void h(int i, List list, F1 f1, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.a(i, list, z);
    }

    public static void i(int i, List list, F1 f1) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.f(i, list);
    }

    public static void j(int i, List list, F1 f1, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.e(i, list, z);
    }

    public static void k(int i, List list, F1 f1, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.d(i, list, z);
    }

    public static void l(int i, List list, F1 f1, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.c(i, list, z);
    }

    public static void m(int i, List list, F1 f1, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.b(i, list, z);
    }

    public static void n(int i, List list, F1 f1, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.r(i, list, z);
    }

    public static void o(int i, List list, F1 f1, o1 o1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((F0) f1).z(i, list.get(i2), o1Var);
        }
    }

    public static void p(int i, List list, F1 f1, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.l(i, list, z);
    }

    public static void q(int i, List list, F1 f1, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.E(i, list, z);
    }

    public static void r(int i, List list, F1 f1, o1 o1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((F0) f1).J(i, list.get(i2), o1Var);
        }
    }

    public static void s(int i, List list, F1 f1, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.F(i, list, z);
    }

    public static void t(int i, List list, F1 f1, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.v(i, list, z);
    }

    public static void u(int i, List list, F1 f1, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.D(i, list, z);
    }

    public static void v(int i, List list, F1 f1, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.I(i, list, z);
    }

    public static void w(int i, List list, F1 f1) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.B(i, list);
    }

    public static void x(int i, List list, F1 f1, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.y(i, list, z);
    }

    public static void y(int i, List list, F1 f1, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        f1.p(i, list, z);
    }

    static boolean z(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
