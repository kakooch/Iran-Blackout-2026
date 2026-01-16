package com.google.ads.interactivemedia.v3.internal;

import org.rbmain.messenger.OneUIUtilities;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class il {
    private static final String[] a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] b = {44100, 48000, 32000};
    private static final int[] c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
    private static final int[] d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
    private static final int[] e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
    private static final int[] f = {32000, OneUIUtilities.ONE_UI_4_0, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    private static final int[] g = {8000, 16000, 24000, 32000, OneUIUtilities.ONE_UI_4_0, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static int b(int i) {
        int i2;
        int i3;
        if (!l(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        int i5 = (i >>> 10) & 3;
        if (i4 == 0 || i4 == 15 || i5 == 3) {
            return -1;
        }
        return m(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(int i) {
        return (i & (-2097152)) == -2097152;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(int i, int i2) {
        return i2 != 1 ? i2 != 2 ? 384 : 1152 : i == 3 ? 1152 : 576;
    }

    public static int a(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (!l(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i6 = b[i5];
        if (i2 == 2) {
            i6 /= 2;
        } else if (i2 == 0) {
            i6 /= 4;
        }
        int i7 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? c[i4 - 1] : d[i4 - 1]) * 12) / i6) + i7) * 4;
        }
        int i8 = i2 == 3 ? i3 == 2 ? e[i4 - 1] : f[i4 - 1] : g[i4 - 1];
        if (i2 == 3) {
            return ((i8 * 144) / i6) + i7;
        }
        return (((i3 == 1 ? 72 : 144) * i8) / i6) + i7;
    }
}
