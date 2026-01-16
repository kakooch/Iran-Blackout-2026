package androidx.datastore.preferences.protobuf;

import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import androidx.datastore.preferences.protobuf.AbstractC1952v;
import androidx.datastore.preferences.protobuf.g0;
import androidx.datastore.preferences.protobuf.h0;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.EnumC4503Fk2;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class K implements V {
    private static final int[] r = new int[0];
    private static final Unsafe s = e0.B();
    private final int[] a;
    private final Object[] b;
    private final int c;
    private final int d;
    private final I e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final int[] j;
    private final int k;
    private final int l;
    private final M m;
    private final AbstractC1955y n;
    private final b0 o;
    private final AbstractC1945n p;
    private final D q;

    private K(int[] iArr, Object[] objArr, int i, int i2, I i3, boolean z, boolean z2, int[] iArr2, int i4, int i5, M m, AbstractC1955y abstractC1955y, b0 b0Var, AbstractC1945n abstractC1945n, D d) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.g = i3 instanceof AbstractC1950t;
        this.h = z;
        this.f = abstractC1945n != null && abstractC1945n.e(i3);
        this.i = z2;
        this.j = iArr2;
        this.k = i4;
        this.l = i5;
        this.m = m;
        this.n = abstractC1955y;
        this.o = b0Var;
        this.p = abstractC1945n;
        this.e = i3;
        this.q = d;
    }

    private boolean A(Object obj, int i, int i2) {
        List list = (List) e0.A(obj, Q(i));
        if (list.isEmpty()) {
            return true;
        }
        V vR = r(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!vR.f(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private boolean B(Object obj, int i, int i2) {
        Map mapE = this.q.e(e0.A(obj, Q(i)));
        if (mapE.isEmpty()) {
            return true;
        }
        if (this.q.b(q(i2)).c.a() != g0.c.MESSAGE) {
            return true;
        }
        V vC = null;
        for (Object obj2 : mapE.values()) {
            if (vC == null) {
                vC = Q.a().c(obj2.getClass());
            }
            if (!vC.f(obj2)) {
                return false;
            }
        }
        return true;
    }

    private boolean C(Object obj, Object obj2, int i) {
        long jX = X(i) & 1048575;
        return e0.x(obj, jX) == e0.x(obj2, jX);
    }

    private boolean D(Object obj, int i, int i2) {
        return e0.x(obj, (long) (X(i2) & 1048575)) == i;
    }

    private static boolean E(int i) {
        return (i & 268435456) != 0;
    }

    private static List F(Object obj, long j) {
        return (List) e0.A(obj, j);
    }

    private static long G(Object obj, long j) {
        return e0.y(obj, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:343:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
    
        r0 = r16.k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
    
        if (r0 >= r16.l) goto L339;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0081, code lost:
    
        r13 = n(r19, r16.j[r0], r13, r17);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008c, code lost:
    
        if (r13 == null) goto L343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008e, code lost:
    
        r17.o(r19, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0091, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void H(androidx.datastore.preferences.protobuf.b0 r17, androidx.datastore.preferences.protobuf.AbstractC1945n r18, java.lang.Object r19, androidx.datastore.preferences.protobuf.U r20, androidx.datastore.preferences.protobuf.C1944m r21) {
        /*
            Method dump skipped, instructions count: 1686
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.K.H(androidx.datastore.preferences.protobuf.b0, androidx.datastore.preferences.protobuf.n, java.lang.Object, androidx.datastore.preferences.protobuf.U, androidx.datastore.preferences.protobuf.m):void");
    }

    private final void I(Object obj, int i, Object obj2, C1944m c1944m, U u) {
        long jQ = Q(h0(i));
        Object objA = e0.A(obj, jQ);
        if (objA == null) {
            objA = this.q.d(obj2);
            e0.O(obj, jQ, objA);
        } else if (this.q.h(objA)) {
            Object objD = this.q.d(obj2);
            this.q.a(objD, objA);
            e0.O(obj, jQ, objD);
            objA = objD;
        }
        u.L(this.q.c(objA), this.q.b(obj2), c1944m);
    }

    private void J(Object obj, Object obj2, int i) {
        long jQ = Q(h0(i));
        if (x(obj2, i)) {
            Object objA = e0.A(obj, jQ);
            Object objA2 = e0.A(obj2, jQ);
            if (objA != null && objA2 != null) {
                e0.O(obj, jQ, AbstractC1952v.h(objA, objA2));
                d0(obj, i);
            } else if (objA2 != null) {
                e0.O(obj, jQ, objA2);
                d0(obj, i);
            }
        }
    }

    private void K(Object obj, Object obj2, int i) {
        int iH0 = h0(i);
        int iP = P(i);
        long jQ = Q(iH0);
        if (D(obj2, iP, i)) {
            Object objA = e0.A(obj, jQ);
            Object objA2 = e0.A(obj2, jQ);
            if (objA != null && objA2 != null) {
                e0.O(obj, jQ, AbstractC1952v.h(objA, objA2));
                e0(obj, iP, i);
            } else if (objA2 != null) {
                e0.O(obj, jQ, objA2);
                e0(obj, iP, i);
            }
        }
    }

    private void L(Object obj, Object obj2, int i) {
        int iH0 = h0(i);
        long jQ = Q(iH0);
        int iP = P(i);
        switch (g0(iH0)) {
            case 0:
                if (x(obj2, i)) {
                    e0.K(obj, jQ, e0.v(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 1:
                if (x(obj2, i)) {
                    e0.L(obj, jQ, e0.w(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 2:
                if (x(obj2, i)) {
                    e0.N(obj, jQ, e0.y(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 3:
                if (x(obj2, i)) {
                    e0.N(obj, jQ, e0.y(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 4:
                if (x(obj2, i)) {
                    e0.M(obj, jQ, e0.x(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 5:
                if (x(obj2, i)) {
                    e0.N(obj, jQ, e0.y(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 6:
                if (x(obj2, i)) {
                    e0.M(obj, jQ, e0.x(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 7:
                if (x(obj2, i)) {
                    e0.E(obj, jQ, e0.p(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 8:
                if (x(obj2, i)) {
                    e0.O(obj, jQ, e0.A(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 9:
                J(obj, obj2, i);
                break;
            case 10:
                if (x(obj2, i)) {
                    e0.O(obj, jQ, e0.A(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 11:
                if (x(obj2, i)) {
                    e0.M(obj, jQ, e0.x(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 12:
                if (x(obj2, i)) {
                    e0.M(obj, jQ, e0.x(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 13:
                if (x(obj2, i)) {
                    e0.M(obj, jQ, e0.x(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 14:
                if (x(obj2, i)) {
                    e0.N(obj, jQ, e0.y(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 15:
                if (x(obj2, i)) {
                    e0.M(obj, jQ, e0.x(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 16:
                if (x(obj2, i)) {
                    e0.N(obj, jQ, e0.y(obj2, jQ));
                    d0(obj, i);
                    break;
                }
                break;
            case 17:
                J(obj, obj2, i);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.n.d(obj, obj2, jQ);
                break;
            case 50:
                X.E(this.q, obj, obj2, jQ);
                break;
            case 51:
            case Type.TLSA /* 52 */:
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
            case 55:
            case Type.NINFO /* 56 */:
            case 57:
            case 58:
            case 59:
                if (D(obj2, iP, i)) {
                    e0.O(obj, jQ, e0.A(obj2, jQ));
                    e0(obj, iP, i);
                    break;
                }
                break;
            case 60:
                K(obj, obj2, i);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case WKSRecord.Protocol.RVD /* 66 */:
            case 67:
                if (D(obj2, iP, i)) {
                    e0.O(obj, jQ, e0.A(obj2, jQ));
                    e0(obj, iP, i);
                    break;
                }
                break;
            case WKSRecord.Service.BOOTPC /* 68 */:
                K(obj, obj2, i);
                break;
        }
    }

    static K M(Class cls, G g, M m, AbstractC1955y abstractC1955y, b0 b0Var, AbstractC1945n abstractC1945n, D d) {
        if (g instanceof T) {
            return O((T) g, m, abstractC1955y, b0Var, abstractC1945n, d);
        }
        AbstractC18350oW3.a(g);
        return N(null, m, abstractC1955y, b0Var, abstractC1945n, d);
    }

    static K N(Z z, M m, AbstractC1955y abstractC1955y, b0 b0Var, AbstractC1945n abstractC1945n, D d) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static androidx.datastore.preferences.protobuf.K O(androidx.datastore.preferences.protobuf.T r35, androidx.datastore.preferences.protobuf.M r36, androidx.datastore.preferences.protobuf.AbstractC1955y r37, androidx.datastore.preferences.protobuf.b0 r38, androidx.datastore.preferences.protobuf.AbstractC1945n r39, androidx.datastore.preferences.protobuf.D r40) {
        /*
            Method dump skipped, instructions count: 1053
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.K.O(androidx.datastore.preferences.protobuf.T, androidx.datastore.preferences.protobuf.M, androidx.datastore.preferences.protobuf.y, androidx.datastore.preferences.protobuf.b0, androidx.datastore.preferences.protobuf.n, androidx.datastore.preferences.protobuf.D):androidx.datastore.preferences.protobuf.K");
    }

    private int P(int i) {
        return this.a[i];
    }

    private static long Q(int i) {
        return i & 1048575;
    }

    private static boolean R(Object obj, long j) {
        return ((Boolean) e0.A(obj, j)).booleanValue();
    }

    private static double S(Object obj, long j) {
        return ((Double) e0.A(obj, j)).doubleValue();
    }

    private static float T(Object obj, long j) {
        return ((Float) e0.A(obj, j)).floatValue();
    }

    private static int U(Object obj, long j) {
        return ((Integer) e0.A(obj, j)).intValue();
    }

    private static long V(Object obj, long j) {
        return ((Long) e0.A(obj, j)).longValue();
    }

    private int W(int i) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return f0(i, 0);
    }

    private int X(int i) {
        return this.a[i + 2];
    }

    private void Y(Object obj, long j, U u, V v, C1944m c1944m) {
        u.M(this.n.e(obj, j), v, c1944m);
    }

    private void Z(Object obj, int i, U u, V v, C1944m c1944m) {
        u.J(this.n.e(obj, Q(i)), v, c1944m);
    }

    private void a0(Object obj, int i, U u) {
        if (w(i)) {
            e0.O(obj, Q(i), u.H());
        } else if (this.g) {
            e0.O(obj, Q(i), u.y());
        } else {
            e0.O(obj, Q(i), u.n());
        }
    }

    private void b0(Object obj, int i, U u) {
        if (w(i)) {
            u.m(this.n.e(obj, Q(i)));
        } else {
            u.A(this.n.e(obj, Q(i)));
        }
    }

    private static Field c0(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void d0(Object obj, int i) {
        if (this.h) {
            return;
        }
        int iX = X(i);
        long j = iX & 1048575;
        e0.M(obj, j, e0.x(obj, j) | (1 << (iX >>> 20)));
    }

    private void e0(Object obj, int i, int i2) {
        e0.M(obj, X(i2) & 1048575, i);
    }

    private int f0(int i, int i2) {
        int length = (this.a.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int iP = P(i4);
            if (i == iP) {
                return i4;
            }
            if (i < iP) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int g0(int i) {
        return (i & 267386880) >>> 20;
    }

    private int h0(int i) {
        return this.a[i + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i0(java.lang.Object r18, androidx.datastore.preferences.protobuf.h0 r19) {
        /*
            Method dump skipped, instructions count: 1352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.K.i0(java.lang.Object, androidx.datastore.preferences.protobuf.h0):void");
    }

    private boolean j(Object obj, Object obj2, int i) {
        return x(obj, i) == x(obj2, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j0(java.lang.Object r13, androidx.datastore.preferences.protobuf.h0 r14) {
        /*
            Method dump skipped, instructions count: 1584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.K.j0(java.lang.Object, androidx.datastore.preferences.protobuf.h0):void");
    }

    private static boolean k(Object obj, long j) {
        return e0.p(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void k0(java.lang.Object r11, androidx.datastore.preferences.protobuf.h0 r12) {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.K.k0(java.lang.Object, androidx.datastore.preferences.protobuf.h0):void");
    }

    private static double l(Object obj, long j) {
        return e0.v(obj, j);
    }

    private void l0(h0 h0Var, int i, Object obj, int i2) {
        if (obj != null) {
            h0Var.M(i, this.q.b(q(i2)), this.q.e(obj));
        }
    }

    private boolean m(Object obj, Object obj2, int i) {
        int iH0 = h0(i);
        long jQ = Q(iH0);
        switch (g0(iH0)) {
            case 0:
                if (j(obj, obj2, i) && Double.doubleToLongBits(e0.v(obj, jQ)) == Double.doubleToLongBits(e0.v(obj2, jQ))) {
                    break;
                }
                break;
            case 1:
                if (j(obj, obj2, i) && Float.floatToIntBits(e0.w(obj, jQ)) == Float.floatToIntBits(e0.w(obj2, jQ))) {
                    break;
                }
                break;
            case 2:
                if (j(obj, obj2, i) && e0.y(obj, jQ) == e0.y(obj2, jQ)) {
                    break;
                }
                break;
            case 3:
                if (j(obj, obj2, i) && e0.y(obj, jQ) == e0.y(obj2, jQ)) {
                    break;
                }
                break;
            case 4:
                if (j(obj, obj2, i) && e0.x(obj, jQ) == e0.x(obj2, jQ)) {
                    break;
                }
                break;
            case 5:
                if (j(obj, obj2, i) && e0.y(obj, jQ) == e0.y(obj2, jQ)) {
                    break;
                }
                break;
            case 6:
                if (j(obj, obj2, i) && e0.x(obj, jQ) == e0.x(obj2, jQ)) {
                    break;
                }
                break;
            case 7:
                if (j(obj, obj2, i) && e0.p(obj, jQ) == e0.p(obj2, jQ)) {
                    break;
                }
                break;
            case 8:
                if (j(obj, obj2, i) && X.J(e0.A(obj, jQ), e0.A(obj2, jQ))) {
                    break;
                }
                break;
            case 9:
                if (j(obj, obj2, i) && X.J(e0.A(obj, jQ), e0.A(obj2, jQ))) {
                    break;
                }
                break;
            case 10:
                if (j(obj, obj2, i) && X.J(e0.A(obj, jQ), e0.A(obj2, jQ))) {
                    break;
                }
                break;
            case 11:
                if (j(obj, obj2, i) && e0.x(obj, jQ) == e0.x(obj2, jQ)) {
                    break;
                }
                break;
            case 12:
                if (j(obj, obj2, i) && e0.x(obj, jQ) == e0.x(obj2, jQ)) {
                    break;
                }
                break;
            case 13:
                if (j(obj, obj2, i) && e0.x(obj, jQ) == e0.x(obj2, jQ)) {
                    break;
                }
                break;
            case 14:
                if (j(obj, obj2, i) && e0.y(obj, jQ) == e0.y(obj2, jQ)) {
                    break;
                }
                break;
            case 15:
                if (j(obj, obj2, i) && e0.x(obj, jQ) == e0.x(obj2, jQ)) {
                    break;
                }
                break;
            case 16:
                if (j(obj, obj2, i) && e0.y(obj, jQ) == e0.y(obj2, jQ)) {
                    break;
                }
                break;
            case 17:
                if (j(obj, obj2, i) && X.J(e0.A(obj, jQ), e0.A(obj2, jQ))) {
                    break;
                }
                break;
            case 51:
            case Type.TLSA /* 52 */:
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
            case 55:
            case Type.NINFO /* 56 */:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case WKSRecord.Protocol.RVD /* 66 */:
            case 67:
            case WKSRecord.Service.BOOTPC /* 68 */:
                if (C(obj, obj2, i) && X.J(e0.A(obj, jQ), e0.A(obj2, jQ))) {
                    break;
                }
                break;
        }
        return true;
    }

    private void m0(int i, Object obj, h0 h0Var) {
        if (obj instanceof String) {
            h0Var.e(i, (String) obj);
        } else {
            h0Var.K(i, (AbstractC1937f) obj);
        }
    }

    private final Object n(Object obj, int i, Object obj2, b0 b0Var) {
        P(i);
        if (e0.A(obj, Q(h0(i))) == null) {
            return obj2;
        }
        p(i);
        return obj2;
    }

    private void n0(b0 b0Var, Object obj, h0 h0Var) {
        b0Var.t(b0Var.g(obj), h0Var);
    }

    private static float o(Object obj, long j) {
        return e0.w(obj, j);
    }

    private AbstractC1952v.a p(int i) {
        AbstractC18350oW3.a(this.b[((i / 3) * 2) + 1]);
        return null;
    }

    private Object q(int i) {
        return this.b[(i / 3) * 2];
    }

    private V r(int i) {
        int i2 = (i / 3) * 2;
        V v = (V) this.b[i2];
        if (v != null) {
            return v;
        }
        V vC = Q.a().c((Class) this.b[i2 + 1]);
        this.b[i2] = vC;
        return vC;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int s(Object obj) {
        int i;
        int i2;
        int iH;
        int iC;
        int iF;
        boolean z;
        int iF2;
        int i3;
        int iP;
        int iR;
        Unsafe unsafe = s;
        int i4 = -1;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < this.a.length) {
            int iH0 = h0(i5);
            int iP2 = P(i5);
            int iG0 = g0(iH0);
            if (iG0 <= 17) {
                i = this.a[i5 + 2];
                int i8 = 1048575 & i;
                int i9 = 1 << (i >>> 20);
                if (i8 != i4) {
                    i7 = unsafe.getInt(obj, i8);
                    i4 = i8;
                }
                i2 = i9;
            } else {
                i = (!this.i || iG0 < EnumC4503Fk2.F0.a() || iG0 > EnumC4503Fk2.S0.a()) ? 0 : this.a[i5 + 2] & 1048575;
                i2 = 0;
            }
            long jQ = Q(iH0);
            int i10 = i4;
            switch (iG0) {
                case 0:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        iH = CodedOutputStream.h(iP2, 0.0d);
                        i6 += iH;
                        break;
                    }
                case 1:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        iH = CodedOutputStream.p(iP2, 0.0f);
                        i6 += iH;
                        break;
                    }
                case 2:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        iH = CodedOutputStream.w(iP2, unsafe.getLong(obj, jQ));
                        i6 += iH;
                        break;
                    }
                case 3:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        iH = CodedOutputStream.S(iP2, unsafe.getLong(obj, jQ));
                        i6 += iH;
                        break;
                    }
                case 4:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        iH = CodedOutputStream.u(iP2, unsafe.getInt(obj, jQ));
                        i6 += iH;
                        break;
                    }
                case 5:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        iH = CodedOutputStream.n(iP2, 0L);
                        i6 += iH;
                        break;
                    }
                case 6:
                    if ((i7 & i2) != 0) {
                        iH = CodedOutputStream.l(iP2, 0);
                        i6 += iH;
                        break;
                    }
                    break;
                case 7:
                    if ((i7 & i2) != 0) {
                        iC = CodedOutputStream.c(iP2, true);
                        i6 += iC;
                    }
                    break;
                case 8:
                    if ((i7 & i2) != 0) {
                        Object object = unsafe.getObject(obj, jQ);
                        iC = object instanceof AbstractC1937f ? CodedOutputStream.f(iP2, (AbstractC1937f) object) : CodedOutputStream.N(iP2, (String) object);
                        i6 += iC;
                    }
                    break;
                case 9:
                    if ((i7 & i2) != 0) {
                        iC = X.o(iP2, unsafe.getObject(obj, jQ), r(i5));
                        i6 += iC;
                    }
                    break;
                case 10:
                    if ((i7 & i2) != 0) {
                        iC = CodedOutputStream.f(iP2, (AbstractC1937f) unsafe.getObject(obj, jQ));
                        i6 += iC;
                    }
                    break;
                case 11:
                    if ((i7 & i2) != 0) {
                        iC = CodedOutputStream.Q(iP2, unsafe.getInt(obj, jQ));
                        i6 += iC;
                    }
                    break;
                case 12:
                    if ((i7 & i2) != 0) {
                        iC = CodedOutputStream.j(iP2, unsafe.getInt(obj, jQ));
                        i6 += iC;
                    }
                    break;
                case 13:
                    if ((i7 & i2) != 0) {
                        iF = CodedOutputStream.F(iP2, 0);
                        i6 += iF;
                    }
                    break;
                case 14:
                    if ((i7 & i2) != 0) {
                        iC = CodedOutputStream.H(iP2, 0L);
                        i6 += iC;
                    }
                    break;
                case 15:
                    if ((i7 & i2) != 0) {
                        iC = CodedOutputStream.J(iP2, unsafe.getInt(obj, jQ));
                        i6 += iC;
                    }
                    break;
                case 16:
                    if ((i7 & i2) != 0) {
                        iC = CodedOutputStream.L(iP2, unsafe.getLong(obj, jQ));
                        i6 += iC;
                    }
                    break;
                case 17:
                    if ((i7 & i2) != 0) {
                        iC = CodedOutputStream.r(iP2, (I) unsafe.getObject(obj, jQ), r(i5));
                        i6 += iC;
                    }
                    break;
                case 18:
                    iC = X.h(iP2, (List) unsafe.getObject(obj, jQ), false);
                    i6 += iC;
                    break;
                case 19:
                    z = false;
                    iF2 = X.f(iP2, (List) unsafe.getObject(obj, jQ), false);
                    i6 += iF2;
                    break;
                case 20:
                    z = false;
                    iF2 = X.m(iP2, (List) unsafe.getObject(obj, jQ), false);
                    i6 += iF2;
                    break;
                case 21:
                    z = false;
                    iF2 = X.x(iP2, (List) unsafe.getObject(obj, jQ), false);
                    i6 += iF2;
                    break;
                case 22:
                    z = false;
                    iF2 = X.k(iP2, (List) unsafe.getObject(obj, jQ), false);
                    i6 += iF2;
                    break;
                case 23:
                    z = false;
                    iF2 = X.h(iP2, (List) unsafe.getObject(obj, jQ), false);
                    i6 += iF2;
                    break;
                case 24:
                    z = false;
                    iF2 = X.f(iP2, (List) unsafe.getObject(obj, jQ), false);
                    i6 += iF2;
                    break;
                case 25:
                    z = false;
                    iF2 = X.a(iP2, (List) unsafe.getObject(obj, jQ), false);
                    i6 += iF2;
                    break;
                case 26:
                    iC = X.u(iP2, (List) unsafe.getObject(obj, jQ));
                    i6 += iC;
                    break;
                case 27:
                    iC = X.p(iP2, (List) unsafe.getObject(obj, jQ), r(i5));
                    i6 += iC;
                    break;
                case 28:
                    iC = X.c(iP2, (List) unsafe.getObject(obj, jQ));
                    i6 += iC;
                    break;
                case 29:
                    iC = X.v(iP2, (List) unsafe.getObject(obj, jQ), false);
                    i6 += iC;
                    break;
                case 30:
                    z = false;
                    iF2 = X.d(iP2, (List) unsafe.getObject(obj, jQ), false);
                    i6 += iF2;
                    break;
                case 31:
                    z = false;
                    iF2 = X.f(iP2, (List) unsafe.getObject(obj, jQ), false);
                    i6 += iF2;
                    break;
                case 32:
                    z = false;
                    iF2 = X.h(iP2, (List) unsafe.getObject(obj, jQ), false);
                    i6 += iF2;
                    break;
                case 33:
                    z = false;
                    iF2 = X.q(iP2, (List) unsafe.getObject(obj, jQ), false);
                    i6 += iF2;
                    break;
                case 34:
                    z = false;
                    iF2 = X.s(iP2, (List) unsafe.getObject(obj, jQ), false);
                    i6 += iF2;
                    break;
                case 35:
                    i3 = X.i((List) unsafe.getObject(obj, jQ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i3);
                        iF = iP + iR + i3;
                        i6 += iF;
                    }
                    break;
                case 36:
                    i3 = X.g((List) unsafe.getObject(obj, jQ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i3);
                        iF = iP + iR + i3;
                        i6 += iF;
                    }
                    break;
                case 37:
                    i3 = X.n((List) unsafe.getObject(obj, jQ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i3);
                        iF = iP + iR + i3;
                        i6 += iF;
                    }
                    break;
                case 38:
                    i3 = X.y((List) unsafe.getObject(obj, jQ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i3);
                        iF = iP + iR + i3;
                        i6 += iF;
                    }
                    break;
                case 39:
                    i3 = X.l((List) unsafe.getObject(obj, jQ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i3);
                        iF = iP + iR + i3;
                        i6 += iF;
                    }
                    break;
                case 40:
                    i3 = X.i((List) unsafe.getObject(obj, jQ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i3);
                        iF = iP + iR + i3;
                        i6 += iF;
                    }
                    break;
                case 41:
                    i3 = X.g((List) unsafe.getObject(obj, jQ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i3);
                        iF = iP + iR + i3;
                        i6 += iF;
                    }
                    break;
                case 42:
                    i3 = X.b((List) unsafe.getObject(obj, jQ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i3);
                        iF = iP + iR + i3;
                        i6 += iF;
                    }
                    break;
                case 43:
                    i3 = X.w((List) unsafe.getObject(obj, jQ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i3);
                        iF = iP + iR + i3;
                        i6 += iF;
                    }
                    break;
                case 44:
                    i3 = X.e((List) unsafe.getObject(obj, jQ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i3);
                        iF = iP + iR + i3;
                        i6 += iF;
                    }
                    break;
                case 45:
                    i3 = X.g((List) unsafe.getObject(obj, jQ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i3);
                        iF = iP + iR + i3;
                        i6 += iF;
                    }
                    break;
                case 46:
                    i3 = X.i((List) unsafe.getObject(obj, jQ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i3);
                        iF = iP + iR + i3;
                        i6 += iF;
                    }
                    break;
                case 47:
                    i3 = X.r((List) unsafe.getObject(obj, jQ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i3);
                        iF = iP + iR + i3;
                        i6 += iF;
                    }
                    break;
                case 48:
                    i3 = X.t((List) unsafe.getObject(obj, jQ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i3);
                        iF = iP + iR + i3;
                        i6 += iF;
                    }
                    break;
                case 49:
                    iC = X.j(iP2, (List) unsafe.getObject(obj, jQ), r(i5));
                    i6 += iC;
                    break;
                case 50:
                    iC = this.q.g(iP2, unsafe.getObject(obj, jQ), q(i5));
                    i6 += iC;
                    break;
                case 51:
                    if (D(obj, iP2, i5)) {
                        iC = CodedOutputStream.h(iP2, 0.0d);
                        i6 += iC;
                    }
                    break;
                case Type.TLSA /* 52 */:
                    if (D(obj, iP2, i5)) {
                        iC = CodedOutputStream.p(iP2, 0.0f);
                        i6 += iC;
                    }
                    break;
                case 53:
                    if (D(obj, iP2, i5)) {
                        iC = CodedOutputStream.w(iP2, V(obj, jQ));
                        i6 += iC;
                    }
                    break;
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (D(obj, iP2, i5)) {
                        iC = CodedOutputStream.S(iP2, V(obj, jQ));
                        i6 += iC;
                    }
                    break;
                case 55:
                    if (D(obj, iP2, i5)) {
                        iC = CodedOutputStream.u(iP2, U(obj, jQ));
                        i6 += iC;
                    }
                    break;
                case Type.NINFO /* 56 */:
                    if (D(obj, iP2, i5)) {
                        iC = CodedOutputStream.n(iP2, 0L);
                        i6 += iC;
                    }
                    break;
                case 57:
                    if (D(obj, iP2, i5)) {
                        iF = CodedOutputStream.l(iP2, 0);
                        i6 += iF;
                    }
                    break;
                case 58:
                    if (D(obj, iP2, i5)) {
                        iC = CodedOutputStream.c(iP2, true);
                        i6 += iC;
                    }
                    break;
                case 59:
                    if (D(obj, iP2, i5)) {
                        Object object2 = unsafe.getObject(obj, jQ);
                        iC = object2 instanceof AbstractC1937f ? CodedOutputStream.f(iP2, (AbstractC1937f) object2) : CodedOutputStream.N(iP2, (String) object2);
                        i6 += iC;
                    }
                    break;
                case 60:
                    if (D(obj, iP2, i5)) {
                        iC = X.o(iP2, unsafe.getObject(obj, jQ), r(i5));
                        i6 += iC;
                    }
                    break;
                case 61:
                    if (D(obj, iP2, i5)) {
                        iC = CodedOutputStream.f(iP2, (AbstractC1937f) unsafe.getObject(obj, jQ));
                        i6 += iC;
                    }
                    break;
                case 62:
                    if (D(obj, iP2, i5)) {
                        iC = CodedOutputStream.Q(iP2, U(obj, jQ));
                        i6 += iC;
                    }
                    break;
                case 63:
                    if (D(obj, iP2, i5)) {
                        iC = CodedOutputStream.j(iP2, U(obj, jQ));
                        i6 += iC;
                    }
                    break;
                case 64:
                    if (D(obj, iP2, i5)) {
                        iF = CodedOutputStream.F(iP2, 0);
                        i6 += iF;
                    }
                    break;
                case 65:
                    if (D(obj, iP2, i5)) {
                        iC = CodedOutputStream.H(iP2, 0L);
                        i6 += iC;
                    }
                    break;
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (D(obj, iP2, i5)) {
                        iC = CodedOutputStream.J(iP2, U(obj, jQ));
                        i6 += iC;
                    }
                    break;
                case 67:
                    if (D(obj, iP2, i5)) {
                        iC = CodedOutputStream.L(iP2, V(obj, jQ));
                        i6 += iC;
                    }
                    break;
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (D(obj, iP2, i5)) {
                        iC = CodedOutputStream.r(iP2, (I) unsafe.getObject(obj, jQ), r(i5));
                        i6 += iC;
                    }
                    break;
            }
            i5 += 3;
            i4 = i10;
        }
        int iU = i6 + u(this.o, obj);
        return this.f ? iU + this.p.c(obj).h() : iU;
    }

    private int t(Object obj) {
        int iH;
        int i;
        int iP;
        int iR;
        Unsafe unsafe = s;
        int i2 = 0;
        for (int i3 = 0; i3 < this.a.length; i3 += 3) {
            int iH0 = h0(i3);
            int iG0 = g0(iH0);
            int iP2 = P(i3);
            long jQ = Q(iH0);
            int i4 = (iG0 < EnumC4503Fk2.F0.a() || iG0 > EnumC4503Fk2.S0.a()) ? 0 : this.a[i3 + 2] & 1048575;
            switch (iG0) {
                case 0:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.h(iP2, 0.0d);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.p(iP2, 0.0f);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.w(iP2, e0.y(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.S(iP2, e0.y(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.u(iP2, e0.x(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.n(iP2, 0L);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.l(iP2, 0);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.c(iP2, true);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (x(obj, i3)) {
                        Object objA = e0.A(obj, jQ);
                        iH = objA instanceof AbstractC1937f ? CodedOutputStream.f(iP2, (AbstractC1937f) objA) : CodedOutputStream.N(iP2, (String) objA);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (x(obj, i3)) {
                        iH = X.o(iP2, e0.A(obj, jQ), r(i3));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.f(iP2, (AbstractC1937f) e0.A(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.Q(iP2, e0.x(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.j(iP2, e0.x(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.F(iP2, 0);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.H(iP2, 0L);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.J(iP2, e0.x(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.L(iP2, e0.y(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (x(obj, i3)) {
                        iH = CodedOutputStream.r(iP2, (I) e0.A(obj, jQ), r(i3));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iH = X.h(iP2, F(obj, jQ), false);
                    i2 += iH;
                    break;
                case 19:
                    iH = X.f(iP2, F(obj, jQ), false);
                    i2 += iH;
                    break;
                case 20:
                    iH = X.m(iP2, F(obj, jQ), false);
                    i2 += iH;
                    break;
                case 21:
                    iH = X.x(iP2, F(obj, jQ), false);
                    i2 += iH;
                    break;
                case 22:
                    iH = X.k(iP2, F(obj, jQ), false);
                    i2 += iH;
                    break;
                case 23:
                    iH = X.h(iP2, F(obj, jQ), false);
                    i2 += iH;
                    break;
                case 24:
                    iH = X.f(iP2, F(obj, jQ), false);
                    i2 += iH;
                    break;
                case 25:
                    iH = X.a(iP2, F(obj, jQ), false);
                    i2 += iH;
                    break;
                case 26:
                    iH = X.u(iP2, F(obj, jQ));
                    i2 += iH;
                    break;
                case 27:
                    iH = X.p(iP2, F(obj, jQ), r(i3));
                    i2 += iH;
                    break;
                case 28:
                    iH = X.c(iP2, F(obj, jQ));
                    i2 += iH;
                    break;
                case 29:
                    iH = X.v(iP2, F(obj, jQ), false);
                    i2 += iH;
                    break;
                case 30:
                    iH = X.d(iP2, F(obj, jQ), false);
                    i2 += iH;
                    break;
                case 31:
                    iH = X.f(iP2, F(obj, jQ), false);
                    i2 += iH;
                    break;
                case 32:
                    iH = X.h(iP2, F(obj, jQ), false);
                    i2 += iH;
                    break;
                case 33:
                    iH = X.q(iP2, F(obj, jQ), false);
                    i2 += iH;
                    break;
                case 34:
                    iH = X.s(iP2, F(obj, jQ), false);
                    i2 += iH;
                    break;
                case 35:
                    i = X.i((List) unsafe.getObject(obj, jQ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i);
                        iH = iP + iR + i;
                        i2 += iH;
                        break;
                    }
                case 36:
                    i = X.g((List) unsafe.getObject(obj, jQ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i);
                        iH = iP + iR + i;
                        i2 += iH;
                        break;
                    }
                case 37:
                    i = X.n((List) unsafe.getObject(obj, jQ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i);
                        iH = iP + iR + i;
                        i2 += iH;
                        break;
                    }
                case 38:
                    i = X.y((List) unsafe.getObject(obj, jQ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i);
                        iH = iP + iR + i;
                        i2 += iH;
                        break;
                    }
                case 39:
                    i = X.l((List) unsafe.getObject(obj, jQ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i);
                        iH = iP + iR + i;
                        i2 += iH;
                        break;
                    }
                case 40:
                    i = X.i((List) unsafe.getObject(obj, jQ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i);
                        iH = iP + iR + i;
                        i2 += iH;
                        break;
                    }
                case 41:
                    i = X.g((List) unsafe.getObject(obj, jQ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i);
                        iH = iP + iR + i;
                        i2 += iH;
                        break;
                    }
                case 42:
                    i = X.b((List) unsafe.getObject(obj, jQ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i);
                        iH = iP + iR + i;
                        i2 += iH;
                        break;
                    }
                case 43:
                    i = X.w((List) unsafe.getObject(obj, jQ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i);
                        iH = iP + iR + i;
                        i2 += iH;
                        break;
                    }
                case 44:
                    i = X.e((List) unsafe.getObject(obj, jQ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i);
                        iH = iP + iR + i;
                        i2 += iH;
                        break;
                    }
                case 45:
                    i = X.g((List) unsafe.getObject(obj, jQ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i);
                        iH = iP + iR + i;
                        i2 += iH;
                        break;
                    }
                case 46:
                    i = X.i((List) unsafe.getObject(obj, jQ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i);
                        iH = iP + iR + i;
                        i2 += iH;
                        break;
                    }
                case 47:
                    i = X.r((List) unsafe.getObject(obj, jQ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i);
                        iH = iP + iR + i;
                        i2 += iH;
                        break;
                    }
                case 48:
                    i = X.t((List) unsafe.getObject(obj, jQ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iP = CodedOutputStream.P(iP2);
                        iR = CodedOutputStream.R(i);
                        iH = iP + iR + i;
                        i2 += iH;
                        break;
                    }
                case 49:
                    iH = X.j(iP2, F(obj, jQ), r(i3));
                    i2 += iH;
                    break;
                case 50:
                    iH = this.q.g(iP2, e0.A(obj, jQ), q(i3));
                    i2 += iH;
                    break;
                case 51:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.h(iP2, 0.0d);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case Type.TLSA /* 52 */:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.p(iP2, 0.0f);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.w(iP2, V(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.S(iP2, V(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.u(iP2, U(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case Type.NINFO /* 56 */:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.n(iP2, 0L);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.l(iP2, 0);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.c(iP2, true);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (D(obj, iP2, i3)) {
                        Object objA2 = e0.A(obj, jQ);
                        iH = objA2 instanceof AbstractC1937f ? CodedOutputStream.f(iP2, (AbstractC1937f) objA2) : CodedOutputStream.N(iP2, (String) objA2);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (D(obj, iP2, i3)) {
                        iH = X.o(iP2, e0.A(obj, jQ), r(i3));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.f(iP2, (AbstractC1937f) e0.A(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.Q(iP2, U(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.j(iP2, U(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.F(iP2, 0);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.H(iP2, 0L);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.J(iP2, U(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.L(iP2, V(obj, jQ));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (D(obj, iP2, i3)) {
                        iH = CodedOutputStream.r(iP2, (I) e0.A(obj, jQ), r(i3));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i2 + u(this.o, obj);
    }

    private int u(b0 b0Var, Object obj) {
        return b0Var.h(b0Var.g(obj));
    }

    private static int v(Object obj, long j) {
        return e0.x(obj, j);
    }

    private static boolean w(int i) {
        return (i & 536870912) != 0;
    }

    private boolean x(Object obj, int i) {
        if (!this.h) {
            int iX = X(i);
            return (e0.x(obj, (long) (iX & 1048575)) & (1 << (iX >>> 20))) != 0;
        }
        int iH0 = h0(i);
        long jQ = Q(iH0);
        switch (g0(iH0)) {
            case 0:
                return e0.v(obj, jQ) != 0.0d;
            case 1:
                return e0.w(obj, jQ) != 0.0f;
            case 2:
                return e0.y(obj, jQ) != 0;
            case 3:
                return e0.y(obj, jQ) != 0;
            case 4:
                return e0.x(obj, jQ) != 0;
            case 5:
                return e0.y(obj, jQ) != 0;
            case 6:
                return e0.x(obj, jQ) != 0;
            case 7:
                return e0.p(obj, jQ);
            case 8:
                Object objA = e0.A(obj, jQ);
                if (objA instanceof String) {
                    return !((String) objA).isEmpty();
                }
                if (objA instanceof AbstractC1937f) {
                    return !AbstractC1937f.b.equals(objA);
                }
                throw new IllegalArgumentException();
            case 9:
                return e0.A(obj, jQ) != null;
            case 10:
                return !AbstractC1937f.b.equals(e0.A(obj, jQ));
            case 11:
                return e0.x(obj, jQ) != 0;
            case 12:
                return e0.x(obj, jQ) != 0;
            case 13:
                return e0.x(obj, jQ) != 0;
            case 14:
                return e0.y(obj, jQ) != 0;
            case 15:
                return e0.x(obj, jQ) != 0;
            case 16:
                return e0.y(obj, jQ) != 0;
            case 17:
                return e0.A(obj, jQ) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private boolean y(Object obj, int i, int i2, int i3) {
        return this.h ? x(obj, i) : (i2 & i3) != 0;
    }

    private static boolean z(Object obj, int i, V v) {
        return v.f(e0.A(obj, Q(i)));
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public void a(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.a.length; i += 3) {
            L(obj, obj2, i);
        }
        if (this.h) {
            return;
        }
        X.F(this.o, obj, obj2);
        if (this.f) {
            X.D(this.p, obj, obj2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public int b(Object obj) {
        int i;
        int iF;
        int length = this.a.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iH0 = h0(i3);
            int iP = P(i3);
            long jQ = Q(iH0);
            int iHashCode = 37;
            switch (g0(iH0)) {
                case 0:
                    i = i2 * 53;
                    iF = AbstractC1952v.f(Double.doubleToLongBits(e0.v(obj, jQ)));
                    i2 = i + iF;
                    break;
                case 1:
                    i = i2 * 53;
                    iF = Float.floatToIntBits(e0.w(obj, jQ));
                    i2 = i + iF;
                    break;
                case 2:
                    i = i2 * 53;
                    iF = AbstractC1952v.f(e0.y(obj, jQ));
                    i2 = i + iF;
                    break;
                case 3:
                    i = i2 * 53;
                    iF = AbstractC1952v.f(e0.y(obj, jQ));
                    i2 = i + iF;
                    break;
                case 4:
                    i = i2 * 53;
                    iF = e0.x(obj, jQ);
                    i2 = i + iF;
                    break;
                case 5:
                    i = i2 * 53;
                    iF = AbstractC1952v.f(e0.y(obj, jQ));
                    i2 = i + iF;
                    break;
                case 6:
                    i = i2 * 53;
                    iF = e0.x(obj, jQ);
                    i2 = i + iF;
                    break;
                case 7:
                    i = i2 * 53;
                    iF = AbstractC1952v.c(e0.p(obj, jQ));
                    i2 = i + iF;
                    break;
                case 8:
                    i = i2 * 53;
                    iF = ((String) e0.A(obj, jQ)).hashCode();
                    i2 = i + iF;
                    break;
                case 9:
                    Object objA = e0.A(obj, jQ);
                    if (objA != null) {
                        iHashCode = objA.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iF = e0.A(obj, jQ).hashCode();
                    i2 = i + iF;
                    break;
                case 11:
                    i = i2 * 53;
                    iF = e0.x(obj, jQ);
                    i2 = i + iF;
                    break;
                case 12:
                    i = i2 * 53;
                    iF = e0.x(obj, jQ);
                    i2 = i + iF;
                    break;
                case 13:
                    i = i2 * 53;
                    iF = e0.x(obj, jQ);
                    i2 = i + iF;
                    break;
                case 14:
                    i = i2 * 53;
                    iF = AbstractC1952v.f(e0.y(obj, jQ));
                    i2 = i + iF;
                    break;
                case 15:
                    i = i2 * 53;
                    iF = e0.x(obj, jQ);
                    i2 = i + iF;
                    break;
                case 16:
                    i = i2 * 53;
                    iF = AbstractC1952v.f(e0.y(obj, jQ));
                    i2 = i + iF;
                    break;
                case 17:
                    Object objA2 = e0.A(obj, jQ);
                    if (objA2 != null) {
                        iHashCode = objA2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iF = e0.A(obj, jQ).hashCode();
                    i2 = i + iF;
                    break;
                case 50:
                    i = i2 * 53;
                    iF = e0.A(obj, jQ).hashCode();
                    i2 = i + iF;
                    break;
                case 51:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = AbstractC1952v.f(Double.doubleToLongBits(S(obj, jQ)));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case Type.TLSA /* 52 */:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = Float.floatToIntBits(T(obj, jQ));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = AbstractC1952v.f(V(obj, jQ));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = AbstractC1952v.f(V(obj, jQ));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = U(obj, jQ);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case Type.NINFO /* 56 */:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = AbstractC1952v.f(V(obj, jQ));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = U(obj, jQ);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = AbstractC1952v.c(R(obj, jQ));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = ((String) e0.A(obj, jQ)).hashCode();
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = e0.A(obj, jQ).hashCode();
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = e0.A(obj, jQ).hashCode();
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = U(obj, jQ);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = U(obj, jQ);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = U(obj, jQ);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = AbstractC1952v.f(V(obj, jQ));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = U(obj, jQ);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = AbstractC1952v.f(V(obj, jQ));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (D(obj, iP, i3)) {
                        i = i2 * 53;
                        iF = e0.A(obj, jQ).hashCode();
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.o.g(obj).hashCode();
        return this.f ? (iHashCode2 * 53) + this.p.c(obj).hashCode() : iHashCode2;
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public boolean c(Object obj, Object obj2) {
        int length = this.a.length;
        for (int i = 0; i < length; i += 3) {
            if (!m(obj, obj2, i)) {
                return false;
            }
        }
        if (!this.o.g(obj).equals(this.o.g(obj2))) {
            return false;
        }
        if (this.f) {
            return this.p.c(obj).equals(this.p.c(obj2));
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public Object d() {
        return this.m.a(this.e);
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public void e(Object obj) {
        int i;
        int i2 = this.k;
        while (true) {
            i = this.l;
            if (i2 >= i) {
                break;
            }
            long jQ = Q(h0(this.j[i2]));
            Object objA = e0.A(obj, jQ);
            if (objA != null) {
                e0.O(obj, jQ, this.q.f(objA));
            }
            i2++;
        }
        int length = this.j.length;
        while (i < length) {
            this.n.c(obj, this.j[i]);
            i++;
        }
        this.o.j(obj);
        if (this.f) {
            this.p.f(obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    @Override // androidx.datastore.preferences.protobuf.V
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(java.lang.Object r13) {
        /*
            r12 = this;
            r0 = -1
            r1 = 0
            r2 = r1
            r3 = r2
        L4:
            int r4 = r12.k
            r5 = 1
            if (r2 >= r4) goto L94
            int[] r4 = r12.j
            r4 = r4[r2]
            int r6 = r12.P(r4)
            int r7 = r12.h0(r4)
            boolean r8 = r12.h
            if (r8 != 0) goto L31
            int[] r8 = r12.a
            int r9 = r4 + 2
            r8 = r8[r9]
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r8
            int r8 = r8 >>> 20
            int r5 = r5 << r8
            if (r9 == r0) goto L32
            sun.misc.Unsafe r0 = androidx.datastore.preferences.protobuf.K.s
            long r10 = (long) r9
            int r3 = r0.getInt(r13, r10)
            r0 = r9
            goto L32
        L31:
            r5 = r1
        L32:
            boolean r8 = E(r7)
            if (r8 == 0) goto L3f
            boolean r8 = r12.y(r13, r4, r3, r5)
            if (r8 != 0) goto L3f
            return r1
        L3f:
            int r8 = g0(r7)
            r9 = 9
            if (r8 == r9) goto L7f
            r9 = 17
            if (r8 == r9) goto L7f
            r5 = 27
            if (r8 == r5) goto L78
            r5 = 60
            if (r8 == r5) goto L67
            r5 = 68
            if (r8 == r5) goto L67
            r5 = 49
            if (r8 == r5) goto L78
            r5 = 50
            if (r8 == r5) goto L60
            goto L90
        L60:
            boolean r4 = r12.B(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L67:
            boolean r5 = r12.D(r13, r6, r4)
            if (r5 == 0) goto L90
            androidx.datastore.preferences.protobuf.V r4 = r12.r(r4)
            boolean r4 = z(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L78:
            boolean r4 = r12.A(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L7f:
            boolean r5 = r12.y(r13, r4, r3, r5)
            if (r5 == 0) goto L90
            androidx.datastore.preferences.protobuf.V r4 = r12.r(r4)
            boolean r4 = z(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L90:
            int r2 = r2 + 1
            goto L4
        L94:
            boolean r0 = r12.f
            if (r0 == 0) goto La5
            androidx.datastore.preferences.protobuf.n r0 = r12.p
            androidx.datastore.preferences.protobuf.q r13 = r0.c(r13)
            boolean r13 = r13.k()
            if (r13 != 0) goto La5
            return r1
        La5:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.K.f(java.lang.Object):boolean");
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public int g(Object obj) {
        return this.h ? t(obj) : s(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public void h(Object obj, U u, C1944m c1944m) {
        c1944m.getClass();
        H(this.o, this.p, obj, u, c1944m);
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public void i(Object obj, h0 h0Var) {
        if (h0Var.t() == h0.a.DESCENDING) {
            k0(obj, h0Var);
        } else if (this.h) {
            j0(obj, h0Var);
        } else {
            i0(obj, h0Var);
        }
    }
}
