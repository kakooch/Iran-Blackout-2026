package com.google.android.exoplayer2t.source;

import com.google.android.exoplayer2t.FormatHolder;
import com.google.android.exoplayer2t.decoder.DecoderInputBuffer;
import java.io.IOException;

/* loaded from: classes.dex */
public final class EmptySampleStream implements SampleStream {
    @Override // com.google.android.exoplayer2t.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2t.source.SampleStream
    public void maybeThrowError() throws IOException {
    }

    @Override // com.google.android.exoplayer2t.source.SampleStream
    public int skipData(long j) {
        return 0;
    }

    @Override // com.google.android.exoplayer2t.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        decoderInputBuffer.setFlags(4);
        return -4;
    }
}
