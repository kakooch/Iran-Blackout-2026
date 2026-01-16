package com.google.android.exoplayer2.ext.flac;

import com.google.android.exoplayer2.ext.flac.FlacDecoderJni;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class FlacBinarySearchSeeker extends BinarySearchSeeker {
    private final FlacDecoderJni decoderJni;

    public static final class OutputFrameHolder {
        public final ByteBuffer byteBuffer;
        public long timeUs = 0;

        public OutputFrameHolder(ByteBuffer outputByteBuffer) {
            this.byteBuffer = outputByteBuffer;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlacBinarySearchSeeker(final FlacStreamMetadata streamMetadata, long firstFramePosition, long inputLength, FlacDecoderJni decoderJni, OutputFrameHolder outputFrameHolder) {
        super(new BinarySearchSeeker.SeekTimestampConverter() { // from class: com.google.android.exoplayer2.ext.flac.-$$Lambda$Mh5Ht-YbzWUwfTSM_pqVtKnjeQQ
            @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter
            public final long timeUsToTargetTime(long j) {
                return streamMetadata.getSampleNumber(j);
            }
        }, new FlacTimestampSeeker(decoderJni, outputFrameHolder), streamMetadata.getDurationUs(), 0L, streamMetadata.totalSamples, firstFramePosition, inputLength, streamMetadata.getApproxBytesPerFrame(), Math.max(6, streamMetadata.minFrameSize));
        streamMetadata.getClass();
        this.decoderJni = (FlacDecoderJni) Assertions.checkNotNull(decoderJni);
    }

    @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker
    protected void onSeekOperationFinished(boolean foundTargetFrame, long resultPosition) {
        if (foundTargetFrame) {
            return;
        }
        this.decoderJni.reset(resultPosition);
    }

    private static final class FlacTimestampSeeker implements BinarySearchSeeker.TimestampSeeker {
        private final FlacDecoderJni decoderJni;
        private final OutputFrameHolder outputFrameHolder;

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public /* bridge */ /* synthetic */ void onSeekFinished() {
            BinarySearchSeeker.TimestampSeeker.CC.$default$onSeekFinished(this);
        }

        private FlacTimestampSeeker(FlacDecoderJni decoderJni, OutputFrameHolder outputFrameHolder) {
            this.decoderJni = decoderJni;
            this.outputFrameHolder = outputFrameHolder;
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput input, long targetSampleIndex) throws Throwable {
            ByteBuffer byteBuffer = this.outputFrameHolder.byteBuffer;
            long position = input.getPosition();
            this.decoderJni.reset(position);
            try {
                this.decoderJni.decodeSampleWithBacktrackPosition(byteBuffer, position);
                if (byteBuffer.limit() == 0) {
                    return BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
                }
                long lastFrameFirstSampleIndex = this.decoderJni.getLastFrameFirstSampleIndex();
                long nextFrameFirstSampleIndex = this.decoderJni.getNextFrameFirstSampleIndex();
                long decodePosition = this.decoderJni.getDecodePosition();
                if (lastFrameFirstSampleIndex <= targetSampleIndex && nextFrameFirstSampleIndex > targetSampleIndex) {
                    this.outputFrameHolder.timeUs = this.decoderJni.getLastFrameTimestamp();
                    return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(input.getPosition());
                }
                if (nextFrameFirstSampleIndex <= targetSampleIndex) {
                    return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(nextFrameFirstSampleIndex, decodePosition);
                }
                return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(lastFrameFirstSampleIndex, position);
            } catch (FlacDecoderJni.FlacFrameDecodeException unused) {
                return BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
            }
        }
    }
}
