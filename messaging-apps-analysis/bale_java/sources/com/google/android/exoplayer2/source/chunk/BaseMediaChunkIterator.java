package com.google.android.exoplayer2.source.chunk;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public abstract class BaseMediaChunkIterator implements MediaChunkIterator {
    private final long b;
    private final long c;
    private long d;

    public BaseMediaChunkIterator(long j, long j2) {
        this.b = j;
        this.c = j2;
        f();
    }

    protected final void c() {
        long j = this.d;
        if (j < this.b || j > this.c) {
            throw new NoSuchElementException();
        }
    }

    protected final long d() {
        return this.d;
    }

    public boolean e() {
        return this.d > this.c;
    }

    public void f() {
        this.d = this.b - 1;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public boolean next() {
        this.d++;
        return !e();
    }
}
