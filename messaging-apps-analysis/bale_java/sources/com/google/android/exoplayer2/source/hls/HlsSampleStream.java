package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import ir.nasim.AbstractC20011rK;
import ir.nasim.C21664tv2;

/* loaded from: classes2.dex */
final class HlsSampleStream implements SampleStream {
    private final int a;
    private final HlsSampleStreamWrapper b;
    private int c = -1;

    public HlsSampleStream(HlsSampleStreamWrapper hlsSampleStreamWrapper, int i) {
        this.b = hlsSampleStreamWrapper;
        this.a = i;
    }

    private boolean c() {
        int i = this.c;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }

    public void a() {
        AbstractC20011rK.a(this.c == -1);
        this.c = this.b.y(this.a);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void b() throws SampleQueueMappingException {
        int i = this.c;
        if (i == -2) {
            throw new SampleQueueMappingException(this.b.t().c(this.a).d(0).l);
        }
        if (i == -1) {
            this.b.U();
        } else if (i != -3) {
            this.b.V(i);
        }
    }

    public void d() {
        if (this.c != -1) {
            this.b.p0(this.a);
            this.c = -1;
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean h() {
        return this.c == -3 || (c() && this.b.Q(this.c));
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int o(C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i) {
        if (this.c == -3) {
            decoderInputBuffer.o(4);
            return -4;
        }
        if (c()) {
            return this.b.e0(this.c, c21664tv2, decoderInputBuffer, i);
        }
        return -3;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int s(long j) {
        if (c()) {
            return this.b.o0(this.c, j);
        }
        return 0;
    }
}
