package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class gn {
    public static final /* synthetic */ int a = 0;
    private static final int[] b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static gm a(byte[] bArr) throws dt {
        return b(new aed(bArr), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ba, code lost:
    
        if (r12 != 3) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.ads.interactivemedia.v3.internal.gm b(com.google.ads.interactivemedia.v3.internal.aed r12, boolean r13) throws com.google.ads.interactivemedia.v3.internal.dt {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.gn.b(com.google.ads.interactivemedia.v3.internal.aed, boolean):com.google.ads.interactivemedia.v3.internal.gm");
    }

    public static int c(int i) {
        if (i == 2) {
            return 10;
        }
        if (i == 5) {
            return 11;
        }
        if (i == 29) {
            return 12;
        }
        if (i == 42) {
            return 16;
        }
        if (i != 22) {
            return i != 23 ? 0 : 15;
        }
        return 1073741824;
    }

    private static int d(aed aedVar) {
        int i = aedVar.i(5);
        return i == 31 ? aedVar.i(6) + 32 : i;
    }

    private static int e(aed aedVar) {
        int i = aedVar.i(4);
        if (i == 15) {
            return aedVar.i(24);
        }
        ary.o(i < 13);
        return b[i];
    }
}
