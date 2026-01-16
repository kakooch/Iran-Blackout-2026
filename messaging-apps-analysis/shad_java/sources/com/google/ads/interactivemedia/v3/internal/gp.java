package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class gp {
    public static final /* synthetic */ int a = 0;
    private static final int[] b = {1, 2, 3, 6};
    private static final int[] c = {48000, 44100, 32000};
    private static final int[] d = {24000, 22050, 16000};
    private static final int[] e = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] f = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] g = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static cy a(aee aeeVar, String str, String str2, jc jcVar) {
        int i = c[(aeeVar.n() & 192) >> 6];
        int iN = aeeVar.n();
        int i2 = e[(iN & 56) >> 3];
        if ((iN & 4) != 0) {
            i2++;
        }
        cx cxVar = new cx();
        cxVar.S(str);
        cxVar.ae("audio/ac3");
        cxVar.H(i2);
        cxVar.af(i);
        cxVar.L(jcVar);
        cxVar.V(str2);
        return cxVar.a();
    }

    public static cy b(aee aeeVar, String str, String str2, jc jcVar) {
        aeeVar.k(2);
        int i = c[(aeeVar.n() & 192) >> 6];
        int iN = aeeVar.n();
        int i2 = e[(iN & 14) >> 1];
        if ((iN & 1) != 0) {
            i2++;
        }
        if (((aeeVar.n() & 30) >> 1) > 0 && (2 & aeeVar.n()) != 0) {
            i2 += 2;
        }
        String str3 = (aeeVar.d() <= 0 || (aeeVar.n() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc";
        cx cxVar = new cx();
        cxVar.S(str);
        cxVar.ae(str3);
        cxVar.H(i2);
        cxVar.af(i);
        cxVar.L(jcVar);
        cxVar.V(str2);
        return cxVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.ads.interactivemedia.v3.internal.go c(com.google.ads.interactivemedia.v3.internal.aed r19) {
        /*
            Method dump skipped, instructions count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.gp.c(com.google.ads.interactivemedia.v3.internal.aed):com.google.ads.interactivemedia.v3.internal.go");
    }

    public static int d(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) <= 10) {
            byte b2 = bArr[4];
            return f((b2 & 192) >> 6, b2 & 63);
        }
        int i = ((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1;
        return i + i;
    }

    public static int e(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return b[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    private static int f(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0 || i >= 3 || i2 < 0 || i3 >= 19) {
            return -1;
        }
        int i4 = c[i];
        if (i4 == 44100) {
            int i5 = g[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = f[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
