package com.google.android.exoplayer2t.extractor.ts;

import com.google.android.exoplayer2t.ParserException;
import com.google.android.exoplayer2t.extractor.ExtractorOutput;
import com.google.android.exoplayer2t.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2t.util.ParsableByteArray;

/* loaded from: classes.dex */
public interface ElementaryStreamReader {
    void consume(ParsableByteArray parsableByteArray) throws ParserException;

    void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator);

    void packetFinished();

    void packetStarted(long j, int i);

    void seek();
}
