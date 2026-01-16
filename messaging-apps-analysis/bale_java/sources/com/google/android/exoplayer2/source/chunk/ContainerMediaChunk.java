package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.upstream.b;
import ir.nasim.AbstractC22885vz1;
import ir.nasim.C19445qM6;
import ir.nasim.RD1;

/* loaded from: classes2.dex */
public class ContainerMediaChunk extends BaseMediaChunk {
    private final long o;
    private final ChunkExtractor p;
    private long q;
    private volatile boolean r;
    private boolean s;

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void a() {
        if (this.q == 0) {
            BaseMediaChunkOutput baseMediaChunkOutputJ = j();
            baseMediaChunkOutputJ.c(this.o);
            ChunkExtractor chunkExtractor = this.p;
            ChunkExtractor.TrackOutputProvider trackOutputProviderL = l(baseMediaChunkOutputJ);
            long j = this.k;
            long j2 = j == -9223372036854775807L ? -9223372036854775807L : j - this.o;
            long j3 = this.l;
            chunkExtractor.c(trackOutputProviderL, j2, j3 == -9223372036854775807L ? -9223372036854775807L : j3 - this.o);
        }
        try {
            b bVarE = this.b.e(this.q);
            C19445qM6 c19445qM6 = this.i;
            RD1 rd1 = new RD1(c19445qM6, bVarE.g, c19445qM6.b(bVarE));
            do {
                try {
                    if (this.r) {
                        break;
                    }
                } finally {
                    this.q = rd1.getPosition() - this.b.g;
                }
            } while (this.p.a(rd1));
            AbstractC22885vz1.a(this.i);
            this.s = !this.r;
        } catch (Throwable th) {
            AbstractC22885vz1.a(this.i);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void c() {
        this.r = true;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean h() {
        return this.s;
    }

    protected ChunkExtractor.TrackOutputProvider l(BaseMediaChunkOutput baseMediaChunkOutput) {
        return baseMediaChunkOutput;
    }
}
