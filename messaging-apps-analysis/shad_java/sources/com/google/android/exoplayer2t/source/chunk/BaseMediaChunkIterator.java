package com.google.android.exoplayer2t.source.chunk;

/* loaded from: classes.dex */
public abstract class BaseMediaChunkIterator implements MediaChunkIterator {
    private final long fromIndex;

    public void reset() {
    }

    public BaseMediaChunkIterator(long j, long j2) {
        this.fromIndex = j;
        reset();
    }
}
