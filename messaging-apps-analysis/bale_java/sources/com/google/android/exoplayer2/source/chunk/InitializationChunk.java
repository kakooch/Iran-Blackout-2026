package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.upstream.b;
import ir.nasim.AbstractC22885vz1;
import ir.nasim.C19445qM6;
import ir.nasim.RD1;

/* loaded from: classes2.dex */
public final class InitializationChunk extends Chunk {
    private final ChunkExtractor j;
    private ChunkExtractor.TrackOutputProvider k;
    private long l;
    private volatile boolean m;

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void a() {
        if (this.l == 0) {
            this.j.c(this.k, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            b bVarE = this.b.e(this.l);
            C19445qM6 c19445qM6 = this.i;
            RD1 rd1 = new RD1(c19445qM6, bVarE.g, c19445qM6.b(bVarE));
            while (!this.m && this.j.a(rd1)) {
                try {
                } finally {
                    this.l = rd1.getPosition() - this.b.g;
                }
            }
        } finally {
            AbstractC22885vz1.a(this.i);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void c() {
        this.m = true;
    }

    public void g(ChunkExtractor.TrackOutputProvider trackOutputProvider) {
        this.k = trackOutputProvider;
    }
}
