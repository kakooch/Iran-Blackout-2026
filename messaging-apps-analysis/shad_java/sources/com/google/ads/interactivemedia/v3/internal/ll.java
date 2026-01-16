package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayDeque;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ll {
    private final byte[] a = new byte[8];
    private final ArrayDeque<lk> b = new ArrayDeque<>();
    private final lt c = new lt();
    private lm d;
    private int e;
    private int f;
    private long g;

    private final long d(jv jvVar, int i) throws IOException {
        jvVar.c(this.a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.a[i2] & 255);
        }
        return j;
    }

    public final void a(lm lmVar) {
        this.d = lmVar;
    }

    public final void b() {
        this.e = 0;
        this.b.clear();
        this.c.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad A[LOOP:0: B:3:0x0005->B:36:0x00ad, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0167 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(com.google.ads.interactivemedia.v3.internal.jv r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ll.c(com.google.ads.interactivemedia.v3.internal.jv):boolean");
    }
}
