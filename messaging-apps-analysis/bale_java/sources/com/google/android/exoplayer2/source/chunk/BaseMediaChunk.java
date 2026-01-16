package com.google.android.exoplayer2.source.chunk;

import ir.nasim.AbstractC20011rK;

/* loaded from: classes2.dex */
public abstract class BaseMediaChunk extends MediaChunk {
    public final long k;
    public final long l;
    private BaseMediaChunkOutput m;
    private int[] n;

    public final int i(int i) {
        return ((int[]) AbstractC20011rK.i(this.n))[i];
    }

    protected final BaseMediaChunkOutput j() {
        return (BaseMediaChunkOutput) AbstractC20011rK.i(this.m);
    }

    public void k(BaseMediaChunkOutput baseMediaChunkOutput) {
        this.m = baseMediaChunkOutput;
        this.n = baseMediaChunkOutput.a();
    }
}
