package com.google.android.exoplayer2.extractor.flac;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import java.io.IOException;

/* loaded from: classes.dex */
final class FlacBinarySearchSeeker extends BinarySearchSeeker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlacBinarySearchSeeker(final FlacStreamMetadata flacStreamMetadata, int frameStartMarker, long firstFramePosition, long inputLength) {
        super(new BinarySearchSeeker.SeekTimestampConverter() { // from class: com.google.android.exoplayer2.extractor.flac.-$$Lambda$Mh5Ht-YbzWUwfTSM_pqVtKnjeQQ
            @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter
            public final long timeUsToTargetTime(long j) {
                return flacStreamMetadata.getSampleNumber(j);
            }
        }, new FlacTimestampSeeker(flacStreamMetadata, frameStartMarker), flacStreamMetadata.getDurationUs(), 0L, flacStreamMetadata.totalSamples, firstFramePosition, inputLength, flacStreamMetadata.getApproxBytesPerFrame(), Math.max(6, flacStreamMetadata.minFrameSize));
        flacStreamMetadata.getClass();
    }

    private static final class FlacTimestampSeeker implements BinarySearchSeeker.TimestampSeeker {
        private final FlacStreamMetadata flacStreamMetadata;
        private final int frameStartMarker;
        private final FlacFrameReader.SampleNumberHolder sampleNumberHolder;

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public /* synthetic */ void onSeekFinished() {
            BinarySearchSeeker.TimestampSeeker.CC.$default$onSeekFinished(this);
        }

        private FlacTimestampSeeker(FlacStreamMetadata flacStreamMetadata, int frameStartMarker) {
            this.flacStreamMetadata = flacStreamMetadata;
            this.frameStartMarker = frameStartMarker;
            this.sampleNumberHolder = new FlacFrameReader.SampleNumberHolder();
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput input, long targetSampleNumber) throws InterruptedException, IOException {
            long position = input.getPosition();
            long jFindNextFrame = findNextFrame(input);
            long peekPosition = input.getPeekPosition();
            input.advancePeekPosition(Math.max(6, this.flacStreamMetadata.minFrameSize));
            long jFindNextFrame2 = findNextFrame(input);
            long peekPosition2 = input.getPeekPosition();
            if (jFindNextFrame <= targetSampleNumber && jFindNextFrame2 > targetSampleNumber) {
                return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(peekPosition);
            }
            if (jFindNextFrame2 <= targetSampleNumber) {
                return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(jFindNextFrame2, peekPosition2);
            }
            return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(jFindNextFrame, position);
        }

        private long findNextFrame(ExtractorInput input) throws InterruptedException, IOException {
            while (input.getPeekPosition() < input.getLength() - 6 && !FlacFrameReader.checkFrameHeaderFromPeek(input, this.flacStreamMetadata, this.frameStartMarker, this.sampleNumberHolder)) {
                input.advancePeekPosition(1);
            }
            if (input.getPeekPosition() >= input.getLength() - 6) {
                input.advancePeekPosition((int) (input.getLength() - input.getPeekPosition()));
                return this.flacStreamMetadata.totalSamples;
            }
            return this.sampleNumberHolder.sampleNumber;
        }
    }
}
