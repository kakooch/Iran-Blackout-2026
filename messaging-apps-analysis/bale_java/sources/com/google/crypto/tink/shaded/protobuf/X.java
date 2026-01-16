package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC2360w;
import ir.nasim.InterfaceC3685Bx3;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
abstract class X {
    private static final Class a = A();
    private static final a0 b = B(false);
    private static final a0 c = B(true);
    private static final a0 d = new c0();

    private static Class A() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static a0 B(boolean z) {
        try {
            Class clsC = C();
            if (clsC == null) {
                return null;
            }
            return (a0) clsC.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class C() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static void D(AbstractC2353o abstractC2353o, Object obj, Object obj2) {
        r rVarC = abstractC2353o.c(obj2);
        if (rVarC.d()) {
            return;
        }
        abstractC2353o.d(obj).h(rVarC);
    }

    static void E(D d2, Object obj, Object obj2, long j) {
        d0.R(obj, j, d2.a(d0.C(obj, j), d0.C(obj2, j)));
    }

    static void F(a0 a0Var, Object obj, Object obj2) {
        a0Var.p(obj, a0Var.k(a0Var.g(obj), a0Var.g(obj2)));
    }

    public static a0 G() {
        return b;
    }

    public static a0 H() {
        return c;
    }

    public static void I(Class cls) {
        Class cls2;
        if (!AbstractC2358u.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
    }

    static boolean J(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static Object K(Object obj, int i, int i2, Object obj2, a0 a0Var) {
        if (obj2 == null) {
            obj2 = a0Var.f(obj);
        }
        a0Var.e(obj2, i, i2);
        return obj2;
    }

    public static a0 L() {
        return d;
    }

    public static void M(int i, List list, g0 g0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.A(i, list, z);
    }

    public static void N(int i, List list, g0 g0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.I(i, list);
    }

    public static void O(int i, List list, g0 g0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.G(i, list, z);
    }

    public static void P(int i, List list, g0 g0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.n(i, list, z);
    }

    public static void Q(int i, List list, g0 g0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.j(i, list, z);
    }

    public static void R(int i, List list, g0 g0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.y(i, list, z);
    }

    public static void S(int i, List list, g0 g0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.a(i, list, z);
    }

    public static void T(int i, List list, g0 g0Var, V v) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.O(i, list, v);
    }

    public static void U(int i, List list, g0 g0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.g(i, list, z);
    }

    public static void V(int i, List list, g0 g0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.F(i, list, z);
    }

    public static void W(int i, List list, g0 g0Var, V v) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.L(i, list, v);
    }

    public static void X(int i, List list, g0 g0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.z(i, list, z);
    }

    public static void Y(int i, List list, g0 g0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.q(i, list, z);
    }

    public static void Z(int i, List list, g0 g0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.D(i, list, z);
    }

    static int a(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.L(i) + CodedOutputStream.x(size) : size * CodedOutputStream.d(i, true);
    }

    public static void a0(int i, List list, g0 g0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.l(i, list, z);
    }

    static int b(List list) {
        return list.size();
    }

    public static void b0(int i, List list, g0 g0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.d(i, list);
    }

    static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iL = size * CodedOutputStream.L(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iL += CodedOutputStream.g((AbstractC2345g) list.get(i2));
        }
        return iL;
    }

    public static void c0(int i, List list, g0 g0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.k(i, list, z);
    }

    static int d(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iE = e(list);
        return z ? CodedOutputStream.L(i) + CodedOutputStream.x(iE) : iE + (size * CodedOutputStream.L(i));
    }

    public static void d0(int i, List list, g0 g0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g0Var.r(i, list, z);
    }

    static int e(List list) {
        int iK;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC2359v) {
            AbstractC2359v abstractC2359v = (AbstractC2359v) list;
            iK = 0;
            while (i < size) {
                iK += CodedOutputStream.k(abstractC2359v.getInt(i));
                i++;
            }
        } else {
            iK = 0;
            while (i < size) {
                iK += CodedOutputStream.k(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iK;
    }

    static int f(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.L(i) + CodedOutputStream.x(size * 4) : size * CodedOutputStream.l(i, 0);
    }

    static int g(List list) {
        return list.size() * 4;
    }

    static int h(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.L(i) + CodedOutputStream.x(size * 8) : size * CodedOutputStream.n(i, 0L);
    }

    static int i(List list) {
        return list.size() * 8;
    }

    static int j(int i, List list, V v) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iR += CodedOutputStream.r(i, (I) list.get(i2), v);
        }
        return iR;
    }

    static int k(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iL = l(list);
        return z ? CodedOutputStream.L(i) + CodedOutputStream.x(iL) : iL + (size * CodedOutputStream.L(i));
    }

    static int l(List list) {
        int iU;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC2359v) {
            AbstractC2359v abstractC2359v = (AbstractC2359v) list;
            iU = 0;
            while (i < size) {
                iU += CodedOutputStream.u(abstractC2359v.getInt(i));
                i++;
            }
        } else {
            iU = 0;
            while (i < size) {
                iU += CodedOutputStream.u(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iU;
    }

    static int m(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int iN = n(list);
        return z ? CodedOutputStream.L(i) + CodedOutputStream.x(iN) : iN + (list.size() * CodedOutputStream.L(i));
    }

    static int n(List list) {
        int iW;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC2363z) {
            AbstractC2363z abstractC2363z = (AbstractC2363z) list;
            iW = 0;
            while (i < size) {
                iW += CodedOutputStream.w(abstractC2363z.getLong(i));
                i++;
            }
        } else {
            iW = 0;
            while (i < size) {
                iW += CodedOutputStream.w(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iW;
    }

    static int o(int i, Object obj, V v) {
        return CodedOutputStream.y(i, (I) obj, v);
    }

    static int p(int i, List list, V v) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iL = CodedOutputStream.L(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            iL += CodedOutputStream.z((I) list.get(i2), v);
        }
        return iL;
    }

    static int q(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = r(list);
        return z ? CodedOutputStream.L(i) + CodedOutputStream.x(iR) : iR + (size * CodedOutputStream.L(i));
    }

    static int r(List list) {
        int iG;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC2359v) {
            AbstractC2359v abstractC2359v = (AbstractC2359v) list;
            iG = 0;
            while (i < size) {
                iG += CodedOutputStream.G(abstractC2359v.getInt(i));
                i++;
            }
        } else {
            iG = 0;
            while (i < size) {
                iG += CodedOutputStream.G(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iG;
    }

    static int s(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = t(list);
        return z ? CodedOutputStream.L(i) + CodedOutputStream.x(iT) : iT + (size * CodedOutputStream.L(i));
    }

    static int t(List list) {
        int I;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC2363z) {
            AbstractC2363z abstractC2363z = (AbstractC2363z) list;
            I = 0;
            while (i < size) {
                I += CodedOutputStream.I(abstractC2363z.getLong(i));
                i++;
            }
        } else {
            I = 0;
            while (i < size) {
                I += CodedOutputStream.I(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return I;
    }

    static int u(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iL = CodedOutputStream.L(i) * size;
        if (list instanceof InterfaceC3685Bx3) {
            InterfaceC3685Bx3 interfaceC3685Bx3 = (InterfaceC3685Bx3) list;
            while (i2 < size) {
                Object objQ = interfaceC3685Bx3.q(i2);
                iL += objQ instanceof AbstractC2345g ? CodedOutputStream.g((AbstractC2345g) objQ) : CodedOutputStream.K((String) objQ);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iL += obj instanceof AbstractC2345g ? CodedOutputStream.g((AbstractC2345g) obj) : CodedOutputStream.K((String) obj);
                i2++;
            }
        }
        return iL;
    }

    static int v(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iW = w(list);
        return z ? CodedOutputStream.L(i) + CodedOutputStream.x(iW) : iW + (size * CodedOutputStream.L(i));
    }

    static int w(List list) {
        int iN;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC2359v) {
            AbstractC2359v abstractC2359v = (AbstractC2359v) list;
            iN = 0;
            while (i < size) {
                iN += CodedOutputStream.N(abstractC2359v.getInt(i));
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

    static int x(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = y(list);
        return z ? CodedOutputStream.L(i) + CodedOutputStream.x(iY) : iY + (size * CodedOutputStream.L(i));
    }

    static int y(List list) {
        int iP;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC2363z) {
            AbstractC2363z abstractC2363z = (AbstractC2363z) list;
            iP = 0;
            while (i < size) {
                iP += CodedOutputStream.P(abstractC2363z.getLong(i));
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

    static Object z(Object obj, int i, List list, AbstractC2360w.c cVar, Object obj2, a0 a0Var) {
        if (cVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (cVar.a(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj2 = K(obj, i, iIntValue, obj2, a0Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!cVar.a(iIntValue2)) {
                    obj2 = K(obj, i, iIntValue2, obj2, a0Var);
                    it.remove();
                }
            }
        }
        return obj2;
    }
}
