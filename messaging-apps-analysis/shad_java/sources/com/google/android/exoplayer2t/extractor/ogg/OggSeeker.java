package com.google.android.exoplayer2t.extractor.ogg;

import com.google.android.exoplayer2t.extractor.ExtractorInput;
import com.google.android.exoplayer2t.extractor.SeekMap;
import java.io.IOException;

/* loaded from: classes.dex */
interface OggSeeker {
    SeekMap createSeekMap();

    long read(ExtractorInput extractorInput) throws InterruptedException, IOException;

    void startSeek(long j);
}
