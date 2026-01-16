package com.google.android.exoplayer2t.ext.flac;

import com.google.android.exoplayer2t.Format;
import com.google.android.exoplayer2t.ext.flac.FlacBinarySearchSeeker;
import com.google.android.exoplayer2t.ext.flac.FlacDecoderJni;
import com.google.android.exoplayer2t.extractor.Extractor;
import com.google.android.exoplayer2t.extractor.ExtractorInput;
import com.google.android.exoplayer2t.extractor.ExtractorOutput;
import com.google.android.exoplayer2t.extractor.ExtractorsFactory;
import com.google.android.exoplayer2t.extractor.FlacMetadataReader;
import com.google.android.exoplayer2t.extractor.PositionHolder;
import com.google.android.exoplayer2t.extractor.SeekMap;
import com.google.android.exoplayer2t.extractor.SeekPoint;
import com.google.android.exoplayer2t.extractor.TrackOutput;
import com.google.android.exoplayer2t.metadata.Metadata;
import com.google.android.exoplayer2t.util.Assertions;
import com.google.android.exoplayer2t.util.FlacStreamMetadata;
import com.google.android.exoplayer2t.util.ParsableByteArray;
import com.google.android.exoplayer2t.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public final class FlacExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2t.ext.flac.FlacExtractor$$ExternalSyntheticLambda0
        @Override // com.google.android.exoplayer2t.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return FlacExtractor.lambda$static$0();
        }
    };
    public static final int FLAG_DISABLE_ID3_METADATA = 1;
    private FlacBinarySearchSeeker binarySearchSeeker;
    private FlacDecoderJni decoderJni;
    private ExtractorOutput extractorOutput;
    private Metadata id3Metadata;
    private final boolean id3MetadataDisabled;
    private final ParsableByteArray outputBuffer;
    private FlacBinarySearchSeeker.OutputFrameHolder outputFrameHolder;
    private FlacStreamMetadata streamMetadata;
    private boolean streamMetadataDecoded;
    private TrackOutput trackOutput;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new FlacExtractor()};
    }

    public FlacExtractor() {
        this(0);
    }

    public FlacExtractor(int i) {
        this.outputBuffer = new ParsableByteArray();
        this.id3MetadataDisabled = (i & 1) != 0;
    }

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = extractorOutput.track(0, 1);
        this.extractorOutput.endTracks();
        try {
            this.decoderJni = new FlacDecoderJni();
        } catch (FlacDecoderException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws InterruptedException, IOException {
        this.id3Metadata = FlacMetadataReader.peekId3Metadata(extractorInput, !this.id3MetadataDisabled);
        return FlacMetadataReader.checkAndPeekStreamMarker(extractorInput);
    }

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws InterruptedException, IOException {
        if (extractorInput.getPosition() == 0 && !this.id3MetadataDisabled && this.id3Metadata == null) {
            this.id3Metadata = FlacMetadataReader.peekId3Metadata(extractorInput, true);
        }
        FlacDecoderJni flacDecoderJniInitDecoderJni = initDecoderJni(extractorInput);
        try {
            decodeStreamMetadata(extractorInput);
            FlacBinarySearchSeeker flacBinarySearchSeeker = this.binarySearchSeeker;
            if (flacBinarySearchSeeker != null && flacBinarySearchSeeker.isSeeking()) {
                return handlePendingSeek(extractorInput, positionHolder, this.outputBuffer, this.outputFrameHolder, this.trackOutput);
            }
            ByteBuffer byteBuffer = this.outputFrameHolder.byteBuffer;
            long decodePosition = flacDecoderJniInitDecoderJni.getDecodePosition();
            try {
                flacDecoderJniInitDecoderJni.decodeSampleWithBacktrackPosition(byteBuffer, decodePosition);
                int iLimit = byteBuffer.limit();
                if (iLimit == 0) {
                    return -1;
                }
                outputSample(this.outputBuffer, iLimit, flacDecoderJniInitDecoderJni.getLastFrameTimestamp(), this.trackOutput);
                return flacDecoderJniInitDecoderJni.isEndOfData() ? -1 : 0;
            } catch (FlacDecoderJni.FlacFrameDecodeException e) {
                throw new IOException("Cannot read frame at position " + decodePosition, e);
            }
        } finally {
            flacDecoderJniInitDecoderJni.clearData();
        }
    }

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public void seek(long j, long j2) {
        if (j == 0) {
            this.streamMetadataDecoded = false;
        }
        FlacDecoderJni flacDecoderJni = this.decoderJni;
        if (flacDecoderJni != null) {
            flacDecoderJni.reset(j);
        }
        FlacBinarySearchSeeker flacBinarySearchSeeker = this.binarySearchSeeker;
        if (flacBinarySearchSeeker != null) {
            flacBinarySearchSeeker.setSeekTargetUs(j2);
        }
    }

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public void release() {
        this.binarySearchSeeker = null;
        FlacDecoderJni flacDecoderJni = this.decoderJni;
        if (flacDecoderJni != null) {
            flacDecoderJni.release();
            this.decoderJni = null;
        }
    }

    @EnsuresNonNull({"decoderJni", "extractorOutput", "trackOutput"})
    private FlacDecoderJni initDecoderJni(ExtractorInput extractorInput) {
        FlacDecoderJni flacDecoderJni = (FlacDecoderJni) Assertions.checkNotNull(this.decoderJni);
        flacDecoderJni.setData(extractorInput);
        return flacDecoderJni;
    }

    @EnsuresNonNull({"streamMetadata", "outputFrameHolder"})
    @RequiresNonNull({"decoderJni", "extractorOutput", "trackOutput"})
    private void decodeStreamMetadata(ExtractorInput extractorInput) throws Throwable {
        if (this.streamMetadataDecoded) {
            return;
        }
        FlacDecoderJni flacDecoderJni = this.decoderJni;
        try {
            FlacStreamMetadata flacStreamMetadataDecodeStreamMetadata = flacDecoderJni.decodeStreamMetadata();
            this.streamMetadataDecoded = true;
            if (this.streamMetadata == null) {
                this.streamMetadata = flacStreamMetadataDecodeStreamMetadata;
                this.outputBuffer.reset(flacStreamMetadataDecodeStreamMetadata.getMaxDecodedFrameSize());
                this.outputFrameHolder = new FlacBinarySearchSeeker.OutputFrameHolder(ByteBuffer.wrap(this.outputBuffer.data));
                this.binarySearchSeeker = outputSeekMap(flacDecoderJni, flacStreamMetadataDecodeStreamMetadata, extractorInput.getLength(), this.extractorOutput, this.outputFrameHolder);
                outputFormat(flacStreamMetadataDecodeStreamMetadata, flacStreamMetadataDecodeStreamMetadata.getMetadataCopyWithAppendedEntriesFrom(this.id3Metadata), this.trackOutput);
            }
        } catch (IOException e) {
            flacDecoderJni.reset(0L);
            extractorInput.setRetryPosition(0L, e);
            throw e;
        }
    }

    @RequiresNonNull({"binarySearchSeeker"})
    private int handlePendingSeek(ExtractorInput extractorInput, PositionHolder positionHolder, ParsableByteArray parsableByteArray, FlacBinarySearchSeeker.OutputFrameHolder outputFrameHolder, TrackOutput trackOutput) throws InterruptedException, IOException {
        int iHandlePendingSeek = this.binarySearchSeeker.handlePendingSeek(extractorInput, positionHolder);
        ByteBuffer byteBuffer = outputFrameHolder.byteBuffer;
        if (iHandlePendingSeek == 0 && byteBuffer.limit() > 0) {
            outputSample(parsableByteArray, byteBuffer.limit(), outputFrameHolder.timeUs, trackOutput);
        }
        return iHandlePendingSeek;
    }

    private static FlacBinarySearchSeeker outputSeekMap(FlacDecoderJni flacDecoderJni, FlacStreamMetadata flacStreamMetadata, long j, ExtractorOutput extractorOutput, FlacBinarySearchSeeker.OutputFrameHolder outputFrameHolder) {
        SeekMap unseekable;
        FlacBinarySearchSeeker flacBinarySearchSeeker = null;
        if (flacDecoderJni.getSeekPoints(0L) != null) {
            unseekable = new FlacSeekMap(flacStreamMetadata.getDurationUs(), flacDecoderJni);
        } else if (j != -1) {
            flacBinarySearchSeeker = new FlacBinarySearchSeeker(flacStreamMetadata, flacDecoderJni.getDecodePosition(), j, flacDecoderJni, outputFrameHolder);
            unseekable = flacBinarySearchSeeker.getSeekMap();
        } else {
            unseekable = new SeekMap.Unseekable(flacStreamMetadata.getDurationUs());
        }
        extractorOutput.seekMap(unseekable);
        return flacBinarySearchSeeker;
    }

    private static void outputFormat(FlacStreamMetadata flacStreamMetadata, Metadata metadata, TrackOutput trackOutput) {
        trackOutput.format(Format.createAudioSampleFormat(null, "audio/raw", null, flacStreamMetadata.getBitRate(), flacStreamMetadata.getMaxDecodedFrameSize(), flacStreamMetadata.channels, flacStreamMetadata.sampleRate, Util.getPcmEncoding(flacStreamMetadata.bitsPerSample), 0, 0, null, null, 0, null, metadata));
    }

    private static void outputSample(ParsableByteArray parsableByteArray, int i, long j, TrackOutput trackOutput) {
        parsableByteArray.setPosition(0);
        trackOutput.sampleData(parsableByteArray, i);
        trackOutput.sampleMetadata(j, 1, i, 0, null);
    }

    private static final class FlacSeekMap implements SeekMap {
        private final FlacDecoderJni decoderJni;
        private final long durationUs;

        @Override // com.google.android.exoplayer2t.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }

        public FlacSeekMap(long j, FlacDecoderJni flacDecoderJni) {
            this.durationUs = j;
            this.decoderJni = flacDecoderJni;
        }

        @Override // com.google.android.exoplayer2t.extractor.SeekMap
        public SeekMap.SeekPoints getSeekPoints(long j) {
            SeekMap.SeekPoints seekPoints = this.decoderJni.getSeekPoints(j);
            return seekPoints == null ? new SeekMap.SeekPoints(SeekPoint.START) : seekPoints;
        }

        @Override // com.google.android.exoplayer2t.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }
    }
}
