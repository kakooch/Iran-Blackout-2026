package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

/* loaded from: classes.dex */
public final class SpliceInfoSectionReader implements SectionPayloadReader {
    private boolean formatDeclared;
    private TrackOutput output;
    private TimestampAdjuster timestampAdjuster;

    @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator idGenerator) {
        this.timestampAdjuster = timestampAdjuster;
        idGenerator.generateNewId();
        TrackOutput trackOutputTrack = extractorOutput.track(idGenerator.getTrackId(), 4);
        this.output = trackOutputTrack;
        trackOutputTrack.format(Format.createSampleFormat(idGenerator.getFormatId(), "application/x-scte35", null, -1, null));
    }

    @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
    public void consume(ParsableByteArray sectionData) {
        if (!this.formatDeclared) {
            if (this.timestampAdjuster.getTimestampOffsetUs() == -9223372036854775807L) {
                return;
            }
            this.output.format(Format.createSampleFormat(null, "application/x-scte35", this.timestampAdjuster.getTimestampOffsetUs()));
            this.formatDeclared = true;
        }
        int iBytesLeft = sectionData.bytesLeft();
        this.output.sampleData(sectionData, iBytesLeft);
        this.output.sampleMetadata(this.timestampAdjuster.getLastAdjustedTimestampUs(), 1, iBytesLeft, 0, null);
    }
}
