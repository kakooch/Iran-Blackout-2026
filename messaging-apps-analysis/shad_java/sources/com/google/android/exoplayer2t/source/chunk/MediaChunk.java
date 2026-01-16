package com.google.android.exoplayer2t.source.chunk;

import com.google.android.exoplayer2t.Format;
import com.google.android.exoplayer2t.upstream.DataSource;
import com.google.android.exoplayer2t.upstream.DataSpec;
import com.google.android.exoplayer2t.util.Assertions;

/* loaded from: classes.dex */
public abstract class MediaChunk extends Chunk {
    public final long chunkIndex;

    public abstract boolean isLoadCompleted();

    public MediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, long j3) {
        super(dataSource, dataSpec, 1, format, i, obj, j, j2);
        Assertions.checkNotNull(format);
        this.chunkIndex = j3;
    }

    public long getNextChunkIndex() {
        long j = this.chunkIndex;
        if (j != -1) {
            return 1 + j;
        }
        return -1L;
    }
}
