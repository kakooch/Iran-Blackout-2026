package ir.nasim;

import java.util.List;

/* loaded from: classes.dex */
public abstract class H66 {
    public static final InterfaceC11734dW3 a(G66 g66, int i, int i2, int i3, int i4, int i5, InterfaceC12377eW3 interfaceC12377eW3, List list, AbstractC21430te5[] abstractC21430te5Arr, int i6, int i7, int[] iArr, int i8) {
        int i9;
        int i10;
        int i11;
        float f;
        int iMax;
        int i12;
        int i13;
        int i14;
        int[] iArr2;
        int i15;
        long j = i5;
        int i16 = i7 - i6;
        int[] iArr3 = new int[i16];
        int i17 = 0;
        int i18 = i6;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        float f2 = 0.0f;
        while (i18 < i7) {
            ZV3 zv3 = (ZV3) list.get(i18);
            I66 i66C = F66.c(zv3);
            float fE = F66.e(i66C);
            i22 = (i22 != 0 || F66.f(i66C)) ? 1 : i17;
            if (fE > 0.0f) {
                f2 += fE;
                i21++;
                i14 = i18;
                i15 = i16;
            } else {
                if (i4 != Integer.MAX_VALUE && i66C != null) {
                    i66C.c();
                }
                int i24 = i3 - i23;
                AbstractC21430te5 abstractC21430te5L0 = abstractC21430te5Arr[i18];
                if (abstractC21430te5L0 == null) {
                    i13 = i20;
                    i14 = i18;
                    iArr2 = iArr3;
                    i15 = i16;
                    abstractC21430te5L0 = zv3.l0(G66.n(g66, 0, 0, i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : i24 < 0 ? i17 : i24, i4, false, 16, null));
                } else {
                    i13 = i20;
                    i14 = i18;
                    iArr2 = iArr3;
                    i15 = i16;
                }
                int iG = g66.g(abstractC21430te5L0);
                int iC = g66.c(abstractC21430te5L0);
                iArr3 = iArr2;
                iArr3[i14 - i6] = iG;
                int i25 = i24 - iG;
                if (i25 < 0) {
                    i25 = 0;
                }
                int iMin = Math.min(i5, i25);
                i23 += iG + iMin;
                int iMax2 = Math.max(i13, iC);
                abstractC21430te5Arr[i14] = abstractC21430te5L0;
                i19 = iMin;
                i20 = iMax2;
            }
            i18 = i14 + 1;
            i16 = i15;
            i17 = 0;
        }
        int i26 = i20;
        int i27 = i16;
        if (i21 == 0) {
            i23 -= i19;
            i10 = i26;
            i9 = 0;
        } else {
            long j2 = j * (i21 - 1);
            long jRound = ((i3 != Integer.MAX_VALUE ? i3 : i) - i23) - j2;
            if (jRound < 0) {
                jRound = 0;
            }
            float f3 = jRound / f2;
            for (int i28 = i6; i28 < i7; i28++) {
                jRound -= Math.round(F66.e(F66.c((ZV3) list.get(i28))) * f3);
            }
            int i29 = i6;
            int i30 = 0;
            while (i29 < i7) {
                if (abstractC21430te5Arr[i29] == null) {
                    ZV3 zv32 = (ZV3) list.get(i29);
                    I66 i66C2 = F66.c(zv32);
                    float fE2 = F66.e(i66C2);
                    if (i4 != Integer.MAX_VALUE && i66C2 != null) {
                        i66C2.c();
                    }
                    if (!(fE2 > 0.0f)) {
                        K73.b("All weights <= 0 should have placeables");
                    }
                    int iB = AbstractC20723sV3.b(jRound);
                    int i31 = i29;
                    long j3 = jRound - iB;
                    int iMax3 = Math.max(0, Math.round(fE2 * f3) + iB);
                    i11 = i31;
                    f = f3;
                    AbstractC21430te5 abstractC21430te5L02 = zv32.l0(g66.f((!F66.b(i66C2) || iMax3 == Integer.MAX_VALUE) ? 0 : iMax3, 0, iMax3, i4, true));
                    int iG2 = g66.g(abstractC21430te5L02);
                    int iC2 = g66.c(abstractC21430te5L02);
                    iArr3[i11 - i6] = iG2;
                    i30 += iG2;
                    int iMax4 = Math.max(i26, iC2);
                    abstractC21430te5Arr[i11] = abstractC21430te5L02;
                    i26 = iMax4;
                    jRound = j3;
                } else {
                    i11 = i29;
                    f = f3;
                }
                i29 = i11 + 1;
                f3 = f;
            }
            int i32 = i26;
            i9 = (int) (i30 + j2);
            int i33 = i3 - i23;
            if (i9 < 0) {
                i9 = 0;
            }
            if (i9 > i33) {
                i9 = i33;
            }
            i10 = i32;
        }
        if (i22 != 0) {
            int iMax5 = 0;
            iMax = 0;
            for (int i34 = i6; i34 < i7; i34++) {
                AbstractC21430te5 abstractC21430te5 = abstractC21430te5Arr[i34];
                AbstractC13042fc3.f(abstractC21430te5);
                AbstractC5075Hu1 abstractC5075Hu1A = F66.a(F66.d(abstractC21430te5));
                Integer numB = abstractC5075Hu1A != null ? abstractC5075Hu1A.b(abstractC21430te5) : null;
                if (numB != null) {
                    int iIntValue = numB.intValue();
                    int iC3 = g66.c(abstractC21430te5);
                    iMax5 = Math.max(iMax5, iIntValue != Integer.MIN_VALUE ? numB.intValue() : 0);
                    if (iIntValue == Integer.MIN_VALUE) {
                        iIntValue = iC3;
                    }
                    iMax = Math.max(iMax, iC3 - iIntValue);
                }
            }
            i12 = iMax5;
        } else {
            iMax = 0;
            i12 = 0;
        }
        int i35 = i23 + i9;
        if (i35 < 0) {
            i35 = 0;
        }
        int iMax6 = Math.max(i35, i);
        int iMax7 = Math.max(i10, Math.max(i2, iMax + i12));
        int[] iArr4 = new int[i27];
        g66.j(iMax6, iArr3, iArr4, interfaceC12377eW3);
        return g66.e(abstractC21430te5Arr, interfaceC12377eW3, i12, iArr4, iMax6, iMax7, iArr, i8, i6, i7);
    }
}
