package com.google.android.exoplayer2.ext.flac;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ext.flac.FlacBinarySearchSeeker;
import com.google.android.exoplayer2.ext.flac.FlacDecoderJni;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public final class FlacExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.ext.flac.-$$Lambda$FlacExtractor$JyVPXeWDZT81efhhBJSBvAMxkZ4
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
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

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new FlacExtractor()};
    }

    public FlacExtractor() {
        this(0);
    }

    public FlacExtractor(int flags) {
        this.outputBuffer = new ParsableByteArray();
        this.id3MetadataDisabled = (flags & 1) != 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput output) {
        this.extractorOutput = output;
        this.trackOutput = output.track(0, 1);
        this.extractorOutput.endTracks();
        try {
            this.decoderJni = new FlacDecoderJni();
        } catch (FlacDecoderException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput input) throws InterruptedException, IOException {
        this.id3Metadata = FlacMetadataReader.peekId3Metadata(input, !this.id3MetadataDisabled);
        return FlacMetadataReader.checkAndPeekStreamMarker(input);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(final ExtractorInput input, PositionHolder seekPosition) throws InterruptedException, IOException {
        if (input.getPosition() == 0 && !this.id3MetadataDisabled && this.id3Metadata == null) {
            this.id3Metadata = FlacMetadataReader.peekId3Metadata(input, true);
        }
        FlacDecoderJni flacDecoderJniInitDecoderJni = initDecoderJni(input);
        try {
            decodeStreamMetadata(input);
            FlacBinarySearchSeeker flacBinarySearchSeeker = this.binarySearchSeeker;
            if (flacBinarySearchSeeker != null && flacBinarySearchSeeker.isSeeking()) {
                return handlePendingSeek(input, seekPosition, this.outputBuffer, this.outputFrameHolder, this.trackOutput);
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

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long position, long timeUs) {
        if (position == 0) {
            this.streamMetadataDecoded = false;
        }
        FlacDecoderJni flacDecoderJni = this.decoderJni;
        if (flacDecoderJni != null) {
            flacDecoderJni.reset(position);
        }
        FlacBinarySearchSeeker flacBinarySearchSeeker = this.binarySearchSeeker;
        if (flacBinarySearchSeeker != null) {
            flacBinarySearchSeeker.setSeekTargetUs(timeUs);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        this.binarySearchSeeker = null;
        FlacDecoderJni flacDecoderJni = this.decoderJni;
        if (flacDecoderJni != null) {
            flacDecoderJni.release();
            this.decoderJni = null;
        }
    }

    @EnsuresNonNull({"decoderJni", "extractorOutput", "trackOutput"})
    private FlacDecoderJni initDecoderJni(ExtractorInput input) {
        FlacDecoderJni flacDecoderJni = (FlacDecoderJni) Assertions.checkNotNull(this.decoderJni);
        flacDecoderJni.setData(input);
        return flacDecoderJni;
    }

    @EnsuresNonNull({"streamMetadata", "outputFrameHolder"})
    @RequiresNonNull({"decoderJni", "extractorOutput", "trackOutput"})
    private void decodeStreamMetadata(ExtractorInput input) throws Throwable {
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
                this.binarySearchSeeker = outputSeekMap(flacDecoderJni, flacStreamMetadataDecodeStreamMetadata, input.getLength(), this.extractorOutput, this.outputFrameHolder);
                outputFormat(flacStreamMetadataDecodeStreamMetadata, flacStreamMetadataDecodeStreamMetadata.getMetadataCopyWithAppendedEntriesFrom(this.id3Metadata), this.trackOutput);
            }
        } catch (IOException e) {
            flacDecoderJni.reset(0L);
            input.setRetryPosition(0L, e);
            throw e;
        }
    }

    @RequiresNonNull({"binarySearchSeeker"})
    private int handlePendingSeek(ExtractorInput input, PositionHolder seekPosition, ParsableByteArray outputBuffer, FlacBinarySearchSeeker.OutputFrameHolder outputFrameHolder, TrackOutput trackOutput) throws InterruptedException, IOException {
        int iHandlePendingSeek = this.binarySearchSeeker.handlePendingSeek(input, seekPosition);
        ByteBuffer byteBuffer = outputFrameHolder.byteBuffer;
        if (iHandlePendingSeek == 0 && byteBuffer.limit() > 0) {
            outputSample(outputBuffer, byteBuffer.limit(), outputFrameHolder.timeUs, trackOutput);
        }
        return iHandlePendingSeek;
    }

    private static FlacBinarySearchSeeker outputSeekMap(FlacDecoderJni decoderJni, FlacStreamMetadata streamMetadata, long streamLength, ExtractorOutput output, FlacBinarySearchSeeker.OutputFrameHolder outputFrameHolder) {
        SeekMap unseekable;
        FlacBinarySearchSeeker flacBinarySearchSeeker = null;
        if (decoderJni.getSeekPoints(0L) != null) {
            unseekable = new FlacSeekMap(streamMetadata.getDurationUs(), decoderJni);
        } else if (streamLength != -1) {
            flacBinarySearchSeeker = new FlacBinarySearchSeeker(streamMetadata, decoderJni.getDecodePosition(), streamLength, decoderJni, outputFrameHolder);
            unseekable = flacBinarySearchSeeker.getSeekMap();
        } else {
            unseekable = new SeekMap.Unseekable(streamMetadata.getDurationUs());
        }
        output.seekMap(unseekable);
        return flacBinarySearchSeeker;
    }

    private static void outputFormat(FlacStreamMetadata streamMetadata, Metadata metadata, TrackOutput output) {
        output.format(Format.createAudioSampleFormat(null, "audio/raw", null, streamMetadata.getBitRate(), streamMetadata.getMaxDecodedFrameSize(), streamMetadata.channels, streamMetadata.sampleRate, Util.getPcmEncoding(streamMetadata.bitsPerSample), 0, 0, null, null, 0, null, metadata));
    }

    private static void outputSample(ParsableByteArray sampleData, int size, long timeUs, TrackOutput output) {
        sampleData.setPosition(0);
        output.sampleData(sampleData, size);
        output.sampleMetadata(timeUs, 1, size, 0, null);
    }

    private static final class FlacSeekMap implements SeekMap {
        private final FlacDecoderJni decoderJni;
        private final long durationUs;

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }

        public FlacSeekMap(long durationUs, FlacDecoderJni decoderJni) {
            this.durationUs = durationUs;
            this.decoderJni = decoderJni;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekMap.SeekPoints getSeekPoints(long timeUs) {
            SeekMap.SeekPoints seekPoints = this.decoderJni.getSeekPoints(timeUs);
            return seekPoints == null ? new SeekMap.SeekPoints(SeekPoint.START) : seekPoints;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }
    }
}
