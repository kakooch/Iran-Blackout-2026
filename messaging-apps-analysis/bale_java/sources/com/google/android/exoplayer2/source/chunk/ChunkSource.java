package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.upstream.j;
import java.util.List;

/* loaded from: classes2.dex */
public interface ChunkSource {
    boolean a(long j, Chunk chunk, List list);

    void b();

    void c(Chunk chunk);

    boolean d(Chunk chunk, boolean z, j.c cVar, j jVar);

    int e(long j, List list);

    void f(long j, long j2, List list, ChunkHolder chunkHolder);

    void release();
}
