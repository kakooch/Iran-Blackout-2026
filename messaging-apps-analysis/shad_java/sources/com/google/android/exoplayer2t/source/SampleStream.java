package com.google.android.exoplayer2t.source;

import com.google.android.exoplayer2t.FormatHolder;
import com.google.android.exoplayer2t.decoder.DecoderInputBuffer;
import java.io.IOException;

/* loaded from: classes.dex */
public interface SampleStream {
    boolean isReady();

    void maybeThrowError() throws IOException;

    int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z);

    int skipData(long j);
}
