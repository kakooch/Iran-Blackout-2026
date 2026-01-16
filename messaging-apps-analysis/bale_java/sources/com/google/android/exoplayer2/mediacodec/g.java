package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC4754Gk4;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class g {
    private long a;
    private long b;
    private boolean c;

    g() {
    }

    private long a(long j) {
        return this.a + Math.max(0L, ((this.b - 529) * 1000000) / j);
    }

    public long b(X x) {
        return a(x.z);
    }

    public void c() {
        this.a = 0L;
        this.b = 0L;
        this.c = false;
    }

    public long d(X x, DecoderInputBuffer decoderInputBuffer) {
        if (this.b == 0) {
            this.a = decoderInputBuffer.e;
        }
        if (this.c) {
            return decoderInputBuffer.e;
        }
        ByteBuffer byteBuffer = (ByteBuffer) AbstractC20011rK.e(decoderInputBuffer.c);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (byteBuffer.get(i2) & 255);
        }
        int iM = AbstractC4754Gk4.m(i);
        if (iM != -1) {
            long jA = a(x.z);
            this.b += iM;
            return jA;
        }
        this.c = true;
        this.b = 0L;
        this.a = decoderInputBuffer.e;
        AbstractC18815pI3.k("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
        return decoderInputBuffer.e;
    }
}
