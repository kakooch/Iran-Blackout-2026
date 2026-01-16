package com.google.android.exoplayer2t.extractor.ts;

import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2t.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2t.extractor.ExtractorInput;
import com.google.android.exoplayer2t.util.ParsableByteArray;
import com.google.android.exoplayer2t.util.TimestampAdjuster;
import com.google.android.exoplayer2t.util.Util;
import java.io.IOException;

/* loaded from: classes.dex */
final class PsBinarySearchSeeker extends BinarySearchSeeker {
    public PsBinarySearchSeeker(TimestampAdjuster timestampAdjuster, long j, long j2) {
        super(new BinarySearchSeeker.DefaultSeekTimestampConverter(), new PsScrSeeker(timestampAdjuster), j, 0L, j + 1, 0L, j2, 188L, CloseCodes.NORMAL_CLOSURE);
    }

    private static final class PsScrSeeker implements BinarySearchSeeker.TimestampSeeker {
        private final ParsableByteArray packetBuffer;
        private final TimestampAdjuster scrTimestampAdjuster;

        private PsScrSeeker(TimestampAdjuster timestampAdjuster) {
            this.scrTimestampAdjuster = timestampAdjuster;
            this.packetBuffer = new ParsableByteArray();
        }

        @Override // com.google.android.exoplayer2t.extractor.BinarySearchSeeker.TimestampSeeker
        public BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j) throws InterruptedException, IOException {
            long position = extractorInput.getPosition();
            int iMin = (int) Math.min(20000L, extractorInput.getLength() - position);
            this.packetBuffer.reset(iMin);
            extractorInput.peekFully(this.packetBuffer.data, 0, iMin);
            return searchForScrValueInBuffer(this.packetBuffer, j, position);
        }

        @Override // com.google.android.exoplayer2t.extractor.BinarySearchSeeker.TimestampSeeker
        public void onSeekFinished() {
            this.packetBuffer.reset(Util.EMPTY_BYTE_ARRAY);
        }

        private BinarySearchSeeker.TimestampSearchResult searchForScrValueInBuffer(ParsableByteArray parsableByteArray, long j, long j2) {
            int position = -1;
            long j3 = -9223372036854775807L;
            int position2 = -1;
            while (parsableByteArray.bytesLeft() >= 4) {
                if (PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray.data, parsableByteArray.getPosition()) != 442) {
                    parsableByteArray.skipBytes(1);
                } else {
                    parsableByteArray.skipBytes(4);
                    long scrValueFromPack = PsDurationReader.readScrValueFromPack(parsableByteArray);
                    if (scrValueFromPack != -9223372036854775807L) {
                        long jAdjustTsTimestamp = this.scrTimestampAdjuster.adjustTsTimestamp(scrValueFromPack);
                        if (jAdjustTsTimestamp > j) {
                            if (j3 == -9223372036854775807L) {
                                return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(jAdjustTsTimestamp, j2);
                            }
                            return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j2 + position2);
                        }
                        if (100000 + jAdjustTsTimestamp > j) {
                            return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j2 + parsableByteArray.getPosition());
                        }
                        position2 = parsableByteArray.getPosition();
                        j3 = jAdjustTsTimestamp;
                    }
                    skipToEndOfCurrentPack(parsableByteArray);
                    position = parsableByteArray.getPosition();
                }
            }
            if (j3 != -9223372036854775807L) {
                return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j3, j2 + position);
            }
            return BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
        }

        private static void skipToEndOfCurrentPack(ParsableByteArray parsableByteArray) {
            int iPeekIntAtPosition;
            int iLimit = parsableByteArray.limit();
            if (parsableByteArray.bytesLeft() < 10) {
                parsableByteArray.setPosition(iLimit);
                return;
            }
            parsableByteArray.skipBytes(9);
            int unsignedByte = parsableByteArray.readUnsignedByte() & 7;
            if (parsableByteArray.bytesLeft() < unsignedByte) {
                parsableByteArray.setPosition(iLimit);
                return;
            }
            parsableByteArray.skipBytes(unsignedByte);
            if (parsableByteArray.bytesLeft() >= 4) {
                if (PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray.data, parsableByteArray.getPosition()) == 443) {
                    parsableByteArray.skipBytes(4);
                    int unsignedShort = parsableByteArray.readUnsignedShort();
                    if (parsableByteArray.bytesLeft() < unsignedShort) {
                        parsableByteArray.setPosition(iLimit);
                        return;
                    }
                    parsableByteArray.skipBytes(unsignedShort);
                }
                while (parsableByteArray.bytesLeft() >= 4 && (iPeekIntAtPosition = PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray.data, parsableByteArray.getPosition())) != 442 && iPeekIntAtPosition != 441 && (iPeekIntAtPosition >>> 8) == 1) {
                    parsableByteArray.skipBytes(4);
                    if (parsableByteArray.bytesLeft() < 2) {
                        parsableByteArray.setPosition(iLimit);
                        return;
                    }
                    parsableByteArray.setPosition(Math.min(parsableByteArray.limit(), parsableByteArray.getPosition() + parsableByteArray.readUnsignedShort()));
                }
                return;
            }
            parsableByteArray.setPosition(iLimit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int peekIntAtPosition(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
