package com.google.android.exoplayer2t.extractor.ts;

import com.google.android.exoplayer2t.extractor.ExtractorInput;
import com.google.android.exoplayer2t.extractor.PositionHolder;
import com.google.android.exoplayer2t.util.ParsableByteArray;
import com.google.android.exoplayer2t.util.TimestampAdjuster;
import com.google.android.exoplayer2t.util.Util;
import java.io.IOException;

/* loaded from: classes.dex */
final class TsDurationReader {
    private boolean isDurationRead;
    private boolean isFirstPcrValueRead;
    private boolean isLastPcrValueRead;
    private final TimestampAdjuster pcrTimestampAdjuster = new TimestampAdjuster(0);
    private long firstPcrValue = -9223372036854775807L;
    private long lastPcrValue = -9223372036854775807L;
    private long durationUs = -9223372036854775807L;
    private final ParsableByteArray packetBuffer = new ParsableByteArray();

    TsDurationReader() {
    }

    public boolean isDurationReadFinished() {
        return this.isDurationRead;
    }

    public int readDuration(ExtractorInput extractorInput, PositionHolder positionHolder, int i) throws InterruptedException, IOException {
        if (i <= 0) {
            return finishReadDuration(extractorInput);
        }
        if (!this.isLastPcrValueRead) {
            return readLastPcrValue(extractorInput, positionHolder, i);
        }
        if (this.lastPcrValue == -9223372036854775807L) {
            return finishReadDuration(extractorInput);
        }
        if (!this.isFirstPcrValueRead) {
            return readFirstPcrValue(extractorInput, positionHolder, i);
        }
        long j = this.firstPcrValue;
        if (j == -9223372036854775807L) {
            return finishReadDuration(extractorInput);
        }
        this.durationUs = this.pcrTimestampAdjuster.adjustTsTimestamp(this.lastPcrValue) - this.pcrTimestampAdjuster.adjustTsTimestamp(j);
        return finishReadDuration(extractorInput);
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public TimestampAdjuster getPcrTimestampAdjuster() {
        return this.pcrTimestampAdjuster;
    }

    private int finishReadDuration(ExtractorInput extractorInput) {
        this.packetBuffer.reset(Util.EMPTY_BYTE_ARRAY);
        this.isDurationRead = true;
        extractorInput.resetPeekPosition();
        return 0;
    }

    private int readFirstPcrValue(ExtractorInput extractorInput, PositionHolder positionHolder, int i) throws InterruptedException, IOException {
        int iMin = (int) Math.min(112800L, extractorInput.getLength());
        long j = 0;
        if (extractorInput.getPosition() != j) {
            positionHolder.position = j;
            return 1;
        }
        this.packetBuffer.reset(iMin);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.packetBuffer.data, 0, iMin);
        this.firstPcrValue = readFirstPcrValueFromBuffer(this.packetBuffer, i);
        this.isFirstPcrValueRead = true;
        return 0;
    }

    private long readFirstPcrValueFromBuffer(ParsableByteArray parsableByteArray, int i) {
        int iLimit = parsableByteArray.limit();
        for (int position = parsableByteArray.getPosition(); position < iLimit; position++) {
            if (parsableByteArray.data[position] == 71) {
                long pcrFromPacket = TsUtil.readPcrFromPacket(parsableByteArray, position, i);
                if (pcrFromPacket != -9223372036854775807L) {
                    return pcrFromPacket;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int readLastPcrValue(ExtractorInput extractorInput, PositionHolder positionHolder, int i) throws InterruptedException, IOException {
        long length = extractorInput.getLength();
        int iMin = (int) Math.min(112800L, length);
        long j = length - iMin;
        if (extractorInput.getPosition() != j) {
            positionHolder.position = j;
            return 1;
        }
        this.packetBuffer.reset(iMin);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.packetBuffer.data, 0, iMin);
        this.lastPcrValue = readLastPcrValueFromBuffer(this.packetBuffer, i);
        this.isLastPcrValueRead = true;
        return 0;
    }

    private long readLastPcrValueFromBuffer(ParsableByteArray parsableByteArray, int i) {
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        while (true) {
            iLimit--;
            if (iLimit < position) {
                return -9223372036854775807L;
            }
            if (parsableByteArray.data[iLimit] == 71) {
                long pcrFromPacket = TsUtil.readPcrFromPacket(parsableByteArray, iLimit, i);
                if (pcrFromPacket != -9223372036854775807L) {
                    return pcrFromPacket;
                }
            }
        }
    }
}
