package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.X;
import ir.nasim.AbstractC22885vz1;
import ir.nasim.InterfaceC4589Ft7;
import ir.nasim.RD1;

/* loaded from: classes2.dex */
public final class SingleSampleMediaChunk extends BaseMediaChunk {
    private final int o;
    private final X p;
    private long q;
    private boolean r;

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void a() {
        BaseMediaChunkOutput baseMediaChunkOutputJ = j();
        baseMediaChunkOutputJ.c(0L);
        InterfaceC4589Ft7 interfaceC4589Ft7B = baseMediaChunkOutputJ.b(0, this.o);
        interfaceC4589Ft7B.c(this.p);
        try {
            long jB = this.i.b(this.b.e(this.q));
            if (jB != -1) {
                jB += this.q;
            }
            RD1 rd1 = new RD1(this.i, this.q, jB);
            for (int iF = 0; iF != -1; iF = interfaceC4589Ft7B.f(rd1, Integer.MAX_VALUE, true)) {
                this.q += iF;
            }
            interfaceC4589Ft7B.b(this.g, 1, (int) this.q, 0, null);
            AbstractC22885vz1.a(this.i);
            this.r = true;
        } catch (Throwable th) {
            AbstractC22885vz1.a(this.i);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void c() {
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean h() {
        return this.r;
    }
}
