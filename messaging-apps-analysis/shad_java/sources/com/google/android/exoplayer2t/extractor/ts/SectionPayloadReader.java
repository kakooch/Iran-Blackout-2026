package com.google.android.exoplayer2t.extractor.ts;

import com.google.android.exoplayer2t.extractor.ExtractorOutput;
import com.google.android.exoplayer2t.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2t.util.ParsableByteArray;
import com.google.android.exoplayer2t.util.TimestampAdjuster;

/* loaded from: classes.dex */
public interface SectionPayloadReader {
    void consume(ParsableByteArray parsableByteArray);

    void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator);
}
