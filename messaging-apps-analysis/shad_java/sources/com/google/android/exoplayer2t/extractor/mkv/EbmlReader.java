package com.google.android.exoplayer2t.extractor.mkv;

import com.google.android.exoplayer2t.extractor.ExtractorInput;
import java.io.IOException;

/* loaded from: classes.dex */
interface EbmlReader {
    void init(EbmlProcessor ebmlProcessor);

    boolean read(ExtractorInput extractorInput) throws InterruptedException, IOException;

    void reset();
}
