package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.rbmain.tgnet.ConnectionsManager;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class asn {
    static int a(Set<?> set) {
        Iterator<?> it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    public static <E> HashSet<E> b() {
        return new HashSet<>(h(4));
    }

    static <T> asm<T> c(Class<T> cls, String str) {
        try {
            return new asm<>(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    static <T> T[] e(T[] tArr, int i) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
    }

    static void f(Object obj, int i) {
        if (obj != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i);
        throw new NullPointerException(sb.toString());
    }

    public static <K, V> HashMap<K, V> g(int i) {
        return new HashMap<>(h(i));
    }

    static int h(int i) {
        if (i >= 3) {
            return i < 1073741824 ? (int) ((i / 0.75f) + 1.0f) : ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        ary.n(i, "expectedSize");
        return i + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean i(com.google.ads.interactivemedia.v3.internal.aee r17, com.google.ads.interactivemedia.v3.internal.kh r18, int r19, com.google.ads.interactivemedia.v3.internal.kd r20) {
        /*
            r0 = r17
            r1 = r18
            int r2 = r17.g()
            long r3 = r17.t()
            r5 = 16
            long r5 = r3 >>> r5
            r7 = r19
            long r7 = (long) r7
            r9 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 == 0) goto L19
            return r9
        L19:
            r7 = 1
            long r5 = r5 & r7
            r10 = 1
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 != 0) goto L23
            r5 = 1
            goto L24
        L23:
            r5 = 0
        L24:
            r6 = 12
            long r11 = r3 >> r6
            r13 = 15
            long r11 = r11 & r13
            int r12 = (int) r11
            r11 = 8
            long r15 = r3 >> r11
            long r6 = r15 & r13
            int r7 = (int) r6
            r6 = 4
            long r15 = r3 >> r6
            long r13 = r13 & r15
            int r6 = (int) r13
            long r13 = r3 >> r10
            r15 = 7
            long r13 = r13 & r15
            int r8 = (int) r13
            r13 = 1
            long r3 = r3 & r13
            r11 = 7
            r13 = -1
            if (r6 > r11) goto L4b
            int r11 = r1.g
            int r11 = r11 + r13
            if (r6 != r11) goto Lb1
            goto L54
        L4b:
            r11 = 10
            if (r6 > r11) goto Lb1
            int r6 = r1.g
            r11 = 2
            if (r6 != r11) goto Lb1
        L54:
            if (r8 != 0) goto L59
        L56:
            r14 = 1
            goto L5e
        L59:
            int r6 = r1.i
            if (r8 != r6) goto Lb1
            goto L56
        L5e:
            int r6 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r6 == 0) goto Lb1
            r3 = r20
            boolean r3 = t(r0, r1, r5, r3)
            if (r3 == 0) goto Lb1
            int r3 = j(r0, r12)
            if (r3 == r13) goto Lb1
            int r4 = r1.b
            if (r3 > r4) goto Lb1
            int r3 = r1.e
            if (r7 != 0) goto L79
            goto L9d
        L79:
            r4 = 11
            if (r7 > r4) goto L82
            int r1 = r1.f
            if (r7 == r1) goto L9d
            goto Lb1
        L82:
            r1 = 12
            if (r7 != r1) goto L8f
            int r1 = r17.n()
            int r1 = r1 * 1000
            if (r1 != r3) goto Lb1
            goto L9d
        L8f:
            r1 = 14
            if (r7 > r1) goto Lb1
            int r4 = r17.o()
            if (r7 != r1) goto L9b
            int r4 = r4 * 10
        L9b:
            if (r4 != r3) goto Lb1
        L9d:
            int r1 = r17.n()
            int r3 = r17.g()
            byte[] r0 = r17.i()
            int r3 = r3 + r13
            int r0 = com.google.ads.interactivemedia.v3.internal.aeu.ap(r0, r2, r3)
            if (r1 != r0) goto Lb1
            return r10
        Lb1:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.asn.i(com.google.ads.interactivemedia.v3.internal.aee, com.google.ads.interactivemedia.v3.internal.kh, int, com.google.ads.interactivemedia.v3.internal.kd):boolean");
    }

    public static int j(aee aeeVar, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return aeeVar.n() + 1;
            case 7:
                return aeeVar.o() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    public static boolean k(jv jvVar, kh khVar, int i, kd kdVar) throws IOException {
        long jK = jvVar.k();
        byte[] bArr = new byte[2];
        jvVar.g(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
            jvVar.j();
            jvVar.i((int) (jK - jvVar.l()));
            return false;
        }
        aee aeeVar = new aee(16);
        System.arraycopy(bArr, 0, aeeVar.i(), 0, 2);
        aeeVar.f(n(jvVar, aeeVar.i(), 2, 14));
        jvVar.j();
        jvVar.i((int) (jK - jvVar.l()));
        return i(aeeVar, khVar, i, kdVar);
    }

    public static long l(jv jvVar, kh khVar) throws IOException {
        jvVar.j();
        jvVar.i(1);
        byte[] bArr = new byte[1];
        jvVar.g(bArr, 0, 1);
        int i = bArr[0] & 1;
        jvVar.i(2);
        int i2 = 1 != i ? 6 : 7;
        aee aeeVar = new aee(i2);
        aeeVar.f(n(jvVar, aeeVar.i(), 0, i2));
        jvVar.j();
        kd kdVar = new kd();
        if (t(aeeVar, khVar, 1 == i, kdVar)) {
            return kdVar.a;
        }
        throw new dt();
    }

    public static jy[] m(kc kcVar) {
        return kcVar.a();
    }

    public static int n(jv jvVar, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int iE = jvVar.e(bArr, i + i3, i2 - i3);
            if (iE == -1) {
                break;
            }
            i3 += iE;
        }
        return i3;
    }

    public static void o(long j, aee aeeVar, kr[] krVarArr) {
        int iV;
        while (true) {
            if (aeeVar.d() <= 1) {
                return;
            }
            int iU = u(aeeVar);
            int iU2 = u(aeeVar);
            int iG = aeeVar.g() + iU2;
            if (iU2 == -1 || iU2 > aeeVar.d()) {
                Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iG = aeeVar.e();
            } else if (iU == 4 && iU2 >= 8) {
                int iN = aeeVar.n();
                int iO = aeeVar.o();
                if (iO == 49) {
                    iV = aeeVar.v();
                    iO = 49;
                } else {
                    iV = 0;
                }
                int iN2 = aeeVar.n();
                if (iO == 47) {
                    aeeVar.k(1);
                }
                boolean z = iN == 181 && (iO == 49 || iO == 47) && iN2 == 3;
                if (iO == 49) {
                    z &= iV == 1195456820;
                }
                if (z) {
                    p(j, aeeVar, krVarArr);
                }
            }
            aeeVar.h(iG);
        }
    }

    public static void p(long j, aee aeeVar, kr[] krVarArr) {
        int iN = aeeVar.n();
        if ((iN & 64) != 0) {
            aeeVar.k(1);
            int i = (iN & 31) * 3;
            int iG = aeeVar.g();
            for (kr krVar : krVarArr) {
                aeeVar.h(iG);
                krVar.d(aeeVar, i);
                krVar.b(j, 1, i, 0, null);
            }
        }
    }

    public static int q(int i) {
        return i;
    }

    public static int r(int i) {
        return i & 7;
    }

    public static void s(String str, Exception exc) {
        if (b.a.booleanValue()) {
            TextUtils.isEmpty(str);
        }
        Log.e("OMIDLIB", str, exc);
    }

    private static boolean t(aee aeeVar, kh khVar, boolean z, kd kdVar) {
        try {
            long J = aeeVar.J();
            if (!z) {
                J *= khVar.b;
            }
            kdVar.a = J;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private static int u(aee aeeVar) {
        int i = 0;
        while (aeeVar.d() != 0) {
            int iN = aeeVar.n();
            i += iN;
            if (iN != 255) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0022 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean d(java.lang.Object[] r3, java.lang.Object r4) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            goto L27
        L4:
            if (r4 != 0) goto L12
            r4 = 0
        L7:
            int r1 = r3.length
            if (r4 >= r1) goto L27
            r1 = r3[r4]
            if (r1 != 0) goto Lf
            goto L1f
        Lf:
            int r4 = r4 + 1
            goto L7
        L12:
            r1 = 0
        L13:
            int r2 = r3.length
            if (r1 >= r2) goto L27
            r2 = r3[r1]
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L24
            r4 = r1
        L1f:
            r3 = -1
            if (r4 == r3) goto L27
            r3 = 1
            return r3
        L24:
            int r1 = r1 + 1
            goto L13
        L27:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.asn.d(java.lang.Object[], java.lang.Object):boolean");
    }
}
