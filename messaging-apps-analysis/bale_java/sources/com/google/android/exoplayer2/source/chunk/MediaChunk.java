package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import ir.nasim.AbstractC20011rK;

/* loaded from: classes2.dex */
public abstract class MediaChunk extends Chunk {
    public final long j;

    public MediaChunk(a aVar, b bVar, X x, int i, Object obj, long j, long j2, long j3) {
        super(aVar, bVar, 1, x, i, obj, j, j2);
        AbstractC20011rK.e(x);
        this.j = j3;
    }

    public long g() {
        long j = this.j;
        if (j != -1) {
            return 1 + j;
        }
        return -1L;
    }

    public abstract boolean h();
}
