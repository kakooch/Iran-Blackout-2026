package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;
import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class qd {
    private long a;
    private long b;
    private boolean c;

    qd() {
    }

    public final void a() {
        this.a = 0L;
        this.b = 0L;
        this.c = false;
    }

    public final long b(cy cyVar, iw iwVar) {
        if (this.c) {
            return iwVar.d;
        }
        ByteBuffer byteBuffer = iwVar.b;
        ary.t(byteBuffer);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (byteBuffer.get(i2) & 255);
        }
        int iB = il.b(i);
        if (iB == -1) {
            this.c = true;
            Log.w("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return iwVar.d;
        }
        long j = this.a;
        if (j != 0) {
            long j2 = (1000000 * j) / cyVar.z;
            this.a = j + iB;
            return this.b + j2;
        }
        long j3 = iwVar.d;
        this.b = j3;
        this.a = iB - 529;
        return j3;
    }
}
