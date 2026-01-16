package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import ir.nasim.C21664tv2;

/* loaded from: classes2.dex */
public final class EmptySampleStream implements SampleStream {
    @Override // com.google.android.exoplayer2.source.SampleStream
    public void b() {
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean h() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int o(C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i) {
        decoderInputBuffer.x(4);
        return -4;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int s(long j) {
        return 0;
    }
}
