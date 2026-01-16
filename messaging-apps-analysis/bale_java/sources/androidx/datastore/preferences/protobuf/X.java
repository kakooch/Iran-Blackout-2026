package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC1952v;
import ir.nasim.InterfaceC4387Ex3;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
abstract class X {
    private static final Class a = A();
    private static final b0 b = B(false);
    private static final b0 c = B(true);
    private static final b0 d = new d0();

    private static Class A() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static b0 B(boolean z) {
        try {
            Class clsC = C();
            if (clsC == null) {
                return null;
            }
            return (b0) clsC.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class C() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static void D(AbstractC1945n abstractC1945n, Object obj, Object obj2) {
        C1948q c1948qC = abstractC1945n.c(obj2);
        if (c1948qC.j()) {
            return;
        }
        abstractC1945n.d(obj).p(c1948qC);
    }

    static void E(D d2, Object obj, Object obj2, long j) {
        e0.O(obj, j, d2.a(e0.A(obj, j), e0.A(obj2, j)));
    }

    static void F(b0 b0Var, Object obj, Object obj2) {
        b0Var.p(obj, b0Var.k(b0Var.g(obj), b0Var.g(obj2)));
    }

    public static b0 G() {
        return b;
    }

    public static b0 H() {
        return c;
    }

    public static void I(Class cls) {
        Class cls2;
        if (!AbstractC1950t.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean J(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static Object K(int i, int i2, Object obj, b0 b0Var) {
        if (obj == null) {
            obj = b0Var.n();
        }
        b0Var.e(obj, i, i2);
        return obj;
    }

    public static b0 L() {
        return d;
    }

    public static void M(int i, List list, h0 h0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.A(i, list, z);
    }

    public static void N(int i, List list, h0 h0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.I(i, list);
    }

    public static void O(int i, List list, h0 h0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.G(i, list, z);
    }

    public static void P(int i, List list, h0 h0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.n(i, list, z);
    }

    public static void Q(int i, List list, h0 h0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.j(i, list, z);
    }

    public static void R(int i, List list, h0 h0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.y(i, list, z);
    }

    public static void S(int i, List list, h0 h0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.a(i, list, z);
    }

    public static void T(int i, List list, h0 h0Var, V v) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.J(i, list, v);
    }

    public static void U(int i, List list, h0 h0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.g(i, list, z);
    }

    public static void V(int i, List list, h0 h0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.F(i, list, z);
    }

    public static void W(int i, List list, h0 h0Var, V v) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.O(i, list, v);
    }

    public static void X(int i, List list, h0 h0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.z(i, list, z);
    }

    public static void Y(int i, List list, h0 h0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.q(i, list, z);
    }

    public static void Z(int i, List list, h0 h0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.D(i, list, z);
    }

    static int a(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.P(i) + CodedOutputStream.y(size) : size * CodedOutputStream.c(i, true);
    }

    public static void a0(int i, List list, h0 h0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.l(i, list, z);
    }

    static int b(List list) {
        return list.size();
    }

    public static void b0(int i, List list, h0 h0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.d(i, list);
    }

    static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iP = size * CodedOutputStream.P(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iP += CodedOutputStream.g((AbstractC1937f) list.get(i2));
        }
        return iP;
    }

    public static void c0(int i, List list, h0 h0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.k(i, list, z);
    }

    static int d(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iE = e(list);
        return z ? CodedOutputStream.P(i) + CodedOutputStream.y(iE) : iE + (size * CodedOutputStream.P(i));
    }

    public static void d0(int i, List list, h0 h0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h0Var.r(i, list, z);
    }

    static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC1951u) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iK = 0;
        for (int i = 0; i < size; i++) {
            iK += CodedOutputStream.k(((Integer) list.get(i)).intValue());
        }
        return iK;
    }

    static int f(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.P(i) + CodedOutputStream.y(size * 4) : size * CodedOutputStream.l(i, 0);
    }

    static int g(List list) {
        return list.size() * 4;
    }

    static int h(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.P(i) + CodedOutputStream.y(size * 8) : size * CodedOutputStream.n(i, 0L);
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
        return z ? CodedOutputStream.P(i) + CodedOutputStream.y(iL) : iL + (size * CodedOutputStream.P(i));
    }

    static int l(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC1951u) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iV = 0;
        for (int i = 0; i < size; i++) {
            iV += CodedOutputStream.v(((Integer) list.get(i)).intValue());
        }
        return iV;
    }

    static int m(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int iN = n(list);
        return z ? CodedOutputStream.P(i) + CodedOutputStream.y(iN) : iN + (list.size() * CodedOutputStream.P(i));
    }

    static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC1956z) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iX = 0;
        for (int i = 0; i < size; i++) {
            iX += CodedOutputStream.x(((Long) list.get(i)).longValue());
        }
        return iX;
    }

    static int o(int i, Object obj, V v) {
        return CodedOutputStream.z(i, (I) obj, v);
    }

    static int p(int i, List list, V v) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iP = CodedOutputStream.P(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            iP += CodedOutputStream.B((I) list.get(i2), v);
        }
        return iP;
    }

    static int q(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = r(list);
        return z ? CodedOutputStream.P(i) + CodedOutputStream.y(iR) : iR + (size * CodedOutputStream.P(i));
    }

    static int r(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC1951u) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iK = 0;
        for (int i = 0; i < size; i++) {
            iK += CodedOutputStream.K(((Integer) list.get(i)).intValue());
        }
        return iK;
    }

    static int s(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = t(list);
        return z ? CodedOutputStream.P(i) + CodedOutputStream.y(iT) : iT + (size * CodedOutputStream.P(i));
    }

    static int t(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC1956z) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iM = 0;
        for (int i = 0; i < size; i++) {
            iM += CodedOutputStream.M(((Long) list.get(i)).longValue());
        }
        return iM;
    }

    static int u(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iP = CodedOutputStream.P(i) * size;
        if (list instanceof InterfaceC4387Ex3) {
            InterfaceC4387Ex3 interfaceC4387Ex3 = (InterfaceC4387Ex3) list;
            while (i2 < size) {
                Object objQ = interfaceC4387Ex3.q(i2);
                iP += objQ instanceof AbstractC1937f ? CodedOutputStream.g((AbstractC1937f) objQ) : CodedOutputStream.O((String) objQ);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iP += obj instanceof AbstractC1937f ? CodedOutputStream.g((AbstractC1937f) obj) : CodedOutputStream.O((String) obj);
                i2++;
            }
        }
        return iP;
    }

    static int v(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iW = w(list);
        return z ? CodedOutputStream.P(i) + CodedOutputStream.y(iW) : iW + (size * CodedOutputStream.P(i));
    }

    static int w(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC1951u) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iR = 0;
        for (int i = 0; i < size; i++) {
            iR += CodedOutputStream.R(((Integer) list.get(i)).intValue());
        }
        return iR;
    }

    static int x(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = y(list);
        return z ? CodedOutputStream.P(i) + CodedOutputStream.y(iY) : iY + (size * CodedOutputStream.P(i));
    }

    static int y(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC1956z) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iT = 0;
        for (int i = 0; i < size; i++) {
            iT += CodedOutputStream.T(((Long) list.get(i)).longValue());
        }
        return iT;
    }

    static Object z(int i, List list, AbstractC1952v.a aVar, Object obj, b0 b0Var) {
        if (aVar == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (aVar.a(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj = K(i, iIntValue, obj, b0Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!aVar.a(iIntValue2)) {
                    obj = K(i, iIntValue2, obj, b0Var);
                    it.remove();
                }
            }
        }
        return obj;
    }
}
