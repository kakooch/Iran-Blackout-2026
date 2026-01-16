package com.google.android.exoplayer2.extractor;

import java.io.IOException;

/* loaded from: classes.dex */
public interface Extractor {
    void init(ExtractorOutput output);

    int read(ExtractorInput input, PositionHolder seekPosition) throws InterruptedException, IOException;

    void release();

    void seek(long position, long timeUs);

    boolean sniff(ExtractorInput input) throws InterruptedException, IOException;
}
