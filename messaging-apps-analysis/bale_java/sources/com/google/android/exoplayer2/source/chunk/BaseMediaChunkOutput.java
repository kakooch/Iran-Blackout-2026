package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.InterfaceC4589Ft7;
import ir.nasim.P12;

/* loaded from: classes2.dex */
public final class BaseMediaChunkOutput implements ChunkExtractor.TrackOutputProvider {
    private final int[] a;
    private final SampleQueue[] b;

    public int[] a() {
        int[] iArr = new int[this.b.length];
        int i = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.b;
            if (i >= sampleQueueArr.length) {
                return iArr;
            }
            iArr[i] = sampleQueueArr[i].B();
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor.TrackOutputProvider
    public InterfaceC4589Ft7 b(int i, int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i3 >= iArr.length) {
                AbstractC18815pI3.c("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
                return new P12();
            }
            if (i2 == iArr[i3]) {
                return this.b[i3];
            }
            i3++;
        }
    }

    public void c(long j) {
        for (SampleQueue sampleQueue : this.b) {
            sampleQueue.U(j);
        }
    }
}
