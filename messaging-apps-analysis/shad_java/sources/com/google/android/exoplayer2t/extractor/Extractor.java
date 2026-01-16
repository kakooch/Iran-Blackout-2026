package com.google.android.exoplayer2t.extractor;

import java.io.IOException;

/* loaded from: classes.dex */
public interface Extractor {
    void init(ExtractorOutput extractorOutput);

    int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws InterruptedException, IOException;

    void release();

    void seek(long j, long j2);

    boolean sniff(ExtractorInput extractorInput) throws InterruptedException, IOException;
}
