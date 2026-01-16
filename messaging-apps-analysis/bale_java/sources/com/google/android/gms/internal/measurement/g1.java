package com.google.android.gms.internal.measurement;

import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.InterfaceC17970nr8;
import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Qr8;
import ir.nasim.Zq8;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
final class g1 implements o1 {
    private static final int[] p = new int[0];
    private static final Unsafe q = z1.l();
    private final int[] a;
    private final Object[] b;
    private final int c;
    private final int d;
    private final Qr8 e;
    private final boolean f;
    private final boolean g;
    private final int[] h;
    private final int i;
    private final int j;
    private final V0 k;
    private final s1 l;
    private final I0 m;
    private final i1 n;
    private final C2107b1 o;

    private g1(int[] iArr, Object[] objArr, int i, int i2, Qr8 qr8, boolean z, boolean z2, int[] iArr2, int i3, int i4, i1 i1Var, V0 v0, s1 s1Var, I0 i0, C2107b1 c2107b1, byte[] bArr) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.g = z;
        boolean z3 = false;
        if (i0 != null && i0.c(qr8)) {
            z3 = true;
        }
        this.f = z3;
        this.h = iArr2;
        this.i = i3;
        this.j = i4;
        this.n = i1Var;
        this.k = v0;
        this.l = s1Var;
        this.m = i0;
        this.e = qr8;
        this.o = c2107b1;
    }

    private final void A(F1 f1, int i, Object obj, int i2) {
        if (obj == null) {
            return;
        }
        AbstractC18350oW3.a(o(i2));
        throw null;
    }

    private final boolean B(Object obj, Object obj2, int i) {
        return C(obj, i) == C(obj2, i);
    }

    private final boolean C(Object obj, int i) {
        int iY = Y(i);
        long j = iY & 1048575;
        if (j != 1048575) {
            return (z1.h(obj, j) & (1 << (iY >>> 20))) != 0;
        }
        int iC = c(i);
        long j2 = iC & 1048575;
        switch (b(iC)) {
            case 0:
                return Double.doubleToRawLongBits(z1.f(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(z1.g(obj, j2)) != 0;
            case 2:
                return z1.i(obj, j2) != 0;
            case 3:
                return z1.i(obj, j2) != 0;
            case 4:
                return z1.h(obj, j2) != 0;
            case 5:
                return z1.i(obj, j2) != 0;
            case 6:
                return z1.h(obj, j2) != 0;
            case 7:
                return z1.B(obj, j2);
            case 8:
                Object objK = z1.k(obj, j2);
                if (objK instanceof String) {
                    return !((String) objK).isEmpty();
                }
                if (objK instanceof A0) {
                    return !A0.b.equals(objK);
                }
                throw new IllegalArgumentException();
            case 9:
                return z1.k(obj, j2) != null;
            case 10:
                return !A0.b.equals(z1.k(obj, j2));
            case 11:
                return z1.h(obj, j2) != 0;
            case 12:
                return z1.h(obj, j2) != 0;
            case 13:
                return z1.h(obj, j2) != 0;
            case 14:
                return z1.i(obj, j2) != 0;
            case 15:
                return z1.h(obj, j2) != 0;
            case 16:
                return z1.i(obj, j2) != 0;
            case 17:
                return z1.k(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean D(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? C(obj, i) : (i3 & i4) != 0;
    }

    private static boolean E(Object obj, int i, o1 o1Var) {
        return o1Var.a(z1.k(obj, i & 1048575));
    }

    private static boolean F(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof P0) {
            return ((P0) obj).u();
        }
        return true;
    }

    private final boolean G(Object obj, int i, int i2) {
        return z1.h(obj, (long) (Y(i2) & 1048575)) == i;
    }

    private static boolean H(Object obj, long j) {
        return ((Boolean) z1.k(obj, j)).booleanValue();
    }

    private static final void I(int i, Object obj, F1 f1) {
        if (obj instanceof String) {
            f1.i(i, (String) obj);
        } else {
            f1.k(i, (A0) obj);
        }
    }

    static t1 K(Object obj) {
        P0 p0 = (P0) obj;
        t1 t1Var = p0.zzc;
        if (t1Var != t1.c()) {
            return t1Var;
        }
        t1 t1VarF = t1.f();
        p0.zzc = t1VarF;
        return t1VarF;
    }

    static g1 L(Class cls, InterfaceC2113d1 interfaceC2113d1, i1 i1Var, V0 v0, s1 s1Var, I0 i0, C2107b1 c2107b1) {
        if (interfaceC2113d1 instanceof n1) {
            return M((n1) interfaceC2113d1, i1Var, v0, s1Var, i0, c2107b1);
        }
        AbstractC18350oW3.a(interfaceC2113d1);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0384  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.android.gms.internal.measurement.g1 M(com.google.android.gms.internal.measurement.n1 r34, com.google.android.gms.internal.measurement.i1 r35, com.google.android.gms.internal.measurement.V0 r36, com.google.android.gms.internal.measurement.s1 r37, com.google.android.gms.internal.measurement.I0 r38, com.google.android.gms.internal.measurement.C2107b1 r39) {
        /*
            Method dump skipped, instructions count: 1025
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.g1.M(com.google.android.gms.internal.measurement.n1, com.google.android.gms.internal.measurement.i1, com.google.android.gms.internal.measurement.V0, com.google.android.gms.internal.measurement.s1, com.google.android.gms.internal.measurement.I0, com.google.android.gms.internal.measurement.b1):com.google.android.gms.internal.measurement.g1");
    }

    private static double N(Object obj, long j) {
        return ((Double) z1.k(obj, j)).doubleValue();
    }

    private static float O(Object obj, long j) {
        return ((Float) z1.k(obj, j)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int P(Object obj) {
        int i;
        int iA;
        int iA2;
        int iA3;
        int iB;
        int iA4;
        int iZ;
        int iA5;
        int iA6;
        int iR;
        int iA7;
        int i2;
        int iW;
        boolean z;
        int iF;
        int iK;
        int iC;
        int iA8;
        int iA9;
        int iA10;
        int iA11;
        int iA12;
        int iB2;
        int iA13;
        int iR2;
        int iA14;
        int i3;
        Unsafe unsafe = q;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int iA15 = 0;
        int i7 = 0;
        while (i6 < this.a.length) {
            int iC2 = c(i6);
            int[] iArr = this.a;
            int i8 = iArr[i6];
            int iB3 = b(iC2);
            if (iB3 <= 17) {
                int i9 = iArr[i6 + 2];
                int i10 = i9 & i4;
                i = 1 << (i9 >>> 20);
                if (i10 != i5) {
                    i7 = unsafe.getInt(obj, i10);
                    i5 = i10;
                }
            } else {
                i = 0;
            }
            long j = iC2 & i4;
            switch (iB3) {
                case 0:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        iA = E0.a(i8 << 3);
                        iA5 = iA + 8;
                        iA15 += iA5;
                        break;
                    }
                case 1:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        iA2 = E0.a(i8 << 3);
                        iA5 = iA2 + 4;
                        iA15 += iA5;
                        break;
                    }
                case 2:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        long j2 = unsafe.getLong(obj, j);
                        iA3 = E0.a(i8 << 3);
                        iB = E0.b(j2);
                        iA15 += iA3 + iB;
                        break;
                    }
                case 3:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        long j3 = unsafe.getLong(obj, j);
                        iA3 = E0.a(i8 << 3);
                        iB = E0.b(j3);
                        iA15 += iA3 + iB;
                        break;
                    }
                case 4:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        int i11 = unsafe.getInt(obj, j);
                        iA4 = E0.a(i8 << 3);
                        iZ = E0.z(i11);
                        i2 = iA4 + iZ;
                        iA15 += i2;
                        break;
                    }
                case 5:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        iA = E0.a(i8 << 3);
                        iA5 = iA + 8;
                        iA15 += iA5;
                        break;
                    }
                case 6:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        iA2 = E0.a(i8 << 3);
                        iA5 = iA2 + 4;
                        iA15 += iA5;
                        break;
                    }
                case 7:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        iA5 = E0.a(i8 << 3) + 1;
                        iA15 += iA5;
                        break;
                    }
                case 8:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof A0) {
                            iA6 = E0.a(i8 << 3);
                            iR = ((A0) object).r();
                            iA7 = E0.a(iR);
                            i2 = iA6 + iA7 + iR;
                            iA15 += i2;
                            break;
                        } else {
                            iA4 = E0.a(i8 << 3);
                            iZ = E0.B((String) object);
                            i2 = iA4 + iZ;
                            iA15 += i2;
                        }
                    }
                case 9:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        iA5 = q1.Q(i8, unsafe.getObject(obj, j), f(i6));
                        iA15 += iA5;
                        break;
                    }
                case 10:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        A0 a0 = (A0) unsafe.getObject(obj, j);
                        iA6 = E0.a(i8 << 3);
                        iR = a0.r();
                        iA7 = E0.a(iR);
                        i2 = iA6 + iA7 + iR;
                        iA15 += i2;
                        break;
                    }
                case 11:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        int i12 = unsafe.getInt(obj, j);
                        iA4 = E0.a(i8 << 3);
                        iZ = E0.a(i12);
                        i2 = iA4 + iZ;
                        iA15 += i2;
                        break;
                    }
                case 12:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        int i13 = unsafe.getInt(obj, j);
                        iA4 = E0.a(i8 << 3);
                        iZ = E0.z(i13);
                        i2 = iA4 + iZ;
                        iA15 += i2;
                        break;
                    }
                case 13:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        iA2 = E0.a(i8 << 3);
                        iA5 = iA2 + 4;
                        iA15 += iA5;
                        break;
                    }
                case 14:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        iA = E0.a(i8 << 3);
                        iA5 = iA + 8;
                        iA15 += iA5;
                        break;
                    }
                case 15:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        int i14 = unsafe.getInt(obj, j);
                        iA4 = E0.a(i8 << 3);
                        iZ = E0.a((i14 >> 31) ^ (i14 + i14));
                        i2 = iA4 + iZ;
                        iA15 += i2;
                        break;
                    }
                case 16:
                    if ((i & i7) == 0) {
                        break;
                    } else {
                        long j4 = unsafe.getLong(obj, j);
                        iA15 += E0.a(i8 << 3) + E0.b((j4 >> 63) ^ (j4 + j4));
                        break;
                    }
                case 17:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        iA5 = E0.y(i8, (Qr8) unsafe.getObject(obj, j), f(i6));
                        iA15 += iA5;
                        break;
                    }
                case 18:
                    iA5 = q1.J(i8, (List) unsafe.getObject(obj, j), false);
                    iA15 += iA5;
                    break;
                case 19:
                    iA5 = q1.H(i8, (List) unsafe.getObject(obj, j), false);
                    iA15 += iA5;
                    break;
                case 20:
                    iA5 = q1.O(i8, (List) unsafe.getObject(obj, j), false);
                    iA15 += iA5;
                    break;
                case 21:
                    iA5 = q1.Z(i8, (List) unsafe.getObject(obj, j), false);
                    iA15 += iA5;
                    break;
                case 22:
                    iA5 = q1.M(i8, (List) unsafe.getObject(obj, j), false);
                    iA15 += iA5;
                    break;
                case 23:
                    iA5 = q1.J(i8, (List) unsafe.getObject(obj, j), false);
                    iA15 += iA5;
                    break;
                case 24:
                    iA5 = q1.H(i8, (List) unsafe.getObject(obj, j), false);
                    iA15 += iA5;
                    break;
                case 25:
                    iA5 = q1.A(i8, (List) unsafe.getObject(obj, j), false);
                    iA15 += iA5;
                    break;
                case 26:
                    iW = q1.W(i8, (List) unsafe.getObject(obj, j));
                    iA15 += iW;
                    break;
                case 27:
                    iW = q1.R(i8, (List) unsafe.getObject(obj, j), f(i6));
                    iA15 += iW;
                    break;
                case 28:
                    iW = q1.E(i8, (List) unsafe.getObject(obj, j));
                    iA15 += iW;
                    break;
                case 29:
                    iW = q1.X(i8, (List) unsafe.getObject(obj, j), false);
                    iA15 += iW;
                    break;
                case 30:
                    z = false;
                    iF = q1.F(i8, (List) unsafe.getObject(obj, j), false);
                    iA15 += iF;
                    break;
                case 31:
                    z = false;
                    iF = q1.H(i8, (List) unsafe.getObject(obj, j), false);
                    iA15 += iF;
                    break;
                case 32:
                    z = false;
                    iF = q1.J(i8, (List) unsafe.getObject(obj, j), false);
                    iA15 += iF;
                    break;
                case 33:
                    z = false;
                    iF = q1.S(i8, (List) unsafe.getObject(obj, j), false);
                    iA15 += iF;
                    break;
                case 34:
                    z = false;
                    iF = q1.U(i8, (List) unsafe.getObject(obj, j), false);
                    iA15 += iF;
                    break;
                case 35:
                    iK = q1.K((List) unsafe.getObject(obj, j));
                    if (iK > 0) {
                        iC = E0.C(i8);
                        iA8 = E0.a(iK);
                        iA9 = iC + iA8;
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 36:
                    iK = q1.I((List) unsafe.getObject(obj, j));
                    if (iK > 0) {
                        iC = E0.C(i8);
                        iA8 = E0.a(iK);
                        iA9 = iC + iA8;
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 37:
                    iK = q1.P((List) unsafe.getObject(obj, j));
                    if (iK > 0) {
                        iC = E0.C(i8);
                        iA8 = E0.a(iK);
                        iA9 = iC + iA8;
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 38:
                    iK = q1.a0((List) unsafe.getObject(obj, j));
                    if (iK > 0) {
                        iC = E0.C(i8);
                        iA8 = E0.a(iK);
                        iA9 = iC + iA8;
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 39:
                    iK = q1.N((List) unsafe.getObject(obj, j));
                    if (iK > 0) {
                        iC = E0.C(i8);
                        iA8 = E0.a(iK);
                        iA9 = iC + iA8;
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 40:
                    iK = q1.K((List) unsafe.getObject(obj, j));
                    if (iK > 0) {
                        iC = E0.C(i8);
                        iA8 = E0.a(iK);
                        iA9 = iC + iA8;
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 41:
                    iK = q1.I((List) unsafe.getObject(obj, j));
                    if (iK > 0) {
                        iC = E0.C(i8);
                        iA8 = E0.a(iK);
                        iA9 = iC + iA8;
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 42:
                    iK = q1.D((List) unsafe.getObject(obj, j));
                    if (iK > 0) {
                        iC = E0.C(i8);
                        iA8 = E0.a(iK);
                        iA9 = iC + iA8;
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 43:
                    iK = q1.Y((List) unsafe.getObject(obj, j));
                    if (iK > 0) {
                        iC = E0.C(i8);
                        iA8 = E0.a(iK);
                        iA9 = iC + iA8;
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 44:
                    iK = q1.G((List) unsafe.getObject(obj, j));
                    if (iK > 0) {
                        iC = E0.C(i8);
                        iA8 = E0.a(iK);
                        iA9 = iC + iA8;
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 45:
                    iK = q1.I((List) unsafe.getObject(obj, j));
                    if (iK > 0) {
                        iC = E0.C(i8);
                        iA8 = E0.a(iK);
                        iA9 = iC + iA8;
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 46:
                    iK = q1.K((List) unsafe.getObject(obj, j));
                    if (iK > 0) {
                        iC = E0.C(i8);
                        iA8 = E0.a(iK);
                        iA9 = iC + iA8;
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 47:
                    iK = q1.T((List) unsafe.getObject(obj, j));
                    if (iK > 0) {
                        iC = E0.C(i8);
                        iA8 = E0.a(iK);
                        iA9 = iC + iA8;
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 48:
                    iK = q1.V((List) unsafe.getObject(obj, j));
                    if (iK > 0) {
                        iC = E0.C(i8);
                        iA8 = E0.a(iK);
                        iA9 = iC + iA8;
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 49:
                    iW = q1.L(i8, (List) unsafe.getObject(obj, j), f(i6));
                    iA15 += iW;
                    break;
                case 50:
                    C2107b1.a(i8, unsafe.getObject(obj, j), o(i6));
                    break;
                case 51:
                    if (G(obj, i8, i6)) {
                        iA10 = E0.a(i8 << 3);
                        iW = iA10 + 8;
                        iA15 += iW;
                    }
                    break;
                case Type.TLSA /* 52 */:
                    if (G(obj, i8, i6)) {
                        iA11 = E0.a(i8 << 3);
                        iW = iA11 + 4;
                        iA15 += iW;
                    }
                    break;
                case 53:
                    if (G(obj, i8, i6)) {
                        long jD = d(obj, j);
                        iA12 = E0.a(i8 << 3);
                        iB2 = E0.b(jD);
                        iA15 += iA12 + iB2;
                    }
                    break;
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (G(obj, i8, i6)) {
                        long jD2 = d(obj, j);
                        iA12 = E0.a(i8 << 3);
                        iB2 = E0.b(jD2);
                        iA15 += iA12 + iB2;
                    }
                    break;
                case 55:
                    if (G(obj, i8, i6)) {
                        int iR3 = R(obj, j);
                        iA9 = E0.a(i8 << 3);
                        iK = E0.z(iR3);
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case Type.NINFO /* 56 */:
                    if (G(obj, i8, i6)) {
                        iA10 = E0.a(i8 << 3);
                        iW = iA10 + 8;
                        iA15 += iW;
                    }
                    break;
                case 57:
                    if (G(obj, i8, i6)) {
                        iA11 = E0.a(i8 << 3);
                        iW = iA11 + 4;
                        iA15 += iW;
                    }
                    break;
                case 58:
                    if (G(obj, i8, i6)) {
                        iW = E0.a(i8 << 3) + 1;
                        iA15 += iW;
                    }
                    break;
                case 59:
                    if (G(obj, i8, i6)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof A0) {
                            iA13 = E0.a(i8 << 3);
                            iR2 = ((A0) object2).r();
                            iA14 = E0.a(iR2);
                            i3 = iA13 + iA14 + iR2;
                            iA15 += i3;
                        } else {
                            iA9 = E0.a(i8 << 3);
                            iK = E0.B((String) object2);
                            i3 = iA9 + iK;
                            iA15 += i3;
                        }
                    }
                    break;
                case 60:
                    if (G(obj, i8, i6)) {
                        iW = q1.Q(i8, unsafe.getObject(obj, j), f(i6));
                        iA15 += iW;
                    }
                    break;
                case 61:
                    if (G(obj, i8, i6)) {
                        A0 a02 = (A0) unsafe.getObject(obj, j);
                        iA13 = E0.a(i8 << 3);
                        iR2 = a02.r();
                        iA14 = E0.a(iR2);
                        i3 = iA13 + iA14 + iR2;
                        iA15 += i3;
                    }
                    break;
                case 62:
                    if (G(obj, i8, i6)) {
                        int iR4 = R(obj, j);
                        iA9 = E0.a(i8 << 3);
                        iK = E0.a(iR4);
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 63:
                    if (G(obj, i8, i6)) {
                        int iR5 = R(obj, j);
                        iA9 = E0.a(i8 << 3);
                        iK = E0.z(iR5);
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 64:
                    if (G(obj, i8, i6)) {
                        iA11 = E0.a(i8 << 3);
                        iW = iA11 + 4;
                        iA15 += iW;
                    }
                    break;
                case 65:
                    if (G(obj, i8, i6)) {
                        iA10 = E0.a(i8 << 3);
                        iW = iA10 + 8;
                        iA15 += iW;
                    }
                    break;
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (G(obj, i8, i6)) {
                        int iR6 = R(obj, j);
                        iA9 = E0.a(i8 << 3);
                        iK = E0.a((iR6 >> 31) ^ (iR6 + iR6));
                        i3 = iA9 + iK;
                        iA15 += i3;
                    }
                    break;
                case 67:
                    if (G(obj, i8, i6)) {
                        long jD3 = d(obj, j);
                        iA15 += E0.a(i8 << 3) + E0.b((jD3 >> 63) ^ (jD3 + jD3));
                    }
                    break;
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (G(obj, i8, i6)) {
                        iW = E0.y(i8, (Qr8) unsafe.getObject(obj, j), f(i6));
                        iA15 += iW;
                    }
                    break;
            }
            i6 += 3;
            i4 = 1048575;
        }
        s1 s1Var = this.l;
        int iA16 = iA15 + s1Var.a(s1Var.d(obj));
        if (!this.f) {
            return iA16;
        }
        this.m.a(obj);
        throw null;
    }

    private final int Q(Object obj) {
        int iA;
        int iA2;
        int iA3;
        int iB;
        int iA4;
        int iZ;
        int iA5;
        int iA6;
        int iR;
        int iA7;
        int iQ;
        int iC;
        int iA8;
        int i;
        Unsafe unsafe = q;
        int i2 = 0;
        for (int i3 = 0; i3 < this.a.length; i3 += 3) {
            int iC2 = c(i3);
            int iB2 = b(iC2);
            int i4 = this.a[i3];
            long j = iC2 & 1048575;
            if (iB2 >= Zq8.D0.zza() && iB2 <= Zq8.Q0.zza()) {
                int i5 = this.a[i3 + 2];
            }
            switch (iB2) {
                case 0:
                    if (C(obj, i3)) {
                        iA = E0.a(i4 << 3);
                        iQ = iA + 8;
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (C(obj, i3)) {
                        iA2 = E0.a(i4 << 3);
                        iQ = iA2 + 4;
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (C(obj, i3)) {
                        long jI = z1.i(obj, j);
                        iA3 = E0.a(i4 << 3);
                        iB = E0.b(jI);
                        i2 += iA3 + iB;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (C(obj, i3)) {
                        long jI2 = z1.i(obj, j);
                        iA3 = E0.a(i4 << 3);
                        iB = E0.b(jI2);
                        i2 += iA3 + iB;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (C(obj, i3)) {
                        int iH = z1.h(obj, j);
                        iA4 = E0.a(i4 << 3);
                        iZ = E0.z(iH);
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (C(obj, i3)) {
                        iA = E0.a(i4 << 3);
                        iQ = iA + 8;
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (C(obj, i3)) {
                        iA2 = E0.a(i4 << 3);
                        iQ = iA2 + 4;
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (C(obj, i3)) {
                        iA5 = E0.a(i4 << 3);
                        iQ = iA5 + 1;
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!C(obj, i3)) {
                        break;
                    } else {
                        Object objK = z1.k(obj, j);
                        if (objK instanceof A0) {
                            iA6 = E0.a(i4 << 3);
                            iR = ((A0) objK).r();
                            iA7 = E0.a(iR);
                            i = iA6 + iA7 + iR;
                            i2 += i;
                            break;
                        } else {
                            iA4 = E0.a(i4 << 3);
                            iZ = E0.B((String) objK);
                            i = iA4 + iZ;
                            i2 += i;
                        }
                    }
                case 9:
                    if (C(obj, i3)) {
                        iQ = q1.Q(i4, z1.k(obj, j), f(i3));
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (C(obj, i3)) {
                        A0 a0 = (A0) z1.k(obj, j);
                        iA6 = E0.a(i4 << 3);
                        iR = a0.r();
                        iA7 = E0.a(iR);
                        i = iA6 + iA7 + iR;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (C(obj, i3)) {
                        int iH2 = z1.h(obj, j);
                        iA4 = E0.a(i4 << 3);
                        iZ = E0.a(iH2);
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (C(obj, i3)) {
                        int iH3 = z1.h(obj, j);
                        iA4 = E0.a(i4 << 3);
                        iZ = E0.z(iH3);
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (C(obj, i3)) {
                        iA2 = E0.a(i4 << 3);
                        iQ = iA2 + 4;
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (C(obj, i3)) {
                        iA = E0.a(i4 << 3);
                        iQ = iA + 8;
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (C(obj, i3)) {
                        int iH4 = z1.h(obj, j);
                        iA4 = E0.a(i4 << 3);
                        iZ = E0.a((iH4 >> 31) ^ (iH4 + iH4));
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (C(obj, i3)) {
                        long jI3 = z1.i(obj, j);
                        iA4 = E0.a(i4 << 3);
                        iZ = E0.b((jI3 >> 63) ^ (jI3 + jI3));
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (C(obj, i3)) {
                        iQ = E0.y(i4, (Qr8) z1.k(obj, j), f(i3));
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iQ = q1.J(i4, (List) z1.k(obj, j), false);
                    i2 += iQ;
                    break;
                case 19:
                    iQ = q1.H(i4, (List) z1.k(obj, j), false);
                    i2 += iQ;
                    break;
                case 20:
                    iQ = q1.O(i4, (List) z1.k(obj, j), false);
                    i2 += iQ;
                    break;
                case 21:
                    iQ = q1.Z(i4, (List) z1.k(obj, j), false);
                    i2 += iQ;
                    break;
                case 22:
                    iQ = q1.M(i4, (List) z1.k(obj, j), false);
                    i2 += iQ;
                    break;
                case 23:
                    iQ = q1.J(i4, (List) z1.k(obj, j), false);
                    i2 += iQ;
                    break;
                case 24:
                    iQ = q1.H(i4, (List) z1.k(obj, j), false);
                    i2 += iQ;
                    break;
                case 25:
                    iQ = q1.A(i4, (List) z1.k(obj, j), false);
                    i2 += iQ;
                    break;
                case 26:
                    iQ = q1.W(i4, (List) z1.k(obj, j));
                    i2 += iQ;
                    break;
                case 27:
                    iQ = q1.R(i4, (List) z1.k(obj, j), f(i3));
                    i2 += iQ;
                    break;
                case 28:
                    iQ = q1.E(i4, (List) z1.k(obj, j));
                    i2 += iQ;
                    break;
                case 29:
                    iQ = q1.X(i4, (List) z1.k(obj, j), false);
                    i2 += iQ;
                    break;
                case 30:
                    iQ = q1.F(i4, (List) z1.k(obj, j), false);
                    i2 += iQ;
                    break;
                case 31:
                    iQ = q1.H(i4, (List) z1.k(obj, j), false);
                    i2 += iQ;
                    break;
                case 32:
                    iQ = q1.J(i4, (List) z1.k(obj, j), false);
                    i2 += iQ;
                    break;
                case 33:
                    iQ = q1.S(i4, (List) z1.k(obj, j), false);
                    i2 += iQ;
                    break;
                case 34:
                    iQ = q1.U(i4, (List) z1.k(obj, j), false);
                    i2 += iQ;
                    break;
                case 35:
                    iZ = q1.K((List) unsafe.getObject(obj, j));
                    if (iZ > 0) {
                        iC = E0.C(i4);
                        iA8 = E0.a(iZ);
                        iA4 = iC + iA8;
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    iZ = q1.I((List) unsafe.getObject(obj, j));
                    if (iZ > 0) {
                        iC = E0.C(i4);
                        iA8 = E0.a(iZ);
                        iA4 = iC + iA8;
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    iZ = q1.P((List) unsafe.getObject(obj, j));
                    if (iZ > 0) {
                        iC = E0.C(i4);
                        iA8 = E0.a(iZ);
                        iA4 = iC + iA8;
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    iZ = q1.a0((List) unsafe.getObject(obj, j));
                    if (iZ > 0) {
                        iC = E0.C(i4);
                        iA8 = E0.a(iZ);
                        iA4 = iC + iA8;
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    iZ = q1.N((List) unsafe.getObject(obj, j));
                    if (iZ > 0) {
                        iC = E0.C(i4);
                        iA8 = E0.a(iZ);
                        iA4 = iC + iA8;
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    iZ = q1.K((List) unsafe.getObject(obj, j));
                    if (iZ > 0) {
                        iC = E0.C(i4);
                        iA8 = E0.a(iZ);
                        iA4 = iC + iA8;
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    iZ = q1.I((List) unsafe.getObject(obj, j));
                    if (iZ > 0) {
                        iC = E0.C(i4);
                        iA8 = E0.a(iZ);
                        iA4 = iC + iA8;
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    iZ = q1.D((List) unsafe.getObject(obj, j));
                    if (iZ > 0) {
                        iC = E0.C(i4);
                        iA8 = E0.a(iZ);
                        iA4 = iC + iA8;
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    iZ = q1.Y((List) unsafe.getObject(obj, j));
                    if (iZ > 0) {
                        iC = E0.C(i4);
                        iA8 = E0.a(iZ);
                        iA4 = iC + iA8;
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    iZ = q1.G((List) unsafe.getObject(obj, j));
                    if (iZ > 0) {
                        iC = E0.C(i4);
                        iA8 = E0.a(iZ);
                        iA4 = iC + iA8;
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    iZ = q1.I((List) unsafe.getObject(obj, j));
                    if (iZ > 0) {
                        iC = E0.C(i4);
                        iA8 = E0.a(iZ);
                        iA4 = iC + iA8;
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    iZ = q1.K((List) unsafe.getObject(obj, j));
                    if (iZ > 0) {
                        iC = E0.C(i4);
                        iA8 = E0.a(iZ);
                        iA4 = iC + iA8;
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    iZ = q1.T((List) unsafe.getObject(obj, j));
                    if (iZ > 0) {
                        iC = E0.C(i4);
                        iA8 = E0.a(iZ);
                        iA4 = iC + iA8;
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    iZ = q1.V((List) unsafe.getObject(obj, j));
                    if (iZ > 0) {
                        iC = E0.C(i4);
                        iA8 = E0.a(iZ);
                        iA4 = iC + iA8;
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    iQ = q1.L(i4, (List) z1.k(obj, j), f(i3));
                    i2 += iQ;
                    break;
                case 50:
                    C2107b1.a(i4, z1.k(obj, j), o(i3));
                    break;
                case 51:
                    if (G(obj, i4, i3)) {
                        iA = E0.a(i4 << 3);
                        iQ = iA + 8;
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case Type.TLSA /* 52 */:
                    if (G(obj, i4, i3)) {
                        iA2 = E0.a(i4 << 3);
                        iQ = iA2 + 4;
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (G(obj, i4, i3)) {
                        long jD = d(obj, j);
                        iA3 = E0.a(i4 << 3);
                        iB = E0.b(jD);
                        i2 += iA3 + iB;
                        break;
                    } else {
                        break;
                    }
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (G(obj, i4, i3)) {
                        long jD2 = d(obj, j);
                        iA3 = E0.a(i4 << 3);
                        iB = E0.b(jD2);
                        i2 += iA3 + iB;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (G(obj, i4, i3)) {
                        int iR2 = R(obj, j);
                        iA4 = E0.a(i4 << 3);
                        iZ = E0.z(iR2);
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case Type.NINFO /* 56 */:
                    if (G(obj, i4, i3)) {
                        iA = E0.a(i4 << 3);
                        iQ = iA + 8;
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (G(obj, i4, i3)) {
                        iA2 = E0.a(i4 << 3);
                        iQ = iA2 + 4;
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (G(obj, i4, i3)) {
                        iA5 = E0.a(i4 << 3);
                        iQ = iA5 + 1;
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!G(obj, i4, i3)) {
                        break;
                    } else {
                        Object objK2 = z1.k(obj, j);
                        if (objK2 instanceof A0) {
                            iA6 = E0.a(i4 << 3);
                            iR = ((A0) objK2).r();
                            iA7 = E0.a(iR);
                            i = iA6 + iA7 + iR;
                            i2 += i;
                            break;
                        } else {
                            iA4 = E0.a(i4 << 3);
                            iZ = E0.B((String) objK2);
                            i = iA4 + iZ;
                            i2 += i;
                        }
                    }
                case 60:
                    if (G(obj, i4, i3)) {
                        iQ = q1.Q(i4, z1.k(obj, j), f(i3));
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (G(obj, i4, i3)) {
                        A0 a02 = (A0) z1.k(obj, j);
                        iA6 = E0.a(i4 << 3);
                        iR = a02.r();
                        iA7 = E0.a(iR);
                        i = iA6 + iA7 + iR;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (G(obj, i4, i3)) {
                        int iR3 = R(obj, j);
                        iA4 = E0.a(i4 << 3);
                        iZ = E0.a(iR3);
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (G(obj, i4, i3)) {
                        int iR4 = R(obj, j);
                        iA4 = E0.a(i4 << 3);
                        iZ = E0.z(iR4);
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (G(obj, i4, i3)) {
                        iA2 = E0.a(i4 << 3);
                        iQ = iA2 + 4;
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (G(obj, i4, i3)) {
                        iA = E0.a(i4 << 3);
                        iQ = iA + 8;
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (G(obj, i4, i3)) {
                        int iR5 = R(obj, j);
                        iA4 = E0.a(i4 << 3);
                        iZ = E0.a((iR5 >> 31) ^ (iR5 + iR5));
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (G(obj, i4, i3)) {
                        long jD3 = d(obj, j);
                        iA4 = E0.a(i4 << 3);
                        iZ = E0.b((jD3 >> 63) ^ (jD3 + jD3));
                        i = iA4 + iZ;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (G(obj, i4, i3)) {
                        iQ = E0.y(i4, (Qr8) z1.k(obj, j), f(i3));
                        i2 += iQ;
                        break;
                    } else {
                        break;
                    }
            }
        }
        s1 s1Var = this.l;
        return i2 + s1Var.a(s1Var.d(obj));
    }

    private static int R(Object obj, long j) {
        return ((Integer) z1.k(obj, j)).intValue();
    }

    private final int S(Object obj, byte[] bArr, int i, int i2, int i3, long j, C2142r0 c2142r0) {
        Unsafe unsafe = q;
        Object objO = o(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((C2104a1) object).f()) {
            C2104a1 c2104a1C = C2104a1.b().c();
            C2107b1.b(c2104a1C, object);
            unsafe.putObject(obj, j, c2104a1C);
        }
        AbstractC18350oW3.a(objO);
        throw null;
    }

    private final int T(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, C2142r0 c2142r0) throws zzkp {
        Unsafe unsafe = q;
        long j2 = this.a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(AbstractC2144s0.p(bArr, i))));
                    unsafe.putInt(obj, j2, i4);
                    return i + 8;
                }
                break;
            case Type.TLSA /* 52 */:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(AbstractC2144s0.b(bArr, i))));
                    unsafe.putInt(obj, j2, i4);
                    return i + 4;
                }
                break;
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                if (i5 == 0) {
                    int iM = AbstractC2144s0.m(bArr, i, c2142r0);
                    unsafe.putObject(obj, j, Long.valueOf(c2142r0.b));
                    unsafe.putInt(obj, j2, i4);
                    return iM;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int iJ = AbstractC2144s0.j(bArr, i, c2142r0);
                    unsafe.putObject(obj, j, Integer.valueOf(c2142r0.a));
                    unsafe.putInt(obj, j2, i4);
                    return iJ;
                }
                break;
            case Type.NINFO /* 56 */:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Long.valueOf(AbstractC2144s0.p(bArr, i)));
                    unsafe.putInt(obj, j2, i4);
                    return i + 8;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Integer.valueOf(AbstractC2144s0.b(bArr, i)));
                    unsafe.putInt(obj, j2, i4);
                    return i + 4;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int iM2 = AbstractC2144s0.m(bArr, i, c2142r0);
                    unsafe.putObject(obj, j, Boolean.valueOf(c2142r0.b != 0));
                    unsafe.putInt(obj, j2, i4);
                    return iM2;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int iJ2 = AbstractC2144s0.j(bArr, i, c2142r0);
                    int i9 = c2142r0.a;
                    if (i9 == 0) {
                        unsafe.putObject(obj, j, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !E1.f(bArr, iJ2, iJ2 + i9)) {
                            throw zzkp.c();
                        }
                        unsafe.putObject(obj, j, new String(bArr, iJ2, i9, R0.b));
                        iJ2 += i9;
                    }
                    unsafe.putInt(obj, j2, i4);
                    return iJ2;
                }
                break;
            case 60:
                if (i5 == 2) {
                    Object objQ = q(obj, i4, i8);
                    int iO = AbstractC2144s0.o(objQ, f(i8), bArr, i, i2, c2142r0);
                    y(obj, i4, i8, objQ);
                    return iO;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int iA = AbstractC2144s0.a(bArr, i, c2142r0);
                    unsafe.putObject(obj, j, c2142r0.c);
                    unsafe.putInt(obj, j2, i4);
                    return iA;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int iJ3 = AbstractC2144s0.j(bArr, i, c2142r0);
                    int i10 = c2142r0.a;
                    InterfaceC17970nr8 interfaceC17970nr8E = e(i8);
                    if (interfaceC17970nr8E == null || interfaceC17970nr8E.zza(i10)) {
                        unsafe.putObject(obj, j, Integer.valueOf(i10));
                        unsafe.putInt(obj, j2, i4);
                    } else {
                        K(obj).j(i3, Long.valueOf(i10));
                    }
                    return iJ3;
                }
                break;
            case WKSRecord.Protocol.RVD /* 66 */:
                if (i5 == 0) {
                    int iJ4 = AbstractC2144s0.j(bArr, i, c2142r0);
                    unsafe.putObject(obj, j, Integer.valueOf(C0.a(c2142r0.a)));
                    unsafe.putInt(obj, j2, i4);
                    return iJ4;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int iM3 = AbstractC2144s0.m(bArr, i, c2142r0);
                    unsafe.putObject(obj, j, Long.valueOf(C0.b(c2142r0.b)));
                    unsafe.putInt(obj, j2, i4);
                    return iM3;
                }
                break;
            case WKSRecord.Service.BOOTPC /* 68 */:
                if (i5 == 3) {
                    Object objQ2 = q(obj, i4, i8);
                    int iN = AbstractC2144s0.n(objQ2, f(i8), bArr, i, i2, (i3 & (-8)) | 4, c2142r0);
                    y(obj, i4, i8, objQ2);
                    return iN;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x029b, code lost:
    
        if (r0 != r15) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x029d, code lost:
    
        r15 = r29;
        r14 = r30;
        r12 = r31;
        r13 = r33;
        r11 = r34;
        r8 = r18;
        r2 = r19;
        r1 = r23;
        r7 = r26;
        r6 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02b5, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02e6, code lost:
    
        if (r0 != r15) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0306, code lost:
    
        if (r0 != r15) goto L101;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0087. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int U(java.lang.Object r30, byte[] r31, int r32, int r33, com.google.android.gms.internal.measurement.C2142r0 r34) throws com.google.android.gms.internal.measurement.zzkp {
        /*
            Method dump skipped, instructions count: 876
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.g1.U(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.r0):int");
    }

    private final int V(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, C2142r0 c2142r0) throws zzkp {
        int i8;
        int i9;
        int iL;
        int iJ = i;
        Unsafe unsafe = q;
        InterfaceC20943sr8 interfaceC20943sr8K = (InterfaceC20943sr8) unsafe.getObject(obj, j2);
        if (!interfaceC20943sr8K.e()) {
            int size = interfaceC20943sr8K.size();
            interfaceC20943sr8K = interfaceC20943sr8K.K(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, interfaceC20943sr8K);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    AbstractC18350oW3.a(interfaceC20943sr8K);
                    int iJ2 = AbstractC2144s0.j(bArr, iJ, c2142r0);
                    int i10 = c2142r0.a + iJ2;
                    if (iJ2 < i10) {
                        Double.longBitsToDouble(AbstractC2144s0.p(bArr, iJ2));
                        throw null;
                    }
                    if (iJ2 == i10) {
                        return iJ2;
                    }
                    throw zzkp.f();
                }
                if (i5 == 1) {
                    AbstractC18350oW3.a(interfaceC20943sr8K);
                    Double.longBitsToDouble(AbstractC2144s0.p(bArr, i));
                    throw null;
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    AbstractC18350oW3.a(interfaceC20943sr8K);
                    int iJ3 = AbstractC2144s0.j(bArr, iJ, c2142r0);
                    int i11 = c2142r0.a + iJ3;
                    if (iJ3 < i11) {
                        Float.intBitsToFloat(AbstractC2144s0.b(bArr, iJ3));
                        throw null;
                    }
                    if (iJ3 == i11) {
                        return iJ3;
                    }
                    throw zzkp.f();
                }
                if (i5 == 5) {
                    AbstractC18350oW3.a(interfaceC20943sr8K);
                    Float.intBitsToFloat(AbstractC2144s0.b(bArr, i));
                    throw null;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    W0 w0 = (W0) interfaceC20943sr8K;
                    int iJ4 = AbstractC2144s0.j(bArr, iJ, c2142r0);
                    int i12 = c2142r0.a + iJ4;
                    while (iJ4 < i12) {
                        iJ4 = AbstractC2144s0.m(bArr, iJ4, c2142r0);
                        w0.i(c2142r0.b);
                    }
                    if (iJ4 == i12) {
                        return iJ4;
                    }
                    throw zzkp.f();
                }
                if (i5 == 0) {
                    W0 w02 = (W0) interfaceC20943sr8K;
                    int iM = AbstractC2144s0.m(bArr, iJ, c2142r0);
                    w02.i(c2142r0.b);
                    while (iM < i2) {
                        int iJ5 = AbstractC2144s0.j(bArr, iM, c2142r0);
                        if (i3 != c2142r0.a) {
                            return iM;
                        }
                        iM = AbstractC2144s0.m(bArr, iJ5, c2142r0);
                        w02.i(c2142r0.b);
                    }
                    return iM;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return AbstractC2144s0.f(bArr, iJ, interfaceC20943sr8K, c2142r0);
                }
                if (i5 == 0) {
                    return AbstractC2144s0.l(i3, bArr, i, i2, interfaceC20943sr8K, c2142r0);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    W0 w03 = (W0) interfaceC20943sr8K;
                    int iJ6 = AbstractC2144s0.j(bArr, iJ, c2142r0);
                    int i13 = c2142r0.a + iJ6;
                    while (iJ6 < i13) {
                        w03.i(AbstractC2144s0.p(bArr, iJ6));
                        iJ6 += 8;
                    }
                    if (iJ6 == i13) {
                        return iJ6;
                    }
                    throw zzkp.f();
                }
                if (i5 == 1) {
                    W0 w04 = (W0) interfaceC20943sr8K;
                    w04.i(AbstractC2144s0.p(bArr, i));
                    while (true) {
                        i8 = iJ + 8;
                        if (i8 < i2) {
                            iJ = AbstractC2144s0.j(bArr, i8, c2142r0);
                            if (i3 == c2142r0.a) {
                                w04.i(AbstractC2144s0.p(bArr, iJ));
                            }
                        }
                    }
                    return i8;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    Q0 q0 = (Q0) interfaceC20943sr8K;
                    int iJ7 = AbstractC2144s0.j(bArr, iJ, c2142r0);
                    int i14 = c2142r0.a + iJ7;
                    while (iJ7 < i14) {
                        q0.j(AbstractC2144s0.b(bArr, iJ7));
                        iJ7 += 4;
                    }
                    if (iJ7 == i14) {
                        return iJ7;
                    }
                    throw zzkp.f();
                }
                if (i5 == 5) {
                    Q0 q02 = (Q0) interfaceC20943sr8K;
                    q02.j(AbstractC2144s0.b(bArr, i));
                    while (true) {
                        i9 = iJ + 4;
                        if (i9 < i2) {
                            iJ = AbstractC2144s0.j(bArr, i9, c2142r0);
                            if (i3 == c2142r0.a) {
                                q02.j(AbstractC2144s0.b(bArr, iJ));
                            }
                        }
                    }
                    return i9;
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    AbstractC18350oW3.a(interfaceC20943sr8K);
                    int iJ8 = AbstractC2144s0.j(bArr, iJ, c2142r0);
                    int i15 = c2142r0.a + iJ8;
                    if (iJ8 < i15) {
                        AbstractC2144s0.m(bArr, iJ8, c2142r0);
                        throw null;
                    }
                    if (iJ8 == i15) {
                        return iJ8;
                    }
                    throw zzkp.f();
                }
                if (i5 == 0) {
                    AbstractC18350oW3.a(interfaceC20943sr8K);
                    AbstractC2144s0.m(bArr, iJ, c2142r0);
                    long j3 = c2142r0.b;
                    throw null;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iJ9 = AbstractC2144s0.j(bArr, iJ, c2142r0);
                        int i16 = c2142r0.a;
                        if (i16 < 0) {
                            throw zzkp.d();
                        }
                        if (i16 == 0) {
                            interfaceC20943sr8K.add("");
                        } else {
                            interfaceC20943sr8K.add(new String(bArr, iJ9, i16, R0.b));
                            iJ9 += i16;
                        }
                        while (iJ9 < i2) {
                            int iJ10 = AbstractC2144s0.j(bArr, iJ9, c2142r0);
                            if (i3 != c2142r0.a) {
                                return iJ9;
                            }
                            iJ9 = AbstractC2144s0.j(bArr, iJ10, c2142r0);
                            int i17 = c2142r0.a;
                            if (i17 < 0) {
                                throw zzkp.d();
                            }
                            if (i17 == 0) {
                                interfaceC20943sr8K.add("");
                            } else {
                                interfaceC20943sr8K.add(new String(bArr, iJ9, i17, R0.b));
                                iJ9 += i17;
                            }
                        }
                        return iJ9;
                    }
                    int iJ11 = AbstractC2144s0.j(bArr, iJ, c2142r0);
                    int i18 = c2142r0.a;
                    if (i18 < 0) {
                        throw zzkp.d();
                    }
                    if (i18 == 0) {
                        interfaceC20943sr8K.add("");
                    } else {
                        int i19 = iJ11 + i18;
                        if (!E1.f(bArr, iJ11, i19)) {
                            throw zzkp.c();
                        }
                        interfaceC20943sr8K.add(new String(bArr, iJ11, i18, R0.b));
                        iJ11 = i19;
                    }
                    while (iJ11 < i2) {
                        int iJ12 = AbstractC2144s0.j(bArr, iJ11, c2142r0);
                        if (i3 != c2142r0.a) {
                            return iJ11;
                        }
                        iJ11 = AbstractC2144s0.j(bArr, iJ12, c2142r0);
                        int i20 = c2142r0.a;
                        if (i20 < 0) {
                            throw zzkp.d();
                        }
                        if (i20 == 0) {
                            interfaceC20943sr8K.add("");
                        } else {
                            int i21 = iJ11 + i20;
                            if (!E1.f(bArr, iJ11, i21)) {
                                throw zzkp.c();
                            }
                            interfaceC20943sr8K.add(new String(bArr, iJ11, i20, R0.b));
                            iJ11 = i21;
                        }
                    }
                    return iJ11;
                }
                break;
            case 27:
                if (i5 == 2) {
                    return AbstractC2144s0.e(f(i6), i3, bArr, i, i2, interfaceC20943sr8K, c2142r0);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int iJ13 = AbstractC2144s0.j(bArr, iJ, c2142r0);
                    int i22 = c2142r0.a;
                    if (i22 < 0) {
                        throw zzkp.d();
                    }
                    if (i22 > bArr.length - iJ13) {
                        throw zzkp.f();
                    }
                    if (i22 == 0) {
                        interfaceC20943sr8K.add(A0.b);
                    } else {
                        interfaceC20943sr8K.add(A0.O(bArr, iJ13, i22));
                        iJ13 += i22;
                    }
                    while (iJ13 < i2) {
                        int iJ14 = AbstractC2144s0.j(bArr, iJ13, c2142r0);
                        if (i3 != c2142r0.a) {
                            return iJ13;
                        }
                        iJ13 = AbstractC2144s0.j(bArr, iJ14, c2142r0);
                        int i23 = c2142r0.a;
                        if (i23 < 0) {
                            throw zzkp.d();
                        }
                        if (i23 > bArr.length - iJ13) {
                            throw zzkp.f();
                        }
                        if (i23 == 0) {
                            interfaceC20943sr8K.add(A0.b);
                        } else {
                            interfaceC20943sr8K.add(A0.O(bArr, iJ13, i23));
                            iJ13 += i23;
                        }
                    }
                    return iJ13;
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iL = AbstractC2144s0.f(bArr, iJ, interfaceC20943sr8K, c2142r0);
                } else if (i5 == 0) {
                    iL = AbstractC2144s0.l(i3, bArr, i, i2, interfaceC20943sr8K, c2142r0);
                }
                q1.c(obj, i4, interfaceC20943sr8K, e(i6), null, this.l);
                return iL;
            case 33:
            case 47:
                if (i5 == 2) {
                    Q0 q03 = (Q0) interfaceC20943sr8K;
                    int iJ15 = AbstractC2144s0.j(bArr, iJ, c2142r0);
                    int i24 = c2142r0.a + iJ15;
                    while (iJ15 < i24) {
                        iJ15 = AbstractC2144s0.j(bArr, iJ15, c2142r0);
                        q03.j(C0.a(c2142r0.a));
                    }
                    if (iJ15 == i24) {
                        return iJ15;
                    }
                    throw zzkp.f();
                }
                if (i5 == 0) {
                    Q0 q04 = (Q0) interfaceC20943sr8K;
                    int iJ16 = AbstractC2144s0.j(bArr, iJ, c2142r0);
                    q04.j(C0.a(c2142r0.a));
                    while (iJ16 < i2) {
                        int iJ17 = AbstractC2144s0.j(bArr, iJ16, c2142r0);
                        if (i3 != c2142r0.a) {
                            return iJ16;
                        }
                        iJ16 = AbstractC2144s0.j(bArr, iJ17, c2142r0);
                        q04.j(C0.a(c2142r0.a));
                    }
                    return iJ16;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    W0 w05 = (W0) interfaceC20943sr8K;
                    int iJ18 = AbstractC2144s0.j(bArr, iJ, c2142r0);
                    int i25 = c2142r0.a + iJ18;
                    while (iJ18 < i25) {
                        iJ18 = AbstractC2144s0.m(bArr, iJ18, c2142r0);
                        w05.i(C0.b(c2142r0.b));
                    }
                    if (iJ18 == i25) {
                        return iJ18;
                    }
                    throw zzkp.f();
                }
                if (i5 == 0) {
                    W0 w06 = (W0) interfaceC20943sr8K;
                    int iM2 = AbstractC2144s0.m(bArr, iJ, c2142r0);
                    w06.i(C0.b(c2142r0.b));
                    while (iM2 < i2) {
                        int iJ19 = AbstractC2144s0.j(bArr, iM2, c2142r0);
                        if (i3 != c2142r0.a) {
                            return iM2;
                        }
                        iM2 = AbstractC2144s0.m(bArr, iJ19, c2142r0);
                        w06.i(C0.b(c2142r0.b));
                    }
                    return iM2;
                }
                break;
            default:
                if (i5 == 3) {
                    o1 o1VarF = f(i6);
                    int i26 = (i3 & (-8)) | 4;
                    int iC = AbstractC2144s0.c(o1VarF, bArr, i, i2, i26, c2142r0);
                    interfaceC20943sr8K.add(c2142r0.c);
                    while (iC < i2) {
                        int iJ20 = AbstractC2144s0.j(bArr, iC, c2142r0);
                        if (i3 != c2142r0.a) {
                            return iC;
                        }
                        iC = AbstractC2144s0.c(o1VarF, bArr, iJ20, i2, i26, c2142r0);
                        interfaceC20943sr8K.add(c2142r0.c);
                    }
                    return iC;
                }
                break;
        }
        return iJ;
    }

    private final int W(int i) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return Z(i, 0);
    }

    private final int X(int i, int i2) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return Z(i, i2);
    }

    private final int Y(int i) {
        return this.a[i + 2];
    }

    private final int Z(int i, int i2) {
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

    private static int b(int i) {
        return (i >>> 20) & 255;
    }

    private final int c(int i) {
        return this.a[i + 1];
    }

    private static long d(Object obj, long j) {
        return ((Long) z1.k(obj, j)).longValue();
    }

    private final InterfaceC17970nr8 e(int i) {
        int i2 = i / 3;
        return (InterfaceC17970nr8) this.b[i2 + i2 + 1];
    }

    private final o1 f(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        o1 o1Var = (o1) this.b[i3];
        if (o1Var != null) {
            return o1Var;
        }
        o1 o1VarB = l1.a().b((Class) this.b[i3 + 1]);
        this.b[i3] = o1VarB;
        return o1VarB;
    }

    private final Object o(int i) {
        int i2 = i / 3;
        return this.b[i2 + i2];
    }

    private final Object p(Object obj, int i) {
        o1 o1VarF = f(i);
        long jC = c(i) & 1048575;
        if (!C(obj, i)) {
            return o1VarF.g();
        }
        Object object = q.getObject(obj, jC);
        if (F(object)) {
            return object;
        }
        Object objG = o1VarF.g();
        if (object != null) {
            o1VarF.k(objG, object);
        }
        return objG;
    }

    private final Object q(Object obj, int i, int i2) {
        o1 o1VarF = f(i2);
        if (!G(obj, i, i2)) {
            return o1VarF.g();
        }
        Object object = q.getObject(obj, c(i2) & 1048575);
        if (F(object)) {
            return object;
        }
        Object objG = o1VarF.g();
        if (object != null) {
            o1VarF.k(objG, object);
        }
        return objG;
    }

    private static Field r(Class cls, String str) {
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

    private static void s(Object obj) {
        if (!F(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void t(Object obj, Object obj2, int i) {
        if (C(obj2, i)) {
            long jC = c(i) & 1048575;
            Unsafe unsafe = q;
            Object object = unsafe.getObject(obj2, jC);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.a[i] + " is present but null: " + obj2.toString());
            }
            o1 o1VarF = f(i);
            if (!C(obj, i)) {
                if (F(object)) {
                    Object objG = o1VarF.g();
                    o1VarF.k(objG, object);
                    unsafe.putObject(obj, jC, objG);
                } else {
                    unsafe.putObject(obj, jC, object);
                }
                v(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jC);
            if (!F(object2)) {
                Object objG2 = o1VarF.g();
                o1VarF.k(objG2, object2);
                unsafe.putObject(obj, jC, objG2);
                object2 = objG2;
            }
            o1VarF.k(object2, object);
        }
    }

    private final void u(Object obj, Object obj2, int i) {
        int i2 = this.a[i];
        if (G(obj2, i2, i)) {
            long jC = c(i) & 1048575;
            Unsafe unsafe = q;
            Object object = unsafe.getObject(obj2, jC);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.a[i] + " is present but null: " + obj2.toString());
            }
            o1 o1VarF = f(i);
            if (!G(obj, i2, i)) {
                if (F(object)) {
                    Object objG = o1VarF.g();
                    o1VarF.k(objG, object);
                    unsafe.putObject(obj, jC, objG);
                } else {
                    unsafe.putObject(obj, jC, object);
                }
                w(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jC);
            if (!F(object2)) {
                Object objG2 = o1VarF.g();
                o1VarF.k(objG2, object2);
                unsafe.putObject(obj, jC, objG2);
                object2 = objG2;
            }
            o1VarF.k(object2, object);
        }
    }

    private final void v(Object obj, int i) {
        int iY = Y(i);
        long j = 1048575 & iY;
        if (j == 1048575) {
            return;
        }
        z1.v(obj, j, (1 << (iY >>> 20)) | z1.h(obj, j));
    }

    private final void w(Object obj, int i, int i2) {
        z1.v(obj, Y(i2) & 1048575, i);
    }

    private final void x(Object obj, int i, Object obj2) {
        q.putObject(obj, c(i) & 1048575, obj2);
        v(obj, i);
    }

    private final void y(Object obj, int i, int i2, Object obj2) {
        q.putObject(obj, c(i2) & 1048575, obj2);
        w(obj, i, i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final void z(Object obj, F1 f1) {
        int i;
        boolean z;
        if (this.f) {
            this.m.a(obj);
            throw null;
        }
        int length = this.a.length;
        Unsafe unsafe = q;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int iC = c(i4);
            int[] iArr = this.a;
            int i6 = iArr[i4];
            int iB = b(iC);
            if (iB <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & i2;
                if (i8 != i3) {
                    i5 = unsafe.getInt(obj, i8);
                    i3 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            long j = iC & i2;
            switch (iB) {
                case 0:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.n(i6, z1.f(obj, j));
                        break;
                    }
                case 1:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.C(i6, z1.g(obj, j));
                        break;
                    }
                case 2:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.j(i6, unsafe.getLong(obj, j));
                        break;
                    }
                case 3:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.G(i6, unsafe.getLong(obj, j));
                        break;
                    }
                case 4:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.m(i6, unsafe.getInt(obj, j));
                        break;
                    }
                case 5:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.H(i6, unsafe.getLong(obj, j));
                        break;
                    }
                case 6:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.w(i6, unsafe.getInt(obj, j));
                        break;
                    }
                case 7:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.h(i6, z1.B(obj, j));
                        break;
                    }
                case 8:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        I(i6, unsafe.getObject(obj, j), f1);
                        break;
                    }
                case 9:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.J(i6, unsafe.getObject(obj, j), f(i4));
                        break;
                    }
                case 10:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.k(i6, (A0) unsafe.getObject(obj, j));
                        break;
                    }
                case 11:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.u(i6, unsafe.getInt(obj, j));
                        break;
                    }
                case 12:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.A(i6, unsafe.getInt(obj, j));
                        break;
                    }
                case 13:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.o(i6, unsafe.getInt(obj, j));
                        break;
                    }
                case 14:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.x(i6, unsafe.getLong(obj, j));
                        break;
                    }
                case 15:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.g(i6, unsafe.getInt(obj, j));
                        break;
                    }
                case 16:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.s(i6, unsafe.getLong(obj, j));
                        break;
                    }
                case 17:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        f1.z(i6, unsafe.getObject(obj, j), f(i4));
                        break;
                    }
                case 18:
                    q1.j(this.a[i4], (List) unsafe.getObject(obj, j), f1, false);
                    break;
                case 19:
                    q1.n(this.a[i4], (List) unsafe.getObject(obj, j), f1, false);
                    break;
                case 20:
                    q1.q(this.a[i4], (List) unsafe.getObject(obj, j), f1, false);
                    break;
                case 21:
                    q1.y(this.a[i4], (List) unsafe.getObject(obj, j), f1, false);
                    break;
                case 22:
                    q1.p(this.a[i4], (List) unsafe.getObject(obj, j), f1, false);
                    break;
                case 23:
                    q1.m(this.a[i4], (List) unsafe.getObject(obj, j), f1, false);
                    break;
                case 24:
                    q1.l(this.a[i4], (List) unsafe.getObject(obj, j), f1, false);
                    break;
                case 25:
                    q1.h(this.a[i4], (List) unsafe.getObject(obj, j), f1, false);
                    break;
                case 26:
                    q1.w(this.a[i4], (List) unsafe.getObject(obj, j), f1);
                    break;
                case 27:
                    q1.r(this.a[i4], (List) unsafe.getObject(obj, j), f1, f(i4));
                    break;
                case 28:
                    q1.i(this.a[i4], (List) unsafe.getObject(obj, j), f1);
                    break;
                case 29:
                    z = false;
                    q1.x(this.a[i4], (List) unsafe.getObject(obj, j), f1, false);
                    break;
                case 30:
                    z = false;
                    q1.k(this.a[i4], (List) unsafe.getObject(obj, j), f1, false);
                    break;
                case 31:
                    z = false;
                    q1.s(this.a[i4], (List) unsafe.getObject(obj, j), f1, false);
                    break;
                case 32:
                    z = false;
                    q1.t(this.a[i4], (List) unsafe.getObject(obj, j), f1, false);
                    break;
                case 33:
                    z = false;
                    q1.u(this.a[i4], (List) unsafe.getObject(obj, j), f1, false);
                    break;
                case 34:
                    z = false;
                    q1.v(this.a[i4], (List) unsafe.getObject(obj, j), f1, false);
                    break;
                case 35:
                    q1.j(this.a[i4], (List) unsafe.getObject(obj, j), f1, true);
                    break;
                case 36:
                    q1.n(this.a[i4], (List) unsafe.getObject(obj, j), f1, true);
                    break;
                case 37:
                    q1.q(this.a[i4], (List) unsafe.getObject(obj, j), f1, true);
                    break;
                case 38:
                    q1.y(this.a[i4], (List) unsafe.getObject(obj, j), f1, true);
                    break;
                case 39:
                    q1.p(this.a[i4], (List) unsafe.getObject(obj, j), f1, true);
                    break;
                case 40:
                    q1.m(this.a[i4], (List) unsafe.getObject(obj, j), f1, true);
                    break;
                case 41:
                    q1.l(this.a[i4], (List) unsafe.getObject(obj, j), f1, true);
                    break;
                case 42:
                    q1.h(this.a[i4], (List) unsafe.getObject(obj, j), f1, true);
                    break;
                case 43:
                    q1.x(this.a[i4], (List) unsafe.getObject(obj, j), f1, true);
                    break;
                case 44:
                    q1.k(this.a[i4], (List) unsafe.getObject(obj, j), f1, true);
                    break;
                case 45:
                    q1.s(this.a[i4], (List) unsafe.getObject(obj, j), f1, true);
                    break;
                case 46:
                    q1.t(this.a[i4], (List) unsafe.getObject(obj, j), f1, true);
                    break;
                case 47:
                    q1.u(this.a[i4], (List) unsafe.getObject(obj, j), f1, true);
                    break;
                case 48:
                    q1.v(this.a[i4], (List) unsafe.getObject(obj, j), f1, true);
                    break;
                case 49:
                    q1.o(this.a[i4], (List) unsafe.getObject(obj, j), f1, f(i4));
                    break;
                case 50:
                    A(f1, i6, unsafe.getObject(obj, j), i4);
                    break;
                case 51:
                    if (G(obj, i6, i4)) {
                        f1.n(i6, N(obj, j));
                    }
                    break;
                case Type.TLSA /* 52 */:
                    if (G(obj, i6, i4)) {
                        f1.C(i6, O(obj, j));
                    }
                    break;
                case 53:
                    if (G(obj, i6, i4)) {
                        f1.j(i6, d(obj, j));
                    }
                    break;
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (G(obj, i6, i4)) {
                        f1.G(i6, d(obj, j));
                    }
                    break;
                case 55:
                    if (G(obj, i6, i4)) {
                        f1.m(i6, R(obj, j));
                    }
                    break;
                case Type.NINFO /* 56 */:
                    if (G(obj, i6, i4)) {
                        f1.H(i6, d(obj, j));
                    }
                    break;
                case 57:
                    if (G(obj, i6, i4)) {
                        f1.w(i6, R(obj, j));
                    }
                    break;
                case 58:
                    if (G(obj, i6, i4)) {
                        f1.h(i6, H(obj, j));
                    }
                    break;
                case 59:
                    if (G(obj, i6, i4)) {
                        I(i6, unsafe.getObject(obj, j), f1);
                    }
                    break;
                case 60:
                    if (G(obj, i6, i4)) {
                        f1.J(i6, unsafe.getObject(obj, j), f(i4));
                    }
                    break;
                case 61:
                    if (G(obj, i6, i4)) {
                        f1.k(i6, (A0) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (G(obj, i6, i4)) {
                        f1.u(i6, R(obj, j));
                    }
                    break;
                case 63:
                    if (G(obj, i6, i4)) {
                        f1.A(i6, R(obj, j));
                    }
                    break;
                case 64:
                    if (G(obj, i6, i4)) {
                        f1.o(i6, R(obj, j));
                    }
                    break;
                case 65:
                    if (G(obj, i6, i4)) {
                        f1.x(i6, d(obj, j));
                    }
                    break;
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (G(obj, i6, i4)) {
                        f1.g(i6, R(obj, j));
                    }
                    break;
                case 67:
                    if (G(obj, i6, i4)) {
                        f1.s(i6, d(obj, j));
                    }
                    break;
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (G(obj, i6, i4)) {
                        f1.z(i6, unsafe.getObject(obj, j), f(i4));
                    }
                    break;
            }
            i4 += 3;
            i2 = 1048575;
        }
        s1 s1Var = this.l;
        s1Var.i(s1Var.d(obj), f1);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0094. Please report as an issue. */
    final int J(Object obj, byte[] bArr, int i, int i2, int i3, C2142r0 c2142r0) throws zzkp {
        Unsafe unsafe;
        int i4;
        g1 g1Var;
        Object obj2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        C2142r0 c2142r02;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        g1 g1Var2 = this;
        Object obj3 = obj;
        byte[] bArr2 = bArr;
        int i20 = i2;
        int i21 = i3;
        C2142r0 c2142r03 = c2142r0;
        s(obj);
        Unsafe unsafe2 = q;
        int i22 = i;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = -1;
        int i27 = 1048575;
        while (true) {
            if (i22 < i20) {
                int i28 = i22 + 1;
                byte b = bArr2[i22];
                if (b < 0) {
                    int iK = AbstractC2144s0.k(b, bArr2, i28, c2142r03);
                    i5 = c2142r03.a;
                    i28 = iK;
                } else {
                    i5 = b;
                }
                int i29 = i5 >>> 3;
                int i30 = i5 & 7;
                int iX = i29 > i26 ? g1Var2.X(i29, i24 / 3) : g1Var2.W(i29);
                if (iX == -1) {
                    i6 = i29;
                    i7 = i5;
                    i8 = i25;
                    unsafe = unsafe2;
                    i4 = i21;
                    i9 = 0;
                    i10 = i28;
                } else {
                    int[] iArr = g1Var2.a;
                    int i31 = iArr[iX + 1];
                    int iB = b(i31);
                    int i32 = i28;
                    long j = i31 & 1048575;
                    int i33 = i5;
                    if (iB <= 17) {
                        int i34 = iArr[iX + 2];
                        int i35 = 1 << (i34 >>> 20);
                        int i36 = i34 & 1048575;
                        if (i36 != i27) {
                            i12 = iX;
                            if (i27 != 1048575) {
                                unsafe2.putInt(obj3, i27, i25);
                            }
                            i13 = i36;
                            i8 = unsafe2.getInt(obj3, i36);
                        } else {
                            i12 = iX;
                            i8 = i25;
                            i13 = i27;
                        }
                        switch (iB) {
                            case 0:
                                i14 = i29;
                                i15 = i12;
                                i16 = i32;
                                bArr2 = bArr;
                                if (i30 != 1) {
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i6 = i14;
                                    i9 = i15;
                                    i7 = i33;
                                    i27 = i13;
                                    break;
                                } else {
                                    z1.t(obj3, j, Double.longBitsToDouble(AbstractC2144s0.p(bArr2, i16)));
                                    i22 = i16 + 8;
                                    i25 = i8 | i35;
                                    i26 = i14;
                                    i24 = i15;
                                    i23 = i33;
                                    i27 = i13;
                                    i20 = i2;
                                    i21 = i3;
                                }
                            case 1:
                                i14 = i29;
                                i15 = i12;
                                i16 = i32;
                                bArr2 = bArr;
                                if (i30 != 5) {
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i6 = i14;
                                    i9 = i15;
                                    i7 = i33;
                                    i27 = i13;
                                    break;
                                } else {
                                    z1.u(obj3, j, Float.intBitsToFloat(AbstractC2144s0.b(bArr2, i16)));
                                    i22 = i16 + 4;
                                    i25 = i8 | i35;
                                    i26 = i14;
                                    i24 = i15;
                                    i23 = i33;
                                    i27 = i13;
                                    i20 = i2;
                                    i21 = i3;
                                }
                            case 2:
                            case 3:
                                i14 = i29;
                                i15 = i12;
                                i16 = i32;
                                bArr2 = bArr;
                                if (i30 != 0) {
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i6 = i14;
                                    i9 = i15;
                                    i7 = i33;
                                    i27 = i13;
                                    break;
                                } else {
                                    int iM = AbstractC2144s0.m(bArr2, i16, c2142r03);
                                    unsafe2.putLong(obj, j, c2142r03.b);
                                    i25 = i8 | i35;
                                    i22 = iM;
                                    i26 = i14;
                                    i24 = i15;
                                    i23 = i33;
                                    i27 = i13;
                                    i20 = i2;
                                    i21 = i3;
                                }
                            case 4:
                            case 11:
                                i14 = i29;
                                i15 = i12;
                                i16 = i32;
                                bArr2 = bArr;
                                if (i30 != 0) {
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i6 = i14;
                                    i9 = i15;
                                    i7 = i33;
                                    i27 = i13;
                                    break;
                                } else {
                                    i22 = AbstractC2144s0.j(bArr2, i16, c2142r03);
                                    unsafe2.putInt(obj3, j, c2142r03.a);
                                    i25 = i8 | i35;
                                    i26 = i14;
                                    i24 = i15;
                                    i23 = i33;
                                    i27 = i13;
                                    i20 = i2;
                                    i21 = i3;
                                }
                            case 5:
                            case 14:
                                i14 = i29;
                                i15 = i12;
                                i16 = i32;
                                i17 = i33;
                                bArr2 = bArr;
                                if (i30 != 1) {
                                    i33 = i17;
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i6 = i14;
                                    i9 = i15;
                                    i7 = i33;
                                    i27 = i13;
                                    break;
                                } else {
                                    i33 = i17;
                                    unsafe2.putLong(obj, j, AbstractC2144s0.p(bArr2, i16));
                                    i22 = i16 + 8;
                                    i25 = i8 | i35;
                                    i26 = i14;
                                    i24 = i15;
                                    i23 = i33;
                                    i27 = i13;
                                    i20 = i2;
                                    i21 = i3;
                                }
                            case 6:
                            case 13:
                                i14 = i29;
                                i15 = i12;
                                i16 = i32;
                                i17 = i33;
                                bArr2 = bArr;
                                if (i30 != 5) {
                                    i33 = i17;
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i6 = i14;
                                    i9 = i15;
                                    i7 = i33;
                                    i27 = i13;
                                    break;
                                } else {
                                    unsafe2.putInt(obj3, j, AbstractC2144s0.b(bArr2, i16));
                                    i22 = i16 + 4;
                                    i26 = i14;
                                    i24 = i15;
                                    i27 = i13;
                                    i20 = i2;
                                    i21 = i3;
                                    int i37 = i17;
                                    i25 = i8 | i35;
                                    i23 = i37;
                                }
                            case 7:
                                i14 = i29;
                                i15 = i12;
                                i16 = i32;
                                i17 = i33;
                                bArr2 = bArr;
                                if (i30 != 0) {
                                    i33 = i17;
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i6 = i14;
                                    i9 = i15;
                                    i7 = i33;
                                    i27 = i13;
                                    break;
                                } else {
                                    i22 = AbstractC2144s0.m(bArr2, i16, c2142r03);
                                    z1.r(obj3, j, c2142r03.b != 0);
                                    i26 = i14;
                                    i24 = i15;
                                    i27 = i13;
                                    i20 = i2;
                                    i21 = i3;
                                    int i372 = i17;
                                    i25 = i8 | i35;
                                    i23 = i372;
                                }
                            case 8:
                                i14 = i29;
                                i15 = i12;
                                i16 = i32;
                                i17 = i33;
                                bArr2 = bArr;
                                if (i30 != 2) {
                                    i33 = i17;
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i6 = i14;
                                    i9 = i15;
                                    i7 = i33;
                                    i27 = i13;
                                    break;
                                } else {
                                    i22 = (536870912 & i31) == 0 ? AbstractC2144s0.g(bArr2, i16, c2142r03) : AbstractC2144s0.h(bArr2, i16, c2142r03);
                                    unsafe2.putObject(obj3, j, c2142r03.c);
                                    i26 = i14;
                                    i24 = i15;
                                    i27 = i13;
                                    i20 = i2;
                                    i21 = i3;
                                    int i3722 = i17;
                                    i25 = i8 | i35;
                                    i23 = i3722;
                                }
                            case 9:
                                bArr2 = bArr;
                                i14 = i29;
                                i15 = i12;
                                i16 = i32;
                                i18 = i33;
                                if (i30 != 2) {
                                    i33 = i18;
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i6 = i14;
                                    i9 = i15;
                                    i7 = i33;
                                    i27 = i13;
                                    break;
                                } else {
                                    Object objP = g1Var2.p(obj3, i15);
                                    i22 = AbstractC2144s0.o(objP, g1Var2.f(i15), bArr, i16, i2, c2142r0);
                                    g1Var2.x(obj3, i15, objP);
                                    i25 = i8 | i35;
                                    i23 = i18;
                                    i26 = i14;
                                    i24 = i15;
                                    i27 = i13;
                                    i20 = i2;
                                    i21 = i3;
                                }
                            case 10:
                                i14 = i29;
                                i15 = i12;
                                i16 = i32;
                                i18 = i33;
                                bArr2 = bArr;
                                if (i30 != 2) {
                                    i33 = i18;
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i6 = i14;
                                    i9 = i15;
                                    i7 = i33;
                                    i27 = i13;
                                    break;
                                } else {
                                    i22 = AbstractC2144s0.a(bArr2, i16, c2142r03);
                                    unsafe2.putObject(obj3, j, c2142r03.c);
                                    i25 = i8 | i35;
                                    i23 = i18;
                                    i26 = i14;
                                    i24 = i15;
                                    i27 = i13;
                                    i20 = i2;
                                    i21 = i3;
                                }
                            case 12:
                                i14 = i29;
                                i15 = i12;
                                i16 = i32;
                                i18 = i33;
                                bArr2 = bArr;
                                if (i30 != 0) {
                                    i33 = i18;
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i6 = i14;
                                    i9 = i15;
                                    i7 = i33;
                                    i27 = i13;
                                    break;
                                } else {
                                    i22 = AbstractC2144s0.j(bArr2, i16, c2142r03);
                                    int i38 = c2142r03.a;
                                    InterfaceC17970nr8 interfaceC17970nr8E = g1Var2.e(i15);
                                    if (interfaceC17970nr8E == null || interfaceC17970nr8E.zza(i38)) {
                                        unsafe2.putInt(obj3, j, i38);
                                        i25 = i8 | i35;
                                        i23 = i18;
                                        i26 = i14;
                                        i24 = i15;
                                        i27 = i13;
                                        i20 = i2;
                                        i21 = i3;
                                    } else {
                                        K(obj).j(i18, Long.valueOf(i38));
                                        i23 = i18;
                                        i26 = i14;
                                        i24 = i15;
                                        i25 = i8;
                                        i27 = i13;
                                        i20 = i2;
                                        i21 = i3;
                                    }
                                }
                                break;
                            case 15:
                                i14 = i29;
                                i15 = i12;
                                i16 = i32;
                                i18 = i33;
                                bArr2 = bArr;
                                if (i30 != 0) {
                                    i33 = i18;
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i6 = i14;
                                    i9 = i15;
                                    i7 = i33;
                                    i27 = i13;
                                    break;
                                } else {
                                    i22 = AbstractC2144s0.j(bArr2, i16, c2142r03);
                                    unsafe2.putInt(obj3, j, C0.a(c2142r03.a));
                                    i25 = i8 | i35;
                                    i23 = i18;
                                    i26 = i14;
                                    i24 = i15;
                                    i27 = i13;
                                    i20 = i2;
                                    i21 = i3;
                                }
                            case 16:
                                i14 = i29;
                                int i39 = i12;
                                i16 = i32;
                                i18 = i33;
                                if (i30 != 0) {
                                    i15 = i39;
                                    i33 = i18;
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i6 = i14;
                                    i9 = i15;
                                    i7 = i33;
                                    i27 = i13;
                                    break;
                                } else {
                                    bArr2 = bArr;
                                    int iM2 = AbstractC2144s0.m(bArr2, i16, c2142r03);
                                    i15 = i39;
                                    unsafe2.putLong(obj, j, C0.b(c2142r03.b));
                                    i25 = i8 | i35;
                                    i22 = iM2;
                                    i23 = i18;
                                    i26 = i14;
                                    i24 = i15;
                                    i27 = i13;
                                    i20 = i2;
                                    i21 = i3;
                                }
                            default:
                                if (i30 != 3) {
                                    i14 = i29;
                                    i16 = i32;
                                    i15 = i12;
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    i6 = i14;
                                    i9 = i15;
                                    i7 = i33;
                                    i27 = i13;
                                    break;
                                } else {
                                    int i40 = i12;
                                    Object objP2 = g1Var2.p(obj3, i40);
                                    i22 = AbstractC2144s0.n(objP2, g1Var2.f(i40), bArr, i32, i2, (i29 << 3) | 4, c2142r0);
                                    g1Var2.x(obj3, i40, objP2);
                                    i25 = i8 | i35;
                                    i20 = i2;
                                    i24 = i40;
                                    i26 = i29;
                                    i23 = i33;
                                    i27 = i13;
                                    bArr2 = bArr;
                                    i21 = i3;
                                }
                        }
                    } else {
                        bArr2 = bArr;
                        if (iB != 27) {
                            i8 = i25;
                            i13 = i27;
                            if (iB <= 49) {
                                i6 = i29;
                                unsafe = unsafe2;
                                i9 = iX;
                                i22 = V(obj, bArr, i32, i2, i33, i6, i30, iX, i31, iB, j, c2142r0);
                                if (i22 != i32) {
                                    g1Var2 = this;
                                    obj3 = obj;
                                    bArr2 = bArr;
                                    i26 = i6;
                                    i20 = i2;
                                    i21 = i3;
                                    c2142r03 = c2142r0;
                                    i24 = i9;
                                    i23 = i33;
                                    i25 = i8;
                                    i27 = i13;
                                    unsafe2 = unsafe;
                                } else {
                                    i4 = i3;
                                    i10 = i22;
                                }
                            } else {
                                i19 = i32;
                                i6 = i29;
                                unsafe = unsafe2;
                                i9 = iX;
                                if (iB != 50) {
                                    i22 = T(obj, bArr, i19, i2, i33, i6, i30, i31, iB, j, i9, c2142r0);
                                    if (i22 != i19) {
                                        g1Var2 = this;
                                        obj3 = obj;
                                        bArr2 = bArr;
                                        i26 = i6;
                                        i20 = i2;
                                        i21 = i3;
                                        c2142r03 = c2142r0;
                                        i24 = i9;
                                        i23 = i33;
                                        i25 = i8;
                                        i27 = i13;
                                        unsafe2 = unsafe;
                                    } else {
                                        i4 = i3;
                                        i10 = i22;
                                    }
                                } else if (i30 == 2) {
                                    i22 = S(obj, bArr, i19, i2, i9, j, c2142r0);
                                    if (i22 != i19) {
                                        g1Var2 = this;
                                        obj3 = obj;
                                        bArr2 = bArr;
                                        i26 = i6;
                                        i20 = i2;
                                        i21 = i3;
                                        c2142r03 = c2142r0;
                                        i24 = i9;
                                        i23 = i33;
                                        i25 = i8;
                                        i27 = i13;
                                        unsafe2 = unsafe;
                                    } else {
                                        i4 = i3;
                                        i10 = i22;
                                    }
                                } else {
                                    i4 = i3;
                                    i10 = i19;
                                }
                            }
                        } else if (i30 == 2) {
                            InterfaceC20943sr8 interfaceC20943sr8K = (InterfaceC20943sr8) unsafe2.getObject(obj3, j);
                            if (!interfaceC20943sr8K.e()) {
                                int size = interfaceC20943sr8K.size();
                                interfaceC20943sr8K = interfaceC20943sr8K.K(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj3, j, interfaceC20943sr8K);
                            }
                            i23 = i33;
                            i22 = AbstractC2144s0.e(g1Var2.f(iX), i23, bArr, i32, i2, interfaceC20943sr8K, c2142r0);
                            i21 = i3;
                            i26 = i29;
                            i24 = iX;
                            i25 = i25;
                            i27 = i27;
                            i20 = i2;
                        } else {
                            i8 = i25;
                            i13 = i27;
                            i6 = i29;
                            i19 = i32;
                            unsafe = unsafe2;
                            i9 = iX;
                            i4 = i3;
                            i10 = i19;
                        }
                        i7 = i33;
                        i27 = i13;
                    }
                }
                if (i7 != i4 || i4 == 0) {
                    if (this.f) {
                        c2142r02 = c2142r0;
                        H0 h0 = c2142r02.d;
                        if (h0 != H0.c) {
                            i11 = i6;
                            h0.b(this.e, i11);
                            i22 = AbstractC2144s0.i(i7, bArr, i10, i2, K(obj), c2142r0);
                            obj3 = obj;
                            bArr2 = bArr;
                            i20 = i2;
                            i23 = i7;
                            g1Var2 = this;
                            c2142r03 = c2142r02;
                            i26 = i11;
                            i24 = i9;
                            i25 = i8;
                            unsafe2 = unsafe;
                            i21 = i4;
                        } else {
                            i11 = i6;
                        }
                    } else {
                        i11 = i6;
                        c2142r02 = c2142r0;
                    }
                    i22 = AbstractC2144s0.i(i7, bArr, i10, i2, K(obj), c2142r0);
                    obj3 = obj;
                    bArr2 = bArr;
                    i20 = i2;
                    i23 = i7;
                    g1Var2 = this;
                    c2142r03 = c2142r02;
                    i26 = i11;
                    i24 = i9;
                    i25 = i8;
                    unsafe2 = unsafe;
                    i21 = i4;
                } else {
                    g1Var = this;
                    i22 = i10;
                    i23 = i7;
                    i25 = i8;
                }
            } else {
                unsafe = unsafe2;
                i4 = i21;
                g1Var = g1Var2;
            }
        }
        if (i27 != 1048575) {
            long j2 = i27;
            obj2 = obj;
            unsafe.putInt(obj2, j2, i25);
        } else {
            obj2 = obj;
        }
        for (int i41 = g1Var.i; i41 < g1Var.j; i41++) {
            int i42 = g1Var.h[i41];
            int i43 = g1Var.a[i42];
            Object objK = z1.k(obj2, g1Var.c(i42) & 1048575);
            if (objK != null && g1Var.e(i42) != null) {
                AbstractC18350oW3.a(g1Var.o(i42));
                throw null;
            }
        }
        if (i4 == 0) {
            if (i22 != i2) {
                throw zzkp.e();
            }
        } else if (i22 > i2 || i23 != i4) {
            throw zzkp.e();
        }
        return i22;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009f  */
    @Override // com.google.android.gms.internal.measurement.o1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.g1.a(java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final Object g() {
        return ((P0) this.e).i();
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final int h(Object obj) {
        return this.g ? Q(obj) : P(obj);
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final int i(Object obj) {
        int i;
        int iC;
        int length = this.a.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iC2 = c(i3);
            int i4 = this.a[i3];
            long j = 1048575 & iC2;
            int iHashCode = 37;
            switch (b(iC2)) {
                case 0:
                    i = i2 * 53;
                    iC = R0.c(Double.doubleToLongBits(z1.f(obj, j)));
                    i2 = i + iC;
                    break;
                case 1:
                    i = i2 * 53;
                    iC = Float.floatToIntBits(z1.g(obj, j));
                    i2 = i + iC;
                    break;
                case 2:
                    i = i2 * 53;
                    iC = R0.c(z1.i(obj, j));
                    i2 = i + iC;
                    break;
                case 3:
                    i = i2 * 53;
                    iC = R0.c(z1.i(obj, j));
                    i2 = i + iC;
                    break;
                case 4:
                    i = i2 * 53;
                    iC = z1.h(obj, j);
                    i2 = i + iC;
                    break;
                case 5:
                    i = i2 * 53;
                    iC = R0.c(z1.i(obj, j));
                    i2 = i + iC;
                    break;
                case 6:
                    i = i2 * 53;
                    iC = z1.h(obj, j);
                    i2 = i + iC;
                    break;
                case 7:
                    i = i2 * 53;
                    iC = R0.a(z1.B(obj, j));
                    i2 = i + iC;
                    break;
                case 8:
                    i = i2 * 53;
                    iC = ((String) z1.k(obj, j)).hashCode();
                    i2 = i + iC;
                    break;
                case 9:
                    Object objK = z1.k(obj, j);
                    if (objK != null) {
                        iHashCode = objK.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iC = z1.k(obj, j).hashCode();
                    i2 = i + iC;
                    break;
                case 11:
                    i = i2 * 53;
                    iC = z1.h(obj, j);
                    i2 = i + iC;
                    break;
                case 12:
                    i = i2 * 53;
                    iC = z1.h(obj, j);
                    i2 = i + iC;
                    break;
                case 13:
                    i = i2 * 53;
                    iC = z1.h(obj, j);
                    i2 = i + iC;
                    break;
                case 14:
                    i = i2 * 53;
                    iC = R0.c(z1.i(obj, j));
                    i2 = i + iC;
                    break;
                case 15:
                    i = i2 * 53;
                    iC = z1.h(obj, j);
                    i2 = i + iC;
                    break;
                case 16:
                    i = i2 * 53;
                    iC = R0.c(z1.i(obj, j));
                    i2 = i + iC;
                    break;
                case 17:
                    Object objK2 = z1.k(obj, j);
                    if (objK2 != null) {
                        iHashCode = objK2.hashCode();
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
                    iC = z1.k(obj, j).hashCode();
                    i2 = i + iC;
                    break;
                case 50:
                    i = i2 * 53;
                    iC = z1.k(obj, j).hashCode();
                    i2 = i + iC;
                    break;
                case 51:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = R0.c(Double.doubleToLongBits(N(obj, j)));
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case Type.TLSA /* 52 */:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = Float.floatToIntBits(O(obj, j));
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = R0.c(d(obj, j));
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = R0.c(d(obj, j));
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = R(obj, j);
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case Type.NINFO /* 56 */:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = R0.c(d(obj, j));
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = R(obj, j);
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = R0.a(H(obj, j));
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = ((String) z1.k(obj, j)).hashCode();
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = z1.k(obj, j).hashCode();
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = z1.k(obj, j).hashCode();
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = R(obj, j);
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = R(obj, j);
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = R(obj, j);
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = R0.c(d(obj, j));
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = R(obj, j);
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = R0.c(d(obj, j));
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (G(obj, i4, i3)) {
                        i = i2 * 53;
                        iC = z1.k(obj, j).hashCode();
                        i2 = i + iC;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.l.d(obj).hashCode();
        if (!this.f) {
            return iHashCode2;
        }
        this.m.a(obj);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    @Override // com.google.android.gms.internal.measurement.o1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = F(r8)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r8 instanceof com.google.android.gms.internal.measurement.P0
            r1 = 0
            if (r0 == 0) goto L1a
            r0 = r8
            com.google.android.gms.internal.measurement.P0 r0 = (com.google.android.gms.internal.measurement.P0) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.t(r2)
            r0.zzb = r1
            r0.r()
        L1a:
            int[] r0 = r7.a
            int r0 = r0.length
        L1d:
            if (r1 >= r0) goto L62
            int r2 = r7.c(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            long r3 = (long) r3
            int r2 = b(r2)
            r5 = 9
            if (r2 == r5) goto L4c
            switch(r2) {
                case 17: goto L4c;
                case 18: goto L46;
                case 19: goto L46;
                case 20: goto L46;
                case 21: goto L46;
                case 22: goto L46;
                case 23: goto L46;
                case 24: goto L46;
                case 25: goto L46;
                case 26: goto L46;
                case 27: goto L46;
                case 28: goto L46;
                case 29: goto L46;
                case 30: goto L46;
                case 31: goto L46;
                case 32: goto L46;
                case 33: goto L46;
                case 34: goto L46;
                case 35: goto L46;
                case 36: goto L46;
                case 37: goto L46;
                case 38: goto L46;
                case 39: goto L46;
                case 40: goto L46;
                case 41: goto L46;
                case 42: goto L46;
                case 43: goto L46;
                case 44: goto L46;
                case 45: goto L46;
                case 46: goto L46;
                case 47: goto L46;
                case 48: goto L46;
                case 49: goto L46;
                case 50: goto L34;
                default: goto L33;
            }
        L33:
            goto L5f
        L34:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.measurement.g1.q
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L5f
            r6 = r5
            com.google.android.gms.internal.measurement.a1 r6 = (com.google.android.gms.internal.measurement.C2104a1) r6
            r6.d()
            r2.putObject(r8, r3, r5)
            goto L5f
        L46:
            com.google.android.gms.internal.measurement.V0 r2 = r7.k
            r2.a(r8, r3)
            goto L5f
        L4c:
            boolean r2 = r7.C(r8, r1)
            if (r2 == 0) goto L5f
            com.google.android.gms.internal.measurement.o1 r2 = r7.f(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.measurement.g1.q
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.j(r3)
        L5f:
            int r1 = r1 + 3
            goto L1d
        L62:
            com.google.android.gms.internal.measurement.s1 r0 = r7.l
            r0.g(r8)
            boolean r0 = r7.f
            if (r0 == 0) goto L70
            com.google.android.gms.internal.measurement.I0 r0 = r7.m
            r0.b(r8)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.g1.j(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final void k(Object obj, Object obj2) {
        s(obj);
        obj2.getClass();
        for (int i = 0; i < this.a.length; i += 3) {
            int iC = c(i);
            long j = 1048575 & iC;
            int i2 = this.a[i];
            switch (b(iC)) {
                case 0:
                    if (C(obj2, i)) {
                        z1.t(obj, j, z1.f(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (C(obj2, i)) {
                        z1.u(obj, j, z1.g(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (C(obj2, i)) {
                        z1.w(obj, j, z1.i(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (C(obj2, i)) {
                        z1.w(obj, j, z1.i(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (C(obj2, i)) {
                        z1.v(obj, j, z1.h(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (C(obj2, i)) {
                        z1.w(obj, j, z1.i(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (C(obj2, i)) {
                        z1.v(obj, j, z1.h(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (C(obj2, i)) {
                        z1.r(obj, j, z1.B(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (C(obj2, i)) {
                        z1.x(obj, j, z1.k(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    t(obj, obj2, i);
                    break;
                case 10:
                    if (C(obj2, i)) {
                        z1.x(obj, j, z1.k(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (C(obj2, i)) {
                        z1.v(obj, j, z1.h(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (C(obj2, i)) {
                        z1.v(obj, j, z1.h(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (C(obj2, i)) {
                        z1.v(obj, j, z1.h(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (C(obj2, i)) {
                        z1.w(obj, j, z1.i(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (C(obj2, i)) {
                        z1.v(obj, j, z1.h(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (C(obj2, i)) {
                        z1.w(obj, j, z1.i(obj2, j));
                        v(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    t(obj, obj2, i);
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
                    this.k.b(obj, obj2, j);
                    break;
                case 50:
                    q1.B(this.o, obj, obj2, j);
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
                    if (G(obj2, i2, i)) {
                        z1.x(obj, j, z1.k(obj2, j));
                        w(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    u(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case WKSRecord.Protocol.RVD /* 66 */:
                case 67:
                    if (G(obj2, i2, i)) {
                        z1.x(obj, j, z1.k(obj2, j));
                        w(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    u(obj, obj2, i);
                    break;
            }
        }
        q1.f(this.l, obj, obj2);
        if (this.f) {
            q1.e(this.m, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final void l(Object obj, F1 f1) {
        if (!this.g) {
            z(obj, f1);
            return;
        }
        if (this.f) {
            this.m.a(obj);
            throw null;
        }
        int length = this.a.length;
        for (int i = 0; i < length; i += 3) {
            int iC = c(i);
            int i2 = this.a[i];
            switch (b(iC)) {
                case 0:
                    if (C(obj, i)) {
                        f1.n(i2, z1.f(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (C(obj, i)) {
                        f1.C(i2, z1.g(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (C(obj, i)) {
                        f1.j(i2, z1.i(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (C(obj, i)) {
                        f1.G(i2, z1.i(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (C(obj, i)) {
                        f1.m(i2, z1.h(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (C(obj, i)) {
                        f1.H(i2, z1.i(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (C(obj, i)) {
                        f1.w(i2, z1.h(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (C(obj, i)) {
                        f1.h(i2, z1.B(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (C(obj, i)) {
                        I(i2, z1.k(obj, iC & 1048575), f1);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (C(obj, i)) {
                        f1.J(i2, z1.k(obj, iC & 1048575), f(i));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (C(obj, i)) {
                        f1.k(i2, (A0) z1.k(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (C(obj, i)) {
                        f1.u(i2, z1.h(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (C(obj, i)) {
                        f1.A(i2, z1.h(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (C(obj, i)) {
                        f1.o(i2, z1.h(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (C(obj, i)) {
                        f1.x(i2, z1.i(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (C(obj, i)) {
                        f1.g(i2, z1.h(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (C(obj, i)) {
                        f1.s(i2, z1.i(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (C(obj, i)) {
                        f1.z(i2, z1.k(obj, iC & 1048575), f(i));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    q1.j(i2, (List) z1.k(obj, iC & 1048575), f1, false);
                    break;
                case 19:
                    q1.n(i2, (List) z1.k(obj, iC & 1048575), f1, false);
                    break;
                case 20:
                    q1.q(i2, (List) z1.k(obj, iC & 1048575), f1, false);
                    break;
                case 21:
                    q1.y(i2, (List) z1.k(obj, iC & 1048575), f1, false);
                    break;
                case 22:
                    q1.p(i2, (List) z1.k(obj, iC & 1048575), f1, false);
                    break;
                case 23:
                    q1.m(i2, (List) z1.k(obj, iC & 1048575), f1, false);
                    break;
                case 24:
                    q1.l(i2, (List) z1.k(obj, iC & 1048575), f1, false);
                    break;
                case 25:
                    q1.h(i2, (List) z1.k(obj, iC & 1048575), f1, false);
                    break;
                case 26:
                    q1.w(i2, (List) z1.k(obj, iC & 1048575), f1);
                    break;
                case 27:
                    q1.r(i2, (List) z1.k(obj, iC & 1048575), f1, f(i));
                    break;
                case 28:
                    q1.i(i2, (List) z1.k(obj, iC & 1048575), f1);
                    break;
                case 29:
                    q1.x(i2, (List) z1.k(obj, iC & 1048575), f1, false);
                    break;
                case 30:
                    q1.k(i2, (List) z1.k(obj, iC & 1048575), f1, false);
                    break;
                case 31:
                    q1.s(i2, (List) z1.k(obj, iC & 1048575), f1, false);
                    break;
                case 32:
                    q1.t(i2, (List) z1.k(obj, iC & 1048575), f1, false);
                    break;
                case 33:
                    q1.u(i2, (List) z1.k(obj, iC & 1048575), f1, false);
                    break;
                case 34:
                    q1.v(i2, (List) z1.k(obj, iC & 1048575), f1, false);
                    break;
                case 35:
                    q1.j(i2, (List) z1.k(obj, iC & 1048575), f1, true);
                    break;
                case 36:
                    q1.n(i2, (List) z1.k(obj, iC & 1048575), f1, true);
                    break;
                case 37:
                    q1.q(i2, (List) z1.k(obj, iC & 1048575), f1, true);
                    break;
                case 38:
                    q1.y(i2, (List) z1.k(obj, iC & 1048575), f1, true);
                    break;
                case 39:
                    q1.p(i2, (List) z1.k(obj, iC & 1048575), f1, true);
                    break;
                case 40:
                    q1.m(i2, (List) z1.k(obj, iC & 1048575), f1, true);
                    break;
                case 41:
                    q1.l(i2, (List) z1.k(obj, iC & 1048575), f1, true);
                    break;
                case 42:
                    q1.h(i2, (List) z1.k(obj, iC & 1048575), f1, true);
                    break;
                case 43:
                    q1.x(i2, (List) z1.k(obj, iC & 1048575), f1, true);
                    break;
                case 44:
                    q1.k(i2, (List) z1.k(obj, iC & 1048575), f1, true);
                    break;
                case 45:
                    q1.s(i2, (List) z1.k(obj, iC & 1048575), f1, true);
                    break;
                case 46:
                    q1.t(i2, (List) z1.k(obj, iC & 1048575), f1, true);
                    break;
                case 47:
                    q1.u(i2, (List) z1.k(obj, iC & 1048575), f1, true);
                    break;
                case 48:
                    q1.v(i2, (List) z1.k(obj, iC & 1048575), f1, true);
                    break;
                case 49:
                    q1.o(i2, (List) z1.k(obj, iC & 1048575), f1, f(i));
                    break;
                case 50:
                    A(f1, i2, z1.k(obj, iC & 1048575), i);
                    break;
                case 51:
                    if (G(obj, i2, i)) {
                        f1.n(i2, N(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case Type.TLSA /* 52 */:
                    if (G(obj, i2, i)) {
                        f1.C(i2, O(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (G(obj, i2, i)) {
                        f1.j(i2, d(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (G(obj, i2, i)) {
                        f1.G(i2, d(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (G(obj, i2, i)) {
                        f1.m(i2, R(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case Type.NINFO /* 56 */:
                    if (G(obj, i2, i)) {
                        f1.H(i2, d(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (G(obj, i2, i)) {
                        f1.w(i2, R(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (G(obj, i2, i)) {
                        f1.h(i2, H(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (G(obj, i2, i)) {
                        I(i2, z1.k(obj, iC & 1048575), f1);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (G(obj, i2, i)) {
                        f1.J(i2, z1.k(obj, iC & 1048575), f(i));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (G(obj, i2, i)) {
                        f1.k(i2, (A0) z1.k(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (G(obj, i2, i)) {
                        f1.u(i2, R(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (G(obj, i2, i)) {
                        f1.A(i2, R(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (G(obj, i2, i)) {
                        f1.o(i2, R(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (G(obj, i2, i)) {
                        f1.x(i2, d(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (G(obj, i2, i)) {
                        f1.g(i2, R(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (G(obj, i2, i)) {
                        f1.s(i2, d(obj, iC & 1048575));
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (G(obj, i2, i)) {
                        f1.z(i2, z1.k(obj, iC & 1048575), f(i));
                        break;
                    } else {
                        break;
                    }
            }
        }
        s1 s1Var = this.l;
        s1Var.i(s1Var.d(obj), f1);
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final boolean m(Object obj, Object obj2) {
        boolean z;
        int length = this.a.length;
        for (int i = 0; i < length; i += 3) {
            int iC = c(i);
            long j = iC & 1048575;
            switch (b(iC)) {
                case 0:
                    if (!B(obj, obj2, i) || Double.doubleToLongBits(z1.f(obj, j)) != Double.doubleToLongBits(z1.f(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 1:
                    if (!B(obj, obj2, i) || Float.floatToIntBits(z1.g(obj, j)) != Float.floatToIntBits(z1.g(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 2:
                    if (!B(obj, obj2, i) || z1.i(obj, j) != z1.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 3:
                    if (!B(obj, obj2, i) || z1.i(obj, j) != z1.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 4:
                    if (!B(obj, obj2, i) || z1.h(obj, j) != z1.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 5:
                    if (!B(obj, obj2, i) || z1.i(obj, j) != z1.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 6:
                    if (!B(obj, obj2, i) || z1.h(obj, j) != z1.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 7:
                    if (!B(obj, obj2, i) || z1.B(obj, j) != z1.B(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 8:
                    if (!B(obj, obj2, i) || !q1.z(z1.k(obj, j), z1.k(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 9:
                    if (!B(obj, obj2, i) || !q1.z(z1.k(obj, j), z1.k(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 10:
                    if (!B(obj, obj2, i) || !q1.z(z1.k(obj, j), z1.k(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 11:
                    if (!B(obj, obj2, i) || z1.h(obj, j) != z1.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 12:
                    if (!B(obj, obj2, i) || z1.h(obj, j) != z1.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 13:
                    if (!B(obj, obj2, i) || z1.h(obj, j) != z1.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 14:
                    if (!B(obj, obj2, i) || z1.i(obj, j) != z1.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 15:
                    if (!B(obj, obj2, i) || z1.h(obj, j) != z1.h(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 16:
                    if (!B(obj, obj2, i) || z1.i(obj, j) != z1.i(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 17:
                    if (!B(obj, obj2, i) || !q1.z(z1.k(obj, j), z1.k(obj2, j))) {
                        return false;
                    }
                    continue;
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
                    z = q1.z(z1.k(obj, j), z1.k(obj2, j));
                    break;
                case 50:
                    z = q1.z(z1.k(obj, j), z1.k(obj2, j));
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
                    long jY = Y(i) & 1048575;
                    if (z1.h(obj, jY) != z1.h(obj2, jY) || !q1.z(z1.k(obj, j), z1.k(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                default:
            }
            if (!z) {
                return false;
            }
        }
        if (!this.l.d(obj).equals(this.l.d(obj2))) {
            return false;
        }
        if (!this.f) {
            return true;
        }
        this.m.a(obj);
        this.m.a(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.o1
    public final void n(Object obj, byte[] bArr, int i, int i2, C2142r0 c2142r0) throws zzkp {
        if (this.g) {
            U(obj, bArr, i, i2, c2142r0);
        } else {
            J(obj, bArr, i, i2, 0, c2142r0);
        }
    }
}
