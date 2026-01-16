package com.google.ads.interactivemedia.v3.internal;

import com.facebook.stetho.websocket.CloseCodes;
import org.rbmain.messenger.MediaController;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class gr {
    public static final /* synthetic */ int a = 0;
    private static final int[] b = {2002, 2000, 1920, 1601, 1600, 1001, CloseCodes.NORMAL_CLOSURE, 960, MediaController.MAX_WIDTH_HEIGHT_SIZE, MediaController.MAX_WIDTH_HEIGHT_SIZE, 480, 400, 400, 2048};

    /* JADX WARN: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.ads.interactivemedia.v3.internal.gq a(com.google.ads.interactivemedia.v3.internal.aed r10) {
        /*
            r0 = 16
            int r1 = r10.i(r0)
            int r0 = r10.i(r0)
            r2 = 4
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r0 != r3) goto L18
            r0 = 24
            int r0 = r10.i(r0)
            r3 = 7
            goto L19
        L18:
            r3 = 4
        L19:
            int r0 = r0 + r3
            r3 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r3) goto L21
            int r0 = r0 + 2
        L21:
            r1 = 2
            int r3 = r10.i(r1)
            r4 = 3
            if (r3 != r4) goto L32
        L29:
            r10.i(r1)
            boolean r3 = r10.h()
            if (r3 != 0) goto L29
        L32:
            r3 = 10
            int r3 = r10.i(r3)
            boolean r5 = r10.h()
            if (r5 == 0) goto L47
            int r5 = r10.i(r4)
            if (r5 <= 0) goto L47
            r10.g(r1)
        L47:
            boolean r5 = r10.h()
            r6 = 44100(0xac44, float:6.1797E-41)
            r7 = 48000(0xbb80, float:6.7262E-41)
            r8 = 1
            if (r8 == r5) goto L58
            r5 = 44100(0xac44, float:6.1797E-41)
            goto L5b
        L58:
            r5 = 48000(0xbb80, float:6.7262E-41)
        L5b:
            int r10 = r10.i(r2)
            r9 = 0
            if (r5 != r6) goto L6b
            r6 = 13
            if (r10 != r6) goto L6b
            int[] r10 = com.google.ads.interactivemedia.v3.internal.gr.b
            r9 = r10[r6]
            goto L96
        L6b:
            if (r5 != r7) goto L96
            r6 = 14
            if (r10 >= r6) goto L96
            int[] r6 = com.google.ads.interactivemedia.v3.internal.gr.b
            r9 = r6[r10]
            int r3 = r3 % 5
            r6 = 8
            if (r3 == r8) goto L90
            r7 = 11
            if (r3 == r1) goto L8b
            if (r3 == r4) goto L90
            if (r3 == r2) goto L84
            goto L96
        L84:
            if (r10 == r4) goto L94
            if (r10 == r6) goto L94
            if (r10 != r7) goto L96
            goto L94
        L8b:
            if (r10 == r6) goto L94
            if (r10 != r7) goto L96
            goto L94
        L90:
            if (r10 == r4) goto L94
            if (r10 != r6) goto L96
        L94:
            int r9 = r9 + 1
        L96:
            com.google.ads.interactivemedia.v3.internal.gq r10 = new com.google.ads.interactivemedia.v3.internal.gq
            r10.<init>(r5, r0, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.gr.a(com.google.ads.interactivemedia.v3.internal.aed):com.google.ads.interactivemedia.v3.internal.gq");
    }

    public static void b(int i, aee aeeVar) {
        aeeVar.a(7);
        byte[] bArrI = aeeVar.i();
        bArrI[0] = -84;
        bArrI[1] = 64;
        bArrI[2] = -1;
        bArrI[3] = -1;
        bArrI[4] = (byte) ((i >> 16) & 255);
        bArrI[5] = (byte) ((i >> 8) & 255);
        bArrI[6] = (byte) (i & 255);
    }
}
