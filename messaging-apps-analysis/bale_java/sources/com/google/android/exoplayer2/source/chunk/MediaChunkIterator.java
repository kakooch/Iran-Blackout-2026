package com.google.android.exoplayer2.source.chunk;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public interface MediaChunkIterator {
    public static final MediaChunkIterator a = new MediaChunkIterator() { // from class: com.google.android.exoplayer2.source.chunk.MediaChunkIterator.1
        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long a() {
            throw new NoSuchElementException();
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long b() {
            throw new NoSuchElementException();
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public boolean next() {
            return false;
        }
    };

    long a();

    long b();

    boolean next();
}
