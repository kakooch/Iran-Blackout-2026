package com.google.ads.interactivemedia.v3.internal;

import com.facebook.stetho.websocket.CloseCodes;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.if, reason: invalid class name */
/* loaded from: classes.dex */
public final class Cif {
    public static final /* synthetic */ int a = 0;
    private static final int[] b = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] c = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] d = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static cy a(byte[] bArr, String str, String str2) {
        aed aedVar;
        if (bArr[0] == 127) {
            aedVar = new aed(bArr);
        } else {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            byte b2 = bArrCopyOf[0];
            if (b2 == -2 || b2 == -1) {
                for (int i = 0; i < bArrCopyOf.length - 1; i += 2) {
                    byte b3 = bArrCopyOf[i];
                    int i2 = i + 1;
                    bArrCopyOf[i] = bArrCopyOf[i2];
                    bArrCopyOf[i2] = b3;
                }
            }
            aedVar = new aed(bArrCopyOf);
            if (bArrCopyOf[0] == 31) {
                aed aedVar2 = new aed(bArrCopyOf);
                while (aedVar2.c() >= 16) {
                    aedVar2.g(2);
                    aedVar.l(aedVar2.i(14));
                }
            }
            aedVar.a(bArrCopyOf);
        }
        aedVar.g(60);
        int i3 = b[aedVar.i(6)];
        int i4 = c[aedVar.i(4)];
        int i5 = aedVar.i(5);
        int i6 = i5 < 29 ? (d[i5] * CloseCodes.NORMAL_CLOSURE) / 2 : -1;
        aedVar.g(10);
        int i7 = aedVar.i(2) > 0 ? 1 : 0;
        cx cxVar = new cx();
        cxVar.S(str);
        cxVar.ae("audio/vnd.dts");
        cxVar.G(i6);
        cxVar.H(i3 + i7);
        cxVar.af(i4);
        cxVar.L(null);
        cxVar.V(str2);
        return cxVar.a();
    }
}
