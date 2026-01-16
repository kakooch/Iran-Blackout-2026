package com.google.android.exoplayer2t.extractor.ts;

import com.google.android.exoplayer2t.Format;
import com.google.android.exoplayer2t.extractor.ExtractorOutput;
import com.google.android.exoplayer2t.extractor.TrackOutput;
import com.google.android.exoplayer2t.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2t.text.cea.CeaUtil;
import com.google.android.exoplayer2t.util.Assertions;
import com.google.android.exoplayer2t.util.ParsableByteArray;
import java.util.List;

/* loaded from: classes.dex */
final class UserDataReader {
    private final List<Format> closedCaptionFormats;
    private final TrackOutput[] outputs;

    public UserDataReader(List<Format> list) {
        this.closedCaptionFormats = list;
        this.outputs = new TrackOutput[list.size()];
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i = 0; i < this.outputs.length; i++) {
            trackIdGenerator.generateNewId();
            TrackOutput trackOutputTrack = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
            Format format = this.closedCaptionFormats.get(i);
            String str = format.sampleMimeType;
            Assertions.checkArgument("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            trackOutputTrack.format(Format.createTextSampleFormat(trackIdGenerator.getFormatId(), str, null, -1, format.selectionFlags, format.language, format.accessibilityChannel, null, Long.MAX_VALUE, format.initializationData));
            this.outputs[i] = trackOutputTrack;
        }
    }

    public void consume(long j, ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() < 9) {
            return;
        }
        int i = parsableByteArray.readInt();
        int i2 = parsableByteArray.readInt();
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if (i == 434 && i2 == 1195456820 && unsignedByte == 3) {
            CeaUtil.consumeCcData(j, parsableByteArray, this.outputs);
        }
    }
}
