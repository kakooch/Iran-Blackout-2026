package com.google.crypto.tink.shaded.protobuf;

import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import com.google.crypto.tink.shaded.protobuf.AbstractC2343e;
import com.google.crypto.tink.shaded.protobuf.AbstractC2360w;
import com.google.crypto.tink.shaded.protobuf.B;
import com.google.crypto.tink.shaded.protobuf.g0;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.EnumC4752Gk2;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
final class K implements V {
    private static final int[] r = new int[0];
    private static final Unsafe s = d0.D();
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
    private final AbstractC2362y n;
    private final a0 o;
    private final AbstractC2353o p;
    private final D q;

    private K(int[] iArr, Object[] objArr, int i, int i2, I i3, boolean z, boolean z2, int[] iArr2, int i4, int i5, M m, AbstractC2362y abstractC2362y, a0 a0Var, AbstractC2353o abstractC2353o, D d) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.g = i3 instanceof AbstractC2358u;
        this.h = z;
        this.f = abstractC2353o != null && abstractC2353o.e(i3);
        this.i = z2;
        this.j = iArr2;
        this.k = i4;
        this.l = i5;
        this.m = m;
        this.n = abstractC2362y;
        this.o = a0Var;
        this.p = abstractC2353o;
        this.e = i3;
        this.q = d;
    }

    private static boolean A(int i) {
        return (i & 536870912) != 0;
    }

    private void A0(g0 g0Var, int i, Object obj, int i2) {
        if (obj != null) {
            this.q.b(t(i2));
            g0Var.J(i, null, this.q.e(obj));
        }
    }

    private boolean B(Object obj, int i) {
        int iK0 = k0(i);
        long j = 1048575 & iK0;
        if (j != 1048575) {
            return (d0.z(obj, j) & (1 << (iK0 >>> 20))) != 0;
        }
        int iW0 = w0(i);
        long jX = X(iW0);
        switch (v0(iW0)) {
            case 0:
                return Double.doubleToRawLongBits(d0.x(obj, jX)) != 0;
            case 1:
                return Float.floatToRawIntBits(d0.y(obj, jX)) != 0;
            case 2:
                return d0.A(obj, jX) != 0;
            case 3:
                return d0.A(obj, jX) != 0;
            case 4:
                return d0.z(obj, jX) != 0;
            case 5:
                return d0.A(obj, jX) != 0;
            case 6:
                return d0.z(obj, jX) != 0;
            case 7:
                return d0.r(obj, jX);
            case 8:
                Object objC = d0.C(obj, jX);
                if (objC instanceof String) {
                    return !((String) objC).isEmpty();
                }
                if (objC instanceof AbstractC2345g) {
                    return !AbstractC2345g.b.equals(objC);
                }
                throw new IllegalArgumentException();
            case 9:
                return d0.C(obj, jX) != null;
            case 10:
                return !AbstractC2345g.b.equals(d0.C(obj, jX));
            case 11:
                return d0.z(obj, jX) != 0;
            case 12:
                return d0.z(obj, jX) != 0;
            case 13:
                return d0.z(obj, jX) != 0;
            case 14:
                return d0.A(obj, jX) != 0;
            case 15:
                return d0.z(obj, jX) != 0;
            case 16:
                return d0.A(obj, jX) != 0;
            case 17:
                return d0.C(obj, jX) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void B0(int i, Object obj, g0 g0Var) {
        if (obj instanceof String) {
            g0Var.e(i, (String) obj);
        } else {
            g0Var.M(i, (AbstractC2345g) obj);
        }
    }

    private boolean C(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? B(obj, i) : (i3 & i4) != 0;
    }

    private void C0(a0 a0Var, Object obj, g0 g0Var) {
        a0Var.t(a0Var.g(obj), g0Var);
    }

    private static boolean D(Object obj, int i, V v) {
        return v.f(d0.C(obj, X(i)));
    }

    private boolean E(Object obj, int i, int i2) {
        List list = (List) d0.C(obj, X(i));
        if (list.isEmpty()) {
            return true;
        }
        V vU = u(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!vU.f(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private boolean F(Object obj, int i, int i2) {
        if (this.q.e(d0.C(obj, X(i))).isEmpty()) {
            return true;
        }
        this.q.b(t(i2));
        throw null;
    }

    private static boolean G(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof AbstractC2358u) {
            return ((AbstractC2358u) obj).A();
        }
        return true;
    }

    private boolean H(Object obj, Object obj2, int i) {
        long jK0 = k0(i) & 1048575;
        return d0.z(obj, jK0) == d0.z(obj2, jK0);
    }

    private boolean I(Object obj, int i, int i2) {
        return d0.z(obj, (long) (k0(i2) & 1048575)) == i;
    }

    private static boolean J(int i) {
        return (i & 268435456) != 0;
    }

    private static List K(Object obj, long j) {
        return (List) d0.C(obj, j);
    }

    private static long L(Object obj, long j) {
        return d0.A(obj, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:324:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
    
        r12 = r10.k;
        r3 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
    
        if (r12 >= r10.l) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
    
        r3 = q(r13, r10.j[r12], r3, r11, r13);
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
    
        if (r3 == null) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0081, code lost:
    
        r11.o(r13, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void M(com.google.crypto.tink.shaded.protobuf.a0 r11, com.google.crypto.tink.shaded.protobuf.AbstractC2353o r12, java.lang.Object r13, com.google.crypto.tink.shaded.protobuf.U r14, com.google.crypto.tink.shaded.protobuf.C2352n r15) {
        /*
            Method dump skipped, instructions count: 1570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.K.M(com.google.crypto.tink.shaded.protobuf.a0, com.google.crypto.tink.shaded.protobuf.o, java.lang.Object, com.google.crypto.tink.shaded.protobuf.U, com.google.crypto.tink.shaded.protobuf.n):void");
    }

    private final void N(Object obj, int i, Object obj2, C2352n c2352n, U u) {
        long jX = X(w0(i));
        Object objC = d0.C(obj, jX);
        if (objC == null) {
            objC = this.q.d(obj2);
            d0.R(obj, jX, objC);
        } else if (this.q.h(objC)) {
            Object objD = this.q.d(obj2);
            this.q.a(objD, objC);
            d0.R(obj, jX, objD);
            objC = objD;
        }
        Map mapC = this.q.c(objC);
        this.q.b(obj2);
        u.J(mapC, null, c2352n);
    }

    private void O(Object obj, Object obj2, int i) {
        if (B(obj2, i)) {
            long jX = X(w0(i));
            Unsafe unsafe = s;
            Object object = unsafe.getObject(obj2, jX);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + W(i) + " is present but null: " + obj2);
            }
            V vU = u(i);
            if (!B(obj, i)) {
                if (G(object)) {
                    Object objD = vU.d();
                    vU.a(objD, object);
                    unsafe.putObject(obj, jX, objD);
                } else {
                    unsafe.putObject(obj, jX, object);
                }
                q0(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jX);
            if (!G(object2)) {
                Object objD2 = vU.d();
                vU.a(objD2, object2);
                unsafe.putObject(obj, jX, objD2);
                object2 = objD2;
            }
            vU.a(object2, object);
        }
    }

    private void P(Object obj, Object obj2, int i) {
        int iW = W(i);
        if (I(obj2, iW, i)) {
            long jX = X(w0(i));
            Unsafe unsafe = s;
            Object object = unsafe.getObject(obj2, jX);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + W(i) + " is present but null: " + obj2);
            }
            V vU = u(i);
            if (!I(obj, iW, i)) {
                if (G(object)) {
                    Object objD = vU.d();
                    vU.a(objD, object);
                    unsafe.putObject(obj, jX, objD);
                } else {
                    unsafe.putObject(obj, jX, object);
                }
                r0(obj, iW, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jX);
            if (!G(object2)) {
                Object objD2 = vU.d();
                vU.a(objD2, object2);
                unsafe.putObject(obj, jX, objD2);
                object2 = objD2;
            }
            vU.a(object2, object);
        }
    }

    private void Q(Object obj, Object obj2, int i) {
        int iW0 = w0(i);
        long jX = X(iW0);
        int iW = W(i);
        switch (v0(iW0)) {
            case 0:
                if (B(obj2, i)) {
                    d0.N(obj, jX, d0.x(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 1:
                if (B(obj2, i)) {
                    d0.O(obj, jX, d0.y(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 2:
                if (B(obj2, i)) {
                    d0.Q(obj, jX, d0.A(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 3:
                if (B(obj2, i)) {
                    d0.Q(obj, jX, d0.A(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 4:
                if (B(obj2, i)) {
                    d0.P(obj, jX, d0.z(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 5:
                if (B(obj2, i)) {
                    d0.Q(obj, jX, d0.A(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 6:
                if (B(obj2, i)) {
                    d0.P(obj, jX, d0.z(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 7:
                if (B(obj2, i)) {
                    d0.H(obj, jX, d0.r(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 8:
                if (B(obj2, i)) {
                    d0.R(obj, jX, d0.C(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 9:
                O(obj, obj2, i);
                break;
            case 10:
                if (B(obj2, i)) {
                    d0.R(obj, jX, d0.C(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 11:
                if (B(obj2, i)) {
                    d0.P(obj, jX, d0.z(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 12:
                if (B(obj2, i)) {
                    d0.P(obj, jX, d0.z(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 13:
                if (B(obj2, i)) {
                    d0.P(obj, jX, d0.z(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 14:
                if (B(obj2, i)) {
                    d0.Q(obj, jX, d0.A(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 15:
                if (B(obj2, i)) {
                    d0.P(obj, jX, d0.z(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 16:
                if (B(obj2, i)) {
                    d0.Q(obj, jX, d0.A(obj2, jX));
                    q0(obj, i);
                    break;
                }
                break;
            case 17:
                O(obj, obj2, i);
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
                this.n.d(obj, obj2, jX);
                break;
            case 50:
                X.E(this.q, obj, obj2, jX);
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
                if (I(obj2, iW, i)) {
                    d0.R(obj, jX, d0.C(obj2, jX));
                    r0(obj, iW, i);
                    break;
                }
                break;
            case 60:
                P(obj, obj2, i);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case WKSRecord.Protocol.RVD /* 66 */:
            case 67:
                if (I(obj2, iW, i)) {
                    d0.R(obj, jX, d0.C(obj2, jX));
                    r0(obj, iW, i);
                    break;
                }
                break;
            case WKSRecord.Service.BOOTPC /* 68 */:
                P(obj, obj2, i);
                break;
        }
    }

    private Object R(Object obj, int i) {
        V vU = u(i);
        long jX = X(w0(i));
        if (!B(obj, i)) {
            return vU.d();
        }
        Object object = s.getObject(obj, jX);
        if (G(object)) {
            return object;
        }
        Object objD = vU.d();
        if (object != null) {
            vU.a(objD, object);
        }
        return objD;
    }

    private Object S(Object obj, int i, int i2) {
        V vU = u(i2);
        if (!I(obj, i, i2)) {
            return vU.d();
        }
        Object object = s.getObject(obj, X(w0(i2)));
        if (G(object)) {
            return object;
        }
        Object objD = vU.d();
        if (object != null) {
            vU.a(objD, object);
        }
        return objD;
    }

    static K T(Class cls, G g, M m, AbstractC2362y abstractC2362y, a0 a0Var, AbstractC2353o abstractC2353o, D d) {
        if (g instanceof T) {
            return V((T) g, m, abstractC2362y, a0Var, abstractC2353o, d);
        }
        AbstractC18350oW3.a(g);
        return U(null, m, abstractC2362y, a0Var, abstractC2353o, d);
    }

    static K U(Y y, M m, AbstractC2362y abstractC2362y, a0 a0Var, AbstractC2353o abstractC2353o, D d) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x036d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.crypto.tink.shaded.protobuf.K V(com.google.crypto.tink.shaded.protobuf.T r33, com.google.crypto.tink.shaded.protobuf.M r34, com.google.crypto.tink.shaded.protobuf.AbstractC2362y r35, com.google.crypto.tink.shaded.protobuf.a0 r36, com.google.crypto.tink.shaded.protobuf.AbstractC2353o r37, com.google.crypto.tink.shaded.protobuf.D r38) {
        /*
            Method dump skipped, instructions count: 994
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.K.V(com.google.crypto.tink.shaded.protobuf.T, com.google.crypto.tink.shaded.protobuf.M, com.google.crypto.tink.shaded.protobuf.y, com.google.crypto.tink.shaded.protobuf.a0, com.google.crypto.tink.shaded.protobuf.o, com.google.crypto.tink.shaded.protobuf.D):com.google.crypto.tink.shaded.protobuf.K");
    }

    private int W(int i) {
        return this.a[i];
    }

    private static long X(int i) {
        return i & 1048575;
    }

    private static boolean Y(Object obj, long j) {
        return ((Boolean) d0.C(obj, j)).booleanValue();
    }

    private static double Z(Object obj, long j) {
        return ((Double) d0.C(obj, j)).doubleValue();
    }

    private static float a0(Object obj, long j) {
        return ((Float) d0.C(obj, j)).floatValue();
    }

    private static int b0(Object obj, long j) {
        return ((Integer) d0.C(obj, j)).intValue();
    }

    private static long c0(Object obj, long j) {
        return ((Long) d0.C(obj, j)).longValue();
    }

    private int d0(Object obj, byte[] bArr, int i, int i2, int i3, long j, AbstractC2343e.a aVar) {
        Unsafe unsafe = s;
        Object objT = t(i3);
        Object object = unsafe.getObject(obj, j);
        if (this.q.h(object)) {
            Object objD = this.q.d(objT);
            this.q.a(objD, object);
            unsafe.putObject(obj, j, objD);
            object = objD;
        }
        this.q.b(objT);
        return n(bArr, i, i2, null, this.q.c(object), aVar);
    }

    private int e0(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, AbstractC2343e.a aVar) throws InvalidProtocolBufferException {
        Unsafe unsafe = s;
        long j2 = this.a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Double.valueOf(AbstractC2343e.d(bArr, i)));
                    int i9 = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return i9;
                }
                break;
            case Type.TLSA /* 52 */:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Float.valueOf(AbstractC2343e.k(bArr, i)));
                    int i10 = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return i10;
                }
                break;
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                if (i5 == 0) {
                    int iK = AbstractC2343e.K(bArr, i, aVar);
                    unsafe.putObject(obj, j, Long.valueOf(aVar.b));
                    unsafe.putInt(obj, j2, i4);
                    return iK;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int iH = AbstractC2343e.H(bArr, i, aVar);
                    unsafe.putObject(obj, j, Integer.valueOf(aVar.a));
                    unsafe.putInt(obj, j2, i4);
                    return iH;
                }
                break;
            case Type.NINFO /* 56 */:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Long.valueOf(AbstractC2343e.i(bArr, i)));
                    int i11 = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return i11;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Integer.valueOf(AbstractC2343e.g(bArr, i)));
                    int i12 = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return i12;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int iK2 = AbstractC2343e.K(bArr, i, aVar);
                    unsafe.putObject(obj, j, Boolean.valueOf(aVar.b != 0));
                    unsafe.putInt(obj, j2, i4);
                    return iK2;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int iH2 = AbstractC2343e.H(bArr, i, aVar);
                    int i13 = aVar.a;
                    if (i13 == 0) {
                        unsafe.putObject(obj, j, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !e0.n(bArr, iH2, iH2 + i13)) {
                            throw InvalidProtocolBufferException.d();
                        }
                        unsafe.putObject(obj, j, new String(bArr, iH2, i13, AbstractC2360w.b));
                        iH2 += i13;
                    }
                    unsafe.putInt(obj, j2, i4);
                    return iH2;
                }
                break;
            case 60:
                if (i5 == 2) {
                    Object objS = S(obj, i4, i8);
                    int iN = AbstractC2343e.N(objS, u(i8), bArr, i, i2, aVar);
                    u0(obj, i4, i8, objS);
                    return iN;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int iB = AbstractC2343e.b(bArr, i, aVar);
                    unsafe.putObject(obj, j, aVar.c);
                    unsafe.putInt(obj, j2, i4);
                    return iB;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int iH3 = AbstractC2343e.H(bArr, i, aVar);
                    int i14 = aVar.a;
                    s(i8);
                    unsafe.putObject(obj, j, Integer.valueOf(i14));
                    unsafe.putInt(obj, j2, i4);
                    return iH3;
                }
                break;
            case WKSRecord.Protocol.RVD /* 66 */:
                if (i5 == 0) {
                    int iH4 = AbstractC2343e.H(bArr, i, aVar);
                    unsafe.putObject(obj, j, Integer.valueOf(AbstractC2346h.b(aVar.a)));
                    unsafe.putInt(obj, j2, i4);
                    return iH4;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int iK3 = AbstractC2343e.K(bArr, i, aVar);
                    unsafe.putObject(obj, j, Long.valueOf(AbstractC2346h.c(aVar.b)));
                    unsafe.putInt(obj, j2, i4);
                    return iK3;
                }
                break;
            case WKSRecord.Service.BOOTPC /* 68 */:
                if (i5 == 3) {
                    Object objS2 = S(obj, i4, i8);
                    int iM = AbstractC2343e.M(objS2, u(i8), bArr, i, i2, (i3 & (-8)) | 4, aVar);
                    u0(obj, i4, i8, objS2);
                    return iM;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x02b2, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02e8, code lost:
    
        if (r0 != r15) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0307, code lost:
    
        if (r0 != r15) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0298, code lost:
    
        if (r0 != r10) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x029a, code lost:
    
        r15 = r29;
        r14 = r30;
        r12 = r31;
        r13 = r33;
        r11 = r34;
        r1 = r18;
        r8 = r19;
        r7 = r22;
        r6 = r26;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0089. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int g0(java.lang.Object r30, byte[] r31, int r32, int r33, com.google.crypto.tink.shaded.protobuf.AbstractC2343e.a r34) throws com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException {
        /*
            Method dump skipped, instructions count: 876
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.K.g0(java.lang.Object, byte[], int, int, com.google.crypto.tink.shaded.protobuf.e$a):int");
    }

    private int h0(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, AbstractC2343e.a aVar) throws InvalidProtocolBufferException {
        int I;
        Unsafe unsafe = s;
        AbstractC2360w.d dVarB = (AbstractC2360w.d) unsafe.getObject(obj, j2);
        if (!dVarB.u()) {
            int size = dVarB.size();
            dVarB = dVarB.b(size == 0 ? 10 : size * 2);
            unsafe.putObject(obj, j2, dVarB);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return AbstractC2343e.r(bArr, i, dVarB, aVar);
                }
                if (i5 == 1) {
                    return AbstractC2343e.e(i3, bArr, i, i2, dVarB, aVar);
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    return AbstractC2343e.u(bArr, i, dVarB, aVar);
                }
                if (i5 == 5) {
                    return AbstractC2343e.l(i3, bArr, i, i2, dVarB, aVar);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    return AbstractC2343e.y(bArr, i, dVarB, aVar);
                }
                if (i5 == 0) {
                    return AbstractC2343e.L(i3, bArr, i, i2, dVarB, aVar);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return AbstractC2343e.x(bArr, i, dVarB, aVar);
                }
                if (i5 == 0) {
                    return AbstractC2343e.I(i3, bArr, i, i2, dVarB, aVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return AbstractC2343e.t(bArr, i, dVarB, aVar);
                }
                if (i5 == 1) {
                    return AbstractC2343e.j(i3, bArr, i, i2, dVarB, aVar);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    return AbstractC2343e.s(bArr, i, dVarB, aVar);
                }
                if (i5 == 5) {
                    return AbstractC2343e.h(i3, bArr, i, i2, dVarB, aVar);
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    return AbstractC2343e.q(bArr, i, dVarB, aVar);
                }
                if (i5 == 0) {
                    return AbstractC2343e.a(i3, bArr, i, i2, dVarB, aVar);
                }
                break;
            case 26:
                if (i5 == 2) {
                    return (j & 536870912) == 0 ? AbstractC2343e.C(i3, bArr, i, i2, dVarB, aVar) : AbstractC2343e.D(i3, bArr, i, i2, dVarB, aVar);
                }
                break;
            case 27:
                if (i5 == 2) {
                    return AbstractC2343e.p(u(i6), i3, bArr, i, i2, dVarB, aVar);
                }
                break;
            case 28:
                if (i5 == 2) {
                    return AbstractC2343e.c(i3, bArr, i, i2, dVarB, aVar);
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    I = AbstractC2343e.x(bArr, i, dVarB, aVar);
                } else if (i5 == 0) {
                    I = AbstractC2343e.I(i3, bArr, i, i2, dVarB, aVar);
                }
                s(i6);
                X.z(obj, i4, dVarB, null, null, this.o);
                return I;
            case 33:
            case 47:
                if (i5 == 2) {
                    return AbstractC2343e.v(bArr, i, dVarB, aVar);
                }
                if (i5 == 0) {
                    return AbstractC2343e.z(i3, bArr, i, i2, dVarB, aVar);
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    return AbstractC2343e.w(bArr, i, dVarB, aVar);
                }
                if (i5 == 0) {
                    return AbstractC2343e.A(i3, bArr, i, i2, dVarB, aVar);
                }
                break;
            case 49:
                if (i5 == 3) {
                    return AbstractC2343e.n(u(i6), i3, bArr, i, i2, dVarB, aVar);
                }
                break;
        }
        return i;
    }

    private int i0(int i) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return s0(i, 0);
    }

    private int j0(int i, int i2) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return s0(i, i2);
    }

    private boolean k(Object obj, Object obj2, int i) {
        return B(obj, i) == B(obj2, i);
    }

    private int k0(int i) {
        return this.a[i + 2];
    }

    private static boolean l(Object obj, long j) {
        return d0.r(obj, j);
    }

    private void l0(Object obj, long j, U u, V v, C2352n c2352n) {
        u.M(this.n.e(obj, j), v, c2352n);
    }

    private static void m(Object obj) {
        if (G(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    private void m0(Object obj, int i, U u, V v, C2352n c2352n) {
        u.L(this.n.e(obj, X(i)), v, c2352n);
    }

    private int n(byte[] bArr, int i, int i2, B.a aVar, Map map, AbstractC2343e.a aVar2) throws InvalidProtocolBufferException {
        int iH = AbstractC2343e.H(bArr, i, aVar2);
        int i3 = aVar2.a;
        if (i3 < 0 || i3 > i2 - iH) {
            throw InvalidProtocolBufferException.p();
        }
        throw null;
    }

    private void n0(Object obj, int i, U u) {
        if (A(i)) {
            d0.R(obj, X(i), u.H());
        } else if (this.g) {
            d0.R(obj, X(i), u.y());
        } else {
            d0.R(obj, X(i), u.n());
        }
    }

    private static double o(Object obj, long j) {
        return d0.x(obj, j);
    }

    private void o0(Object obj, int i, U u) {
        if (A(i)) {
            u.m(this.n.e(obj, X(i)));
        } else {
            u.A(this.n.e(obj, X(i)));
        }
    }

    private boolean p(Object obj, Object obj2, int i) {
        int iW0 = w0(i);
        long jX = X(iW0);
        switch (v0(iW0)) {
            case 0:
                if (k(obj, obj2, i) && Double.doubleToLongBits(d0.x(obj, jX)) == Double.doubleToLongBits(d0.x(obj2, jX))) {
                    break;
                }
                break;
            case 1:
                if (k(obj, obj2, i) && Float.floatToIntBits(d0.y(obj, jX)) == Float.floatToIntBits(d0.y(obj2, jX))) {
                    break;
                }
                break;
            case 2:
                if (k(obj, obj2, i) && d0.A(obj, jX) == d0.A(obj2, jX)) {
                    break;
                }
                break;
            case 3:
                if (k(obj, obj2, i) && d0.A(obj, jX) == d0.A(obj2, jX)) {
                    break;
                }
                break;
            case 4:
                if (k(obj, obj2, i) && d0.z(obj, jX) == d0.z(obj2, jX)) {
                    break;
                }
                break;
            case 5:
                if (k(obj, obj2, i) && d0.A(obj, jX) == d0.A(obj2, jX)) {
                    break;
                }
                break;
            case 6:
                if (k(obj, obj2, i) && d0.z(obj, jX) == d0.z(obj2, jX)) {
                    break;
                }
                break;
            case 7:
                if (k(obj, obj2, i) && d0.r(obj, jX) == d0.r(obj2, jX)) {
                    break;
                }
                break;
            case 8:
                if (k(obj, obj2, i) && X.J(d0.C(obj, jX), d0.C(obj2, jX))) {
                    break;
                }
                break;
            case 9:
                if (k(obj, obj2, i) && X.J(d0.C(obj, jX), d0.C(obj2, jX))) {
                    break;
                }
                break;
            case 10:
                if (k(obj, obj2, i) && X.J(d0.C(obj, jX), d0.C(obj2, jX))) {
                    break;
                }
                break;
            case 11:
                if (k(obj, obj2, i) && d0.z(obj, jX) == d0.z(obj2, jX)) {
                    break;
                }
                break;
            case 12:
                if (k(obj, obj2, i) && d0.z(obj, jX) == d0.z(obj2, jX)) {
                    break;
                }
                break;
            case 13:
                if (k(obj, obj2, i) && d0.z(obj, jX) == d0.z(obj2, jX)) {
                    break;
                }
                break;
            case 14:
                if (k(obj, obj2, i) && d0.A(obj, jX) == d0.A(obj2, jX)) {
                    break;
                }
                break;
            case 15:
                if (k(obj, obj2, i) && d0.z(obj, jX) == d0.z(obj2, jX)) {
                    break;
                }
                break;
            case 16:
                if (k(obj, obj2, i) && d0.A(obj, jX) == d0.A(obj2, jX)) {
                    break;
                }
                break;
            case 17:
                if (k(obj, obj2, i) && X.J(d0.C(obj, jX), d0.C(obj2, jX))) {
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
                if (H(obj, obj2, i) && X.J(d0.C(obj, jX), d0.C(obj2, jX))) {
                    break;
                }
                break;
        }
        return true;
    }

    private static Field p0(Class cls, String str) {
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

    private Object q(Object obj, int i, Object obj2, a0 a0Var, Object obj3) {
        W(i);
        if (d0.C(obj, X(w0(i))) == null) {
            return obj2;
        }
        s(i);
        return obj2;
    }

    private void q0(Object obj, int i) {
        int iK0 = k0(i);
        long j = 1048575 & iK0;
        if (j == 1048575) {
            return;
        }
        d0.P(obj, j, (1 << (iK0 >>> 20)) | d0.z(obj, j));
    }

    private static float r(Object obj, long j) {
        return d0.y(obj, j);
    }

    private void r0(Object obj, int i, int i2) {
        d0.P(obj, k0(i2) & 1048575, i);
    }

    private AbstractC2360w.c s(int i) {
        AbstractC18350oW3.a(this.b[((i / 3) * 2) + 1]);
        return null;
    }

    private int s0(int i, int i2) {
        int length = (this.a.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int iW = W(i4);
            if (i == iW) {
                return i4;
            }
            if (i < iW) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private Object t(int i) {
        return this.b[(i / 3) * 2];
    }

    private void t0(Object obj, int i, Object obj2) {
        s.putObject(obj, X(w0(i)), obj2);
        q0(obj, i);
    }

    private V u(int i) {
        int i2 = (i / 3) * 2;
        V v = (V) this.b[i2];
        if (v != null) {
            return v;
        }
        V vC = Q.a().c((Class) this.b[i2 + 1]);
        this.b[i2] = vC;
        return vC;
    }

    private void u0(Object obj, int i, int i2, Object obj2) {
        s.putObject(obj, X(w0(i2)), obj2);
        r0(obj, i, i2);
    }

    static b0 v(Object obj) {
        AbstractC2358u abstractC2358u = (AbstractC2358u) obj;
        b0 b0Var = abstractC2358u.unknownFields;
        if (b0Var != b0.c()) {
            return b0Var;
        }
        b0 b0VarK = b0.k();
        abstractC2358u.unknownFields = b0VarK;
        return b0VarK;
    }

    private static int v0(int i) {
        return (i & 267386880) >>> 20;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int w(Object obj) {
        int i;
        int i2;
        int iH;
        int iD;
        int iB;
        boolean z;
        int iF;
        int i3;
        int iL;
        int iN;
        Unsafe unsafe = s;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < this.a.length) {
            int iW0 = w0(i6);
            int iW = W(i6);
            int iV0 = v0(iW0);
            if (iV0 <= 17) {
                i = this.a[i6 + 2];
                int i9 = i & i4;
                i2 = 1 << (i >>> 20);
                if (i9 != i5) {
                    i8 = unsafe.getInt(obj, i9);
                    i5 = i9;
                }
            } else {
                i = (!this.i || iV0 < EnumC4752Gk2.F0.a() || iV0 > EnumC4752Gk2.S0.a()) ? 0 : this.a[i6 + 2] & i4;
                i2 = 0;
            }
            long jX = X(iW0);
            switch (iV0) {
                case 0:
                    if ((i8 & i2) == 0) {
                        break;
                    } else {
                        iH = CodedOutputStream.h(iW, 0.0d);
                        i7 += iH;
                        break;
                    }
                case 1:
                    if ((i8 & i2) == 0) {
                        break;
                    } else {
                        iH = CodedOutputStream.p(iW, 0.0f);
                        i7 += iH;
                        break;
                    }
                case 2:
                    if ((i8 & i2) == 0) {
                        break;
                    } else {
                        iH = CodedOutputStream.v(iW, unsafe.getLong(obj, jX));
                        i7 += iH;
                        break;
                    }
                case 3:
                    if ((i8 & i2) == 0) {
                        break;
                    } else {
                        iH = CodedOutputStream.O(iW, unsafe.getLong(obj, jX));
                        i7 += iH;
                        break;
                    }
                case 4:
                    if ((i8 & i2) == 0) {
                        break;
                    } else {
                        iH = CodedOutputStream.t(iW, unsafe.getInt(obj, jX));
                        i7 += iH;
                        break;
                    }
                case 5:
                    if ((i8 & i2) == 0) {
                        break;
                    } else {
                        iH = CodedOutputStream.n(iW, 0L);
                        i7 += iH;
                        break;
                    }
                case 6:
                    if ((i8 & i2) != 0) {
                        iH = CodedOutputStream.l(iW, 0);
                        i7 += iH;
                        break;
                    }
                    break;
                case 7:
                    if ((i8 & i2) != 0) {
                        iD = CodedOutputStream.d(iW, true);
                        i7 += iD;
                    }
                    break;
                case 8:
                    if ((i8 & i2) != 0) {
                        Object object = unsafe.getObject(obj, jX);
                        iD = object instanceof AbstractC2345g ? CodedOutputStream.f(iW, (AbstractC2345g) object) : CodedOutputStream.J(iW, (String) object);
                        i7 += iD;
                    }
                    break;
                case 9:
                    if ((i8 & i2) != 0) {
                        iD = X.o(iW, unsafe.getObject(obj, jX), u(i6));
                        i7 += iD;
                    }
                    break;
                case 10:
                    if ((i8 & i2) != 0) {
                        iD = CodedOutputStream.f(iW, (AbstractC2345g) unsafe.getObject(obj, jX));
                        i7 += iD;
                    }
                    break;
                case 11:
                    if ((i8 & i2) != 0) {
                        iD = CodedOutputStream.M(iW, unsafe.getInt(obj, jX));
                        i7 += iD;
                    }
                    break;
                case 12:
                    if ((i8 & i2) != 0) {
                        iD = CodedOutputStream.j(iW, unsafe.getInt(obj, jX));
                        i7 += iD;
                    }
                    break;
                case 13:
                    if ((i8 & i2) != 0) {
                        iB = CodedOutputStream.B(iW, 0);
                        i7 += iB;
                    }
                    break;
                case 14:
                    if ((i8 & i2) != 0) {
                        iD = CodedOutputStream.D(iW, 0L);
                        i7 += iD;
                    }
                    break;
                case 15:
                    if ((i8 & i2) != 0) {
                        iD = CodedOutputStream.F(iW, unsafe.getInt(obj, jX));
                        i7 += iD;
                    }
                    break;
                case 16:
                    if ((i8 & i2) != 0) {
                        iD = CodedOutputStream.H(iW, unsafe.getLong(obj, jX));
                        i7 += iD;
                    }
                    break;
                case 17:
                    if ((i8 & i2) != 0) {
                        iD = CodedOutputStream.r(iW, (I) unsafe.getObject(obj, jX), u(i6));
                        i7 += iD;
                    }
                    break;
                case 18:
                    iD = X.h(iW, (List) unsafe.getObject(obj, jX), false);
                    i7 += iD;
                    break;
                case 19:
                    z = false;
                    iF = X.f(iW, (List) unsafe.getObject(obj, jX), false);
                    i7 += iF;
                    break;
                case 20:
                    z = false;
                    iF = X.m(iW, (List) unsafe.getObject(obj, jX), false);
                    i7 += iF;
                    break;
                case 21:
                    z = false;
                    iF = X.x(iW, (List) unsafe.getObject(obj, jX), false);
                    i7 += iF;
                    break;
                case 22:
                    z = false;
                    iF = X.k(iW, (List) unsafe.getObject(obj, jX), false);
                    i7 += iF;
                    break;
                case 23:
                    z = false;
                    iF = X.h(iW, (List) unsafe.getObject(obj, jX), false);
                    i7 += iF;
                    break;
                case 24:
                    z = false;
                    iF = X.f(iW, (List) unsafe.getObject(obj, jX), false);
                    i7 += iF;
                    break;
                case 25:
                    z = false;
                    iF = X.a(iW, (List) unsafe.getObject(obj, jX), false);
                    i7 += iF;
                    break;
                case 26:
                    iD = X.u(iW, (List) unsafe.getObject(obj, jX));
                    i7 += iD;
                    break;
                case 27:
                    iD = X.p(iW, (List) unsafe.getObject(obj, jX), u(i6));
                    i7 += iD;
                    break;
                case 28:
                    iD = X.c(iW, (List) unsafe.getObject(obj, jX));
                    i7 += iD;
                    break;
                case 29:
                    iD = X.v(iW, (List) unsafe.getObject(obj, jX), false);
                    i7 += iD;
                    break;
                case 30:
                    z = false;
                    iF = X.d(iW, (List) unsafe.getObject(obj, jX), false);
                    i7 += iF;
                    break;
                case 31:
                    z = false;
                    iF = X.f(iW, (List) unsafe.getObject(obj, jX), false);
                    i7 += iF;
                    break;
                case 32:
                    z = false;
                    iF = X.h(iW, (List) unsafe.getObject(obj, jX), false);
                    i7 += iF;
                    break;
                case 33:
                    z = false;
                    iF = X.q(iW, (List) unsafe.getObject(obj, jX), false);
                    i7 += iF;
                    break;
                case 34:
                    z = false;
                    iF = X.s(iW, (List) unsafe.getObject(obj, jX), false);
                    i7 += iF;
                    break;
                case 35:
                    i3 = X.i((List) unsafe.getObject(obj, jX));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i3);
                        iB = iL + iN + i3;
                        i7 += iB;
                    }
                    break;
                case 36:
                    i3 = X.g((List) unsafe.getObject(obj, jX));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i3);
                        iB = iL + iN + i3;
                        i7 += iB;
                    }
                    break;
                case 37:
                    i3 = X.n((List) unsafe.getObject(obj, jX));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i3);
                        iB = iL + iN + i3;
                        i7 += iB;
                    }
                    break;
                case 38:
                    i3 = X.y((List) unsafe.getObject(obj, jX));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i3);
                        iB = iL + iN + i3;
                        i7 += iB;
                    }
                    break;
                case 39:
                    i3 = X.l((List) unsafe.getObject(obj, jX));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i3);
                        iB = iL + iN + i3;
                        i7 += iB;
                    }
                    break;
                case 40:
                    i3 = X.i((List) unsafe.getObject(obj, jX));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i3);
                        iB = iL + iN + i3;
                        i7 += iB;
                    }
                    break;
                case 41:
                    i3 = X.g((List) unsafe.getObject(obj, jX));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i3);
                        iB = iL + iN + i3;
                        i7 += iB;
                    }
                    break;
                case 42:
                    i3 = X.b((List) unsafe.getObject(obj, jX));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i3);
                        iB = iL + iN + i3;
                        i7 += iB;
                    }
                    break;
                case 43:
                    i3 = X.w((List) unsafe.getObject(obj, jX));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i3);
                        iB = iL + iN + i3;
                        i7 += iB;
                    }
                    break;
                case 44:
                    i3 = X.e((List) unsafe.getObject(obj, jX));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i3);
                        iB = iL + iN + i3;
                        i7 += iB;
                    }
                    break;
                case 45:
                    i3 = X.g((List) unsafe.getObject(obj, jX));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i3);
                        iB = iL + iN + i3;
                        i7 += iB;
                    }
                    break;
                case 46:
                    i3 = X.i((List) unsafe.getObject(obj, jX));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i3);
                        iB = iL + iN + i3;
                        i7 += iB;
                    }
                    break;
                case 47:
                    i3 = X.r((List) unsafe.getObject(obj, jX));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i3);
                        iB = iL + iN + i3;
                        i7 += iB;
                    }
                    break;
                case 48:
                    i3 = X.t((List) unsafe.getObject(obj, jX));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i3);
                        iB = iL + iN + i3;
                        i7 += iB;
                    }
                    break;
                case 49:
                    iD = X.j(iW, (List) unsafe.getObject(obj, jX), u(i6));
                    i7 += iD;
                    break;
                case 50:
                    iD = this.q.g(iW, unsafe.getObject(obj, jX), t(i6));
                    i7 += iD;
                    break;
                case 51:
                    if (I(obj, iW, i6)) {
                        iD = CodedOutputStream.h(iW, 0.0d);
                        i7 += iD;
                    }
                    break;
                case Type.TLSA /* 52 */:
                    if (I(obj, iW, i6)) {
                        iD = CodedOutputStream.p(iW, 0.0f);
                        i7 += iD;
                    }
                    break;
                case 53:
                    if (I(obj, iW, i6)) {
                        iD = CodedOutputStream.v(iW, c0(obj, jX));
                        i7 += iD;
                    }
                    break;
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (I(obj, iW, i6)) {
                        iD = CodedOutputStream.O(iW, c0(obj, jX));
                        i7 += iD;
                    }
                    break;
                case 55:
                    if (I(obj, iW, i6)) {
                        iD = CodedOutputStream.t(iW, b0(obj, jX));
                        i7 += iD;
                    }
                    break;
                case Type.NINFO /* 56 */:
                    if (I(obj, iW, i6)) {
                        iD = CodedOutputStream.n(iW, 0L);
                        i7 += iD;
                    }
                    break;
                case 57:
                    if (I(obj, iW, i6)) {
                        iB = CodedOutputStream.l(iW, 0);
                        i7 += iB;
                    }
                    break;
                case 58:
                    if (I(obj, iW, i6)) {
                        iD = CodedOutputStream.d(iW, true);
                        i7 += iD;
                    }
                    break;
                case 59:
                    if (I(obj, iW, i6)) {
                        Object object2 = unsafe.getObject(obj, jX);
                        iD = object2 instanceof AbstractC2345g ? CodedOutputStream.f(iW, (AbstractC2345g) object2) : CodedOutputStream.J(iW, (String) object2);
                        i7 += iD;
                    }
                    break;
                case 60:
                    if (I(obj, iW, i6)) {
                        iD = X.o(iW, unsafe.getObject(obj, jX), u(i6));
                        i7 += iD;
                    }
                    break;
                case 61:
                    if (I(obj, iW, i6)) {
                        iD = CodedOutputStream.f(iW, (AbstractC2345g) unsafe.getObject(obj, jX));
                        i7 += iD;
                    }
                    break;
                case 62:
                    if (I(obj, iW, i6)) {
                        iD = CodedOutputStream.M(iW, b0(obj, jX));
                        i7 += iD;
                    }
                    break;
                case 63:
                    if (I(obj, iW, i6)) {
                        iD = CodedOutputStream.j(iW, b0(obj, jX));
                        i7 += iD;
                    }
                    break;
                case 64:
                    if (I(obj, iW, i6)) {
                        iB = CodedOutputStream.B(iW, 0);
                        i7 += iB;
                    }
                    break;
                case 65:
                    if (I(obj, iW, i6)) {
                        iD = CodedOutputStream.D(iW, 0L);
                        i7 += iD;
                    }
                    break;
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (I(obj, iW, i6)) {
                        iD = CodedOutputStream.F(iW, b0(obj, jX));
                        i7 += iD;
                    }
                    break;
                case 67:
                    if (I(obj, iW, i6)) {
                        iD = CodedOutputStream.H(iW, c0(obj, jX));
                        i7 += iD;
                    }
                    break;
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (I(obj, iW, i6)) {
                        iD = CodedOutputStream.r(iW, (I) unsafe.getObject(obj, jX), u(i6));
                        i7 += iD;
                    }
                    break;
            }
            i6 += 3;
            i4 = 1048575;
        }
        int iY = i7 + y(this.o, obj);
        return this.f ? iY + this.p.c(obj).c() : iY;
    }

    private int w0(int i) {
        return this.a[i + 1];
    }

    private int x(Object obj) {
        int iH;
        int i;
        int iL;
        int iN;
        Unsafe unsafe = s;
        int i2 = 0;
        for (int i3 = 0; i3 < this.a.length; i3 += 3) {
            int iW0 = w0(i3);
            int iV0 = v0(iW0);
            int iW = W(i3);
            long jX = X(iW0);
            int i4 = (iV0 < EnumC4752Gk2.F0.a() || iV0 > EnumC4752Gk2.S0.a()) ? 0 : this.a[i3 + 2] & 1048575;
            switch (iV0) {
                case 0:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.h(iW, 0.0d);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.p(iW, 0.0f);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.v(iW, d0.A(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.O(iW, d0.A(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.t(iW, d0.z(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.n(iW, 0L);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.l(iW, 0);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.d(iW, true);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (B(obj, i3)) {
                        Object objC = d0.C(obj, jX);
                        iH = objC instanceof AbstractC2345g ? CodedOutputStream.f(iW, (AbstractC2345g) objC) : CodedOutputStream.J(iW, (String) objC);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (B(obj, i3)) {
                        iH = X.o(iW, d0.C(obj, jX), u(i3));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.f(iW, (AbstractC2345g) d0.C(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.M(iW, d0.z(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.j(iW, d0.z(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.B(iW, 0);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.D(iW, 0L);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.F(iW, d0.z(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.H(iW, d0.A(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (B(obj, i3)) {
                        iH = CodedOutputStream.r(iW, (I) d0.C(obj, jX), u(i3));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iH = X.h(iW, K(obj, jX), false);
                    i2 += iH;
                    break;
                case 19:
                    iH = X.f(iW, K(obj, jX), false);
                    i2 += iH;
                    break;
                case 20:
                    iH = X.m(iW, K(obj, jX), false);
                    i2 += iH;
                    break;
                case 21:
                    iH = X.x(iW, K(obj, jX), false);
                    i2 += iH;
                    break;
                case 22:
                    iH = X.k(iW, K(obj, jX), false);
                    i2 += iH;
                    break;
                case 23:
                    iH = X.h(iW, K(obj, jX), false);
                    i2 += iH;
                    break;
                case 24:
                    iH = X.f(iW, K(obj, jX), false);
                    i2 += iH;
                    break;
                case 25:
                    iH = X.a(iW, K(obj, jX), false);
                    i2 += iH;
                    break;
                case 26:
                    iH = X.u(iW, K(obj, jX));
                    i2 += iH;
                    break;
                case 27:
                    iH = X.p(iW, K(obj, jX), u(i3));
                    i2 += iH;
                    break;
                case 28:
                    iH = X.c(iW, K(obj, jX));
                    i2 += iH;
                    break;
                case 29:
                    iH = X.v(iW, K(obj, jX), false);
                    i2 += iH;
                    break;
                case 30:
                    iH = X.d(iW, K(obj, jX), false);
                    i2 += iH;
                    break;
                case 31:
                    iH = X.f(iW, K(obj, jX), false);
                    i2 += iH;
                    break;
                case 32:
                    iH = X.h(iW, K(obj, jX), false);
                    i2 += iH;
                    break;
                case 33:
                    iH = X.q(iW, K(obj, jX), false);
                    i2 += iH;
                    break;
                case 34:
                    iH = X.s(iW, K(obj, jX), false);
                    i2 += iH;
                    break;
                case 35:
                    i = X.i((List) unsafe.getObject(obj, jX));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i);
                        iH = iL + iN + i;
                        i2 += iH;
                        break;
                    }
                case 36:
                    i = X.g((List) unsafe.getObject(obj, jX));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i);
                        iH = iL + iN + i;
                        i2 += iH;
                        break;
                    }
                case 37:
                    i = X.n((List) unsafe.getObject(obj, jX));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i);
                        iH = iL + iN + i;
                        i2 += iH;
                        break;
                    }
                case 38:
                    i = X.y((List) unsafe.getObject(obj, jX));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i);
                        iH = iL + iN + i;
                        i2 += iH;
                        break;
                    }
                case 39:
                    i = X.l((List) unsafe.getObject(obj, jX));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i);
                        iH = iL + iN + i;
                        i2 += iH;
                        break;
                    }
                case 40:
                    i = X.i((List) unsafe.getObject(obj, jX));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i);
                        iH = iL + iN + i;
                        i2 += iH;
                        break;
                    }
                case 41:
                    i = X.g((List) unsafe.getObject(obj, jX));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i);
                        iH = iL + iN + i;
                        i2 += iH;
                        break;
                    }
                case 42:
                    i = X.b((List) unsafe.getObject(obj, jX));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i);
                        iH = iL + iN + i;
                        i2 += iH;
                        break;
                    }
                case 43:
                    i = X.w((List) unsafe.getObject(obj, jX));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i);
                        iH = iL + iN + i;
                        i2 += iH;
                        break;
                    }
                case 44:
                    i = X.e((List) unsafe.getObject(obj, jX));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i);
                        iH = iL + iN + i;
                        i2 += iH;
                        break;
                    }
                case 45:
                    i = X.g((List) unsafe.getObject(obj, jX));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i);
                        iH = iL + iN + i;
                        i2 += iH;
                        break;
                    }
                case 46:
                    i = X.i((List) unsafe.getObject(obj, jX));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i);
                        iH = iL + iN + i;
                        i2 += iH;
                        break;
                    }
                case 47:
                    i = X.r((List) unsafe.getObject(obj, jX));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i);
                        iH = iL + iN + i;
                        i2 += iH;
                        break;
                    }
                case 48:
                    i = X.t((List) unsafe.getObject(obj, jX));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iL = CodedOutputStream.L(iW);
                        iN = CodedOutputStream.N(i);
                        iH = iL + iN + i;
                        i2 += iH;
                        break;
                    }
                case 49:
                    iH = X.j(iW, K(obj, jX), u(i3));
                    i2 += iH;
                    break;
                case 50:
                    iH = this.q.g(iW, d0.C(obj, jX), t(i3));
                    i2 += iH;
                    break;
                case 51:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.h(iW, 0.0d);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case Type.TLSA /* 52 */:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.p(iW, 0.0f);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.v(iW, c0(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.O(iW, c0(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.t(iW, b0(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case Type.NINFO /* 56 */:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.n(iW, 0L);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.l(iW, 0);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.d(iW, true);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (I(obj, iW, i3)) {
                        Object objC2 = d0.C(obj, jX);
                        iH = objC2 instanceof AbstractC2345g ? CodedOutputStream.f(iW, (AbstractC2345g) objC2) : CodedOutputStream.J(iW, (String) objC2);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (I(obj, iW, i3)) {
                        iH = X.o(iW, d0.C(obj, jX), u(i3));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.f(iW, (AbstractC2345g) d0.C(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.M(iW, b0(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.j(iW, b0(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.B(iW, 0);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.D(iW, 0L);
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.F(iW, b0(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.H(iW, c0(obj, jX));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (I(obj, iW, i3)) {
                        iH = CodedOutputStream.r(iW, (I) d0.C(obj, jX), u(i3));
                        i2 += iH;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i2 + y(this.o, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void x0(java.lang.Object r18, com.google.crypto.tink.shaded.protobuf.g0 r19) {
        /*
            Method dump skipped, instructions count: 1336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.K.x0(java.lang.Object, com.google.crypto.tink.shaded.protobuf.g0):void");
    }

    private int y(a0 a0Var, Object obj) {
        return a0Var.h(a0Var.g(obj));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void y0(java.lang.Object r13, com.google.crypto.tink.shaded.protobuf.g0 r14) {
        /*
            Method dump skipped, instructions count: 1584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.K.y0(java.lang.Object, com.google.crypto.tink.shaded.protobuf.g0):void");
    }

    private static int z(Object obj, long j) {
        return d0.z(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void z0(java.lang.Object r11, com.google.crypto.tink.shaded.protobuf.g0 r12) {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.K.z0(java.lang.Object, com.google.crypto.tink.shaded.protobuf.g0):void");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public void a(Object obj, Object obj2) {
        m(obj);
        obj2.getClass();
        for (int i = 0; i < this.a.length; i += 3) {
            Q(obj, obj2, i);
        }
        X.F(this.o, obj, obj2);
        if (this.f) {
            X.D(this.p, obj, obj2);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public int b(Object obj) {
        int i;
        int iF;
        int length = this.a.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iW0 = w0(i3);
            int iW = W(i3);
            long jX = X(iW0);
            int iHashCode = 37;
            switch (v0(iW0)) {
                case 0:
                    i = i2 * 53;
                    iF = AbstractC2360w.f(Double.doubleToLongBits(d0.x(obj, jX)));
                    i2 = i + iF;
                    break;
                case 1:
                    i = i2 * 53;
                    iF = Float.floatToIntBits(d0.y(obj, jX));
                    i2 = i + iF;
                    break;
                case 2:
                    i = i2 * 53;
                    iF = AbstractC2360w.f(d0.A(obj, jX));
                    i2 = i + iF;
                    break;
                case 3:
                    i = i2 * 53;
                    iF = AbstractC2360w.f(d0.A(obj, jX));
                    i2 = i + iF;
                    break;
                case 4:
                    i = i2 * 53;
                    iF = d0.z(obj, jX);
                    i2 = i + iF;
                    break;
                case 5:
                    i = i2 * 53;
                    iF = AbstractC2360w.f(d0.A(obj, jX));
                    i2 = i + iF;
                    break;
                case 6:
                    i = i2 * 53;
                    iF = d0.z(obj, jX);
                    i2 = i + iF;
                    break;
                case 7:
                    i = i2 * 53;
                    iF = AbstractC2360w.c(d0.r(obj, jX));
                    i2 = i + iF;
                    break;
                case 8:
                    i = i2 * 53;
                    iF = ((String) d0.C(obj, jX)).hashCode();
                    i2 = i + iF;
                    break;
                case 9:
                    Object objC = d0.C(obj, jX);
                    if (objC != null) {
                        iHashCode = objC.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iF = d0.C(obj, jX).hashCode();
                    i2 = i + iF;
                    break;
                case 11:
                    i = i2 * 53;
                    iF = d0.z(obj, jX);
                    i2 = i + iF;
                    break;
                case 12:
                    i = i2 * 53;
                    iF = d0.z(obj, jX);
                    i2 = i + iF;
                    break;
                case 13:
                    i = i2 * 53;
                    iF = d0.z(obj, jX);
                    i2 = i + iF;
                    break;
                case 14:
                    i = i2 * 53;
                    iF = AbstractC2360w.f(d0.A(obj, jX));
                    i2 = i + iF;
                    break;
                case 15:
                    i = i2 * 53;
                    iF = d0.z(obj, jX);
                    i2 = i + iF;
                    break;
                case 16:
                    i = i2 * 53;
                    iF = AbstractC2360w.f(d0.A(obj, jX));
                    i2 = i + iF;
                    break;
                case 17:
                    Object objC2 = d0.C(obj, jX);
                    if (objC2 != null) {
                        iHashCode = objC2.hashCode();
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
                    iF = d0.C(obj, jX).hashCode();
                    i2 = i + iF;
                    break;
                case 50:
                    i = i2 * 53;
                    iF = d0.C(obj, jX).hashCode();
                    i2 = i + iF;
                    break;
                case 51:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = AbstractC2360w.f(Double.doubleToLongBits(Z(obj, jX)));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case Type.TLSA /* 52 */:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = Float.floatToIntBits(a0(obj, jX));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = AbstractC2360w.f(c0(obj, jX));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = AbstractC2360w.f(c0(obj, jX));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = b0(obj, jX);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case Type.NINFO /* 56 */:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = AbstractC2360w.f(c0(obj, jX));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = b0(obj, jX);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = AbstractC2360w.c(Y(obj, jX));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = ((String) d0.C(obj, jX)).hashCode();
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = d0.C(obj, jX).hashCode();
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = d0.C(obj, jX).hashCode();
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = b0(obj, jX);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = b0(obj, jX);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = b0(obj, jX);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = AbstractC2360w.f(c0(obj, jX));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = b0(obj, jX);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = AbstractC2360w.f(c0(obj, jX));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (I(obj, iW, i3)) {
                        i = i2 * 53;
                        iF = d0.C(obj, jX).hashCode();
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

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public boolean c(Object obj, Object obj2) {
        int length = this.a.length;
        for (int i = 0; i < length; i += 3) {
            if (!p(obj, obj2, i)) {
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

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public Object d() {
        return this.m.a(this.e);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    @Override // com.google.crypto.tink.shaded.protobuf.V
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = G(r8)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r8 instanceof com.google.crypto.tink.shaded.protobuf.AbstractC2358u
            if (r0 == 0) goto L17
            r0 = r8
            com.google.crypto.tink.shaded.protobuf.u r0 = (com.google.crypto.tink.shaded.protobuf.AbstractC2358u) r0
            r0.k()
            r0.i()
            r0.C()
        L17:
            int[] r0 = r7.a
            int r0 = r0.length
            r1 = 0
        L1b:
            if (r1 >= r0) goto L5f
            int r2 = r7.w0(r1)
            long r3 = X(r2)
            int r2 = v0(r2)
            r5 = 9
            if (r2 == r5) goto L49
            switch(r2) {
                case 17: goto L49;
                case 18: goto L43;
                case 19: goto L43;
                case 20: goto L43;
                case 21: goto L43;
                case 22: goto L43;
                case 23: goto L43;
                case 24: goto L43;
                case 25: goto L43;
                case 26: goto L43;
                case 27: goto L43;
                case 28: goto L43;
                case 29: goto L43;
                case 30: goto L43;
                case 31: goto L43;
                case 32: goto L43;
                case 33: goto L43;
                case 34: goto L43;
                case 35: goto L43;
                case 36: goto L43;
                case 37: goto L43;
                case 38: goto L43;
                case 39: goto L43;
                case 40: goto L43;
                case 41: goto L43;
                case 42: goto L43;
                case 43: goto L43;
                case 44: goto L43;
                case 45: goto L43;
                case 46: goto L43;
                case 47: goto L43;
                case 48: goto L43;
                case 49: goto L43;
                case 50: goto L31;
                default: goto L30;
            }
        L30:
            goto L5c
        L31:
            sun.misc.Unsafe r2 = com.google.crypto.tink.shaded.protobuf.K.s
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L5c
            com.google.crypto.tink.shaded.protobuf.D r6 = r7.q
            java.lang.Object r5 = r6.f(r5)
            r2.putObject(r8, r3, r5)
            goto L5c
        L43:
            com.google.crypto.tink.shaded.protobuf.y r2 = r7.n
            r2.c(r8, r3)
            goto L5c
        L49:
            boolean r2 = r7.B(r8, r1)
            if (r2 == 0) goto L5c
            com.google.crypto.tink.shaded.protobuf.V r2 = r7.u(r1)
            sun.misc.Unsafe r5 = com.google.crypto.tink.shaded.protobuf.K.s
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.e(r3)
        L5c:
            int r1 = r1 + 3
            goto L1b
        L5f:
            com.google.crypto.tink.shaded.protobuf.a0 r0 = r7.o
            r0.j(r8)
            boolean r0 = r7.f
            if (r0 == 0) goto L6d
            com.google.crypto.tink.shaded.protobuf.o r0 = r7.p
            r0.f(r8)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.K.e(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    @Override // com.google.crypto.tink.shaded.protobuf.V
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(java.lang.Object r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = 0
            r0 = r8
            r1 = r9
            r10 = r1
        Lb:
            int r2 = r6.k
            r3 = 1
            if (r10 >= r2) goto Lb1
            int[] r2 = r6.j
            r11 = r2[r10]
            int r12 = r6.W(r11)
            int r13 = r6.w0(r11)
            int[] r2 = r6.a
            int r4 = r11 + 2
            r2 = r2[r4]
            r4 = r2 & r8
            int r2 = r2 >>> 20
            int r14 = r3 << r2
            if (r4 == r0) goto L37
            if (r4 == r8) goto L33
            sun.misc.Unsafe r0 = com.google.crypto.tink.shaded.protobuf.K.s
            long r1 = (long) r4
            int r1 = r0.getInt(r7, r1)
        L33:
            r16 = r1
            r15 = r4
            goto L3a
        L37:
            r15 = r0
            r16 = r1
        L3a:
            boolean r0 = J(r13)
            if (r0 == 0) goto L50
            r0 = r17
            r1 = r18
            r2 = r11
            r3 = r15
            r4 = r16
            r5 = r14
            boolean r0 = r0.C(r1, r2, r3, r4, r5)
            if (r0 != 0) goto L50
            return r9
        L50:
            int r0 = v0(r13)
            r1 = 9
            if (r0 == r1) goto L90
            r1 = 17
            if (r0 == r1) goto L90
            r1 = 27
            if (r0 == r1) goto L89
            r1 = 60
            if (r0 == r1) goto L78
            r1 = 68
            if (r0 == r1) goto L78
            r1 = 49
            if (r0 == r1) goto L89
            r1 = 50
            if (r0 == r1) goto L71
            goto Laa
        L71:
            boolean r0 = r6.F(r7, r13, r11)
            if (r0 != 0) goto Laa
            return r9
        L78:
            boolean r0 = r6.I(r7, r12, r11)
            if (r0 == 0) goto Laa
            com.google.crypto.tink.shaded.protobuf.V r0 = r6.u(r11)
            boolean r0 = D(r7, r13, r0)
            if (r0 != 0) goto Laa
            return r9
        L89:
            boolean r0 = r6.E(r7, r13, r11)
            if (r0 != 0) goto Laa
            return r9
        L90:
            r0 = r17
            r1 = r18
            r2 = r11
            r3 = r15
            r4 = r16
            r5 = r14
            boolean r0 = r0.C(r1, r2, r3, r4, r5)
            if (r0 == 0) goto Laa
            com.google.crypto.tink.shaded.protobuf.V r0 = r6.u(r11)
            boolean r0 = D(r7, r13, r0)
            if (r0 != 0) goto Laa
            return r9
        Laa:
            int r10 = r10 + 1
            r0 = r15
            r1 = r16
            goto Lb
        Lb1:
            boolean r0 = r6.f
            if (r0 == 0) goto Lc2
            com.google.crypto.tink.shaded.protobuf.o r0 = r6.p
            com.google.crypto.tink.shaded.protobuf.r r0 = r0.c(r7)
            boolean r0 = r0.e()
            if (r0 != 0) goto Lc2
            return r9
        Lc2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.K.f(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02d5, code lost:
    
        if (r0 != r11) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02d7, code lost:
    
        r15 = r27;
        r14 = r28;
        r12 = r29;
        r13 = r31;
        r11 = r32;
        r9 = r33;
        r5 = r17;
        r3 = r19;
        r6 = r20;
        r2 = r21;
        r1 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02f1, code lost:
    
        r2 = r0;
        r8 = r19;
        r0 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x031c, code lost:
    
        if (r0 != r15) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x033e, code lost:
    
        if (r0 != r15) goto L101;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0090. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    int f0(java.lang.Object r28, byte[] r29, int r30, int r31, int r32, com.google.crypto.tink.shaded.protobuf.AbstractC2343e.a r33) {
        /*
            Method dump skipped, instructions count: 1046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.K.f0(java.lang.Object, byte[], int, int, int, com.google.crypto.tink.shaded.protobuf.e$a):int");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public int g(Object obj) {
        return this.h ? x(obj) : w(obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public void h(Object obj, byte[] bArr, int i, int i2, AbstractC2343e.a aVar) throws InvalidProtocolBufferException {
        if (this.h) {
            g0(obj, bArr, i, i2, aVar);
        } else {
            f0(obj, bArr, i, i2, 0, aVar);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public void i(Object obj, U u, C2352n c2352n) {
        c2352n.getClass();
        m(obj);
        M(this.o, this.p, obj, u, c2352n);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public void j(Object obj, g0 g0Var) {
        if (g0Var.t() == g0.a.DESCENDING) {
            z0(obj, g0Var);
        } else if (this.h) {
            y0(obj, g0Var);
        } else {
            x0(obj, g0Var);
        }
    }
}
