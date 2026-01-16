package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;
import org.rbmain.messenger.LiteMode;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aaw extends abf {
    public static final /* synthetic */ int a = 0;
    private static final int[] b = new int[0];
    private static final asc<Integer> c = asc.c(aal.a);
    private static final asc<Integer> d = asc.c(aam.a);
    private final AtomicReference<aaq> e;
    private final aah f;

    @Deprecated
    public aaw() {
        aaq aaqVar = aaq.a;
        throw null;
    }

    protected static boolean b(int i, boolean z) {
        int iR = asn.r(i);
        return iR == 4 || (z && iR == 3);
    }

    protected static String c(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    protected static int d(cy cyVar, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(cyVar.c)) {
            return 4;
        }
        String strC = c(str);
        String strC2 = c(cyVar.c);
        if (strC2 == null || strC == null) {
            return (z && strC2 == null) ? 1 : 0;
        }
        if (strC2.startsWith(strC) || strC.startsWith(strC2)) {
            return 3;
        }
        return aeu.A(strC2, "-")[0].equals(aeu.A(strC, "-")[0]) ? 2 : 0;
    }

    private static boolean j(cy cyVar, String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if ((cyVar.e & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) != 0 || !b(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !aeu.c(cyVar.l, str)) {
            return false;
        }
        int i11 = cyVar.q;
        if (i11 != -1 && (i7 > i11 || i11 > i3)) {
            return false;
        }
        int i12 = cyVar.r;
        if (i12 != -1 && (i8 > i12 || i12 > i4)) {
            return false;
        }
        float f = cyVar.s;
        if (f != -1.0f && (i9 > f || f > i5)) {
            return false;
        }
        int i13 = cyVar.h;
        if (i13 != -1) {
            return i10 <= i13 && i13 <= i6;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<java.lang.Integer> k(com.google.ads.interactivemedia.v3.internal.vh r12, int r13, int r14, boolean r15) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r12.a
            r0.<init>(r1)
            r1 = 0
            r2 = 0
        L9:
            int r3 = r12.a
            if (r2 >= r3) goto L17
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.add(r3)
            int r2 = r2 + 1
            goto L9
        L17:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r13 == r2) goto La3
            if (r14 == r2) goto La3
            r3 = 0
            r4 = 2147483647(0x7fffffff, float:NaN)
        L22:
            int r5 = r12.a
            if (r3 >= r5) goto L7d
            com.google.ads.interactivemedia.v3.internal.cy r5 = r12.a(r3)
            int r6 = r5.q
            if (r6 <= 0) goto L7a
            int r7 = r5.r
            if (r7 <= 0) goto L7a
            if (r15 == 0) goto L42
            r8 = 1
            if (r6 > r7) goto L39
            r9 = 0
            goto L3a
        L39:
            r9 = 1
        L3a:
            if (r13 > r14) goto L3d
            r8 = 0
        L3d:
            if (r9 == r8) goto L42
            r8 = r13
            r9 = r14
            goto L44
        L42:
            r9 = r13
            r8 = r14
        L44:
            int r10 = r6 * r8
            int r11 = r7 * r9
            if (r10 < r11) goto L54
            android.graphics.Point r7 = new android.graphics.Point
            int r6 = com.google.ads.interactivemedia.v3.internal.aeu.F(r11, r6)
            r7.<init>(r9, r6)
            goto L5e
        L54:
            android.graphics.Point r6 = new android.graphics.Point
            int r7 = com.google.ads.interactivemedia.v3.internal.aeu.F(r10, r7)
            r6.<init>(r7, r8)
            r7 = r6
        L5e:
            int r6 = r5.q
            int r5 = r5.r
            int r8 = r6 * r5
            int r9 = r7.x
            float r9 = (float) r9
            r10 = 1065017672(0x3f7ae148, float:0.98)
            float r9 = r9 * r10
            int r9 = (int) r9
            if (r6 < r9) goto L7a
            int r6 = r7.y
            float r6 = (float) r6
            float r6 = r6 * r10
            int r6 = (int) r6
            if (r5 < r6) goto L7a
            if (r8 >= r4) goto L7a
            r4 = r8
        L7a:
            int r3 = r3 + 1
            goto L22
        L7d:
            if (r4 == r2) goto La3
            int r13 = r0.size()
            r14 = -1
            int r13 = r13 + r14
        L85:
            if (r13 < 0) goto La3
            java.lang.Object r15 = r0.get(r13)
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            com.google.ads.interactivemedia.v3.internal.cy r15 = r12.a(r15)
            int r15 = r15.d()
            if (r15 == r14) goto L9d
            if (r15 <= r4) goto La0
        L9d:
            r0.remove(r13)
        La0:
            int r13 = r13 + (-1)
            goto L85
        La3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aaw.k(com.google.ads.interactivemedia.v3.internal.vh, int, int, boolean):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:173:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x015b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0161 A[LOOP:1: B:23:0x004a->B:65:0x0161, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x020f  */
    @Override // com.google.ads.interactivemedia.v3.internal.abf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final android.util.Pair<com.google.ads.interactivemedia.v3.internal.ef[], com.google.ads.interactivemedia.v3.internal.aba[]> a(com.google.ads.interactivemedia.v3.internal.aay r44, int[][][] r45, int[] r46) throws com.google.ads.interactivemedia.v3.internal.bn {
        /*
            Method dump skipped, instructions count: 1645
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aaw.a(com.google.ads.interactivemedia.v3.internal.aay, int[][][], int[]):android.util.Pair");
    }

    public aaw(aaq aaqVar, aah aahVar) {
        super(null);
        this.f = aahVar;
        this.e = new AtomicReference<>(aaqVar);
    }
}
