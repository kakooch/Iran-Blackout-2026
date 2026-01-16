package com.google.android.gms.internal.clearcut;

import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import com.google.android.gms.internal.clearcut.AbstractC2101z;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.EnumC14348hl8;
import ir.nasim.InterfaceC20302rm8;
import ir.nasim.InterfaceC23346wl8;
import ir.nasim.InterfaceC25120zl8;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
final class V implements InterfaceC2082f0 {
    private static final Unsafe s = o0.z();
    private final int[] a;
    private final Object[] b;
    private final int c;
    private final int d;
    private final int e;
    private final InterfaceC20302rm8 f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int[] k;
    private final int[] l;
    private final int[] m;
    private final X n;
    private final D o;
    private final l0 p;
    private final AbstractC2095t q;
    private final O r;

    private V(int[] iArr, Object[] objArr, int i, int i2, int i3, InterfaceC20302rm8 interfaceC20302rm8, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, X x, D d, l0 l0Var, AbstractC2095t abstractC2095t, O o) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.h = interfaceC20302rm8 instanceof AbstractC2101z;
        this.i = z;
        this.g = abstractC2095t != null && abstractC2095t.g(interfaceC20302rm8);
        this.j = false;
        this.k = iArr2;
        this.l = iArr3;
        this.m = iArr4;
        this.n = x;
        this.o = d;
        this.p = l0Var;
        this.q = abstractC2095t;
        this.f = interfaceC20302rm8;
        this.r = o;
    }

    private final boolean A(Object obj, int i, int i2, int i3) {
        return this.i ? y(obj, i) : (i2 & i3) != 0;
    }

    private static boolean B(Object obj, int i, InterfaceC2082f0 interfaceC2082f0) {
        return interfaceC2082f0.f(o0.M(obj, i & 1048575));
    }

    private final InterfaceC2082f0 C(int i) {
        int i2 = (i / 4) << 1;
        InterfaceC2082f0 interfaceC2082f0 = (InterfaceC2082f0) this.b[i2];
        if (interfaceC2082f0 != null) {
            return interfaceC2082f0;
        }
        InterfaceC2082f0 interfaceC2082f0B = C2072a0.a().b((Class) this.b[i2 + 1]);
        this.b[i2] = interfaceC2082f0B;
        return interfaceC2082f0B;
    }

    private final Object D(int i) {
        return this.b[(i / 4) << 1];
    }

    private final InterfaceC23346wl8 E(int i) {
        return (InterfaceC23346wl8) this.b[((i / 4) << 1) + 1];
    }

    private final int F(int i) {
        return this.a[i + 1];
    }

    private final int G(int i) {
        return this.a[i + 2];
    }

    private final int H(int i) {
        int i2 = this.c;
        if (i >= i2) {
            int i3 = this.e;
            if (i < i3) {
                int i4 = (i - i2) << 2;
                if (this.a[i4] == i) {
                    return i4;
                }
                return -1;
            }
            if (i <= this.d) {
                int i5 = i3 - i2;
                int length = (this.a.length / 4) - 1;
                while (i5 <= length) {
                    int i6 = (length + i5) >>> 1;
                    int i7 = i6 << 2;
                    int i8 = this.a[i7];
                    if (i == i8) {
                        return i7;
                    }
                    if (i < i8) {
                        length = i6 - 1;
                    } else {
                        i5 = i6 + 1;
                    }
                }
            }
        }
        return -1;
    }

    private final void I(Object obj, int i) {
        if (this.i) {
            return;
        }
        int iG = G(i);
        long j = iG & 1048575;
        o0.g(obj, j, o0.H(obj, j) | (1 << (iG >>> 20)));
    }

    private final void J(Object obj, int i, int i2) {
        o0.g(obj, G(i2) & 1048575, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void K(java.lang.Object r18, com.google.android.gms.internal.clearcut.v0 r19) {
        /*
            Method dump skipped, instructions count: 1332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.V.K(java.lang.Object, com.google.android.gms.internal.clearcut.v0):void");
    }

    private final void L(Object obj, Object obj2, int i) {
        int iF = F(i);
        int i2 = this.a[i];
        long j = iF & 1048575;
        if (z(obj2, i2, i)) {
            Object objM = o0.M(obj, j);
            Object objM2 = o0.M(obj2, j);
            if (objM != null && objM2 != null) {
                o0.i(obj, j, B.d(objM, objM2));
                J(obj, i2, i);
            } else if (objM2 != null) {
                o0.i(obj, j, objM2);
                J(obj, i2, i);
            }
        }
    }

    private final boolean M(Object obj, Object obj2, int i) {
        return y(obj, i) == y(obj2, i);
    }

    private static List N(Object obj, long j) {
        return (List) o0.M(obj, j);
    }

    private static double O(Object obj, long j) {
        return ((Double) o0.M(obj, j)).doubleValue();
    }

    private static float P(Object obj, long j) {
        return ((Float) o0.M(obj, j)).floatValue();
    }

    private static int Q(Object obj, long j) {
        return ((Integer) o0.M(obj, j)).intValue();
    }

    private static long R(Object obj, long j) {
        return ((Long) o0.M(obj, j)).longValue();
    }

    private static boolean S(Object obj, long j) {
        return ((Boolean) o0.M(obj, j)).booleanValue();
    }

    private static m0 T(Object obj) {
        AbstractC2101z abstractC2101z = (AbstractC2101z) obj;
        m0 m0Var = abstractC2101z.zzjp;
        if (m0Var != m0.h()) {
            return m0Var;
        }
        m0 m0VarI = m0.i();
        abstractC2101z.zzjp = m0VarI;
        return m0VarI;
    }

    private static int j(int i, byte[] bArr, int i2, int i3, Object obj, C2079e c2079e) {
        return AbstractC2077d.b(i, bArr, i2, i3, T(obj), c2079e);
    }

    private static int k(InterfaceC2082f0 interfaceC2082f0, int i, byte[] bArr, int i2, int i3, InterfaceC25120zl8 interfaceC25120zl8, C2079e c2079e) throws zzco {
        int iM = m(interfaceC2082f0, bArr, i2, i3, c2079e);
        while (true) {
            interfaceC25120zl8.add(c2079e.c);
            if (iM >= i3) {
                break;
            }
            int iE = AbstractC2077d.e(bArr, iM, c2079e);
            if (i != c2079e.a) {
                break;
            }
            iM = m(interfaceC2082f0, bArr, iE, i3, c2079e);
        }
        return iM;
    }

    private static int l(InterfaceC2082f0 interfaceC2082f0, byte[] bArr, int i, int i2, int i3, C2079e c2079e) throws zzco {
        V v = (V) interfaceC2082f0;
        Object objD = v.d();
        int iR = v.r(objD, bArr, i, i2, i3, c2079e);
        v.a(objD);
        c2079e.c = objD;
        return iR;
    }

    private static int m(InterfaceC2082f0 interfaceC2082f0, byte[] bArr, int i, int i2, C2079e c2079e) throws zzco {
        int iD = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iD = AbstractC2077d.d(i3, bArr, iD, c2079e);
            i3 = c2079e.a;
        }
        int i4 = iD;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzco.a();
        }
        Object objD = interfaceC2082f0.d();
        int i5 = i3 + i4;
        interfaceC2082f0.i(objD, bArr, i4, i5, c2079e);
        interfaceC2082f0.a(objD);
        c2079e.c = objD;
        return i5;
    }

    private static int n(l0 l0Var, Object obj) {
        return l0Var.j(l0Var.k(obj));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int o(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, C2079e c2079e) throws zzco {
        Object objValueOf;
        Object objValueOf2;
        int iG;
        long jA;
        int iE;
        Object objValueOf3;
        int i9;
        Unsafe unsafe = s;
        long j2 = this.a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    objValueOf = Double.valueOf(AbstractC2077d.l(bArr, i));
                    unsafe.putObject(obj, j, objValueOf);
                    iG = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                return i;
            case Type.TLSA /* 52 */:
                if (i5 == 5) {
                    objValueOf2 = Float.valueOf(AbstractC2077d.n(bArr, i));
                    unsafe.putObject(obj, j, objValueOf2);
                    iG = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                return i;
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                if (i5 == 0) {
                    iG = AbstractC2077d.g(bArr, i, c2079e);
                    jA = c2079e.b;
                    objValueOf3 = Long.valueOf(jA);
                    unsafe.putObject(obj, j, objValueOf3);
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    iG = AbstractC2077d.e(bArr, i, c2079e);
                    iE = c2079e.a;
                    objValueOf3 = Integer.valueOf(iE);
                    unsafe.putObject(obj, j, objValueOf3);
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                return i;
            case Type.NINFO /* 56 */:
            case 65:
                if (i5 == 1) {
                    objValueOf = Long.valueOf(AbstractC2077d.k(bArr, i));
                    unsafe.putObject(obj, j, objValueOf);
                    iG = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    objValueOf2 = Integer.valueOf(AbstractC2077d.h(bArr, i));
                    unsafe.putObject(obj, j, objValueOf2);
                    iG = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    iG = AbstractC2077d.g(bArr, i, c2079e);
                    objValueOf3 = Boolean.valueOf(c2079e.b != 0);
                    unsafe.putObject(obj, j, objValueOf3);
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    iG = AbstractC2077d.e(bArr, i, c2079e);
                    i9 = c2079e.a;
                    if (i9 == 0) {
                        objValueOf3 = "";
                        unsafe.putObject(obj, j, objValueOf3);
                        unsafe.putInt(obj, j2, i4);
                        return iG;
                    }
                    if ((i6 & 536870912) != 0 && !q0.i(bArr, iG, iG + i9)) {
                        throw zzco.e();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iG, i9, B.a));
                    iG += i9;
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    iG = m(C(i8), bArr, i, i2, c2079e);
                    Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                    objValueOf3 = c2079e.c;
                    if (object != null) {
                        objValueOf3 = B.d(object, objValueOf3);
                    }
                    unsafe.putObject(obj, j, objValueOf3);
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    iG = AbstractC2077d.e(bArr, i, c2079e);
                    i9 = c2079e.a;
                    if (i9 == 0) {
                        objValueOf3 = AbstractC2081f.b;
                        unsafe.putObject(obj, j, objValueOf3);
                        unsafe.putInt(obj, j2, i4);
                        return iG;
                    }
                    unsafe.putObject(obj, j, AbstractC2081f.F(bArr, iG, i9));
                    iG += i9;
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int iE2 = AbstractC2077d.e(bArr, i, c2079e);
                    int i10 = c2079e.a;
                    InterfaceC23346wl8 interfaceC23346wl8E = E(i8);
                    if (interfaceC23346wl8E != null && interfaceC23346wl8E.l(i10) == null) {
                        T(obj).e(i3, Long.valueOf(i10));
                        return iE2;
                    }
                    unsafe.putObject(obj, j, Integer.valueOf(i10));
                    iG = iE2;
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                return i;
            case WKSRecord.Protocol.RVD /* 66 */:
                if (i5 == 0) {
                    iG = AbstractC2077d.e(bArr, i, c2079e);
                    iE = AbstractC2091o.e(c2079e.a);
                    objValueOf3 = Integer.valueOf(iE);
                    unsafe.putObject(obj, j, objValueOf3);
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    iG = AbstractC2077d.g(bArr, i, c2079e);
                    jA = AbstractC2091o.a(c2079e.b);
                    objValueOf3 = Long.valueOf(jA);
                    unsafe.putObject(obj, j, objValueOf3);
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                return i;
            case WKSRecord.Service.BOOTPC /* 68 */:
                if (i5 == 3) {
                    iG = l(C(i8), bArr, i, i2, (i3 & (-8)) | 4, c2079e);
                    Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                    objValueOf3 = c2079e.c;
                    if (object2 != null) {
                        objValueOf3 = B.d(object2, objValueOf3);
                    }
                    unsafe.putObject(obj, j, objValueOf3);
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                return i;
            default:
                return i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:190:0x012a, code lost:
    
        r12.add(com.google.android.gms.internal.clearcut.AbstractC2081f.F(r17, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x011a, code lost:
    
        if (r4 == 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x011c, code lost:
    
        r12.add(com.google.android.gms.internal.clearcut.AbstractC2081f.b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0122, code lost:
    
        r12.add(com.google.android.gms.internal.clearcut.AbstractC2081f.F(r17, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x012a, code lost:
    
        if (r1 >= r19) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012c, code lost:
    
        r4 = com.google.android.gms.internal.clearcut.AbstractC2077d.e(r17, r1, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0132, code lost:
    
        if (r20 != r29.a) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0134, code lost:
    
        r1 = com.google.android.gms.internal.clearcut.AbstractC2077d.e(r17, r4, r29);
        r4 = r29.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x013a, code lost:
    
        if (r4 != 0) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x013a -> B:62:0x011c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x018d -> B:77:0x016e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x01c7 -> B:89:0x01a0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int p(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.clearcut.C2079e r29) throws com.google.android.gms.internal.clearcut.zzco {
        /*
            Method dump skipped, instructions count: 806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.V.p(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.clearcut.e):int");
    }

    private final int q(Object obj, byte[] bArr, int i, int i2, int i3, int i4, long j, C2079e c2079e) throws zzco {
        Unsafe unsafe = s;
        Object objD = D(i3);
        Object object = unsafe.getObject(obj, j);
        if (this.r.h(object)) {
            Object objA = this.r.a(objD);
            this.r.d(objA, object);
            unsafe.putObject(obj, j, objA);
            object = objA;
        }
        this.r.f(objD);
        this.r.j(object);
        int iE = AbstractC2077d.e(bArr, i, c2079e);
        int i5 = c2079e.a;
        if (i5 < 0 || i5 > i2 - iE) {
            throw zzco.a();
        }
        throw null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0069. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0376 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int r(java.lang.Object r27, byte[] r28, int r29, int r30, int r31, com.google.android.gms.internal.clearcut.C2079e r32) throws com.google.android.gms.internal.clearcut.zzco {
        /*
            Method dump skipped, instructions count: 1074
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.V.r(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.clearcut.e):int");
    }

    static V s(Class cls, S s2, X x, D d, l0 l0Var, AbstractC2095t abstractC2095t, O o) {
        int iK;
        int i;
        int i2;
        int iB;
        int iB2;
        int iQ;
        if (!(s2 instanceof C2076c0)) {
            AbstractC18350oW3.a(s2);
            throw null;
        }
        C2076c0 c2076c0 = (C2076c0) s2;
        boolean z = c2076c0.a() == AbstractC2101z.c.j;
        if (c2076c0.d() == 0) {
            iK = 0;
            i = 0;
            i2 = 0;
        } else {
            int iF = c2076c0.f();
            int iG = c2076c0.g();
            iK = c2076c0.k();
            i = iF;
            i2 = iG;
        }
        int[] iArr = new int[iK << 2];
        Object[] objArr = new Object[iK << 1];
        int[] iArr2 = c2076c0.h() > 0 ? new int[c2076c0.h()] : null;
        int[] iArr3 = c2076c0.i() > 0 ? new int[c2076c0.i()] : null;
        C2078d0 c2078d0E = c2076c0.e();
        if (c2078d0E.a()) {
            int iG2 = c2078d0E.g();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (iG2 >= c2076c0.l() || i3 >= ((iG2 - i) << 2)) {
                    if (c2078d0E.k()) {
                        iB = (int) o0.b(c2078d0E.l());
                        iB2 = (int) o0.b(c2078d0E.m());
                        iQ = 0;
                    } else {
                        iB = (int) o0.b(c2078d0E.n());
                        if (c2078d0E.o()) {
                            iB2 = (int) o0.b(c2078d0E.p());
                            iQ = c2078d0E.q();
                        } else {
                            iB2 = 0;
                            iQ = 0;
                        }
                    }
                    iArr[i3] = c2078d0E.g();
                    int i6 = i3 + 1;
                    iArr[i6] = (c2078d0E.s() ? 536870912 : 0) | (c2078d0E.r() ? 268435456 : 0) | (c2078d0E.h() << 20) | iB;
                    iArr[i3 + 2] = iB2 | (iQ << 20);
                    if (c2078d0E.v() != null) {
                        int i7 = (i3 / 4) << 1;
                        objArr[i7] = c2078d0E.v();
                        if (c2078d0E.t() != null) {
                            objArr[i7 + 1] = c2078d0E.t();
                        } else if (c2078d0E.u() != null) {
                            objArr[i7 + 1] = c2078d0E.u();
                        }
                    } else if (c2078d0E.t() != null) {
                        objArr[((i3 / 4) << 1) + 1] = c2078d0E.t();
                    } else if (c2078d0E.u() != null) {
                        objArr[((i3 / 4) << 1) + 1] = c2078d0E.u();
                    }
                    int iH = c2078d0E.h();
                    if (iH == EnumC14348hl8.U0.ordinal()) {
                        iArr2[i4] = i3;
                        i4++;
                    } else if (iH >= 18 && iH <= 49) {
                        iArr3[i5] = iArr[i6] & 1048575;
                        i5++;
                    }
                    if (!c2078d0E.a()) {
                        break;
                    }
                    iG2 = c2078d0E.g();
                } else {
                    for (int i8 = 0; i8 < 4; i8++) {
                        iArr[i3 + i8] = -1;
                    }
                }
                i3 += 4;
            }
        }
        return new V(iArr, objArr, i, i2, c2076c0.l(), c2076c0.c(), z, false, c2076c0.j(), iArr2, iArr3, x, d, l0Var, abstractC2095t, o);
    }

    private final Object t(int i, int i2, Map map, InterfaceC23346wl8 interfaceC23346wl8, Object obj, l0 l0Var) {
        this.r.f(D(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (interfaceC23346wl8.l(((Integer) entry.getValue()).intValue()) == null) {
                if (obj == null) {
                    obj = l0Var.f();
                }
                C2087k c2087kO = AbstractC2081f.O(L.a(null, entry.getKey(), entry.getValue()));
                try {
                    L.b(c2087kO.b(), null, entry.getKey(), entry.getValue());
                    l0Var.b(obj, i2, c2087kO.a());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    private static void u(int i, Object obj, v0 v0Var) {
        if (obj instanceof String) {
            v0Var.z(i, (String) obj);
        } else {
            v0Var.H(i, (AbstractC2081f) obj);
        }
    }

    private static void v(l0 l0Var, Object obj, v0 v0Var) {
        l0Var.c(l0Var.k(obj), v0Var);
    }

    private final void w(v0 v0Var, int i, Object obj, int i2) {
        if (obj != null) {
            this.r.f(D(i2));
            v0Var.P(i, null, this.r.i(obj));
        }
    }

    private final void x(Object obj, Object obj2, int i) {
        long jF = F(i) & 1048575;
        if (y(obj2, i)) {
            Object objM = o0.M(obj, jF);
            Object objM2 = o0.M(obj2, jF);
            if (objM != null && objM2 != null) {
                o0.i(obj, jF, B.d(objM, objM2));
                I(obj, i);
            } else if (objM2 != null) {
                o0.i(obj, jF, objM2);
                I(obj, i);
            }
        }
    }

    private final boolean y(Object obj, int i) {
        if (!this.i) {
            int iG = G(i);
            return (o0.H(obj, (long) (iG & 1048575)) & (1 << (iG >>> 20))) != 0;
        }
        int iF = F(i);
        long j = iF & 1048575;
        switch ((iF & 267386880) >>> 20) {
            case 0:
                return o0.L(obj, j) != 0.0d;
            case 1:
                return o0.K(obj, j) != 0.0f;
            case 2:
                return o0.I(obj, j) != 0;
            case 3:
                return o0.I(obj, j) != 0;
            case 4:
                return o0.H(obj, j) != 0;
            case 5:
                return o0.I(obj, j) != 0;
            case 6:
                return o0.H(obj, j) != 0;
            case 7:
                return o0.J(obj, j);
            case 8:
                Object objM = o0.M(obj, j);
                if (objM instanceof String) {
                    return !((String) objM).isEmpty();
                }
                if (objM instanceof AbstractC2081f) {
                    return !AbstractC2081f.b.equals(objM);
                }
                throw new IllegalArgumentException();
            case 9:
                return o0.M(obj, j) != null;
            case 10:
                return !AbstractC2081f.b.equals(o0.M(obj, j));
            case 11:
                return o0.H(obj, j) != 0;
            case 12:
                return o0.H(obj, j) != 0;
            case 13:
                return o0.H(obj, j) != 0;
            case 14:
                return o0.I(obj, j) != 0;
            case 15:
                return o0.H(obj, j) != 0;
            case 16:
                return o0.I(obj, j) != 0;
            case 17:
                return o0.M(obj, j) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean z(Object obj, int i, int i2) {
        return o0.H(obj, (long) (G(i2) & 1048575)) == i;
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    public final void a(Object obj) {
        int[] iArr = this.l;
        if (iArr != null) {
            for (int i : iArr) {
                long jF = F(i) & 1048575;
                Object objM = o0.M(obj, jF);
                if (objM != null) {
                    o0.i(obj, jF, this.r.g(objM));
                }
            }
        }
        int[] iArr2 = this.m;
        if (iArr2 != null) {
            for (int i2 : iArr2) {
                this.o.a(obj, i2);
            }
        }
        this.p.d(obj);
        if (this.g) {
            this.q.f(obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f4 A[PHI: r3
      0x00f4: PHI (r3v9 java.lang.Object) = (r3v6 java.lang.Object), (r3v10 java.lang.Object) binds: [B:74:0x0110, B:68:0x00f2] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.V.b(java.lang.Object):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(java.lang.Object r10, java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.V.c(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    public final Object d() {
        return this.n.a(this.f);
    }

    /* JADX WARN: Removed duplicated region for block: B:192:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.Object r14, com.google.android.gms.internal.clearcut.v0 r15) {
        /*
            Method dump skipped, instructions count: 2752
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.V.e(java.lang.Object, com.google.android.gms.internal.clearcut.v0):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.V.f(java.lang.Object):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(java.lang.Object r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.V.g(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x041f, code lost:
    
        if (z(r20, r15, r4) != false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0421, code lost:
    
        r6 = com.google.android.gms.internal.clearcut.zzbn.M(r15, (ir.nasim.InterfaceC20302rm8) r2.getObject(r20, r10), C(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x045a, code lost:
    
        if (z(r20, r15, r4) != false) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x045c, code lost:
    
        r6 = com.google.android.gms.internal.clearcut.zzbn.i0(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0467, code lost:
    
        if (z(r20, r15, r4) != false) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0469, code lost:
    
        r9 = com.google.android.gms.internal.clearcut.zzbn.p0(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0492, code lost:
    
        if (z(r20, r15, r4) != false) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0494, code lost:
    
        r6 = r2.getObject(r20, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x04a3, code lost:
    
        if (z(r20, r15, r4) != false) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x04a5, code lost:
    
        r6 = com.google.android.gms.internal.clearcut.h0.n(r15, r2.getObject(r20, r10), C(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x04ce, code lost:
    
        if (z(r20, r15, r4) != false) goto L291;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x04d0, code lost:
    
        r6 = com.google.android.gms.internal.clearcut.zzbn.N(r15, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0715, code lost:
    
        if ((r12 & r18) != 0) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x072f, code lost:
    
        if ((r12 & r18) != 0) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x0735, code lost:
    
        if ((r12 & r18) != 0) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x074f, code lost:
    
        if ((r12 & r18) != 0) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x0755, code lost:
    
        if ((r12 & r18) != 0) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x0769, code lost:
    
        if ((r12 & r18) != 0) goto L291;
     */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0430 A[PHI: r5
      0x0430: PHI (r5v4 int) = 
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v14 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v15 int)
      (r5v1 int)
     binds: [B:245:0x0417, B:437:0x076f, B:434:0x0769, B:429:0x075b, B:426:0x0755, B:423:0x074f, B:420:0x0745, B:417:0x073b, B:414:0x0735, B:411:0x072f, B:408:0x0725, B:405:0x071b, B:402:0x0715, B:382:0x0657, B:377:0x0645, B:372:0x0633, B:367:0x0621, B:362:0x060f, B:357:0x05fd, B:352:0x05eb, B:347:0x05da, B:342:0x05c9, B:337:0x05b8, B:332:0x05a7, B:327:0x0596, B:322:0x0585, B:316:0x0565, B:311:0x0531, B:308:0x0524, B:305:0x0514, B:302:0x0504, B:299:0x04f4, B:296:0x04e6, B:293:0x04da, B:290:0x04ce, B:284:0x04b7, B:281:0x04a3, B:277:0x0492, B:273:0x0483, B:269:0x0474, B:267:0x046e, B:265:0x0467, B:262:0x045a, B:258:0x044b, B:254:0x043c, B:250:0x042f, B:248:0x041f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0498 A[PHI: r6
      0x0498: PHI (r6v150 java.lang.Object) = (r6v16 java.lang.Object), (r6v146 java.lang.Object), (r6v153 java.lang.Object) binds: [B:431:0x0763, B:286:0x04bf, B:278:0x0494] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x04c2 A[PHI: r6
      0x04c2: PHI (r6v142 java.lang.Object) = (r6v16 java.lang.Object), (r6v146 java.lang.Object) binds: [B:431:0x0763, B:286:0x04bf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x056b A[PHI: r6
      0x056b: PHI (r6v116 int) = 
      (r6v78 int)
      (r6v81 int)
      (r6v84 int)
      (r6v87 int)
      (r6v90 int)
      (r6v93 int)
      (r6v96 int)
      (r6v99 int)
      (r6v102 int)
      (r6v105 int)
      (r6v108 int)
      (r6v111 int)
      (r6v114 int)
      (r6v119 int)
     binds: [B:384:0x065b, B:379:0x0649, B:374:0x0637, B:369:0x0625, B:364:0x0613, B:359:0x0601, B:354:0x05ef, B:349:0x05de, B:344:0x05cd, B:339:0x05bc, B:334:0x05ab, B:329:0x059a, B:324:0x0589, B:318:0x0569] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ba A[PHI: r4
      0x00ba: PHI (r4v94 java.lang.Object) = (r4v12 java.lang.Object), (r4v92 java.lang.Object), (r4v96 java.lang.Object) binds: [B:197:0x0365, B:51:0x00e0, B:43:0x00b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e3 A[PHI: r4
      0x00e3: PHI (r4v90 java.lang.Object) = (r4v12 java.lang.Object), (r4v92 java.lang.Object) binds: [B:197:0x0365, B:51:0x00e0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0187 A[PHI: r4
      0x0187: PHI (r4v72 int) = 
      (r4v34 int)
      (r4v37 int)
      (r4v40 int)
      (r4v43 int)
      (r4v46 int)
      (r4v49 int)
      (r4v52 int)
      (r4v55 int)
      (r4v58 int)
      (r4v61 int)
      (r4v64 int)
      (r4v67 int)
      (r4v70 int)
      (r4v75 int)
     binds: [B:152:0x0277, B:147:0x0265, B:142:0x0253, B:137:0x0241, B:132:0x022f, B:127:0x021d, B:122:0x020b, B:117:0x01fa, B:112:0x01e9, B:107:0x01d8, B:102:0x01c7, B:97:0x01b6, B:92:0x01a5, B:86:0x0185] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 2320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.V.h(java.lang.Object):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0163, code lost:
    
        if (r0 == r15) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0165, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0196, code lost:
    
        if (r0 == r15) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01af, code lost:
    
        if (r0 == r15) goto L74;
     */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(java.lang.Object r23, byte[] r24, int r25, int r26, com.google.android.gms.internal.clearcut.C2079e r27) throws com.google.android.gms.internal.clearcut.zzco {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.V.i(java.lang.Object, byte[], int, int, com.google.android.gms.internal.clearcut.e):void");
    }
}
