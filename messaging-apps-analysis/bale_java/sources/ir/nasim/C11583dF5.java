package ir.nasim;

import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import com.google.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.dF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C11583dF5 extends B1 {
    private static final int[] i = {1, 10, 34, 70, 126};
    private static final int[] j = {4, 20, 48, 81};
    private static final int[] k = {0, SetUpdatesStruct$ComposedUpdates.OWN_STICKERS_CHANGED_FIELD_NUMBER, 961, 2015, 2715};
    private static final int[] l = {0, 336, 1036, 1516};
    private static final int[] m = {8, 6, 4, 3, 1};
    private static final int[] n = {2, 4, 6, 8};
    private static final int[][] o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List g = new ArrayList();
    private final List h = new ArrayList();

    private static void q(Collection collection, WV4 wv4) {
        if (wv4 == null) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            WV4 wv42 = (WV4) it.next();
            if (wv42.b() == wv4.b()) {
                wv42.e();
                return;
            }
        }
        collection.add(wv4);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a A[PHI: r6 r7
      0x002a: PHI (r6v5 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x002a: PHI (r7v5 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[PHI: r6 r7
      0x002d: PHI (r6v4 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x002d: PHI (r7v4 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void r(boolean r10, int r11) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11583dF5.r(boolean, int):void");
    }

    private static boolean s(WV4 wv4, WV4 wv42) {
        int iA = (wv4.a() + (wv42.a() * 16)) % 79;
        int iC = (wv4.d().c() * 9) + wv42.d().c();
        if (iC > 72) {
            iC--;
        }
        if (iC > 8) {
            iC--;
        }
        return iA == iC;
    }

    private static X06 t(WV4 wv4, WV4 wv42) {
        String strValueOf = String.valueOf((wv4.b() * 4537077) + wv42.b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int iCharAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                iCharAt *= 3;
            }
            i2 += iCharAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        C12092e16[] c12092e16ArrA = wv4.d().a();
        C12092e16[] c12092e16ArrA2 = wv42.d().a();
        return new X06(sb.toString(), null, new C12092e16[]{c12092e16ArrA[0], c12092e16ArrA[1], c12092e16ArrA2[0], c12092e16ArrA2[1]}, EnumC9549a90.RSS_14);
    }

    private C7491Ry1 u(C3988Df0 c3988Df0, C24550yo2 c24550yo2, boolean z) throws NotFoundException {
        int[] iArrH = h();
        for (int i2 = 0; i2 < iArrH.length; i2++) {
            iArrH[i2] = 0;
        }
        if (z) {
            MK4.f(c3988Df0, c24550yo2.b()[0], iArrH);
        } else {
            MK4.e(c3988Df0, c24550yo2.b()[1] + 1, iArrH);
            int i3 = 0;
            for (int length = iArrH.length - 1; i3 < length; length--) {
                int i4 = iArrH[i3];
                iArrH[i3] = iArrH[length];
                iArrH[length] = i4;
                i3++;
            }
        }
        int i5 = z ? 16 : 15;
        float fD = AbstractC23186wV3.d(iArrH) / i5;
        int[] iArrL = l();
        int[] iArrJ = j();
        float[] fArrM = m();
        float[] fArrK = k();
        for (int i6 = 0; i6 < iArrH.length; i6++) {
            float f = iArrH[i6] / fD;
            int i7 = (int) (0.5f + f);
            if (i7 <= 0) {
                i7 = 1;
            } else if (i7 > 8) {
                i7 = 8;
            }
            int i8 = i6 / 2;
            if ((i6 & 1) == 0) {
                iArrL[i8] = i7;
                fArrM[i8] = f - i7;
            } else {
                iArrJ[i8] = i7;
                fArrK[i8] = f - i7;
            }
        }
        r(z, i5);
        int i9 = 0;
        int i10 = 0;
        for (int length2 = iArrL.length - 1; length2 >= 0; length2--) {
            int i11 = iArrL[length2];
            i9 = (i9 * 9) + i11;
            i10 += i11;
        }
        int i12 = 0;
        int i13 = 0;
        for (int length3 = iArrJ.length - 1; length3 >= 0; length3--) {
            int i14 = iArrJ[length3];
            i12 = (i12 * 9) + i14;
            i13 += i14;
        }
        int i15 = i9 + (i12 * 3);
        if (!z) {
            if ((i13 & 1) != 0 || i13 > 10 || i13 < 4) {
                throw NotFoundException.a();
            }
            int i16 = (10 - i13) / 2;
            int i17 = n[i16];
            return new C7491Ry1((AbstractC12835fF5.b(iArrJ, 9 - i17, false) * j[i16]) + AbstractC12835fF5.b(iArrL, i17, true) + l[i16], i15);
        }
        if ((i10 & 1) != 0 || i10 > 12 || i10 < 4) {
            throw NotFoundException.a();
        }
        int i18 = (12 - i10) / 2;
        int i19 = m[i18];
        return new C7491Ry1((AbstractC12835fF5.b(iArrL, i19, false) * i[i18]) + AbstractC12835fF5.b(iArrJ, 9 - i19, true) + k[i18], i15);
    }

    private WV4 v(C3988Df0 c3988Df0, boolean z, int i2, Map map) {
        try {
            C24550yo2 c24550yo2X = x(c3988Df0, i2, z, w(c3988Df0, z));
            if (map != null) {
                AbstractC18350oW3.a(map.get(EnumC19932rB1.NEED_RESULT_POINT_CALLBACK));
            }
            C7491Ry1 c7491Ry1U = u(c3988Df0, c24550yo2X, true);
            C7491Ry1 c7491Ry1U2 = u(c3988Df0, c24550yo2X, false);
            return new WV4((c7491Ry1U.b() * 1597) + c7491Ry1U2.b(), c7491Ry1U.a() + (c7491Ry1U2.a() * 4), c24550yo2X);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private int[] w(C3988Df0 c3988Df0, boolean z) throws NotFoundException {
        int[] iArrI = i();
        iArrI[0] = 0;
        iArrI[1] = 0;
        iArrI[2] = 0;
        iArrI[3] = 0;
        int iN = c3988Df0.n();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < iN) {
            z2 = !c3988Df0.i(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = 0;
        int i4 = i2;
        while (i2 < iN) {
            if (c3988Df0.i(i2) != z2) {
                iArrI[i3] = iArrI[i3] + 1;
            } else {
                if (i3 != 3) {
                    i3++;
                } else {
                    if (B1.o(iArrI)) {
                        return new int[]{i4, i2};
                    }
                    i4 += iArrI[0] + iArrI[1];
                    iArrI[0] = iArrI[2];
                    iArrI[1] = iArrI[3];
                    iArrI[2] = 0;
                    iArrI[3] = 0;
                    i3--;
                }
                iArrI[i3] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw NotFoundException.a();
    }

    private C24550yo2 x(C3988Df0 c3988Df0, int i2, boolean z, int[] iArr) throws NotFoundException {
        int iN;
        int i3;
        boolean zI = c3988Df0.i(iArr[0]);
        int i4 = iArr[0] - 1;
        while (i4 >= 0 && zI != c3988Df0.i(i4)) {
            i4--;
        }
        int i5 = i4 + 1;
        int i6 = iArr[0] - i5;
        int[] iArrI = i();
        System.arraycopy(iArrI, 0, iArrI, 1, iArrI.length - 1);
        iArrI[0] = i6;
        int iP = B1.p(iArrI, o);
        int i7 = iArr[1];
        if (z) {
            int iN2 = (c3988Df0.n() - 1) - i5;
            iN = (c3988Df0.n() - 1) - i7;
            i3 = iN2;
        } else {
            iN = i7;
            i3 = i5;
        }
        return new C24550yo2(iP, new int[]{i5, iArr[1]}, i3, iN, i2);
    }

    @Override // ir.nasim.MK4
    public X06 b(int i2, C3988Df0 c3988Df0, Map map) throws NotFoundException {
        q(this.g, v(c3988Df0, false, i2, map));
        c3988Df0.r();
        q(this.h, v(c3988Df0, true, i2, map));
        c3988Df0.r();
        for (WV4 wv4 : this.g) {
            if (wv4.c() > 1) {
                for (WV4 wv42 : this.h) {
                    if (wv42.c() > 1 && s(wv4, wv42)) {
                        return t(wv4, wv42);
                    }
                }
            }
        }
        throw NotFoundException.a();
    }

    @Override // ir.nasim.MK4, ir.nasim.BI5
    public void reset() {
        this.g.clear();
        this.h.clear();
    }
}
