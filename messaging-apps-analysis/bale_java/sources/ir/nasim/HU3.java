package ir.nasim;

/* loaded from: classes3.dex */
abstract class HU3 {
    static int a(C5722Ko0 c5722Ko0) {
        return b(c5722Ko0, true) + b(c5722Ko0, false);
    }

    private static int b(C5722Ko0 c5722Ko0, boolean z) {
        int iD = z ? c5722Ko0.d() : c5722Ko0.e();
        int iE = z ? c5722Ko0.e() : c5722Ko0.d();
        byte[][] bArrC = c5722Ko0.c();
        int i = 0;
        for (int i2 = 0; i2 < iD; i2++) {
            byte b = -1;
            int i3 = 0;
            for (int i4 = 0; i4 < iE; i4++) {
                byte b2 = z ? bArrC[i2][i4] : bArrC[i4][i2];
                if (b2 == b) {
                    i3++;
                } else {
                    if (i3 >= 5) {
                        i += i3 - 2;
                    }
                    i3 = 1;
                    b = b2;
                }
            }
            if (i3 >= 5) {
                i += i3 - 2;
            }
        }
        return i;
    }

    static int c(C5722Ko0 c5722Ko0) {
        byte[][] bArrC = c5722Ko0.c();
        int iE = c5722Ko0.e();
        int iD = c5722Ko0.d();
        int i = 0;
        for (int i2 = 0; i2 < iD - 1; i2++) {
            byte[] bArr = bArrC[i2];
            int i3 = 0;
            while (i3 < iE - 1) {
                byte b = bArr[i3];
                int i4 = i3 + 1;
                if (b == bArr[i4]) {
                    byte[] bArr2 = bArrC[i2 + 1];
                    if (b == bArr2[i3] && b == bArr2[i4]) {
                        i++;
                    }
                }
                i3 = i4;
            }
        }
        return i * 3;
    }

    static int d(C5722Ko0 c5722Ko0) {
        byte[][] bArrC = c5722Ko0.c();
        int iE = c5722Ko0.e();
        int iD = c5722Ko0.d();
        int i = 0;
        for (int i2 = 0; i2 < iD; i2++) {
            for (int i3 = 0; i3 < iE; i3++) {
                byte[] bArr = bArrC[i2];
                int i4 = i3 + 6;
                if (i4 < iE && bArr[i3] == 1 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 1 && bArr[i3 + 3] == 1 && bArr[i3 + 4] == 1 && bArr[i3 + 5] == 0 && bArr[i4] == 1 && (g(bArr, i3 - 4, i3) || g(bArr, i3 + 7, i3 + 11))) {
                    i++;
                }
                int i5 = i2 + 6;
                if (i5 < iD && bArrC[i2][i3] == 1 && bArrC[i2 + 1][i3] == 0 && bArrC[i2 + 2][i3] == 1 && bArrC[i2 + 3][i3] == 1 && bArrC[i2 + 4][i3] == 1 && bArrC[i2 + 5][i3] == 0 && bArrC[i5][i3] == 1 && (h(bArrC, i3, i2 - 4, i2) || h(bArrC, i3, i2 + 7, i2 + 11))) {
                    i++;
                }
            }
        }
        return i * 40;
    }

    static int e(C5722Ko0 c5722Ko0) {
        byte[][] bArrC = c5722Ko0.c();
        int iE = c5722Ko0.e();
        int iD = c5722Ko0.d();
        int i = 0;
        for (int i2 = 0; i2 < iD; i2++) {
            byte[] bArr = bArrC[i2];
            for (int i3 = 0; i3 < iE; i3++) {
                if (bArr[i3] == 1) {
                    i++;
                }
            }
        }
        int iD2 = c5722Ko0.d() * c5722Ko0.e();
        return ((Math.abs((i << 1) - iD2) * 10) / iD2) * 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static boolean f(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L30;
                case 1: goto L31;
                case 2: goto L38;
                case 3: goto L34;
                case 4: goto L2c;
                case 5: goto L25;
                case 6: goto L1e;
                case 7: goto L14;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Invalid mask pattern: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L14:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
        L1c:
            r1 = r1 & r0
            goto L3a
        L1e:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L1c
        L25:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L3a
        L2c:
            int r3 = r3 / 2
            int r2 = r2 / 3
        L30:
            int r3 = r3 + r2
        L31:
            r1 = r3 & 1
            goto L3a
        L34:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L3a
        L38:
            int r1 = r2 % 3
        L3a:
            if (r1 != 0) goto L3d
            return r0
        L3d:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.HU3.f(int, int, int):boolean");
    }

    private static boolean g(byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, bArr.length);
        for (int iMax = Math.max(i, 0); iMax < iMin; iMax++) {
            if (bArr[iMax] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean h(byte[][] bArr, int i, int i2, int i3) {
        int iMin = Math.min(i3, bArr.length);
        for (int iMax = Math.max(i2, 0); iMax < iMin; iMax++) {
            if (bArr[iMax][i] == 1) {
                return false;
            }
        }
        return true;
    }
}
