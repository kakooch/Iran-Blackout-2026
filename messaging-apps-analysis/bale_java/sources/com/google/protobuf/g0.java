package com.google.protobuf;

import com.google.protobuf.B;
import ir.nasim.InterfaceC3919Cx3;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
abstract class g0 {
    private static final Class a = B();
    private static final l0 b = C(false);
    private static final l0 c = C(true);
    private static final l0 d = new n0();

    static Object A(Object obj, int i, List list, B.e eVar, Object obj2, l0 l0Var) {
        if (eVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (eVar.a(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj2 = L(obj, i, iIntValue, obj2, l0Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!eVar.a(iIntValue2)) {
                    obj2 = L(obj, i, iIntValue2, obj2, l0Var);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    private static Class B() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static l0 C(boolean z) {
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

    private static Class D() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static void E(AbstractC2395t abstractC2395t, Object obj, Object obj2) {
        C2399x c2399xC = abstractC2395t.c(obj2);
        if (c2399xC.q()) {
            return;
        }
        abstractC2395t.d(obj).y(c2399xC);
    }

    static void F(K k, Object obj, Object obj2, long j) {
        o0.V(obj, j, k.a(o0.G(obj, j), o0.G(obj2, j)));
    }

    static void G(l0 l0Var, Object obj, Object obj2) {
        l0Var.p(obj, l0Var.k(l0Var.g(obj), l0Var.g(obj2)));
    }

    public static l0 H() {
        return b;
    }

    public static l0 I() {
        return c;
    }

    public static void J(Class cls) {
        Class cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
    }

    static boolean K(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static Object L(Object obj, int i, int i2, Object obj2, l0 l0Var) {
        if (obj2 == null) {
            obj2 = l0Var.f(obj);
        }
        l0Var.e(obj2, i, i2);
        return obj2;
    }

    public static l0 M() {
        return d;
    }

    public static void N(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.A(i, list, z);
    }

    public static void O(int i, List list, s0 s0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.I(i, list);
    }

    public static void P(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.G(i, list, z);
    }

    public static void Q(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.n(i, list, z);
    }

    public static void R(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.j(i, list, z);
    }

    public static void S(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.y(i, list, z);
    }

    public static void T(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.a(i, list, z);
    }

    public static void U(int i, List list, s0 s0Var, e0 e0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.M(i, list, e0Var);
    }

    public static void V(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.g(i, list, z);
    }

    public static void W(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.F(i, list, z);
    }

    public static void X(int i, List list, s0 s0Var, e0 e0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.J(i, list, e0Var);
    }

    public static void Y(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.z(i, list, z);
    }

    public static void Z(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.q(i, list, z);
    }

    static int a(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.S(i) + CodedOutputStream.A(size) : size * CodedOutputStream.e(i, true);
    }

    public static void a0(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.D(i, list, z);
    }

    static int b(List list) {
        return list.size();
    }

    public static void b0(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.l(i, list, z);
    }

    static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = size * CodedOutputStream.S(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iS += CodedOutputStream.i((AbstractC2383g) list.get(i2));
        }
        return iS;
    }

    public static void c0(int i, List list, s0 s0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.d(i, list);
    }

    static int d(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iE = e(list);
        return z ? CodedOutputStream.S(i) + CodedOutputStream.A(iE) : iE + (size * CodedOutputStream.S(i));
    }

    public static void d0(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.k(i, list, z);
    }

    static int e(List list) {
        int iM;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof A) {
            A a2 = (A) list;
            iM = 0;
            while (i < size) {
                iM += CodedOutputStream.m(a2.getInt(i));
                i++;
            }
        } else {
            iM = 0;
            while (i < size) {
                iM += CodedOutputStream.m(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iM;
    }

    public static void e0(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.r(i, list, z);
    }

    static int f(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.S(i) + CodedOutputStream.A(size * 4) : size * CodedOutputStream.n(i, 0);
    }

    static int g(List list) {
        return list.size() * 4;
    }

    static int h(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.S(i) + CodedOutputStream.A(size * 8) : size * CodedOutputStream.p(i, 0L);
    }

    static int i(List list) {
        return list.size() * 8;
    }

    static int j(int i, List list, e0 e0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iT += CodedOutputStream.t(i, (P) list.get(i2), e0Var);
        }
        return iT;
    }

    static int k(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iL = l(list);
        return z ? CodedOutputStream.S(i) + CodedOutputStream.A(iL) : iL + (size * CodedOutputStream.S(i));
    }

    static int l(List list) {
        int iX;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof A) {
            A a2 = (A) list;
            iX = 0;
            while (i < size) {
                iX += CodedOutputStream.x(a2.getInt(i));
                i++;
            }
        } else {
            iX = 0;
            while (i < size) {
                iX += CodedOutputStream.x(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iX;
    }

    static int m(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int iN = n(list);
        return z ? CodedOutputStream.S(i) + CodedOutputStream.A(iN) : iN + (list.size() * CodedOutputStream.S(i));
    }

    static int n(List list) {
        int iZ;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof G) {
            G g = (G) list;
            iZ = 0;
            while (i < size) {
                iZ += CodedOutputStream.z(g.getLong(i));
                i++;
            }
        } else {
            iZ = 0;
            while (i < size) {
                iZ += CodedOutputStream.z(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZ;
    }

    static int o(int i, Object obj, e0 e0Var) {
        return CodedOutputStream.D(i, (P) obj, e0Var);
    }

    static int p(int i, List list, e0 e0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = CodedOutputStream.S(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            iS += CodedOutputStream.F((P) list.get(i2), e0Var);
        }
        return iS;
    }

    static int q(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = r(list);
        return z ? CodedOutputStream.S(i) + CodedOutputStream.A(iR) : iR + (size * CodedOutputStream.S(i));
    }

    static int r(List list) {
        int iN;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof A) {
            A a2 = (A) list;
            iN = 0;
            while (i < size) {
                iN += CodedOutputStream.N(a2.getInt(i));
                i++;
            }
        } else {
            iN = 0;
            while (i < size) {
                iN += CodedOutputStream.N(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iN;
    }

    static int s(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = t(list);
        return z ? CodedOutputStream.S(i) + CodedOutputStream.A(iT) : iT + (size * CodedOutputStream.S(i));
    }

    static int t(List list) {
        int iP;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof G) {
            G g = (G) list;
            iP = 0;
            while (i < size) {
                iP += CodedOutputStream.P(g.getLong(i));
                i++;
            }
        } else {
            iP = 0;
            while (i < size) {
                iP += CodedOutputStream.P(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iP;
    }

    static int u(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iS = CodedOutputStream.S(i) * size;
        if (list instanceof InterfaceC3919Cx3) {
            InterfaceC3919Cx3 interfaceC3919Cx3 = (InterfaceC3919Cx3) list;
            while (i2 < size) {
                Object objQ = interfaceC3919Cx3.q(i2);
                iS += objQ instanceof AbstractC2383g ? CodedOutputStream.i((AbstractC2383g) objQ) : CodedOutputStream.R((String) objQ);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iS += obj instanceof AbstractC2383g ? CodedOutputStream.i((AbstractC2383g) obj) : CodedOutputStream.R((String) obj);
                i2++;
            }
        }
        return iS;
    }

    static int v(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iW = w(list);
        return z ? CodedOutputStream.S(i) + CodedOutputStream.A(iW) : iW + (size * CodedOutputStream.S(i));
    }

    static int w(List list) {
        int iU;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof A) {
            A a2 = (A) list;
            iU = 0;
            while (i < size) {
                iU += CodedOutputStream.U(a2.getInt(i));
                i++;
            }
        } else {
            iU = 0;
            while (i < size) {
                iU += CodedOutputStream.U(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iU;
    }

    static int x(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = y(list);
        return z ? CodedOutputStream.S(i) + CodedOutputStream.A(iY) : iY + (size * CodedOutputStream.S(i));
    }

    static int y(List list) {
        int iW;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof G) {
            G g = (G) list;
            iW = 0;
            while (i < size) {
                iW += CodedOutputStream.W(g.getLong(i));
                i++;
            }
        } else {
            iW = 0;
            while (i < size) {
                iW += CodedOutputStream.W(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iW;
    }

    static Object z(Object obj, int i, List list, B.d dVar, Object obj2, l0 l0Var) {
        if (dVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (dVar.a(iIntValue) != null) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj2 = L(obj, i, iIntValue, obj2, l0Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (dVar.a(iIntValue2) == null) {
                    obj2 = L(obj, i, iIntValue2, obj2, l0Var);
                    it.remove();
                }
            }
        }
        return obj2;
    }
}
