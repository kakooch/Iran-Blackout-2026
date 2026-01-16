package com.google.android.gms.internal.vision;

import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.EnumC21620tq8;
import ir.nasim.InterfaceC18561or8;
import ir.nasim.Oq8;
import ir.nasim.Tq8;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
final class F0 implements P0 {
    private static final int[] r = new int[0];
    private static final Unsafe s = i1.t();
    private final int[] a;
    private final Object[] b;
    private final int c;
    private final int d;
    private final InterfaceC18561or8 e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final int[] j;
    private final int k;
    private final int l;
    private final I0 m;
    private final AbstractC2190p0 n;
    private final f1 o;
    private final AbstractC2166d0 p;
    private final B0 q;

    private F0(int[] iArr, Object[] objArr, int i, int i2, InterfaceC18561or8 interfaceC18561or8, boolean z, boolean z2, int[] iArr2, int i3, int i4, I0 i0, AbstractC2190p0 abstractC2190p0, f1 f1Var, AbstractC2166d0 abstractC2166d0, B0 b0) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.g = interfaceC18561or8 instanceof AbstractC2178j0;
        this.h = z;
        this.f = abstractC2166d0 != null && abstractC2166d0.d(interfaceC18561or8);
        this.i = false;
        this.j = iArr2;
        this.k = i3;
        this.l = i4;
        this.m = i0;
        this.n = abstractC2190p0;
        this.o = f1Var;
        this.p = abstractC2166d0;
        this.e = interfaceC18561or8;
        this.q = b0;
    }

    private final boolean A(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? y(obj, i) : (i3 & i4) != 0;
    }

    private static boolean B(Object obj, int i, P0 p0) {
        return p0.b(i1.F(obj, i & 1048575));
    }

    private static double C(Object obj, long j) {
        return ((Double) i1.F(obj, j)).doubleValue();
    }

    private final int D(int i, int i2) {
        int length = (this.a.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.a[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final Object E(int i) {
        return this.b[(i / 3) << 1];
    }

    private final void F(Object obj, int i) {
        int iO = O(i);
        long j = 1048575 & iO;
        if (j == 1048575) {
            return;
        }
        i1.h(obj, j, (1 << (iO >>> 20)) | i1.b(obj, j));
    }

    private final void G(Object obj, int i, int i2) {
        i1.h(obj, O(i2) & 1048575, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void H(java.lang.Object r18, com.google.android.gms.internal.vision.q1 r19) {
        /*
            Method dump skipped, instructions count: 1334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.F0.H(java.lang.Object, com.google.android.gms.internal.vision.q1):void");
    }

    private final void I(Object obj, Object obj2, int i) {
        int iM = M(i);
        int i2 = this.a[i];
        long j = iM & 1048575;
        if (z(obj2, i2, i)) {
            Object objF = z(obj, i2, i) ? i1.F(obj, j) : null;
            Object objF2 = i1.F(obj2, j);
            if (objF != null && objF2 != null) {
                i1.j(obj, j, AbstractC2184m0.e(objF, objF2));
                G(obj, i2, i);
            } else if (objF2 != null) {
                i1.j(obj, j, objF2);
                G(obj, i2, i);
            }
        }
    }

    private static float J(Object obj, long j) {
        return ((Float) i1.F(obj, j)).floatValue();
    }

    private final Oq8 K(int i) {
        return (Oq8) this.b[((i / 3) << 1) + 1];
    }

    private final boolean L(Object obj, Object obj2, int i) {
        return y(obj, i) == y(obj2, i);
    }

    private final int M(int i) {
        return this.a[i + 1];
    }

    private static int N(Object obj, long j) {
        return ((Integer) i1.F(obj, j)).intValue();
    }

    private final int O(int i) {
        return this.a[i + 2];
    }

    private static long P(Object obj, long j) {
        return ((Long) i1.F(obj, j)).longValue();
    }

    private static h1 Q(Object obj) {
        AbstractC2178j0 abstractC2178j0 = (AbstractC2178j0) obj;
        h1 h1Var = abstractC2178j0.zzb;
        if (h1Var != h1.a()) {
            return h1Var;
        }
        h1 h1VarG = h1.g();
        abstractC2178j0.zzb = h1VarG;
        return h1VarG;
    }

    private static boolean R(Object obj, long j) {
        return ((Boolean) i1.F(obj, j)).booleanValue();
    }

    private final int S(int i) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return D(i, 0);
    }

    private final int g(int i, int i2) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return D(i, i2);
    }

    private static int j(f1 f1Var, Object obj) {
        return f1Var.l(f1Var.f(obj));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int k(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, H h) throws zzjk {
        int iJ;
        Unsafe unsafe = s;
        long j2 = this.a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Double.valueOf(G.l(bArr, i)));
                    iJ = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return iJ;
                }
                return i;
            case Type.TLSA /* 52 */:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Float.valueOf(G.n(bArr, i)));
                    iJ = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return iJ;
                }
                return i;
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                if (i5 == 0) {
                    iJ = G.j(bArr, i, h);
                    unsafe.putObject(obj, j, Long.valueOf(h.b));
                    unsafe.putInt(obj, j2, i4);
                    return iJ;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    iJ = G.h(bArr, i, h);
                    unsafe.putObject(obj, j, Integer.valueOf(h.a));
                    unsafe.putInt(obj, j2, i4);
                    return iJ;
                }
                return i;
            case Type.NINFO /* 56 */:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Long.valueOf(G.k(bArr, i)));
                    iJ = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return iJ;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Integer.valueOf(G.g(bArr, i)));
                    iJ = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return iJ;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    iJ = G.j(bArr, i, h);
                    unsafe.putObject(obj, j, Boolean.valueOf(h.b != 0));
                    unsafe.putInt(obj, j2, i4);
                    return iJ;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int iH = G.h(bArr, i, h);
                    int i9 = h.a;
                    if (i9 == 0) {
                        unsafe.putObject(obj, j, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !k1.g(bArr, iH, iH + i9)) {
                            throw zzjk.f();
                        }
                        unsafe.putObject(obj, j, new String(bArr, iH, i9, AbstractC2184m0.a));
                        iH += i9;
                    }
                    unsafe.putInt(obj, j2, i4);
                    return iH;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int iF = G.f(p(i8), bArr, i, i2, h);
                    Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                    if (object == null) {
                        unsafe.putObject(obj, j, h.c);
                    } else {
                        unsafe.putObject(obj, j, AbstractC2184m0.e(object, h.c));
                    }
                    unsafe.putInt(obj, j2, i4);
                    return iF;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    iJ = G.p(bArr, i, h);
                    unsafe.putObject(obj, j, h.c);
                    unsafe.putInt(obj, j2, i4);
                    return iJ;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int iH2 = G.h(bArr, i, h);
                    int i10 = h.a;
                    Oq8 oq8K = K(i8);
                    if (oq8K != null && !oq8K.zza(i10)) {
                        Q(obj).c(i3, Long.valueOf(i10));
                        return iH2;
                    }
                    unsafe.putObject(obj, j, Integer.valueOf(i10));
                    iJ = iH2;
                    unsafe.putInt(obj, j2, i4);
                    return iJ;
                }
                return i;
            case WKSRecord.Protocol.RVD /* 66 */:
                if (i5 == 0) {
                    iJ = G.h(bArr, i, h);
                    unsafe.putObject(obj, j, Integer.valueOf(W.d(h.a)));
                    unsafe.putInt(obj, j2, i4);
                    return iJ;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    iJ = G.j(bArr, i, h);
                    unsafe.putObject(obj, j, Long.valueOf(W.a(h.b)));
                    unsafe.putInt(obj, j2, i4);
                    return iJ;
                }
                return i;
            case WKSRecord.Service.BOOTPC /* 68 */:
                if (i5 == 3) {
                    iJ = G.e(p(i8), bArr, i, i2, (i3 & (-8)) | 4, h);
                    Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj, j, h.c);
                    } else {
                        unsafe.putObject(obj, j, AbstractC2184m0.e(object2, h.c));
                    }
                    unsafe.putInt(obj, j2, i4);
                    return iJ;
                }
                return i;
            default:
                return i;
        }
    }

    private final int l(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, H h) throws zzjk {
        int iB;
        int iH = i;
        Unsafe unsafe = s;
        Tq8 tq8Zza = (Tq8) unsafe.getObject(obj, j2);
        if (!tq8Zza.zza()) {
            int size = tq8Zza.size();
            tq8Zza = tq8Zza.zza(size == 0 ? 10 : size << 1);
            unsafe.putObject(obj, j2, tq8Zza);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    int iH2 = G.h(bArr, iH, h);
                    int i8 = h.a + iH2;
                    if (iH2 < i8) {
                        G.l(bArr, iH2);
                        throw null;
                    }
                    if (iH2 == i8) {
                        return iH2;
                    }
                    throw zzjk.a();
                }
                if (i5 == 1) {
                    G.l(bArr, i);
                    throw null;
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    int iH3 = G.h(bArr, iH, h);
                    int i9 = h.a + iH3;
                    if (iH3 < i9) {
                        G.n(bArr, iH3);
                        throw null;
                    }
                    if (iH3 == i9) {
                        return iH3;
                    }
                    throw zzjk.a();
                }
                if (i5 == 5) {
                    G.n(bArr, i);
                    throw null;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    int iH4 = G.h(bArr, iH, h);
                    int i10 = h.a + iH4;
                    if (iH4 < i10) {
                        G.j(bArr, iH4, h);
                        throw null;
                    }
                    if (iH4 == i10) {
                        return iH4;
                    }
                    throw zzjk.a();
                }
                if (i5 == 0) {
                    G.j(bArr, iH, h);
                    long j3 = h.b;
                    throw null;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return G.i(bArr, iH, tq8Zza, h);
                }
                if (i5 == 0) {
                    return G.b(i3, bArr, i, i2, tq8Zza, h);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    int iH5 = G.h(bArr, iH, h);
                    int i11 = h.a + iH5;
                    if (iH5 < i11) {
                        G.k(bArr, iH5);
                        throw null;
                    }
                    if (iH5 == i11) {
                        return iH5;
                    }
                    throw zzjk.a();
                }
                if (i5 == 1) {
                    G.k(bArr, i);
                    throw null;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    C2182l0 c2182l0 = (C2182l0) tq8Zza;
                    int iH6 = G.h(bArr, iH, h);
                    int i12 = h.a + iH6;
                    while (iH6 < i12) {
                        c2182l0.i(G.g(bArr, iH6));
                        iH6 += 4;
                    }
                    if (iH6 == i12) {
                        return iH6;
                    }
                    throw zzjk.a();
                }
                if (i5 == 5) {
                    C2182l0 c2182l02 = (C2182l0) tq8Zza;
                    c2182l02.i(G.g(bArr, i));
                    while (true) {
                        int i13 = iH + 4;
                        if (i13 >= i2) {
                            return i13;
                        }
                        iH = G.h(bArr, i13, h);
                        if (i3 != h.a) {
                            return i13;
                        }
                        c2182l02.i(G.g(bArr, iH));
                    }
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    int iH7 = G.h(bArr, iH, h);
                    int i14 = h.a + iH7;
                    if (iH7 < i14) {
                        G.j(bArr, iH7, h);
                        throw null;
                    }
                    if (iH7 == i14) {
                        return iH7;
                    }
                    throw zzjk.a();
                }
                if (i5 == 0) {
                    G.j(bArr, iH, h);
                    long j4 = h.b;
                    throw null;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iH8 = G.h(bArr, iH, h);
                        int i15 = h.a;
                        if (i15 < 0) {
                            throw zzjk.b();
                        }
                        if (i15 == 0) {
                            tq8Zza.add("");
                        } else {
                            tq8Zza.add(new String(bArr, iH8, i15, AbstractC2184m0.a));
                            iH8 += i15;
                        }
                        while (iH8 < i2) {
                            int iH9 = G.h(bArr, iH8, h);
                            if (i3 != h.a) {
                                return iH8;
                            }
                            iH8 = G.h(bArr, iH9, h);
                            int i16 = h.a;
                            if (i16 < 0) {
                                throw zzjk.b();
                            }
                            if (i16 == 0) {
                                tq8Zza.add("");
                            } else {
                                tq8Zza.add(new String(bArr, iH8, i16, AbstractC2184m0.a));
                                iH8 += i16;
                            }
                        }
                        return iH8;
                    }
                    int iH10 = G.h(bArr, iH, h);
                    int i17 = h.a;
                    if (i17 < 0) {
                        throw zzjk.b();
                    }
                    if (i17 == 0) {
                        tq8Zza.add("");
                    } else {
                        int i18 = iH10 + i17;
                        if (!k1.g(bArr, iH10, i18)) {
                            throw zzjk.f();
                        }
                        tq8Zza.add(new String(bArr, iH10, i17, AbstractC2184m0.a));
                        iH10 = i18;
                    }
                    while (iH10 < i2) {
                        int iH11 = G.h(bArr, iH10, h);
                        if (i3 != h.a) {
                            return iH10;
                        }
                        iH10 = G.h(bArr, iH11, h);
                        int i19 = h.a;
                        if (i19 < 0) {
                            throw zzjk.b();
                        }
                        if (i19 == 0) {
                            tq8Zza.add("");
                        } else {
                            int i20 = iH10 + i19;
                            if (!k1.g(bArr, iH10, i20)) {
                                throw zzjk.f();
                            }
                            tq8Zza.add(new String(bArr, iH10, i19, AbstractC2184m0.a));
                            iH10 = i20;
                        }
                    }
                    return iH10;
                }
                break;
            case 27:
                if (i5 == 2) {
                    return G.d(p(i6), i3, bArr, i, i2, tq8Zza, h);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int iH12 = G.h(bArr, iH, h);
                    int i21 = h.a;
                    if (i21 < 0) {
                        throw zzjk.b();
                    }
                    if (i21 > bArr.length - iH12) {
                        throw zzjk.a();
                    }
                    if (i21 == 0) {
                        tq8Zza.add(K.b);
                    } else {
                        tq8Zza.add(K.E(bArr, iH12, i21));
                        iH12 += i21;
                    }
                    while (iH12 < i2) {
                        int iH13 = G.h(bArr, iH12, h);
                        if (i3 != h.a) {
                            return iH12;
                        }
                        iH12 = G.h(bArr, iH13, h);
                        int i22 = h.a;
                        if (i22 < 0) {
                            throw zzjk.b();
                        }
                        if (i22 > bArr.length - iH12) {
                            throw zzjk.a();
                        }
                        if (i22 == 0) {
                            tq8Zza.add(K.b);
                        } else {
                            tq8Zza.add(K.E(bArr, iH12, i22));
                            iH12 += i22;
                        }
                    }
                    return iH12;
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iB = G.i(bArr, iH, tq8Zza, h);
                } else if (i5 == 0) {
                    iB = G.b(i3, bArr, i, i2, tq8Zza, h);
                }
                AbstractC2178j0 abstractC2178j0 = (AbstractC2178j0) obj;
                h1 h1Var = abstractC2178j0.zzb;
                h1 h1Var2 = (h1) Q0.i(i4, tq8Zza, K(i6), h1Var != h1.a() ? h1Var : null, this.o);
                if (h1Var2 != null) {
                    abstractC2178j0.zzb = h1Var2;
                }
                return iB;
            case 33:
            case 47:
                if (i5 == 2) {
                    C2182l0 c2182l03 = (C2182l0) tq8Zza;
                    int iH14 = G.h(bArr, iH, h);
                    int i23 = h.a + iH14;
                    while (iH14 < i23) {
                        iH14 = G.h(bArr, iH14, h);
                        c2182l03.i(W.d(h.a));
                    }
                    if (iH14 == i23) {
                        return iH14;
                    }
                    throw zzjk.a();
                }
                if (i5 == 0) {
                    C2182l0 c2182l04 = (C2182l0) tq8Zza;
                    int iH15 = G.h(bArr, iH, h);
                    c2182l04.i(W.d(h.a));
                    while (iH15 < i2) {
                        int iH16 = G.h(bArr, iH15, h);
                        if (i3 != h.a) {
                            return iH15;
                        }
                        iH15 = G.h(bArr, iH16, h);
                        c2182l04.i(W.d(h.a));
                    }
                    return iH15;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    int iH17 = G.h(bArr, iH, h);
                    int i24 = h.a + iH17;
                    if (iH17 >= i24) {
                        if (iH17 == i24) {
                            return iH17;
                        }
                        throw zzjk.a();
                    }
                    G.j(bArr, iH17, h);
                    W.a(h.b);
                    throw null;
                }
                if (i5 == 0) {
                    G.j(bArr, iH, h);
                    W.a(h.b);
                    throw null;
                }
                break;
            case 49:
                if (i5 == 3) {
                    P0 p0P = p(i6);
                    int i25 = (i3 & (-8)) | 4;
                    iH = G.e(p0P, bArr, i, i2, i25, h);
                    tq8Zza.add(h.c);
                    while (iH < i2) {
                        int iH18 = G.h(bArr, iH, h);
                        if (i3 != h.a) {
                            break;
                        } else {
                            iH = G.e(p0P, bArr, iH18, i2, i25, h);
                            tq8Zza.add(h.c);
                        }
                    }
                    break;
                }
                break;
        }
        return iH;
    }

    private final int m(Object obj, byte[] bArr, int i, int i2, int i3, long j, H h) throws zzjk {
        Unsafe unsafe = s;
        Object objE = E(i3);
        Object object = unsafe.getObject(obj, j);
        if (this.q.b(object)) {
            Object objJ = this.q.j(objE);
            this.q.c(objJ, object);
            unsafe.putObject(obj, j, objJ);
            object = objJ;
        }
        this.q.i(objE);
        this.q.h(object);
        int iH = G.h(bArr, i, h);
        int i4 = h.a;
        if (i4 < 0 || i4 > i2 - iH) {
            throw zzjk.a();
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x038b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.android.gms.internal.vision.F0 o(java.lang.Class r31, com.google.android.gms.internal.vision.C0 r32, com.google.android.gms.internal.vision.I0 r33, com.google.android.gms.internal.vision.AbstractC2190p0 r34, com.google.android.gms.internal.vision.f1 r35, com.google.android.gms.internal.vision.AbstractC2166d0 r36, com.google.android.gms.internal.vision.B0 r37) {
        /*
            Method dump skipped, instructions count: 1032
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.F0.o(java.lang.Class, com.google.android.gms.internal.vision.C0, com.google.android.gms.internal.vision.I0, com.google.android.gms.internal.vision.p0, com.google.android.gms.internal.vision.f1, com.google.android.gms.internal.vision.d0, com.google.android.gms.internal.vision.B0):com.google.android.gms.internal.vision.F0");
    }

    private final P0 p(int i) {
        int i2 = (i / 3) << 1;
        P0 p0 = (P0) this.b[i2];
        if (p0 != null) {
            return p0;
        }
        P0 p0B = M0.a().b((Class) this.b[i2 + 1]);
        this.b[i2] = p0B;
        return p0B;
    }

    private final Object q(int i, int i2, Map map, Oq8 oq8, Object obj, f1 f1Var) {
        this.q.i(E(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!oq8.zza(((Integer) entry.getValue()).intValue())) {
                if (obj == null) {
                    obj = f1Var.a();
                }
                S sR = K.R(AbstractC2203w0.a(null, entry.getKey(), entry.getValue()));
                try {
                    AbstractC2203w0.b(sR.b(), null, entry.getKey(), entry.getValue());
                    f1Var.c(obj, i2, sR.a());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    private final Object r(Object obj, int i, Object obj2, f1 f1Var) {
        Oq8 oq8K;
        int i2 = this.a[i];
        Object objF = i1.F(obj, M(i) & 1048575);
        return (objF == null || (oq8K = K(i)) == null) ? obj2 : q(i, i2, this.q.h(objF), oq8K, obj2, f1Var);
    }

    private static Field s(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString());
        }
    }

    private static List t(Object obj, long j) {
        return (List) i1.F(obj, j);
    }

    private static void u(int i, Object obj, q1 q1Var) {
        if (obj instanceof String) {
            q1Var.z(i, (String) obj);
        } else {
            q1Var.I(i, (K) obj);
        }
    }

    private static void v(f1 f1Var, Object obj, q1 q1Var) {
        f1Var.d(f1Var.f(obj), q1Var);
    }

    private final void w(q1 q1Var, int i, Object obj, int i2) {
        if (obj != null) {
            this.q.i(E(i2));
            q1Var.J(i, null, this.q.a(obj));
        }
    }

    private final void x(Object obj, Object obj2, int i) {
        long jM = M(i) & 1048575;
        if (y(obj2, i)) {
            Object objF = i1.F(obj, jM);
            Object objF2 = i1.F(obj2, jM);
            if (objF != null && objF2 != null) {
                i1.j(obj, jM, AbstractC2184m0.e(objF, objF2));
                F(obj, i);
            } else if (objF2 != null) {
                i1.j(obj, jM, objF2);
                F(obj, i);
            }
        }
    }

    private final boolean y(Object obj, int i) {
        int iO = O(i);
        long j = iO & 1048575;
        if (j != 1048575) {
            return (i1.b(obj, j) & (1 << (iO >>> 20))) != 0;
        }
        int iM = M(i);
        long j2 = iM & 1048575;
        switch ((iM & 267386880) >>> 20) {
            case 0:
                return i1.C(obj, j2) != 0.0d;
            case 1:
                return i1.x(obj, j2) != 0.0f;
            case 2:
                return i1.o(obj, j2) != 0;
            case 3:
                return i1.o(obj, j2) != 0;
            case 4:
                return i1.b(obj, j2) != 0;
            case 5:
                return i1.o(obj, j2) != 0;
            case 6:
                return i1.b(obj, j2) != 0;
            case 7:
                return i1.w(obj, j2);
            case 8:
                Object objF = i1.F(obj, j2);
                if (objF instanceof String) {
                    return !((String) objF).isEmpty();
                }
                if (objF instanceof K) {
                    return !K.b.equals(objF);
                }
                throw new IllegalArgumentException();
            case 9:
                return i1.F(obj, j2) != null;
            case 10:
                return !K.b.equals(i1.F(obj, j2));
            case 11:
                return i1.b(obj, j2) != 0;
            case 12:
                return i1.b(obj, j2) != 0;
            case 13:
                return i1.b(obj, j2) != 0;
            case 14:
                return i1.o(obj, j2) != 0;
            case 15:
                return i1.b(obj, j2) != 0;
            case 16:
                return i1.o(obj, j2) != 0;
            case 17:
                return i1.F(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean z(Object obj, int i, int i2) {
        return i1.b(obj, (long) (O(i2) & 1048575)) == i;
    }

    @Override // com.google.android.gms.internal.vision.P0
    public final void a(Object obj) {
        int i;
        int i2 = this.k;
        while (true) {
            i = this.l;
            if (i2 >= i) {
                break;
            }
            long jM = M(this.j[i2]) & 1048575;
            Object objF = i1.F(obj, jM);
            if (objF != null) {
                i1.j(obj, jM, this.q.d(objF));
            }
            i2++;
        }
        int length = this.j.length;
        while (i < length) {
            this.n.d(obj, this.j[i]);
            i++;
        }
        this.o.j(obj);
        if (this.f) {
            this.p.f(obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a2  */
    @Override // com.google.android.gms.internal.vision.P0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.F0.b(java.lang.Object):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    @Override // com.google.android.gms.internal.vision.P0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(java.lang.Object r10, java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.F0.c(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.vision.P0
    public final void d(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.a.length; i += 3) {
            int iM = M(i);
            long j = 1048575 & iM;
            int i2 = this.a[i];
            switch ((iM & 267386880) >>> 20) {
                case 0:
                    if (y(obj2, i)) {
                        i1.f(obj, j, i1.C(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (y(obj2, i)) {
                        i1.g(obj, j, i1.x(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (y(obj2, i)) {
                        i1.i(obj, j, i1.o(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (y(obj2, i)) {
                        i1.i(obj, j, i1.o(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (y(obj2, i)) {
                        i1.h(obj, j, i1.b(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (y(obj2, i)) {
                        i1.i(obj, j, i1.o(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (y(obj2, i)) {
                        i1.h(obj, j, i1.b(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (y(obj2, i)) {
                        i1.k(obj, j, i1.w(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (y(obj2, i)) {
                        i1.j(obj, j, i1.F(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    x(obj, obj2, i);
                    break;
                case 10:
                    if (y(obj2, i)) {
                        i1.j(obj, j, i1.F(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (y(obj2, i)) {
                        i1.h(obj, j, i1.b(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (y(obj2, i)) {
                        i1.h(obj, j, i1.b(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (y(obj2, i)) {
                        i1.h(obj, j, i1.b(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (y(obj2, i)) {
                        i1.i(obj, j, i1.o(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (y(obj2, i)) {
                        i1.h(obj, j, i1.b(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (y(obj2, i)) {
                        i1.i(obj, j, i1.o(obj2, j));
                        F(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    x(obj, obj2, i);
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
                    this.n.b(obj, obj2, j);
                    break;
                case 50:
                    Q0.n(this.q, obj, obj2, j);
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
                    if (z(obj2, i2, i)) {
                        i1.j(obj, j, i1.F(obj2, j));
                        G(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    I(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case WKSRecord.Protocol.RVD /* 66 */:
                case 67:
                    if (z(obj2, i2, i)) {
                        i1.j(obj, j, i1.F(obj2, j));
                        G(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    I(obj, obj2, i);
                    break;
            }
        }
        Q0.o(this.o, obj, obj2);
        if (this.f) {
            Q0.m(this.p, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @Override // com.google.android.gms.internal.vision.P0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.Object r14, com.google.android.gms.internal.vision.q1 r15) {
        /*
            Method dump skipped, instructions count: 2916
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.F0.e(java.lang.Object, com.google.android.gms.internal.vision.q1):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x02ce, code lost:
    
        if (r0 == r5) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02d0, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02d7, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r18;
        r10 = r19;
        r1 = r25;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0321, code lost:
    
        if (r0 == r15) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0340, code lost:
    
        if (r0 == r15) goto L102;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0094. Please report as an issue. */
    @Override // com.google.android.gms.internal.vision.P0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.Object r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.vision.H r35) throws com.google.android.gms.internal.vision.zzjk {
        /*
            Method dump skipped, instructions count: 952
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.F0.f(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.H):void");
    }

    @Override // com.google.android.gms.internal.vision.P0
    public final int h(Object obj) {
        int i;
        int iB;
        int length = this.a.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iM = M(i3);
            int i4 = this.a[i3];
            long j = 1048575 & iM;
            int iHashCode = 37;
            switch ((iM & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iB = AbstractC2184m0.b(Double.doubleToLongBits(i1.C(obj, j)));
                    i2 = i + iB;
                    break;
                case 1:
                    i = i2 * 53;
                    iB = Float.floatToIntBits(i1.x(obj, j));
                    i2 = i + iB;
                    break;
                case 2:
                    i = i2 * 53;
                    iB = AbstractC2184m0.b(i1.o(obj, j));
                    i2 = i + iB;
                    break;
                case 3:
                    i = i2 * 53;
                    iB = AbstractC2184m0.b(i1.o(obj, j));
                    i2 = i + iB;
                    break;
                case 4:
                    i = i2 * 53;
                    iB = i1.b(obj, j);
                    i2 = i + iB;
                    break;
                case 5:
                    i = i2 * 53;
                    iB = AbstractC2184m0.b(i1.o(obj, j));
                    i2 = i + iB;
                    break;
                case 6:
                    i = i2 * 53;
                    iB = i1.b(obj, j);
                    i2 = i + iB;
                    break;
                case 7:
                    i = i2 * 53;
                    iB = AbstractC2184m0.c(i1.w(obj, j));
                    i2 = i + iB;
                    break;
                case 8:
                    i = i2 * 53;
                    iB = ((String) i1.F(obj, j)).hashCode();
                    i2 = i + iB;
                    break;
                case 9:
                    Object objF = i1.F(obj, j);
                    if (objF != null) {
                        iHashCode = objF.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iB = i1.F(obj, j).hashCode();
                    i2 = i + iB;
                    break;
                case 11:
                    i = i2 * 53;
                    iB = i1.b(obj, j);
                    i2 = i + iB;
                    break;
                case 12:
                    i = i2 * 53;
                    iB = i1.b(obj, j);
                    i2 = i + iB;
                    break;
                case 13:
                    i = i2 * 53;
                    iB = i1.b(obj, j);
                    i2 = i + iB;
                    break;
                case 14:
                    i = i2 * 53;
                    iB = AbstractC2184m0.b(i1.o(obj, j));
                    i2 = i + iB;
                    break;
                case 15:
                    i = i2 * 53;
                    iB = i1.b(obj, j);
                    i2 = i + iB;
                    break;
                case 16:
                    i = i2 * 53;
                    iB = AbstractC2184m0.b(i1.o(obj, j));
                    i2 = i + iB;
                    break;
                case 17:
                    Object objF2 = i1.F(obj, j);
                    if (objF2 != null) {
                        iHashCode = objF2.hashCode();
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
                    iB = i1.F(obj, j).hashCode();
                    i2 = i + iB;
                    break;
                case 50:
                    i = i2 * 53;
                    iB = i1.F(obj, j).hashCode();
                    i2 = i + iB;
                    break;
                case 51:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = AbstractC2184m0.b(Double.doubleToLongBits(C(obj, j)));
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case Type.TLSA /* 52 */:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = Float.floatToIntBits(J(obj, j));
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = AbstractC2184m0.b(P(obj, j));
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = AbstractC2184m0.b(P(obj, j));
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = N(obj, j);
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case Type.NINFO /* 56 */:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = AbstractC2184m0.b(P(obj, j));
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = N(obj, j);
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = AbstractC2184m0.c(R(obj, j));
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = ((String) i1.F(obj, j)).hashCode();
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = i1.F(obj, j).hashCode();
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = i1.F(obj, j).hashCode();
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = N(obj, j);
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = N(obj, j);
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = N(obj, j);
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = AbstractC2184m0.b(P(obj, j));
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = N(obj, j);
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = AbstractC2184m0.b(P(obj, j));
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iB = i1.F(obj, j).hashCode();
                        i2 = i + iB;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.o.f(obj).hashCode();
        return this.f ? (iHashCode2 * 53) + this.p.b(obj).hashCode() : iHashCode2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.vision.P0
    public final int i(Object obj) {
        int i;
        boolean z;
        int i2;
        long j;
        int iX;
        int iD;
        int iP;
        int iR;
        int iV;
        int iC0;
        int iK0;
        int iZ;
        int iV2;
        int iC02;
        int iK02;
        int i3 = 267386880;
        int i4 = 1048575;
        int i5 = 1;
        int i6 = 0;
        if (this.h) {
            Unsafe unsafe = s;
            int i7 = 0;
            int i8 = 0;
            while (i7 < this.a.length) {
                int iM = M(i7);
                int i9 = (iM & i3) >>> 20;
                int i10 = this.a[i7];
                long j2 = iM & 1048575;
                if (i9 >= EnumC21620tq8.F0.zza() && i9 <= EnumC21620tq8.S0.zza()) {
                    int i11 = this.a[i7 + 2];
                }
                switch (i9) {
                    case 0:
                        if (y(obj, i7)) {
                            iZ = zzii.z(i10, 0.0d);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (y(obj, i7)) {
                            iZ = zzii.A(i10, 0.0f);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (y(obj, i7)) {
                            iZ = zzii.X(i10, i1.o(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (y(obj, i7)) {
                            iZ = zzii.d0(i10, i1.o(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (y(obj, i7)) {
                            iZ = zzii.h0(i10, i1.b(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (y(obj, i7)) {
                            iZ = zzii.m0(i10, 0L);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (y(obj, i7)) {
                            iZ = zzii.t0(i10, 0);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (y(obj, i7)) {
                            iZ = zzii.D(i10, true);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (y(obj, i7)) {
                            Object objF = i1.F(obj, j2);
                            iZ = objF instanceof K ? zzii.P(i10, (K) objF) : zzii.C(i10, (String) objF);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (y(obj, i7)) {
                            iZ = Q0.a(i10, i1.F(obj, j2), p(i7));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (y(obj, i7)) {
                            iZ = zzii.P(i10, (K) i1.F(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (y(obj, i7)) {
                            iZ = zzii.l0(i10, i1.b(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (y(obj, i7)) {
                            iZ = zzii.y0(i10, i1.b(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (y(obj, i7)) {
                            iZ = zzii.w0(i10, 0);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (y(obj, i7)) {
                            iZ = zzii.q0(i10, 0L);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (y(obj, i7)) {
                            iZ = zzii.p0(i10, i1.b(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (y(obj, i7)) {
                            iZ = zzii.i0(i10, i1.o(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (y(obj, i7)) {
                            iZ = zzii.Q(i10, (InterfaceC18561or8) i1.F(obj, j2), p(i7));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        iZ = Q0.U(i10, t(obj, j2), false);
                        i8 += iZ;
                        break;
                    case 19:
                        iZ = Q0.R(i10, t(obj, j2), false);
                        i8 += iZ;
                        break;
                    case 20:
                        iZ = Q0.d(i10, t(obj, j2), false);
                        i8 += iZ;
                        break;
                    case 21:
                        iZ = Q0.t(i10, t(obj, j2), false);
                        i8 += iZ;
                        break;
                    case 22:
                        iZ = Q0.H(i10, t(obj, j2), false);
                        i8 += iZ;
                        break;
                    case 23:
                        iZ = Q0.U(i10, t(obj, j2), false);
                        i8 += iZ;
                        break;
                    case 24:
                        iZ = Q0.R(i10, t(obj, j2), false);
                        i8 += iZ;
                        break;
                    case 25:
                        iZ = Q0.X(i10, t(obj, j2), false);
                        i8 += iZ;
                        break;
                    case 26:
                        iZ = Q0.b(i10, t(obj, j2));
                        i8 += iZ;
                        break;
                    case 27:
                        iZ = Q0.c(i10, t(obj, j2), p(i7));
                        i8 += iZ;
                        break;
                    case 28:
                        iZ = Q0.r(i10, t(obj, j2));
                        i8 += iZ;
                        break;
                    case 29:
                        iZ = Q0.L(i10, t(obj, j2), false);
                        i8 += iZ;
                        break;
                    case 30:
                        iZ = Q0.D(i10, t(obj, j2), false);
                        i8 += iZ;
                        break;
                    case 31:
                        iZ = Q0.R(i10, t(obj, j2), false);
                        i8 += iZ;
                        break;
                    case 32:
                        iZ = Q0.U(i10, t(obj, j2), false);
                        i8 += iZ;
                        break;
                    case 33:
                        iZ = Q0.O(i10, t(obj, j2), false);
                        i8 += iZ;
                        break;
                    case 34:
                        iZ = Q0.z(i10, t(obj, j2), false);
                        i8 += iZ;
                        break;
                    case 35:
                        iV2 = Q0.V((List) unsafe.getObject(obj, j2));
                        if (iV2 > 0) {
                            iC02 = zzii.c0(i10);
                            iK02 = zzii.k0(iV2);
                            iZ = iC02 + iK02 + iV2;
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        iV2 = Q0.S((List) unsafe.getObject(obj, j2));
                        if (iV2 > 0) {
                            iC02 = zzii.c0(i10);
                            iK02 = zzii.k0(iV2);
                            iZ = iC02 + iK02 + iV2;
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        iV2 = Q0.e((List) unsafe.getObject(obj, j2));
                        if (iV2 > 0) {
                            iC02 = zzii.c0(i10);
                            iK02 = zzii.k0(iV2);
                            iZ = iC02 + iK02 + iV2;
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        iV2 = Q0.u((List) unsafe.getObject(obj, j2));
                        if (iV2 > 0) {
                            iC02 = zzii.c0(i10);
                            iK02 = zzii.k0(iV2);
                            iZ = iC02 + iK02 + iV2;
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        iV2 = Q0.I((List) unsafe.getObject(obj, j2));
                        if (iV2 > 0) {
                            iC02 = zzii.c0(i10);
                            iK02 = zzii.k0(iV2);
                            iZ = iC02 + iK02 + iV2;
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        iV2 = Q0.V((List) unsafe.getObject(obj, j2));
                        if (iV2 > 0) {
                            iC02 = zzii.c0(i10);
                            iK02 = zzii.k0(iV2);
                            iZ = iC02 + iK02 + iV2;
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        iV2 = Q0.S((List) unsafe.getObject(obj, j2));
                        if (iV2 > 0) {
                            iC02 = zzii.c0(i10);
                            iK02 = zzii.k0(iV2);
                            iZ = iC02 + iK02 + iV2;
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        iV2 = Q0.Y((List) unsafe.getObject(obj, j2));
                        if (iV2 > 0) {
                            iC02 = zzii.c0(i10);
                            iK02 = zzii.k0(iV2);
                            iZ = iC02 + iK02 + iV2;
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        iV2 = Q0.M((List) unsafe.getObject(obj, j2));
                        if (iV2 > 0) {
                            iC02 = zzii.c0(i10);
                            iK02 = zzii.k0(iV2);
                            iZ = iC02 + iK02 + iV2;
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        iV2 = Q0.E((List) unsafe.getObject(obj, j2));
                        if (iV2 > 0) {
                            iC02 = zzii.c0(i10);
                            iK02 = zzii.k0(iV2);
                            iZ = iC02 + iK02 + iV2;
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        iV2 = Q0.S((List) unsafe.getObject(obj, j2));
                        if (iV2 > 0) {
                            iC02 = zzii.c0(i10);
                            iK02 = zzii.k0(iV2);
                            iZ = iC02 + iK02 + iV2;
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        iV2 = Q0.V((List) unsafe.getObject(obj, j2));
                        if (iV2 > 0) {
                            iC02 = zzii.c0(i10);
                            iK02 = zzii.k0(iV2);
                            iZ = iC02 + iK02 + iV2;
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        iV2 = Q0.P((List) unsafe.getObject(obj, j2));
                        if (iV2 > 0) {
                            iC02 = zzii.c0(i10);
                            iK02 = zzii.k0(iV2);
                            iZ = iC02 + iK02 + iV2;
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        iV2 = Q0.A((List) unsafe.getObject(obj, j2));
                        if (iV2 > 0) {
                            iC02 = zzii.c0(i10);
                            iK02 = zzii.k0(iV2);
                            iZ = iC02 + iK02 + iV2;
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        iZ = Q0.s(i10, t(obj, j2), p(i7));
                        i8 += iZ;
                        break;
                    case 50:
                        iZ = this.q.e(i10, i1.F(obj, j2), E(i7));
                        i8 += iZ;
                        break;
                    case 51:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.z(i10, 0.0d);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case Type.TLSA /* 52 */:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.A(i10, 0.0f);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.X(i10, P(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.d0(i10, P(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.h0(i10, N(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case Type.NINFO /* 56 */:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.m0(i10, 0L);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.t0(i10, 0);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.D(i10, true);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (z(obj, i10, i7)) {
                            Object objF2 = i1.F(obj, j2);
                            iZ = objF2 instanceof K ? zzii.P(i10, (K) objF2) : zzii.C(i10, (String) objF2);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (z(obj, i10, i7)) {
                            iZ = Q0.a(i10, i1.F(obj, j2), p(i7));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.P(i10, (K) i1.F(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.l0(i10, N(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.y0(i10, N(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.w0(i10, 0);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.q0(i10, 0L);
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case WKSRecord.Protocol.RVD /* 66 */:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.p0(i10, N(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.i0(i10, P(obj, j2));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                    case WKSRecord.Service.BOOTPC /* 68 */:
                        if (z(obj, i10, i7)) {
                            iZ = zzii.Q(i10, (InterfaceC18561or8) i1.F(obj, j2), p(i7));
                            i8 += iZ;
                            break;
                        } else {
                            break;
                        }
                }
                i7 += 3;
                i3 = 267386880;
            }
            return i8 + j(this.o, obj);
        }
        Unsafe unsafe2 = s;
        int i12 = 1048575;
        int i13 = 0;
        int iZ2 = 0;
        int i14 = 0;
        while (i13 < this.a.length) {
            int iM2 = M(i13);
            int[] iArr = this.a;
            int i15 = iArr[i13];
            int i16 = (iM2 & 267386880) >>> 20;
            if (i16 <= 17) {
                int i17 = iArr[i13 + 2];
                int i18 = i17 & i4;
                i = i5 << (i17 >>> 20);
                if (i18 != i12) {
                    i14 = unsafe2.getInt(obj, i18);
                    i12 = i18;
                }
            } else {
                i = 0;
            }
            long j3 = iM2 & i4;
            switch (i16) {
                case 0:
                    z = false;
                    i2 = 0;
                    j = 0;
                    if ((i14 & i) != 0) {
                        iZ2 += zzii.z(i15, 0.0d);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    i2 = 0;
                    j = 0;
                    if ((i14 & i) != 0) {
                        z = false;
                        iZ2 += zzii.A(i15, 0.0f);
                    } else {
                        z = false;
                    }
                    break;
                case 2:
                    i2 = 0;
                    j = 0;
                    if ((i & i14) != 0) {
                        iX = zzii.X(i15, unsafe2.getLong(obj, j3));
                        iZ2 += iX;
                    }
                    z = false;
                    break;
                case 3:
                    i2 = 0;
                    j = 0;
                    if ((i & i14) != 0) {
                        iX = zzii.d0(i15, unsafe2.getLong(obj, j3));
                        iZ2 += iX;
                    }
                    z = false;
                    break;
                case 4:
                    i2 = 0;
                    j = 0;
                    if ((i & i14) != 0) {
                        iX = zzii.h0(i15, unsafe2.getInt(obj, j3));
                        iZ2 += iX;
                    }
                    z = false;
                    break;
                case 5:
                    i2 = 0;
                    j = 0;
                    if ((i14 & i) != 0) {
                        iX = zzii.m0(i15, 0L);
                        iZ2 += iX;
                    }
                    z = false;
                    break;
                case 6:
                    i2 = 0;
                    if ((i14 & i) != 0) {
                        iZ2 += zzii.t0(i15, 0);
                    }
                    z = false;
                    j = 0;
                    break;
                case 7:
                    if ((i14 & i) != 0) {
                        iD = zzii.D(i15, true);
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 8:
                    if ((i14 & i) != 0) {
                        Object object = unsafe2.getObject(obj, j3);
                        iP = object instanceof K ? zzii.P(i15, (K) object) : zzii.C(i15, (String) object);
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 9:
                    if ((i14 & i) != 0) {
                        iP = Q0.a(i15, unsafe2.getObject(obj, j3), p(i13));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 10:
                    if ((i14 & i) != 0) {
                        iP = zzii.P(i15, (K) unsafe2.getObject(obj, j3));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 11:
                    if ((i14 & i) != 0) {
                        iP = zzii.l0(i15, unsafe2.getInt(obj, j3));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 12:
                    if ((i14 & i) != 0) {
                        iP = zzii.y0(i15, unsafe2.getInt(obj, j3));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 13:
                    if ((i14 & i) != 0) {
                        iD = zzii.w0(i15, 0);
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 14:
                    if ((i14 & i) != 0) {
                        iP = zzii.q0(i15, 0L);
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 15:
                    if ((i14 & i) != 0) {
                        iP = zzii.p0(i15, unsafe2.getInt(obj, j3));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 16:
                    if ((i14 & i) != 0) {
                        iP = zzii.i0(i15, unsafe2.getLong(obj, j3));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 17:
                    if ((i14 & i) != 0) {
                        iP = zzii.Q(i15, (InterfaceC18561or8) unsafe2.getObject(obj, j3), p(i13));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 18:
                    iP = Q0.U(i15, (List) unsafe2.getObject(obj, j3), false);
                    iZ2 += iP;
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 19:
                    i2 = 0;
                    iR = Q0.R(i15, (List) unsafe2.getObject(obj, j3), false);
                    iZ2 += iR;
                    z = false;
                    j = 0;
                    break;
                case 20:
                    i2 = 0;
                    iR = Q0.d(i15, (List) unsafe2.getObject(obj, j3), false);
                    iZ2 += iR;
                    z = false;
                    j = 0;
                    break;
                case 21:
                    i2 = 0;
                    iR = Q0.t(i15, (List) unsafe2.getObject(obj, j3), false);
                    iZ2 += iR;
                    z = false;
                    j = 0;
                    break;
                case 22:
                    i2 = 0;
                    iR = Q0.H(i15, (List) unsafe2.getObject(obj, j3), false);
                    iZ2 += iR;
                    z = false;
                    j = 0;
                    break;
                case 23:
                    i2 = 0;
                    iR = Q0.U(i15, (List) unsafe2.getObject(obj, j3), false);
                    iZ2 += iR;
                    z = false;
                    j = 0;
                    break;
                case 24:
                    i2 = 0;
                    iR = Q0.R(i15, (List) unsafe2.getObject(obj, j3), false);
                    iZ2 += iR;
                    z = false;
                    j = 0;
                    break;
                case 25:
                    i2 = 0;
                    iR = Q0.X(i15, (List) unsafe2.getObject(obj, j3), false);
                    iZ2 += iR;
                    z = false;
                    j = 0;
                    break;
                case 26:
                    iP = Q0.b(i15, (List) unsafe2.getObject(obj, j3));
                    iZ2 += iP;
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 27:
                    iP = Q0.c(i15, (List) unsafe2.getObject(obj, j3), p(i13));
                    iZ2 += iP;
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 28:
                    iP = Q0.r(i15, (List) unsafe2.getObject(obj, j3));
                    iZ2 += iP;
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 29:
                    iP = Q0.L(i15, (List) unsafe2.getObject(obj, j3), false);
                    iZ2 += iP;
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 30:
                    i2 = 0;
                    iR = Q0.D(i15, (List) unsafe2.getObject(obj, j3), false);
                    iZ2 += iR;
                    z = false;
                    j = 0;
                    break;
                case 31:
                    i2 = 0;
                    iR = Q0.R(i15, (List) unsafe2.getObject(obj, j3), false);
                    iZ2 += iR;
                    z = false;
                    j = 0;
                    break;
                case 32:
                    i2 = 0;
                    iR = Q0.U(i15, (List) unsafe2.getObject(obj, j3), false);
                    iZ2 += iR;
                    z = false;
                    j = 0;
                    break;
                case 33:
                    i2 = 0;
                    iR = Q0.O(i15, (List) unsafe2.getObject(obj, j3), false);
                    iZ2 += iR;
                    z = false;
                    j = 0;
                    break;
                case 34:
                    i2 = 0;
                    iR = Q0.z(i15, (List) unsafe2.getObject(obj, j3), false);
                    iZ2 += iR;
                    z = false;
                    j = 0;
                    break;
                case 35:
                    iV = Q0.V((List) unsafe2.getObject(obj, j3));
                    if (iV > 0) {
                        iC0 = zzii.c0(i15);
                        iK0 = zzii.k0(iV);
                        iD = iC0 + iK0 + iV;
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 36:
                    iV = Q0.S((List) unsafe2.getObject(obj, j3));
                    if (iV > 0) {
                        iC0 = zzii.c0(i15);
                        iK0 = zzii.k0(iV);
                        iD = iC0 + iK0 + iV;
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 37:
                    iV = Q0.e((List) unsafe2.getObject(obj, j3));
                    if (iV > 0) {
                        iC0 = zzii.c0(i15);
                        iK0 = zzii.k0(iV);
                        iD = iC0 + iK0 + iV;
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 38:
                    iV = Q0.u((List) unsafe2.getObject(obj, j3));
                    if (iV > 0) {
                        iC0 = zzii.c0(i15);
                        iK0 = zzii.k0(iV);
                        iD = iC0 + iK0 + iV;
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 39:
                    iV = Q0.I((List) unsafe2.getObject(obj, j3));
                    if (iV > 0) {
                        iC0 = zzii.c0(i15);
                        iK0 = zzii.k0(iV);
                        iD = iC0 + iK0 + iV;
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 40:
                    iV = Q0.V((List) unsafe2.getObject(obj, j3));
                    if (iV > 0) {
                        iC0 = zzii.c0(i15);
                        iK0 = zzii.k0(iV);
                        iD = iC0 + iK0 + iV;
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 41:
                    iV = Q0.S((List) unsafe2.getObject(obj, j3));
                    if (iV > 0) {
                        iC0 = zzii.c0(i15);
                        iK0 = zzii.k0(iV);
                        iD = iC0 + iK0 + iV;
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 42:
                    iV = Q0.Y((List) unsafe2.getObject(obj, j3));
                    if (iV > 0) {
                        iC0 = zzii.c0(i15);
                        iK0 = zzii.k0(iV);
                        iD = iC0 + iK0 + iV;
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 43:
                    iV = Q0.M((List) unsafe2.getObject(obj, j3));
                    if (iV > 0) {
                        iC0 = zzii.c0(i15);
                        iK0 = zzii.k0(iV);
                        iD = iC0 + iK0 + iV;
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 44:
                    iV = Q0.E((List) unsafe2.getObject(obj, j3));
                    if (iV > 0) {
                        iC0 = zzii.c0(i15);
                        iK0 = zzii.k0(iV);
                        iD = iC0 + iK0 + iV;
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 45:
                    iV = Q0.S((List) unsafe2.getObject(obj, j3));
                    if (iV > 0) {
                        iC0 = zzii.c0(i15);
                        iK0 = zzii.k0(iV);
                        iD = iC0 + iK0 + iV;
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 46:
                    iV = Q0.V((List) unsafe2.getObject(obj, j3));
                    if (iV > 0) {
                        iC0 = zzii.c0(i15);
                        iK0 = zzii.k0(iV);
                        iD = iC0 + iK0 + iV;
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 47:
                    iV = Q0.P((List) unsafe2.getObject(obj, j3));
                    if (iV > 0) {
                        iC0 = zzii.c0(i15);
                        iK0 = zzii.k0(iV);
                        iD = iC0 + iK0 + iV;
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 48:
                    iV = Q0.A((List) unsafe2.getObject(obj, j3));
                    if (iV > 0) {
                        iC0 = zzii.c0(i15);
                        iK0 = zzii.k0(iV);
                        iD = iC0 + iK0 + iV;
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 49:
                    iP = Q0.s(i15, (List) unsafe2.getObject(obj, j3), p(i13));
                    iZ2 += iP;
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 50:
                    iP = this.q.e(i15, unsafe2.getObject(obj, j3), E(i13));
                    iZ2 += iP;
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 51:
                    if (z(obj, i15, i13)) {
                        iP = zzii.z(i15, 0.0d);
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case Type.TLSA /* 52 */:
                    if (z(obj, i15, i13)) {
                        iD = zzii.A(i15, 0.0f);
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 53:
                    if (z(obj, i15, i13)) {
                        iP = zzii.X(i15, P(obj, j3));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (z(obj, i15, i13)) {
                        iP = zzii.d0(i15, P(obj, j3));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 55:
                    if (z(obj, i15, i13)) {
                        iP = zzii.h0(i15, N(obj, j3));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case Type.NINFO /* 56 */:
                    if (z(obj, i15, i13)) {
                        iP = zzii.m0(i15, 0L);
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 57:
                    if (z(obj, i15, i13)) {
                        iD = zzii.t0(i15, 0);
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 58:
                    if (z(obj, i15, i13)) {
                        iD = zzii.D(i15, true);
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 59:
                    if (z(obj, i15, i13)) {
                        Object object2 = unsafe2.getObject(obj, j3);
                        iP = object2 instanceof K ? zzii.P(i15, (K) object2) : zzii.C(i15, (String) object2);
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 60:
                    if (z(obj, i15, i13)) {
                        iP = Q0.a(i15, unsafe2.getObject(obj, j3), p(i13));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 61:
                    if (z(obj, i15, i13)) {
                        iP = zzii.P(i15, (K) unsafe2.getObject(obj, j3));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 62:
                    if (z(obj, i15, i13)) {
                        iP = zzii.l0(i15, N(obj, j3));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 63:
                    if (z(obj, i15, i13)) {
                        iP = zzii.y0(i15, N(obj, j3));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 64:
                    if (z(obj, i15, i13)) {
                        iD = zzii.w0(i15, 0);
                        iZ2 += iD;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 65:
                    if (z(obj, i15, i13)) {
                        iP = zzii.q0(i15, 0L);
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (z(obj, i15, i13)) {
                        iP = zzii.p0(i15, N(obj, j3));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case 67:
                    if (z(obj, i15, i13)) {
                        iP = zzii.i0(i15, P(obj, j3));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (z(obj, i15, i13)) {
                        iP = zzii.Q(i15, (InterfaceC18561or8) unsafe2.getObject(obj, j3), p(i13));
                        iZ2 += iP;
                    }
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
                default:
                    z = false;
                    i2 = 0;
                    j = 0;
                    break;
            }
            i13 += 3;
            i6 = i2;
            i4 = 1048575;
            i5 = 1;
        }
        int iH = i6;
        int iJ = iZ2 + j(this.o, obj);
        if (!this.f) {
            return iJ;
        }
        C2172g0 c2172g0B = this.p.b(obj);
        for (int i19 = iH; i19 < c2172g0B.a.k(); i19++) {
            Map.Entry entryI = c2172g0B.a.i(i19);
            AbstractC18350oW3.a(entryI.getKey());
            iH += C2172g0.h(null, entryI.getValue());
        }
        for (Map.Entry entry : c2172g0B.a.o()) {
            AbstractC18350oW3.a(entry.getKey());
            iH += C2172g0.h(null, entry.getValue());
        }
        return iJ + iH;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x008d. Please report as an issue. */
    final int n(Object obj, byte[] bArr, int i, int i2, int i3, H h) throws zzjk {
        Unsafe unsafe;
        int i4;
        F0 f0;
        int i5;
        Object obj2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        H h2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int iJ;
        int i18;
        int i19;
        int i20;
        int i21;
        F0 f02 = this;
        Object obj3 = obj;
        byte[] bArr2 = bArr;
        int i22 = i2;
        int i23 = i3;
        H h3 = h;
        Unsafe unsafe2 = s;
        int iA = i;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = -1;
        int i28 = 1048575;
        while (true) {
            if (iA < i22) {
                int i29 = iA + 1;
                byte b = bArr2[iA];
                if (b < 0) {
                    int iC = G.c(b, bArr2, i29, h3);
                    i6 = h3.a;
                    i29 = iC;
                } else {
                    i6 = b;
                }
                int i30 = i6 >>> 3;
                int i31 = i6 & 7;
                int iG = i30 > i27 ? f02.g(i30, i24 / 3) : f02.S(i30);
                if (iG == -1) {
                    i7 = i30;
                    i8 = i29;
                    i9 = i6;
                    i10 = i26;
                    unsafe = unsafe2;
                    i4 = i23;
                    i11 = 0;
                } else {
                    int[] iArr = f02.a;
                    int i32 = iArr[iG + 1];
                    int i33 = (i32 & 267386880) >>> 20;
                    int i34 = i6;
                    long j = i32 & 1048575;
                    if (i33 <= 17) {
                        int i35 = iArr[iG + 2];
                        int i36 = 1 << (i35 >>> 20);
                        int i37 = i35 & 1048575;
                        if (i37 != i28) {
                            if (i28 != 1048575) {
                                unsafe2.putInt(obj3, i28, i26);
                            }
                            i26 = unsafe2.getInt(obj3, i37);
                            i13 = i37;
                        } else {
                            i13 = i28;
                        }
                        int i38 = i26;
                        switch (i33) {
                            case 0:
                                i14 = i30;
                                i15 = i13;
                                i16 = i34;
                                bArr2 = bArr;
                                i17 = iG;
                                if (i31 == 1) {
                                    i1.f(obj3, j, G.l(bArr2, i29));
                                    iA = i29 + 8;
                                    i26 = i38 | i36;
                                    i28 = i15;
                                    i25 = i16;
                                    i27 = i14;
                                    i24 = i17;
                                    i22 = i2;
                                    i23 = i3;
                                    break;
                                } else {
                                    i8 = i29;
                                    i10 = i38;
                                    i9 = i16;
                                    unsafe = unsafe2;
                                    i11 = i17;
                                    i28 = i15;
                                    i4 = i3;
                                    i7 = i14;
                                    break;
                                }
                            case 1:
                                i14 = i30;
                                i15 = i13;
                                i16 = i34;
                                bArr2 = bArr;
                                i17 = iG;
                                if (i31 == 5) {
                                    i1.g(obj3, j, G.n(bArr2, i29));
                                    iA = i29 + 4;
                                    i26 = i38 | i36;
                                    i28 = i15;
                                    i25 = i16;
                                    i27 = i14;
                                    i24 = i17;
                                    i22 = i2;
                                    i23 = i3;
                                    break;
                                } else {
                                    i8 = i29;
                                    i10 = i38;
                                    i9 = i16;
                                    unsafe = unsafe2;
                                    i11 = i17;
                                    i28 = i15;
                                    i4 = i3;
                                    i7 = i14;
                                    break;
                                }
                            case 2:
                            case 3:
                                i14 = i30;
                                i15 = i13;
                                i16 = i34;
                                bArr2 = bArr;
                                i17 = iG;
                                if (i31 == 0) {
                                    iJ = G.j(bArr2, i29, h3);
                                    unsafe2.putLong(obj, j, h3.b);
                                    i26 = i38 | i36;
                                    i28 = i15;
                                    i25 = i16;
                                    iA = iJ;
                                    i27 = i14;
                                    i24 = i17;
                                    i22 = i2;
                                    i23 = i3;
                                    break;
                                } else {
                                    i8 = i29;
                                    i10 = i38;
                                    i9 = i16;
                                    unsafe = unsafe2;
                                    i11 = i17;
                                    i28 = i15;
                                    i4 = i3;
                                    i7 = i14;
                                    break;
                                }
                            case 4:
                            case 11:
                                i14 = i30;
                                i15 = i13;
                                i16 = i34;
                                bArr2 = bArr;
                                i17 = iG;
                                if (i31 == 0) {
                                    iA = G.h(bArr2, i29, h3);
                                    unsafe2.putInt(obj3, j, h3.a);
                                    i26 = i38 | i36;
                                    i28 = i15;
                                    i25 = i16;
                                    i27 = i14;
                                    i24 = i17;
                                    i22 = i2;
                                    i23 = i3;
                                    break;
                                } else {
                                    i8 = i29;
                                    i10 = i38;
                                    i9 = i16;
                                    unsafe = unsafe2;
                                    i11 = i17;
                                    i28 = i15;
                                    i4 = i3;
                                    i7 = i14;
                                    break;
                                }
                            case 5:
                            case 14:
                                i14 = i30;
                                i15 = i13;
                                i16 = i34;
                                bArr2 = bArr;
                                i17 = iG;
                                if (i31 == 1) {
                                    unsafe2.putLong(obj, j, G.k(bArr2, i29));
                                    iA = i29 + 8;
                                    i26 = i38 | i36;
                                    i28 = i15;
                                    i25 = i16;
                                    i27 = i14;
                                    i24 = i17;
                                    i22 = i2;
                                    i23 = i3;
                                    break;
                                } else {
                                    i8 = i29;
                                    i10 = i38;
                                    i9 = i16;
                                    unsafe = unsafe2;
                                    i11 = i17;
                                    i28 = i15;
                                    i4 = i3;
                                    i7 = i14;
                                    break;
                                }
                            case 6:
                            case 13:
                                i14 = i30;
                                i15 = i13;
                                i16 = i34;
                                bArr2 = bArr;
                                i17 = iG;
                                i18 = i2;
                                if (i31 == 5) {
                                    unsafe2.putInt(obj3, j, G.g(bArr2, i29));
                                    iA = i29 + 4;
                                    i26 = i38 | i36;
                                    i28 = i15;
                                    i25 = i16;
                                    i27 = i14;
                                    i23 = i3;
                                    int i39 = i17;
                                    i22 = i18;
                                    i24 = i39;
                                    break;
                                } else {
                                    i8 = i29;
                                    i10 = i38;
                                    i9 = i16;
                                    unsafe = unsafe2;
                                    i11 = i17;
                                    i28 = i15;
                                    i4 = i3;
                                    i7 = i14;
                                    break;
                                }
                            case 7:
                                i14 = i30;
                                i15 = i13;
                                i16 = i34;
                                bArr2 = bArr;
                                i17 = iG;
                                i18 = i2;
                                if (i31 == 0) {
                                    int iJ2 = G.j(bArr2, i29, h3);
                                    i1.k(obj3, j, h3.b != 0);
                                    i26 = i38 | i36;
                                    i28 = i15;
                                    iA = iJ2;
                                    i25 = i16;
                                    i27 = i14;
                                    i23 = i3;
                                    int i392 = i17;
                                    i22 = i18;
                                    i24 = i392;
                                    break;
                                } else {
                                    i8 = i29;
                                    i10 = i38;
                                    i9 = i16;
                                    unsafe = unsafe2;
                                    i11 = i17;
                                    i28 = i15;
                                    i4 = i3;
                                    i7 = i14;
                                    break;
                                }
                            case 8:
                                i14 = i30;
                                i15 = i13;
                                i16 = i34;
                                bArr2 = bArr;
                                i17 = iG;
                                i18 = i2;
                                if (i31 == 2) {
                                    iA = (i32 & 536870912) == 0 ? G.m(bArr2, i29, h3) : G.o(bArr2, i29, h3);
                                    unsafe2.putObject(obj3, j, h3.c);
                                    i26 = i38 | i36;
                                    i28 = i15;
                                    i25 = i16;
                                    i27 = i14;
                                    i23 = i3;
                                    int i3922 = i17;
                                    i22 = i18;
                                    i24 = i3922;
                                    break;
                                } else {
                                    i8 = i29;
                                    i10 = i38;
                                    i9 = i16;
                                    unsafe = unsafe2;
                                    i11 = i17;
                                    i28 = i15;
                                    i4 = i3;
                                    i7 = i14;
                                    break;
                                }
                            case 9:
                                i14 = i30;
                                i15 = i13;
                                i16 = i34;
                                bArr2 = bArr;
                                i17 = iG;
                                if (i31 == 2) {
                                    i18 = i2;
                                    iA = G.f(f02.p(i17), bArr2, i29, i18, h3);
                                    if ((i38 & i36) == 0) {
                                        unsafe2.putObject(obj3, j, h3.c);
                                    } else {
                                        unsafe2.putObject(obj3, j, AbstractC2184m0.e(unsafe2.getObject(obj3, j), h3.c));
                                    }
                                    i26 = i38 | i36;
                                    i28 = i15;
                                    i25 = i16;
                                    i27 = i14;
                                    i23 = i3;
                                    int i39222 = i17;
                                    i22 = i18;
                                    i24 = i39222;
                                    break;
                                } else {
                                    i8 = i29;
                                    i10 = i38;
                                    i9 = i16;
                                    unsafe = unsafe2;
                                    i11 = i17;
                                    i28 = i15;
                                    i4 = i3;
                                    i7 = i14;
                                    break;
                                }
                            case 10:
                                i14 = i30;
                                i15 = i13;
                                i16 = i34;
                                bArr2 = bArr;
                                i17 = iG;
                                if (i31 == 2) {
                                    iA = G.p(bArr2, i29, h3);
                                    unsafe2.putObject(obj3, j, h3.c);
                                    i26 = i38 | i36;
                                    i28 = i15;
                                    i25 = i16;
                                    i27 = i14;
                                    i24 = i17;
                                    i22 = i2;
                                    i23 = i3;
                                    break;
                                } else {
                                    i8 = i29;
                                    i10 = i38;
                                    i9 = i16;
                                    unsafe = unsafe2;
                                    i11 = i17;
                                    i28 = i15;
                                    i4 = i3;
                                    i7 = i14;
                                    break;
                                }
                            case 12:
                                i14 = i30;
                                i15 = i13;
                                i16 = i34;
                                bArr2 = bArr;
                                i17 = iG;
                                if (i31 != 0) {
                                    i8 = i29;
                                    i10 = i38;
                                    i9 = i16;
                                    unsafe = unsafe2;
                                    i11 = i17;
                                    i28 = i15;
                                    i4 = i3;
                                    i7 = i14;
                                    break;
                                } else {
                                    iA = G.h(bArr2, i29, h3);
                                    int i40 = h3.a;
                                    Oq8 oq8K = f02.K(i17);
                                    if (oq8K == null || oq8K.zza(i40)) {
                                        unsafe2.putInt(obj3, j, i40);
                                        i26 = i38 | i36;
                                        i28 = i15;
                                        i25 = i16;
                                        i27 = i14;
                                        i24 = i17;
                                        i22 = i2;
                                        i23 = i3;
                                        break;
                                    } else {
                                        Q(obj).c(i16, Long.valueOf(i40));
                                        i26 = i38;
                                        i25 = i16;
                                        i27 = i14;
                                        i24 = i17;
                                        i28 = i15;
                                        i22 = i2;
                                        i23 = i3;
                                    }
                                }
                                break;
                            case 15:
                                i14 = i30;
                                i15 = i13;
                                i16 = i34;
                                bArr2 = bArr;
                                i17 = iG;
                                if (i31 == 0) {
                                    iA = G.h(bArr2, i29, h3);
                                    unsafe2.putInt(obj3, j, W.d(h3.a));
                                    i26 = i38 | i36;
                                    i28 = i15;
                                    i25 = i16;
                                    i27 = i14;
                                    i24 = i17;
                                    i22 = i2;
                                    i23 = i3;
                                    break;
                                } else {
                                    i8 = i29;
                                    i10 = i38;
                                    i9 = i16;
                                    unsafe = unsafe2;
                                    i11 = i17;
                                    i28 = i15;
                                    i4 = i3;
                                    i7 = i14;
                                    break;
                                }
                            case 16:
                                i14 = i30;
                                i15 = i13;
                                i16 = i34;
                                if (i31 == 0) {
                                    bArr2 = bArr;
                                    iJ = G.j(bArr2, i29, h3);
                                    i17 = iG;
                                    unsafe2.putLong(obj, j, W.a(h3.b));
                                    i26 = i38 | i36;
                                    i28 = i15;
                                    i25 = i16;
                                    iA = iJ;
                                    i27 = i14;
                                    i24 = i17;
                                    i22 = i2;
                                    i23 = i3;
                                    break;
                                } else {
                                    i17 = iG;
                                    i8 = i29;
                                    i10 = i38;
                                    i9 = i16;
                                    unsafe = unsafe2;
                                    i11 = i17;
                                    i28 = i15;
                                    i4 = i3;
                                    i7 = i14;
                                    break;
                                }
                            case 17:
                                if (i31 == 3) {
                                    int i41 = i13;
                                    iA = G.e(f02.p(iG), bArr, i29, i2, (i30 << 3) | 4, h);
                                    if ((i38 & i36) == 0) {
                                        unsafe2.putObject(obj3, j, h3.c);
                                    } else {
                                        unsafe2.putObject(obj3, j, AbstractC2184m0.e(unsafe2.getObject(obj3, j), h3.c));
                                    }
                                    i26 = i38 | i36;
                                    bArr2 = bArr;
                                    i28 = i41;
                                    i22 = i2;
                                    i25 = i34;
                                    i24 = iG;
                                    i27 = i30;
                                    i23 = i3;
                                    break;
                                } else {
                                    i14 = i30;
                                    i15 = i13;
                                    i16 = i34;
                                    i17 = iG;
                                    i8 = i29;
                                    i10 = i38;
                                    i9 = i16;
                                    unsafe = unsafe2;
                                    i11 = i17;
                                    i28 = i15;
                                    i4 = i3;
                                    i7 = i14;
                                    break;
                                }
                            default:
                                i14 = i30;
                                i17 = iG;
                                i15 = i13;
                                i16 = i34;
                                i8 = i29;
                                i10 = i38;
                                i9 = i16;
                                unsafe = unsafe2;
                                i11 = i17;
                                i28 = i15;
                                i4 = i3;
                                i7 = i14;
                                break;
                        }
                    } else {
                        bArr2 = bArr;
                        if (i33 != 27) {
                            i10 = i26;
                            i19 = i28;
                            if (i33 <= 49) {
                                int i42 = i29;
                                i7 = i30;
                                i21 = i34;
                                unsafe = unsafe2;
                                i11 = iG;
                                iA = l(obj, bArr, i29, i2, i34, i7, i31, iG, i32, i33, j, h);
                                if (iA == i42) {
                                    i4 = i3;
                                    i8 = iA;
                                    i28 = i19;
                                    i9 = i21;
                                } else {
                                    f02 = this;
                                    obj3 = obj;
                                    bArr2 = bArr;
                                    i27 = i7;
                                    i22 = i2;
                                    i23 = i3;
                                    h3 = h;
                                    i24 = i11;
                                    i26 = i10;
                                    i28 = i19;
                                    i25 = i21;
                                    unsafe2 = unsafe;
                                }
                            } else {
                                i20 = i29;
                                i7 = i30;
                                i21 = i34;
                                unsafe = unsafe2;
                                i11 = iG;
                                if (i33 != 50) {
                                    iA = k(obj, bArr, i20, i2, i21, i7, i31, i32, i33, j, i11, h);
                                    if (iA != i20) {
                                        f02 = this;
                                        obj3 = obj;
                                        bArr2 = bArr;
                                        i22 = i2;
                                        h3 = h;
                                        i25 = i21;
                                        i27 = i7;
                                        i24 = i11;
                                        i26 = i10;
                                        i28 = i19;
                                        unsafe2 = unsafe;
                                        i23 = i3;
                                    }
                                } else if (i31 == 2) {
                                    iA = m(obj, bArr, i20, i2, i11, j, h);
                                    if (iA != i20) {
                                        f02 = this;
                                        obj3 = obj;
                                        bArr2 = bArr;
                                        i27 = i7;
                                        i22 = i2;
                                        i23 = i3;
                                        h3 = h;
                                        i24 = i11;
                                        i26 = i10;
                                        i28 = i19;
                                        i25 = i21;
                                        unsafe2 = unsafe;
                                    }
                                }
                                i4 = i3;
                                i8 = iA;
                                i28 = i19;
                                i9 = i21;
                            }
                        } else if (i31 == 2) {
                            Tq8 tq8Zza = (Tq8) unsafe2.getObject(obj3, j);
                            if (!tq8Zza.zza()) {
                                int size = tq8Zza.size();
                                tq8Zza = tq8Zza.zza(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(obj3, j, tq8Zza);
                            }
                            iA = G.d(f02.p(iG), i34, bArr, i29, i2, tq8Zza, h);
                            i25 = i34;
                            i27 = i30;
                            i24 = iG;
                            i26 = i26;
                            i28 = i28;
                            i22 = i2;
                            i23 = i3;
                        } else {
                            i10 = i26;
                            i19 = i28;
                            i20 = i29;
                            i7 = i30;
                            i21 = i34;
                            unsafe = unsafe2;
                            i11 = iG;
                        }
                        i4 = i3;
                        i8 = i20;
                        i28 = i19;
                        i9 = i21;
                    }
                }
                if (i9 != i4 || i4 == 0) {
                    if (this.f) {
                        h2 = h;
                        if (h2.d != C2162b0.b()) {
                            i12 = i7;
                            h2.d.a(this.e, i12);
                            iA = G.a(i9, bArr, i8, i2, Q(obj), h);
                            obj3 = obj;
                            bArr2 = bArr;
                            i22 = i2;
                            i25 = i9;
                            f02 = this;
                            h3 = h2;
                            i27 = i12;
                            i24 = i11;
                            i26 = i10;
                            unsafe2 = unsafe;
                            i23 = i4;
                        } else {
                            i12 = i7;
                        }
                    } else {
                        i12 = i7;
                        h2 = h;
                    }
                    iA = G.a(i9, bArr, i8, i2, Q(obj), h);
                    obj3 = obj;
                    bArr2 = bArr;
                    i22 = i2;
                    i25 = i9;
                    f02 = this;
                    h3 = h2;
                    i27 = i12;
                    i24 = i11;
                    i26 = i10;
                    unsafe2 = unsafe;
                    i23 = i4;
                } else {
                    i5 = 1048575;
                    f0 = this;
                    iA = i8;
                    i25 = i9;
                    i26 = i10;
                }
            } else {
                unsafe = unsafe2;
                i4 = i23;
                f0 = f02;
                i5 = 1048575;
            }
        }
        if (i28 != i5) {
            obj2 = obj;
            unsafe.putInt(obj2, i28, i26);
        } else {
            obj2 = obj;
        }
        h1 h1Var = null;
        for (int i43 = f0.k; i43 < f0.l; i43++) {
            h1Var = (h1) f0.r(obj2, f0.j[i43], h1Var, f0.o);
        }
        if (h1Var != null) {
            f0.o.h(obj2, h1Var);
        }
        if (i4 == 0) {
            if (iA != i2) {
                throw zzjk.e();
            }
        } else if (iA > i2 || i25 != i4) {
            throw zzjk.e();
        }
        return iA;
    }

    @Override // com.google.android.gms.internal.vision.P0
    public final Object zza() {
        return this.m.h(this.e);
    }
}
