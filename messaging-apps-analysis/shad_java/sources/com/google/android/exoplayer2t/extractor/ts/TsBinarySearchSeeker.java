package com.google.android.exoplayer2t.extractor.ts;

import com.google.android.exoplayer2t.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2t.extractor.ExtractorInput;
import com.google.android.exoplayer2t.util.ParsableByteArray;
import com.google.android.exoplayer2t.util.TimestampAdjuster;
import com.google.android.exoplayer2t.util.Util;
import java.io.IOException;

/* loaded from: classes.dex */
final class TsBinarySearchSeeker extends BinarySearchSeeker {
    public TsBinarySearchSeeker(TimestampAdjuster timestampAdjuster, long j, long j2, int i) {
        super(new BinarySearchSeeker.DefaultSeekTimestampConverter(), new TsPcrSeeker(i, timestampAdjuster), j, 0L, j + 1, 0L, j2, 188L, 940);
    }

    private static final class TsPcrSeeker implements BinarySearchSeeker.TimestampSeeker {
        private final ParsableByteArray packetBuffer = new ParsableByteArray();
        private final int pcrPid;
        private final TimestampAdjuster pcrTimestampAdjuster;

        public TsPcrSeeker(int i, TimestampAdjuster timestampAdjuster) {
            this.pcrPid = i;
            this.pcrTimestampAdjuster = timestampAdjuster;
        }

        @Override // com.google.android.exoplayer2t.extractor.BinarySearchSeeker.TimestampSeeker
        public BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j) throws InterruptedException, IOException {
            long position = extractorInput.getPosition();
            int iMin = (int) Math.min(112800L, extractorInput.getLength() - position);
            this.packetBuffer.reset(iMin);
            extractorInput.peekFully(this.packetBuffer.data, 0, iMin);
            return searchForPcrValueInBuffer(this.packetBuffer, j, position);
        }

        private BinarySearchSeeker.TimestampSearchResult searchForPcrValueInBuffer(ParsableByteArray parsableByteArray, long j, long j2) {
            int iFindSyncBytePosition;
            int iFindSyncBytePosition2;
            int iLimit = parsableByteArray.limit();
            long j3 = -1;
            long j4 = -1;
            long j5 = -9223372036854775807L;
            while (parsableByteArray.bytesLeft() >= 188 && (iFindSyncBytePosition2 = (iFindSyncBytePosition = TsUtil.findSyncBytePosition(parsableByteArray.data, parsableByteArray.getPosition(), iLimit)) + 188) <= iLimit) {
                long pcrFromPacket = TsUtil.readPcrFromPacket(parsableByteArray, iFindSyncBytePosition, this.pcrPid);
                if (pcrFromPacket != -9223372036854775807L) {
                    long jAdjustTsTimestamp = this.pcrTimestampAdjuster.adjustTsTimestamp(pcrFromPacket);
                    if (jAdjustTsTimestamp > j) {
                        if (j5 == -9223372036854775807L) {
                            return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(jAdjustTsTimestamp, j2);
                        }
                        return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j2 + j4);
                    }
                    if (100000 + jAdjustTsTimestamp > j) {
                        return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j2 + iFindSyncBytePosition);
                    }
                    j4 = iFindSyncBytePosition;
                    j5 = jAdjustTsTimestamp;
                }
                parsableByteArray.setPosition(iFindSyncBytePosition2);
                j3 = iFindSyncBytePosition2;
            }
            if (j5 != -9223372036854775807L) {
                return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j5, j2 + j3);
            }
            return BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
        }

        @Override // com.google.android.exoplayer2t.extractor.BinarySearchSeeker.TimestampSeeker
        public void onSeekFinished() {
            this.packetBuffer.reset(Util.EMPTY_BYTE_ARRAY);
        }
    }
}
