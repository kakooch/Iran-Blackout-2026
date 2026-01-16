package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* loaded from: classes.dex */
public final class FlvExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.flv.-$$Lambda$FlvExtractor$uGPIR_OZmcT4Rba70dWWmnPAxgs
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return FlvExtractor.lambda$static$0();
        }
    };
    private AudioTagPayloadReader audioReader;
    private int bytesToNextTagHeader;
    private ExtractorOutput extractorOutput;
    private long mediaTagTimestampOffsetUs;
    private boolean outputFirstSample;
    private boolean outputSeekMap;
    private int tagDataSize;
    private long tagTimestampUs;
    private int tagType;
    private VideoTagPayloadReader videoReader;
    private final ParsableByteArray scratch = new ParsableByteArray(4);
    private final ParsableByteArray headerBuffer = new ParsableByteArray(9);
    private final ParsableByteArray tagHeaderBuffer = new ParsableByteArray(11);
    private final ParsableByteArray tagData = new ParsableByteArray();
    private final ScriptTagPayloadReader metadataReader = new ScriptTagPayloadReader();
    private int state = 1;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new FlvExtractor()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput input) throws InterruptedException, IOException {
        input.peekFully(this.scratch.data, 0, 3);
        this.scratch.setPosition(0);
        if (this.scratch.readUnsignedInt24() != 4607062) {
            return false;
        }
        input.peekFully(this.scratch.data, 0, 2);
        this.scratch.setPosition(0);
        if ((this.scratch.readUnsignedShort() & 250) != 0) {
            return false;
        }
        input.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        int i = this.scratch.readInt();
        input.resetPeekPosition();
        input.advancePeekPosition(i);
        input.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        return this.scratch.readInt() == 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput output) {
        this.extractorOutput = output;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long position, long timeUs) {
        this.state = 1;
        this.outputFirstSample = false;
        this.bytesToNextTagHeader = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput input, PositionHolder seekPosition) throws InterruptedException, IOException {
        while (true) {
            int i = this.state;
            if (i != 1) {
                if (i == 2) {
                    skipToTagHeader(input);
                } else if (i != 3) {
                    if (i == 4) {
                        if (readTagData(input)) {
                            return 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (!readTagHeader(input)) {
                    return -1;
                }
            } else if (!readFlvHeader(input)) {
                return -1;
            }
        }
    }

    private boolean readFlvHeader(ExtractorInput input) throws InterruptedException, IOException {
        if (!input.readFully(this.headerBuffer.data, 0, 9, true)) {
            return false;
        }
        this.headerBuffer.setPosition(0);
        this.headerBuffer.skipBytes(4);
        int unsignedByte = this.headerBuffer.readUnsignedByte();
        boolean z = (unsignedByte & 4) != 0;
        boolean z2 = (unsignedByte & 1) != 0;
        if (z && this.audioReader == null) {
            this.audioReader = new AudioTagPayloadReader(this.extractorOutput.track(8, 1));
        }
        if (z2 && this.videoReader == null) {
            this.videoReader = new VideoTagPayloadReader(this.extractorOutput.track(9, 2));
        }
        this.extractorOutput.endTracks();
        this.bytesToNextTagHeader = (this.headerBuffer.readInt() - 9) + 4;
        this.state = 2;
        return true;
    }

    private void skipToTagHeader(ExtractorInput input) throws InterruptedException, IOException {
        input.skipFully(this.bytesToNextTagHeader);
        this.bytesToNextTagHeader = 0;
        this.state = 3;
    }

    private boolean readTagHeader(ExtractorInput input) throws InterruptedException, IOException {
        if (!input.readFully(this.tagHeaderBuffer.data, 0, 11, true)) {
            return false;
        }
        this.tagHeaderBuffer.setPosition(0);
        this.tagType = this.tagHeaderBuffer.readUnsignedByte();
        this.tagDataSize = this.tagHeaderBuffer.readUnsignedInt24();
        this.tagTimestampUs = this.tagHeaderBuffer.readUnsignedInt24();
        this.tagTimestampUs = ((this.tagHeaderBuffer.readUnsignedByte() << 24) | this.tagTimestampUs) * 1000;
        this.tagHeaderBuffer.skipBytes(3);
        this.state = 4;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean readTagData(com.google.android.exoplayer2.extractor.ExtractorInput r9) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r8 = this;
            long r0 = r8.getCurrentTimestampUs()
            int r2 = r8.tagType
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = 0
            r6 = 1
            r7 = 8
            if (r2 != r7) goto L24
            com.google.android.exoplayer2.extractor.flv.AudioTagPayloadReader r7 = r8.audioReader
            if (r7 == 0) goto L24
            r8.ensureReadyForMediaOutput()
            com.google.android.exoplayer2.extractor.flv.AudioTagPayloadReader r2 = r8.audioReader
            com.google.android.exoplayer2.util.ParsableByteArray r9 = r8.prepareTagData(r9)
            boolean r5 = r2.consume(r9, r0)
        L22:
            r9 = 1
            goto L69
        L24:
            r7 = 9
            if (r2 != r7) goto L3a
            com.google.android.exoplayer2.extractor.flv.VideoTagPayloadReader r7 = r8.videoReader
            if (r7 == 0) goto L3a
            r8.ensureReadyForMediaOutput()
            com.google.android.exoplayer2.extractor.flv.VideoTagPayloadReader r2 = r8.videoReader
            com.google.android.exoplayer2.util.ParsableByteArray r9 = r8.prepareTagData(r9)
            boolean r5 = r2.consume(r9, r0)
            goto L22
        L3a:
            r7 = 18
            if (r2 != r7) goto L63
            boolean r2 = r8.outputSeekMap
            if (r2 != 0) goto L63
            com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader r2 = r8.metadataReader
            com.google.android.exoplayer2.util.ParsableByteArray r9 = r8.prepareTagData(r9)
            boolean r5 = r2.consume(r9, r0)
            com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader r9 = r8.metadataReader
            long r0 = r9.getDurationUs()
            int r9 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r9 == 0) goto L22
            com.google.android.exoplayer2.extractor.ExtractorOutput r9 = r8.extractorOutput
            com.google.android.exoplayer2.extractor.SeekMap$Unseekable r2 = new com.google.android.exoplayer2.extractor.SeekMap$Unseekable
            r2.<init>(r0)
            r9.seekMap(r2)
            r8.outputSeekMap = r6
            goto L22
        L63:
            int r0 = r8.tagDataSize
            r9.skipFully(r0)
            r9 = 0
        L69:
            boolean r0 = r8.outputFirstSample
            if (r0 != 0) goto L83
            if (r5 == 0) goto L83
            r8.outputFirstSample = r6
            com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader r0 = r8.metadataReader
            long r0 = r0.getDurationUs()
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 != 0) goto L7f
            long r0 = r8.tagTimestampUs
            long r0 = -r0
            goto L81
        L7f:
            r0 = 0
        L81:
            r8.mediaTagTimestampOffsetUs = r0
        L83:
            r0 = 4
            r8.bytesToNextTagHeader = r0
            r0 = 2
            r8.state = r0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.flv.FlvExtractor.readTagData(com.google.android.exoplayer2.extractor.ExtractorInput):boolean");
    }

    private ParsableByteArray prepareTagData(ExtractorInput input) throws InterruptedException, IOException {
        if (this.tagDataSize > this.tagData.capacity()) {
            ParsableByteArray parsableByteArray = this.tagData;
            parsableByteArray.reset(new byte[Math.max(parsableByteArray.capacity() * 2, this.tagDataSize)], 0);
        } else {
            this.tagData.setPosition(0);
        }
        this.tagData.setLimit(this.tagDataSize);
        input.readFully(this.tagData.data, 0, this.tagDataSize);
        return this.tagData;
    }

    private void ensureReadyForMediaOutput() {
        if (this.outputSeekMap) {
            return;
        }
        this.extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
        this.outputSeekMap = true;
    }

    private long getCurrentTimestampUs() {
        if (this.outputFirstSample) {
            return this.mediaTagTimestampOffsetUs + this.tagTimestampUs;
        }
        if (this.metadataReader.getDurationUs() == -9223372036854775807L) {
            return 0L;
        }
        return this.tagTimestampUs;
    }
}
